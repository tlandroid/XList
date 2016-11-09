package com.leagmain.xlist;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

/**
 * Created by leagmain on 10/17/2016.
 */

public class XList extends RecyclerView {

    public XList(Context context) {
        this(context, null);
    }

    public XList(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public XList(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }
}
