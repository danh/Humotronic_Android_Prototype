package com.example.mycheezburger.fragment;

import com.example.swipetab.R;
import com.viewpagerindicator.IconPagerAdapter;
import com.viewpagerindicator.TabPageIndicator;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link android.support.v4.app.Fragment} subclass.
 * 
 */
public class FragmentUserPicture extends Fragment {

	private static final String[] CONTENT = new String[] { "All", "Uploads", "Reposts" };
	private static final int[] ICONS = new int[] {
		R.drawable.custom_userprofile_tab_all,
		R.drawable.custom_userprofile_tab_upload,
		R.drawable.custom_userprofile_tab_repost,
	};
	
	ViewPager viewPager;
	
	public FragmentUserPicture() {
		// Required empty public constructor
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// declare a contextThemeWrapper to store a theme
		final Context contextThemeWrapper = new ContextThemeWrapper(getActivity(), R.style.Theme_PageIndicatorTextColorBlue);
		
		// Set theme inside local inflater
		LayoutInflater localInflater = inflater.cloneInContext(contextThemeWrapper);
		
		// Inflate the layout for this fragment
		View view = localInflater.inflate(R.layout.fragment_user_picture,
				container, false);
		
		viewPager = (ViewPager) view.findViewById(R.id.pager);
		viewPager.setAdapter(new UserPictureAdapter(getFragmentManager()));
		
		TabPageIndicator indicator = (TabPageIndicator) view.findViewById(R.id.indicator);
        indicator.setViewPager(viewPager);
		
		return view;
	}
	
	class UserPictureAdapter extends FragmentPagerAdapter implements IconPagerAdapter {

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
	        return CONTENT[position % CONTENT.length];
	    }
		
		@Override 
		public int getIconResId(int index) {
	          return ICONS[index];
	    }
		
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
				// we have only 3 fragment, so the number is 3
			return ICONS.length;
		}
	
	}

}
