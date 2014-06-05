package com.example.mycheezburger.activity;

import com.example.mycheezburger.fragment.FragmentUserFollowing;
import com.example.swipetab.R;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

public class FollowingActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_following);

		FragmentManager manager = getSupportFragmentManager();
		FragmentTransaction transaction = manager.beginTransaction();
		
		FragmentUserFollowing fUserFollowing = new FragmentUserFollowing();
		transaction.add(R.id.followingFragmentActivity, fUserFollowing);
		transaction.commit();
	}
}
