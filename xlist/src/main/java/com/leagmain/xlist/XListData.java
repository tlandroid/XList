package com.leagmain.xlist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leagmain on 10/17/2016.
 */

class XListData<DATA_TYPE> extends RecyclerView.Adapter<XListViewHolder> {

    private Context context;

    private boolean enabledLoadMore = false;
    private List<DATA_TYPE> source = new ArrayList<>();
    private XListBindPolicy<DATA_TYPE> xListBindPolicy;
    private XListOnItemClickListener<DATA_TYPE> onItemClickListener;

    public XListData(Context context, XListBindPolicy<DATA_TYPE> policy) {
        this.xListBindPolicy = policy;
        this.context = context;
    }

    @Override
    public XListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case VIEW_TYPES.FOOTER:
                try {
                    return new XListViewHolder(LayoutInflater.from(context).inflate(xListBindPolicy.getFooterRes(), parent, false));
                } catch (Exception e) {
                    throw new IllegalArgumentException(xListBindPolicy.getClass().getSimpleName() + " contains an invalid footer xml resource!");
                }
            case VIEW_TYPES.EMPTY:
                try {
                    return new XListViewHolder(LayoutInflater.from(context).inflate(xListBindPolicy.getEmptyRes(), parent, false));
                } catch (Exception e) {
                    throw new IllegalArgumentException(xListBindPolicy.getClass().getSimpleName() + " contains an invalid empty xml resource!");
                }
            default: // normal
                try {
                    return new XListViewHolder(LayoutInflater.from(context).inflate(xListBindPolicy.getNormalRes(), parent, false));
                } catch (Exception e) {
                    throw new IllegalArgumentException(xListBindPolicy.getClass().getSimpleName() + " contains an invalid normal xml resource!");
                }
        }
    }

    @Override
    public void onBindViewHolder(XListViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case VIEW_TYPES.EMPTY:
                xListBindPolicy.forEmpty(holder.itemView);
                break;
            case VIEW_TYPES.FOOTER:
                xListBindPolicy.forFooter(holder.itemView);
                break;
            case VIEW_TYPES.NORMAL:
                final int pos = position;
                final DATA_TYPE data = source.get(pos);
                xListBindPolicy.forNormal(holder.itemView, pos, data);

                if (onItemClickListener != null) {
                    holder.itemView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            onItemClickListener.onItemClick(v, pos, data);
                        }
                    });
                }
                break;
        }
    }

    public int getItemViewType(int position) {
        if (source.size() == 0) {
            return VIEW_TYPES.EMPTY;
        } else if (source.size() > 0) {
            int last_item = getItemCount() - 1;
            if (position == last_item && enabledLoadMore) {
                return position == 0 ? VIEW_TYPES.EMPTY : VIEW_TYPES.FOOTER;
            }
        }
        return VIEW_TYPES.NORMAL;
    }

    @Override
    public int getItemCount() {
        int itemCount = source.size();
        if (itemCount == 0) itemCount++;
        if (enabledLoadMore) itemCount++;
        return itemCount;
    }

    public int getDataSize() {
        return source.size();
    }

    public void setOnItemClickListener(XListOnItemClickListener<DATA_TYPE> onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    void setLoadMoreEnable(boolean enabledLoadMore) {
        this.enabledLoadMore = enabledLoadMore;
        notifyDataSetChanged();
    }

    public void addAll(List<DATA_TYPE> data) {
        if (enabledLoadMore) {
            // remove the load more view
            source.remove(source.size() - 1);
        }
        int position = source.size();
        int length = data.size();
        source.addAll(data);
        if (position == 0) {
            notifyDataSetChanged();
        } else {
            notifyItemRangeInserted(position, length);
        }
    }

    public void add(DATA_TYPE data) {
        source.add(data);
        notifyItemInserted(source.size() - 1);
    }

    public void addAt(int position, DATA_TYPE data) {
        source.add(position, data);
        notifyItemInserted(position);
    }

    public void setData(int position, DATA_TYPE data) {
        source.set(position, data);
        notifyItemChanged(position);
    }

    public void setSource(DATA_TYPE data) {
        source.clear();
        source.add(data);
        notifyDataSetChanged();
    }

    public void setSource(List<DATA_TYPE> data) {
        source.clear();
        source.addAll(data);
        notifyDataSetChanged();
    }

    public void remove(int position) {
        source.remove(position);
        notifyItemRemoved(position);
    }

    public void clear() {
        source.clear();
        notifyDataSetChanged();
    }

    public static class VIEW_TYPES {
        public static final int NORMAL = 0;
        public static final int FOOTER = 1;
        public static final int EMPTY = 2;
    }
}
