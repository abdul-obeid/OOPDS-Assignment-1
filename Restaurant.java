import java.util.*;
import java.io.*;

public class Restaurant extends User{
	private String name; // Restaurant name
	private Menu menu; // Restaurant's Menu
	private String description; // Restaurant's description 
	private ArrayList<Order> currentOrders = new ArrayList<>(); // Restaurant's active orders (not collected yet)
	private ArrayList<Order> pastOrders = new ArrayList<>(); // Restaurant's past orders (collected )
	private String address; // Restaurant address
	File restDir; // Restaurant Directory (declare it here to use it in different methods)
	public Restaurant(){ //default constructor 
		super(username, password);
	}
	
	public Restaurant(String name,String username, String password, String description, String address) {
		super(username, password); //get username and password from User class
		this.name = name;
		this.description = description;
		this.address = address;
		try{
			sendRestToFile(); // used to make a directory for the restaurant
			menu = new Menu(name, restDir); // send Restaurant name and Directory file to make the menu
		}
		catch(IOException ex){
			System.out.println("File or directory not found " + ex.getMessage());
		}
	}	
	private void sendRestToFile() throws FileNotFoundException{ // used to make a directory for the restaurant
		restDir = new File("Restaurant/" + name);
		restDir.mkdir(); // make the directory using the restaurant name
		File restaurantInfo = new File(restDir + "/basicInfo.txt"); // make a text file to store the restaurant information
		PrintWriter outputRestInfo =  new PrintWriter(restaurantInfo); // writes into the basicInfo.txt
		outputRestInfo.println(name); // move the info to the basicInfo.txt file
		outputRestInfo.println(getUsername());
		outputRestInfo.println(getPassword());
		outputRestInfo.println(description);
		outputRestInfo.println(address);
		outputRestInfo.close(); // close basicInfo.txt file
	}
	public void setName(String name){
		this.name = name;
	}
	
	public void setMenue(Menu menu){
		this.menu = menu;
	
	}
	
	
	public void setAddress(String adress){
		this.address= address;
	}
	
	public String getName(){
		return name;
	}
	
	
	public Menu getMenu(){
		return menu;
	}
	
	public String getAddress(){
		return address;
	}
	public String getDescription(){
        return this.description;
    }
	public ArrayList<Order> getCurrentOrders(){ // get the active orders which not collected yet
		return currentOrders;
	}
	
	public void removeFromCurrentOrders(Order removedOrder){ // remove the order from current orders after being collected
		currentOrders.remove(removedOrder);
	}
	public void addToCurrentOrders(Order newOrder){ // make new order in the restaurant
		currentOrders.add(newOrder);
	}
	public void showAndUpdateCurrentOrders(){ // show the orders and update the status to ready
		Scanner scan = new Scanner(System.in);
		
			if(currentOrders.size() == 0){
				System.out.print("you have no orders in the meanTime");
				return;
			}
			else{
				RestaurantUI.clearScreen(); // clear the screen
				System.out.println();
				System.out.println();
				for(int i = 0; i < currentOrders.size(); ++i)
					System.out.println("\t\t" + currentOrders.get(i));
				System.out.print("\n\n\t\t" + "choose number of order to show or update: ");
				int choosenOrder = (scan.nextInt() - 1);
				do{
				RestaurantUI.clearScreen();
				System.out.println("+----------------------------------------------------+");
				System.out.println("|\tOrder ID: " + currentOrders.get(choosenOrder).getID());
				System.out.println("|\tCustomer Username: " + currentOrders.get(choosenOrder).getCusUsername());
				System.out.println("|\tTime Requested: " + currentOrders.get(choosenOrder).getTimeRequested());
				System.out.println("|\tOrder Status: " + currentOrders.get(choosenOrder).getOrderStatus());
				System.out.println("|\tOrder Contents: " );
				for(int i = 0; i < currentOrders.get(choosenOrder).getOrderContents().size(); ++i){
					System.out.println("|\t\tItem #" + (i+1) + " Name: " + currentOrders.get(choosenOrder).getOrderContents().get(i).getItemName());
					System.out.println("|\t\tItem ID: " + currentOrders.get(choosenOrder).getOrderContents().get(i).getItemID());
					System.out.println("|\t\tItem Price: " + currentOrders.get(choosenOrder).getOrderContents().get(i).getItemPrice());
					System.out.println("|");
				}
				System.out.println("|\tTotal Price: RM" + currentOrders.get(choosenOrder).getOrderPrice());
				System.out.println("|\n|\t1) Update Order Status to ready ");
				System.out.println("|\t2) Back to Restaurant Dashboard ");
				int choosenAction = scan.nextInt();
				if(choosenAction == 1){
					currentOrders.get(choosenOrder).setOrderStatus("READY");
					
				}
				else if(choosenAction == 2){
					break;
				}
				else
					throw new InputMismatchException();
			}while(true);
		}
	}
	public ArrayList<Order> getPastOrders(){ // get order history for the restaurant
		try{
			readOrderHistoryFromFiles(); // reads the order files and sets them as history  
		}
		catch(IOException ex){
			System.out.println("File not found: " + ex.getMessage());
		}
		return pastOrders;
	}
	
	private void readOrderHistoryFromFiles() throws IOException{
		pastOrders.clear(); // clear the menuContents to avoid redundant items
		File pastOrdersFileInput = new File(restDir + "/Order/names.txt" );
		Scanner inputOrders = new Scanner(pastOrdersFileInput);
		while(inputOrders.hasNext()){
			File orderFile = new File(restDir + "/Order/" + inputOrders.nextLine() + ".txt");
			// Scanner OrderNameScanner = new Scanner(orderFile);
			pastOrders.add(new Order(orderFile));
		}
		inputOrders.close();
	}
	public String toString(){
		return ("Restaurant Name: " + name + "\n, Address: " + address + ", About us: " + description);
	}
	
	public  boolean validateLogin(String userAttempt, String passwordAttempt){
		if(userAttempt.equals(getUsername()) && passwordAttempt.equals(getPassword()))
			return true;
		else
			return false;
	}

	
}