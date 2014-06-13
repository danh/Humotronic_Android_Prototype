package com.example.mycheezburger.activity;

import com.example.mycheezburger.fragment.FragmentCheezburger;
import com.example.mycheezburger.fragment.FragmentHotToday;
import com.example.mycheezburger.fragment.FragmentYourFeed;
import com.example.swipetab.R;
import com.viewpagerindicator.TabPageIndicator;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Window;


public class MainActivity extends FragmentActivity{

	private static final String[] CONTENT = new String[] { "CHEEZBURGER", "YOUR FEED", "HOT TODAY" };
	
	ViewPager viewPager;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		
		viewPager = (ViewPager) findViewById(R.id.pager);
		viewPager.setAdapter(new MainPagerAdapter(getSupportFragmentManager()));
		
		TabPageIndicator indicator = (TabPageIndicator) findViewById(R.id.indicator);
        indicator.setViewPager(viewPager);

	}

	class MainPagerAdapter extends FragmentPagerAdapter {

		// get the Fragment manager
		public MainPagerAdapter(FragmentManager fm) {
			super(fm);
		}
		
		@Override
		public Fragment getItem(int arg0) {
			// TODO Auto-generated method stub
			Fragment fragment = null;
				// move to the related Fragment
			if (arg0 == 0) {
				fragment = new FragmentCheezburger();
			} else if (arg0 == 1) {
				fragment = new FragmentYourFeed();
			} else if (arg0 == 2) {
				fragment = new FragmentHotToday();
			}
			return fragment;
		}
	
		@Override
	    public CharSequence getPageTitle(int position) {
	        return CONTENT[position % CONTENT.length].toUpperCase();
	    }
		
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
				// we have only 3 fragment, so the number is 3
			return CONTENT.length;
		}
		
	}
}
