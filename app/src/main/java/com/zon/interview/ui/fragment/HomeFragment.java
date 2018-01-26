package com.zon.interview.ui.fragment;

import android.view.View;
import com.zon.interview.R;
import com.zon.interview.ui.base.BaseFragment;


public class HomeFragment extends BaseFragment {

    @Override
    protected void initData() {

    }

    @Override
    protected int getInflaterLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView(View view) {
        mTitleBar.getTitle().setVisibility(View.GONE);
        mTitleBar.getDefute_Icon().setVisibility(View.VISIBLE);
        mTitleBar.getDefute_Text().setVisibility(View.VISIBLE);
        mTitleBar.getDefute_Text().setText("首页");
        mTitleBar.getAction().setVisibility(View.VISIBLE);

    }
}
