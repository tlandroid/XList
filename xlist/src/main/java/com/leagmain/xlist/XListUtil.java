package com.leagmain.xlist;

/**
 * Created by Leon on 11/1/2016.
 */

public class XListUtil {
    public static boolean isEmpty(XList list) {
        return ((XListData) list.getAdapter()).getDataSize() == 0;
    }
}
