/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author 61433
 */
public class AtmMachine {

    private final int customerDebitCardNumber;
    private final int pin;
    private BankAccount bankAccount;

    public AtmMachine(int customerDebitCardNumber, int pin) {
        this.customerDebitCardNumber = customerDebitCardNumber;
        this.pin = pin;
    }

    public boolean isAccountFound(BankAccount[] bankAccounts) {
        bankAccount = findBankAccount(bankAccounts);
        if (bankAccount != null) {
            return true;
        } else {
            return false;
        }
    }

    private BankAccount findBankAccount(BankAccount[] bankAccounts) {
        for (int i = 0; i < bankAccounts.length; i++) {
            if (bankAccounts[i].getCustomerDebitCardNumber() == customerDebitCardNumber && bankAccounts[i].getPin() == pin) {
                return bankAccounts[i];
            }
        }

        return null;
    }

    public String getCustomerName() {
        return bankAccount.getCustomerName().toUpperCase();
    }

    public void checkBalance() {
        if (bankAccount != null) {
            System.out.println("Balance Amount: " + bankAccount.getBalance());
        } else {
            System.out.println("Invalid Account");
        }
    }

    public int deposit(int amountToDeposit) {

        if (amountToDeposit > 0 && amountToDeposit % 100 == 0) {
            double balance = bankAccount.getBalance();
            balance = balance + amountToDeposit;
            bankAccount.updateBalance(balance);
            System.out.println("Thank you. " + amountToDeposit + " dollars is deposited");
            System.out.println("Your updated balance is: " + balance);
            return 0;
        } else {
            System.out.println("Deposited amount should be in multiple of 100 dollars.");
            return -1;
        }

    }

    public boolean withdraw(int amountToWithdraw) {

        if (amountToWithdraw % 100 == 0) {
            if (amountToWithdraw > 0 && amountToWithdraw <= bankAccount.getBalance()) {
                double balance = bankAccount.getBalance();
                balance = balance - amountToWithdraw;
                bankAccount.updateBalance(balance);
                System.out.println("Please collect your cash and Debit Card");
                System.out.println(amountToWithdraw + " dollars have been debited");
                System.out.println("Remaining Balance: " + balance);
                return true;
            } else {
                System.out.println("Insufficient Balance. Current balance: " + bankAccount.getBalance());
                return false;
            }
        } else {
            System.out.println("Withdrawal Amount should be in multiple of 100 dollars");
            return false;
        }
    }
}
