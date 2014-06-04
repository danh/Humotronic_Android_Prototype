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
import android.widget.Toast;

public class UserFollowersAdapter extends BaseAdapter implements OnClickListener{

	private Context context;
	private String[] followersName;
	
	TextView txtFollowerName;
	ImageView imgFollow;
	ImageView imgUser;
	
	public UserFollowersAdapter(Context context, String[] followersName) {
		this.context = context;
		this.followersName = followersName;
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
		
		txtFollowerName = (TextView) listView.findViewById(R.id.txtFollowName);
		txtFollowerName.setText(followersName[position]);

		imgUser = (ImageView) listView.findViewById(R.id.imgUser);
		imgUser.setImageResource(R.drawable.user);
		
		imgFollow = (ImageView) listView.findViewById(R.id.imgFollow);
		
//		if (imgFollow.getDrawable() != context.getResources().getDrawable(R.drawable.follow)
//				&& imgFollow.getDrawable() != null) {
//			imgFollow.setImageResource(R.drawable.followed);
//		}
//		
//		if (imgFollow.getDrawable() == null)
//		{
//			imgFollow.setImageResource(R.drawable.follow);
//		}
		
		imgFollow = (ImageView) listView.findViewById(R.id.imgFollow);
		imgFollow.setImageResource(R.drawable.follow);
		
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
				imgFollow.setImageResource(R.drawable.followed);
				Toast.makeText(context, "Follow Successful", Toast.LENGTH_SHORT).show();
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
		return followersName.length;
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

}
