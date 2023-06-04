package oyebade.cs665.part1;

import java.util.Date;

/**
 * Method is creating a TransactionDecorator(subclass) class which is being inherited from the
 *      Transaction(parent class) abstract class.
 */
public abstract class TransactionDecorator extends Transaction {

    Transaction myTransaction;
    public abstract String getDescription();
}

/**
 * Method is creating a LoggingDecorator(subclass) class which is being inherited from the
 *      TransactionDecorator(parent class) abstract class.
 */
class LoggingDecorator extends TransactionDecorator {

    public LoggingDecorator(Transaction myTransaction) {
        this.myTransaction = myTransaction;
    }

    public String getDescription() {
        return "Logging @" + new Date() + "-->" + myTransaction.getDescription();
    }
}

/**
 * Method is creating a SecurityDecorator(subclass) class which is being inherited from the
 *      TransactionDecorator(parent class) abstract class.
 */
class SecurityDecorator extends TransactionDecorator {

    public SecurityDecorator(Transaction myTransaction) {
        this.myTransaction = myTransaction;
    }

    public String getDescription() {
        return "Security check @" + new Date() + "-->" + myTransaction.getDescription();
    }
}

