package com.tanyoo.teroka.activities;

import com.tanyoo.teroka.AnimasiTask;
import com.tanyoo.teroka.R;
import com.tanyoo.teroka.R.menu;
import com.tanyoo.teroka.entities.EButton;
import com.tanyoo.teroka.lib.GameActivity;
import com.tanyoo.teroka.lib.GameView;
import com.tanyoo.teroka.view.*;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnTouchListener;

public class HelpActivity extends GameActivity{
	
	// mesin
	private GameView gv;
	
	// views
	public Help mu;
	
	// task
	public AnimasiTask at;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		
		//hilangkan title bar
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		//hilangkan notification bar
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		//inisialisasi thread
		at = new AnimasiTask();
		
		
		//inisiaslisi graphic view
		mu = new Help(this);
			
		gv = mu;
		
		//set aksi yang dilakukan oleh touch dilakukan siapa
		gv.setOnTouchListener(this);

		//set tampilan yang muncul
		setContentView(gv);
		
		//jalankan program
		at.setPlay(true);
		at.gv = mu;
		at.execute();
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}


	/**
	 * Tombol kembali diklik
	 */
	public void tombolKembali(){
		finish();
	}
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		
		
		System.gc();
	}
	
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		mu.recycleEntityCollection();
	}
	
}
