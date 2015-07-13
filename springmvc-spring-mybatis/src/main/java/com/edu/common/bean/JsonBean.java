package com.edu.common.bean;

/**
 * Created by lc on 2015/6/24.
 */
public class JsonBean {
    /**
     * json返回编号0代表成功,1代表失败，如果为1时，必须得有返回错误原因message
     */
    private int id;

    /**
     * 返回错误原因处message
     */
    private String message;

    public JsonBean(int id, String message) {
        this.id = id;
        this.message = message;
    }

    public JsonBean() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", message='" + message + '\'' +
                '}';
    }
}
