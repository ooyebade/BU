package oyebade.cs665.creational.builder;

public class BachelorBuilder extends DBuilder {

    public BachelorBuilder() {
        this.name = "Computer Science";
        this.chairperson = "Michelle Williams";
    }

    public DBuilder addCourseName() {
        this.courses.add("MET CS-231 --> Programming with C++");
        return this;
    }

    public DBuilder addCourseDescription() {
        this.courses.add("Covering the elements of object-oriented programming and the C++ language.");
        return this;
    }

    public DBuilder addProgram() {
        this.programs.add("Degree Program: Bachelor's");
        return this;
    }

    public DBuilder addFacultyName() {
        this.faculty.add("Faculty Name: Solange Rowland");
        return this;
    }

    public DBuilder addSemester() {
        this.courses.add("Semester: Fall");
        return this;
    }

    public DBuilder addEnrollmentLimit() {
        this.courses.add("Enrollment Limit: 28");
        return this;
    }

    public DBuilder addStudentName() {
        this.students.add("Student Name: Ivy Quinn");
        return this;
    }
}
