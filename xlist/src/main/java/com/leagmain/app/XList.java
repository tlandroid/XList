package com.leagmain.app;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

/**
 * Created by leagmain on 10/17/2016.
 */

public class XList extends RecyclerView {

    private XListOnLoadMoreListener loadMoreListener;
    private int previousDataSize = 0;
    private OnScrollListener onScrollListener = new OnScrollListener() {
        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            LayoutManager layoutManager = recyclerView.getLayoutManager();
            XListPositionHelper positionHelper = new XListPositionHelper(XList.this);
            int totalItemCount = layoutManager.getItemCount();
            int visibleItemCount = layoutManager.getChildCount();
            int firstVisiblePosition = positionHelper.findFirstVisibleItemPosition();
            boolean bottomEdgeHit = (totalItemCount - visibleItemCount) <= firstVisiblePosition;

            XListData xListData = (XListData) getAdapter();
            if (bottomEdgeHit // hit bottom
                    && xListData.getDataSize() != 0 // empty list
                    && loadMoreListener != null) { // load more enabled
                if (previousDataSize != xListData.getDataSize()) {
                    previousDataSize = xListData.getDataSize();
                    loadMoreListener.onLoadMore();
                }
            }
        }
    };

    public XList(Context context) {
        this(context, null);
    }

    public XList(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public XList(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        addOnScrollListener(onScrollListener);
    }

    void setOnLoadMoreListener(XListOnLoadMoreListener loadMoreListener) {
        this.loadMoreListener = loadMoreListener;
    }

    public <DATA_TYPE> XListHelper<DATA_TYPE> policy(XListBindPolicy<DATA_TYPE> policy) {
        return new XListHelper<>(this, policy);
    }
}
