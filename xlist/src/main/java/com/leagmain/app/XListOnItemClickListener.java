package com.leagmain.app;

import android.view.View;

/**
 * Created by leagmain on 10/18/2016.
 */

public interface XListOnItemClickListener<DATA_TYPE> {
    void onItemClick(View v, int position, DATA_TYPE data);
}
