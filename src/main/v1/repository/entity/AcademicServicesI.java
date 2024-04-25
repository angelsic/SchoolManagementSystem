package main.v1.repository.entity;

import main.v1.exception.*;

public interface AcademicServicesI {
    void assignStudent(Student student) throws StudentNotAssignException, StudentNotEnrolledException;

    void addCourse(Course course) throws CourseAlreadyCreatedException;

    void enrollStudentCourse(Student student, int idCourse) throws StudentAlreadyEnrolledException, CourseNotValidException;

    void unEnrollStudentCourse(int idStudent, int idCourse) throws StudentNotEnrolledException, CourseNotValidException;
}
