package oyebade.cs665.part2;

import java.util.LinkedList;


// the common interface
interface BankBuilder {

    void createHeader();
    void createSidebar();
    void createMainPanel();
    void createFooter();
    UserInterface getUI();
}

// creating the bank of america class which extends the bank builder interface
// Bank of America Builder class
class BankOfAmericaBuilder implements BankBuilder {
    private final String bankName;
    /**private String customerId;
    private String customerName;
    private Date registrationDate; **/
    private final UserInterface userInterface;

    public BankOfAmericaBuilder(String bank) {
        userInterface = new UserInterface();
        this.bankName = bank;
        /**this.customerId = customerId;
        this.customerName = customerName;
        this.registrationDate = registrationDate; **/
    }

    public void createHeader() {
        // creating bank of america header
        userInterface.add("Step 1: Creating " + this.bankName + " Header...");
    }

    public void createSidebar() {
        // creating bank of america sidebar
        userInterface.add("Step 2: Creating " + this.bankName + " Sidebar...");
    }

    public void createMainPanel() {
        // creating bank of america main panel
        userInterface.add("Step 3: Creating " + this.bankName + " Main Panel...");
    }

    public void createFooter() {
        // creating bank of america sidebar
        userInterface.add("Step 4: Creating " + this.bankName + " Footer...");
    }

    public UserInterface getUI() {
        return userInterface;
    }
}

// creating the navy federal credit union class which extends the bank builder interface
// Navy Federal Credit Union Builder class
class NavyFederalCreditUnionBuilder implements BankBuilder {
    private final String bankName;
    /**private String customerId;
     private String customerName;
     private Date registrationDate; **/
    private final UserInterface userInterface;

    public NavyFederalCreditUnionBuilder(String bank) {
        userInterface = new UserInterface();
        this.bankName = bank;
        /**this.customerId = customerId;
         this.customerName = customerName;
         this.registrationDate = registrationDate; **/
    }

    public void createHeader() {
        // creating bank of america header
        userInterface.add("Step 1: Creating " + this.bankName + " Header...");
    }

    public void createSidebar() {
        // creating bank of america sidebar
        userInterface.add("Step 2: Creating " + this.bankName + " Sidebar...");
    }

    public void createMainPanel() {
        // creating bank of america main panel
        userInterface.add("Step 3: Creating " + this.bankName + " Main Panel...");
    }

    public void createFooter() {
        // creating bank of america sidebar
        userInterface.add("Step 4: Creating " + this.bankName + " Footer...");
    }

    public UserInterface getUI() {
        return userInterface;
    }
}


// user interface class (product)
class UserInterface {

    private final LinkedList<String> parts;
    public UserInterface() {
        parts = new LinkedList<>();
    }

    public void add(String part) {
        // adding parts
        parts.addLast(part);
    }

    public void showUserInterface() {
        System.out.println("\nUser Interface completed as below: ");
        for (String part: parts) {
            System.out.println(part);
        }
    }
}

// Bank Director
class BankDirector {
    BankBuilder bankBuilder;
    // using Director to help understand the builder and the sequence of steps
    public void construct(BankBuilder bankBuilder) {
        this.bankBuilder = bankBuilder;
        bankBuilder.createHeader();
        bankBuilder.createSidebar();
        bankBuilder.createMainPanel();
        bankBuilder.createFooter();
    }
}

public class BanksUserInterface {

    public static void main(String[] args) {

        System.out.println("--Testing Bank of America version of UI--");
        BankDirector bankDirector = new BankDirector();

        // making bank of america
        BankBuilder boaBuilder = new BankOfAmericaBuilder("Bank of America");
        bankDirector.construct(boaBuilder);
        UserInterface ui1 = boaBuilder.getUI();
        ui1.showUserInterface();

        System.out.println("\n");

        System.out.println("--Testing Navy Federal Credit Union version of UI--");
        // making navy federal credit union
        BankBuilder nfcuBuilder = new NavyFederalCreditUnionBuilder("Navy Federal Credit Union");
        bankDirector.construct(nfcuBuilder);
        UserInterface ui2 = nfcuBuilder.getUI();
        ui2.showUserInterface();
    }
}
