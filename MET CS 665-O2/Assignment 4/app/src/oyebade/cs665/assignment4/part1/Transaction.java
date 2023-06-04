package oyebade.cs665.part1;

// Transaction (Parent Class)
public abstract class Transaction {

    String description = "Transaction::";

    // get the transaction description
    public String getDescription() {
        return description;
    }
}

/**
 * Method is creating a DepositTransaction(subclass) class which is being inherited from the
 *      Transaction(parent class) abstract class.
 */
class DepositTransaction extends Transaction {

    // get the deposit transaction description
    public DepositTransaction() {
        description = getDescription() + "DepositTransaction";
    }
}

/**
 * Method is creating a WithdrawTransaction(subclass) class which is being inherited from the
 *      Transaction(parent class) abstract class.
 */
class WithdrawTransaction extends Transaction {

    // get the withdrawal transaction description
    public WithdrawTransaction() {
        description = getDescription() + "WithdrawTransaction";
    }
}

