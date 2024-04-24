package main.v1;

import main.v1.repository.entity.AcademicManager;
import main.v1.repository.entity.Course;
import main.v1.repository.entity.Student;

import java.util.ArrayList;
import java.util.Date;

public class Main {
    public static void main (String[] args){
        Student student = new Student(1, "Angel", "Sic", new Date(), "graduado");
        Student student2 = new Student(2, "Eduardo", "Morales", new Date(), "graduado");
        Course course = new Course(1, "Matematica", "Matematica II", 5, "1");
        AcademicManager academicManager = new AcademicManager();
        academicManager.enrollStudentCourse(student, course);
        academicManager.enrollStudentCourse(student2, course);
        ArrayList<Student> students = academicManager.getStudentCourse(course);


        System.out.println("---------------Students in Matematica-------------------");
        for (int i = 0; i < students.size(); i++) {
            System.out.println(students.get(i).getName() + " " + students.get(i).getLastname());
        }

    }
}
