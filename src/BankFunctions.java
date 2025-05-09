import java.util.Date;
import java.util.Scanner;

public class BankFunctions {
    private static int accountCounter = 1001;
    private Account[] accounts = new Account[100];
    private int accountCount = 0;
    private Scanner sc = new Scanner(System.in);

    public void createAccount() 
    {
        if (accountCount >= accounts.length) 
        {
            System.out.println("Account creation limit reached...Cannot create more accounts.");
            return;
        }

        System.out.println("\n--- Create Account ---");
        System.out.println("Choose account type:");
        System.out.println("1. Savings Account");
        System.out.println("2. Salary Account");
        System.out.println("3. Current Account");
        System.out.println("4. Loan Account");
        System.out.println();
        System.out.print("Enter account type: ");
        int choice = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter your full name: ");
        String name = sc.nextLine();

        System.out.print("Enter your password: ");
        String password = sc.nextLine();

        System.out.print("Enter the initial balance: ");
        int balance = sc.nextInt();
        sc.nextLine();

        int accountNumber = accountCounter++;
        Account newAccount;

        try {
            switch (choice) 
            {
                case 1:
                    newAccount = new SavingsAccount(accountNumber, name, password, "Savings", 3.5f, balance);
                    break;
                case 2:
                    newAccount = new SalaryAccount(accountNumber, name, password, "Salary", 3.5f, balance);
                    break;
                case 3:
                    System.out.print("Enter overdraft limit: ");
                    int overdraftLimit = sc.nextInt();
                    sc.nextLine();
                    newAccount = new CurrentAccount(accountNumber, name, password, "Current", 0.0f, balance, overdraftLimit);
                    break;
                case 4:
                    newAccount = new LoanAccount(accountNumber, name, password, "Loan", 5.0f, balance);
                    break;
                default:
                    System.out.println("Invalid choice. Account creation failed.");
                    return;
            }

            accounts[accountCount++] = newAccount;
            System.out.println("Account created successfully! Your account number is: " + accountNumber);

        } catch (Exception e) {
            System.out.println("Account creation failed: " + e.getMessage());
        }
    }

    public Account login() {
        System.out.println("\n--- Login ---");
        System.out.print("Enter your account number: ");
        int accNumber = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter account holder's name: ");
        String name = sc.nextLine();

        System.out.print("Enter your password: ");
        String password = sc.nextLine();

        for (int i = 0; i < accountCount; i++) 
        {
            Account account = accounts[i];
            if (account.getAccNumber1() == accNumber &&
                account.getAccHolderName1().equals(name) &&
                account.getPassword().equals(password)) 
            {
                System.out.println("Login successful!");
                return account;
            }
        }
        System.out.println("Invalid account number, name, or password.");
        return null;
    }

    public void deposit(Account account) 
    {
        System.out.print("Enter the amount to deposit: ");
        int amount = sc.nextInt();
        account.deposit(amount);
        System.out.println("Deposit successful! Your balance is: " + account.checkBalance1());
        recordTransaction(account, "Deposit", amount);
    }

    public void withdraw(Account account) 
    {
        System.out.print("Enter the amount to withdraw: ");
        int amount = sc.nextInt();
        boolean success = account.withdraw(amount);
        if (success) 
        {
            System.out.println("Withdrawal successful! Your new balance is: " + account.checkBalance1());
            recordTransaction(account, "Withdraw", amount);
        } 
        else 
        {
            System.out.println("Withdrawal failed.");
        }
    }

    public void checkBalance(Account account) 
    {
        System.out.println("Your current balance is: " + account.checkBalance1());
    }

    public void closeAccount(Account account) 
    {
        for (int i = 0; i < accountCount; i++) 
        {
            if (accounts[i] == account) 
            {
                accounts[i] = accounts[accountCount - 1];
                accounts[accountCount - 1] = null;
                accountCount--;
                System.out.println("Account closed successfully.");
                return;
            }
        }
        System.out.println("Account not found.");
    }

    public void generateEndOfDayReport() 
    {
        System.out.println("\n--- End of Day Report ---\n");
        for (int i = 0; i < accountCount; i++) 
        {
            Account account = accounts[i];
            System.out.println("Account Number: " + account.getAccNumber1() + ", Account Holder: " + account.getAccHolderName1() + ", Account Type: " + account.getAccType1() + ", Balance: " + account.checkBalance1());
        }
    }

    public void calculateInterest(Account account) {
        double interest = account.calculateInterest();
        System.out.println("Interest earned: " + interest);
        account.deposit((int) interest);
    }

    public void viewTransactionHistory(Account account) {
        System.out.println("\n--- Transaction History ---");
        for (String transaction : account.getTransactionHistory()) {
            System.out.println(transaction);
        }
    }

    private void recordTransaction(Account account, String type, int amount) {
        Date now = new Date();
        String transaction = now.toString() + " - " + type + ": " + amount;
        account.addTransaction(transaction);
    }
}
