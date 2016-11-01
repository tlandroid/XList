package com.leagmain.xlist;

import android.support.annotation.IdRes;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by leagmain on 10/17/2016.
 */

class XListViewHolder extends RecyclerView.ViewHolder {

    public XListViewHolder(View itemView) {
        super(itemView);
    }

    public View findViewById(@IdRes int viewId) {
        return itemView.findViewById(viewId);
    }
}
