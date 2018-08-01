package com.dhxz.prospring5.ch5;

public class ErrorBean {
    public void errorProneMehtod() throws Exception {
        throw new Exception("Generic Exception");
    }
    public void otherErrorProneMehtod() throws IllegalArgumentException{
        throw new IllegalArgumentException("IllegalArgument Exception");
    }
}
