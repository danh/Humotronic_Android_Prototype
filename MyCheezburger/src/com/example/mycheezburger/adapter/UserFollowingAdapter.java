package com.example.mycheezburger.adapter;

import java.util.ArrayList;
import java.util.List;

import com.example.mycheezburger.database.UserFollowDatabaseHelper;
import com.example.mycheezburger.object.UserFollow;
import com.example.mycheezburger.object.UserFollowTag;
import com.example.swipetab.R;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class UserFollowingAdapter extends BaseAdapter implements OnClickListener{

	private Context context;

	List<UserFollow> userFollows = new ArrayList<UserFollow>();
	int numberOfFollowing = 0;
	
	TextView txtFollowingName;
	TextView txtFollowingEdit;
	ImageView imgFollow;
	ImageView imgUser;
	
	UserFollowDatabaseHelper UserFollowingHelper;
	
	UserFollowTag imgFollowTag;
	
	public UserFollowingAdapter(Context context, List<UserFollow> userFollows) {
		// TODO Auto-generated constructor stub
		this.context = context;
		this.userFollows = userFollows;
		this.numberOfFollowing = userFollows.size();
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
			listView = inflater.inflate(R.layout.layout_single_user_follow, null);

			
		} else {
			listView = (View) view;
		}
		
		// Database
		UserFollowingHelper = new UserFollowDatabaseHelper(context);
		
		imgUser = (ImageView) listView.findViewById(R.id.imgUser);
		imgUser.setImageResource(userFollows.get(position).getImgId());
		
		txtFollowingName = (TextView) listView.findViewById(R.id.txtFollowName);
		txtFollowingName.setText(userFollows.get(position).getName());
		
		txtFollowingEdit = (TextView) listView.findViewById(R.id.txtFollowEdit);
		txtFollowingEdit.setText(userFollows.get(position).getEdit());
		
		imgFollow = (ImageView) listView.findViewById(R.id.imgFollow);
		// Position = 0		:	User ID = 1 => TAG = 1
		// Position = 1		:	User ID = 2 => TAG = 2
		// ...
		
		imgFollowTag = new UserFollowTag();
		imgFollowTag.setListviewPosition(position);
		imgFollowTag.setDatabasePosition(userFollows.get(position).getId());
		
		imgFollow.setTag(imgFollowTag);

		if (userFollows.get(position).getIsFollowed() == true) {
			imgFollow.setImageResource(R.drawable.followed);
			
		} else {
			imgFollow.setImageResource(R.drawable.follow);
		}
		
		imgFollow.setOnClickListener(this);
		
		return listView;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return userFollows.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

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
					
					// update in database
					UserFollowingHelper.updateFollowed(
											String.valueOf(databasePosition),
											"true",
											"false");
					// user is not followed
					userFollows.get(listViewPosition).setIsFollowed(false);
					
					// update number of follower
					--numberOfFollowing;
					
					// show notification
					Toast.makeText(context, 
							"Unfollow " + userFollows.get(listViewPosition).getName() + " Successful", 
							Toast.LENGTH_SHORT).show();
					
				} else {
					// if user is not followed, allow user to be followed
						// set Is followed = true
					imgFollow.setImageResource(R.drawable.followed);
					
					// update in database
					UserFollowingHelper.updateFollowed(
											String.valueOf(databasePosition),
											"false",
											"true");
					
					// user is followed
					userFollows.get(listViewPosition).setIsFollowed(true);
					
					// update number of follower
					++numberOfFollowing;
					
					// show notification
					Toast.makeText(context, 
							"Follow " + userFollows.get(listViewPosition).getName() + " Successful", 
							Toast.LENGTH_SHORT).show();
				}
				
				ActionBar userFollowingActionbar =  ((Activity) v.getContext()).getActionBar();
				userFollowingActionbar.setTitle("FOLLOWING (" + String.valueOf(numberOfFollowing) + ")");
			}
			break;
			default:
			{
				Toast.makeText(context, "Notthing", Toast.LENGTH_SHORT).show();
			}
		}
	}
}
