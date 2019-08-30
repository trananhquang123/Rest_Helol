package com.example.controller;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Response<T> {

    private String message;


    private T data;



    public Response(){

    }


    public static <T> Response<?> succsess(T responseObject , String message){
        Response<T> res = new Response<>();
        res.setMessage(message);
        res.setData(responseObject);

        return res;
    }

    public static <T> Response<T> error(String message){
        Response<T> res = new Response<>();
        res.setMessage(message);
        return res;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
