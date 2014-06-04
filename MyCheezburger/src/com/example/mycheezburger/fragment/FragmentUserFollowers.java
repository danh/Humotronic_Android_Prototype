package com.example.mycheezburger.fragment;

import com.example.mycheezburger.adapter.UserFollowersAdapter;
import com.example.swipetab.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

/**
 * A simple {@link android.support.v4.app.Fragment} subclass.
 * 
 */
public class FragmentUserFollowers extends Fragment {

	ListView userFollowerList;
	
	UserFollowersAdapter followerAdapter;
	
	String[] followersName;
	
	public FragmentUserFollowers() {
		// Required empty public constructor
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		View view = inflater.inflate(R.layout.fragment_user_followers, container, false);
		
		followersName = getResources().getStringArray(R.array.followerNames);
		
		userFollowerList = (ListView) view.findViewById(R.id.listUserFollowers);
		
		followerAdapter = new UserFollowersAdapter(view.getContext(), followersName);
		
		userFollowerList.setAdapter(followerAdapter);
		
		return view;
	}

}
