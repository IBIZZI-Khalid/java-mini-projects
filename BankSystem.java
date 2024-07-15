package Java_Mini_Projects;
import java.util.HashMap;
import java.util.Scanner;

public class BankSystem {
    Scanner sc = new Scanner(System.in);

    private HashMap<String,BankAccount> accounts ;

    public BankSystem(){
        accounts = new HashMap<>();
    }
    

    class BankAccount{
        private String accountNumber;
        private String holderName;
        private Integer balance;

        public BankAccount(String accountNumber,String holderName,Integer balance){
            this.accountNumber = accountNumber;
            this.holderName = holderName;
            this.balance = balance;
        };

        public String getAccountNumber(){
            return accountNumber;
        };

        public String getHolderName(){
                return holderName;
        };
        
        public void addToBalance(Integer bal){
            balance += bal;
        };
        public Integer getBalance(){
            return balance;
        };

    
        // deposit method
        public void deposit(){
            System.out.println("Enter the amount you want to deposit");
            Integer amount = sc.nextInt();
            addToBalance(amount);
            sc.nextLine();
            System.out.println(amount+" Is added to ur balance , Happy Day !");

            // System.out.println("operation");
        }

        // withdraw method
        public void withdraw(){
            boolean running = true;
            while (running) {
                System.out.println("Enter the amount you want to withdraw");
                Integer withdrawAmount = sc.nextInt();
                sc.nextLine();

                if (withdrawAmount> 0 && balance > 0){
                    addToBalance(- withdrawAmount);
                    System.out.println(withdrawAmount+" $ Is out of ur balance , Happy Day !");
                    running = false;
                }else{
                    System.out.println(" Oops , Invalid amount ... try again .");
                }
            }

        }   

        // display balance method
        public void displayBalance(){
            System.out.println("the balance in ur acc is = ");
            Integer balance = getBalance();
            System.out.println(balance);
        }
    }

    class SavingsAccount extends BankAccount{
        private double interestrate ;

        // constructor
        public SavingsAccount(String accountNumber,String holderName,Integer balance,double interestrate ){
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
    
    public void addAccount(String accountNumber , BankAccount account ){
        accounts.put(accountNumber,account);
    }

    public BankAccount getAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }

    public HashMap<String, BankAccount> getAccounts() {
        return accounts;
    }


    public static void successop(boolean oprunning , boolean running){
                                Scanner sc = new Scanner(System.in);
                                System.out.println("Successful Operation !");    
                                System.out.println("1. Performe another operation ? "); 
                                System.out.println("2. Exit Operations");
                                System.out.println("3. Exit all ");
                                int answer2 = sc.nextInt();
                                sc.nextLine();

                                switch (answer2) {
                                    case 1:
                                        oprunning = true;        
                                        break;
                                    case 2:
                                        oprunning = false;
                                        break;
                                    case 3:
                                        oprunning = false;
                                        running = false;
                                        break;
                                    default:
                                        break;
                                }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankSystem bankSystem = new BankSystem();

        boolean running = true;

        while (running == true){

            System.out.println("What whould u like to do ? ");
            System.out.println("1. Create an account");
            System.out.println("2. Perform an operation ");
            int choice = sc.nextInt();
            sc.nextLine();

            while(choice > 2 || choice <1){
                System.out.println("Invalid choice... Try again !");
                System.out.println("1. Create an account");
                System.out.println("2. Perform an operation ");
                choice = sc.nextInt();
                sc.nextLine();
            }
            switch (choice) {
                case 1:
                    System.out.println("Enter account number:");

                    String accountNumber = sc.nextLine();

                    System.out.println("Enter holder name:");
                    String holderName = sc.nextLine();
                    System.out.println("Enter initial balance:");
                    Integer balance = sc.nextInt();
                    sc.nextLine();

                    System.out.println("do u wanna set it as a savings account ? ");
                    String answer = sc.nextLine();

                    if(answer.equalsIgnoreCase("yes")){
                        System.out.println("Enter interest rate:");
                        double interestRate = sc.nextDouble();
                        SavingsAccount savingsAcc = bankSystem.new SavingsAccount(accountNumber, holderName, balance, interestRate);
            
                        bankSystem.addAccount(accountNumber, savingsAcc);
                        System.out.println("Added as a savings account !");
            
                    }else if ( answer.equalsIgnoreCase("no")){
                        BankAccount normalAccount = bankSystem.new BankAccount(accountNumber, holderName, balance);
                        bankSystem.addAccount(accountNumber, normalAccount);
                        System.out.println("Added as a normal account !");

                    }else{
                        System.out.println("Invalid answer... Try again later !");
                        running= false;
                    }
                    
                    break;
                case 2:


                    System.out.println("Enter account number");
                    String accountNumber2 = sc.nextLine();
                    System.out.println("the acc number u entered is : "+ accountNumber2);

                    BankAccount acc = bankSystem.getAccount(accountNumber2);
                    if (acc == null) {
                        System.out.println("No account found with the number: " + accountNumber2);
                        break;
                    }else if (acc != null ){
                        System.out.println("give it a minute to find ur acc ...");
                    }
                    
                    boolean oprunning = true;
                    while (oprunning){
                        int choice2 = 69; //lol humor
                        while (choice2<1 || choice2 >5){
                            System.out.println("Choose one of theese operations !");
                            System.out.println("1. Deposit money");
                            System.out.println("2. Withdraw money");
                            System.out.println("3. Check balance");
                            System.out.println("4. Add interest to balance  , I didn't add this part yet ¯\\_( ͡° ͜ʖ ͡°)_/¯  ");
                            System.out.println("5. Exit");
                            choice2 = sc.nextInt();
                            sc.nextLine();

                        }
                        switch (choice2) {
                            case 1: 
                                acc.deposit();   
                                successop(oprunning,running);
                                break;
                            case 2:
                                acc.withdraw();
                                successop(oprunning,running);
                                break;
                            case 3:
                                acc.displayBalance();
                                successop(oprunning,running);
                                break;
                            case 4:
                                // acc.addInterest(); 
                                // i didn't add this part yet ¯\_( ͡° ͜ʖ ͡°)_/¯ 
                                successop(oprunning,running);
                                break;
                            case 5:
                                System.out.println("Thank you for using our bank system !");
                                running = false;
                                break;

                                

                            default:
                                break;
                        }
                        
                    
                    }



                default:
                    break;
            }
        
        

        

        // savingsAccount.displayBalance();
        // savingsAccount.deposit();
        // savingsAccount.displayBalance();
        // savingsAccount.withdraw();
        // savingsAccount.displayBalance();
        // savingsAccount.addInterestToBalance();
        // savingsAccount.displayBalance();
    }}
}
