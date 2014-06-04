package com.example.mycheezburger.adapter;

import com.example.swipetab.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class UserFollowingAdapter extends BaseAdapter implements OnClickListener{

	private Context context;
	private String[] followingName;
	
	TextView txtFollowingName;
	ImageView imgFollow;
	ImageView imgUser;
	
	public UserFollowingAdapter(Context context, String[] followingName) {
		// TODO Auto-generated constructor stub
		this.context = context;
		this.followingName = followingName;
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
		
		txtFollowingName = (TextView) listView.findViewById(R.id.txtFollowName);
		txtFollowingName.setText(followingName[position]);

		imgUser = (ImageView) listView.findViewById(R.id.imgUser);
		imgUser.setImageResource(R.drawable.user);
		
		imgFollow = (ImageView) listView.findViewById(R.id.imgFollow);
		imgFollow.setImageResource(R.drawable.followed);
		
		return listView;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return followingName.length;
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
		
	}

	

}
