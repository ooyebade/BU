package oyebade.cs665.structural.facade;

import java.util.*;

public class DepartmentFacade {

    CourseOffers courseOffers;
    StudentEnrollment studentEnrollment;

    public DepartmentFacade() {
        courseOffers = new CourseOffers();
        studentEnrollment = new StudentEnrollment();
    }

    public void addCourse(Course courseName) {
        courseOffers.addCourse(courseName);
    }

    public void enroll(Student studentName, Course courseName) {
        studentEnrollment.enroll(studentName, courseName);
    }

    public void drop(Student studentName, Course courseName) {
        studentEnrollment.drop(studentName, courseName);
    }

    public void notify(Course courseName) {
        courseOffers.notify(courseName);
    }

    public List<String> getStudentsEnrolled(Student studentName) {
        return studentEnrollment.getStudentsEnrolled(studentName.getStudentName());
    }

}
