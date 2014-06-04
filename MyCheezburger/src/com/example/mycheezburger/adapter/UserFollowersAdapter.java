package com.example.mycheezburger.adapter;

import java.util.ArrayList;
import java.util.List;

import com.example.mycheezburger.object.UserFollow;
import com.example.swipetab.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class UserFollowersAdapter extends BaseAdapter implements OnClickListener{

	private Context context;
//	private String[] followersName;
	
	List<UserFollow> userFollows = new ArrayList<UserFollow>();
	
	TextView txtFollowerName;
	TextView txtFollowerEdit;
	ImageView imgFollow;
	ImageView imgUser;
	
	public UserFollowersAdapter(Context context, String[] followersName) {
		this.context = context;
//		this.followersName = followersName;
		
		// Set userFollows list
		UserFollow userFollow;
		
		for (int i = 0; i < followersName.length; ++i) {
			userFollow = new UserFollow(i, followersName[i], "Edit", R.drawable.user, false);
						
			userFollows.add(userFollow);
		}
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

		imgUser = (ImageView) listView.findViewById(R.id.imgUser);
//		imgUser.setImageResource(R.drawable.user);
		imgUser.setImageResource(userFollows.get(position).getImgId());
		
		txtFollowerName = (TextView) listView.findViewById(R.id.txtFollowName);
//		txtFollowerName.setText(followersName[position]);
		txtFollowerName.setText(userFollows.get(position).getName());
		
		txtFollowerEdit = (TextView) listView.findViewById(R.id.txtFollowEdit);
		txtFollowerEdit.setText(userFollows.get(position).getEdit());
		
		imgFollow = (ImageView) listView.findViewById(R.id.imgFollow);
		imgFollow.setTag(userFollows.get(position).getId());
//		imgFollow.setImageResource(R.drawable.follow);
		if (userFollows.get(position).getIsFollowed() == false) {
			imgFollow.setImageResource(R.drawable.follow);
			
		} else {
			imgFollow.setImageResource(R.drawable.followed);
		}

		

		imgFollow.setOnClickListener(this);
		
		return listView;
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
				if (userFollows.get((int)imgFollow.getTag()).getIsFollowed() == true) {
					imgFollow.setImageResource(R.drawable.follow);
					userFollows.get((int)imgFollow.getTag()).setIsFollowed(false);
					Toast.makeText(context, "Unfollow Successful", Toast.LENGTH_SHORT).show();
					
				} else {
					// if user is not followed, allow user to be followed
					// set Is followed = true
					imgFollow.setImageResource(R.drawable.followed);
					userFollows.get((int)imgFollow.getTag()).setIsFollowed(true);
					Toast.makeText(context, "Follow Successful", Toast.LENGTH_SHORT).show();
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
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return userFollows.get(position);
	}

	@Override
	public long getItemId(int i) {
		// TODO Auto-generated method stub
		return i;
	}

}
