package com.mycompany.myapptest.standapp;

import android.app.*;
import android.os.*;
import android.content.*;
import android.widget.*;
import com.mycompany.myapptest.*;

public class StartActivity extends Activity
{
	class MyHandler extends Handler
	{

		@Override
		public void handleMessage(Message msg)
		{
			super.handleMessage(msg);
			switch(msg.what)
			{
				case 0:
				   	StartActivity.this.startImage.setImageResource(R.drawable.image_1);
					break;
				case 1:
					startActivity(new Intent(StartActivity.this,StandAppMainActivity.class));
					StartActivity.this.finish();
					break;
			}
		}
		
	}
	SharedPreferences mSP = null;
	ImageView startImage = null;
	protected void onCreate(Bundle saved)
	{
		super.onCreate(saved);
		setTheme(android.R.style.Theme_Black_NoTitleBar_Fullscreen);
		setContentView(R.layout.startpicture);
		
		startImage = (ImageView) findViewById(R.id.startPictureImageView);
		final MyHandler mHandler = new MyHandler();
		mSP = getSharedPreferences("config",Activity.MODE_APPEND);
		boolean isFirstStartUp = mSP.getBoolean("isfirst",true);
		
		if(isFirstStartUp)
		{
			Toast.makeText(StartActivity.this,"第一次打开",0).show();
			mSP.edit().putBoolean("isfirst",false).commit();
			Intent intent = new Intent(StartActivity.this,HelpActivity.class);
			startActivity(intent);
		}
		else
		{
			new Thread(){
				public void run()
				{
					try
					{
						mHandler.sendEmptyMessage(0);
						Thread.sleep(1500);
						mHandler.sendEmptyMessage(1);
					}
					catch (InterruptedException e)
					{
						e.printStackTrace();
					}
				}
			}.start();
		}
	}
}

