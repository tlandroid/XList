package com.leagmain.xlist;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.Arrays;
import java.util.List;

/**
 * Created by leagmain on 10/17/2016.
 */

public class XListHelper<DT> {
    private XList xList;
    private XListData<DT> adapter;
    private XListOnLoadMoreListener onLoadMoreListener;

    public static <_DT> XListHelper<_DT> create(XList list, XListBindPolicy<_DT> policy) {
        return new XListHelper<_DT>(list, policy);
    }

    public XListHelper(XList list, XListBindPolicy<DT> policy) {
        this.xList = list;
        this.adapter = new XListData<>(list.getContext(), policy);
        if (xList.getLayoutManager() == null)
            this.xList.setLayoutManager(new LinearLayoutManager(list.getContext()));
        this.xList.setAdapter(adapter);
        this.xList.addOnScrollListener(new XList_DefaultScrollListener());
    }

    public XListHelper<DT> add(DT data) {
        adapter.add(data);
        return this;
    }

    public XListHelper<DT> addAll(List<DT> dataList) {
        adapter.addAll(dataList);
        return this;
    }

    public XListHelper<DT> addAt(int position, DT data) {
        adapter.addAt(position, data);
        return this;
    }

    public XListHelper<DT> replace(int position, DT data) {
        adapter.setData(position, data);
        return this;
    }

    public XListHelper<DT> remove(int position) {
        adapter.remove(position);
        return this;
    }

    public XListHelper<DT> clear() {
        adapter.clear();
        return this;
    }

    public XListHelper<DT> bind(List<DT> sourceList) {
        adapter.setSource(sourceList);
        return this;
    }

    public XListHelper<DT> bind(DT source) {
        adapter.setSource(source);
        return this;
    }

    public XListHelper<DT> layoutManager(RecyclerView.LayoutManager layoutManager) {
        xList.setLayoutManager(layoutManager);
        return this;
    }

    public XListHelper<DT> linearLayoutManager(int width, int height) {
        xList.setLayoutManager(XListLinearLayoutManager.create(xList.getContext(), width, height));
        return this;
    }

    public XListHelper<DT> loadMore(XListOnLoadMoreListener loadMoreListener) {
        onLoadMoreListener = loadMoreListener;
        adapter.setLoadMoreEnable(loadMoreListener != null);
        return this;
    }

    public XListHelper<DT> clickItem(XListOnItemClickListener<DT> onClickListener) {
        adapter.setOnItemClickListener(onClickListener);
        return this;
    }

    public XListHelper<DT> itemDecoration(RecyclerView.ItemDecoration decoration) {
        xList.addItemDecoration(decoration);
        return this;
    }


    private class XList_DefaultScrollListener extends RecyclerView.OnScrollListener {
        private XListScrollHelper scrollHelper;
        private int previousDataSize = 0;

        public XList_DefaultScrollListener() {
            scrollHelper = new XListScrollHelper(xList);
        }

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            XListData xListData = (XListData) xList.getAdapter();
            if (scrollHelper.isHitBottom() // hit bottom
                    && !XListUtil.isEmpty(xList) // empty list
                    && onLoadMoreListener != null) { // load more enabled
                if (previousDataSize != xListData.getDataSize()) {
                    previousDataSize = xListData.getDataSize();
                    onLoadMoreListener.onLoadMore();
                }
            }
        }
    }
}
