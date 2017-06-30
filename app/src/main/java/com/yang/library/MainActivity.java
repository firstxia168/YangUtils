package com.yang.library;


import android.os.Bundle;
import android.view.View;

import com.ymz.baselibrary.ABaseActivity;
import com.ymz.baselibrary.utils.T_;

public class MainActivity extends ABaseActivity {

    private static final String TAG = "MainActivity";


    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void afterCreate(Bundle savedInstanceState) {

        setTitleText("测试 TopBar");
        setTopLeftButton(R.drawable.ic_load_fail_black, new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                T_.showToastReal("测试");
            }
        });

       // setTopLeftButton(R.drawable.ic_load_fail_black);
        //showLoadingView();
//        UIUtils.getHandler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                showLoadingView();
//            }
//        }, 0);
//
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                showEmptyView();
//            }
//        }, 2000);
//
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                showProgressFail("正在登录");
//            }
//        }, 2000);
//
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                showErrorView();
//            }
//        }, 6000);
//
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                showProgressSuccess("加载成功");
//            }
//        }, 8000);
//
//
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                showProgressFail("加载失败");
//            }
//        }, 1000);
//
//
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                showContentView();
//            }
//        }, 12000);

        MainFragment  mainFragment=new MainFragment();
        addFragment(mainFragment);
    }

    @Override
    public int getFragmentContentId() {
        return R.id.id_fragment_container;
    }


}
