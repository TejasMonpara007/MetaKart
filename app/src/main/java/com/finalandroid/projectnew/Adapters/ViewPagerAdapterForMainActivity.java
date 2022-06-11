package com.finalandroid.projectnew.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class ViewPagerAdapterForMainActivity  extends PagerAdapter {
    Context context;
    String[] imageUrls;
    int [] imagesMainActivityAll;

    LayoutInflater layoutInflater;

    public ViewPagerAdapterForMainActivity(Context context, int[] imagesMainActivityAll) {
        this.context = context;
        this.imagesMainActivityAll = imagesMainActivityAll;

    }
    @Override
    public int getCount() {
        return imagesMainActivityAll.length;
    }
    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ImageView imageViewsss = new ImageView(context);
        imageViewsss.setScaleType(ImageView.ScaleType.FIT_XY);
        imageViewsss.setImageResource(imagesMainActivityAll[position]);
        ((ViewPager)container).addView(imageViewsss,0);
        return imageViewsss;

    }
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

}
