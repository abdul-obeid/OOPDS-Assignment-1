import java.util.Date;
import java.util.ArrayList;

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

    //CONSTRUCTORS

    public Order() {   //Default constructor
        this.orderID = ++lastID;
        this.orderStatus = "Sent to restaurant";
        this.timeRequested = new Date();    
    }

    public Order(String newCusName, String newResName, ArrayList<Item> newContents, double newPrice){  
        this.orderID = ++lastID;
        this.cusUsername = newCusName;
        this.resName = newResName;
        for (Item i:newContents){    //Copies newContents into orderContents
            this.orderContents.add(i);
        }
        this.orderStatus = "Sent";
        this.orderPrice = newPrice;
        this.timeRequested = new Date(); //Sets timeRequested to the current time
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