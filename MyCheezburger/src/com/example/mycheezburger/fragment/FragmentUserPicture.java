package com.example.mycheezburger.fragment;

import com.example.swipetab.R;
import com.viewpagerindicator.TabPageIndicator;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link android.support.v4.app.Fragment} subclass.
 * 
 */
public class FragmentUserPicture extends Fragment {

	private static final String[] CONTENT = new String[] { "ALL", "UPLOAD", "REPOSTS" };
	
	ViewPager viewPager;
	
	public FragmentUserPicture() {
		// Required empty public constructor
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		View view = inflater.inflate(R.layout.fragment_user_picture,
				container, false);
		
		viewPager = (ViewPager) view.findViewById(R.id.pager);
		viewPager.setAdapter(new UserPictureAdapter(getFragmentManager()));
		
		TabPageIndicator indicator = (TabPageIndicator) view.findViewById(R.id.indicator);
        indicator.setViewPager(viewPager);
		
		return view;
	}
	
	class UserPictureAdapter extends FragmentPagerAdapter {

		// get the Fragment manager
		public UserPictureAdapter(FragmentManager fm) {
			super(fm);
		}
	
		@Override
		public Fragment getItem(int arg0) {
			// TODO Auto-generated method stub
			Fragment fragment = null;
				// move to the related Fragment
			if (arg0 == 0) {
				fragment = new FragmentUserAllPicture();
			} else if (arg0 == 1) {
				fragment = new FragmentUserUploadPicture();
			} else if (arg0 == 2) {
				fragment = new FragmentUserRepostsPicture();
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
