package com.leagmain.xlist;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;

/**
 * Created by Leon on 11/1/2016.
 */

public class DividerDecoration extends RecyclerView.ItemDecoration {

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
        Paint paint = new Paint();
        paint.setColor(Color.GRAY);
        c.drawLine(0, 0, parent.getMeasuredWidth(), 5, paint);
    }
}
