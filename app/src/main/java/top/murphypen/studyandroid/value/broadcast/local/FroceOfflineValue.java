/*
 * ***************************************
 * Copyright (C) 2018. MurphyPen All rights reserved.
 * web site:www.murphypen.top
 * mail:pengdongjian@gmail.com
 * ***************************************
 */

package top.murphypen.studyandroid.value.broadcast.local;

import java.io.Serializable;

public class FroceOfflineValue implements Serializable {
    final long serialVersionUID = 1L;

    final String msg;
    final boolean isOffline;

    public FroceOfflineValue(String msg, boolean isOffline) {
        this.msg = msg;
        this.isOffline = isOffline;
    }

    public String getMsg() {
        return msg;
    }

    public boolean isOffline() {
        return isOffline;
    }
}
