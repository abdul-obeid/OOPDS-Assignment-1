import java.util.*;
import java.io.*;
public class Menu{
	private ArrayList<Item> menuContents = new ArrayList<>();
	private File menuDir;
	public Menu(){
		
	}
	
	public Menu(File restDir) throws IOException{		
		menuDir = new File(restDir + "/Menu");  // makes a directory for the menu inside each restaurant
		menuDir.mkdir();
		try{
			copyItems(); // copy the items from the files to the menuContents 
		}
		catch(FileNotFoundException ex){
			System.out.println("you have no items in the menu, you need to add some");
		}
	}
	
	public ArrayList<Item> getMenuContents(){
		return menuContents;
	}
	
	
	public void addItemToMenuDir() throws IOException{ // makes a new file for the items (used to update and input new items)
		boolean existFlag = false;
		Scanner scan = new Scanner(System.in);
		Item newItem = new Item();
		
		System.out.print("Enter item Name: ");
		newItem.setItemName(scan.nextLine());
		for(int i = 0; i < menuContents.size(); ++i){
			if(menuContents.get(i).getItemName().equals(newItem.getItemName()));
				existFlag = true;
		}
		if(existFlag)
			System.out.println("Item already exist");
		else{
			System.out.print("Enter item Price: ");
			newItem.setItemPrice(scan.nextDouble());
			
			scan.nextLine(); // consume rest of that line including newline (needed after nextDouble Int ...etc)
			
			System.out.print("Enter item Description: ");
			newItem.setItemDescription(scan.nextLine());
			
			System.out.print("Enter item Type: ");
			newItem.setItemType(scan.nextLine());
			
			FileWriter NamesFileOutput = new FileWriter(menuDir + "/ItemsNames.txt", true); // makes a file to save the items names to read them later, the true value is to be able to write more without clearing the file every time
			PrintWriter outputNames =  new PrintWriter(NamesFileOutput); // PrintWriter to write to Itemsnames.txt
			
			
			String itemName = newItem.getItemName();
			itemName = itemName.replace(' ', '_'); // replace the spaces in the item name with _ to make reading the files easier
			
			outputNames.println(itemName);
			
			
			File itemFile = new File(menuDir + "/"  + itemName + ".txt"); // makes a new file with the new item name and its information
			PrintWriter outputItem =  new PrintWriter(itemFile);
			outputItem.println(newItem.writeToFile());
			outputItem.close();
			
			outputNames.close();
		}
	}
	
	public void removeItem(Item removedItem) throws FileNotFoundException{ // remove the item from the ItemsName.txt and menuContents, it won't be read anymore by copyItems method
		File NamesFileInput = new File(menuDir + "/ItemsNames.txt" );
		File temp = new File(menuDir + "/temp.txt"); // make a temp file to copy all the other names to it.
		PrintWriter moveToTemp = new PrintWriter(temp);
		Scanner originalNames = new Scanner(NamesFileInput);
		
		while(originalNames.hasNext()){
			String nextName = originalNames.next();
			if(!nextName.equals(removedItem.getItemName()))
				moveToTemp.println(nextName);
				
		}
			
		moveToTemp.close();
		originalNames.close();
		File tempName = NamesFileInput;
		System.out.println(NamesFileInput.delete());
		System.out.println(temp.renameTo(tempName)); // give the temp file the name "ItemsName" after deleting the old one
		menuContents.remove(removedItem);
	}
	
	
	private void copyItems() throws FileNotFoundException{ // copy the items with the names from ItemsNames.txt to the actual menuContents
		menuContents.clear(); // clear the menuContents to avoid redundant items
		File NamesFileInput = new File(menuDir + "/ItemsNames.txt" );
		Scanner inputNames = new Scanner(NamesFileInput);
		while(inputNames.hasNext()){
			File itemFile = new File(menuDir + "/" + inputNames.nextLine() + ".txt");
			Scanner itemNameScanner = new Scanner(itemFile);
			menuContents.add(new Item(itemNameScanner.nextLine(), //using the reading constructor (without incrementing the lastID)
								  Double.parseDouble(itemNameScanner.nextLine()), 
								  itemNameScanner.nextLine(), 
								  itemNameScanner.nextLine(),
								  itemNameScanner.nextBoolean()));
		}
		inputNames.close();
	}
	
	public void showItems(){
		try{
			copyItems(); // copy the items from the files to the menuContents 
		}
		catch(FileNotFoundException ex){
			System.out.println("you have no items in the menu, you need to add some");
		}
		Scanner scan = new Scanner(System.in);
		System.out.println("which item you want to show?: (enter its number)");
		for(int i = 0; i < menuContents.size(); ++i){
			System.out.println((i + 1) + "# " + menuContents.get(i).getItemName());
		}
		int itemChoice = scan.nextInt() - 1;
		System.out.println("Name: " + menuContents.get(itemChoice).getItemName()); 
		System.out.println("ID: " + menuContents.get(itemChoice).getItemID());
		System.out.println("Price: $" + menuContents.get(itemChoice).getItemPrice());
		System.out.println("Type: " + menuContents.get(itemChoice).getItemType());
		System.out.println("Description: " + menuContents.get(itemChoice).getItemDescription());
		System.out.println("Availability: " + menuContents.get(itemChoice).getAvailability());
	}
	
	public void updateItem(Item updatedItem){
		Scanner scan = new Scanner(System.in);
		do{
			System.out.println("1)Desc");
			System.out.println("2)Price");
			System.out.println("3)Type");
			System.out.println("4)Availability");
			System.out.println("5)Back");
			System.out.print("Select which attribute to change: ");
			int choosenAttribute = scan.nextInt(); 
			scan.nextLine(); 
			
			if(choosenAttribute == 1){
				System.out.print("Enter new description: ");
				updatedItem.setItemDescription(scan.nextLine());
			}
			else if(choosenAttribute == 2){
				System.out.print("Enter new price: ");
				updatedItem.setItemPrice(scan.nextDouble());
			}
			else if(choosenAttribute == 3){
				System.out.print("Enter new Type: ");
				updatedItem.setItemType(scan.nextLine());
			}
			else if(choosenAttribute == 4){
				System.out.print("Enter new Availability: ");
				updatedItem.setItemAvailability(scan.nextBoolean());
			}
			else if(choosenAttribute == 5)
				break;
			else
				System.out.print("Invalid input");
			
			try{
				File itemFile = new File(menuDir + "/"  + updatedItem.getItemName() + ".txt"); // makes a new file with the new item name and its information
				PrintWriter outputItem =  new PrintWriter(itemFile);
				outputItem.println(updatedItem.writeToFile());
				outputItem.close();
			}
			catch(IOException ex){
				System.out.println("directorty not found");
			}
		}while(true);
	}
	
	
	// @Override
	// public String toString(){
		// return( 
		// for(int i = 0; i < menuContents.size(); ++i
			// menuContents.get(i););
	// }
}

