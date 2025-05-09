import java.util.Scanner;

public class Main 
{
    public static void main(String[] args) 
    {
        BankFunctions bankFunctions = new BankFunctions();
        Account currentAccount = null;
        Scanner sc = new Scanner(System.in);

        while (true) 
        {
            if (currentAccount == null) 
            {
                System.out.println("\n--- Bank Management System ---");
                System.out.println("1. Create Account");
                System.out.println("2. Login");
                System.out.println("3. Exit");
                System.out.println();
                System.out.print("Choose an option: ");
                int choice = sc.nextInt();

                switch (choice) 
                {
                    case 1:
                        bankFunctions.createAccount();
                        break;
                    case 2:
                        currentAccount = bankFunctions.login();
                        break;
                    case 3:
                        System.out.println("Exiting the bank system. Thank you!");
                        sc.close();
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } 
            else 
            {
                System.out.println("\n--- Operations Menu ---");
                System.out.println("1. Deposit");
                System.out.println("2. Withdraw");
                System.out.println("3. Check Balance");
                System.out.println("4. Calculate Interest");
                System.out.println("5. View Transaction History");
                System.out.println("6. Close Account");
                System.out.println("7. End of Day Report");
                System.out.println("8. Logout");
                System.out.println();
                System.out.print("Choose an option: ");
                int choice = sc.nextInt();

                switch (choice) 
                {
                    case 1:
                        bankFunctions.deposit(currentAccount);
                        break;
                    case 2:
                        bankFunctions.withdraw(currentAccount);
                        break;
                    case 3:
                        bankFunctions.checkBalance(currentAccount);
                        break;
                    case 4:
                        bankFunctions.calculateInterest(currentAccount);
                        break;
                    case 5:
                        bankFunctions.viewTransactionHistory(currentAccount);
                        break;
                    case 6:
                        bankFunctions.closeAccount(currentAccount);
                        currentAccount = null;  
                        break;
                    case 7:
                        bankFunctions.generateEndOfDayReport();
                        break;
                    case 8:
                        System.out.println("Logging out...");
                        currentAccount = null;  
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }
    }
}
