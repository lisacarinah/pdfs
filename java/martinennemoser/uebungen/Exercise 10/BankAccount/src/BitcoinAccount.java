package src;

public class BitcoinAccount {
    int bitcoins = 0;

    public void buyBitcoins(int numBitcoins) {
        this.bitcoins = this.bitcoins + numBitcoins;
    }
    public void sellBitcoins(int numBitcoins) throws InvalidWithdrawException {
        if(numBitcoins > this.bitcoins) {
            throw new InvalidWithdrawException("Cannot sell bitcoins. Not sufficient bitcoins available.", numBitcoins - this.bitcoins);
        }
        this.bitcoins = this.bitcoins - numBitcoins;
    }
}
