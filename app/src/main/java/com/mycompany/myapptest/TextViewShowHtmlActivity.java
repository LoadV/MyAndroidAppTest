package com.mycompany.myapptest;
import android.app.*;
import android.os.*;
import android.widget.*;
import android.text.*;
import android.graphics.*;
import android.util.*;
import java.io.*;

public class TextViewShowHtmlActivity extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		TextView mTextView = new TextView(this);
		mTextView.setDrawingCacheEnabled(true);
		mTextView.setBackgroundColor(Color.WHITE);
		mTextView.setText(Html.fromHtml("<h1><font color=red>我既是虫群</font></h1><hr><h2>大军灰飞烟灭</h2><br><h3>世界在我脚下燃烧</h3><hr><a href=https://www.baidu.com>百度</a>"));
		
		Canvas canvas = new Canvas();
		Bitmap mBitmap = Bitmap.createBitmap(1080,1920,Bitmap.Config.ARGB_8888);
		canvas.setBitmap(mBitmap);
		
		
		
		try
		{
			 Toast.makeText(TextViewShowHtmlActivity.this,""+mBitmap.compress(Bitmap.CompressFormat.PNG, 100, new FileOutputStream(new File("/sdcard/test.png"))),0);
		}
		catch (FileNotFoundException e)
		{}
		setContentView(mTextView);
		mTextView.invalidate();
		mTextView.draw(canvas);
	}
	
};
