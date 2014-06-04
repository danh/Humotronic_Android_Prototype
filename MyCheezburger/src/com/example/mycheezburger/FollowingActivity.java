package com.example.mycheezburger;

import com.example.mycheezburger.fragment.FragmentUserFollowing;
import com.example.swipetab.R;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

public class FollowingActivity extends FragmentActivity {

	FragmentUserFollowing fUserFollowing;
	
	FragmentManager manager;
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_following);
		
		manager = getSupportFragmentManager();
		fUserFollowing = (FragmentUserFollowing) manager.findFragmentById(R.id.fragmentUserFollowing);
	}
}
