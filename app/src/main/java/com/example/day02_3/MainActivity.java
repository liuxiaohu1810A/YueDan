package com.example.day02_3;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.LinearLayout;

import com.example.day02_3.model.Modelmap;
import com.example.day02_3.presenter.Presenter;
import com.example.day02_3.view.IView;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements IView {

    private RecyclerView mRlv;
    private ArrayList<User.ResultsBean> users;
    private MyAdapter adapter;
    private BroadClass broadClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        Presenter presenter = new Presenter(this);
        presenter.getDataP();
    }

    private void initView() {
        mRlv = (RecyclerView) findViewById(R.id.rlv);
        mRlv = (RecyclerView) findViewById(R.id.rlv);
        mRlv = (RecyclerView) findViewById(R.id.rlv);
        mRlv.setLayoutManager(new LinearLayoutManager(this));
        mRlv.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        //创建适配器
        users = new ArrayList<>();
        adapter = new MyAdapter(this, users);
        mRlv.setAdapter(adapter);
    }

    private static final String TAG = "MainActivity";
    @Override
    public void onSuccess(List<User.ResultsBean> success) {
        users.addAll(success);

        adapter.notifyDataSetChanged();

    }

    @Override
    public void onError(String error) {
        Log.d(TAG, "onError: "+error);
    }
    //创建一个广播的内部类
    class BroadClass extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            int data = intent.getIntExtra("data", 0);
            Intent in = new Intent(MainActivity.this, VapeActivity.class);
            in.putExtra("da",users);
            startActivity(in);
        }
    }
    @Override
    protected void onResume() {
        super.onResume();
        broadClass = new BroadClass();
        IntentFilter tt = new IntentFilter("tt");
        registerReceiver(broadClass, tt);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(broadClass);
    }
}
