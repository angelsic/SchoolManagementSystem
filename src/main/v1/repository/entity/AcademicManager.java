package main.v1.repository.entity;

import main.v1.exception.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class AcademicManager implements AcademicServicesI{
    private ArrayList<Student> students;
    private ArrayList<Course> courses;

    private HashMap<Course, List<Student>> studentxcourse;

    public AcademicManager(){
        this.students = new ArrayList<Student>();
        this.courses = new ArrayList<Course>();
        this.studentxcourse = new HashMap<Course, List<Student>>();
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    public HashMap<Course, List<Student>> getStudentxcourse() {
        return studentxcourse;
    }

    public void setStudentxcourse(HashMap<Course, List<Student>> studentxcourse) {
        this.studentxcourse = studentxcourse;
    }

    @Override
    public void assignStudent(Student student) throws StudentNotEnrolledException {
        if(this.students.stream().anyMatch(student1 -> student1.getId() == student.getId())){
            throw new StudentNotEnrolledException("Student already assign");
        }else{
            this.students.add(student);
        }
    }

    @Override
    public void addCourse(Course course) throws CourseAlreadyCreatedException {
        if(this.courses.stream().anyMatch(course1 -> course1.getId() == course.getId())){
            throw new CourseAlreadyCreatedException("Curse already created");
        }else{
            this.courses.add(course);
        }
    }

    @Override
    public void enrollStudentCourse(Student student, int idCourse) throws StudentAlreadyEnrolledException, CourseNotValidException {
        Course course = (Course) this.courses.stream().filter(course1 -> course1.getId() == idCourse).collect(Collectors.toList()).get(0);
        if(course.getName() == null){
            throw new CourseNotValidException("Not valid Course");
        }
        if(!this.studentxcourse.containsKey(course)){
            this.studentxcourse.computeIfAbsent(course, k -> new ArrayList<>()).add(student);
        }else{
            ArrayList<Student> students = (ArrayList<Student>) this.studentxcourse.get(course);
            if(students.stream().anyMatch(student1 -> student1.getId() == student.getId())){
                throw new StudentAlreadyEnrolledException("Student exists in course");
            }else {
                this.studentxcourse.get(course).add(student);
            }
        }
    }

    @Override
    public void unEnrollStudentCourse(int idStudent, int idCourse) throws CourseNotValidException, StudentNotEnrolledException {
        Course course = (Course) this.courses.stream().filter(course1 -> course1.getId() == idCourse).collect(Collectors.toList()).get(0);
        if(course.getName() == null){
            throw new CourseNotValidException("Not valid Course");
        }
        ArrayList<Student> students = (ArrayList<Student>) this.studentxcourse.get(course);
        if(!students.stream().anyMatch(student1 -> student1.getId() == idStudent)){
            throw new StudentNotEnrolledException("Student not exists in course");
        }else {
            this.studentxcourse.get(course).remove(students.stream().filter(a -> a.getId() == idStudent).collect(Collectors.toList()).get(0));
        }
    }
}
