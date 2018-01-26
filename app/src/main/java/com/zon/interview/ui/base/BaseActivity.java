package com.zon.interview.ui.base;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import butterknife.ButterKnife;
import com.zon.interview.R;
import com.zon.interview.utils.StatusBarUtil;

public abstract class BaseActivity extends AppCompatActivity {
    //    上下文
    protected Context mContext;
    //    TAG
    protected String TAG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStatusBar();
        init();
        initData();
        initView();
    }

    protected void setStatusBar() {
        StatusBarUtil.setColor(this, getResources().getColor(R.color.background_default));
    }

    protected void init() {
        setContentView(getLayoutId());
        mContext = this;
        ButterKnife.bind(this);
        TAG = getClass().getName();
    }

    /**
     * @return   要加载的布局
     */
    protected abstract int getLayoutId();

    /**
     * 初始化数据
     */
    protected abstract void initData();

    /**
     * 初始化View
     */
    protected abstract void initView();


    public void showFragment(Class<? extends BaseFragment> toShowFragment,
                             String fragmentTag,
                             Bundle bundle,
                             boolean addToBackstack) {
        Log.d(TAG,TAG);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
//        fragment切换动画
        transaction.setCustomAnimations(R.anim.fragment_enter, R.anim.fragment_exit,
                R.anim.fragment_pop_enter, R.anim.fragment_pop_exit);
        try {
//            .newInstance()
            Fragment fragment = toShowFragment.newInstance();
            if (bundle != null) {
                fragment.setArguments(bundle);
            }
            transaction.add(android.R.id.content, fragment, fragmentTag);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (addToBackstack) {
            transaction.addToBackStack(fragmentTag);
        }
        transaction.commit();
    }
}
