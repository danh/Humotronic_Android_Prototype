package com.example.mycheezburger;

import com.example.mycheezburger.fragment.FragmentUserProfile;
import com.example.swipetab.R;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;


public class UserProfileActivity extends FragmentActivity{

	FragmentUserProfile fUserProfile;
	
	FragmentManager manager;
	
	int display_mode;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_user_profile);
		
		manager = getSupportFragmentManager();
		
		display_mode = getResources().getConfiguration().orientation;
		
		if (display_mode == 1) {
			fUserProfile = (FragmentUserProfile) manager.findFragmentById(R.id.fragmentUserProfilePor);
		} else {
			fUserProfile = (FragmentUserProfile) manager.findFragmentById(R.id.fragmentUserProfileLand);
		}

	}
	
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		
		display_mode = getResources().getConfiguration().orientation;
		
		if (display_mode == 1) {
			fUserProfile = (FragmentUserProfile) manager.findFragmentById(R.id.fragmentUserProfilePor);
		} else {
			fUserProfile = (FragmentUserProfile) manager.findFragmentById(R.id.fragmentUserProfileLand);
		}
	}

}
