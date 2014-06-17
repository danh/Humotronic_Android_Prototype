package com.example.mycheezburger.adapter;

import java.util.ArrayList;
import java.util.List;

import com.example.mycheezburger.database.UserFollowDatabaseHelper;
import com.example.mycheezburger.object.UserFollow;
import com.example.mycheezburger.object.UserFollowTag;
import com.example.swipetab.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class UserFollowersAdapter extends ArrayAdapter<UserFollow> implements OnClickListener{

	private Context context;
	
	List<UserFollow> userFollows = new ArrayList<UserFollow>();
	
	TextView txtFollowerName;
	TextView txtFollowerEdit;
	ImageView imgFollow;
	ImageView imgUser;
	
	UserFollowDatabaseHelper userFollowersHelper;
	
	UserFollowTag imgFollowTag;
	
	public UserFollowersAdapter(Context context, List<UserFollow> userFollows) {
		super(context, 0,userFollows);
		this.context = context;
		this.userFollows = userFollows;
	}
	
	@Override
	public View getView(int position, View view, ViewGroup viewGroup) {
		// TODO Auto-generated method stub
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
		View listView;
		
		if (view == null) {
			listView = new View(context);
			
			// SET item on grid view one by one
			listView = inflater.inflate(R.layout.layout_single_user_follow, viewGroup, false);
			
		} else {
			listView = (View) view;
		}
		
		// Database
		userFollowersHelper = new UserFollowDatabaseHelper(context);

		imgUser = (ImageView) listView.findViewById(R.id.imgUser);
		imgUser.setImageResource(userFollows.get(position).getImgId());
			
		txtFollowerName = (TextView) listView.findViewById(R.id.txtFollowName);
		txtFollowerName.setText(userFollows.get(position).getName());
		
		txtFollowerEdit = (TextView) listView.findViewById(R.id.txtFollowEdit);
		txtFollowerEdit.setText(userFollows.get(position).getEdit());
		
		imgFollow = (ImageView) listView.findViewById(R.id.imgFollow);
		// Position = 0		:	User ID = 1 => TAG = 1
		// Position = 1		:	User ID = 2 => TAG = 2
		// ...
		imgFollowTag = new UserFollowTag();
		imgFollowTag.setListviewPosition(position);
		imgFollowTag.setDatabasePosition(userFollows.get(position).getId());
		
		imgFollow.setTag(imgFollowTag);

		if (userFollows.get(position).getIsFollowed() == false) {
			imgFollow.setImageResource(R.drawable.follow);
			
		} else {
			imgFollow.setImageResource(R.drawable.followed);
		}

		

		imgFollow.setOnClickListener(this);
		
		return listView;
	}
	
	// SET Title of action bar
	
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId())
		{
			case R.id.imgFollow:
			{
				imgFollow = (ImageView) v.findViewById(R.id.imgFollow);
				
				// if user is followed, unfollow
				imgFollowTag = (UserFollowTag) imgFollow.getTag();
				
				int databasePosition = imgFollowTag.getDatabasePosition();
				int listViewPosition = imgFollowTag.getListviewPosition();

				if (userFollows.get(listViewPosition).getIsFollowed() == true) {
					
					imgFollow.setImageResource(R.drawable.follow);
					userFollows.get(listViewPosition).setIsFollowed(false);
					
					// update in database
					userFollowersHelper.updateFollowed(
											String.valueOf(databasePosition),
											"true",
											"false");
					
					// show notification
					Toast.makeText(context, 
							"Unfollow " + userFollows.get(listViewPosition).getName() + " Successful", 
							Toast.LENGTH_SHORT).show();
					
				} else {
					// if user is not followed, allow user to be followed
					// set Is followed = true
					imgFollow.setImageResource(R.drawable.followed);
					userFollows.get(listViewPosition).setIsFollowed(true);
					
					// update in database
					userFollowersHelper.updateFollowed(
											String.valueOf(databasePosition),
											"false",
											"true");
					
					// show notification
					Toast.makeText(context, 
							"Follow " + userFollows.get(listViewPosition).getName() + " Successful", 
							Toast.LENGTH_SHORT).show();
				}
			}
			break;
			default:
			{
				Toast.makeText(context, "Notthing", Toast.LENGTH_SHORT).show();
			}
		}
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return userFollows.size();
	}

	@Override
	public UserFollow getItem(int position) {
		// TODO Auto-generated method stub
		return userFollows.get(position);
	}

	@Override
	public long getItemId(int i) {
		// TODO Auto-generated method stub
		return i;
	}

}
