package com.braysoft.chfjrfichas.activities;

import com.braysoft.chfjrfichas.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Main extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	
	public void btnListaCasas_onClick(View v)
	{
		Intent intent = new Intent(this,ListaCasas.class);
		startActivity(intent);
	}
	
	public void btnListaPJ_onClick(View v)
	{
		Intent intent = new Intent(this,ListaPJ.class);
		startActivity(intent);
	}
}
