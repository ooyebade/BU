package oyebade.cs665.behavioral.state;

interface CourseState {

    void enrolled(CourseContext context);
    void waitlisted(CourseContext context);
    void takingCourse(CourseContext context);
    void notTakingCourse(CourseContext context);
}

// enrolled state
class CourseEnrolled implements CourseState {
    @Override
    public void enrolled(CourseContext context) {
        System.out.println("Student is already is enrolled in the course");
        context.setCurrentCourseState(new CourseEnrolled());
        System.out.println(context.getCurrentCourseState().toString());
    }

    @Override
    public void waitlisted(CourseContext context) {
        System.out.println("Student is being waitlisted for the course");
    }

    @Override
    public void takingCourse(CourseContext context) {
        System.out.println("Student is taking the course");
        context.setCurrentCourseState(new TakingCourse());
        System.out.println(context.getCurrentCourseState().toString());
    }

    @Override
    public void notTakingCourse(CourseContext context) {
        System.out.println("Student is dropping the course");
    }

    public String toString() {
        return "\t**Student is enrolled now.**";
    }
}

class CourseWaitlisted implements CourseState {

    @Override
    public void enrolled(CourseContext context) {
        System.out.println("Student is already is enrolled in the course");
    }

    @Override
    public void waitlisted(CourseContext context) {
        System.out.println("Student is being waitlisted for the course");
        context.setCurrentCourseState(new CourseWaitlisted());
        System.out.println(context.getCurrentCourseState().toString());
    }

    @Override
    public void takingCourse(CourseContext context) {
        System.out.println("Student is taking the course");
    }

    @Override
    public void notTakingCourse(CourseContext context) {
        System.out.println("Student is dropping the course");
        context.setCurrentCourseState(new NotTakingCourse());
        System.out.println(context.getCurrentCourseState().toString());
    }

    public String toString() {
        return "\t**Student is waitlisted now.**";
    }

}

class TakingCourse implements CourseState {
    @Override
    public void enrolled(CourseContext context) {
        System.out.println("Student is already is enrolled in the course");
        context.setCurrentCourseState(new CourseEnrolled());
        System.out.println(context.getCurrentCourseState().toString());
    }

    @Override
    public void waitlisted(CourseContext context) {
        System.out.println("Student is being waitlisted for the course");
        context.setCurrentCourseState(new CourseWaitlisted());
        System.out.println(context.getCurrentCourseState().toString());
    }

    @Override
    public void takingCourse(CourseContext context) {
        System.out.println("Student is taking the course");
    }

    @Override
    public void notTakingCourse(CourseContext context) {
        System.out.println("Student is dropping the course");
        context.setCurrentCourseState(new NotTakingCourse());
        System.out.println(context.getCurrentCourseState().toString());
    }

    public String toString() {
        return "\t**Student is taking the course now.**";
    }
}

class NotTakingCourse implements CourseState {

    @Override
    public void enrolled(CourseContext context) {
        System.out.println("Student is already is enrolled in the course");
        context.setCurrentCourseState(new CourseEnrolled());
        System.out.println(context.getCurrentCourseState().toString());
    }

    @Override
    public void waitlisted(CourseContext context) {
        System.out.println("Student is being waitlisted for the course");
        context.setCurrentCourseState(new CourseWaitlisted());
        System.out.println(context.getCurrentCourseState().toString());
    }

    @Override
    public void takingCourse(CourseContext context) {
        System.out.println("Student is taking the course");
        context.setCurrentCourseState(new TakingCourse());
        System.out.println(context.getCurrentCourseState().toString());
    }

    @Override
    public void notTakingCourse(CourseContext context) {
        System.out.println("Student is dropping the course");
    }

    public String toString() {
        return "\t**Student is no longer taking the course now.**";
    }
}

class CourseContext {
    private CourseState currentCourseState;
    public CourseContext() {
        this.setCurrentCourseState(new CourseEnrolled());
    }

    public CourseState getCurrentCourseState() {
        return currentCourseState;
    }

    public void setCurrentCourseState(CourseState currentCourseState) {
        this.currentCourseState = currentCourseState;
    }

    public void enrolled() {
        currentCourseState.enrolled(this);
    }

    public void waitlisted() {
        currentCourseState.waitlisted(this);
    }

    public void takingCourse() {
        currentCourseState.takingCourse(this);
    }

    public void notTakingCourse() {
        currentCourseState.notTakingCourse(this);
    }
}

