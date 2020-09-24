package com.example.recyclerviewdemo;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyRecycleAdapter extends RecyclerView.Adapter<MyRecycleAdapter.ViewHolder>
{
    private List<String> mdata;
    private LayoutInflater inflater;
    private ItemClickListener myclicklistener;
    int a=0;
    public MyRecycleAdapter(Context context, List<String> data)
    {
        this.mdata = data;
        this.inflater = LayoutInflater.from(context);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        TextView textView;
        ViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.mytextbox);
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View view) {
             if(myclicklistener!=null){
                 myclicklistener.onItemClick(view,getAdapterPosition());
             }
        }
    }
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.myrecycle_row,parent,false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
           String data=mdata.get(position);
           holder.textView.setText(data);
    }
    @Override
    public int getItemCount() {
        return mdata.size();
    }

    //Event handling code
    //implemented by MainActivity
    interface ItemClickListener{
        void onItemClick(View view,int position);
    }
    public void setClickListener(ItemClickListener itemClickListener){
        this.myclicklistener = itemClickListener;
    }
    String getItem(int id){
        return mdata.get(id);
    }
}
