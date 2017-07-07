package com.yang.library;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.ymz.baselibrary.ABaseActivity;
import com.ymz.baselibrary.utils.T_;
import com.ymz.baselibrary.widget.NavigationBarView;

import butterknife.BindView;

@SuppressLint("Registered")
public class MainActivity extends ABaseActivity {

    @BindView(R.id.id_fragment_container)
    RelativeLayout idFragmentContainer;
    @BindView(R.id.id_navigationbar)
    NavigationBarView idNavigationbar;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void afterCreate(Bundle savedInstanceState) {

        idNavigationbar.setTitleText("测试测试");
        setTitleText("测试 TopBar");
        setTopLeftButton(R.drawable.ic_load_fail_black, v -> T_.showToastReal("测试"));

        MainFragment mainFragment = new MainFragment();
        addFragment(mainFragment);
    }

    @Override
    public int getFragmentContentId() {
        return R.id.id_fragment_container;
    }

}
