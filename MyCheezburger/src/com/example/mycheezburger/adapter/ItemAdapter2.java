package com.example.mycheezburger.adapter;

import com.example.swipetab.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ItemAdapter2 extends BaseAdapter{
	private Context context;
	private String[] itemValue;
	
	public ItemAdapter2(Context context, String[] itemValue) {
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
			gridView = inflater.inflate(R.layout.layout_single_item2, null);
			
		} else {
			gridView = (View) view;
		}
		
		TextView itemName = (TextView) gridView.findViewById(R.id.txtSingleItemName2);
		itemName.setText(itemValue[position]);

		ImageView imageView = (ImageView) gridView.findViewById(R.id.imgSingleItem2);
		imageView.setImageResource(R.drawable.item2);
		
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
}
