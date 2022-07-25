package Presentation;


import businessLogic.Client;
import businessLogic.DeliveryService;
import DataAccess.Serializator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    //create delivery service

    private LogView logInView= new LogView();
    private Client client;
    private AdministratorGUI adminGUI;
    private EmployeeGUI employeeGUI;
    private ClientGUI clientGUI;


    //vcreate serializator
    private Serializator serializator = new Serializator();

   // private List<BaseProduct> baseProducts = serializator.readProducts();

    public Controller() {
    }


    //print the list of base products
   /* public void printBaseProducts() {
        for (BaseProduct baseProduct : baseProducts) {
            System.out.println(baseProduct.getTitle() + " " + baseProduct.getRating() + " " + baseProduct.getCalories() + " " + baseProduct.getProtein() + " " + baseProduct.getFat() + " " + baseProduct.getSodium() + " " + baseProduct.getPrice());
        }
    }*/

    public void start()
    {
        logInView = new LogView();

        initializeUserInterfaceButtons();
        logInView.setVisible(true);

    }
    //implement action listeners for log in view
    public void initializeUserInterfaceButtons()
    {
        logInView.addRegisterButtonActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String role = logInView.getRole();
                String username = logInView.getUsername();
                String password = logInView.getPassword();

                DeliveryService deliveryService = new DeliveryService();
                if(role.equals("Administrator")||role.equals("Employee")){
                    System.out.println("False");
                    JOptionPane.showMessageDialog(null, "Can't register as "+role+"!");
                }
                else if(role.equals("Client") && deliveryService.register(username, password)){
                    System.out.println("True");
                    //print client's credentials
                    JOptionPane.showMessageDialog(null, "You have successfully registered as "+role+"!");
                }
                else{
                    JOptionPane.showMessageDialog(null, "Invalid data!");
                }
            }
        });

        logInView.addLogInButtonActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String username = logInView.getUsername();
                String password = logInView.getPassword();
                String role =logInView.getRole();

                DeliveryService deliveryService = new DeliveryService();
                if(role.equals("Administrator")){
                    if(username.equals("admin")&&password.equals("admin")){
                        logInView.setVisible(false);
                        //adminGUI = new AdministratorGUI(logInView);
                        //adminGUI.setVisible(true);
                        AdminController adminController = new AdminController();
                        adminController.start( logInView);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Invalid username or password!");
                    }
                }
                else if(role.equals("Employee")){
                    if(username.equals("employee")&&password.equals("employee")){
                        logInView.setVisible(false);
                       employeeGUI = new EmployeeGUI(logInView);
                        employeeGUI.setVisible(true);

                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Invalid username or password!");
                    }
                }
                else if(role.equals("Client") && deliveryService.logIn(username, password) != null) {
                    client = deliveryService.logIn(username, password);
                    System.out.println(client.getId() + client.getUsername());
                    System.out.println("true");
                    logInView.setVisible(false);

                    ClientController clientController = new ClientController();
                    clientController.start(client, logInView);

                }
                else
                {
                    System.out.println("Invalid username or password!");
                    JOptionPane.showMessageDialog(null, "Invalid username or password!");
                }

            }
        });


    }
}
