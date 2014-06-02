package com.example.swipetab;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class UserProfileActivity extends Activity implements OnClickListener{

	GridView pictureGridView;
	
	UserPictureAdapter userPicAdapter;
	
	String[] userPictures;
	
	ImageView imgFollow;
	
	TextView txtAll;
	TextView txtUploads;
	TextView txtReposts;
	
	Button btnFollower;
	Button btnFollowing;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_user_profile);
		
		userPictures = getResources().getStringArray(R.array.itemNames);
		
		imgFollow = (ImageView) findViewById(R.id.imgFollow);
		txtAll = (TextView) findViewById(R.id.txtAll);
		txtUploads = (TextView) findViewById(R.id.txtUploads);
		txtReposts = (TextView) findViewById(R.id.txtReposts);
		
		btnFollower = (Button) findViewById(R.id.btnFollowers);
		btnFollowing = (Button) findViewById(R.id.btnFollowing);
		
		
			// SET on click listener
		imgFollow.setOnClickListener(this);
		
		txtAll.setOnClickListener(this);
		txtUploads.setOnClickListener(this);
		txtReposts.setOnClickListener(this);
		
		btnFollower.setOnClickListener(this);
		btnFollowing.setOnClickListener(this);
		
		pictureGridView = (GridView) findViewById(R.id.userPicGridView);
		
		userPicAdapter = new UserPictureAdapter(this, userPictures);
		
		pictureGridView.setAdapter(userPicAdapter);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId())
		{
			case R.id.btnFollowers:
			{
				Toast.makeText(UserProfileActivity.this, "Clicked on button Follower", Toast.LENGTH_SHORT).show();
			}
			break;
			case R.id.btnFollowing:
			{
				Toast.makeText(UserProfileActivity.this, "Click on button Following", Toast.LENGTH_SHORT).show();
			}
			break;
			case R.id.imgFollow:
			{
				Toast.makeText(UserProfileActivity.this, "Follow Successful", Toast.LENGTH_SHORT).show();
			}
			break;
			case R.id.txtAll:
			{
				Toast.makeText(UserProfileActivity.this, "Show All Images", Toast.LENGTH_SHORT).show();
			}
			break;
			case R.id.txtUploads:
			{
				Toast.makeText(UserProfileActivity.this, "Show Upload Images", Toast.LENGTH_SHORT).show();
			}
			break;
			case R.id.txtReposts:
			{
				Toast.makeText(UserProfileActivity.this, "Reposts", Toast.LENGTH_SHORT).show();
			}
			break;
			default:
			{
				Toast.makeText(UserProfileActivity.this, "Nothing", Toast.LENGTH_SHORT).show();
			}
		}
	}
}
