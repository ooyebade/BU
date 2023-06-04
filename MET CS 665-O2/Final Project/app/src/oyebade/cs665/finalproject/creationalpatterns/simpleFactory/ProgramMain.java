package oyebade.cs665.creational.simpleFactory;

public class ProgramMain {

    public static void main(String[] args) {

        ProgramFactory pFactory = new ProgramFactory();
        UnivProgram program = new UnivProgram(pFactory);

        Program myProgram = program.regProgram("master's");
        System.out.println("Student is enrolling in the " + myProgram.getDepartmentName() + " " +
                myProgram.getName());
        System.out.println(myProgram);


        myProgram = program.regProgram("bachelor's");
        System.out.println("Student is enrolling in the " + myProgram.getDepartmentName() + " " +
                myProgram.getName());
        System.out.println(myProgram);

        myProgram = program.regProgram("certificate");
        System.out.println("Student is enrolling in the " + myProgram.getDepartmentName() + " " +
                myProgram.getName());
        System.out.println(myProgram);
    }
}
