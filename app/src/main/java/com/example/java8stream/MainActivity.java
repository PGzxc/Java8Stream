package com.example.java8stream;

import android.hardware.camera2.params.StreamConfigurationMap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.java8stream.stream.StreamUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setListener();
    }

    private void setListener() {
        findViewById(R.id.btn_filter).setOnClickListener(view-> StreamUtils.filter());
        findViewById(R.id.btn_map).setOnClickListener(view->StreamUtils.map());
        findViewById(R.id.btn_reduce).setOnClickListener(view->StreamUtils.reduce());
        findViewById(R.id.btn_collect).setOnClickListener(view->StreamUtils.collect());
        findViewById(R.id.btn_peek).setOnClickListener(view->StreamUtils.peek());
        findViewById(R.id.btn_average).setOnClickListener(view-> StreamUtils.average());
        findViewById(R.id.btn_sum).setOnClickListener(view->StreamUtils.sum());
        findViewById(R.id.btn_max).setOnClickListener(view->StreamUtils.max());
        findViewById(R.id.btn_min).setOnClickListener(view->StreamUtils.min());
        findViewById(R.id.btn_arrStream).setOnClickListener(view->StreamUtils.arrStream());
        findViewById(R.id.btn_then).setOnClickListener(view->StreamUtils.then());
        findViewById(R.id.btn_foreach).setOnClickListener(view->StreamUtils.foreach());
        findViewById(R.id.btn_visitOuterVar).setOnClickListener(view->StreamUtils.visitOuterVar());
        findViewById(R.id.btn_sorted).setOnClickListener(view->StreamUtils.sorted());
        findViewById(R.id.btn_groupBy).setOnClickListener(view->StreamUtils.groupBy());
        findViewById(R.id.btn_join).setOnClickListener(view->StreamUtils.join());
        findViewById(R.id.btn_flatMap).setOnClickListener(view->StreamUtils.flatMap());



    }
}
