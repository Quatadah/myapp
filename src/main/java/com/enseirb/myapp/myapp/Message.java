package com.enseirb.myapp.myapp;

public class Message {
    private String sender;
    private String msg;

    public Message(String sender, String msg){
        this.sender = sender;
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
    public String getSender() {
        return sender;
    }
    public void setSender(String sender) {
        this.sender = sender;
    }
}
