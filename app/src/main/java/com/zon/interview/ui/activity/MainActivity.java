package com.zon.interview.ui.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import butterknife.BindView;
import butterknife.OnClick;
import com.zon.interview.R;
import com.zon.interview.constant.FragmentTag;
import com.zon.interview.ui.base.BaseActivity;
import com.zon.interview.ui.fragment.HomeFragment;
import com.zon.interview.ui.fragment.LineFragment;
import com.zon.interview.ui.fragment.MineFragment;

public class MainActivity extends BaseActivity {
    private HomeFragment mHomeFragment;
    private LineFragment mLineFragment;
    private MineFragment mMineFragment;

    private Fragment mFragment;
    private FragmentManager mFragmentManager;
    private FragmentTransaction mFragmentTransaction;
    @BindView(R.id.Rlay_home)
    View Rlay_home;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {

    }

    /**
     * 初始化View
     */
    @Override
    protected void initView() {
        mFragmentManager = getSupportFragmentManager();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mHomeFragment = new HomeFragment();
        mFragment = mHomeFragment;
        mFragmentTransaction.add(R.id.myFLayout, mHomeFragment, FragmentTag.MAIN_HOME);
        mFragmentTransaction.commit();
        Rlay_home.setSelected(true);
    }

    @OnClick({R.id.Rlay_home, R.id.Rlay_line, R.id.Rlay_mine})
    protected void tab_select(View view) {
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.hide(mFragment);
        change(view);
        switch (view.getId()) {
            case R.id.Rlay_home:
                if (mHomeFragment == null) {
                    mHomeFragment = new HomeFragment();
                    mFragmentTransaction.add(R.id.myFLayout, mHomeFragment, FragmentTag.MAIN_HOME);
                } else {
                    mFragmentTransaction.show(mHomeFragment);
                }
                mFragment = mHomeFragment;
                break;
            case R.id.Rlay_line:
                if (mLineFragment == null) {
                    mLineFragment = new LineFragment();
                    mFragmentTransaction.add(R.id.myFLayout, mLineFragment, FragmentTag.MAIN_LINE);
                } else {
                    mFragmentTransaction.show(mLineFragment);
                }
                mFragment = mLineFragment;
                break;
            case R.id.Rlay_mine:
                if (mMineFragment == null) {
                    mMineFragment = new MineFragment();
                    mFragmentTransaction.add(R.id.myFLayout, mMineFragment, FragmentTag.MAIN_MINE);
                } else {
                    mFragmentTransaction.show(mMineFragment);
                }
                mFragment = mMineFragment;
                break;
        }
        mFragmentTransaction.commit();
    }

    public void change(View view) {
        if (Rlay_home != null) {
            Rlay_home.setSelected(false);
        }
        view.setSelected(true);
        Rlay_home = view;
    }

}
