package oyebade.cs665.part3;

public interface IVerify {
    boolean verifyCustomer(Customer customer);
}

class InHouseVerifier implements IVerify {

    public boolean verifyCustomer(Customer customer) {
        System.out.println("Doing in house verification for " + customer.getName());

        return true;
    }
}

class ABCValidator {
    static boolean validate(String name, String phone) {
        System.out.println("ABC third-party verification for " + name + ", " + phone);

        return true;
    }
}


class ABCAdapter implements IVerify {

    @Override
    public boolean verifyCustomer(Customer customer) {
        return ABCValidator.validate(customer.getName(), customer.getPhone());
    }
}

class XYZChecker {
    public static boolean backgroundCheck(String name, String address) {
        System.out.println("XYZ third-party background verification for " + name + ", " + address);

        return true;
    }
}


