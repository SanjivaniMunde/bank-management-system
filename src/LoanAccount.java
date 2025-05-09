public class LoanAccount extends Account 
{
    public LoanAccount(int accNumber, String accHolderName, String password, String accType, float interestRate, int loanAmount) 
    {
        super(accNumber, accHolderName, password, accType, interestRate, -loanAmount);
    }

    
    public void deposit(int amount) 
    {
        balance += amount;
        if (balance > 0) 
        {
            balance = 0;
        }
    }

    
    public boolean withdraw(int amount) 
    {
        System.out.println("Withdrawals are not allowed for Loan Accounts.");
        return false;
    }

    
    public double calculateInterest() 
    {
        int interest = (int) (Math.abs(balance) * (interestRate / 100));
        return interest;
    }

    
    public void accLifeCycle() 
    {
    }
}
