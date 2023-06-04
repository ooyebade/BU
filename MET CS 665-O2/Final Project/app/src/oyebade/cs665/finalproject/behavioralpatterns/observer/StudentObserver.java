package oyebade.cs665.behavioral.observer;


public class StudentObserver implements Observer {

    // instance variables
    // observer value
    private String s;
    // observer name
    private String name;
    // observer ID
    private int ID;
    // observer program
    private String program;
    // observer course
    private String courses;

    double credit;
    double points;


    public StudentObserver(String name, int ID, String program, String courses, double points,
                           double credit) {
        this.name = name;
        this.ID = ID;
        this.program = program;
        this.courses = courses;
        this.points = points;
        this.credit = credit;
    }

    public double GPA() {
        return ((points / credit));
    }

    @Override
    public void update(String s) {
        this.s = s;
        display();
    }

    public void display() {
        System.out.println("Student Information: " +
                "\nID: " + ID +
                "\nName: " + name +
                "\nProgram: " + program +
                "\nCourse: " + courses +
                "\nGPA: " + GPA());
    }
}
