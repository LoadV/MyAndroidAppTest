package com.mycompany.myapptest;



import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import java.util.List;
import android.widget.TextView;
import android.content.Context;
import android.view.View;
import java.util.ArrayList;
import android.view.LayoutInflater;

public class RecyclerViewTestActivity extends Activity
{
	@Override
	protected void onCreate(Bundle saveData)
	{
		super.onCreate(saveData);
		setContentView(R.layout.recyclerviewtest);
		RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recyclerviewtestRecyclerView);
		List<String> items = new ArrayList<String>();
		for(int i = 65;i<=89;i++)
			items.add(i+","+ (char) i);
		mRecyclerView.setAdapter(new RecyclerAdapter(RecyclerViewTestActivity.this,items));
	}
	
	class RecyclerAdapter extends RecyclerView.Adapter
	{
		List<String> items;
		Context context = null;
		TextView itemsView = null;
		public RecyclerAdapter(Context context,List<String> items)
		{
			this.context = context;
			this.items = items;
			itemsView = (TextView) LayoutInflater.from(context).inflate(R.layout.recycle_item_view,null);
			Utils.log2File("创建RecycleAdapter");
		}
		@Override
		public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup p1, int p2)
		{
			Utils.log2File("创建RecycleViewHolder");
			MyViewHolder mViewHolder = new MyViewHolder(itemsView);
			
			return mViewHolder;
		}

		@Override
		public void onBindViewHolder(RecyclerView.ViewHolder p1, int p2)
		{
			Utils.log2File("Bind RecycleViewHolder");
			((TextView)p1.itemView).setText(items.get(p2));
			Utils.log2File("Bind RecycleViewHolder,ViewHolder.ItemView =" + p1.itemView.toString());
		}

		@Override
		public int getItemCount()
		{
			Utils.log2File("ViewItemsSize"+items.size());
			return items.size();
		}
		class MyViewHolder extends RecyclerView.ViewHolder{
			
			public MyViewHolder(View view)
			{
				super(view);
			}
			
		}
	}
}
