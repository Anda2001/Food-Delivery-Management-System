package businessLogic;

import java.util.*;

/**
 * @invariant isWellFormed()
 */
public interface IDeliveryServiceProcessing {

    /**
     * @pre isWellFormed()
     * @pre !username.isEmpty()
     * @pre !password.isEmpty()
     *
     * @post isWellFormed()
     *
     */
    public boolean register(String username, String password);

    /**
     * @pre isWellFormed()
     * @pre !username.isEmpty()
     * @pre !password.isEmpty()
     *
     * @post isWellFormed()
     *
     */
    public Client logIn(String username, String password);

    /**
     * @pre isWellFormed()
     * @pre menuItem!=null
     *
     * @post isWellFormed()
     *
     */
    public void addBaseMenuItem(String title, String rating, String calories, String proteins, String fats, String sodium, String price);
    public void addCompositeMenuItem(String title, ArrayList<MenuItem> menuItems);

    /**
     * @pre isWellFormed()
     * @pre menuItem!=null
     *
     * @post isWellFormed()
     *
     */
    public void editMenuItem(String title, String rating, String calories, String proteins, String fats, String sodium, String price);

    /**
     * @pre isWellFormed()
     * @pre !menuItem.isEmpty()
     *
     * @post isWellFormed()
     *
     */
    public void deleteMenuItem(String menuItem);

    /**
     * @pre isWellFormed()
     *
     * @post isWellFormed()
     *
     */
    public void addOrder(String[] rows, int id);


    public Map<Object, Object> getWithinDay(int day, int month, int year);

    /**
     * @pre order != null
     *
     */
    public void bill(Order order);
    public List<MenuItem> getMenu();
    public void setMenu(List<MenuItem> menu);
    public List<Client> getClients();
    public void setClients(List<Client> clients);
    public HashMap<Order, ArrayList<MenuItem>> getOrders();
    public void setOrders(HashMap<Order, ArrayList<MenuItem>> orders);
    public boolean isWellFormed();
    public ArrayList<MenuItem> searchProducts(String title, String rating, String calories, String protein, String fat, String sodium, String price);


}

