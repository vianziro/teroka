package com.tanyoo.teroka.entities;

import android.content.res.Resources;

import com.tanyoo.teroka.R;
import com.tanyoo.teroka.lib.Entity;

public class EMonster extends Entity {

	public EMonster(Resources res) {
		super(res);
		// TODO Auto-generated constructor stub
		addSprite(R.drawable.monster1, "monster");
		setSprite("monster");
	}

}
