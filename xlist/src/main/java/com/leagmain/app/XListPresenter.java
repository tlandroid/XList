package com.leagmain.app;

import android.support.annotation.IdRes;
import android.view.View;

/**
 * Created by leagmain on 10/17/2016.
 */

public abstract class XListPresenter<VIEW_TYPE extends View, DATA_TYPE> {

    private
    @IdRes
    int viewId;

    public XListPresenter(@IdRes int viewId) {
        this.viewId = viewId;
    }

    public
    @IdRes
    int getViewId() {
        return viewId;
    }

    public abstract void show(VIEW_TYPE view, DATA_TYPE value);

}
