package com.example.mobiletheftsecurity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDataBase {
	
	SQLiteDatabase sdb;
    MyHelper mh;
    
    
    public MyDataBase(Context con)
    {
    	mh=new MyHelper(con,"contacts", null,1);
    }
    
    public void open() 
    {
         sdb=mh.getWritableDatabase();
	}
    public void insertdata(String n, String m) 
    {
        ContentValues cv=new ContentValues();
        cv.put("num",n);
        cv.put("email",m);
        sdb.insert("contacts", null,cv);
	}
    public Cursor retrieveData() 
    {
       Cursor c=sdb.query("contacts", null,null,null,null,null,null);
	   return c;
    }
	public void updateInfo(int pos,String n,String m){
		ContentValues cv=new ContentValues();
		cv.put("num",n);
		cv.put("email",m);
		sdb.update("contacts",cv,"_id="+pos, null);

	}

	public void deleteInfo(int pos){

		//Log.d("B36","Deleted Pos is "+pos);
		sdb.delete("contacts","_id="+pos, null);

	}

	public void close(){
		sdb.close();

	}

	class MyHelper extends SQLiteOpenHelper
	{

		public MyHelper(Context context, String name, CursorFactory factory,
				int version) {
			super(context, name, factory, version);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			db.execSQL("create table contacts(_id integer primary key," +
					"num text,email text);");
			
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub
			
			
		}
		
	}

}
