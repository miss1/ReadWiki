package cn.bmob.imdemo.ui.fragment;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.bmob.imdemo.R;
import cn.bmob.imdemo.adapter.CommunicationAdapter;
import cn.bmob.imdemo.adapter.OnRecyclerViewListener;
import cn.bmob.imdemo.base.ParentWithNaviActivity;
import cn.bmob.imdemo.base.ParentWithNaviFragment;
import cn.bmob.imdemo.bean.Post;
import cn.bmob.imdemo.ui.PostCommentActivity;
import cn.bmob.imdemo.ui.PostWriteActivity;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.FindListener;

/**
 * Created by Administrator on 2016/5/18.
 */
public class CommunicationFragment extends ParentWithNaviFragment {

    @Bind(R.id.communication_refresh)
    SwipeRefreshLayout communication_refresh;

    @Bind(R.id.communication_recycleview)
    RecyclerView communication_recycleview;

    CommunicationAdapter adapter;
    LinearLayoutManager layoutManager;

    @Override
    protected String title() {
        return "广场";
    }

    @Override
    public Object right() {
        return R.drawable.base_action_bar_add_bg_selector;
    }

    @Override
    public ParentWithNaviActivity.ToolBarListener setToolBarListener() {
        return new ParentWithNaviActivity.ToolBarListener() {
            @Override
            public void clickLeft() {

            }

            @Override
            public void clickRight() {
                startActivity(PostWriteActivity.class, null);
            }
        };
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_communication, container, false);
        initNaviView();
        ButterKnife.bind(this, rootView);
        adapter = new CommunicationAdapter();
        communication_recycleview.setAdapter(adapter);
        layoutManager = new LinearLayoutManager(getActivity());
        communication_recycleview.setLayoutManager(layoutManager);
        communication_refresh.setEnabled(true);
        setListener();
        return rootView;
    }

    private void setListener() {
        rootView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                rootView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                communication_refresh.setRefreshing(true);
                query();
            }
        });
        communication_refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                query();
            }
        });
        adapter.setOnRecyclerViewListener(new OnRecyclerViewListener() {
            @Override
            public void onItemClick(int position) {
                startActivity(PostCommentActivity.class, null);
            }

            @Override
            public boolean onItemLongClick(int position) {
                return false;
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        communication_refresh.setRefreshing(true);
        query();
    }

    //查询所有帖子
    private void query() {
        BmobQuery<Post> query = new BmobQuery<>();
        query.include("user");
        query.order("-updatedAt");
        query.findObjects(getActivity(), new FindListener<Post>() {
            @Override
            public void onSuccess(List<Post> list) {
                adapter.bindDatas(list);
                adapter.notifyDataSetChanged();
                communication_refresh.setRefreshing(false);
            }

            @Override
            public void onError(int i, String s) {
                adapter.bindDatas(null);
                adapter.notifyDataSetChanged();
                communication_refresh.setRefreshing(false);
                toast(s);
            }
        });
    }

}
