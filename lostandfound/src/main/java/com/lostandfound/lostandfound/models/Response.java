package com.lostandfound.lostandfound.models;

public class Response<T> {
    private String error;
    private T data;

    public Response(T data) {
        this.data = data;
    }

    public Response(String error, T data) {
        this(data);
        this.error = error;
    }

    public String getError() {
        return this.error;
    }

    public T getData() {
        return this.data;
    }
}