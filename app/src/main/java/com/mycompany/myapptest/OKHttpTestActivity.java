package com.mycompany.myapptest;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import okhttp3.OkHttpClient;
import java.util.HashMap;
import java.io.IOException;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

public class OKHttpTestActivity extends Activity
{

	String s = "";
	MyHandler mHandler = null;
	class MyHandler extends Handler
	{

		@Override
		public void handleMessage(Message msg)
		{
			super.handleMessage(msg);
			Toast.makeText(OKHttpTestActivity.this,s,1).show();
		}
		
	}
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		mHandler = new MyHandler();
		new Thread()
		{
			public void run()
			{
				try
				{
					RequestManager rm = RequestManager.getInstance(OKHttpTestActivity. this);
					HashMap<String,String> params = new HashMap<String,String>();
					params.put("xianbao_data","大菊花");
					params.put("ran","79");
					s = new String(rm.requestSyn("http://127.0.0.1:8080/write_xianbao_data.php", RequestManager.TYPE_GET, params));
				
				}
				catch (IOException e)
				{

					s=e.toString();
				}
				finally
				{
					mHandler.sendEmptyMessage(0);
				}
			}
		}.start();
	}

}
