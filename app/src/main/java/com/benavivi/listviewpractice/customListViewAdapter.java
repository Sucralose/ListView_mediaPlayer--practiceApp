package com.benavivi.listviewpractice;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class customListViewAdapter extends BaseAdapter {
	private Context context;
	private ArrayList<String> itemArrayList;

	public  customListViewAdapter(Context context, ArrayList<String> items){
		this.context = context;
		this.itemArrayList = items;
	}
	@Override
	public int getCount () {
		return itemArrayList.size();
	}

	@Override
	public Object getItem (int i) {
		return itemArrayList.get(i);
	}

	@Override
	public long getItemId (int i) {
		return i;
	}

	@Override
	public View getView (int i, View convertView, ViewGroup parent) {
		ViewHolder viewHolder;
		if(convertView == null){
			viewHolder=new ViewHolder();
			convertView = LayoutInflater.from(context).inflate(R.layout.my_list_item,parent,false);
			viewHolder.textView = (TextView) convertView.findViewById(R.id.listItemTextView);
			convertView.setTag(viewHolder);
		}
		else{
			viewHolder = (ViewHolder) convertView.getTag();
		}
		viewHolder.textView.setText(itemArrayList.get(i));
		return convertView;
	}


	 static class ViewHolder {
		TextView textView;
	}
}
