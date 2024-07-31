import java.util.Scanner;
class ATM 
{
    private double balance;
    public ATM(double initialBalance) 
    {
        balance=initialBalance;
    }
    public void deposit(double amount) 
    {
        balance+=amount;
        System.out.println(amount + " deposited successfully.");
    }
    public void withdraw(double amount) 
    {
        if (amount<=balance) 
        {
            balance -=amount;
            System.out.println(amount + " withdrawn successfully.");
        }
        else 
        {
            System.out.println("Insufficient funds.");
        }
    }
    public void checkBalance() 
    {
        System.out.println("Current balance: " + balance);
    }
}
public class Atminterface 
{
    public static void main(String[] args) 
    {
        ATM atm=new ATM(40000);
        Scanner sc=new Scanner(System.in);
        while (true) 
        {
            System.out.println("\nATM Menu:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            int choice=sc.nextInt();
            switch (choice) 
            {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount=sc.nextDouble();
                    atm.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawalAmount=sc.nextDouble();
                    atm.withdraw(withdrawalAmount);
                    break;
                case 3:
                    atm.checkBalance();
                    break;
                case 4:
                    System.out.println("Thank you for using our ATM!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}