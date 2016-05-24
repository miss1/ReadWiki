package cn.bmob.imdemo.ui;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.OnClick;
import cn.bmob.imdemo.R;
import cn.bmob.imdemo.base.BaseActivity;
import cn.bmob.imdemo.bean.Post;
import cn.bmob.imdemo.bean.User;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.listener.SaveListener;

/**
 * Created by Administrator on 2016/5/19.
 */
public class PostWriteActivity extends BaseActivity{

    @Bind(R.id.write_edhead)
    EditText write_edhead;

    @Bind(R.id.write_edcontent)
    EditText write_edcontent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_write);
        progressBar = myProgressBar.createMyProgressBar(this, null);
    }

    @OnClick(R.id.write_buttonok)          //发表帖子
    public void reportPost(View view){
        String title = write_edhead.getText().toString();
        String content = write_edcontent.getText().toString();
        if (!TextUtils.isEmpty(content)){
            progressBar.setVisibility(View.VISIBLE);
            User user = BmobUser.getCurrentUser(this, User.class);
            //创建帖子信息
            Post post = new Post();
            if (!TextUtils.isEmpty(title)){
                post.setTitle(title);
            }
            post.setContent(content);
            post.setUser(user);

            post.save(this, new SaveListener() {
                @Override
                public void onSuccess() {
                    toast("帖子发表成功");
                    progressBar.setVisibility(View.GONE);
                    finish();
                }

                @Override
                public void onFailure(int i, String s) {
                    toast(s);
                    progressBar.setVisibility(View.GONE);
                }
            });
        }else {
            toast("帖子内容不能为空");
        }
    }

    @OnClick(R.id.write_imh)
    public void cancelReport(View view){
        finish();
    }
}
