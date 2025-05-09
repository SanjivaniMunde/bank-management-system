abstract public class Account 
{
    protected int accNumber;
    protected String accHolderName;
    protected String password;
    protected String accType;
    protected float interestRate;
    protected int balance;
    private String[] transactionHistory;
    private int transactionCount;

    public Account(int accNumber, String accHolderName, String password, String accType, float interestRate, int balance) 
    {
        this.accNumber = accNumber;
        this.accHolderName = accHolderName;
        this.password = password;
        this.accType = accType;
        this.interestRate = interestRate;
        this.balance = balance;
        this.transactionHistory = new String[100]; 
        this.transactionCount = 0; 
    }

    public int getAccNumber1() 
    {
        return accNumber;
    }

    public String getAccHolderName1() 
    {
        return accHolderName;
    }

    public String getPassword() 
    {
        return password;
    }

    public String getAccType1() 
    {
        return accType;
    }

    public int checkBalance1() 
    {
        return balance;
    }

    public void deposit(int amount) 
    {
        balance += amount;
    }

    public boolean withdraw(int amount) 
    {
        if (amount <= balance) {
            balance -= amount;
            return true;
        } else {
            System.out.println("Insufficient funds.");
            return false;
        }
    }

    public double calculateInterest() 
    {
        return balance * interestRate / 100;
    }

    public void addTransaction(String transaction) 
    {
        if (transactionCount < transactionHistory.length) 
        {
            transactionHistory[transactionCount++] = transaction;
        } else {
            System.out.println("Transaction history is full. Cannot record more transactions.");
        }
    }

    public String[] getTransactionHistory() {
        String[] history = new String[transactionCount];
        System.arraycopy(transactionHistory, 0, history, 0, transactionCount);
        return history;
    }

    public void accLifeCycle() {
       
    }
}
