package com.example.mycheezburger.activity;

import com.example.mycheezburger.fragment.FragmentUserFollowers;
import com.example.swipetab.R;

//import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

public class FollowersActivity extends FragmentActivity {
	
	FragmentUserFollowers fUserFollower;
	
	FragmentManager manager;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_followers);

	}
}
