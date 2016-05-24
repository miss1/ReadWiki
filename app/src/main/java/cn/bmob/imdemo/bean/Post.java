package cn.bmob.imdemo.bean;

import cn.bmob.v3.BmobObject;

/**
 * Created by Administrator on 2016/5/19.
 */
public class Post extends BmobObject{

    private String title;     //帖子标题
    private String content;     //帖子内容
    private User user;       //帖子的发布者

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
