package com.example.mycheezburger.endlesslistview;

import java.util.List;

import com.example.mycheezburger.adapter.UserFollowingAdapter;
import com.example.mycheezburger.object.UserFollow;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.AbsListView.OnScrollListener;

public class UserFollowingEndlessListview extends ListView implements OnScrollListener{

	private View footer;
	private boolean isLoading;
	private EndlessListener listener;
	private UserFollowingAdapter adapter;
	private int totalNumberOfFollowing;
	
	// CONSTRUCTOR ---------------------------------------------------------------------------
		public UserFollowingEndlessListview(Context context, AttributeSet attrs, int defStyle) {
			super(context, attrs, defStyle);	
			this.setOnScrollListener(this);
		}

		public UserFollowingEndlessListview(Context context, AttributeSet attrs) {
			super(context, attrs);
			this.setOnScrollListener(this);
		}
		
		public UserFollowingEndlessListview(Context context) {
			super(context);
			this.setOnScrollListener(this);
		}
	
		
	// OnScrollListener FUNCTIONS -------------------------------------------------------------
	@Override
	public void onScroll(AbsListView view, int firstVisibleItem,
			int visibleItemCount, int totalItemCount) {
		// TODO Auto-generated method stub
		if (getAdapter() == null)
			return ;
		
		if (getAdapter().getCount() == 0)
			return ;
		
		int l = visibleItemCount + firstVisibleItem;
		if (l >= totalItemCount && !isLoading && totalItemCount < totalNumberOfFollowing) {
			// It is time to add new data. We call the listener
			this.addFooterView(footer);
			isLoading = true;
			listener.loadData();
		}
	}

	@Override
	public void onScrollStateChanged(AbsListView view, int scrollState) {
		// TODO Auto-generated method stub
		
	}
	
	// SET GET functions ------------------------------------------------------------------
	public void setTotalNumberOfFollowing(int totalNumberOfFollowing) {
		this.totalNumberOfFollowing = totalNumberOfFollowing;
	}
	
	public void setListener(EndlessListener listener) {
		this.listener = listener;
	}
	
	public void setLoadingView(int resId) {
		LayoutInflater inflater = (LayoutInflater) super.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		footer = (View) inflater.inflate(resId, null);
		this.addFooterView(footer);
		
	}
	
	public void setAdapter(UserFollowingAdapter adapter) {		
		super.setAdapter(adapter);
		this.adapter = adapter;
		this.removeFooterView(footer);
	}
	
	// ADD Data ----------------------------------------------------------------------------
	public void addNewData(List<UserFollow> data) {
		
		this.removeFooterView(footer);
		
		adapter.addAll(data);
		adapter.notifyDataSetChanged();
		isLoading = false;
	}
	
	public EndlessListener setListener() {
		return listener;
	}

	public static interface EndlessListener {
		public void loadData() ;
	}

}
