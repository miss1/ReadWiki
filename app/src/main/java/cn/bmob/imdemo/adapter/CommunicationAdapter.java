package cn.bmob.imdemo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.imdemo.bean.Post;

/**
 * Created by Administrator on 2016/5/24.
 */
public class CommunicationAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Post> posts = new ArrayList<>();

    private OnRecyclerViewListener onRecyclerViewListener;

    public CommunicationAdapter() {
    }

    public void bindDatas(List<Post> list){
        posts.clear();
        if (null != list){
            posts.addAll(list);
        }
    }

    public Post getItem(int position){
        return posts.get(position);
    }

    public void setOnRecyclerViewListener(OnRecyclerViewListener onRecyclerViewListener) {
        this.onRecyclerViewListener = onRecyclerViewListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CommunicationHolder(parent.getContext(), parent, onRecyclerViewListener);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((BaseViewHolder)holder).bindData(getItem(position));
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }
}
