package com.example.mycheezburger.activity;

import java.util.ArrayList;
import java.util.List;

import com.example.mycheezburger.fragment.FragmentUserFollowers;
import com.example.mycheezburger.fragment.FragmentUserFollowing;
import com.example.mycheezburger.object.UserFollow;
import com.example.swipetab.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

public class FollowingActivity extends FragmentActivity {
	
	FragmentManager manager = getSupportFragmentManager();
	FragmentTransaction transaction = manager.beginTransaction();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_following);

		// Get user followers information
		Bundle bundle = getIntent().getExtras();
		
		List<UserFollow> userFollowing = new ArrayList<UserFollow>();
		userFollowing = bundle.getParcelableArrayList("UserFollowers");
		
		// if there was a fragment
		FragmentUserFollowing fUserFollowing = (FragmentUserFollowing) manager.findFragmentByTag("USER_FOLLOWING_TAG");
		
		if (fUserFollowing == null)
		{
			fUserFollowing = new FragmentUserFollowing();
			transaction.add(R.id.followingFragmentActivity, fUserFollowing, "USER_FOLLOWING_TAG");
			fUserFollowing.setArguments(bundle);
			transaction.commit();
		}
	}
	
	@Override
	public void onAttachFragment(Fragment fragment) {
		// TODO Auto-generated method stub
		super.onAttachFragment(fragment);
		Log.v("onAttachFragment", "onAttachFragment");
	}
	
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		Log.v("onStart", "onStart");
	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Log.v("onResume", "onResume");
	}
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		Log.v("onPause", "onPause");
	}
	
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
		Log.v("onSaveInstanceState", "onSaveInstanceState");
	}
	
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		Log.v("onStop", "onStop");
	}
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		
		Log.v("onDestroy", "onDestroy");
	}
}
