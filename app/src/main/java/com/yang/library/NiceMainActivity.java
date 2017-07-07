package com.yang.library;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.ymz.baselibrary.ABaseActivity;
import com.ys.uilibrary.MultiImageView;
import com.ys.uilibrary.MultiImageView.PhotoInfo;
import com.ys.uilibrary.base.BaseRecyclerAdapter;
import com.ys.uilibrary.base.BaseRecyclerHolder;
import com.ys.uilibrary.rv.LazyLoadRecycleView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 创建人：$ gyymz1993
 * 创建时间：2017/7/1 14:56
 */

@SuppressLint("Registered")
public class NiceMainActivity extends ABaseActivity {


    public static final String Http = "https://app.zizi.com.cn";
    @BindView(R.id.id_recycleview)
    LazyLoadRecycleView idRecycleview;

    @Override
    protected int getLayoutId() {
        return R.layout.nice_main;
    }

    public List<PhotoInfo> initData(){
        PhotoInfo p1 = new PhotoInfo();
        p1.url = "http://f.hiphotos.baidu.com/image/pic/item/faf2b2119313b07e97f760d908d7912396dd8c9c.jpg";
        p1.w = 640;
        p1.h = 792;

        PhotoInfo p2 = new PhotoInfo();
        p2.url = "http://g.hiphotos.baidu.com/image/pic/item/4b90f603738da977c76ab6fab451f8198718e39e.jpg";
        p2.w = 640;
        p2.h = 792;

        PhotoInfo p3 = new PhotoInfo();
        p3.url = "http://e.hiphotos.baidu.com/image/pic/item/902397dda144ad343de8b756d4a20cf430ad858f.jpg";
        p3.w = 950;
        p3.h = 597;

        PhotoInfo p4 = new PhotoInfo();
        p4.url = "http://a.hiphotos.baidu.com/image/pic/item/a6efce1b9d16fdfa0fbc1ebfb68f8c5495ee7b8b.jpg";
        p4.w = 533;
        p4.h = 800;

        PhotoInfo p5 = new PhotoInfo();
        p5.url = "http://b.hiphotos.baidu.com/image/pic/item/a71ea8d3fd1f4134e61e0f90211f95cad1c85e36.jpg";
        p5.w = 700;
        p5.h = 467;

        PhotoInfo p6 = new PhotoInfo();
        p6.url = "http://c.hiphotos.baidu.com/image/pic/item/7dd98d1001e939011b9c86d07fec54e737d19645.jpg";
        p6.w = 700;
        p6.h = 467;

        PhotoInfo p7 = new PhotoInfo();
        p7.url = "http://pica.nipic.com/2007-10-17/20071017111345564_2.jpg";
        p7.w = 1024;
        p7.h = 640;

        PhotoInfo p8 = new PhotoInfo();
        p8.url = "http://pic4.nipic.com/20091101/3672704_160309066949_2.jpg";
        p8.w = 1024;
        p8.h = 768;

        PhotoInfo p9 = new PhotoInfo();
        p9.url = "http://pic4.nipic.com/20091203/1295091_123813163959_2.jpg";
        p9.w = 1024;
        p9.h = 640;

        PhotoInfo p10 = new PhotoInfo();
        p10.url = "http://pic31.nipic.com/20130624/8821914_104949466000_2.jpg";
        p10.w = 1024;
        p10.h = 768;
        List<PhotoInfo>  photoInfos=new ArrayList<>();
        photoInfos.add(p1);
        photoInfos.add(p2);
        photoInfos.add(p3);
        photoInfos.add(p4);
        photoInfos.add(p5);
        photoInfos.add(p6);
        photoInfos.add(p7);
        photoInfos.add(p8);
        photoInfos.add(p9);
        photoInfos.add(p10);
        return photoInfos;
    }

    @Override
    protected void afterCreate(Bundle savedInstanceState) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        List<List<PhotoInfo>> mdata = new ArrayList<>();
        for (int i = 0; i < initData().size(); i++) {
            List<PhotoInfo> list = new ArrayList<>();
            for (int j = 0; j < i+1 ; j++) {
                list.add(initData().get(j));
            }
            mdata.add(list);
        }
        NiceViewAdapter niceViewAdapter = new NiceViewAdapter(getApplicationContext(),mdata, R.layout.itme_nice);
        idRecycleview.setLayoutManager(linearLayoutManager);
        idRecycleview.setAdapter(niceViewAdapter);
    }


    public class NiceViewAdapter extends BaseRecyclerAdapter<List<PhotoInfo>> {

        public NiceViewAdapter(Context context,List<List<PhotoInfo>> datas, int itemLayoutId) {
            super(context,datas, itemLayoutId);
        }

        @Override
        protected void convert(BaseRecyclerHolder holder, List<PhotoInfo> item, int position) {
            MultiImageView multiImageView = holder.getView(R.id.multiImagView);
            multiImageView.setList(item);
            multiImageView.setOnItemClickListener(new MultiImageView.OnItemClickListener() {
                @Override
                public void onItemClick(View view, int position) {
                    //ImagePagerActivity.ImageSize imageSize = new ImagePagerActivity.ImageSize(view.getMeasuredWidth(), view.getMeasuredHeight());
                    List<String> photoUrls = new ArrayList<>();
                    for(PhotoInfo photoInfo : item){
                        photoUrls.add(photoInfo.getUrl());
                    }
                    Intent intent = new Intent(NiceMainActivity.this, ImagePagerActivity.class);
                    intent.putStringArrayListExtra("INTENT_IMGURLS", (ArrayList<String>) photoUrls);
                    intent.putExtra("INTENT_WIDTH", view.getMeasuredWidth());
                    intent.putExtra("INTENT_HEIGHT", view.getMeasuredHeight());
                    intent.putExtra("INTENT_POSITION", position);
                    startActivity(intent);

                }
            });
        }
    }

    @Override
    public int getFragmentContentId() {
        return 0;
    }

}
