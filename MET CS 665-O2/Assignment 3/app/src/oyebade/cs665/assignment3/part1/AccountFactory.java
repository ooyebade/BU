package oyebade.cs665.part1;

// Abstract Factory
class AccountFactory {
    // creating the checking account
    CheckingAccount createCheckingAccount() {
        return new CheckingAccount();
    }

    // creating the savings account
    SavingsAccount createSavingsAccount() {
        return new SavingsAccount();
    }
}

// Concrete Factory - Bank of American Account Factory
class BankOfAmericaAccountFactory extends AccountFactory {
    @Override
    public CheckingAccount createCheckingAccount() {
        return new BankOfAmericaCheckingAccount();
    }

    @Override
    public SavingsAccount createSavingsAccount() {
        return new BankOfAmericaSavingsAccount();
    }

}

// Concrete Factory - Navy Federal Credit Union Account Factory
class NavyFederalCreditUnionAccountFactory extends AccountFactory {
    @Override
    public CheckingAccount createCheckingAccount() {
        return new NFCUCheckingAccount();
    }

    @Override
    public SavingsAccount createSavingsAccount() {
        return new NFCUSavingsAccount();
    }
}