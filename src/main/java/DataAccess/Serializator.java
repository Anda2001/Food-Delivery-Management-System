package DataAccess;


import businessLogic.*;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Serializator {

    //read the data from products.csv using streams
    public List<MenuItem> readProducts() {
          List<BaseProduct> baseProducts;

        try {
            List<String[]> lines = Files.lines(Paths.get("D:\\Faculta\\IIsem2\\PT\\PT2022_30423_Domsa_Anda_Assignment_4\\products.csv"))
                    .filter(line -> !line.startsWith("Title"))
                    .map(line -> line.split(","))
                    .collect(Collectors.toList());
            baseProducts = lines.stream().map(a -> new BaseProduct(a[0], Float.parseFloat(a[1]), Integer.parseInt(a[2]), Integer.parseInt(a[3])
                    , Integer.parseInt(a[4]), Integer.parseInt(a[5]), Double.parseDouble(a[6]))).collect(Collectors.toList());

           // System.out.println(baseProducts);

            Set<String> titleSet = new HashSet<>();

            // verify if the title is unique
            List<BaseProduct> basePr = baseProducts.stream()
                    .filter(c -> titleSet.add(c.getTitle()))
                    .collect(Collectors.toList());

            //System.out.println(basePr.stream().distinct().collect(Collectors.toList()));
            return basePr.stream().distinct().collect(Collectors.toList());


        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;

    }

    //serialize the data to file.txt
    public void serialize(List<MenuItem> menu, List<Client> clients, HashMap<Order, ArrayList<MenuItem>> order) {
        DeliveryService deliveryService = new DeliveryService();
        deliveryService.setMenu(menu);
        deliveryService.setClients(clients);
        deliveryService.setOrders(order);
        try{
            FileOutputStream fileOutput = new FileOutputStream("file.txt");
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOutput);
           // System.out.println(deliveryService.getMenu());
            outputStream.writeObject(deliveryService.getMenu());
            outputStream.writeObject(deliveryService.getOrders());
            outputStream.writeObject(deliveryService.getClients());

            fileOutput.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //deserialize the data from file.txt
    public void deserialize(DeliveryService deliveryService) {

        try {
            FileInputStream fileInput = new FileInputStream("file.txt");
            ObjectInputStream inputStream = new ObjectInputStream(fileInput);
            if(fileInput.available() != 0) {
                deliveryService.setMenu((List<MenuItem>) inputStream.readObject());
                deliveryService.setOrders((HashMap<Order, ArrayList<MenuItem>>) inputStream.readObject());
                deliveryService.setClients((List<Client>) inputStream.readObject());

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}