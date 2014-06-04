package com.example.mycheezburger.fragment;

import com.example.mycheezburger.adapter.UserFollowingAdapter;
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
public class FragmentUserFollowing extends Fragment {

	ListView userFollowingList;
	
	UserFollowingAdapter followingAdapter;
	
	String[] followingName;
	
	public FragmentUserFollowing() {
		// Required empty public constructor
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		View view = inflater.inflate(R.layout.fragment_user_following, container, false);
		
		followingName = getResources().getStringArray(R.array.followingNames);
		
		userFollowingList = (ListView) view.findViewById(R.id.listUserFollowing);
		
		followingAdapter = new UserFollowingAdapter(view.getContext(), followingName);
		
		userFollowingList.setAdapter(followingAdapter);
		
		return view;
	}

}
