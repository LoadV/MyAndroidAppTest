package com.mycompany.myapptest;

import android.app.*;
import android.os.*;
import android.support.v4.view.*;
import android.view.*;
import java.util.*;
import android.widget.*;
import android.graphics.*;
import android.content.*;
import android.widget.AdapterView.*;
import java.io.*;

public class MainActivity extends Activity 
{
	
	ListView mListView = null;
	MainListBaseAdapter mListBaseAdapter = null;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		initView();
		
		
		List<String> items = new ArrayList<String>();
		
		
		items.add("RecycleView Test");
		items.add("mdzz");
		items.add("TextView->Html");
		items.add("OKHttp测试");
		mListBaseAdapter = new MainListBaseAdapter(MainActivity.this, items);
		mListBaseAdapter.notifyDataSetChanged();
		mListBaseAdapter.notifyDataSetInvalidated();
		mListView.setAdapter(mListBaseAdapter);
		mListBaseAdapter.notifyDataSetChanged();
		mListBaseAdapter.notifyDataSetInvalidated();
		mListView.setOnItemClickListener(new OnItemClickListener()
			{
				
				Intent intent = new Intent();
				@Override
				public void onItemClick(AdapterView<?> p1, View p2, int p3, long p4)
				{
					Toast.makeText(MainActivity.this,"",0).show();
					switch(p3)
					{
						case 0 :
							intent.setClass(MainActivity.this,RecyclerViewTestActivity.class);
							startActivity(intent);
							break;
						case 1 :
							intent.setClass(MainActivity.this,com.mycompany.myapptest.standapp.StartActivity.class);
							startActivity(intent);
							break;
						case 2:
							intent.setClass(MainActivity.this,TextViewShowHtmlActivity.class);
							startActivity(intent);
							break;
						case 3 :
							intent.setClass(MainActivity.this,OKHttpTestActivity.class);
							startActivity(intent);
							break;
					}
				}

			
		});
		
		Utils.log2File(""+mListView.getChildCount());
	}

	private void initView()
	{
		mListView = (ListView) findViewById(R.id.mainListView);
	}
	
}
class MainListBaseAdapter extends BaseAdapter
{
	
	
	
	List<String> items = null;
	Context context = null;
	public MainListBaseAdapter(Context context,List<String> items)
	{
		this.items = items;
		this.context = context;
	}
	@Override
	public int getCount()
	{
		return items.size();
	}

	@Override
	public Object getItem(int p1)
	{
		return items.get(p1);
	}

	@Override
	public long getItemId(int p1)
	{
		return 0;
	}

	@Override
	public View getView(int p1, View convertView, ViewGroup p3)
	{
		if(convertView == null)
		{
			convertView = new TextView(context);
			((TextView)convertView).setText(items.get(p1));
			((TextView)convertView).setTextSize(30);
			Utils.log2File("convertView为空");
		}
		else
		{
			((TextView)convertView).setText(items.get(p1));
			Utils.log2File("convertView已有值");
		}
		return convertView;
	}



}
