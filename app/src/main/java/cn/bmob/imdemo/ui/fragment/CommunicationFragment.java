package cn.bmob.imdemo.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import cn.bmob.imdemo.R;
import cn.bmob.imdemo.base.ParentWithNaviFragment;

/**
 * Created by Administrator on 2016/5/18.
 */
public class CommunicationFragment extends ParentWithNaviFragment {

    @Override
    protected String title() {
        return "广场";
    }

    public static CommunicationFragment newInstance() {
        Bundle args = new Bundle();
        CommunicationFragment fragment = new CommunicationFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public CommunicationFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_communication, container, false);
        initNaviView();
        ButterKnife.bind(this, rootView);
        return rootView;
    }
}
