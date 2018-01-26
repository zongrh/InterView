package com.zon.interview.ui.base;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.zon.interview.R;
import com.zon.interview.wigdet.AppTitleBar;

public abstract class BaseFragment extends Fragment {
    protected AppTitleBar mTitleBar;
    protected String RECEIVER = "receiver";
    protected Context mContext;
    protected BaseActivity mBaseActivity;
    private Unbinder mUnbinder;
    protected Bundle mBundle;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(getInflaterLayoutId(), container, false);
    }

    @SuppressLint("NewApi")
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //        防止点击穿透，底层fragment响应顶层点击事件
        view.setClickable(true);
        //共享文件的创和获取共享文件
        mContext = getContext();
        mBaseActivity = (BaseActivity) getActivity();
//        填充当前布局
        mUnbinder = ButterKnife.bind(this, view);
//        添加TitleBar
        mTitleBar = view.findViewById(R.id.apptitle_root);
        initData();
        initView(view);
        setBackListener();
    }

    protected abstract void initData();

    protected abstract int getInflaterLayoutId();

    protected abstract void initView(View view);

    protected void setBackListener() {
        if (mTitleBar != null) {
            mTitleBar.getBack().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    popBackStack();
                }
            });
        }
    }

    protected void popBackStack() {
        if (isDetached() || isRemoving() || getFragmentManager() == null) {
            return;
        }
        if (isResumed()) {
            getFragmentManager().popBackStackImmediate();
        }
    }


}
