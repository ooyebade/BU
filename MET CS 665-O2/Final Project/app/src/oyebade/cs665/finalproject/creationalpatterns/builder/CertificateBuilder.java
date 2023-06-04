package oyebade.cs665.creational.builder;

public class CertificateBuilder extends DBuilder {

    public CertificateBuilder() {
        this.name = "Computer Science";
        this.chairperson = "Michelle Williams";
    }

    public DBuilder addCourseName() {
        this.courses.add("MET CS-695 --> Cybersecurity");
        return this;
    }

    public DBuilder addCourseDescription() {
        this.courses.add("Introducing fundamental concepts, principles of cybersecurity" +
                " and their use in the development of security mechanisms and policies");
        return this;
    }

    public DBuilder addProgram() {
        this.programs.add("Degree Program: Digital Forensics Certificate");
        return this;
    }

    public DBuilder addFacultyName() {
        this.faculty.add("Faculty Name: Solange Rowland");
        return this;
    }

    public DBuilder addSemester() {
        this.courses.add("Semester: Summer");
        return this;
    }

    public DBuilder addEnrollmentLimit() {
        this.courses.add("Enrollment Limit: 50");
        return this;
    }

    public DBuilder addStudentName() {
        this.students.add("Student Name: Jennifer Hudson");
        return this;
    }
}
