package main.v1;

import main.v1.exception.CourseAlreadyCreatedException;
import main.v1.exception.CourseNotValidException;
import main.v1.exception.StudentAlreadyEnrolledException;
import main.v1.exception.StudentNotEnrolledException;
import main.v1.repository.entity.AcademicManager;
import main.v1.repository.entity.Course;
import main.v1.repository.entity.Person;
import main.v1.repository.entity.Student;

import java.util.ArrayList;
import java.util.Date;

public class Main {
    public static void main (String[] args) throws StudentNotEnrolledException, CourseAlreadyCreatedException, StudentAlreadyEnrolledException, CourseNotValidException {
        Person student = new Student(1, "Angel", "Sic", new Date(), "graduado");
        Person student2 = new Student(2, "Eduardo", "Morales", new Date(), "graduado");
        Person student3 = new Student(3, "Maria", "Delgado", new Date(), "matriculado");
        Course course = new Course(1, "Matematica", "Matematica II", 5, "1");
        Course course2 = new Course(2, "Computación", "Desarrollo JAVA", 6, "2");
        AcademicManager academicManager = new AcademicManager();

            academicManager.assignStudent((Student) student);
            academicManager.assignStudent((Student) student2);
            academicManager.assignStudent((Student) student3);

            academicManager.addCourse(course);
            academicManager.addCourse(course2);
            //academicManager.addCourse(course2);

            academicManager.enrollStudentCourse((Student) student, course.getId());
            academicManager.enrollStudentCourse((Student) student2, course.getId());
            academicManager.enrollStudentCourse((Student) student3, course.getId());
            academicManager.enrollStudentCourse((Student) student, course2.getId());
            academicManager.enrollStudentCourse((Student) student3, course2.getId());

            academicManager.unEnrollStudentCourse(student.getId(), course.getId());

            for(Course course1: academicManager.getStudentxcourse().keySet()){
                String courseInfo = course1.getId() + " " + course1.getName();
                System.out.println("Course Information: " + courseInfo);
                for(Student student1: academicManager.getStudentxcourse().get(course1)){
                    String studentInfo = student1.getId() + " " + student1.getName() + " " + student1.getLastname();
                    System.out.println(studentInfo);
                }
            }
    }
}
