package Java_Mini_Projects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class EmployeeManagementSystem {



    public static class Employee{
        String name;
        Double baseSalary;
        Integer age;
        Integer joiningYear;
        String designation;
        String department;
        String address;
        String email;
        String phone;
        String gender;
        String maritalStatus;
        String performance;


        //constuctor
        public Employee(String name,
        Double baseSalary,
        Integer age,
        Integer joiningYear,
        String designation,
        String department,
        String address,
        String email,
        String phone,
        String gender,
        String maritalStatus,
        String performance){
            this.name = name ;
            this.baseSalary = baseSalary ;
            this.age = age ;
            this.joiningYear = joiningYear ;
            this.designation = designation ;
            this.department = department ;
            this.address = address ;
            this.email = email ;
            this.phone = phone ;
            this.gender = gender ;
            this.maritalStatus = maritalStatus ;
            this.performance = performance ;


        }

        public Double calculateSalary(){
            return baseSalary ;
        }

        public void displayDetails(){

            System.out.println("Name : " + name);
            System.out.println("Base Salary : " + baseSalary);
            System.out.println("Age : " + age);
            System.out.println("Joining Year : " + joiningYear);
            System.out.println("Designation : " + designation);
            System.out.println("Department : " + department);
            System.out.println("Address : " + address);
            System.out.println("Email : " + email);
            System.out.println("Phone : " + phone);
            System.out.println("Gender : " + gender);
            System.out.println("Marital Status : " + maritalStatus);
            System.out.println("Performance : " + performance);

        }
        
        

    } 


    public static class Manager extends Employee{
        static List<Manager> managers = new ArrayList<>();
        Double bonus;

        public Manager(String name, Double baseSalary, Integer age, Integer joiningYear, String designation, String department, String address, String email, String phone, String gender, String maritalStatus, String performance, Double bonus) {
            super(name, baseSalary, age, joiningYear, designation, department, address, email, phone, gender, maritalStatus, performance);
            this.bonus = bonus;
        }

        public static void addmanager(Manager manager){
            managers.add(manager);
            System.out.println(manager.name+"has been added successfuly !");
        }

        @Override
        public Double calculateSalary(){
            return baseSalary+bonus;

        }

        @Override
        public void displayDetails(){
            super.displayDetails();
            System.out.println("Bonus : " + bonus);
        }

        public static void displayAllManagers(){
            System.out.println("Managers Details : ");
            for (Manager manager : managers){
                manager.displayDetails();

            }
        }
        public static void removeManager(String nametoremove) {
            managers.removeIf(manager -> manager.name.equalsIgnoreCase(nametoremove));
        }

        public static void editManager(String name){
            for (Manager manager : managers) {
                if(manager.name.equalsIgnoreCase(name)){
                    System.out.println("what do u wanna change ? (name/age/phone/...) ");
                    Scanner sc = new Scanner(System.in);
                    String choice = sc.nextLine();
                    switch (choice){
                        case "name":
                            System.out.println("enter the new name : ");
                            String newName =sc.nextLine();
                            manager.name = newName;

                        case "age":
                            System.out.println("enter the new age : ");
                            int newAge = sc.nextInt();
                            manager.age = newAge;
                        
                        case "phone":
                            System.out.println("enter the new phone : ");
                            String newPhone = sc.nextLine();
                            manager.phone = newPhone;
                        case "salary":
                            System.out.println("enter the new salary : ");
                            double newSalary = sc.nextDouble();
                            manager.baseSalary = newSalary;
                        case "bonus":
                            System.out.println("enter the new bonus : ");
                            double newBonus = sc.nextDouble();
                            manager.bonus = newBonus;
                        case "address":
                            System.out.println("enter the new address : ");
                            String newAddress = sc.nextLine();
                            manager.address = newAddress;
                        case "email":
                            System.out.println("enter the new email : ");
                            String newEmail = sc.nextLine();
                            manager.email = newEmail;

                        }
                }else{
                    System.out.println("the name u gave isn't in managers list");
                }
            }
        }


        
        public static void showManager(String name){
            for (Manager man : managers){
                if(man.name.equalsIgnoreCase(name)){
                    man.displayDetails();
                }
            }

        }
    }

    
    public static class Developer extends Employee{
        static List<Developer> Devs = new ArrayList<>(); 
        int overtimehours;
        double overtimerate;

        //constructor
        public Developer(
                String name,
                Double baseSalary,
                Integer age,
                Integer joiningYear,
                String designation,
                String department,
                String address,
                String email,
                String phone,
                String gender,
                String maritalStatus,
                String performance ,
                Integer overtimehours, 
                Double overtimerate)
            {
            super(name, baseSalary, age, joiningYear, designation, department, address, email, phone, gender, maritalStatus, performance);
            this.overtimehours = overtimehours;
            this.overtimerate = overtimerate;
        }

        public static void addDev(Developer dev){
            Devs.add(dev);
            System.out.println(dev.name+"has been added successfuly !");
        }

        @Override
        public Double calculateSalary(){
            return baseSalary + (overtimehours * overtimerate);
        }

        @Override
        public void displayDetails(){
            super.displayDetails();
            System.out.println("Overtime Hours : " + overtimehours);
            System.out.println("Overtime Rate : " + overtimerate);
        }

        public static void displayAllDevs(){
            for(Developer dev : Devs){
                dev.displayDetails();
                System.out.println("_______");
            }
        }

        public static void removeDev(String nametoremove) {
            Devs.removeIf(dev -> dev.name.equals(nametoremove));
        }

        public static void editDev(String name){
            for (Developer dev : Devs) {
                if(dev.name.equalsIgnoreCase(name)){
                    System.out.println("what do u wanna change ? (name/age/phone/...) ");
                    Scanner sc = new Scanner(System.in);
                    String choice = sc.nextLine();
                    switch (choice){
                        case "name":
                            System.out.println("enter the new name : ");
                            String newName =sc.nextLine();
                            dev.name = newName;
                            break;

                        case "age":
                            System.out.println("enter the new age : ");
                            int newAge = sc.nextInt();
                            dev.age = newAge;
                            break;

                        case "phone":
                            System.out.println("enter the new phone : ");
                            String newPhone = sc.nextLine();
                            dev.phone = newPhone;
                            break;
                        case "salary":
                            System.out.println("enter the new salary : ");
                            double newSalary = sc.nextDouble();
                            dev.baseSalary = newSalary;
                            break;

                        case "address":
                            System.out.println("enter the new address : ");
                            String newAddress = sc.nextLine();
                            dev.address = newAddress;
                            break;    
                        case "email":
                            System.out.println("enter the new email : ");
                            String newEmail = sc.nextLine();
                            dev.email = newEmail;
                            break;
                        }
                }else{
                    System.out.println("the name u gave isn't in devs list");
                }
            }
        }

        public static void showDev(String name){
            for (Developer dev : Devs){
                if(dev.name.equalsIgnoreCase(name)){
                    dev.displayDetails();
                }
            }

        }
    }
    
    
    public static void main(String[] args) {  
        Manager.addmanager(new Manager("Alice", 50000.0, 35, 2010, "Manager", "Sales", "123 Street", "alice@example.com", "1234567890", "Female", "Married", "Excellent", 10000.0));
        Developer.addDev(new Developer("Bob", 40000.0, 30, 2015, "Developer", "IT", "456 Avenue", "bob@example.com", "0987654321", "Male", "Single", "Good", 20, 50.0));
                
        Scanner sc = new Scanner(System.in);
        Boolean running = true;
        while (running){
            
        System.out.println("What Would U Like To Do");
        System.out.println("1. Add An Employee");
        System.out.println("2. Display Details");
        System.out.println("3. Remove An Employee");
        System.out.println("4. Modify An employee's Details");
        System.out.println("5. Display A Specefic Employee's Details");
        System.out.println("6. Exit");
        System.out.println(" ");

         int choice = sc.nextInt();
            sc.nextLine();

            switch (choice){
                case 1:

                    System.out.println("are u gonna add a manager or a dev ?");
                    String type = sc.nextLine();

                    System.out.println("what's the Emp's name ? ");
                    String name = sc.nextLine();

                    System.out.println("what's their base salary ? ");
                    Double baseSalary = sc.nextDouble();
                    
                    System.out.println("what's their age? ");
                    Integer age = sc.nextInt();
                    
                    System.out.println("in what year did they join us ? ");
                    Integer joiningYear = sc.nextInt();
                    
                    System.out.println("what's the Emp's Designation? ");
                    String designation = sc.nextLine();
                    
                    System.out.println("what's their departement? ");
                    String department = sc.nextLine();
                    
                    System.out.println("what's their address ? ");
                    String address = sc.nextLine();
                    
                    System.out.println("what's their email ? ");
                    String email = sc.nextLine();
                    
                    System.out.println("what's their Pone number ? ");
                    String phone = sc.nextLine();
                    
                    System.out.println("what's their gender ? ");
                    String gender = sc.nextLine();
                    
                    System.out.println("what's their maritalStatus ? ");
                    String maritalStatus = sc.nextLine();
                    
                    System.out.println("how are they performing at work ? ");
                    String performance = sc.nextLine();

                    if (type.equals("manager")){
                        
                        System.out.println("what is their bonus ? ");
                        Double bonus = sc.nextDouble();
                        Manager.addmanager(new Manager(name, baseSalary, age, joiningYear, designation, department, address, email, phone, gender, maritalStatus, performance, bonus));
                        
                    }else if (type.equals("dev")){

                        System.out.println("overtimehours ? ");
                        Integer overtimehours = sc.nextInt();
                        System.out.println("overtimerate ? ");
                        Double overtimerate = sc.nextDouble();
                        Developer.addDev(new Developer(name, baseSalary, age, joiningYear, designation, department, address, email, phone, gender, maritalStatus, performance, overtimehours, overtimerate));


                    }else{
                        System.out.println("invalid job type ! but lets ignor it for now");
                    }
                    sc.nextLine();
                     break;
                
                case 2:
                //     Display Details
                    System.out.println("1 - Manager details ?");
                    System.out.println("2 - Devs details ?");
                    System.out.println("3 - Exit ?");
                    int choice2 = sc.nextInt();
                    sc.nextLine();
                    switch(choice2){
                        case 1:
                            Manager.displayAllManagers();
                            break;
                        case 2:
                            Developer.displayAllDevs();
                            break;
                        case 3:
                            running = false;
                            break;
                            
                        default:
                            System.out.println("invalid choice !");
                            break;
                    }
                    break;

                case 3:
                    //remove an employee from the list by name
                    System.out.println("enter the name of the employee you want to remove : ");
                    String nametoremove = sc.nextLine();

                    System.out.println("are they a dev or a manager ?");
                    String typetoremove = sc.nextLine();

                    if (typetoremove.equalsIgnoreCase("manager")){
                        Manager.removeManager(nametoremove);
                    }else if (typetoremove.equalsIgnoreCase("dev")){
                        Developer.removeDev(nametoremove);
                    }else{
                        System.out.println("invalid job type ! but lets ignor it for now");
                        }

                    
                    break;

                case 4:
                // Modify An employee's Details
                    System.out.println("enter the name of the employee you want to modify : ");
                    String nametomodify = sc.nextLine();

                    System.out.println("are they a dev or a manager ?");
                    String typetomodify = sc.nextLine();

                    if (typetomodify.equalsIgnoreCase("manager")){
                        Manager.editManager(nametomodify);
                    }else if (typetomodify.equalsIgnoreCase("dev")){
                        Developer.editDev(nametomodify);
                    }else{
                        System.out.println("invalid job type ! but lets ignor it for now");
                        }
                    
                    break;

                case 5:
                // Display A Specefic Employee's Details
                    System.out.println("whats the name of the employee");
                    String nametoshow = sc.nextLine();
                    System.out.println("are they a dev or a manager ?");
                    String typetoshow = sc.nextLine();
                    while(true){
                    if ( typetoshow.equalsIgnoreCase("dev")){
                        Developer.showDev(nametoshow);

                        break;
                    }else if ( typetoshow.equalsIgnoreCase("manager")){
                        Manager.showManager(nametoshow);

                        break;
                    }else{
                        System.out.println("not a valide type , dev or manager !?");
                    }}
                    break;
                case 6:
                    running = false;
                    break;
                    
                    
                default:
                    System.out.println("invalid choice try again with a number between 1-5");
                    
            }
        }


    }
    

}
