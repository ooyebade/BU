package oyebade.cs665.structural.decorator;

/**
 * Method is creating a SemesterDecorator(subclass) class which is being inherited from the
 *      Semester(parent class) abstract class.
 */
public abstract class SemesterDecorator extends Semester {

    Semester mySemester;
    public abstract String getSemesterName();

}

class FallDecorator extends SemesterDecorator {

    public FallDecorator(Semester mySemester) {
        this.mySemester = mySemester;
    }

    public String getSemesterName() {
        return mySemester.getSemesterName() + " Fall";
    }


}


class SpringDecorator extends SemesterDecorator {

    public SpringDecorator(Semester mySemester) {
        this.mySemester = mySemester;
    }

    public String getSemesterName() {
        return mySemester.getSemesterName() + " Spring";
    }


}


class SummerDecorator extends SemesterDecorator {

    public SummerDecorator(Semester mySemester) {
        this.mySemester = mySemester;
    }

    public String getSemesterName() {
        return mySemester.getSemesterName() + " Summer";
    }

}