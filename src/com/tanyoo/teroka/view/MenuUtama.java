package com.tanyoo.teroka.view;

import com.tanyoo.teroka.activities.MainActivity;
import com.tanyoo.teroka.entities.EButton;
import com.tanyoo.teroka.lib.GameView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class MenuUtama extends GameView {

	private Paint cat = new Paint();
	
	// entities
	EButton eb;
	
	public MenuUtama(Context context) {
		super(context);
		
		//entities
		eb = new EButton(getResources());
	}

	@Override
	protected void onDraw(Canvas c) {
		// TODO Auto-generated method stub
		
		cat.setColor(Color.RED);
		//buat background
		c.drawRect(0, 0, c.getWidth(), c.getHeight(), cat);
		
		// teks posisi kursor
		String posisi = "x: " + String.valueOf(posX) + " , y:" + String.valueOf(posY);
		
		cat.setColor(Color.BLACK);
		c.drawText(posisi, 30, 30, cat);
		c.drawText("Ini menu utama", 30, 50, cat);
		
		//draw entities
		eb.draw(c, cat);
		
		
		
		super.onDraw(c);
	}

	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		
		
	}

	@Override
	public void onMove() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDown() {
		// TODO Auto-generated method stub
		if (eb.isHit(posX, posY)) {
			((MainActivity)(this.context)).tombolAbout();
		}
	}

	@Override
	public void onUp() {
		// TODO Auto-generated method stub
		
	}

}
