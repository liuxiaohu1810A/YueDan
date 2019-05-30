package com.example.day02_3;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private Context context;
    private List<User.ResultsBean> list;

    public MyAdapter(Context context, List<User.ResultsBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.main_item, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder viewHolder, final int i) {
        viewHolder.name.setText(list.get(i).getDesc());
        Glide.with(context).load(list.get(i).getUrl()).into(viewHolder.tu);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent("tt");
                in.putExtra("data",i);
                context.sendBroadcast(in);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView tu;
        private final TextView name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tu = itemView.findViewById(R.id.iv_tu);
            name = itemView.findViewById(R.id.tv_name);
        }
    }
}
