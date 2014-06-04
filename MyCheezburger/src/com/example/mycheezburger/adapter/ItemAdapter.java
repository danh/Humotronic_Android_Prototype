package com.example.mycheezburger.adapter;

import com.example.mycheezburger.activity.UserProfileActivity;
import com.example.swipetab.R;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ItemAdapter extends BaseAdapter implements OnClickListener{

	private Context context;
	private String[] itemValue;
	
	public ItemAdapter(Context context, String[] itemValue) {
		this.context = context;
		this.itemValue = itemValue;
	}
	
	@Override
	public View getView(int position, View view, ViewGroup viewGroup) {
		// TODO Auto-generated method stub
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
		View gridView;
		
		if (view == null) {
			gridView = new View(context);
			
			// SET item on grid view one by one
			gridView = inflater.inflate(R.layout.layout_single_item1, null);

			
		} else {
			gridView = (View) view;
		}
		
		TextView itemName = (TextView) gridView.findViewById(R.id.txtSingleItemName1);
		itemName.setText(itemValue[position]);

		ImageView imageView = (ImageView) gridView.findViewById(R.id.imgSingleItem1);
		imageView.setImageResource(R.drawable.item2);
		
		ImageView userView = (ImageView) gridView.findViewById(R.id.imgUserSingleItem1);
		userView.setImageResource(R.drawable.user);
		userView.setOnClickListener(this);
		
		return gridView;
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

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId())
		{
			case R.id.imgUserSingleItem1:
			{
				Toast.makeText(v.getContext(), "User Profile", Toast.LENGTH_SHORT).show();
				// move to user profile
				Intent intent = new Intent(v.getContext(),UserProfileActivity.class);
				v.getContext().startActivity(intent);
				
			}
			break;
			default:
			{
				Toast.makeText(v.getContext(), "Nothing", Toast.LENGTH_SHORT).show();
			}
		}
	}

}
