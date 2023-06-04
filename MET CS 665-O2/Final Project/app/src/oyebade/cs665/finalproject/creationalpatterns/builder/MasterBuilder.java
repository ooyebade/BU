package oyebade.cs665.creational.builder;

public class MasterBuilder extends DBuilder {

    public MasterBuilder() {
        this.name = "Computer Science";
        this.chairperson = "Michelle Williams";
    }

    public DBuilder addCourseName() {
        this.courses.add("MET CS-701 --> Rich Internet Application Development");
        return this;
    }

    public DBuilder addCourseDescription() {
        this.courses.add("Concentrating primarily on building rich client web applications " +
                "in the browser for desktop and mobile devices.");
        return this;
    }

    public DBuilder addProgram() {
        this.programs.add("Degree Program: Master's");
        return this;
    }

    public DBuilder addFacultyName() {
        this.faculty.add("Faculty Name: Solange Rowland");
        return this;
    }

    public DBuilder addSemester() {
        this.courses.add("Semester: Spring");
        return this;
    }

    public DBuilder addEnrollmentLimit() {
        this.courses.add("Enrollment Limit: 86");
        return this;
    }

    public DBuilder addStudentName() {
        this.students.add("Student Name: Esther James");
        return this;
    }
}
