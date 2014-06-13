package com.example.mycheezburger.adapter;

import com.example.swipetab.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;


public class UserPictureAdapter extends BaseAdapter{

	private Context context;
	private String[] itemValue;
	
	public UserPictureAdapter(Context context, String[] itemValue) {
		this.context = context;
		this.itemValue = itemValue;
	}
	
	@Override
	public View getView(int position, View view, ViewGroup viewGroup) {
		// TODO Auto-generated method stub
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
		View mView;
		
		if (view == null) {
			mView = new View(context);
			
			// SET item on grid view one by one
			mView = inflater.inflate(R.layout.layout_single_user_picture, null);

		} else {
			mView = (View) view;
		}
		
		ImageView imageView = (ImageView) mView.findViewById(R.id.imgSingleUserPic);
		imageView.setImageResource(R.drawable.item2);
		
		return mView;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return itemValue.length;
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
