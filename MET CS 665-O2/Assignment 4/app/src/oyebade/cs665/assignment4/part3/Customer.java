package oyebade.cs665.part3;

// creating a customer class
public class Customer {
    // customer name
    String name;
    // customer phone number
    String phone;

    public Customer(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }
}

