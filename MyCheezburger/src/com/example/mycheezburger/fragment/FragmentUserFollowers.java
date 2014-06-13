package com.example.mycheezburger.fragment;

import java.util.ArrayList;
import java.util.List;

import com.example.mycheezburger.adapter.UserFollowersAdapter;
import com.example.mycheezburger.object.UserFollow;
import com.example.swipetab.R;

import android.app.ActionBar;
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

	private final String TAG_USER_FOLLOWER = "UserFollowers";
	
	ListView userFollowerList;
	
	UserFollowersAdapter followerAdapter;
	
	List<UserFollow> userFollowers = new ArrayList<UserFollow>();
	
	public FragmentUserFollowers() {
		// Required empty public constructor
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		View view = inflater.inflate(R.layout.fragment_user_followers, container, false);
		
		if (savedInstanceState == null) {
			// Initial user followers
			userFollowers = getArguments().getParcelableArrayList(TAG_USER_FOLLOWER);
		} else {
			userFollowers = savedInstanceState.getParcelableArrayList(TAG_USER_FOLLOWER);
		}
		
		ActionBar userFollowerActionBar = getActivity().getActionBar();
		userFollowerActionBar.setTitle("FOLLOWERS (" + userFollowers.size() + ")");
		
		userFollowerList = (ListView) view.findViewById(R.id.listUserFollowers);
		
		followerAdapter = new UserFollowersAdapter(view.getContext(), userFollowers);
		
		userFollowerList.setAdapter(followerAdapter);
		
		Log.v("onCreateView", "Fragment User Follower onCreateView");
		
		return view;
	}
	
	@Override 
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putParcelableArrayList(TAG_USER_FOLLOWER, (ArrayList<? extends Parcelable>) userFollowers);
		Log.v("onSaveInstanceState", "Fragment User Follower onSaveInstanceState");
	};
}
