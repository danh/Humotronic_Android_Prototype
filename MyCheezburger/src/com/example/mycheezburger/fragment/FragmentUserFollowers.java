package com.example.mycheezburger.fragment;

import java.util.ArrayList;
import java.util.List;

import com.example.mycheezburger.adapter.UserFollowersAdapter;
import com.example.mycheezburger.endlesslistview.UserFollowersEndlessListview;
import com.example.mycheezburger.endlesslistview.UserFollowersEndlessListview.EndlessListener;
import com.example.mycheezburger.object.UserFollow;
import com.example.swipetab.R;

import android.app.ActionBar;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link android.support.v4.app.Fragment} subclass.
 * 
 */
public class FragmentUserFollowers extends Fragment implements EndlessListener {

	private final String TAG_USER_FOLLOWER = "UserFollowers";
	private final static int USER_PER_REQUEST = 20;
	private int userPosition = 0;
	
	UserFollowersEndlessListview userFollowerList;
	
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
		
		// Show number of user on action bar
		ActionBar userFollowerActionBar = getActivity().getActionBar();
		userFollowerActionBar.setTitle("FOLLOWERS (" + userFollowers.size() + ")");
		
		userFollowerList = (UserFollowersEndlessListview) view.findViewById(R.id.listUserFollowers);
		
		followerAdapter = new UserFollowersAdapter(view.getContext(), createSubUserFollowers());
		
		userFollowerList.setTotalNumberOfFollowers(userFollowers.size());
		userFollowerList.setLoadingView(R.layout.loading_user_follower);
		userFollowerList.setAdapter(followerAdapter);
		userFollowerList.setListener(this);
		
		Log.v("onCreateView", "Fragment User Follower onCreateView");
		
		return view;
	}
	
	private class UserFollowerLoader extends AsyncTask<UserFollow, Void, List<UserFollow>> {

		@Override
		protected List<UserFollow> doInBackground(UserFollow... params) {
			// TODO Auto-generated method stub
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}
			return createSubUserFollowers();
		}
		
		@Override
		protected void onPostExecute(List<UserFollow> result) {			
			super.onPostExecute(result);
			userFollowerList.addNewData(result);
		}
		
	}
	
	private List<UserFollow> createSubUserFollowers() {
		List<UserFollow> subUserFollow = new ArrayList<UserFollow>();
		
		for (int i = 0; i < USER_PER_REQUEST; ++i) {
			if (i + userPosition < userFollowers.size()) {
				subUserFollow.add(userFollowers.get(i + userPosition));
			} else {
				break;
			}
		}
		
		return subUserFollow;
	}
	
	@Override
	public void loadData() {
		System.out.println("Load data");
		userPosition += USER_PER_REQUEST;
		// We load more data here
		UserFollowerLoader fl = new UserFollowerLoader();
		fl.execute(new UserFollow[]{});
		
	}

	
	@Override 
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putParcelableArrayList(TAG_USER_FOLLOWER, (ArrayList<? extends Parcelable>) userFollowers);
		Log.v("onSaveInstanceState", "Fragment User Follower onSaveInstanceState");
	}
}
