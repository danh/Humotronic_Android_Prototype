package com.example.mycheezburger.activity;

import com.example.mycheezburger.fragment.FragmentUserFollowers;
import com.example.swipetab.R;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

public class FollowersActivity extends FragmentActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_followers);
		
		FragmentManager manager = getSupportFragmentManager();
		FragmentTransaction transaction = manager.beginTransaction();
		
		FragmentUserFollowers fUserFollower = new FragmentUserFollowers();
		transaction.add(R.id.followerFragmentActivity, fUserFollower);
		transaction.commit();

	}
}
