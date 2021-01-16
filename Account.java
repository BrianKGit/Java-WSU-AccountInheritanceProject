/*
 * Author: Brian Klein and Aaron Olsen
 * Date: 9/25/17
 * Program: Account.java
 * Description: User defined super class.
 */

public class Account {

    private double acctBal;

    public Account() {
    }

    public Account(double acctBal) {
        setAcctBal(acctBal);
    }

    public double getAcctBal() {
        return acctBal;
    }

    public void setAcctBal(double acctBal) {
        if (acctBal < 0.0) {
            this.acctBal = 0.0;
            System.out.println("Invalid balance.");
        } else {
            this.acctBal = acctBal;
        }
    }

    public void credit(double creditAmt) {
        if (creditAmt < 0) {
            System.out.println("Invalid credit amount.");
        } else {
            this.acctBal += creditAmt;
        }
    }

    public void debit(double debitAmt) {
        if (debitAmt < 0) {
            System.out.println("Invalid debit amount.");
        } 
        else {
            if (debitAmt > this.acctBal) {
                System.out.println("Debit amount exceeds account balance. No debit "
                        + "transaction has occured.");
            } else {
                this.acctBal -= debitAmt;
            }
        }
    }

    @Override
    public String toString() {
        return String.format("Account Balance: $%,.2f", acctBal);
    }

}//end class
