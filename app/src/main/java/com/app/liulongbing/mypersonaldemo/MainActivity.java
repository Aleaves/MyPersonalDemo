package com.app.liulongbing.mypersonaldemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    MyRecycylerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new MyRecycylerAdapter(this,getData());
        mRecyclerView.setAdapter(mAdapter);

    }

    private List<PersonItem> getData(){
        List<PersonItem> lists = new ArrayList<PersonItem>();
        lists.add(new PersonItem("对话框","常用对话框的学习以及自定义对话框"));
        return lists;
    }

}
