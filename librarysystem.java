package Java_Mini_Projects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class librarysystem {
    public static class Book {
        //fields:
        public String title ;
        public String author ;
        public Integer year;
        public Boolean isCheckedOut ;

        //constructor:
        public Book(String title , String author,Integer year , Boolean isCheckedOut ){
            this.title =title;
            this.author = author;
            this.year = year;
            this.isCheckedOut = false;
        }

        //methods (add view check) :
        public void viewdetails(){
            System.out.println("book title : "+title);
            System.out.println("book author : "+author);
            System.out.println("book year : "+year);
            System.out.println("Is the book CheckedOut : "+ (isCheckedOut? "yes":"no"));

        }

        public void checkoutbook(){
            if (!isCheckedOut){
                isCheckedOut = true;
                System.out.println(title+ "has been checked out correctly");

            }else{
                System.out.println("Sorry, "+title+" is already checked out");
            }
        }

        public void returnbook(){
            if(isCheckedOut){
                isCheckedOut = false;
                System.out.println(title+ "has been returned correctly");

            }else{
                System.out.println("it wasn't checked aslan :/");
            }
        }


    }
    public static class library{
        List<Book> books;

        public library(){
            books = new ArrayList<>();
        }

        public void addbook(Book book){
            books.add(book);
            System.out.println(book.title +" has been added  to the library!");


        };
        public void displayallbooks(){
            for (Book book : books){
                book.viewdetails();
                
            }
        };
        public void checkoutbytitle(String title){
            for(Book book : books){
                if(book.title.equals(title)){
                    book.checkoutbook();
                    return;
                }
            }
            System.out.println("the book wasn't found ");
        };

        public void returnbookbytitle(String title){
            for( Book book : books){
                if (book.title.equalsIgnoreCase(title)){
                    book.returnbook();
                    return;
                }
            }
            System.out.println("the book wasn't found");


        };

    }
    public static void main(String[] args) {
        library library = new library();
        Scanner sc = new Scanner(System.in);
        boolean running= true;
        while(running){
            System.out.println("\ntWelcome To My Library Management System");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Check Out Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.print("So ... what's ur choice : ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice){
                case 1:
                    System.out.println("what's the book's name ? ");
                    String title = sc.nextLine();
                    System.out.println("who's its author ? ");
                    String author = sc.nextLine();
                    System.out.println("in what year was it published ? ");
                    int year = sc.nextInt();
                    sc.nextLine();

                    library.addbook(new Book(title, author, year, null));
                    break;
                
                case 2:
                    library.displayallbooks();
                    break;
                
                case 3:
                    System.out.println("what's the book's name ? ");
                    String checkouttitle = sc.nextLine();
                    library.checkoutbytitle(checkouttitle);
                    break;

                case 4:
                    System.out.println("what's the book's name ? ");
                    String returnbooktitle = sc.nextLine();
                    library.returnbookbytitle(returnbooktitle);
                    break;

                case 5:
                    running = false;
                    break;
                    
                default:
                    System.out.println("invalid choice try again with a number between 1-5");
                    
            }

        }
        
    }
    
}
