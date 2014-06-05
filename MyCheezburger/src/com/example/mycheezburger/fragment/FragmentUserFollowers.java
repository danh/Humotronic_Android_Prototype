package com.example.mycheezburger.fragment;

import java.util.ArrayList;
import java.util.List;

import com.example.mycheezburger.adapter.UserFollowersAdapter;
import com.example.mycheezburger.object.UserFollow;
import com.example.swipetab.R;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

/**
 * A simple {@link android.support.v4.app.Fragment} subclass.
 * 
 */
public class FragmentUserFollowers extends Fragment {

	private final String TAG_USER_FOLLOWER = "UserFollower";
	
	ListView userFollowerList;
	
	UserFollowersAdapter followerAdapter;
	
	String[] followersName;
	
	List<UserFollow> userFollowers = new ArrayList<UserFollow>();
	
	public FragmentUserFollowers() {
		// Required empty public constructor
	}
	@Override 
	public void onAttach(android.app.Activity activity) {
		super.onAttach(activity);
		Log.v("onAttach", "Fragment User Follower onAttach");
	};
	
	@Override 
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.v("onCreate", "Fragment User Follower onCreate");
	};

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		View view = inflater.inflate(R.layout.fragment_user_followers, container, false);
		
		if (savedInstanceState == null) {
			// Initial user followers
			InitUserFollowers();
		} else {
			userFollowers = savedInstanceState.getParcelableArrayList(TAG_USER_FOLLOWER);
		}
		
		
		userFollowerList = (ListView) view.findViewById(R.id.listUserFollowers);
		
		followerAdapter = new UserFollowersAdapter(view.getContext(), userFollowers);
		
		userFollowerList.setAdapter(followerAdapter);
		
		Log.v("onCreateView", "Fragment User Follower onCreateView");
		
		return view;
	}
	
	@Override 
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		Log.v("onActivityCreated", "Fragment User Follower onActivityCreated");
	};
	
	@Override 
	public void onStart() {
		super.onStart();
		Log.v("onStart", "Fragment User Follower onStart");
	};
	
	@Override 
	public void onResume() {
		super.onResume();
		Log.v("onResume", "Fragment User Follower onResume");
	};
	
	@Override 
	public void onPause() {
		super.onPause();
		Log.v("onPause", "Fragment User Follower onPause");
	};
	
	@Override 
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putParcelableArrayList(TAG_USER_FOLLOWER, (ArrayList<? extends Parcelable>) userFollowers);
		Log.v("onSaveInstanceState", "Fragment User Follower onSaveInstanceState");
	};
	
	@Override 
	public void onStop() {
		super.onStop();
		Log.v("onStop", "Fragment User Follower onStop");
	};
	
	@Override 
	public void onDestroyView() {
		super.onDestroyView();
		Log.v("onDestroyView", "Fragment User Follower onDestroyView");
	};
	
	@Override 
	public void onDestroy() {
		super.onDestroy();
		Log.v("onDestroy", "Fragment User Follower onDestroy");
	};
	
	@Override 
	public void onDetach() {
		super.onDetach();
		Log.v("onDetach", "Fragment User Follower onDetach");
	};
	
	public void InitUserFollowers() {
		// get User name
		followersName = getResources().getStringArray(R.array.followerNames);
		// Set userFollows list
		UserFollow userFollow;
		
		for (int i = 0; i < followersName.length; ++i) {
			userFollow = new UserFollow(i, followersName[i], "Edit", R.drawable.user, false);
						
			userFollowers.add(userFollow);
		}
	}

}
