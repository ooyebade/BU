package oyebade.cs665.creational.builder;

public class MainDepartment {

    public static void main(String[] args) {

        DBuilder masterBuilder = new MasterBuilder();

        Department mb = masterBuilder.addStudentName().addProgram().addCourseName().addCourseDescription().
                addSemester().addFacultyName().addEnrollmentLimit().build();
        mb.depart();
        System.out.println(mb);


        DBuilder bachelorBuilder = new BachelorBuilder();

        Department bb = bachelorBuilder.addStudentName().addProgram().addCourseName().addCourseDescription().
                addSemester().addFacultyName().addEnrollmentLimit().build();
        bb.depart();
        System.out.println(bb);


        DBuilder certificateBuilder = new CertificateBuilder();

        Department cb = certificateBuilder.addStudentName().addProgram().addCourseName().addCourseDescription().
                addSemester().addFacultyName().addEnrollmentLimit().build();
        cb.depart();
        System.out.println(cb);
    }
}
