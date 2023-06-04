package oyebade.cs665.creational.builder;

import java.util.*;

// the common interface
abstract class DBuilder {
    String name;
    String chairperson;
    List<String> courses = new ArrayList<>();
    List<String> students = new ArrayList<>();
    List<String> programs = new ArrayList<>();
    List<String> faculty = new ArrayList<>();


    public abstract DBuilder addCourseName();
    public abstract DBuilder addCourseDescription();
    public abstract DBuilder addProgram();
    public abstract DBuilder addFacultyName();
    public abstract DBuilder addSemester();
    public abstract DBuilder addStudentName();
    public abstract DBuilder addEnrollmentLimit();
    public Department build() {
        Department department = new Department();
        department.setName(this.name);
        department.setChairperson(this.chairperson);
        department.addCourses(courses);
        department.addStudents(students);
        department.addPrograms(programs);
        department.addFaculty(faculty);
        return department;
    }
}