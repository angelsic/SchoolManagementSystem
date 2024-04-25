package main.v1.exception;

public class StudentAlreadyEnrolledException extends Exception{
    public StudentAlreadyEnrolledException(String msg){
        super(msg);
    }
}
