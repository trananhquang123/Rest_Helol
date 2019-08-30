package com.example.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;

import java.util.List;

public class Resource <T> {

    public ResponseEntity<?> responseListData(List<T> listData){
        if(CollectionUtils.isEmpty(listData)){
            return new ResponseEntity<>(Response.succsess(null,"message null"),HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(Response.succsess(listData,"succsess"),HttpStatus.OK);
    }

    public ResponseEntity<?> responseSuccsess(T responseObject ,String message){
        return new ResponseEntity<>(Response.succsess(responseObject,message), HttpStatus.OK);
    }

    public ResponseEntity<?> responseError(String message ,String status){
        return new ResponseEntity<>(Response.error(message), HttpStatus.BAD_REQUEST);
    }
}
