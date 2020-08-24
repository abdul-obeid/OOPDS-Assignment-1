import java.util.*;
import java.io.*;


class TestItem{
	public static void main(String[] args) throws IOException{
		Scanner scan = new Scanner(System.in);
		ArrayList<Item> ItemsArray = new ArrayList<>(); 
		File ItemDir = new File("Item");
		ItemDir.mkdir();
		// Item movingItem;
		FileWriter NamesFileOutput = new FileWriter(ItemDir + "/ItemsNames.txt", true);
		File NamesFileInput = new File(ItemDir + "/ItemsNames.txt" );
		PrintWriter outputNames =  new PrintWriter(NamesFileOutput); // comment that if you don't want to write (test the reading function only)
		do{
			try{
				addItem(outputNames, ItemDir);
			}
			catch(FileNotFoundException ex){
				System.out.println("file not found");
			} 
			System.out.println("add more? (Y/N)");
			char addMore = scan.next().charAt(0);
			if(addMore == 'n' || addMore == 'N')
				break;
		}while(true);
		outputNames.close(); 
		try{
			copyItems(NamesFileInput, ItemDir, ItemsArray);			
		}
		catch(FileNotFoundException ex){
			System.out.println("file not found");
		} 
		
		showItems(ItemsArray);
		
		
		// copyItems(NamesFileInput, ItemDir, ItemsArray);
		
		// showItems(ItemsArray);
		
		
		
		
		
		// while(inputNames.hasNext()){
			// File itemFile = new File(ItemDir + "/" + inputNames.nextLine() + ".txt");
			// Scanner itemNameScanner = new Scanner(itemFile);
			// newArray.add(new Item(itemNameScanner.nextLine(), //using the reading constructor (without incrementing the lastID)
								  // Double.parseDouble(itemNameScanner.nextLine()), 
								  // itemNameScanner.nextLine(), 
								  // itemNameScanner.nextLine(), 
								  // Integer.parseInt(itemNameScanner.nextLine())));
		// }
		
		// System.out.println();
		// System.out.println();
		// System.out.println();
		// for(int j = 0; j < newArray.size(); ++j){
			// System.out.println("Item number: " + (j + 1));
			// System.out.println(newArray.get(j));
			// System.out.println("------------------------");
		// }
		
		// System.out.println(Item.getLastID());
		
		
		
		
	}
	
	static void addItem(PrintWriter outputNames, File ItemDir) throws FileNotFoundException{
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter the item information: (when done, enter stop)");
		System.out.print("Enter item Name: ");
		String itemName = scan.nextLine();
		
		System.out.print("Enter item Price: ");
		double itemPrice = scan.nextDouble();
		
		scan.nextLine(); // consume rest of that line including newline (needed after nextDouble Int ...etc)
		
		System.out.print("Enter item Description: ");
		String itemDescription = scan.nextLine();
		
		System.out.print("Enter item Type: ");
		String itemType = scan.nextLine();
		String copy = null;
		Item movingItem = new Item(itemName, itemPrice, itemDescription, itemType, copy);
		
		itemName = itemName.replace(' ', '_');
		
		outputNames.println(itemName);
		
		
		File itemFile = new File(ItemDir + "/" + itemName + ".txt");
		PrintWriter outputItem =  new PrintWriter(itemFile);
		outputItem.println(movingItem.writeToFile());
		outputItem.close();
	}
	
	static void copyItems(File NamesFileInput, File ItemDir, ArrayList<Item> ItemsArray) throws FileNotFoundException{
		Scanner inputNames = new Scanner(NamesFileInput);
		while(inputNames.hasNext()){
			File itemFile = new File(ItemDir + "/" + inputNames.nextLine() + ".txt");
			Scanner itemNameScanner = new Scanner(itemFile);
			ItemsArray.add(new Item(itemNameScanner.nextLine(), //using the reading constructor (without incrementing the lastID)
								  Double.parseDouble(itemNameScanner.nextLine()), 
								  itemNameScanner.nextLine(), 
								  itemNameScanner.nextLine()));
		}
	}
	
	static void showItems(ArrayList<Item> ItemsArray){
		Scanner scan = new Scanner(System.in);
		System.out.println("which item you want to show?: (enter its number)");
		for(int i = 0; i < ItemsArray.size(); ++i){
			System.out.println((i + 1) + "# " + ItemsArray.get(i).getItemName());
		}
		int itemChoice = scan.nextInt() - 1;
		System.out.println("Name: " + ItemsArray.get(itemChoice).getItemName()); 
		System.out.println("ID: " + ItemsArray.get(itemChoice).getItemID());
		System.out.println("Price: $" + ItemsArray.get(itemChoice).getItemPrice());
		System.out.println("Type: " + ItemsArray.get(itemChoice).getItemType());
		System.out.println("Description: " + ItemsArray.get(itemChoice).getitemDescription());
		System.out.println("Availability: " + ItemsArray.get(itemChoice).getAvailability());
	}
}