package com.example.mycheezburger.database;

import java.util.ArrayList;
import java.util.List;

import com.example.mycheezburger.object.UserFollow;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class UserFollowDatabaseHelper{

	UserFollowHelper helper;
	public UserFollowDatabaseHelper(Context context) {
		helper = new UserFollowHelper(context);
	}
	
	public long insertData(String name, String edit, String imgId, String isFollowed) {
		SQLiteDatabase db = helper.getWritableDatabase();
		ContentValues contentValues = new ContentValues();
		
		contentValues.put(UserFollowHelper.NAME, name);
		contentValues.put(UserFollowHelper.EDIT, edit);
		contentValues.put(UserFollowHelper.IMGID, imgId);
		contentValues.put(UserFollowHelper.ISFOLLOWED, isFollowed);
		
		long id = db.insert(UserFollowHelper.TABLE_NAME, null, contentValues);
		return id;
	}
	
	public List<UserFollow> getAllData() {
		SQLiteDatabase db = helper.getWritableDatabase();
		
		String[] columns = {
						UserFollowHelper.UID,
						UserFollowHelper.NAME,
						UserFollowHelper.EDIT,
						UserFollowHelper.IMGID,
						UserFollowHelper.ISFOLLOWED };
		Cursor cursor = db.query(UserFollowHelper.TABLE_NAME, columns, null, null, null, null, null);

		List<UserFollow> userFollow = new ArrayList<UserFollow>();
		UserFollow user;
		
		while(cursor.moveToNext()) {
			int cid = cursor.getInt(0);
			String strName = cursor.getString(1);
			String StrEdit = cursor.getString(2);
			String StrImgId = cursor.getString(3);
			String StrIsFollowed = cursor.getString(4);
			
			int intImgId = Integer.parseInt(StrImgId);
			boolean IsFollowed = false;
			if (StrIsFollowed.equalsIgnoreCase("true")) {
				IsFollowed = true;
			}
			
			user = new UserFollow(cid, strName, StrEdit, intImgId, IsFollowed);
			userFollow.add(user);
		}
		return userFollow;
	}
	
	public List<UserFollow> getData(int begin, int end) {
		SQLiteDatabase db = helper.getWritableDatabase();
		
		String[] columns = {
						UserFollowHelper.UID,
						UserFollowHelper.NAME,
						UserFollowHelper.EDIT,
						UserFollowHelper.IMGID,
						UserFollowHelper.ISFOLLOWED };
		Cursor cursor = db.query(UserFollowHelper.TABLE_NAME, columns, null, null, null, null, null);

		List<UserFollow> userFollow = new ArrayList<UserFollow>();
		UserFollow user;
			// set cursor to begin of sub string
		cursor.moveToPosition(begin);
			// get followers information
		for (int i = begin; i < end; ++i) {
			if (cursor != null) {
				int cid = cursor.getInt(0);
				String strName = cursor.getString(1);
				String StrEdit = cursor.getString(2);
				String StrImgId = cursor.getString(3);
				String StrIsFollowed = cursor.getString(4);
				
				int intImgId = Integer.parseInt(StrImgId);
				boolean IsFollowed = false;
				if (StrIsFollowed.equalsIgnoreCase("true")) {
					IsFollowed = true;
				}
				
				user = new UserFollow(cid, strName, StrEdit, intImgId, IsFollowed);
				userFollow.add(user);
					// move to the next user follower
				cursor.moveToNext();
			} else {
				break;
			}
			
		}
		
		return userFollow;
	}
	
	public List<UserFollow> getFollowingData() {
		SQLiteDatabase db = helper.getWritableDatabase();
		
		String[] columns = {
						UserFollowHelper.UID,
						UserFollowHelper.NAME,
						UserFollowHelper.EDIT,
						UserFollowHelper.IMGID,
						UserFollowHelper.ISFOLLOWED };
		String[] whereArgs={"true"};
		Cursor cursor = db.query(UserFollowHelper.TABLE_NAME, columns, UserFollowHelper.ISFOLLOWED + " =?", whereArgs, null, null, null);

		List<UserFollow> userFollow = new ArrayList<UserFollow>();
		UserFollow user;
		
		while(cursor.moveToNext()) {
			int cid = cursor.getInt(0);
			String strName = cursor.getString(1);
			String StrEdit = cursor.getString(2);
			String StrImgId = cursor.getString(3);
			String StrIsFollowed = cursor.getString(4);
			
			int intImgId = Integer.parseInt(StrImgId);
			boolean IsFollowed = false;
			if (StrIsFollowed.equalsIgnoreCase("true")) {
				IsFollowed = true;
			}
			
			user = new UserFollow(cid, strName, StrEdit, intImgId, IsFollowed);
			userFollow.add(user);
		}
		return userFollow;
	}

	
	public String getData(String name) {
		SQLiteDatabase db = helper.getWritableDatabase();
		
		// only select name and password
		String[] columns = {
						UserFollowHelper.NAME,
						UserFollowHelper.EDIT };
		
		
		Cursor cursor = db.query(UserFollowHelper.TABLE_NAME, columns, UserFollowHelper.NAME + " = '"+name+"'", 
				null, null, null, null);
		
		StringBuffer buffer = new StringBuffer();
		
		while(cursor.moveToNext()) {
			int index1 = cursor.getColumnIndex(UserFollowHelper.NAME);
			int index2 = cursor.getColumnIndex(UserFollowHelper.EDIT);
			String personName = cursor.getString(index1);
			String password = cursor.getString(index2);
			buffer.append(personName + " " + password + "\n");
		}
		return buffer.toString();
	}
	
	public int updateFollowed(String ID, String oldFollow, String newFollow) {
		
		SQLiteDatabase db = helper.getWritableDatabase();
		ContentValues contentValues = new ContentValues();
		contentValues.put(UserFollowHelper.ISFOLLOWED, newFollow);
		String[] whereArgs={oldFollow};
		int count = db.update(UserFollowHelper.TABLE_NAME,  contentValues, UserFollowHelper.ISFOLLOWED+" =? AND " + UserFollowHelper.UID + " = " + ID, whereArgs);
		return count;
	}
	
	public int deleteRow() {
		SQLiteDatabase db = helper.getWritableDatabase();
		String[] whereArgs = {"1234"};
		int count = db.delete(UserFollowHelper.TABLE_NAME, UserFollowHelper.NAME+ "=?", whereArgs);
		return count;
	}
	
	public int getCount() {
		String countQuery = "SELECT * FROM " + UserFollowHelper.TABLE_NAME;
		SQLiteDatabase db = helper.getWritableDatabase();
		Cursor cursor = db.rawQuery(countQuery, null);
		
		int r = cursor.getCount();
		cursor.close();
		return r;
	}
	
	static class UserFollowHelper extends SQLiteOpenHelper {
		private static final String DATABASE_NAME = "USER_FOLLOW";
		private static final String TABLE_NAME = "FOLLOWERS";
		private static final int DATABASE_VERSION = 11;
		private static final String UID = "Id";
		private static final String NAME = "Name";
		private static final String EDIT = "Edit";
		private static final String IMGID = "ImageID";
		private static final String ISFOLLOWED = "Followed";
		
		private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME 
				+ " (" + UID + " INTEGER PRIMARY KEY AUTOINCREMENT, " 
				+ NAME + " VARCHAR(255), "
				+ EDIT + " VARCHAR(255), "
				+ IMGID + " VARCHAR(255), "
				+ ISFOLLOWED + " VARCHAR(255));";
		private static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
		
		private Context context;
		
		public UserFollowHelper(Context context) {
			// TODO Auto-generated constructor stub
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
			this.context = context;
			Log.v("Constructor","Constructor");
		}
		
		@Override
		public void onCreate(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			try {
				db.execSQL(CREATE_TABLE);
				Log.v("onCreate","Create successful");
			} catch (Exception e) {
				Log.v("onCreate","Error");
			}
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub
			try {
				Log.v("onUpgrade","onUpgrade Successful");
				db.execSQL(DROP_TABLE);
				onCreate(db);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				Log.v("onUpgrade","Error");
			}
		}
	}

}
