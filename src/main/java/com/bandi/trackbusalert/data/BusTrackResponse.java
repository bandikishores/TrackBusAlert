
package com.bandi.trackbusalert.data;

import java.io.Serializable;

public class BusTrackResponse implements Serializable
{

    private String msg;
    private Data data;
    private final static long serialVersionUID = 2825992869942507459L;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

}
