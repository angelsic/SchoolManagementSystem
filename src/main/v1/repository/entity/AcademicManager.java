package main.v1.repository.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AcademicManager {
    private ArrayList<Student> students;
    private ArrayList<Course> courses;

    private HashMap<Course, List<Student>> studentxcourse;

    public AcademicManager(){
        this.students = new ArrayList<>();
        this.courses = new ArrayList<>();
        this.studentxcourse = new HashMap<>();
    }

    public void addStudent(Student student){
        this.students.add(student);
    }

    public void removeStudent(Student student){
        this.students.remove(student);
    }

    public void addCourse(Course course){
        this.courses.add(course);
    }

    public void removeCourse(Course course){
        this.courses.remove(course);
    }

    public void enrollStudentCourse(Student student, Course course){
        if(!this.studentxcourse.containsKey(course)){
            this.studentxcourse.put(course, new ArrayList<>());
        }
        this.studentxcourse.get(course).add(student);
    }

    public ArrayList<Student> getStudentCourse (Course course){
        if(this.studentxcourse.containsKey(course)){
            return (ArrayList<Student>) studentxcourse.get(course);
        }else {
            return new ArrayList<>();
        }
    }

}
