package com.leagmain.app;

import android.support.annotation.LayoutRes;
import android.view.View;

/**
 * Created by leagmain on 10/17/2016.
 */

public abstract class XListBindPolicy<DATA_TYPE> {


    public abstract
    @LayoutRes
    int getNormalRes();

    public abstract
    @LayoutRes
    int getFooterRes();

    public abstract
    @LayoutRes
    int getEmptyRes();

    public abstract void forNormal(View itemView, int position, DATA_TYPE data);

    public abstract void forFooter(View footer);

    public abstract void forEmpty(View itemView);
}
