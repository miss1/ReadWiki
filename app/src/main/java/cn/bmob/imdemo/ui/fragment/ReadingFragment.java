package cn.bmob.imdemo.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import cn.bmob.imdemo.R;
import cn.bmob.imdemo.base.ParentWithNaviFragment;

/**设置
 * @author :smile
 * @project:SetFragment
 * @date :2016-01-25-18:23
 */
public class ReadingFragment extends ParentWithNaviFragment {

    @Override
    protected String title() {
        return "阅读";
    }

    public static ReadingFragment newInstance() {
        ReadingFragment fragment = new ReadingFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public ReadingFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView= inflater.inflate(R.layout.fragment_reading,container, false);
        initNaviView();
        ButterKnife.bind(this, rootView);
        return rootView;
    }

}
