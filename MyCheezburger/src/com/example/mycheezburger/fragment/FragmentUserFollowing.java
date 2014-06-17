package com.example.mycheezburger.fragment;

import java.util.ArrayList;
import java.util.List;

import com.example.mycheezburger.adapter.UserFollowingAdapter;
import com.example.mycheezburger.endlesslistview.UserFollowingEndlessListview;
import com.example.mycheezburger.endlesslistview.UserFollowingEndlessListview.EndlessListener;
import com.example.mycheezburger.object.UserFollow;
import com.example.swipetab.R;

import android.app.ActionBar;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link android.support.v4.app.Fragment} subclass.
 * 
 */
public class FragmentUserFollowing extends Fragment implements EndlessListener {

	private final String TAG_USER_FOLLOWING = "UserFollowing";
	private final static int USER_PER_REQUEST = 20;
	private int userPosition = 0;
	
	UserFollowingEndlessListview userFollowingList;
	
	UserFollowingAdapter followingAdapter;
	
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
		
		userFollowingList = (UserFollowingEndlessListview) view.findViewById(R.id.listUserFollowing);
		
		followingAdapter = new UserFollowingAdapter(view.getContext(), createSubUserFollowing());
		
		userFollowingList.setTotalNumberOfFollowing(userFollowing.size());
		userFollowingList.setLoadingView(R.layout.loading_user_following);
		userFollowingList.setAdapter(followingAdapter);
		userFollowingList.setListener(this);
		
		return view;
	}
	
	private class UserFollowingLoader extends AsyncTask<UserFollow, Void, List<UserFollow>> {

		@Override
		protected List<UserFollow> doInBackground(UserFollow... params) {
			// TODO Auto-generated method stub
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}
			return createSubUserFollowing();
		}
		
		@Override
		protected void onPostExecute(List<UserFollow> result) {			
			super.onPostExecute(result);
			userFollowingList.addNewData(result);
		}
		
	}
	
	private List<UserFollow> createSubUserFollowing() {
		List<UserFollow> subUserFollow = new ArrayList<UserFollow>();
		
		for (int i = 0; i < USER_PER_REQUEST; ++i) {
			if (i + userPosition < userFollowing.size()) {
				subUserFollow.add(userFollowing.get(i + userPosition));
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
		UserFollowingLoader fl = new UserFollowingLoader();
		fl.execute(new UserFollow[]{});
		
	}
	
	@Override 
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putParcelableArrayList(TAG_USER_FOLLOWING, (ArrayList<? extends Parcelable>) userFollowing);
	};

}
