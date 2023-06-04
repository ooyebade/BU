package oyebade.cs665.creational.builder;

import java.util.*;

public class Department {

    String name;
    String chairperson;
    List<String> courses = new ArrayList<>();
    List<String> students = new ArrayList<>();
    List<String> programs = new ArrayList<>();
    List<String> faculty = new ArrayList<>();


    void addCourses(List<String> courses) {
        this.courses = courses;
    }

    void addStudents(List<String> students) {
        this.students = students;
    }

    void addPrograms(List<String> programs) {
        this.programs = programs;
    }

    void addFaculty(List<String> faculty) {
        this.faculty = faculty;
    }

    void depart() {
        System.out.println("Department name: " + name);
        System.out.println(name + " chairperson is: " + chairperson);
        System.out.println("Course Information: ");
        for (String course : courses) {
            System.out.println(" " + course);
        }
        for (String program : programs) {
            System.out.println("   " + program);
        }
        for (String faculties : faculty) {
            System.out.println("   " + faculties);
        }
        System.out.println("Student Information: ");
        for (String student : students) {
            System.out.println("   " + student);
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setChairperson(String chairperson) {
        this.chairperson = chairperson;
    }

    public String toString() {
        StringBuilder display = new StringBuilder();
        display.append("---- ").append(this.name).append(" ----\n");
        display.append("---- ").append(this.chairperson).append(" ----\n");
        for (String course : courses) {
            display.append(course).append("\n");
        }
        for (String program : programs) {
            display.append(program).append("\n");
        }
        for (String facilities : faculty) {
            display.append(facilities).append("\n");
        }
        for (String student : students) {
            display.append(student).append("\n");
        }
        return display.toString();
    }
}
