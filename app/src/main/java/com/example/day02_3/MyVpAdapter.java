package com.example.day02_3;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

class MyVpAdapter extends PagerAdapter {
    private Context context;
    private List<User.ResultsBean> list;
    private int i=1;
    public MyVpAdapter(Context context, List<User.ResultsBean> list) {
        this.context = context;
        this.list = list;
    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view==o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = View.inflate(context, R.layout.myvpadapter_item, null);
        ImageView vp = view.findViewById(R.id.iv_vp);
        TextView time = view.findViewById(R.id.tv_time);
        time.setText("第"+i+++"张/共20张");
        Glide.with(context).load(list.get(position).getUrl()).into(vp);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
       container.removeView((View) object);
    }
}

