package com.example.awagallus.w3d1services;

/**
 * Created by HP on 8/16/2017.
 */

public class MessageEvent {
    String action;
    String msg;

    public MessageEvent(String action, String msg) {
        this.action = action;
        this.msg = msg;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
