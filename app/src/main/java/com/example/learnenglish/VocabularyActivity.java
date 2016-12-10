package com.example.learnenglish;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

public class VocabularyActivity extends Activity {
	ListView lv;
	ImageView iv;
	Animation ani;
    
    String []ten={ "Animals","Clothing",
					"Everyday Actions","Food",
					"Fruit","Kitchenware", 
					"Numbers","Occupations",
					"Sports","Vegetables",
					"Office Supplies","Tools"
    
    };
    int []hinh={ R.drawable.listanimal,R.drawable.list_clothing2,
    	   	R.drawable.list_action,R.drawable.list_food,
    	   	R.drawable.list_fruit,R.drawable.list_kitchen, 
    	   	
    	   	R.drawable.list_number,R.drawable.list_docto,
    	   	R.drawable.list_sport,R.drawable.list_vegetable,
    	   	R.drawable.list_office,R.drawable.list_tools
        };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_vocabulary);
		iv = (ImageView) findViewById(R.id.imageView2);
		lv=(ListView)findViewById(R.id.listView1);
		lv.setAdapter(new myadapter(this,ten));
		lv.setDividerHeight(10);
		
		ani =AnimationUtils.loadAnimation(getApplicationContext(), R.anim.scale2);
		
		lv.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				switch(arg2){
				case 0: Intent i = new Intent(getApplicationContext(), AnimalActivity.class);
						startActivity(i);
						break;
				}
				
			}
        });
		iv.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.vocabulary, menu);
		return true;
	}
	class myadapter extends ArrayAdapter{
		Context context;
		

		public myadapter(Context context,String [] ten)
		{
			super(context,R.layout.listview_item,ten);
			this.context=context;
		}
		
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// dung layoutinflater lấy đọc cấu trúc và nội dung của từng hàng listview
			LayoutInflater inf=(LayoutInflater)
					context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View rowview=inf.inflate(R.layout.listview_item,parent, false);
			
			//ánh xạ từng hàng listview , cập nhật thông tin
			TextView textview=(TextView)rowview.findViewById(R.id.textView1);
			ImageView imageview=(ImageView)rowview.findViewById(R.id.imageView1);
			
			textview.setText(ten[position]);
			imageview.setImageResource(hinh[position]);
			
			if (position % 4 == 0){
				rowview.setBackgroundColor(Color.argb(200, 213, 7, 0));
			}
			else
			{
				if (position % 4 == 1){
					rowview.setBackgroundColor(Color.argb(200, 255, 131, 6));
				}
				else
				{
					if (position % 4 == 2){
						rowview.setBackgroundColor(Color.argb(200, 0, 198, 99));
					}
					else
						rowview.setBackgroundColor(Color.argb(200, 0, 206, 206));
				}
			}
			rowview.startAnimation(ani);
			
			return rowview;
		}
	
	}

}
