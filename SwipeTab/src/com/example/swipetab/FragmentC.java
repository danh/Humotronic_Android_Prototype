package com.example.swipetab;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.AdapterView.OnItemClickListener;

/**
 * A simple {@link android.support.v4.app.Fragment} subclass.
 * 
 */
public class FragmentC extends Fragment {

	GridView itemGridView;
	
	ItemAdapter2 itemAdapter;
	
	String[] itemNames;
	
	public FragmentC() {
		// Required empty public constructor
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		
		final View view = inflater.inflate(R.layout.fragment_c, container, false);
		
		itemNames = getResources().getStringArray(R.array.itemNames);
		
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
		
		return view;
	}

}
