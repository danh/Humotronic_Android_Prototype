package com.example.swipetab;

import java.util.List;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class ImagePagerAdapter extends PagerAdapter{

	private Context       context;
    private List<Integer> imageIdList;
    
    public ImagePagerAdapter(Context context, List<Integer> imageIdList) {
        this.context = context;
        this.imageIdList = imageIdList;
    }
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return imageIdList.size();
	}

	@Override
	public boolean isViewFromObject(View view, Object object) {
		// TODO Auto-generated method stub
		return (view == object);
	}
	
	@Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(imageIdList.get(position));
        ((ViewPager)container).addView(imageView, 0);
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager)container).removeView((ImageView)object);
    }

	
}
