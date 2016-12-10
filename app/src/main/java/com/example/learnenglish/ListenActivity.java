package com.example.learnenglish;

import android.os.Bundle;
import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.view.Menu;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class ListenActivity extends TabActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_listen);
		 TabHost tabhost=getTabHost();
	        
	        TabSpec tabhappy=tabhost.newTabSpec("happy");
	        tabhappy.setIndicator("Listen");
	        Intent ihappy=new Intent(this,Listen1Activity.class);
	        tabhappy.setContent(ihappy);
	        tabhost.addTab(tabhappy);
	        
	        
	        TabSpec tabsad=tabhost.newTabSpec("sad");
	        tabsad.setIndicator("Sub");
	        Intent isad=new Intent(this,Listen2Activity.class);
	        tabsad.setContent(isad);
	        tabhost.addTab(tabsad);
	        
	        
	        tabhost.setCurrentTab(0);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.listen, menu);
		return true;
	}

}
