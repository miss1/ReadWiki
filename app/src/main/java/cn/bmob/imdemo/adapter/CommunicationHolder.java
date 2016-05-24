package cn.bmob.imdemo.adapter;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.Bind;
import cn.bmob.imdemo.R;
import cn.bmob.imdemo.bean.Post;
import cn.bmob.imdemo.bean.User;

/**
 * Created by Administrator on 2016/5/24.
 */
public class CommunicationHolder extends BaseViewHolder {

    @Bind(R.id.commu_itemImage)
    public ImageView commu_itemImage;

    @Bind(R.id.commu_itemAuthor)
    public TextView commu_itemAuthor;

    @Bind(R.id.commu_itemTime)
    public TextView commu_itemTime;

    @Bind(R.id.commu_itemContent)
    public TextView commu_itemContent;

    @Bind(R.id.commu_itemHead)
    public TextView commu_itemHead;

    public CommunicationHolder(Context context, ViewGroup root, OnRecyclerViewListener listener) {
        super(context, root, R.layout.item_communication, listener);
    }

    @Override
    public void bindData(Object o) {
        Post post = (Post) o;
        User user = post.getUser();
        //帖子发布者头像
        commu_itemImage.setImageResource(R.mipmap.head);
        //帖子的发布者
        commu_itemAuthor.setText(user.getUsername());
        //帖子的发布时间
        commu_itemTime.setText(post.getCreatedAt());
        //帖子的标题
        commu_itemHead.setText(post.getTitle());
        //帖子的内容
        commu_itemContent.setText(post.getContent());
    }
}
