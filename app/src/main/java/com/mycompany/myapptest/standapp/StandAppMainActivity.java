package com.mycompany.myapptest.standapp;
import android.app.*;
import android.os.*;
import android.widget.*;

public class StandAppMainActivity extends Activity
{
	protected void onCreate(Bundle saved)
	{
		super.onCreate(saved);
		TextView mTextView = new TextView(this);
		mTextView.setText("这里是主界面");
		setContentView(mTextView);
	}
}
