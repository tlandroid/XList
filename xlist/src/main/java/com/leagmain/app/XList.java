package com.leagmain.app;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

import java.util.List;

/**
 * Created by leagmain on 10/17/2016.
 */

public class XList extends RecyclerView {

    private Context context;

    public XList(Context context) {
        this(context, null);
    }

    public XList(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public XList(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.context = context;
    }

    public XList bind(List data, XListPolicy policy) {
        setAdapter(new XListAdapter(context, data, policy));
        return this;
    }

    public void onItemClick(XListOnItemClickListener clickListener) {
        Adapter adapter = getAdapter();
        if (adapter != null) {
            XListAdapter xListAdapter = (XListAdapter) adapter;
            xListAdapter.setOnItemClickListener(clickListener);
        }
    }
}
