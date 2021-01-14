package src;

public class Main {

    private static void equals(int a, int b) throws NotMatchingException {
        if(a != b) {
            throw new NotMatchingException("Values do not match.");
        }
    }

    public static void main(String[] args) throws Exception {
        // DO NOT MODIFY!
        BankAccount account = new BankAccount(300);
        account.deposit(50);
        account.withdraw(30);

        Main.equals(account.getAmount(), 320);
        account.deposit(100);
        Main.equals(account.getAmount(), 420);

        try {
            account.withdraw(500);
            throw new Exception("Must not raised!");
        } catch(InvalidWithdrawException ex) {
            Main.equals(ex.overdrawAmount, 80);
            System.out.println("The overdrawing amount of + " + ex.overdrawAmount + "€ is not possible");
        }
        Main.equals(account.getAmount(), 420);

        try {
            account.withdraw(700);
            throw new Exception("Must not raised!");
        } catch(InvalidWithdrawException ex) {
            Main.equals(ex.overdrawAmount, 280);
            System.out.println("The overdrawing amount of + " + ex.overdrawAmount + "€ is not possible");
        }

        /// Bitcoins
        BitcoinAccount bitcoinAccount = new BitcoinAccount();
        bitcoinAccount.buyBitcoins(5);
        try {
            bitcoinAccount.sellBitcoins(8);
        }
        catch (InvalidWithdrawException ex) {
            System.out.println(ex.toString());
            Main.equals(ex.overdrawAmount, 3);
            System.out.println(ex.overdrawAmount + " bitcoins are not available.");
        }
        System.out.println("Program works as expected!");
     }
}
