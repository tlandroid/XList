package com.leagmain.xlist;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

/**
 * Created by leagmain on 10/17/2016.
 */

public class XListHelper {
    private XList xList;
    private XListData adapter;
    private XListOnLoadMoreListener onLoadMoreListener;

    public static <DT> XListHelper setup(XList list, XListBindPolicy<DT> policy) {
        XListHelper helper = new XListHelper(list, policy);
        list.setHelper(helper);
        return helper;
    }

    private <DT> XListHelper(XList list, XListBindPolicy<DT> policy) {
        this.xList = list;
        this.adapter = new XListData<>(list.getContext(), policy);
        if (xList.getLayoutManager() == null)
            this.xList.setLayoutManager(new LinearLayoutManager(list.getContext()));
        this.xList.setAdapter(adapter);
        this.xList.addOnScrollListener(new XList_DefaultScrollListener());
    }

    public <DT> XListHelper add(DT data) {
        adapter.add(data);
        return this;
    }

    public <DT> XListHelper addAll(List<DT> dataList) {
        adapter.addAll(dataList);
        return this;
    }

    public <DT> XListHelper addAt(int position, DT data) {
        adapter.addAt(position, data);
        return this;
    }

    public <DT> XListHelper replace(int position, DT data) {
        adapter.setData(position, data);
        return this;
    }

    public XListHelper remove(int position) {
        adapter.remove(position);
        return this;
    }

    public XListHelper clear() {
        adapter.clear();
        return this;
    }

    public <DT> XListHelper bind(List<DT> sourceList) {
        adapter.setSource(sourceList);
        return this;
    }

    public <DT> XListHelper bind(DT source) {
        adapter.setSource(source);
        return this;
    }

    public <DT> XListHelper layoutManager(RecyclerView.LayoutManager layoutManager) {
        xList.setLayoutManager(layoutManager);
        return this;
    }

    public <DT> XListHelper linearLayoutManager(int width, int height) {
        xList.setLayoutManager(XListLinearLayoutManager.create(xList.getContext(), width, height));
        return this;
    }

    public <DT> XListHelper loadMore(XListOnLoadMoreListener loadMoreListener) {
        onLoadMoreListener = loadMoreListener;
        adapter.setLoadMoreEnable(loadMoreListener != null);
        return this;
    }

    public <DT> XListHelper clickItem(XListOnItemClickListener<DT> onClickListener) {
        adapter.setOnItemClickListener(onClickListener);
        return this;
    }

    public XListHelper itemDecoration(RecyclerView.ItemDecoration decoration) {
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
