package oyebade.cs665.creational.simpleFactory;

import java.util.ArrayList;
import java.util.List;

public abstract class Program {
    String name;
    String departmentName;
    String enrollment;
    List<String> student = new ArrayList<>();
    List<String> course = new ArrayList<>();

    public String getName() {
        return name;
    }

    public String getDepartmentName() {
        return departmentName;
    }


    public void graduate() {
        System.out.println("Degree Program: " + name);
    }

    public void underGrad() {
        System.out.println("Degree Program: " + name);
    }

    public void certificate() {
        System.out.println("Certificate Program in: " + name);
    }

    public String toString() {
        StringBuilder display = new StringBuilder();
        display.append("---- ").append(name).append(" ----\n");
        display.append(departmentName).append("\n");
        display.append(enrollment).append("\n");
        for (String students : student) {
            display.append(students).append("\n");
        }
        for (String courses : course) {
            display.append(courses + "\n");
        }
        return display.toString();
    }
}

class MastersProgram extends Program {
    public MastersProgram() {
        name = "Master's Degree";
        departmentName = "Computer Science";
        enrollment = "Full-Time";
        student.add("Student Name: Megan Fox");
        course.add("Course Name: MET CS-601 --> Web Application Development");
    }
}

class BachelorProgram extends Program {
    public BachelorProgram() {
        name = "Bachelor's Degree";
        departmentName = "Computer Science";
        enrollment = "Full-Time";
        student.add("Student Name: Roman Uso");
        course.add("Course Name: MET CS-231 --> Programming with C++");
    }
}

class CertificateProgram extends Program {
    public CertificateProgram() {
        name = "Information Security Certificate Program";
        departmentName = "Computer Science & IT";
        enrollment = "Part-Time";
        student.add("Student Name: Summer Walker");
        course.add("Course Name: MET CS-695 --> Cybersecurity");
    }
}