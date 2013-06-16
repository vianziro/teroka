package com.tanyoo.teroka.lib;


import java.util.ArrayList;
import java.util.Vector;


import util.DataListSenjata;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DbTeroka {
	
	public static class DataPemain{
		public String nama;
		public String level;
		public String j_bintang;
		public String j_step;
		public String j_kalori;
		public String max_step;
		public String now_armor;
		public int id;
	}

	//public static class 
	
	private SQLiteDatabase db;
	private final Context con;
	private final RelasiOpenHelper dbHelper;
	
	public DbTeroka(Context c){
		
		con = c;
		dbHelper = new RelasiOpenHelper(con,"", null, 0);
	}
	
	public void open(){
		db = dbHelper.getWritableDatabase();
	}
	
	public void close(){
		
		db.close();
	}
	
	public long insertPemain(String nama, String level, String j_bintang,  String j_step,  String j_kalori,  String max_step,  String now_armor){
		ContentValues newValues = new ContentValues();
		newValues.put("NAMA", nama);
		newValues.put("LEVEL", level);
		newValues.put("J_BINTANG", j_bintang);
		newValues.put("J_STEP", j_step);
		newValues.put("J_KALORI", j_kalori);
		newValues.put("MAX_STEP", max_step);
		newValues.put("NOW_ARMOR", now_armor);
		
		return db.insert("DATA_PEMAIN", null, newValues);
	}
	
	public long insertSenjata(String nama_senjata, String status, String harga,  String syarat_step){
		ContentValues newValues = new ContentValues();
		newValues.put("NAMA_SENJATA", nama_senjata);
		newValues.put("STATUS", status);
		newValues.put("HARGA", harga);
		newValues.put("SYARAT_STEP", syarat_step);
		
		return db.insert("DATA_SENJATA", null, newValues);
	}
	
	public DataPemain getDataPemainByNama(String nama){
		Cursor cur = null;
		DataPemain T = new DataPemain();

		String[] COLS = new String[] {"ID", "NAMA", "LEVEL", "J_BINTANG", "J_STEP", "J_KALORI", "MAX_STEP", "NOW_ARMOR"};
		
		cur = db.query("DATA_PEMAIN", COLS, "NAMA ='"+nama+"'", null, null, null, null);
		if(cur.getCount() > 0){
			cur.moveToFirst();
			T.id = cur.getInt(0);
			T.nama = cur.getString(1);
			T.level = cur.getString(2);
			T.j_bintang = cur.getString(3);
			T.j_step = cur.getString(4);
			T.j_kalori = cur.getString(5);
			T.max_step = cur.getString(6);
			T.now_armor = cur.getString(7);
		}
		
		return T;
	}
	
	public void updateDataPemain(int id,String nama, String level, String j_bintang,  String j_step,  String j_kalori,  String max_step,  String now_armor){
		ContentValues newValues = new ContentValues();
		newValues.put("ID", id);
		newValues.put("NAMA", nama);
		newValues.put("LEVEL", level);
		newValues.put("J_BINTANG", j_bintang);
		newValues.put("J_STEP", j_step);
		newValues.put("J_KALORI", j_kalori);
		newValues.put("MAX_STEP", max_step);
		newValues.put("NOW_ARMOR", now_armor);
		
		db.update("DATA_PEMAIN", newValues, "ID = " +id, null);
	}
	
	public void deleteDataPemain(int id){
		db.delete("DATA_PEMAIN", "ID = " +id, null);
	}
	
	public void hapusTableSenjata(){
		db.execSQL("DROP TABLE IF EXISTS DATA_SENJATA");
		db.execSQL("CREATE TABLE DATA_SENJATA  (ID_ARMOR INTEGER PRIMARY KEY AUTOINCREMENT," + 
			"NAMA_SENJATA TEXT, STATUS INTEGER, HARGA INTEGER, SYARAT_STEP INTEGER);");
		db.execSQL(RelasiOpenHelper.ADD_SENJATA_1);
		db.execSQL(RelasiOpenHelper.ADD_SENJATA_2);
		db.execSQL(RelasiOpenHelper.ADD_SENJATA_3);
	}
	
	public ArrayList<DataListSenjata> getAllSenjata(){
		
		Cursor cur = null;
		
		ArrayList<DataListSenjata> list = new ArrayList<DataListSenjata>();
		String[] kolom = new String[] {"ID_ARMOR","NAMA_SENJATA", "STATUS", "HARGA", "SYARAT_STEP"};
		cur = db.query("DATA_SENJATA", kolom, null, null, null, null, null);
		
		if(cur.moveToFirst()){
			do{
				DataListSenjata data = new DataListSenjata();
				data.setId(cur.getString(0));
				data.setNama(cur.getString(1));
				data.setStatus(cur.getString(2));
				data.setHarga(cur.getString(3));
				data.setSaratStep(cur.getString(4));
				list.add(data);
			}while(cur.moveToNext());
		}
		cur.close();
		
		return list;
	}
	
	
}


