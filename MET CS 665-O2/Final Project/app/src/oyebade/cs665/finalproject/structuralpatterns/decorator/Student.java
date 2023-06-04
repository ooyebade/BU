package oyebade.cs665.structural.decorator;

public class Student extends Course {

    String courseName;

    public Student(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseName() {
        return courseName;
    }
}
