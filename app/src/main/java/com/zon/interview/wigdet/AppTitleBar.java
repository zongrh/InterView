package com.zon.interview.wigdet;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.zon.interview.R;

/**
 * AppTitleBar   封装的一个顶部Title
 */
public class AppTitleBar extends RelativeLayout {
    public AppTitleBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs);
//        引用自定义控件的属性  不添加的话 则是系统的属性
//        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.CustomTextView);
//        String str = ta.getString(R.styleable.CustomTextView_text);
//        init(context, attrs);
    }
    private TextView mBack, mTitle, mAction,mDefute_Text;
    private ImageView mDefute_Icon;
    private void init(Context context, AttributeSet attrs) {
        LayoutInflater.from(context).inflate(R.layout.app_title_bar, this);
        mBack = (TextView) findViewById(R.id.app_title_back);
        mAction = (TextView) findViewById(R.id.app_title_action);
        mTitle = (TextView) findViewById(R.id.app_title);
        mDefute_Icon = findViewById(R.id.app_title_defute_icon);
        mDefute_Text= (TextView) findViewById(R.id.app_title_defute_text);
    }

    public void setBack(String back) {
        this.mBack.setText(back);
    }

    public void setAction(String action) {
        this.mAction.setText(action);
    }

    public void setTitle(String title) {
        this.mTitle.setText(title);
    }

    public TextView getAction() {
        return mAction;
    }

    public TextView getBack() {
        return mBack;
    }

    public TextView getTitle() {
        return mTitle;
    }

    public TextView getDefute_Text() {
        return mDefute_Text;
    }

    public void setDefute_Text(TextView defute_Text) {
        mDefute_Text = defute_Text;
    }

    public ImageView getDefute_Icon() {
        return mDefute_Icon;
    }

    public void setDefute_Icon(ImageView defute_Icon) {
        mDefute_Icon = defute_Icon;
    }

    public void setBackGone(){
//        GONE INVISABLE 都代表隐藏   gone 隐藏后不占位置 INVISABLE 仍占内存
//          VISIBLE  显示
        this.mBack.setVisibility(GONE);
    }


}
