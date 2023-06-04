package oyebade.cs665.part3;

public class VerifyTest {

    public static void main(String[] args) {

        IVerify iVerify = new ABCAdapter();

        IVerify verify = new InHouseVerifier();

        boolean verified = verify.verifyCustomer(new Customer("Alice",""));

        boolean isVerified = iVerify.verifyCustomer(new Customer("Alice",
                "222-333-4444"));

        XYZChecker.backgroundCheck("Alice", "123 Main St, Boston, MA");
    }

}

