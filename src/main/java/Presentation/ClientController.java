package Presentation;

import businessLogic.Client;
import businessLogic.DeliveryService;
import businessLogic.MenuItem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ClientController {
    private ClientGUI userView;
    public DeliveryService deliveryService;
    private LogView logInView;
    private Client user;

    public void start(Client user, LogView logInView)
    {
        this.user = user;
        this.userView = new ClientGUI(logInView, user);
        userView.setVisible(true);
        this.logInView = logInView;

        deliveryService = new DeliveryService();

        userView.setTable(new ArrayList<>(deliveryService.getMenu()));

        initializeUserInterfaceButtons();
    }

    public void initializeUserInterfaceButtons() {
        userView.addCreateOrderActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                deliveryService.addOrder(userView.getSelectedRows(), user.getId());

            }
        });

        userView.addSearchActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<MenuItem> menuItems = deliveryService.searchProducts( userView.getTitle(),
                        userView.getRating(),
                        userView.getCalories(),
                        userView.getProteins(),
                        userView.getFats(),
                        userView.getSodium(),
                        userView.getPrice());

                userView.setTable(menuItems);


            }
        });

        userView.addShowInfoButtonActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String string = userView.getSelectedRow();
                System.out.println(string);
                String s= "";
                for(MenuItem menuItem1 : deliveryService.getMenu()) {
                    if(menuItem1.getTitle().equals(string)) {
                        s+= menuItem1.toString();
                    }
                }
                userView.setInfo(s);

            }
        });


    }
}
