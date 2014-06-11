package com.example.mycheezburger.fragment;

import com.example.mycheezburger.adapter.UserPictureAdapter;
import com.example.swipetab.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

/**
 * A simple {@link android.support.v4.app.Fragment} subclass.
 * 
 */
public class FragmentUserAllPicture extends Fragment {

	GridView pictureGridView;
	
	UserPictureAdapter userPicAdapter;
	
	String[] userPictures;
	
	public FragmentUserAllPicture() {
		// Required empty public constructor
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		View view = inflater.inflate(R.layout.fragment_user_all_picture,
				container, false);
		
		userPictures = getResources().getStringArray(R.array.itemNames);
		
		pictureGridView = (GridView) view.findViewById(R.id.userAllPictureGridView);
		
		userPicAdapter = new UserPictureAdapter(view.getContext(), userPictures);
		
		pictureGridView.setAdapter(userPicAdapter);		
		
		return view;
	}

}
