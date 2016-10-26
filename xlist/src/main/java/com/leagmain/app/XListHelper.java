package com.leagmain.app;

import android.support.v7.widget.LinearLayoutManager;

import java.util.List;

/**
 * Created by leagmain on 10/17/2016.
 */

class XListHelper<DT> {
    private XList xList;
    private XListData<DT> adapter;


    public XListHelper(XList list, XListBindPolicy<DT> policy) {
        this.xList = list;
        this.adapter = new XListData<>(list.getContext(), policy);
        if (xList.getLayoutManager() == null)
            this.xList.setLayoutManager(new LinearLayoutManager(list.getContext()));
        this.xList.setAdapter(adapter);
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

    public XListHelper<DT> enableLoadMore(XListOnLoadMoreListener loadMoreListener) {
        xList.setOnLoadMoreListener(loadMoreListener);
        adapter.setLoadMoreEnable(loadMoreListener != null);
        return this;
    }
}
