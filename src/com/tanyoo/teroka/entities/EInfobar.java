package com.tanyoo.teroka.entities;

import android.content.res.Resources;

import com.tanyoo.teroka.R;
import com.tanyoo.teroka.lib.Entity;

public class EInfobar extends Entity {

	public EInfobar(Resources res) {
		super(res);
		// TODO Auto-generated constructor stub
		addSprite(R.drawable.infobar, "infobar");
		setSprite("infobar");
	}

}
