package com.example.learnenglish;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnSeekCompleteListener;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.ClipData.Item;
import android.content.Context;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.VideoView;

public class Listen1Activity extends Activity implements
		OnSeekBarChangeListener, OnSeekCompleteListener {
	MediaPlayer mp;
	Gallery gl;
	int stt = 0;
	ImageView iv, iv_stop;
	SeekBar sb;

	int[] Pic = { R.drawable.listen1, R.drawable.listen2,
			R.drawable.listen3, R.drawable.listen4, R.drawable.listen5 };
	public final Handler handler = new Handler();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listen_1);
		gl = (Gallery) findViewById(R.id.gallery1);
		iv = (ImageView) findViewById(R.id.imageView2);
		iv_stop = (ImageView) findViewById(R.id.imageView3);
		sb = (SeekBar) findViewById(R.id.seekBar1);
		gl.setAdapter(new myadapter(this));
		gl.setSpacing(100);
		sb.setOnSeekBarChangeListener(Listen1Activity.this);
		iv.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (stt == 0) {
					mp = MediaPlayer.create(Listen1Activity.this, R.raw.listen);
					mp.start();
					stt = 1; // Dang choi
					iv.setImageResource(R.drawable.pause);
					sb.setMax(mp.getDuration());
					Updateseekbar();

				} else if (stt == 1) {
					mp.pause();
					stt = 2;
					iv.setImageResource(R.drawable.start);

				} else if (stt == 2) {

					mp.seekTo(sb.getProgress());
					mp.start();
					stt = 1;
					iv.setImageResource(R.drawable.pause);
					Updateseekbar();
				}

			}
		});

		iv_stop.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mp.stop();
				stt = 0;
				iv.setImageResource(R.drawable.start);
				sb.setProgress(0);
			}
		});
		sb.setOnTouchListener(new View.OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				if (mp.isPlaying()) {
					mp.seekTo(sb.getProgress());
				}

				return false;
			}
		});

	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		if (stt == 1) {
			mp.stop();
		}
	}

	private void Updateseekbar() {
		if (stt != 0)
			sb.setProgress(mp.getCurrentPosition());
		if (mp.isPlaying()) {
			Runnable chay = new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					Updateseekbar();
				}
			};
			handler.postDelayed(chay, 1000);
		}

	}

	class myadapter extends BaseAdapter {
		Context context;

		public myadapter(Context c) {
			this.context = c;
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return Pic.length;
		}

		@Override
		public Object getItem(int arg0) {
			// TODO Auto-generated method stub
			return Pic[arg0];
		}

		@Override
		public long getItemId(int arg0) {
			// TODO Auto-generated method stub
			return arg0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			ImageView iv = new ImageView(this.context);
			iv.setImageResource(Pic[position]);
			iv.setScaleType(ImageView.ScaleType.FIT_CENTER);

			return iv;
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.listen1, menu);
		return true;
	}

	@Override
	public void onProgressChanged(SeekBar seekBar, int progress,
			boolean fromUser) {
		// TODO Auto-generated method stub

		if (sb.getProgress() < 35036) {
			gl.setSelection(0);
		}
		if (sb.getProgress() > 35036 & sb.getProgress() < 55385) {
			gl.setSelection(1);
		}
		if (sb.getProgress() > 55385 & sb.getProgress() < 76159) {
			gl.setSelection(2);
		}
		if (sb.getProgress() > 76159 & sb.getProgress() < 100000) {
			gl.setSelection(3);
		}
		if (sb.getProgress() > 100000) {
			gl.setSelection(4);
		}
		if(sb.getProgress()>119000)
		{
			mp.stop();
			stt = 0;
			iv.setImageResource(R.drawable.start);
			sb.setProgress(0);
		}

	}

	@Override
	public void onStartTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStopTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onSeekComplete(MediaPlayer mp) {
		// TODO Auto-generated method stub

	}

}
