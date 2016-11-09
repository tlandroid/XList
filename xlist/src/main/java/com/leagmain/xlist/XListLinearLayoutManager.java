package com.leagmain.xlist;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by Leon on 11/1/2016.
 */

public class XListLinearLayoutManager {
    private LinearLayoutManager layoutManager;
    private int width, height;

    private XListLinearLayoutManager(Context context, final int width, int height) {
        this.width = width;
        this.height = height;
        this.layoutManager = new LinearLayoutManager(context) {
            @Override
            public RecyclerView.LayoutParams generateDefaultLayoutParams() {
                return new RecyclerView.LayoutParams(XListLinearLayoutManager.this.width, XListLinearLayoutManager.this.height);
            }
        };
    }

    public static RecyclerView.LayoutManager create(Context context, int width, int height) {
        return new XListLinearLayoutManager(context, width, height).layoutManager;
    }
}
