package com.leagmain.app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leagmain on 10/17/2016.
 */

public class NormalXListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.normal_xlist_activity);
        XList xList = (XList) findViewById(R.id.xlist);
        List<People> peoples = new ArrayList<>();


        peoples.add(new People("Lisi", "23", "male"));
        peoples.add(new People("WangMM", "23", "female"));
        peoples.add(new People("HeDong", "18", "male"));
        peoples.add(new People("Lisi", "23", "male"));
        peoples.add(new People("WangMM", "23", "female"));
        peoples.add(new People("HeDong", "18", "male"));
        peoples.add(new People("Lisi", "23", "male"));
        peoples.add(new People("WangMM", "23", "female"));
        peoples.add(new People("HeDong", "18", "male"));
        peoples.add(new People("Lisi", "23", "male"));
        peoples.add(new People("WangMM", "23", "female"));
        peoples.add(new People("HeDong", "18", "male"));
        peoples.add(new People("Lisi", "23", "male"));
        peoples.add(new People("WangMM", "23", "female"));
        peoples.add(new People("HeDong", "18", "male"));
        peoples.add(new People("Lisi", "23", "male"));
        peoples.add(new People("WangMM", "23", "female"));
        peoples.add(new People("HeDong", "18", "male"));
        peoples.add(new People("Lisi", "23", "male"));
        peoples.add(new People("WangMM", "23", "female"));
        peoples.add(new People("HeDong", "18", "male"));
        peoples.add(new People("Lisi", "23", "male"));
        peoples.add(new People("WangMM", "23", "female"));
        peoples.add(new People("HeDong", "18", "male"));
        peoples.add(new People("Lisi", "23", "male"));
        peoples.add(new People("WangMM", "23", "female"));
        peoples.add(new People("HeDong", "18", "male"));


        xList.policy(new PeopleBindPolicy())
                .bind(peoples)
                .enableLoadMore(new XListOnLoadMoreListener() {
                    @Override
                    public void onLoadMore() {
                        Log.i("Leagmain", "load more");
                    }
                });
    }
}
