import java.util.ArrayList;

public class Cart {
    private ArrayList<Item> chosenItems = new ArrayList<Item>();
    private double totalPrice;

    Cart() {}
    
    public ArrayList<Item> getChosenItems() {
        return chosenItems;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
    public void addSelectedItem(Item newItem) {
        this.chosenItems.add(newItem);
    }
    public void removeItem(Item newItem){
        this.chosenItems.remove(newItem);
    }

    @Override
    public String toString() {
        String contents = "";
        for (Item i : chosenItems){
            contents.concat(i.getItemName()+". ");
        }
        return ("Shopping cart contents: "+ contents + ". Total price: "+totalPrice+". ");
    }
}