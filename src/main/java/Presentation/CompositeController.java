package Presentation;

import businessLogic.CompositeProduct;
import businessLogic.DeliveryService;
import businessLogic.MenuItem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CompositeController {
    private CompGUI compositeView;
    public DeliveryService deliveryService;
    private LogView logInView;
    private AdministratorGUI administratorGUI;


    public void start(LogView logInView, AdministratorGUI administratorGUI) {

        this.logInView = logInView;
        this.administratorGUI=administratorGUI;
        this.compositeView = new CompGUI(administratorGUI);
        compositeView.setVisible(true);
        deliveryService = new DeliveryService();
        ArrayList<MenuItem> menuItems = new ArrayList<>();
        menuItems.addAll(deliveryService.getMenu());
        compositeView.setTable(menuItems);


        initializeUserInterfaceButtons();
    }

    public void initializeUserInterfaceButtons() {

        compositeView.addEditButtonActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<MenuItem> menuItems = new ArrayList<>();
                String[] rows = compositeView.getSelectedRows();
                int i=0;
                if(rows.length>0)
                    do {
                        for(MenuItem menuItem : deliveryService.getMenu()) {
                            if(rows[i].equals(menuItem.getTitle()))
                                menuItems.add(menuItem);
                        }
                        i++;
                    }while(i< rows.length);

                CompositeProduct compositeProduct = new CompositeProduct(compositeView.getTitle(), menuItems);

                deliveryService.addCompositeMenuItem(compositeView.getTitle(), menuItems);

            }
        });

    }
}
