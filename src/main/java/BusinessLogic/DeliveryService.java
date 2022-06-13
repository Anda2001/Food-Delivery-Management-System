package BusinessLogic;


import java.util.*;

public class DeliveryService extends Observable implements IDeliveryServiceProcessing {

    private Map<Order, Collection<MenuItem>> orders = new HashMap<>();
    //create a list of menu items
   // private ArrayList<MenuItem> menuItems = new ArrayList<MenuItem>();
}
