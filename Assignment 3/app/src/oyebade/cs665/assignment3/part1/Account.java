package oyebade.cs665.part1;

abstract class Account {
}

class CheckingAccount extends Account {
    public String toString() {
        return "**Basic Checking Account**";
    }
}

class SavingsAccount extends Account {
    public String toString() {
        return "**Basic Savings Account**";
    }
}

class BankOfAmericaCheckingAccount extends CheckingAccount {
    public String toString() {
        return super.toString() + "::" + "Bank of America Checking Account";
    }
}

class BankOfAmericaSavingsAccount extends SavingsAccount {
    public String toString() {
        return super.toString() + "::" + "Bank of America Savings Account";
    }
}

class NFCUCheckingAccount extends CheckingAccount {
    public String toString() {
        return super.toString() + "::" + "Navy Federal Credit Union Checking Account";
    }
}

class NFCUSavingsAccount extends SavingsAccount {
    public String toString() {
        return super.toString() + "::" + "Navy Federal Credit Union Savings Account";
    }
}