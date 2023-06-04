package oyebade.cs665.structural.decorator;

public class SemesterCourses {

    public static void main(String[] args) {

        Course course = new Course();

        Semester semester1 = new FallSemester();

        // printing out the fall semester statement
        System.out.println("--Testing Fall Semester--");
        semester1 = new FallDecorator(semester1);
        System.out.println(semester1.getSemesterName());
        Student student = new Student( " Web Application Development");
        course.addCourse(student);
        System.out.println("David Adebayo registered for" + student.getCourseName());
        System.out.print("\n");

        Semester semester2 = new SpringSemester();
        // printing out the fall semester statement
        System.out.println("--Testing Spring Semester--");
        semester2 = new SpringDecorator(semester2);
        System.out.println(semester2.getSemesterName());
        Student student1 = new Student( " Web Application Development");
        Student student2 = new Student(" Information Structures with Python");
        Student student3 = new Student(" Software Design and Patterns");
        course.addCourse(student2);
        course.addCourse(student3);
        System.out.println("Michelle Jones registered for" + student2.getCourseName() +
                " &" + student3.getCourseName());
        System.out.println("Michelle Jones dropped" + student1.getCourseName());
        course.removeCourse(student1);

        System.out.print("\n");

        Semester semester3 = new SummerSemester();
        // printing out the fall semester statement
        System.out.println("--Testing Summer Semester--");
        semester3 = new SummerDecorator(semester3);
        System.out.println(semester3.getSemesterName());
        Student student4 = new Student( " Server-Side Web Development");
        Student student5 = new Student(" Rich Internet Application Development");
        Student student6 = new Student(" Artificial Intelligence");
        course.addCourse(student4);
        course.addCourse(student5);
        course.addCourse(student6);
        System.out.println("Jane Smith registered for" + student4.getCourseName() +
                " &" + student5.getCourseName());
        System.out.println("Jane Smith is on the wait-list for" + student6.getCourseName());
        course.removeCourse(student1);
        System.out.print("\n");
    }
}
