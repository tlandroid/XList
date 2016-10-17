package com.leagmain.app;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by leagmain on 10/17/2016.
 */

class XListAdapter extends RecyclerView.Adapter<XListViewHolder> {

    private List source = new ArrayList();

    private XListPolicy xListPolicy;
    private Context context;
    private XListOnItemClickListener onItemClickListener;

    public XListAdapter(Context context, List sourceData, XListPolicy policy) {
        this.xListPolicy = policy;
        this.context = context;
        this.source.addAll(sourceData);
    }

    @Override
    public XListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new XListViewHolder(View.inflate(context, xListPolicy.getContentRes(), null));
    }

    @Override
    public void onBindViewHolder(XListViewHolder holder, int position) {
        final Object data = source.get(position);
        Field[] fields = data.getClass().getDeclaredFields();
        for (Field field : fields) {
            try {
                field.setAccessible(true);
                XListPresenter presenter =
                        xListPolicy.forField(field.getName());
                if (presenter != null) {
                    presenter.show(
                            holder.findViewById(presenter.getViewId()),
                            field.get(data));
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        xListPolicy.forOthers(holder.itemView, data);

        if (onItemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onItemClick(v, data);
                }
            });
        }
    }


    @Override
    public int getItemCount() {
        return source.size();
    }

    public void setOnItemClickListener(XListOnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
