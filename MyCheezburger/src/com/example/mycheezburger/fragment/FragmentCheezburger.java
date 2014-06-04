package com.example.mycheezburger.fragment;

import java.util.ArrayList;
import java.util.List;

import com.example.mycheezburger.activity.ItemDetailActivity;
import com.example.mycheezburger.adapter.ImagePagerAdapter;
import com.example.mycheezburger.adapter.ItemAdapter2;
import com.example.swipetab.R;
import com.viewpagerindicator.CirclePageIndicator;

import cn.trinea.android.view.autoscrollviewpager.AutoScrollViewPager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

/**
 * A simple {@link android.support.v4.app.Fragment} subclass.
 * 
 */
public class FragmentCheezburger extends Fragment implements OnClickListener{

	GridView itemGridView;
	
	ItemAdapter2 itemAdapter;
	
	String[] itemNames;
	
	private AutoScrollViewPager viewPager;
	private CirclePageIndicator indicator;
	
	private ImageView imgFollow;
	
	public FragmentCheezburger() {
		// Required empty public constructor
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		final View view = inflater.inflate(R.layout.fragment_cheezburger, container, false);
		
		itemNames = getResources().getStringArray(R.array.itemNames);
		
		imgFollow = (ImageView) view.findViewById(R.id.imgFollow);
		imgFollow.setOnClickListener(this);
		
		itemGridView = (GridView) view.findViewById(R.id.itemGridView);
		
		itemAdapter = new ItemAdapter2(view.getContext(), itemNames);
		
		// set adapter, then itemGridView is really to be used
		itemGridView.setAdapter(itemAdapter);
		
		// click on item of GridView
		itemGridView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {
				
				// set information inside bundle
				Bundle bundle = new Bundle();
				bundle.putString("itemName", itemNames[position]);
				
				// create new intent
				Intent intent = new Intent(view.getContext(),ItemDetailActivity.class);
				
				// store bundle and send
				intent.putExtras(bundle);
				startActivity(intent);
			}
		});
		
		viewPager = (AutoScrollViewPager) view.findViewById(R.id.view_pager);
        indicator = (CirclePageIndicator) view.findViewById(R.id.indicator);

        // create list on image
        List<Integer> imageIdList = new ArrayList<Integer>();
        imageIdList.add(R.drawable.banner1);
        imageIdList.add(R.drawable.banner2);
        imageIdList.add(R.drawable.banner3);
        imageIdList.add(R.drawable.banner4);
        viewPager.setAdapter(new ImagePagerAdapter(view.getContext(), imageIdList));
        indicator.setViewPager(viewPager);

        // set time scroll
        viewPager.setInterval(2000);
        
        // start auto scroll
        viewPager.startAutoScroll();
		
		return view;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId())
		{
			case R.id.imgFollow:
			{
				Toast.makeText(v.getContext(), "Follow Successful", Toast.LENGTH_SHORT).show();
			}
			break;
			default:
			{
				Toast.makeText(v.getContext(), "Nothing", Toast.LENGTH_SHORT).show();
			}
		}
	}

}
