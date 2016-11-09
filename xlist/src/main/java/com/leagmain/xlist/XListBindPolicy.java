package com.leagmain.xlist;

import android.support.annotation.LayoutRes;
import android.view.View;

/**
 * Created by leagmain on 10/17/2016.
 */

public abstract class XListBindPolicy<DATA_TYPE> {


    @LayoutRes
    public abstract int getNormalRes();

    @LayoutRes
    public abstract int getFooterRes();

    @LayoutRes
    public abstract int getEmptyRes();

    public abstract void forNormal(View itemView, int position, DATA_TYPE data);

    public abstract void forFooter(View footer);

    public abstract void forEmpty(View itemView);
}
