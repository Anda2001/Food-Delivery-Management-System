package businessLogic;


import DataAccess.FileWriter;
import DataAccess.Serializator;
import org.w3c.dom.ls.LSOutput;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class DeliveryService extends Observable implements IDeliveryServiceProcessing {

    private HashMap<Order, ArrayList<MenuItem>> orders = new HashMap<>();
    //create a list of clients
    private List<Client> clients = new ArrayList<>();
    private Observer observator;

    private List<MenuItem> menu = new ArrayList<>();
    Serializator serializator;

    //constructor
    public DeliveryService() {
        serializator= new Serializator();
        setMenu(serializator.readProducts());
        //clients.add(new Client(0, "client", "client"));

        //serialize();
        serializator.deserialize(this);
    }

    public void serialize(){
        serializator.serialize(menu, clients, orders);
    }

    public void deserialize(){
        serializator.deserialize(this);
    }

    @Override
    public boolean register(String username, String password) {
        assert isWellFormed();
        assert !username.isEmpty();
        assert !password.isEmpty();
        int id = clients.size()+1;
        System.out.println(id);
        for(Client client : clients) {
            if(client.getUsername().equals(username))
                return false;
        }
        Client client = new Client(id, username, password);
        //System.out.println(client.getId());
        //print client's credentials
        //System.out.println("Client's credentials: " + client.getUsername() + " " + client.getPassword()+ " "+ client.getId());
        clients.add(client);
        serialize();
        assert isWellFormed();
        for(Client client1 : clients)
            System.out.println(client1.getUsername() + " "+ client1.getId());
        return true;
    }

    @Override
    public Client logIn(String username, String password) {
       // System.out.println("Username: " + username + " " + "Password: " + password);
        for(Client client1 : clients)
            System.out.println(client1.getUsername() + " "+ client1.getId() + " " +client1.getPassword());
        assert !username.isEmpty();
        assert !password.isEmpty();
        assert isWellFormed();
        //System.out.println(clients.size());
        //deserialize();
        for(Client client2 : clients) {
            //print client's credentials
            System.out.println("Client's credentials: " + client2.getUsername() + " " + client2.getPassword());
            //print password and username
            //System.out.println("Username: " + username + " " + "Password: " + password);
            if(client2.getUsername().equals(username) && client2.getPassword().equals(password))
                //assert isWellFormed();
                return client2; continue;
        }
       // assert isWellFormed();
        return null;
    }


    @Override
    public void addBaseMenuItem(String title, String rating, String calories, String proteins, String fats, String sodium, String price) {
        assert isWellFormed();
        BaseProduct menuItem = new BaseProduct( title, Float.valueOf(rating), Integer.valueOf(calories), Integer.valueOf(proteins), Integer.valueOf(fats), Integer.valueOf(sodium), Double.valueOf(price));
        if(menuItem==null){
            System.out.println("Menu item is null");
        }
        else{
            menu.add(menuItem);
            System.out.println("Menu item added");
        }
        //menu.add(menuItem);
        serialize();
        //assert isWellFormed();
    }

    @Override
    public void addCompositeMenuItem(String title, ArrayList<MenuItem> menuItems) {
        assert isWellFormed();
        System.out.println(title);
        for(MenuItem menuItem: menuItems){
            System.out.println((menuItem.getTitle()));
        }
        MenuItem menuItem = new CompositeProduct(title, menuItems);
        menu.add(menuItem);
        serialize();
        assert isWellFormed();
    }

    @Override
    public void editMenuItem(String title, String rating, String calories, String proteins, String fats, String sodium, String price) {
        assert isWellFormed();
        BaseProduct menuItem = new BaseProduct( title, Float.valueOf(rating), Integer.valueOf(calories), Integer.valueOf(proteins), Integer.valueOf(fats), Integer.valueOf(sodium), Double.valueOf(price));
        MenuItem tmp = null;
        for(MenuItem menuItem1 : menu) {
            if(menuItem1.getTitle().equals(menuItem.getTitle())) {
                tmp = menuItem1;
            }
        }
        menu.remove(tmp);
        menu.add(menuItem);
        serialize();
        assert isWellFormed();
    }

    @Override
    public void deleteMenuItem(String menuItem) {
        assert isWellFormed();
        assert !menuItem.isEmpty();
        MenuItem tmp = null;
        for(MenuItem menuItem1 : menu) {
            if(menuItem1.getTitle().equals(menuItem)) {
                tmp = menuItem1;
            }
        }

        menu.remove(tmp);
        serialize();
        assert isWellFormed();
    }

    @Override
    public void addOrder(String[] rows, int id) {
        assert isWellFormed();
        ArrayList<MenuItem> menuItems = new ArrayList<>();
        double price = 0;
        for(String string : rows) {
            for(MenuItem menuItem : menu) {
                if(string.equals(menuItem.getTitle()))
                    menuItems.add(menuItem);
                price += menuItem.getPrice();
            }
        }
        Order order = new Order(orders.size()+1, id, LocalDateTime.now(),price);

        System.out.println("Order added");

        System.out.println(order.orderDate.toString());

        orders.put(order, menuItems);
        setChanged();
        ArrayList<Object> objects = new ArrayList<>();
        objects.add(orders);
        notifyObservers(objects);
        serialize();

        bill(order);

        assert isWellFormed();
    }





    @Override
    public  Map<Object, Object> getWithinDay(int day, int month, int year){

        Map<Object, Object> products = menu.stream()
                .filter(p -> orders.entrySet().stream()
                        .filter(map -> map.getKey().getOrderDay()==day && map.getKey().getOrderMonth() == month && map.getKey().getOrderYear() == year)
                        .filter(o -> o.getValue().stream().anyMatch(c -> c.getTitle().equals(p.getTitle()))).count()>0)
                .collect(Collectors.toMap(p -> p, p -> orders.entrySet().stream()
                        .filter(map -> map.getKey().getOrderDay()==day && map.getKey().getOrderMonth() == month && map.getKey().getOrderYear() == year)
                        .filter(o -> o.getValue().stream().anyMatch(c -> c.getTitle().equals(p.getTitle()))).count()));

        return products;
    }

    @Override
    public void bill(Order order) {
        assert order!=null;
        FileWriter fileWriter = new FileWriter();
        fileWriter.bill(order, orders);
    }

    @Override
    public List<MenuItem> getMenu() {
        return menu;
    }

    @Override
    public void setMenu(List<MenuItem> menu) {
        this.menu = menu;
    }

    @Override
    public List<Client> getClients() {
        return clients;
    }

    @Override
    public void setClients(List<Client> clients) {

        this.clients = clients;
    }

    @Override
    public HashMap<Order, ArrayList<MenuItem>> getOrders() {
        return orders;
    }

    @Override
    public void setOrders(HashMap<Order, ArrayList<MenuItem>> orders) {
        this.orders = orders;
    }

    public boolean isWellFormed() {
        return  orders != null || clients != null ||menu != null || true;
    }

    @Override
    public ArrayList<MenuItem> searchProducts(String title, String rating, String calories, String protein, String fat, String sodium, String price) {
        assert isWellFormed();

        ArrayList<MenuItem> menu = new ArrayList<>(this.menu);
        List<MenuItem> products = menu
                .stream()
                .filter(item -> (title.isEmpty() || item.getTitle().contains(title)) &&
                        (rating.isEmpty() || item.getRating() == Float.parseFloat(rating)) &&
                        (calories.isEmpty() || item.getCalories() == Integer.parseInt(calories)) &&
                        (protein.isEmpty() || item.getProtein() == Integer.parseInt(protein)) &&
                        (fat.isEmpty() || item.getFat() == Integer.parseInt(fat)) &&
                        (sodium.isEmpty() || item.getSodium() == Integer.parseInt(sodium)) &&
                        (price.isEmpty() || item.computePrice() == Double.parseDouble(price)))
                .collect(Collectors.toList());

        assert isWellFormed();
        return new ArrayList<>(products);
    }
    public void addObservator(Order o) {
        observator.update(this, o);
    }
}
