package com.example.day02_3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class VapeActivity extends AppCompatActivity {

    private ViewPager mVp;
    private ArrayList<String> list;
    private MyVpAdapter adapter;
    private List<User.ResultsBean> da;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vape);

        Intent in = getIntent();
        da = (List<User.ResultsBean>) in.getSerializableExtra("da");
        initView();
       /* //注册
        EventBus.getDefault().register(this);*/
    }
   /* @Subscribe(threadMode = ThreadMode.MAIN)
    public void MyEventBus(List<User.ResultsBean> bean){
        list.addAll(bean);
        adapter.notifyDataSetChanged();
    }*/

    private void initView() {
        mVp = (ViewPager) findViewById(R.id.vp);
        adapter = new MyVpAdapter(this,da);
        mVp.setAdapter(adapter);
    }

    /*@Override
    protected void onStop() {
        super.onStop();
        //解除注册
        EventBus.getDefault().unregister(this);
    }*/
}
