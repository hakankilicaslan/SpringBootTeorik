package com.hakan.demo.exception;

import lombok.Getter;

@Getter
public class DemoException extends RuntimeException{
    private final ErrorType errorType;

    public DemoException(ErrorType errorType) {
        super(errorType.getMesaj());
        this.errorType = errorType;
    }
    public DemoException(ErrorType errorType,String mesaj) {
        super(mesaj);
        this.errorType = errorType;
    }

}
