package com.example.mycheezburger.fragment;

import java.util.ArrayList;
import java.util.List;

import com.example.mycheezburger.activity.FollowersActivity;
import com.example.mycheezburger.activity.FollowingActivity;
import com.example.mycheezburger.database.UserFollowDatabaseHelper;
import com.example.mycheezburger.object.UserFollow;
import com.example.swipetab.R;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * A simple {@link android.support.v4.app.Fragment} subclass.
 * 
 */
public class FragmentUserProfile extends Fragment implements OnClickListener{
	
	ImageView imgFollow;
	
	Button btnFollower;
	Button btnFollowing;

	String[] followersName;
	String[] followingName;
	
	private final String TAG_USER_FOLLOWERS = "UserFollowers";
	private final String TAG_USER_FOLLOWING = "UserFollowing";
	private final String TAG_USER_PICTURE = "TAG_USER_PICTURE";
	
	List<UserFollow> userFollowers = new ArrayList<UserFollow>();
	List<UserFollow> userFollowing = new ArrayList<UserFollow>();

	UserFollowDatabaseHelper userFollowHelper;
	
	public FragmentUserProfile() {
		// Required empty public constructor
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		View view = inflater.inflate(R.layout.fragment_user_profile, container, false);
		
		// Database
		userFollowHelper = new UserFollowDatabaseHelper(view.getContext());
		
		imgFollow = (ImageView) view.findViewById(R.id.imgFollow);
		
		btnFollower = (Button) view.findViewById(R.id.btnFollowers);
		btnFollowing = (Button) view.findViewById(R.id.btnFollowing);
		
			// SET on click listener
		imgFollow.setOnClickListener(this);
		
		btnFollower.setOnClickListener(this);
		btnFollowing.setOnClickListener(this);

		return view;
	}
	
	@Override 
	public void onStart() {
		super.onStart();
		// Initial User follower
		if (readUserFollowerDatabase() == false)
		{
			initUserFollowers();
			readUserFollowerDatabase();
		}

		// Initial User following
		readUserFollowingDatabase();
		
		btnFollower.setText("FOLLOWERS: \n" + userFollowers.size());
		btnFollower.setTextSize(1,(float) 20.0);
		
		btnFollowing.setText("FOLLOWING: \n" + userFollowing.size());
		btnFollowing.setTextSize(1,(float) 20.0);
		
		Log.v("onStart", "onStart UserProfile");
	};

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId())
		{
			case R.id.btnFollowers:
			{
				Toast.makeText(getActivity(), "Clicked on button Follower", Toast.LENGTH_SHORT).show();
				Intent intent = new Intent(getActivity(), FollowersActivity.class);
				
				// set user follow information to bundle
				Bundle bundle = new Bundle();
				bundle.putParcelableArrayList(TAG_USER_FOLLOWERS, (ArrayList<? extends Parcelable>) userFollowers);
				
				// set bundle into intent
				intent.putExtras(bundle);
				
				startActivity(intent);
			}
			break;
			case R.id.btnFollowing:
			{
				Toast.makeText(getActivity(), "Click on button Following", Toast.LENGTH_SHORT).show();
				Intent intent = new Intent(getActivity(), FollowingActivity.class);
				
				// set user follow information to bundle
				Bundle bundle = new Bundle();
				bundle.putParcelableArrayList(TAG_USER_FOLLOWING, (ArrayList<? extends Parcelable>) userFollowing);
				
				// set bundle into intent
				intent.putExtras(bundle);
				
				startActivity(intent);
			}
			break;
			case R.id.imgFollow:
			{
				Toast.makeText(getActivity(), "Follow Successful", Toast.LENGTH_SHORT).show();
			}
			break;
			default:
			{
				Toast.makeText(getActivity(), "Nothing", Toast.LENGTH_SHORT).show();
			}
		}
	}
	
	public void initUserFollowers() {
		// get User name
		followersName = getResources().getStringArray(R.array.followerNames);
		// Set userFollows list
		for (int i = 0; i < followersName.length; ++i) {
			userFollowHelper.insertData(followersName[i], "Edit", String.valueOf(R.drawable.user), "false");
		}
	}
	
	public boolean readUserFollowerDatabase() {
		userFollowers = userFollowHelper.getAllData();
		if (userFollowers.size() == 0) {
			return false;
		}
		return true;
	}
	
	public void initUserFollowing() {
		// get User name
		followingName = getResources().getStringArray(R.array.followingNames);
		// Set userFollows list
		for (int i = 0; i < followingName.length; ++i) {
			userFollowHelper.insertData(followingName[i], "Edit", String.valueOf(R.drawable.user), "true");
		}
	}
	
	public boolean readUserFollowingDatabase() {
		userFollowing = userFollowHelper.getFollowingData();
		if (userFollowing.size() == 0) {
			return false;
		}
		return true;
	}
}
