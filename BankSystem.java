package Java_Mini_Projects;
import java.util.Scanner;

public class BankSystem {
    Scanner sc = new Scanner(System.in);

    class bankAccount{
        private String accountNumber;
        private String holderName;
        private Integer balance;

        public bankAccount(String accountNumber,String holderName,Integer balance){
            this.accountNumber = accountNumber;
            this.holderName = holderName;
            this.balance = balance;
        };

        public void setAccountNumber(String nbr){
            this.accountNumber = nbr;
        };
        public String getAccountNumber(){
            return accountNumber;
        };


        public void setHolderName(String name){
            this.holderName = name;
        };
        public String getHolderName(){
                return holderName;
        };
        
        public void setBalance(Integer balanceToSet){
            this.balance = balanceToSet;
        }
        public void addToBalance(Integer bal){
            balance += bal;
        };
        public Integer getBalance(){
            return balance;
        };

    
        // deposite method
        public void deposite(){
            System.out.println("Enter the amount you want to deposite");
            Integer amount = sc.nextInt();
            addToBalance(amount);
        }

        // withdraw method
        public void withdraw(){
            System.out.println("Enter the amount you want to withdraw");
            Integer withdrawAmount = sc.nextInt();

            if (withdrawAmount> 0 && balance > 0){
                addToBalance(- withdrawAmount);
            }else{
                System.out.println(" Oops , Invalid amount ... try again .");
            }

        }

        // display balance method
        public void displayBalance(){
            System.out.println("the balance in ur acc is = ");
            Integer balance = getBalance();
            System.out.println(balance);
        }
    }

    class savingsAccount extends bankAccount{
        private double interestrate ;

        // constructor
        public savingsAccount(String accountNumber,String holderName,Integer balance,double interestrate ){
            super(accountNumber,holderName , balance);
            this.interestrate = interestrate;
        }

        public int calculateInterest(){
            int  interest = (int) (getBalance() * interestrate /100);
            return interest;
        }
        public void addInterestToBalance(){
            int interest = calculateInterest();
            addToBalance(interest);
            System.out.println("Interest added : " + interest );
        }

        

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter account number:");
        String accountNumber = sc.nextLine();
        System.out.println("Enter holder name:");
        String holderName = sc.nextLine();
        System.out.println("Enter initial balance:");
        Integer balance = sc.nextInt();
        System.out.println("Enter interest rate:");
        double interestRate = sc.nextDouble();

        BankSystem bankSystem = new BankSystem();
        savingsAccount savingsAccount = bankSystem.new savingsAccount(accountNumber, holderName, balance, interestRate);

        savingsAccount.displayBalance();
        savingsAccount.deposite();
        savingsAccount.displayBalance();
        savingsAccount.withdraw();
        savingsAccount.displayBalance();
        savingsAccount.addInterestToBalance();
        savingsAccount.displayBalance();
    }
}
