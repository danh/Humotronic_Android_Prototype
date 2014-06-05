package com.example.mycheezburger.activity;

import com.example.mycheezburger.fragment.FragmentUserProfile;
import com.example.swipetab.R;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;


public class UserProfileActivity extends FragmentActivity{

	
	
	int display_mode;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_user_profile);

		FragmentManager manager = getSupportFragmentManager();
		FragmentTransaction transaction = manager.beginTransaction();
		
		FragmentUserProfile fUserProfile = new FragmentUserProfile();
		transaction.add(R.id.fragmentUserProfile, fUserProfile);
		transaction.commit();
	}

}
