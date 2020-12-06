package com.example.first_aid.Quiz;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.first_aid.R;

import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter {
    private TextView category;
    private TextView number;
    private TextView content;


    private ArrayList<ListViewItem> listViewItemList=new ArrayList<ListViewItem>();

    public ListViewAdapter(){

    }

    @Override
    public int getCount(){
        return listViewItemList.size();
    }

    public View getView(int position, View convertView, ViewGroup parent){
        final int pos=position;
        final Context context=parent.getContext();

        if(convertView==null){
            LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.quiz_comment_resource,parent,false);
        }

        category=(TextView) convertView.findViewById(R.id.com_category);
        number=(TextView) convertView.findViewById(R.id.com_num);
        content=(TextView) convertView.findViewById(R.id.com_quiz);

        ListViewItem listViewItem=listViewItemList.get(position);

        category.setText(listViewItem.getCategoryS());
        number.setText(listViewItem.getNumS());
        content.setText(listViewItem.getContentS());



        return convertView;
    }

    @Override
    public long getItemId(int position){
        return position;
    }

    @Override
    public Object getItem(int position){
        return listViewItemList.get(position);
    }

    public void addItem(String category, String num, String content){
        ListViewItem item=new ListViewItem();

        item.setCategoryS(category);
        item.setNumS(num);
        item.setContentS(content);

        listViewItemList.add(item);
    }

}
