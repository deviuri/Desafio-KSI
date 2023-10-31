package com.ksi.consultas.DesafioKSI.Infra.exceptions;

public class NoSuchElementException extends RuntimeException{
    public NoSuchElementException(String msg){
        super(msg);
    }
}