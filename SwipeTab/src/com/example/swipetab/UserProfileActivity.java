package com.example.swipetab;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;


public class UserProfileActivity extends FragmentActivity{

	FragmentUserProfile fUserProfile;
	
	FragmentManager manager;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_user_profile);
		
		manager = getSupportFragmentManager();
		fUserProfile = (FragmentUserProfile) manager.findFragmentById(R.id.fragment1);
		
	}

}
