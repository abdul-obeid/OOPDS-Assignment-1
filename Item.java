public class Item{
	private int itemID;
	private static int lastID = 0;
	private String itemName;
	private double itemPrice;
	private String itemDescription;
	private String itemType;
	private boolean availability = true;
	
	public Item(){
		lastID++;
	}
	
	public Item(String itemName, double itemPrice, String itemDescription, String itemType){
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemDescription = itemDescription;
		this.itemType = itemType;
		lastID++;
		itemID = lastID;
	}
	
	public static int getLastID(){
		return lastID;
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
	
	@Override
	public String toString(){
		return ("Item: "+itemName + ". Price: " + itemPrice + " RM. Description: " + itemDescription + ". Type: " + itemType +". ");
	}
	
}