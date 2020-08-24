import java.util.*;
import java.io.*;


class TestItem{
	public static void main(String[] args) throws FileNotFoundException{
		Scanner scan = new Scanner(System.in); 
		
		ArrayList<Item> array = new ArrayList<>();
		File NamesFile = new File("ItemsNames.txt");
		PrintWriter outputNames =  new PrintWriter(NamesFile); // comment that if you don't want to write (test the reading function only)
		
		
		int i = 0;
		do{			// comment that if you don't want to write (test the reading function only)
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
			array.add(new Item(itemName, itemPrice, itemDescription, itemType));
			
			itemName = itemName.replace(' ', '_');
			
			outputNames.println(itemName);
			
			
			File itemFile = new File(itemName + ".txt");
			// Scanner inputItem = new Scanner(itemFile);
			PrintWriter outputItem =  new PrintWriter(itemFile);
			outputItem.println(array.get(i));
			outputItem.close();
			System.out.print("Continue? (Y/N): ");
			char countinue = scan.next().charAt(0);
			if(countinue == 'N' || countinue == 'n')
				break;
			else
				scan.nextLine();// consume rest of that line including newline (needed after nextDouble Int ...etc)
				++i;
		}while(true); // comment that if you don't want to write (test the reading function only)
		
		outputNames.close(); // comment that if you don't want to write (test the reading function only)
		ArrayList<Item> newArray = new ArrayList<>();
		
		
		
		Scanner inputNames = new Scanner(NamesFile);
		while(inputNames.hasNext()){
			File itemFile = new File(inputNames.nextLine() + ".txt");
			Scanner itemNameScanner = new Scanner(itemFile);
			newArray.add(new Item(itemNameScanner.nextLine(), Double.parseDouble(itemNameScanner.nextLine()), itemNameScanner.nextLine(), itemNameScanner.nextLine()));
		}
		
		for(int j = 0; j < newArray.size(); ++j){
			
			System.out.println(newArray.get(j));
			System.out.println("------------------------");
		}
		
		
		
	}
}