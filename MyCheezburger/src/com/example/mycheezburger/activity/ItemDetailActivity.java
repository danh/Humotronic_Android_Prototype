package com.example.mycheezburger.activity;

import com.example.swipetab.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ItemDetailActivity extends Activity implements OnClickListener{

	String itemName;
	
	TextView itemText;
	TextView repostText;
	TextView likeText;
	TextView dislikeText;
	TextView editText;
	
	ImageView repostImg;
	ImageView likeImg;
	ImageView disliketImg;
	ImageView editImg;
	
	ImageView followImg;
	ImageView shareImg;
	
	int currentLike = 0;
	int currentDislike = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_item_detail);
		
		Bundle bundle = getIntent().getExtras();
		itemName = bundle.getString("itemName", "No information");
		
		// SET ID
		itemText = (TextView) findViewById(R.id.txtItemName);
		repostText = (TextView) findViewById(R.id.txtRepost);
		likeText = (TextView) findViewById(R.id.txtLike);
		dislikeText = (TextView) findViewById(R.id.txtDislike);
		editText = (TextView) findViewById(R.id.txtEdit);
		
		repostImg = (ImageView) findViewById(R.id.imgRepost);
		likeImg = (ImageView) findViewById(R.id.imgLike);
		disliketImg = (ImageView) findViewById(R.id.imgDislike);
		editImg = (ImageView) findViewById(R.id.imgEdit);
		
		followImg = (ImageView) findViewById(R.id.imgFollow);
		shareImg = (ImageView) findViewById(R.id.imgShare);
		
		// SET first number
		itemText.setText(itemName);
		likeText.setText(String.valueOf(currentLike));
		dislikeText.setText(String.valueOf(currentDislike));

		// SET on click listener
		repostImg.setOnClickListener(this);
		likeImg.setOnClickListener(this);
		disliketImg.setOnClickListener(this);
		editImg.setOnClickListener(this);
		
		followImg.setOnClickListener(this);
		shareImg.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId())
		{
			case R.id.imgRepost:
			{
				Toast.makeText(this, "Repost successful", Toast.LENGTH_SHORT).show();
			}
			break;
			case R.id.imgLike:
			{
				++currentLike;
				likeText.setText(String.valueOf(currentLike));
			}
			break;
			case R.id.imgDislike:
			{
				++currentDislike;
				dislikeText.setText(String.valueOf(currentDislike));
			}
			break;
			case R.id.imgEdit:
			{
				Toast.makeText(this, "Edit successful", Toast.LENGTH_SHORT).show();
			}
			break;
			case R.id.imgFollow:
			{
				Toast.makeText(this, "Follow successful", Toast.LENGTH_SHORT).show();
			}
			break;
			case R.id.imgShare:
			{
				Toast.makeText(this, "Share successful", Toast.LENGTH_SHORT).show();
			}
			break;
		}
	}
}
