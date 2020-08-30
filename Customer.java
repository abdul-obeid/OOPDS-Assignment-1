import java.io.*;
import java.util.*;

public class Customer extends User {
    private String name;
    private String username;
    private String password;
    private Order currentOrder;
    private ArrayList<Order> pastOrders = new ArrayList<Order>();
    File cusDir;

    public void createCusFile(String name, String username, String password ) throws IOException{
        cusDir = new File("Customer\\" + username +"\\");
        cusDir.mkdirs();
		File cusInfo = new File(cusDir + "\\info.txt");
		PrintWriter outputCusInfo =  new PrintWriter(cusInfo);
        outputCusInfo.println(name);
        outputCusInfo.println(username);
        outputCusInfo.println(password);
		outputCusInfo.close();
	}
    public Customer() {}
    public Customer(String newName, String newUsername, String newPassword) throws IOException{ //Constructor used for registration
        this.name = newName;
        this.username = newUsername;
        this.password = newPassword;
        createCusFile(newName, newUsername, newPassword);
    }
    public Customer(String cusUsername) throws IOException {   //Constructor used for login
        Scanner cusInfo = new Scanner(new File("Customer\\"+ cusUsername + "\\info.txt"));
        this.name = cusInfo.nextLine();
        this.username = cusInfo.nextLine();
        this.password = cusInfo.nextLine();
        Scanner orderNameTxt = new Scanner(new File("Customer\\"+cusUsername+"\\Order\\names.txt"));
        while (orderNameTxt.hasNext()) {
            String orderNames = orderNameTxt.nextLine();
            this.pastOrders.add(new Order("Customer\\"+cusUsername+"\\Order\\" + orderNames +".txt"));   
        }
    }

    public boolean validateLogin(String userAttempt, String passwordAttempt){
        
    }
    public String getName() {
        return this.name;
    }
    public void setName(String newName) {
        this.name = newName;
    }
    public String getUserame() {
        return this.username;
    }
    public void setUsername(String newUser) {
        this.username = newUser;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String newPass) {
        this.password = newPass;
    }

    public Order getCurrentOrder() {
        return this.currentOrder;
    }

    public void setCurrentOrder(Order newOrder) {
        this.currentOrder = newOrder;
    }

    public ArrayList<Order> getPastOrders() {
        return this.pastOrders;
    }


    @Override
    public String toString() {
        return ("Customer name: " + this.name + ". Username: " + this.username+". ");
    }
}