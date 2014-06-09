package com.example.mycheezburger.object;

public class UserFollowTag {
	private int listviewPosition;
	private int datavasePosition;
	
	public UserFollowTag() {
		listviewPosition = 0;
		datavasePosition = 0;
	}
	
	// SET
	public void setListviewPosition(int listviewPosition) {
		this.listviewPosition = listviewPosition;
	}
	public void setDatabasePosition(int databasePosition) {
		this.datavasePosition = databasePosition;
	}
	
	// GET
	public int getListviewPosition() {
		return this.listviewPosition;
	}
	public int getDatabasePosition() {
		return this.datavasePosition;
	}
}
