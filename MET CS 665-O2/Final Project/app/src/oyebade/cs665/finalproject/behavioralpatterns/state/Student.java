package oyebade.cs665.behavioral.state;

// client
public class Student {
    public static void main(String[] args) {

        // initiating Course is already enrolled
        CourseContext course = new CourseContext();

        // Student already in an enrolled state
        course.enrolled();

        // Student already in an enrolled state
        course.takingCourse();

        course.notTakingCourse();

        course.setCurrentCourseState(new CourseWaitlisted());
        course.waitlisted();
    }
}
