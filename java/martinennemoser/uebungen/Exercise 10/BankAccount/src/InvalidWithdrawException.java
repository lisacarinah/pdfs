package src;

public class InvalidWithdrawException extends Exception {
    // public int overdrawAmount = BankAccount.overdrawAmount; // Starke Kopplung!
    public int overdrawAmount;
    
    public InvalidWithdrawException(String msg, int overdrawAmount) {
        super(msg);
        System.out.println(msg);
        this.overdrawAmount = overdrawAmount;
    }
}
