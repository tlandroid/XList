package com.leagmain.app;

import android.support.annotation.LayoutRes;
import android.view.View;

/**
 * Created by leagmain on 10/17/2016.
 */

public abstract class XListPolicy {

    private @LayoutRes int contentRes;

    public XListPolicy(@LayoutRes int layout) {
        contentRes = layout;
    }

    public int getContentRes() {
        return contentRes;
    }

    protected abstract XListPresenter forField(String field);

    public abstract void forOthers(View itemView, Object data);
}
