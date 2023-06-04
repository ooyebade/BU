package oyebade.cs665.creational.simpleFactory;

public class UnivProgram {

    ProgramFactory pFactory;

    public UnivProgram(ProgramFactory pFactory) {
        this.pFactory = pFactory;
    }

    public Program regProgram(String type) {
        Program program;

        program = pFactory.createProgram(type);

        program.graduate();
        program.underGrad();
        program.certificate();

        return program;
    }
}
