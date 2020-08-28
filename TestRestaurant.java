import java.io.*;
import java.util.*;


public class TestRestaurant{
	public static void main(String[] args){
		File allRestDir = new File("Restaurant");
		allRestDir.mkdir();
		ArrayList<Item> menuContents = new ArrayList<>();
		
		
		try{
			Restaurant r = new Restaurant("Pizza", "0123456789", "When the craving hits, and believe that it will, you will go to great lengths to be able to enjoy a Fricano's pizza just one more time.", "29 Jalan Riong, Bangsar, Kuala Lumpur, MY 59100");
	
			
		
			r.getMenu().addItemToMenuDir();
			r.getMenu().addItemToMenuDir();
			
			r.getMenu().showItems();
			
		}
		catch(IOException ex){
			System.out.println("file not found");
		}
	}
}