import java.io.IOException;

public class testCustomer {
    public static void main(String [] args) {
        try {
        // Customer gus = new Customer("gusman95");
        // Customer debacle = new Customer("Adam", "debacle11", "pass1234");
        // System.out.println(gus);
        
       Customer debacle = new Customer("gusman95");
       System.out.println(debacle);
       System.out.println(debacle.getPassword());
       for (Order i : debacle.getPastOrders() ) {
            System.out.print(i + " ");
            System.out.println(i.getOrderContents());
       }

    }
        catch (IOException e) {
            System.out.println("Error" + e);
        }
    }
}