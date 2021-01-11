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

        Main.equals(account.amount, 320);
        account.deposit(100);
        Main.equals(account.amount, 420);

        try {
            account.withdraw(500);
            throw new Exception("Must not raised!");
        } catch(InvalidWithdrawException ex) {
            Main.equals(ex.overdrawAmount, 80);
            System.out.println("The overdrawing amount of + " + ex.overdrawAmount + "€ is not possible");
        }
        Main.equals(account.amount, 420);

        try {
            account.withdraw(700);
            throw new Exception("Must not raised!");
        } catch(InvalidWithdrawException ex) {
            Main.equals(ex.overdrawAmount, 280);
            System.out.println("The overdrawing amount of + " + ex.overdrawAmount + "€ is not possible");
        }

        System.out.println("Program works as expected!");
     }
}
