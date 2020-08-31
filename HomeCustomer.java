import java.util.*;
import java.io.*;
import java.nio.file.*;

public class HomeCustomer {
    public static void main(String[] args) {
     Scanner input = new Scanner(System.in);
     do{
        System.out.println("Select user type: ");
        System.out.println("1. Restaurant");
        System.out.println("2. Customer");
        try{
            int choice = input.nextInt();
            if (choice == 1) { //show the menu for restaurant owners
                //
                // Restaurant owner code
                //
                
            }
            else if (choice == 2) {  //show the menu for customers
                System.out.println("Select action: ");
                System.out.println("1. Login");
                System.out.println("2. Create account");
                System.out.println("3. Back to user select");

                choice = input.nextInt();
                if (choice == 1){
                    //login
                }
                else if (choice == 2){
                    //create acc
                }
                else if (choice == 3){
                    //back
                }
                else throw new InputMismatchException("Must enter integer");

            
            }
            else {
                throw new InputMismatchException("Must enter integer");
            }
        }
        catch (InputMismatchException ex) {
            System.out.println("Invalid entry. Please enter the number of your choice: ");
            input.nextLine();
        }
    } while (true);
    }

    public void ui1() throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the number corresponding with your desired option: ");
        System.out.println("1. Login ");
        System.out.println("2. Create account ");
        int choice = input.nextInt();
        if (choice == 1) {
            ui2();
        }
        else if (choice == 2) {
            ui3();
        }
    }

    public void ui2() throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter your username and password, seperated by a space (E.g. \"jack87 pass8362\") ");
        System.out.println("Alternatively, enter \"BACK\" to go to the previous menu. ");
        
        String choice = input.next();
        if (choice == "BACK") {
            ui1();
        }
        else {
            String userAttempt = input.next();
            try {
                Customer c = new Customer(userAttempt);
                String passAttempt = input.next();
                if (c.getPassword() == passAttempt) {
                    System.out.println("Login Successful. Welcome "+ c.getName()+"! ");
                    ui4(c);
                }
                else {
                    System.out.println("Login failed. Please try again. ");
                    ui2();
                }
            } catch (IOException e) {
                System.out.println("Error:" + e.getMessage() +". Username does not exist.");
            }
        }
    }

    public void ui3() throws IOException{
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter your desired username(E.g. \"jack87\" )");
        System.out.println("Alternatively, enter \"BACK\" to go to the previous menu. ");
        String choice = input.next();
        if (choice == "BACK") {
            ui1();
        }
        else {
            String userCreateAttempt = input.next();
            try {
                if ( new File("Customer\\" + userCreateAttempt + "\\").exists()) {
                    System.out.println("Error: Username already taken. Please try another one.");
                    ui3();
                }
                else {
                    System.out.println("Please enter your desired password(E.g. \"pass8362\")" );
                    System.out.println("Alternatively, enter \"BACK\" to go to the previous menu. ");

                    String passCreateAttempt = input.next();

                    System.out.println("Please enter your full name(E.g. \"John Smith\")" );
                    System.out.println("Alternatively, enter \"BACK\" to go to the previous menu. ");

                    String nameCreateAttempt = input.nextLine();

                    Customer c = new Customer(nameCreateAttempt, userCreateAttempt, passCreateAttempt);
                    ui1();
                }
            } catch (IOException e) {
                System.out.println("Error:" + e.getMessage() +". Username does not exist.");
            }
        }
    }



        // String choice = input.next();
        // if (choice == "BACK") {
        //     ui1();
        // }
        

    public void ui4(Customer c) {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome " + c.getName()+ ". Please enter the number corresponding with your desired option: ");
        System.out.println("1. View Restaurants ");
        System.out.println("2. View Active Order ");
        System.out.println("3. View Order History ");
        System.out.println("4. Back to user select ");

        int choice = input.nextInt();
        if (choice == 1) {
            ui5(c);
        }
        else if (choice == 2) {
            ui6(c);
        }
        else if (choice == 3) {
            ui7(c);
        }
        else if (choice == 4) {
            ///////////// ENTER CODE TO GO BACK TO USER SELECT
        }
    }

    public void ui5(Customer c) {
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        if (choice == 1) {
            
        }
        else if (choice == 2) {

        }
        else if (choice == 3) {
            
        }
    }

    public void ui6(Customer c) {
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        if (choice == 1) {

        }
        else if (choice == 2) {

        }
        else if (choice == 3) {
            
        }
    }

    public void ui7(Customer c) {
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        if (choice == 1) {

        }
        else if (choice == 2) {

        }
        else if (choice == 3) {
            
        }
    }

    public void ui8() {
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        if (choice == 1) {

        }
        else if (choice == 2) {

        }
        else if (choice == 3) {
            
        }
    }

    public void ui9() {
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        if (choice == 1) {

        }
        else if (choice == 2) {

        }
        else if (choice == 3) {
            
        }
    }

    public void ui10() {
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        if (choice == 1) {

        }
        else if (choice == 2) {

        }
        else if (choice == 3) {
            
        }
    }

    public void ui11() {
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        if (choice == 1) {

        }
        else if (choice == 2) {

        }
        else if (choice == 3) {
            
        }
    }

    public void ui12() {
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        if (choice == 1) {

        }
        else if (choice == 2) {

        }
        else if (choice == 3) {
            
        }
    }

    public void ui13() {
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        if (choice == 1) {

        }
        else if (choice == 2) {

        }
        else if (choice == 3) {
            
        }
    }

    public void ui14() {
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        if (choice == 1) {

        }
        else if (choice == 2) {

        }
        else if (choice == 3) {
            
        }
    }
}