package oyebade.cs665.behavioral.observer;

public class StudentAlert {

    public static void main(String[] args) {

        // student subject for the first student
        StudentSubject ss1 = new StudentSubject();

        System.out.println("----First Student Information----");
        System.out.print("\n");

        StudentObserver so1 = new StudentObserver("David Reigns", 1, "Degree Program",
                "MET CS-601", 33, 16);
        CourseObserver co1 = new CourseObserver("Web Application Development",
                "This course focuses on building core competencies " +
                        "in web design and development.", 67);

        // register the observer
        ss1.attach(so1);
        ss1.attach(co1);

        ss1.setValue("");

        ss1.detach(so1);

        System.out.print("\n");

        // student subject for the another student
        StudentSubject ss2 = new StudentSubject();

        System.out.print("----Second Student Information----");
        System.out.print("\n\n");

        StudentObserver so2 = new StudentObserver("Patty Union", 2, "Certificate Program",
                "MET CS-669", 77.2, 24);
        CourseObserver co2 = new CourseObserver("Database Design and Implementation for Business",
                "Students learn the latest relational and object-relational tools and techniques for" +
                        "persistent data and object modeling and management.", 94);

        // register the observer
        ss2.attach(so2);
        ss2.attach(co2);

        // setting the observer value
        ss2.setValue("");
    }
}
