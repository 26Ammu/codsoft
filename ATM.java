import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000.00);  // Starting balance of $1000
        ATM atm = new ATM(userAccount);
        atm.start();
    }

    private BankAccount account;
    private Scanner scanner;

    // Constructor to initialize ATM with a bank account
    public ATM(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    // Method to display the menu
    public void displayMenu() {
        System.out.println("\nWelcome to the ATM!");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Exit");
        System.out.print("Please select an option: ");
    }

    // Method to handle the ATM operations
    public void start() {
        boolean exit = false;
        while (!exit) {
            displayMenu();
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    depositMoney();
                    break;
                case 3:
                    withdrawMoney();
                    break;
                case 4:
                    exit = true;
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // Method to check balance
    private void checkBalance() {
        System.out.println("Your current balance is: $" + account.getBalance());
    }

    // Method to deposit money
    private void depositMoney() {
        System.out.print("Enter the amount to deposit: $");
        double amount = scanner.nextDouble();
        account.deposit(amount);
    }

    // Method to withdraw money
    private void withdrawMoney() {
        System.out.print("Enter the amount to withdraw: $");
        double amount = scanner.nextDouble();
        account.withdraw(amount);
    }

    // Inner class representing a bank account
    static class BankAccount {
        private double balance;

        // Constructor to initialize balance
        public BankAccount(double initialBalance) {
            if (initialBalance > 0) {
                balance = initialBalance;
            } else {
                System.out.println("Initial balance must be greater than 0.");
            }
        }

        // Method to get the current balance
        public double getBalance() {
            return balance;
        }

        // Method to deposit money
        public void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
                System.out.println("Successfully deposited: $" + amount);
            } else {
                System.out.println("Deposit amount must be positive.");
            }
        }

        // Method to withdraw money
        public boolean withdraw(double amount) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                System.out.println("Successfully withdrew: $" + amount);
                return true;
            } else {
                System.out.println("Insufficient balance or invalid withdrawal amount.");
                return false;
            }
        }
    }
}
