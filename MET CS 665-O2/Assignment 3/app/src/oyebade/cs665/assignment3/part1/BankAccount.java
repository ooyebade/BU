package oyebade.cs665.part1;

public class BankAccount {

    public static void main(String[] args) {

        AccountFactory myAccountFactory = new AccountFactory();

        System.out.println("--Testing Basic Version of Accounts--");

        System.out.println("Creating Checking Account");

        CheckingAccount checkingAccount = myAccountFactory.createCheckingAccount();
        System.out.println(checkingAccount);

        System.out.println("Creating Savings Account");

        SavingsAccount savingsAccount = myAccountFactory.createSavingsAccount();
        System.out.println(savingsAccount + "\n");

        BankOfAmericaAccountFactory boaAccountFactory = new BankOfAmericaAccountFactory();

        System.out.println("--Testing Bank of America version of Accounts--");

        System.out.println("Creating Checking Account");

        BankOfAmericaCheckingAccount boaCheckingAccount =
                (BankOfAmericaCheckingAccount) boaAccountFactory.createCheckingAccount();
        System.out.println(boaCheckingAccount);

        System.out.println("Creating Savings Account");

        BankOfAmericaSavingsAccount boaSavingsAccount =
                (BankOfAmericaSavingsAccount) boaAccountFactory.createSavingsAccount();
        System.out.println(boaSavingsAccount + "\n");

        NavyFederalCreditUnionAccountFactory nfcuAccountFactory = new NavyFederalCreditUnionAccountFactory();

        System.out.println("--Testing Navy Federal Credit Union version of Accounts--");

        System.out.println("Creating Checking Account");

        NFCUCheckingAccount nfcuCheckingAccount =
                (NFCUCheckingAccount) nfcuAccountFactory.createCheckingAccount();
        System.out.println(nfcuCheckingAccount);

        System.out.println("Creating Savings Account");

        NFCUSavingsAccount nfcuSavingsAccount =
                (NFCUSavingsAccount) nfcuAccountFactory.createSavingsAccount();
        System.out.println(nfcuSavingsAccount);


    }
}

