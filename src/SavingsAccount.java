public class SavingsAccount extends Account 
{
    private static final int Min_Bal = 10000;

    public SavingsAccount(int accNumber, String accHolderName, String password, String accType, float interestRate, int balance) 
    {
        super(accNumber, accHolderName, password, accType, interestRate, balance);
        if (balance < Min_Bal) 
        {
            throw new IllegalArgumentException("Initial balance too low");
        }
    }

    
    public boolean withdraw(int amount) 
    {
        if (balance - amount >= Min_Bal) 
        {
            balance -= amount;
            return true;
        } 
        else 
        {
            return false;
        }
    }

    
    public double calculateInterest() 
    {
        return balance * (interestRate / 100);
    }

    
    public void accLifeCycle() 
    {
    }
}
