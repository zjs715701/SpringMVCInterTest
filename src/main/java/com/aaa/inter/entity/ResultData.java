package com.aaa.inter.entity;

public class ResultData {
     boolean state;
     String message;
     Object data;

    public ResultData(boolean state, String message, Object data) {
        this.state = state;
        this.message = message;
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResultData{" +
                "state=" + state +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
