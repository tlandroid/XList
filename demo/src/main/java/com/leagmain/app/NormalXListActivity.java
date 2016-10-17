package com.leagmain.app;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatCheckedTextView;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

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

        xList.setLayoutManager(new LinearLayoutManager(this));
        xList.bind(peoples, new People.BindPolicy(R.layout.people_item)).onItemClick(new XListOnItemClickListener() {
            @Override
            public void onItemClick(View v, Object data) {
                People people = (People) data;
                Log.i("Leagmain", "click happened " + people.getName());
            }
        });
    }
}
