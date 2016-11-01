package com.leagmain.xlist;

import android.support.v7.widget.RecyclerView;

/**
 * Created by Leon on 11/1/2016.
 */

public class XListScrollHelper {
    private XList xList;
    private XListPositionHelper positionHelper;
    private RecyclerView.LayoutManager layoutManager;

    public XListScrollHelper(XList xList) {
        this.xList = xList;
        positionHelper = new XListPositionHelper(xList);
        layoutManager = xList.getLayoutManager();
    }

    public boolean isHitBottom() {
        int totalItemCount = layoutManager.getItemCount();
        int visibleItemCount = layoutManager.getChildCount();
        int firstVisiblePosition = positionHelper.findFirstVisibleItemPosition();
        return (totalItemCount - visibleItemCount) <= firstVisiblePosition;
    }

}
