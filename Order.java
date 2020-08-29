import java.io.*;
import java.util.*;

public class Order {
    //ATTRIBUTES

    private int orderID;           //Unique order ID
    private static int lastID = 0; //Keeps track of last-used orderID to allow each order to have a unique ID.
    private String cusUsername;    //Customer username
    private String resName;        //Restaurant name
    private ArrayList<Item> orderContents = new ArrayList<Item>();  //ArrayList containing order items
    private String orderStatus;                 //Order status can be: Sent, Preparing, Ready, or Collected
    private double orderPrice;                  //Total order price
    private Date timeRequested = new Date();    //Sets timeRequested to the current time by default
    private Date timeReady;                     //Time when the restaurant finished preparing order
    private Date timeCollected;                 //Time when customer collected order

    File cusDir = new File("Customer\\"); // + cusUsername
    File resDir = new File("Restaurant\\" ); //+ resName


    public void createOrderFile(int orderID, String cusUsername, String resName, ArrayList<Item> orderContents, String orderStatus, double orderPrice) throws IOException{
        
        new File(cusDir + "\\" + cusUsername + "\\Order\\").mkdirs();                                              // code for making order file in restaurant directory
        File cusOrderNames = new File(cusDir + "\\" + cusUsername + "\\Order\\"+"names.txt"); //Adds order filename to names.txt file. Used to fetch order file names later.
        FileWriter cusOrderNamesFileWriter = new FileWriter(cusOrderNames, true);
        PrintWriter cusOrderNamesPrintWriter = new PrintWriter(cusOrderNamesFileWriter);
        cusOrderNamesPrintWriter.println(cusUsername+"_"+ orderID);
        cusOrderNamesPrintWriter.close();
        cusOrderNamesFileWriter.close();

        File cusOrder = new File(cusDir + "\\" + cusUsername + "\\Order\\" +cusUsername+"_"+ orderID +".txt");
		PrintWriter outputCusOrder =  new PrintWriter(cusOrder);
        outputCusOrder.println(orderID);
        outputCusOrder.println(cusUsername);
        outputCusOrder.println(resName);
        outputCusOrder.println(orderStatus);
        outputCusOrder.println(orderPrice);
        for (int i = 0; i< orderContents.size(); i++) {
            outputCusOrder.println(orderContents.get(i).writeToFile()); //Writes item information to file
        }
        outputCusOrder.close();

        
        new File(resDir + "\\" + resName + "\\Order\\").mkdirs();                                              // code for making order file in restaurant directory
        File orderNames = new File(resDir + "\\" + resName + "\\Order\\"+"names.txt"); //Adds order filename to names.txt file. Used to fetch order file names later.
        FileWriter orderNamesFileWriter = new FileWriter(orderNames, true);
        PrintWriter orderNamesWriter = new PrintWriter(orderNamesFileWriter);
        orderNamesWriter.println(cusUsername+"_"+ orderID);
        orderNamesWriter.close();

		File resOrder = new File(resDir + "\\"+resName+"\\Order\\"+cusUsername+"_"+ orderID +".txt");
		PrintWriter outputResOrder =  new PrintWriter(resOrder);
        outputResOrder.println(orderID);
        outputResOrder.println(cusUsername);
        outputResOrder.println(resName);
        outputResOrder.println(orderStatus);
        outputResOrder.println(orderPrice);
        for (int i = 0; i< orderContents.size(); i++) {
            outputResOrder.println(orderContents.get(i).writeToFile()); //Writes item information to file
        }
        outputResOrder.close();
	}

    //CONSTRUCTORS

    public Order() {}   //Default constructor
        
    public Order(String newCusUsername, String newResName, ArrayList<Item> newContents) throws IOException{  //Constructor for new orders
        this.orderID = ++lastID;
        this.cusUsername = newCusUsername;
        this.resName = newResName;
        for (Item i:newContents){    //Copies newContents into orderContents
            this.orderContents.add(i);
            this.orderPrice += i.getItemPrice();
        }
        this.orderStatus = "Sent";
        this.timeRequested = new Date(); //Sets timeRequested to the current time
        createOrderFile(this.orderID, this.cusUsername, this.resName, this.orderContents, this.orderStatus, this.orderPrice);
    }
    public Order(String filePath) throws IOException { //Constructor for orders in file
        Scanner orderInfo = new Scanner(new File(filePath));
        this.orderID = Integer.parseInt(orderInfo.nextLine());
        this.cusUsername = orderInfo.nextLine();
        this.resName = orderInfo.nextLine();
        this.orderStatus = orderInfo.nextLine();
        this.orderPrice = Double.parseDouble(orderInfo.nextLine());

        while (orderInfo.hasNext()) {       // Creates items from file
            this.orderContents.add(new Item(orderInfo.nextLine(),Double.parseDouble(orderInfo.nextLine()),orderInfo.nextLine(),orderInfo.nextLine())); 
        }
        orderInfo.close();
    }


    //GETTERS AND SETTERS

    public int getID() {    
        return orderID;
    }
    public void setID(int newID) {  
        this.orderID = newID;
    }
    public String getCusUsername() {
        return cusUsername;
    }
    public void setCusUsername(String newName) {
        this.cusUsername = newName;
    }
    public String getResName() {
        return resName;
    }
    public void setResName(String newName) {
        this.resName = newName;
    }
    public ArrayList<Item> getOrderContents() {
        return orderContents;
    }
    public String getOrderStatus() {
        return orderStatus;
    }
    public void setOrderStatus(String newStatus) {
        this.orderStatus = newStatus;
    }
    public Date getTimeRequested() {
        return timeRequested;
    }
    public Date getTimeReady() {
        return timeReady;
    }
    public Date getTimeCollected() {
        return timeCollected;
    }
    public static int getLastID() {
        return lastID;
    }   
    
    // TOSTRING METHOD

    @Override
    public String toString() {
        return "Order# " + orderID +". Ordered by " + cusUsername
        + " from restaurant " + resName + ". Order status: " + orderStatus;
    }
}