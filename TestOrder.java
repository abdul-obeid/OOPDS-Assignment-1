import java.util.ArrayList;
import java.io.IOException;
public class TestOrder {

    public static void main(String [] args) {
        try {
            Customer gus = new Customer("Gus Cusman", "gusman95", "pass1234");
            }
            catch (IOException e) {
                System.out.println("Error customer");
            }
        ArrayList<Item> sampleShoppingCart = new ArrayList<Item>();
        sampleShoppingCart.add(new Item("Pizza", 12, "Circular food", "Main dish") );
        sampleShoppingCart.add(new Item("Milkshake", 5, "Shaken milk", "Drink") );
        sampleShoppingCart.add(new Item("Fries", 5, "Fried potato", "Side") );
        sampleShoppingCart.add(new Item("Cookie", 5, "Sweet circular food", "Dessert") );


        System.out.println("Shopping cart contents: ");//checking shopping cart
        int itemNum = 1;
        for (Item i:sampleShoppingCart){ 
            System.out.print(itemNum++ + ") "+ i + " ");
            System.out.println("\n-------------------");
        }
        try{
        Order o1 = new Order("gusman95", "Pizza Palace", sampleShoppingCart);
        Order o2 = new Order("debacle11", "Pizza Palace", sampleShoppingCart);
        Order o3 = new Order("gusman95", "Pizza Palace", sampleShoppingCart);
        Order o4 = new Order("gusman95", "Pizza Palace", sampleShoppingCart);
        System.out.println(o1);
        //System.out.println("Time requested: " + o1.getTimeRequested() +". ");
        System.out.println(o2);

        } catch (Exception e) { System.out.println("Error order" + e); }
        
    }
    
}