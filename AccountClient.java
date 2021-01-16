/*
 * Author: Brian Klein and Aaron Olsen
 * Date: 9/28/17
 * Program: AccountClient
 * Description: Based on user input, create a CheckingAccount object and a 
 *              SavingAccount object. Obtain user input for credit and debit 
 *              methods as well as the calculateInterest method.
 */
import java.util.*;

public class AccountClient {

    public static void main(String[] args) {

        //create scanner object
        Scanner console = new Scanner(System.in);

        //constants
        final double SENTINEL = -1;

        //variables
        double acctBal, intRate = SENTINEL, transFee = SENTINEL, creditAmt, debitAmt;
        CheckingAccount c1;
        SavingAccount s1;

        try {

            do {
                //user input validated so it cannot be less than 0
                System.out.print("\nEnter Checking Account balance: $");
                acctBal = console.nextDouble();
                if (acctBal < 0) {
                    System.out.println("Cannot enter account balance of less than zero.");
                }
            } while (acctBal < 0);

            while (transFee < 0) {
                System.out.print("\nEnter transaction fee: $");
                transFee = console.nextDouble();

                if (transFee < 0) {
                    System.out.println("Cannot have a fee of less than zero.");
                }
            }

            //create CheckingAccount object
            c1 = new CheckingAccount(transFee, acctBal);

            //print Checking Account
            System.out.println(c1);

            do {
                //user input and call credit() method from CheckingAccount
                System.out.print("\nEnter amount to be credited to Checking Account: $");
                creditAmt = console.nextDouble();
                c1.credit(creditAmt);
                if (creditAmt < 0) {
                    System.out.println("Cannot credit less than zero.");
                }
            } while (creditAmt < 0);

            //print Checking Account
            System.out.println(c1);

            do {
                //user input and call debit() method from CheckingAccount
                System.out.print("\nEnter amount to be debited from Checking Account: $");
                debitAmt = console.nextDouble();
                c1.debit(debitAmt);
                if (debitAmt < 0) {
                    System.out.println("Cannot debit less than zero.");
                }
            } while (debitAmt < 0);

            //print CheckingAccount c1
            System.out.println(c1);

            do {
                //user input validated so it cannot be less than 0
                System.out.print("\nEnter Savings Account balance: $");
                acctBal = console.nextDouble();
                if (acctBal < 0) {
                    System.out.println("Cannot enter balance of less than zero.");
                }
            } while (acctBal < 0);
            while (intRate < 0) {
                System.out.print("\nEnter interest rate percentage: ");
                intRate = console.nextDouble();

                if (intRate < 0) {
                    System.out.println("\nCannot have an interest rate percentage of less than zero.");
                }
            }

            //create SavingAccount object
            s1 = new SavingAccount(intRate, acctBal);

            do {
                //user input and call credit() method from SavingAccount
                System.out.print("\nEnter amount to be credited to Savings Account: $");
                creditAmt = console.nextDouble();
                s1.credit(creditAmt);
                if (creditAmt < 0) {
                    System.out.println("Cannot enter a credit of less than zero.");
                }
            } while (creditAmt < 0);

            //print Checking Account
            System.out.println(s1);

            do {
                //user input and call debit() method from SavingAccount
                System.out.print("\nEnter amount to be debited from Savings Account: $");
                debitAmt = console.nextDouble();
                s1.debit(debitAmt);
                if (debitAmt < 0) {
                    System.out.println("Cannot enter a debit of less than zero.");
                }
            } while (debitAmt < 0);

            //print Checking Account
            System.out.println(s1);

            //call calculateInterest() method from SavingAccount
            s1.calculateInterest(intRate);

            //print
            System.out.println("\nSavings Account after interest:\n" + s1);
        } catch (InputMismatchException e) {
            System.out.println("You have not entered a valid number. Please restart.");
        } catch (Exception e) {
            System.out.print(e);
            System.out.println("Invalid entry. Please restart.");
        }

        //hold space for viewing
        System.out.println("Please press <ENTER> when done viewing.");
        console.nextLine();
        console.nextLine();

        //create an ArrayList
        ArrayList<Account> list = new ArrayList<Account>();

        //add objects in the array
        list.add(new CheckingAccount(5.5, 500));
        list.add(new CheckingAccount(6, 1000));
        list.add(new CheckingAccount(2.5, 250.5));
        list.add(new SavingAccount(0.01, 500));
        list.add(new SavingAccount(0.05, 1000));
        list.add(new CheckingAccount(7.5, 2000));
        list.add(new CheckingAccount(4, 2000));
        list.add(new SavingAccount(0.08, 300));
        list.add(new SavingAccount(0.02, 450));
        list.add(new CheckingAccount(15, 1200));

        //loop through and print ArrayList
        System.out.println("\n");
        for (int i = 0; i < list.size(); i++) {
            System.out.print("\nAccount " + (i + 1) + "\n");
            System.out.println(list.get(i).toString());
        }
    }
}
