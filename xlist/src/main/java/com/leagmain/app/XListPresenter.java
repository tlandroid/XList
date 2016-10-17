package com.leagmain.app;

import android.support.annotation.IdRes;
import android.view.View;

/**
 * Created by leagmain on 10/17/2016.
 */

public abstract class XListPresenter<VT extends View> {

    private
    @IdRes
    int viewId;

    public XListPresenter(@IdRes int viewId) {
        this.viewId = viewId;
    }

    public @IdRes int getViewId() {
        return viewId;
    }

    public abstract void show(VT view, Object value);

}
