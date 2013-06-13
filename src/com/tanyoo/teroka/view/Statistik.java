package com.tanyoo.teroka.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.tanyoo.teroka.activities.StatistikActivity;
import com.tanyoo.teroka.entities.EBatleLose;
import com.tanyoo.teroka.entities.EBatleWin;
import com.tanyoo.teroka.entities.EBintangStatistik;
import com.tanyoo.teroka.entities.EButtonBack;
import com.tanyoo.teroka.entities.ECaloriStatistik;
import com.tanyoo.teroka.entities.ELevelStatistik;
import com.tanyoo.teroka.entities.EStatistikBar;
import com.tanyoo.teroka.entities.EStepStatistik;
import com.tanyoo.teroka.lib.GameView;

public class Statistik extends GameView {
	

	private Paint cat = new Paint();
	
	// angka ticks buat animasi
	private int timeElapsed = 0;
	
	// entities
	EButtonBack ebuttonback;
	EStatistikBar estatistikbar;
	ELevelStatistik elevelstatistik;
	EBintangStatistik ebintangstatistik;
	EStepStatistik estepstatistik;
	ECaloriStatistik ecaloristatistik;
	EBatleWin ebatlewin;
	EBatleLose ebatlelose;
	
	public Statistik(Context context) {
		super(context);
		
		//entities
		estatistikbar = new EStatistikBar(getResources());
		ebuttonback = new EButtonBack(getResources());
		elevelstatistik = new ELevelStatistik(getResources());
		ebintangstatistik = new EBintangStatistik(getResources());
		estepstatistik = new EStepStatistik(getResources());
		ecaloristatistik = new 	ECaloriStatistik(getResources());
		ebatlewin = new EBatleWin(getResources());
		ebatlelose = new EBatleLose(getResources());
		
		addEntityCollection(estatistikbar,
							ebuttonback,
							elevelstatistik,
							ebintangstatistik,
							estepstatistik,
							ecaloristatistik,
							ebatlewin,
							ebatlelose			
				);
	}

	@Override
	public void onWindowFocusChanged(boolean hasWindowFocus) {
		// TODO Auto-generated method stub
		super.onWindowFocusChanged(hasWindowFocus);
				
		// resize gambar
		ebuttonback.resizeImage((int)getPercentWidth(17), (int)getPercentHeight(13));
		estatistikbar.resizeImage((int)getPercentWidth(83), (int)getPercentHeight(13));
		elevelstatistik.resizeImage((int)getPercentWidth(16), (int)getPercentHeight(11));
		ebintangstatistik.resizeImage((int)getPercentWidth(16), (int)getPercentHeight(11));
		estepstatistik.resizeImage((int)getPercentWidth(16), (int)getPercentHeight(11));
		ecaloristatistik.resizeImage((int)getPercentWidth(16), (int)getPercentHeight(11));
		ebatlewin.resizeImage((int)getPercentWidth(16), (int)getPercentHeight(11));
		ebatlelose.resizeImage((int)getPercentWidth(16), (int)getPercentHeight(11));
		
		// set posisi
		ebuttonback.setPosition(getPercentWidth(0), getPercentHeight(0));
		estatistikbar.setPosition(getPercentWidth(17), getPercentHeight(0));
		elevelstatistik.setPosition(getPercentWidth(9), getPercentHeight(16));
		ebintangstatistik.setPosition(getPercentWidth(9), getPercentHeight(30));
		estepstatistik.setPosition(getPercentWidth(9), getPercentHeight(44));
		ecaloristatistik.setPosition(getPercentWidth(9), getPercentHeight(58));
		ebatlewin.setPosition(getPercentWidth(9), getPercentHeight(72));
		ebatlelose.setPosition(getPercentWidth(9), getPercentHeight(86));
		
		ready = true;
		
	}
	
	@Override
	protected void onDraw(Canvas c) {
		
		
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
		if (ebuttonback.isHit(posXDown, posYDown)) {
			((StatistikActivity)(this.context)).tombolKembali();
		}
		
	}

	@Override
	public void onUp() {
		// TODO Auto-generated method stub

	}

	@Override
	public void draw(Canvas c, Paint cat) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		
				cat.setColor(Color.WHITE);
				//buat background
				c.drawRect(0, 0, c.getWidth(), c.getHeight(), cat);
				
				//draw entities
//				ebuttonback.draw(c, cat);
//				estatistikbar.draw(c, cat);
//				logo1.draw(c, cat);
//				logo2.draw(c, cat);
//				logo3.draw(c, cat);
//				logo4.draw(c, cat);
//				logo5.draw(c, cat);
//				logo6.draw(c, cat);
				drawEntityCollection(c, cat);
	}

}
