package oyebade.cs665.structural.facade;

public class FacadeMain {

    public static void main(String[] args) {

        System.out.println("-----Testing the Facade Pattern-----");
        System.out.print("\n");

        DepartmentFacade courseOfferFacade = new DepartmentFacade();
        Course course = new Course("MET CS-522");
        Student student = new Student("Roman Uso");

        courseOfferFacade.courseOffers.addCourse(course);

        courseOfferFacade.getStudentsEnrolled(student);

        courseOfferFacade.studentEnrollment.enroll(student, course);

        courseOfferFacade.courseOffers.notify(course);

        courseOfferFacade.studentEnrollment.drop(student, course);

        System.out.print("\n\n");

        DepartmentFacade facade = new DepartmentFacade();
        Course course2 = new Course("MET CS-695");
        Student student2 = new Student("Sasha Love");

        facade.courseOffers.addCourse(course2);

        facade.getStudentsEnrolled(student2);

        facade.enroll(student2, course2);

        facade.studentEnrollment.drop(student2, course2);


        System.out.print("\n\n");

        DepartmentFacade facade1 = new DepartmentFacade();

        Course course3 = new Course("MET CS-231");
        Student student3 = new Student("Coco Jones");

        facade1.addCourse(course3);

        facade1.notify(course3);

        facade1.drop(student3, course3);


    }
}
