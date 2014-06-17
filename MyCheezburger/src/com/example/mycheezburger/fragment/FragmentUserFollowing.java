package com.example.mycheezburger.fragment;

import java.util.ArrayList;
import java.util.List;

import com.example.mycheezburger.adapter.UserFollowingAdapter;
import com.example.mycheezburger.object.UserFollow;
import com.example.swipetab.R;

import android.app.ActionBar;
import android.os.Bundle;
import android.os.Parcelable;
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

	private final String TAG_USER_FOLLOWING = "UserFollowing";
	
	ListView userFollowingList;
	
	UserFollowingAdapter followingAdapter;
	
	String[] followingName;
	
	List<UserFollow> userFollowing = new ArrayList<UserFollow>();
	
	public FragmentUserFollowing() {
		// Required empty public constructor
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		View view = inflater.inflate(R.layout.fragment_user_following, container, false);
		
		if (savedInstanceState == null) {
			// Initial user followers
			userFollowing = getArguments().getParcelableArrayList(TAG_USER_FOLLOWING);
		} else {
			userFollowing = savedInstanceState.getParcelableArrayList(TAG_USER_FOLLOWING);
		}
		
		// Show number of user on action bar
		ActionBar userFollowingActionBar = getActivity().getActionBar();
		userFollowingActionBar.setTitle("FOLLOWING (" + userFollowing.size() + ")");
		
		followingName = getResources().getStringArray(R.array.followingNames);
		
		userFollowingList = (ListView) view.findViewById(R.id.listUserFollowing);
		
		followingAdapter = new UserFollowingAdapter(view.getContext(), userFollowing);
		
		userFollowingList.setAdapter(followingAdapter);
		
		return view;
	}
	
	@Override 
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putParcelableArrayList(TAG_USER_FOLLOWING, (ArrayList<? extends Parcelable>) userFollowing);
	};

}
