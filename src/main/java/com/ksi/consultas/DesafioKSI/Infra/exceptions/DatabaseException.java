package com.ksi.consultas.DesafioKSI.Infra.exceptions;

public class DatabaseException extends RuntimeException{
    public DatabaseException(String message) {
        super(message);
    }
}