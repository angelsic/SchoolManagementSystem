package main.v1.exception;

public class CourseNotValidException extends Exception{
    public CourseNotValidException(String msg){
        super(msg);
    }
}
