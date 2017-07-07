package com.yang.library;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.ymz.baselibrary.ABaseActivity;

/**
 * 创建人：$ gyymz1993
 * 创建时间：2017/7/7 11:47
 */

@SuppressLint("Registered")
public class ScrollMainActivity extends ABaseActivity {
    @Override
    protected int getLayoutId() {
        return R.layout.scroll_main;
    }

    @Override
    protected void afterCreate(Bundle bundle) {

    }

    @Override
    public int getFragmentContentId() {
        return 0;
    }
}
