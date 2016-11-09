package com.leagmain.xlist;

import android.support.v4.widget.ContentLoadingProgressBar;
import android.view.View;

/**
 * Created by Leon on 11/1/2016.
 */

public abstract class XListCommonBindPolicy<DT> extends XListBindPolicy<DT> {
    @Override
    public void forFooter(View footer) {
    }

    @Override
    public void forEmpty(View itemView) {
    }

    @Override
    public int getFooterRes() {
        return R.layout.default_loading;
    }

    @Override
    public int getEmptyRes() {
        return R.layout.default_empty;
    }
}
