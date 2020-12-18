package com.exceptions;

public class StatusCheck extends RuntimeException{
    public StatusCheck(String statusSomeone){
        super(statusSomeone);
    }
}
