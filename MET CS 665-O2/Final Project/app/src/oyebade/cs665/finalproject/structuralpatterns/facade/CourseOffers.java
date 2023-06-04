package oyebade.cs665.structural.facade;

public class CourseOffers {

    public void addCourse(Course courseName) {

        System.out.println("The CS Department is offering " + courseName.getCourseName() +
                " to students.");
    }

    public void notify(Course courseName) {

        System.out.println("CS Department faculty has been notified that the "  +
                courseName.getCourseName() + " class is full.");
    }
}
