/*
 * Author: Brian Klein and Aaron Olsen
 * Date: 9/25/17
 * Program: CheckingAccount.java
 * Description: user defined class
 */

public class CheckingAccount extends Account {

    private double transFee;

    public CheckingAccount() {
    }

    public CheckingAccount(double transFee, double acctBal) {
        super(acctBal);
        this.transFee = transFee;
    }

    public double getTransFee() {
        return transFee;
    }

    public void setTransFee(double transFee) {
        this.transFee = transFee;
    }

    @Override
    public void credit(double creditAmt) {
        if (creditAmt <= 0) {
            System.out.println("No credit transaction has occured.");
        } else {
            double bal = super.getAcctBal();
            bal += (creditAmt - transFee);
            super.setAcctBal(bal);
        }
    }

    @Override
    public void debit(double debitAmt) {
        if (debitAmt < 0) {
            System.out.println("Invalid debit amount.");
        } else {
            if ((debitAmt + transFee) > super.getAcctBal()) {
                System.out.println("Debit amount exceeds account balance. No debit "
                        + "transaction has occured.");
            } 
            else if(debitAmt == 0){
                System.out.println("No debit transaction has occured.");
            }
            else {
                double bal = super.getAcctBal();
                bal -= (debitAmt + transFee);
                super.setAcctBal(bal);
            }
        }
    }

    @Override
    public String toString() {
        return super.toString()
                + String.format("%nTransaction Fee: $%.2f", transFee);
    }

}
