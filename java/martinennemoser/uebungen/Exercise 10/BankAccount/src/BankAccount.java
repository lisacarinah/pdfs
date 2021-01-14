package src;


public class BankAccount {
    private int amount;
    public BankAccount(int initialAmount) {
        this.amount = initialAmount;
    }

    public void deposit(int depositAmount) {
        this.amount = this.amount + depositAmount;
    }

    public void withdraw(int withdrawAmount) throws InvalidWithdrawException {
        if(withdrawAmount > this.amount) {
            int overdrawAmount = Math.abs(this.amount - withdrawAmount);
            throw new InvalidWithdrawException("Cannot withdraw " + withdrawAmount, overdrawAmount);
        }
        this.amount = this.amount - withdrawAmount;
    }

    public int getAmount() {
        return this.amount;
    }
}
