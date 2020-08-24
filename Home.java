import java.util.Scanner;
import java.util.InputMismatchException;

public class Home {
    public static void main(String[] args) {
     Scanner input = new Scanner(System.in);
     do{
        System.out.println("Select user type: ");
        System.out.println("1. Restaurant");
        System.out.println("2. Customer");
        try{
            int role = input.nextInt();
            if (role == 1) { //show the menu for restaurant owners
                System.out.println("Please select your restaurant: ");
                System.out.println("1. Pizza Palace");
                System.out.println("2. Shwayte");
                System.out.println("3. Mamak Station");
                System.out.println("4. Back to role selection");
                
            }
            else if (role == 2) {  //show the menu for customers
                System.out.println("Please enter your username and password : ");
            
            }
            else {
                throw new InputMismatchException("Must enter integer");
            }
            // choose(role);
            // if (role != 1)
        }
        catch (InputMismatchException ex) {
            System.out.println("Invalid entry. Please enter the number of your choice: ");
            input.nextLine();
        }
    } while (true);
    }

    // public void choose (int role) throws InputMismatchException{
    //     if (role = 1) { //show the menu for restaurant owners
    //         System.out.println("Select user type: ");
    //         System.out.println("1. Restaurant");
    //         System.out.println("2. Customer");
    //     }
    //     else if (role = 2) {  //show the menu for customers
    //         System.out.println("Select user type: ");
    //         System.out.println("1. Restaurant");
    //         System.out.println("2. Customer");
    //     }
    //     else {
    //         throw new InputMismatchException("Must enter integer");
    //     }
        
    // }
    
}