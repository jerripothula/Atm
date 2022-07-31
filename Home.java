

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 61433
 */
import java.util.Scanner;

public class Home {

    public static void main(String args[]) {
        BankAccount[] customers = new BankAccount[2];
        int debitCardPin = 0;
        int debitCardNumber = 0;
        int tries = 3;
        int check = 0;

        customers[0] = new BankAccount("Hemanth J", 123456789, 1234, "ACC123234", "hj1234@gmail.com", 10000);
        customers[1] = new BankAccount("Lucy",987654321, 4321, "ACC456780", "lucy@gmail.com", 5000);
        Scanner sc = new Scanner(System.in);
        //int x = 1;

        while (tries > 0 && check == 0) {

            System.out.println("Welcome to the SwissBank ATM !");
            System.out.println("Enter your customer Number");
            debitCardNumber = sc.nextInt();

            System.out.print("Enter your PIN Number: ");
            debitCardPin = sc.nextInt();

            AtmMachine atmMachine = new AtmMachine(debitCardNumber, debitCardPin);

            if (atmMachine.isAccountFound(customers)) {
                while (true) {
                    System.out.println("Hello! " + atmMachine.getCustomerName() + "\n");
                    System.out.println("1. WithDraw");
                    System.out.println("2. Deposit");
                    System.out.println("3. Check Balance");
                    System.out.println("4. Exit\n");
                    System.out.println("Enter Your Choice : ");
                    if (sc.hasNextInt()) {
                        int choice = sc.nextInt();
                        switch (choice) {
                            case 1:
                                System.out.println("\nEnter Amount to Withdraw : ");
                                check = 1;
                                try {
                                    int amountToWithDraw = Integer.parseInt(sc.next());
                                    //int amountToWithDraw = sc.nextInt();
                                    if (atmMachine.withdraw(amountToWithDraw)) {
                                        continue;
                                    }
                                } catch (NumberFormatException e) {
                                    System.out.println("It is not a Valid Integer Value.");
                                    break;
                                }
                                break;
                            case 2:
                                System.out.println("\nEnter Amount to Deposit : ");
                                check = 1;
                                if (sc.hasNextInt()) {
                                    int amountToDeposit = sc.nextInt();
                                    if (atmMachine.deposit(amountToDeposit) == 0) {
                                        atmMachine.checkBalance();
                                        break;
                                    } else {
                                        continue;
                                    }
                                } else {
                                    System.out.println("Please Enter Valid Integer Value.");
                                }
                                break;
                            case 3:
                                atmMachine.checkBalance();
                                check = 1;
                                continue;
                            case 4:
                                System.out.println("Thanks for using ATM");
                                check = 1;
                                System.exit(-1);
                                break;
                            default:
                                System.out.println("Please Enter Valid Option");
                                continue;
                        }
                    } else {
                        System.out.println("Please Enter Valid Integer Number ( 1 or 2 or 3 or 4)");
                    }
                    sc.nextLine();
                }
            } else {
                tries--;
                System.out.println("INCORRECT PIN");
                System.out.println("Try again, " + tries + " try is  left");
                //continue;
            }

        }
        if (tries == 0) {
            System.out.println("You have entered incorrect PIN for three times");
            System.out.println("Your card is now blocked for 24 hour");
            System.exit(0);
        }
    }

}
