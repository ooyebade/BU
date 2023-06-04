package oyebade.cs665.structural.decorator;

import java.util.*;

class Course {

    ArrayList<Course> courses;

    public Course(){
        courses = new ArrayList<>();
    }
    // get each course
    public ArrayList<Course> getCourse() {
        return courses;
    }

    public void addCourse(Course courses) {
        this.courses.add(courses);
    }

    public void removeCourse(Course courses) {
        this.courses.remove(courses);
    }
}
