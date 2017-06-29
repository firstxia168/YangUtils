package com.yang.library;

import android.os.Bundle;
import android.os.Handler;

import com.ymz.baselibrary.ABaseFragment;
import com.ymz.baselibrary.utils.UIUtils;

/**
 * 创建人：$ gyymz1993
 * 创建时间：2017/6/29 9:18
 */

public class MainFragment extends ABaseFragment {


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main;
    }

    @Override
    protected void afterCreate(Bundle savedInstanceState) {

        UIUtils.getHandler().postDelayed(new Runnable() {
            @Override
            public void run() {
                showLoadingView();
            }
        }, 0);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                showEmptyView();
            }
        }, 2000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                showProgressDialogWithText("正在登录");
            }
        }, 4000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                dismissProgressDialog();
                showErrorView();
            }
        }, 6000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                showProgressSuccess("加载成功");
            }
        }, 8000);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                showProgressFail("加载失败");
            }
        }, 1000);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                showContentView();
            }
        }, 12000);

    }
}
