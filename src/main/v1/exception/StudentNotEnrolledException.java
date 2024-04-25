package main.v1.exception;

public class StudentNotEnrolledException extends Exception{
    public StudentNotEnrolledException(String msg){
        super(msg);
    }
}
