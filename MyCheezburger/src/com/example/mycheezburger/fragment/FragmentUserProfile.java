package com.example.mycheezburger.fragment;

import com.example.mycheezburger.FollowersActivity;
import com.example.mycheezburger.FollowingActivity;
import com.example.mycheezburger.adapter.UserPictureAdapter;
import com.example.swipetab.R;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link android.support.v4.app.Fragment} subclass.
 * 
 */
public class FragmentUserProfile extends Fragment implements OnClickListener{

	GridView pictureGridView;
	
	UserPictureAdapter userPicAdapter;
	
	String[] userPictures;
	
	ImageView imgFollow;
	
	TextView txtAll;
	TextView txtUploads;
	TextView txtReposts;
	
	Button btnFollower;
	Button btnFollowing;
	
	public FragmentUserProfile() {
		// Required empty public constructor
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		View view = inflater.inflate(R.layout.fragment_user_profile, container, false);
		
		userPictures = getResources().getStringArray(R.array.itemNames);
		
		imgFollow = (ImageView) view.findViewById(R.id.imgFollow);
		txtAll = (TextView) view.findViewById(R.id.txtAll);
		txtUploads = (TextView) view.findViewById(R.id.txtUploads);
		txtReposts = (TextView) view.findViewById(R.id.txtReposts);
		
		btnFollower = (Button) view.findViewById(R.id.btnFollowers);
		btnFollowing = (Button) view.findViewById(R.id.btnFollowing);
		
		
			// SET on click listener
		imgFollow.setOnClickListener(this);
		
		txtAll.setOnClickListener(this);
		txtUploads.setOnClickListener(this);
		txtReposts.setOnClickListener(this);
		
		btnFollower.setOnClickListener(this);
		btnFollowing.setOnClickListener(this);
		
		pictureGridView = (GridView) view.findViewById(R.id.userPicGridView);
		
		userPicAdapter = new UserPictureAdapter(view.getContext(), userPictures);
		
		pictureGridView.setAdapter(userPicAdapter);
		
		return view;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId())
		{
			case R.id.btnFollowers:
			{
				Toast.makeText(getActivity(), "Clicked on button Follower", Toast.LENGTH_SHORT).show();
				Intent intent = new Intent(getActivity(), FollowersActivity.class);
				startActivity(intent);
			}
			break;
			case R.id.btnFollowing:
			{
				Toast.makeText(getActivity(), "Click on button Following", Toast.LENGTH_SHORT).show();
				Intent intent = new Intent(getActivity(), FollowingActivity.class);
				startActivity(intent);
			}
			break;
			case R.id.imgFollow:
			{
				Toast.makeText(getActivity(), "Follow Successful", Toast.LENGTH_SHORT).show();
			}
			break;
			case R.id.txtAll:
			{
				Toast.makeText(getActivity(), "Show All Images", Toast.LENGTH_SHORT).show();
			}
			break;
			case R.id.txtUploads:
			{
				Toast.makeText(getActivity(), "Show Upload Images", Toast.LENGTH_SHORT).show();
			}
			break;
			case R.id.txtReposts:
			{
				Toast.makeText(getActivity(), "Reposts", Toast.LENGTH_SHORT).show();
			}
			break;
			default:
			{
				Toast.makeText(getActivity(), "Nothing", Toast.LENGTH_SHORT).show();
			}
		}
	}


}
