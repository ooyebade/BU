package oyebade.cs665.behavioral.observer;


public class CourseObserver implements Observer {

    // observer value
    private String s;
    private String name;
    private String description;
    private int enrollmentLimit;

    public CourseObserver(String name, String description, int enrollmentLimit) {
        this.name = name;
        this.description = description;
        this.enrollmentLimit = enrollmentLimit;
    }

    @Override
    public void update(String s) {
        this.s = s;
        display();
    }

    public void display() {
        System.out.println("Course Information: " +
                "\nCourse Name: " + name +
                "\nDescription: " + description +
                "\nEnrollment Limit: " + enrollmentLimit + s);
    }
}

