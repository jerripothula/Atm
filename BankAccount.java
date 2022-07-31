/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author 61433
 */
public class BankAccount {

    private final String customerName;
    private final int customerDebitCardNumber;
    private final int pin;
    private final String customerAccountNumber;
    private final String customerEmailAddress;
    private double balance;

    public BankAccount(String customerName, int customerDebitCardNumber, int pin, String customerAccountNumber, String customerEmailAddress, double balance) {
        this.customerName = customerName;
        this.customerDebitCardNumber = customerDebitCardNumber;
        this.pin = pin;
        this.customerAccountNumber = customerAccountNumber;
        this.customerEmailAddress = customerEmailAddress;
        this.balance = balance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public int getCustomerDebitCardNumber() {
        return customerDebitCardNumber;
    }

    public int getPin() {
        return pin;
    }

    public String getCustomerAccountNumber() {
        return customerAccountNumber;
    }

    public String getCustomerEmailAddress() {
        return customerEmailAddress;
    }

    public double getBalance() {
        return balance;
    }
    
    public void updateBalance(double newBalance)
	{
		balance=newBalance;
	}

}
