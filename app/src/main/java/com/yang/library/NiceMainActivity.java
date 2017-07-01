package com.yang.library;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.ymz.baselibrary.ABaseActivity;
import com.ymz.baselibrary.utils.L_;
import com.ys.uilibrary.MultiImageView;
import com.ys.uilibrary.base.BaseRecyclerAdapter;
import com.ys.uilibrary.base.BaseRecyclerHolder;
import com.ys.uilibrary.rv.LazyLoadRecycleView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 创建人：$ gyymz1993
 * 创建时间：2017/7/1 14:56
 */

public class NiceMainActivity extends ABaseActivity {


    public static final String Http = "https://app.zizi.com.cn";
    @BindView(R.id.id_recycleview)
    LazyLoadRecycleView idRecycleview;


    @Override
    protected int getLayoutId() {
        return R.layout.nice_main;
    }

    @Override
    protected void afterCreate(Bundle savedInstanceState) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        List<List<MultiImageView.PhotoInfo>> mdata = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            List<MultiImageView.PhotoInfo> list = new ArrayList<>();
            for (int j = 0; j < i+1 ; j++) {
                MultiImageView.PhotoInfo photoInfo = new MultiImageView.PhotoInfo();
                photoInfo.setUrl(Http + "/images?uuid=bf9b37d8-f1c0-4fdc-9906-3e4ee034c745");
                list.add(photoInfo);
            }
            mdata.add(list);
        }
        NiceViewAdapter niceViewAdapter = new NiceViewAdapter(mdata, R.layout.itme_nice);
        idRecycleview.setLayoutManager(linearLayoutManager);
        idRecycleview.setAdapter(niceViewAdapter);
    }


    public class NiceViewAdapter extends BaseRecyclerAdapter<List<MultiImageView.PhotoInfo>> {

        public NiceViewAdapter(List<List<MultiImageView.PhotoInfo>> datas, int itemLayoutId) {
            super(datas, itemLayoutId);
        }

        @Override
        protected void convert(BaseRecyclerHolder holder, List<MultiImageView.PhotoInfo> item, int position) {
            MultiImageView multiImageView = holder.getView(R.id.multiImagView);
            multiImageView.setList(item);
        }
    }

    @Override
    public int getFragmentContentId() {
        return 0;
    }

}
