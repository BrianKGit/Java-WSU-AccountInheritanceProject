/*
 * Author: Brian Klein and Aaron Olsen
 * Date: 9/25/17
 * Program: SavingAccount.java
 * Description: user defined class
 */

public class SavingAccount extends Account{
    
    //constants
    private final double PERCENTAGE = 100;
    
    //variables
    private double intRate, interest;

    public SavingAccount() {
    }

    public SavingAccount(double intRate, double acctBal) {
        super(acctBal);
        this.intRate = intRate;
    }

    public double getIntRate() {
        return intRate;
    }

    public void setIntRate(double intRate) {
        this.intRate = intRate;
    }
    
    public double calculateInterest(double intRate) {
        interest = (intRate/PERCENTAGE) * this.getAcctBal();
        super.setAcctBal((interest + this.getAcctBal()));
        return interest;
    }

    @Override
    public String toString() {
        return super.toString() +
                String.format("%nInterest Rate Percentage: %.2f%%" +
                "%nInterest Gained: $%.2f", intRate, interest);
    }
    
    
    
}
