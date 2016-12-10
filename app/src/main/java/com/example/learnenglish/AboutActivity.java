package com.example.learnenglish;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Typeface;
import android.view.Menu;
import android.widget.TextView;

public class AboutActivity extends Activity {
TextView tv1, tv2, tv3, tv4, tv5;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_about);
		tv1 = (TextView) findViewById(R.id.textView1);
		tv2= (TextView) findViewById(R.id.textView2);
		tv3 = (TextView) findViewById(R.id.textView3);
		tv4 = (TextView) findViewById(R.id.textView4);
		tv5 = (TextView) findViewById(R.id.textView5);
		//Typeface tnr = Typeface.createFromAsset(getAssets(), "TIMES.TTF");
		//Typeface ama = Typeface.createFromAsset(getAssets(), "amazonen.ttf");
		//tv1.setTypeface(tnr);
		//tv2.setTypeface(tnr);
		//tv3.setTypeface(tnr);
		//tv4.setTypeface(ama);
		//tv5.setTypeface(ama);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.about, menu);
		return true;
	}

}
