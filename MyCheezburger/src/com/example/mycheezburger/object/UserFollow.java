package com.example.mycheezburger.object;

import android.os.Parcel;
import android.os.Parcelable;

public class UserFollow implements Parcelable{
	
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
		super();
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

	
	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		// TODO Auto-generated method stub
		dest.writeInt(userFollowId);
		dest.writeString(userFollowName);
		dest.writeString(userFollowEdit);
		dest.writeInt(userFollowImgId);
		
		// if myBoolean == true, byte == 1
		dest.writeByte((byte) (isFollowed ? 1 : 0));     
		
	}
	
	public static final Parcelable.Creator<UserFollow> CREATOR = new Parcelable.Creator<UserFollow>() {
		public UserFollow createFromParcel(Parcel in) {
		    return new UserFollow(in);
		}
		
		public UserFollow[] newArray(int size) {
		    return new UserFollow[size];
		}
	};
		
	private UserFollow(Parcel in) {
		this.userFollowId = in.readInt();
		this.userFollowName = in.readString();
		this.userFollowEdit = in.readString();
		this.userFollowImgId = in.readInt();

		// if in.readByte() = 1 => in.readByte() != 0 = true = isFollowed;
		this.isFollowed = in.readByte() != 0;
	}

}
