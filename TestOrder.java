import java.util.ArrayList;

public class TestOrder {

    public static void main(String [] args) {
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

        Order o1 = new Order("Gus Consumerman", "Pizza Palace", sampleShoppingCart, 27);
        System.out.println(o1);
        System.out.println("Time requested: " + o1.getTimeRequested() +". ");
    }
    
}