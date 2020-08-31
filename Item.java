public class Item implements Comparable<Item>{
	private int itemID;
	private static int lastID = 0;
	private String itemName;
	private double itemPrice;
	private String itemDescription;
	private String itemType;
	private boolean availability = true;
	
	public Item(){
		// lastID++;
	}
	
	public Item(String itemName, 
				double itemPrice, 
				String itemDescription, 
				String itemType,
				boolean availability
				){
					
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemDescription = itemDescription;
		this.itemType = itemType;
		this.availability = availability;
		itemID = ++lastID;
	}
	
	public Item(String itemName, //
				double itemPrice, 
				String itemDescription, 
				String itemType){
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemDescription = itemDescription;
		this.itemType = itemType;
	}
	
	
	public static int getLastID(){
		return lastID;
	}
	public static void resetLastID( ){
		lastID = 0;
	}
	
	public void setItemName(String itemName){
		this.itemName = itemName;
	}
	
	public void setItemPrice(double itemPrice){
		this.itemPrice = itemPrice;
	}
	
	public void setItemDescription(String itemDescription){
		this.itemDescription = itemDescription;
	}
	
	public void setItemAvailability(boolean availability){
		this.availability = availability;
	}
	
	public void setItemType(String itemType){
		this.itemType = itemType;
	}
	
	public int getItemID(){
		return itemID;
	}
	
	public String getItemName(){
		return itemName;
	}
	
	public double getItemPrice(){
		return itemPrice;
	}
	
	public boolean getAvailability(){
		return availability;
	}
	
	public String getItemType(){
		return itemType;
	}
	
	public String getItemDescription(){
		return itemDescription;
	}
	
	@Override
	public String toString(){
		return ("Item: " + itemName + ".\n Price: " + itemPrice + " RM. \nDescription: " + itemDescription + ". \nType: " + itemType +". ");
	}
	
	public String writeToFile(){ // writes new 
		return (itemName + "\n" + itemPrice + "\n" + itemDescription + "\n" + itemType + "\n" + availability);
	}
	
	public String writeToOrder(){
		return (itemName + "\n" + itemPrice + "\n" + itemDescription + "\n" + itemType );
	}
	
	@Override
	public int compareTo(Item item){
		if(getItemPrice() > item.getItemPrice())
			return 1; // > greater than
		else if(getItemPrice()  == item.getItemPrice())
			return 0; // ==
		else
			return -1; // <
	}
}