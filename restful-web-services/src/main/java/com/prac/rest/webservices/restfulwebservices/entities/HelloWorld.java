package com.prac.rest.webservices.restfulwebservices.entities;

public class HelloWorld {
    private String msg;

    public HelloWorld(String msg){
        this.msg = msg;
    }
    @Override
    public String toString() {
        return "HelloWorld{" +
                "msg='" + msg + '\'' +
                '}';
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
