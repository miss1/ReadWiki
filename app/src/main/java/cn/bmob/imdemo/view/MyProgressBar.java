package cn.bmob.imdemo.view;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

/**
 * Created by Administrator on 2016/5/23.
 */
public class MyProgressBar {

    public ProgressBar createMyProgressBar(Activity activity, Drawable drawable){
        FrameLayout rootContainer = (FrameLayout) activity.findViewById(android.R.id.content);
        FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.gravity = Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL;

        ProgressBar progressBar = new ProgressBar(activity);
        progressBar.setVisibility(View.GONE);
        progressBar.setLayoutParams(lp);

        if (drawable != null){
            progressBar.setIndeterminateDrawable(drawable);
        }

        rootContainer.addView(progressBar);
        return progressBar;
    }
}
