public class SalaryAccount extends SavingsAccount 
{
    private int months;

    public SalaryAccount(int accNumber, String accHolderName, String password, String accType, float interestRate, int balance) 
    {
        super(accNumber, accHolderName, password, accType, interestRate, balance);
        this.months = 0;
    }


    public void deposit(int amount) 
    {
        super.deposit(amount);
        months = 0;
    }

    
    public boolean withdraw(int amount) 
    {
        boolean success = super.withdraw(amount);
        if (success) 
        {
            months = 0;
        }
        return success;
    }

    
    public void accLifeCycle() 
    {
        if (months >= 2) 
        {
            System.out.println("Salary account is frozen due to inactivity for 2 months.");
        }
    }

    public void incrementInactivity() 
    {
        months++;
    }
}
