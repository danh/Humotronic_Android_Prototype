package com.example.mycheezburger.object;

public class UserFollow {
	
	private int userFollowId;
	private String userFollowName;
	private String userFollowEdit;
	private int userFollowImgId;
	// true: green picture
	// false: orange picture 
	private boolean isFollowed;
	
	public UserFollow(
			int userFollowId, 
			String userFollowName, 
			String userFollowEdit, 
			int userFollowImgId, 
			boolean isFollowed) {
		// TODO Auto-generated constructor stub
		this.userFollowId = userFollowId;
		this.userFollowName = userFollowName;
		this.userFollowEdit = userFollowEdit;
		this.userFollowImgId = userFollowImgId;
		this.isFollowed = isFollowed;
	}
	
	// SET
	public void setId(int userFollowId) {
		this.userFollowId = userFollowId;
	}
	
	public void setName(String userFollowName) {
		this.userFollowName = userFollowName;
	}
	
	public void setEdit(String userFollowEdit) {
		this.userFollowEdit = userFollowEdit;
	}
	
	public void setImgId(int userFollowImgId) {
		this.userFollowImgId = userFollowImgId;
	}
	
	public void setIsFollowed(boolean isFollowed) {
		this.isFollowed = isFollowed;
	}
	
	// GET
	public int getId() {
		return this.userFollowId;
	}
	
	public String getName() {
		return this.userFollowName;
	}
	
	public String getEdit() {
		return this.userFollowEdit;
	}
	
	public int getImgId() {
		return this.userFollowImgId;
	}
	
	public boolean getIsFollowed() {
		return this.isFollowed;
	}

}
