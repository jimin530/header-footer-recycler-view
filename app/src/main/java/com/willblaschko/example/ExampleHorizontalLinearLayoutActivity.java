package com.willblaschko.example;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.willblaschko.android.headerfooterrecyclerview.R;
import com.willblaschko.android.headerfooterrecyclerview.RecyclerViewHeaderFooterAdapter;
import com.willblaschko.android.headerfooterrecyclerview.RecyclerViewIntermediary;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Will on 2/8/2015.
 */
public class ExampleHorizontalLinearLayoutActivity extends Activity {
    private Context mContext;
    private RecyclerView mRecyclerView;
    private RecyclerViewHeaderFooterAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerViewIntermediary mIntermediary;

    private List<String> mStrings = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        mContext = this;
        setContentView(R.layout.activity_example);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        init();

    }

    private void init(){
        int count = new Random().nextInt(10)+1;
        for(int i = 0; i < count; i++){
            mStrings.add(Integer.toString(i));
        }
        mIntermediary = new ExampleIntermediary(mStrings);

        mLayoutManager = new LinearLayoutManager(mContext);
        ((LinearLayoutManager) mLayoutManager).setOrientation(LinearLayoutManager.HORIZONTAL);

        mAdapter = new RecyclerViewHeaderFooterAdapter(mLayoutManager, mIntermediary);

        mAdapter.addHeader(ExampleHeaderFooter.getView(mContext, "Header"));

        mAdapter.addFooter(ExampleHeaderFooter.getView(mContext, "Footer"));

    }

    public void onResume(){
        super.onResume();
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

}