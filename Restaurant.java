import java.util.*;
import java.io.*;

public class Restaurant{
	private String name;
	private String userName;
	private Menu menu;
	private String password;
	private String description;
	private ArrayList<Order> currentOrders = new ArrayList<>();
	private ArrayList<Order> pastOrders = new ArrayList<>();
	private String address;
	File restDir;
	public Restaurant(){
		
	}
	
	public Restaurant(String name,String userName, String password, String description, String address) {
		this.name = name;
		this.userName = userName;
		this.password = password;
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
		outputRestInfo.println(userName);
		outputRestInfo.println(password);
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
	public void setPassword(String password){
		this.password = password;
	}
	
	public void setAddress(String adress){
		this.address= address;
	}
	
	public String getName(){
		return name;
	}
	
	public String getPassword(){
		return password;
	}
	
	public Menu getMenu(){
		return menu;
	}
	
	public String getAddress(){
		return address;
	}

	public ArrayList<Order> getCurrentOrders(){
		try{
			readCurrentOrdersFromFiles();
			
		}
		catch(IOException ex){
			System.out.println(ex.getMessage());
		}
		return currentOrders;
	}
	
	public ArrayList<Order> getPastOrders(){
		return pastOrders;
	}
	
	// private void readCurrentOrdersFromFiles() throws IOException{
		// currentOrders.clear(); // clear the menuContents to avoid redundant items
		// File currentOrdersFileInput = new File(restDir + "/Order/names.txt" );
		// Scanner inputOrders = new Scanner(currentOrdersFileInput);
		// while(inputOrders.hasNext()){
			// File orderFile = new File(restDir + "/Order/" + inputOrders.nextLine() + ".txt");
			Scanner OrderNameScanner = new Scanner(orderFile);
			// currentOrders.add(new Order(orderFile));
		// }
		// inputOrders.close();
	// }
	
	
}