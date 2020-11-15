package challenges.bankCompany;

import java.util.Date;

public class Transaction {
    private final Date timeStamp;
    private final String transactionType;
    private final String transctionDescription;
    private final double amount;

    public Transaction(String transactionType, double amount, String transctionDescription) {
        this.timeStamp = new Date();
        this.transctionDescription = transctionDescription;
        this.transactionType = transactionType;
        this.amount = amount;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public double getAmount() {
        return amount;
    }

    public String getTransctionDescription() {
        return transctionDescription;
    }
}
