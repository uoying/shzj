package com.ruoyi.shzj.util;

public class Json {
    String msg;
    Object data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Json{" +
                "msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
