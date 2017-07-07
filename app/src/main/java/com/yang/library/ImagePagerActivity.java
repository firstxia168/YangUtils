package com.yang.library;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.ymz.baselibrary.ABaseActivity;
import com.ymz.baselibrary.utils.UIUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**O
 * 创建人：$ gyymz1993
 * 创建时间：2017/7/4 11:18
 */

public class ImagePagerActivity extends ABaseActivity {
    @BindView(R.id.id_viewpager)
    ViewPager viewPager;
    @BindView(R.id.id_layout_contrain)
    LinearLayout layoutContrain;
    private List<String> mdata;
    private int currentItem;
    @Override
    protected int getLayoutId() {
        return R.layout.imagepager_main;
    }

    private void getIntentData() {
        currentItem = getIntent().getIntExtra("INTENT_POSITION", 0);
        mdata = getIntent().getStringArrayListExtra("INTENT_IMGURLS");
    }

    @Override
    protected void afterCreate(Bundle savedInstanceState) {
        getIntentData();
        if (mdata==null||mdata.size()==0)return;
        PhotoAdater photoAdater=new PhotoAdater(mdata);
        viewPager.setAdapter(photoAdater);
        viewPager.setCurrentItem(currentItem);
        viewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
            @Override
            public void onPageSelected(int position) {
                for (int i=0;i<mIndicatorViews.size();i++){
                    mIndicatorViews.get(i).setSelected(i==position);
                }
            }
        });
        addIndiactorView(mdata,currentItem);
    }
    
    List<View> mIndicatorViews=new ArrayList<>();
    private void addIndiactorView(List<String> mdata,int currentSelect) {
        if (mdata==null||mdata.size()==0||mdata.size()==1)return;
        for (int i=0;i<mdata.size();i++){
            View view=new View(this);
            view.setBackgroundResource(R.drawable.indicator_select);
            view.setSelected(i == currentSelect);
            LinearLayout.LayoutParams layoutParams=new LinearLayout.LayoutParams(UIUtils.dip2px(6),
                    UIUtils.dip2px(6));
            layoutParams.setMargins(10, 0, 0, 0);
            layoutContrain.addView(view,layoutParams);
            mIndicatorViews.add(view);
        }
    }


    public class PhotoAdater extends PagerAdapter {

        private List<String> mdata;
        private ImageView samllImageView;

        public PhotoAdater(List<String> data) {
            if (data == null) {
                mdata = new ArrayList<>();
            }
            this.mdata = data;
        }

        @Override
        public int getCount() {
            return mdata == null ? 0 : mdata.size();
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view = UIUtils.inflate(R.layout.item_simple_viewpager);
            ImageView imageView = (ImageView) view.findViewById(R.id.id_ig_photoshow);
            String imageUrl = mdata.get(position);
            Glide.with(getApplicationContext()).load(imageUrl)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .error(R.drawable.ic_no_data)
                    .centerCrop()
                    .into(imageView);
            container.addView(view, 0);
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }
    }

    @Override
    public int getFragmentContentId() {
        return 0;
    }
}
