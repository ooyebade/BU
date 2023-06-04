package oyebade.cs665.creational.simpleFactory;

public class ProgramFactory {

    public Program createProgram(String type) {
        Program program = null;

        if (type.equals("master's")) {
            program = new MastersProgram();
        }
        else if (type.equals("bachelor's")) {
            program = new BachelorProgram();
        }
        else if (type.equals("certificate")) {
            program = new CertificateProgram();
        }
        return program;
    }
}
