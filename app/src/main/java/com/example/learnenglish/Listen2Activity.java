package com.example.learnenglish;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Typeface;
import android.view.Menu;
import android.widget.TextView;

public class Listen2Activity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listen_2);
		Typeface font = Typeface.createFromAsset(getAssets(), "amazonen.ttf");
		TextView tv = (TextView) findViewById(R.id.textView1);
		tv.setTypeface(font);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.listen2, menu);
		return true;
	}

}
