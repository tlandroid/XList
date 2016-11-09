package com.leagmain.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.leagmain.xlist.DividerDecoration;
import com.leagmain.xlist.XList;
import com.leagmain.xlist.XListCommonBindPolicy;
import com.leagmain.xlist.XListHelper;
import com.leagmain.xlist.XListOnItemClickListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AppLauncherActivity extends AppCompatActivity {

    private List<Class<? extends Activity>> demoList = new ArrayList<>();
    private XListHelper<Class<? extends Activity>> listHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_list);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        demoList.add(NormalXListActivity.class);
        demoList.add(NormalXListActivity.class);

        listHelper = XListHelper.create((XList) findViewById(R.id.item_list), new DemoBindPolicy());
        listHelper.bind(demoList)
                .linearLayoutManager(ViewGroup.LayoutParams.MATCH_PARENT, 100)
                .itemDecoration(new DividerDecoration())
                .clickItem(new XListOnItemClickListener<Class<? extends Activity>>() {
                    @Override
                    public void onItemClick(View v, int position, Class<? extends Activity> data) {
                        startActivity(new Intent(AppLauncherActivity.this, data));
                    }
                });


        demoList.add(NormalXListActivity.class);
        demoList.add(NormalXListActivity.class);
        demoList.add(NormalXListActivity.class);
        demoList.add(NormalXListActivity.class);
        demoList.add(NormalXListActivity.class);
        demoList.add(NormalXListActivity.class);
        demoList.add(NormalXListActivity.class);
        demoList.add(NormalXListActivity.class);
        listHelper.addAll(demoList)
                .addAll(demoList)
                .addAll(demoList)
                .addAll(demoList)
                .addAll(demoList);
    }


    private class DemoBindPolicy extends XListCommonBindPolicy<Class<? extends Activity>> {
        @Override
        public int getNormalRes() {
            return R.layout.demo_item;
        }

        @Override
        public void forNormal(View itemView, int position, Class<? extends Activity> data) {
            TextView text = (TextView) itemView;
            text.setText(data.getSimpleName());
        }
    }
}
