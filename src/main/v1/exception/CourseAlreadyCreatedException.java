package main.v1.exception;

public class CourseAlreadyCreatedException extends Exception{
    public CourseAlreadyCreatedException(String msg){
        super(msg);
    }
}
