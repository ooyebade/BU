package oyebade.cs665.structural.decorator;


// Semester (parent class)
public abstract class Semester {
    String semesterName = "Semester Name:: ";

    // get each semester
    public String getSemesterName() {
        return semesterName;
    }
}

/**
 * Method is creating a FallSemester(subclass) class which is being inherited from the
 *      Semester(parent class) abstract class.
 */
class FallSemester extends Semester {

    // get the fall semester name
    public FallSemester() {
        semesterName = getSemesterName() + "Fall Semester";
    }
}


/**
 * Method is creating a SpringSemester(subclass) class which is being inherited from the
 *      Semester(parent class) abstract class.
 */
class SpringSemester extends Semester {

    // get the fall semester name
    public SpringSemester() {
        semesterName = getSemesterName() + "Spring Semester";
    }
}

/**
 * Method is creating a SummerSemester(subclass) class which is being inherited from the
 *      Semester(parent class) abstract class.
 */
class SummerSemester extends Semester {

    // get the fall semester name
    public SummerSemester() {
        semesterName = getSemesterName() + "Summer Semester";
    }
}


