public class CurrentAccount extends Account 
{
    private int overdraftLimit;

    public CurrentAccount(int accNumber, String accHolderName, String password, String accType, float interestRate, int balance, int overdraftLimit) 
    {
        super(accNumber, accHolderName, password, accType, interestRate, balance);
        this.overdraftLimit = overdraftLimit;
    }

    
    public boolean withdraw(int amount) 
    {
        if (balance - amount >= -overdraftLimit) 
        {
            balance -= amount;
            return true;
        } 
        else 
        {
            System.out.println("Cannot withdraw. Exceeds overdraft limit of Rs. " + overdraftLimit);
            return false;
        }
    }

    
    public double calculateInterest() 
    {
        return 0.0;
    }

    
    public void accLifeCycle() 
    {
    }
}
