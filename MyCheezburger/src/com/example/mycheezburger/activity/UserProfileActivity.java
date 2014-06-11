package com.example.mycheezburger.activity;

import com.example.mycheezburger.fragment.FragmentUserProfile;
import com.example.swipetab.R;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;


public class UserProfileActivity extends FragmentActivity{

	private final String TAG_USER_PROFILE = "TAG_USER_PROFILE";
	
	FragmentManager manager = getSupportFragmentManager();
	FragmentTransaction transaction = manager.beginTransaction();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_user_profile);

		FragmentUserProfile fUserProfile = (FragmentUserProfile) manager.findFragmentByTag(TAG_USER_PROFILE);
		
		if (fUserProfile == null) {
			fUserProfile = new FragmentUserProfile();
			transaction.add(R.id.fragmentUserProfile, fUserProfile, TAG_USER_PROFILE);
			transaction.commit();
		}
	}
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Log.v("onDestroy", "onDestroy USER PROFILE");
	}

}
