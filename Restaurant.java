import java.util.*;
import java.io.*;

public class Restaurant extends User{
	private String name;
	private Menu menu;
	private String description;
	private ArrayList<Order> currentOrders = new ArrayList<>();
	private ArrayList<Order> pastOrders = new ArrayList<>();
	private String address;
	File restDir;
	// public Restaurant(){
		
	// }
	
	public Restaurant(String name,String username, String password, String description, String address) {
		super(username, password);
		this.name = name;
		this.description = description;
		this.address = address;
		try{
			sendRestToFile();
			menu = new Menu(name, restDir);
		}
		catch(IOException ex){
			System.out.println(ex.getMessage());
		}
	}	
	private void sendRestToFile() throws FileNotFoundException{
		restDir = new File("Restaurant/" + name);
		restDir.mkdir();
		File restaurantInfo = new File(restDir + "/basicInfo.txt");
		PrintWriter outputRestInfo =  new PrintWriter(restaurantInfo); // comment that if you don't want to write (test the reading function only)
		outputRestInfo.println(name);
		outputRestInfo.println(getUsername());
		outputRestInfo.println(getPassword());
		outputRestInfo.println(description);
		outputRestInfo.println(address);
		outputRestInfo.close();
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

	public ArrayList<Order> getCurrentOrders(){
		return currentOrders;
	}
	
	public void addToCurrentOrders(Order o){
		
	}
	
	public ArrayList<Order> getPastOrders(){
		try{
			readOrderHistoryFromFiles();
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
		return "edit me";
	}
	
	public  boolean validateLogin(String userAttempt, String passwordAttempt){
		if(userAttempt.equals(getUsername()) && passwordAttempt.equals(getPassword()))
			return true;
		else
			return false;
	}

	
}