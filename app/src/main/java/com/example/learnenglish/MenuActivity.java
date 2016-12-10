package com.example.learnenglish;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class MenuActivity extends Activity {
	GridView gv;
	ArrayList<Logo> ds;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);
		gv = (GridView) findViewById(R.id.gridView1);
		ds = new ArrayList<Logo>();
		String[] ten = { "Vocabulary", "Listenning", "Test", "Videos", "Notes",
				"About", "Exit", "Dictionary" };

		int[] hinh = { R.drawable.apple, R.drawable.phone, R.drawable.facebook,
				R.drawable.menu_youtube, R.drawable.note, R.drawable.facebook,
				R.drawable.exit, R.drawable.dictionary };

		for (int i = 0; i < ten.length; i++)
			ds.add(new Logo(ten[i], hinh[i]));

		MyAdapter adapter = new MyAdapter(this);
		gv.setAdapter(adapter);
		gv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				switch (arg2) {
				case 0:
					Intent i = new Intent(getApplicationContext(),
							VocabularyActivity.class);
					startActivity(i);

					break;
				case 1:
					Intent Listen = new Intent(getApplicationContext(),
							ListenActivity.class);
					startActivity(Listen);

					break;
				case 2:
					Intent test = new Intent(getApplicationContext(),
							TestActivity.class);
					startActivity(test);

					break;
				case 3:
					Intent youtube = new Intent(
							Intent.ACTION_VIEW,
							Uri.parse("http://www.youtube.com/results?search_query=Hoc+tieng+anh+hieu+qua&oq=Hoc+tieng+anh+hieu+qua&gs_l=youtube.3..0l2j0i5l8.2070.5797.0.6484.28.19.3.6.6.0.158.1670.16j3.19.0...0.0...1ac.1.11.youtube.m7m2HTi6FjQ"));
					startActivity(youtube);
					break;
				case 4:
					Intent Notes = new Intent(getApplicationContext(),
							NotesActivity.class);
					startActivity(Notes);
					break;
				case 5:
					Intent About = new Intent(getApplicationContext(),AboutActivity.class);
					startActivity(About);
					break;
				case 6:
					AlertDialog.Builder bui = new AlertDialog.Builder(
							MenuActivity.this);
					bui.setTitle("Exit");
					bui.setMessage("Do You Want To Exit?");
					bui.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which) {
							// TODO Auto-generated method stub
							finish();
						}
					});
					bui.setPositiveButton("No", new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which) {
							// TODO Auto-generated method stub
							dialog.cancel();
						}
					});
					bui.show();

					break;
					case 7:
						Intent Dictionary = new Intent(getApplicationContext(), DictionaryActivity.class);
						startActivities(Dictionary);
						break;

				default:
					break;
				}


			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu, menu);
		return true;
	}

	public static class View_Mot_O {
		public ImageView imageview;
		public TextView textview;
	}

	class MyAdapter extends BaseAdapter {
		Context c;

		MyAdapter(Context c) {
			this.c = c;
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return ds.size();
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return ds.get(position);
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			View_Mot_O mot_o;
			LayoutInflater inf = ((Activity) c).getLayoutInflater();
			if (convertView == null) {
				convertView = inf.inflate(R.layout.gridview_mot_o, null);
				mot_o = new View_Mot_O();
				mot_o.imageview = (ImageView) convertView
						.findViewById(R.id.imageView1);
				mot_o.textview = (TextView) convertView
						.findViewById(R.id.textView1);
				convertView.setTag(mot_o);

				if (position % 6 == 0) {
					convertView
							.setBackgroundColor(Color.argb(200, 216, 32, 30));
				} else {
					if (position % 6 == 1) {
						convertView.setBackgroundColor(Color.argb(200, 255,
								131, 6));
					} else {
						if (position % 6 == 2) {
							convertView.setBackgroundColor(Color.argb(200, 0,
									198, 99));
						} else {
							if (position % 6 == 3)
								convertView.setBackgroundColor(Color.argb(200,
										0, 206, 206));
							else {
								if (position % 6 == 4)
									convertView.setBackgroundColor(Color.argb(
											200, 26, 156, 139));
								else
									convertView.setBackgroundColor(Color.argb(
											200, 128, 0, 128));
							}
						}
					}
				}
			} else {
				mot_o = (View_Mot_O) convertView.getTag();
			}

			mot_o.imageview.setImageResource(ds.get(position).hinh);
			mot_o.textview.setText(ds.get(position).ten);

			return convertView;
		}
	}

}
