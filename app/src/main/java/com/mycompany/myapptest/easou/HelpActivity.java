package com.mycompany.myapptest.easou;
import android.app.*;
import android.os.*;
import android.support.v4.view.*;
import android.view.*;
import java.util.*;
import android.widget.*;
import android.view.View.*;

public class HelpActivity extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		ViewPager vp = new ViewPager(this);
		setContentView(vp);
		final List<View> arrList = new ArrayList<View>();
		for(int i = 0; i< 5;i++)
		{
			TextView tv = new TextView(this);
			tv.setText("这是第"+i+"个界面");
			arrList.add(tv);
		}
		(arrList.get(4)).setOnClickListener(new OnClickListener()
			{

				@Override
				public void onClick(View p1)
				{
					HelpActivity.this.finish();
				}

			
		});
		PagerAdapter pa = new PagerAdapter(){

			@Override
			public int getCount()
			{
				return arrList.size();
			}

			@Override
			public boolean isViewFromObject(View p1, Object p2)
			{
				// TODO: Implement this method
				return p1==p2;
			}
			@Override
			public void destroyItem(android.view.ViewGroup container, int position, java.lang.Object object) 
			{
				container.removeView(arrList.get(position));

			}
			

			public java.lang.Object instantiateItem(android.view.ViewGroup container, int position) 
			{
				container.addView(arrList.get(position));
				return arrList.get(position);
			}
			
		};
		vp.setAdapter(pa);
	}
	
}
