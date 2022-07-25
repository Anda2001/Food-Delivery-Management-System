package Presentation;

import businessLogic.BaseProduct;
import businessLogic.DeliveryService;
import businessLogic.MenuItem;
import businessLogic.Order;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class GenerateReportController {
    private AdministratorGUI adminView;
    private ReportGUI reportView;
    public DeliveryService deliveryService;

    public void start(AdministratorGUI adminView) {

        this.reportView = new ReportGUI(adminView);
        reportView.setVisible(true);
        deliveryService = new DeliveryService();
        this.adminView=adminView;

        initializeUserInterfaceButtons();
    }

    public void initializeUserInterfaceButtons() {
        reportView.generateReportButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String reportType = reportView.getReportType();
                if(reportType.equals("Report1")){
                    String startH = reportView.getStart(),endH = reportView.getEnd();
                    int sH,eH;
                    sH=Integer.parseInt(startH);
                    eH=Integer.parseInt(endH);
                    HashMap<Order, ArrayList<MenuItem>> orders = deliveryService.getOrders();
                   // deliveryService.getOrders().keySet().stream().forEach(System.out::println);
//                    for(Order order : orders.keySet() ){
//                        System.out.println(order.getOrderDate().getHour());
//                    }
                    //HashMap<Order, ArrayList<MenuItem>> os;
                           // os = orders.keySet().stream().filter(p -> p.getOrderDate().getHour()>sH && p.getOrderDate().getHour()<eH ).collect(Collectors.toList());
                    List<Order> list1 = orders.keySet().stream().toList()
                            .stream()
                            .filter(p -> p.getOrderDate().getHour()>=sH  && p.getOrderDate().getHour()<eH)
                            .collect(Collectors.toList());
                    File file = new File("raport1.txt");
                    System.out.println(list1);

                    try {
                        file.createNewFile();
                        FileWriter writer = new FileWriter(file);
                        writer.write("Raport 1\n");
                        //writer.write(orders.size());
                        writer.write("\n");
                        //System.out.println(list1);
                        for(Order o : list1) {
                            writer.write("Order id: ");
                            writer.write(String.valueOf(o.getOrderId()));
                            writer.write("   client id: ");
                            writer.write(String.valueOf(o.getClientId()));
                            writer.write("\n");
//                            for (MenuItem m : orders.get(o)) {
//                                writer.write(m.toString());
//                                writer.write("\n");
//                            }
                            //writer.write(list1.toString());
                            writer.flush();

                        }
                        writer.close();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
                else if( reportType.equals("Report2")){
                    int noTimes = Integer.parseInt(reportView.getTimes());
                    Map<Order, ArrayList<MenuItem>> orders = deliveryService.getOrders();
                    Map<String,Long> map = (Map<String, Long>) orders.entrySet().stream()
                            .map(p -> p.getValue())
                            .flatMap(Collection::stream).collect(Collectors.groupingBy(MenuItem::getTitle, Collectors.counting()));
                    AtomicReference<String> total = new AtomicReference<>("");
                    map.entrySet().stream()
                            .filter(p -> p.getValue()>=noTimes)
                            .forEach(stringLongEntry -> total.set(total + stringLongEntry.getKey() + "\n"));
                    File file = new File("raport2.txt");

                    try {
                        file.createNewFile();
                        FileWriter writer = new FileWriter(file);
                        writer.write(total.toString());
                        writer.flush();
                        writer.close();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
                else if( reportType.equals("Report3")){
                    int specNo = Integer.parseInt(reportView.getMinimTimes());
                    double amount = Double.parseDouble(reportView.getMinPrice());
                    HashMap<Order, ArrayList<MenuItem>> orders = deliveryService.getOrders();
                    List<Order> os = orders.keySet().stream().filter(order -> order.getPrice()>= amount).collect(Collectors.toList());

                    Map<Integer,Long> os2 = os.stream()
                            .collect(Collectors.groupingBy(Order::getClientId,Collectors.counting()));
                    AtomicReference<String> total = new AtomicReference<>("");

                    os2.entrySet().stream()
                            .filter(integerLongEntry -> integerLongEntry.getValue()>=specNo)
                            .forEach(stringLongEntry -> total.set(total + "Client id:" + stringLongEntry.getKey() + " Number of times: " + stringLongEntry.getValue()+"\n"));
                    File file = new File("raport3.txt");

                    try {
                        file.createNewFile();
                        FileWriter writer = new FileWriter(file);
                        writer.write(total.toString());
                        writer.flush();
                        writer.close();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
                else{
                    int year = Integer.parseInt(reportView.getYear());
                    int month = Integer.parseInt(reportView.getMonth());
                    int day = Integer.parseInt(reportView.getDay());
                    String date = reportView.getDate();
                    Map<String,Long> lista =  deliveryService.getOrders().entrySet().stream()
                            .filter(orderListEntry -> orderListEntry.getKey().getOrderDate().getYear() == year && orderListEntry.getKey().getOrderDate().getMonth().getValue() == month && orderListEntry.getKey().getOrderDate().getDayOfMonth() == day)
                            .map(p -> p.getValue())
                            .flatMap(Collection::stream)
                            .collect(Collectors.groupingBy(MenuItem::getTitle, Collectors.counting()));
                    System.out.println(lista);
                    AtomicReference<String> total = new AtomicReference<>("");

                    lista.entrySet().stream()
                            .forEach(stringLongEntry -> total.set(total +  stringLongEntry.getKey() + " Number of times: " + stringLongEntry.getValue()+"\n"));
                    File file = new File("raport4.txt");

                    try {
                        file.createNewFile();
                        FileWriter writer = new FileWriter(file);
                        writer.write(total.toString());
                        writer.flush();
                        writer.close();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
            }

        });

    }

}
