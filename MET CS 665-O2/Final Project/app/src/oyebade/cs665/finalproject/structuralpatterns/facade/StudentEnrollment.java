package oyebade.cs665.structural.facade;

import java.util.*;

public class StudentEnrollment {
    public void drop(Student studentName, Course courseName) {

        System.out.println(studentName.getStudentName() + " is dropping out of " + courseName.getCourseName());
    }

    public void enroll(Student studentName, Course courseName) {

        System.out.println(studentName.getStudentName() + " is enrolling in " + courseName.getCourseName());

    }

    public List<String> getStudentsEnrolled(String student) {
        System.out.println(student);
        return Collections.singletonList(student);
    }
}
