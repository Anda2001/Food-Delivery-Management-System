package Presentation;

import businessLogic.BaseProduct;
import businessLogic.DeliveryService;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BaseController {
    private BaseGUI baseView;
    public DeliveryService deliveryService;
    private LogView logInView;
    private AdministratorGUI administratorGUI;


    public void start(LogView logInView, boolean edit, BaseProduct baseProduct, AdministratorGUI administratorGUI) {

        this.logInView = logInView;
        this.baseView = new BaseGUI(edit, baseProduct, administratorGUI);
        this.administratorGUI=administratorGUI;
        baseView.setVisible(true);
        deliveryService = new DeliveryService();

        if(edit)
        {
            baseView.setTitle(baseProduct.getTitle());
            baseView.setCalories(String.valueOf(baseProduct.getCalories()));
            baseView.setRaiting(String.valueOf(baseProduct.getRating()));
            baseView.setSodium(String.valueOf(baseProduct.getSodium()));
            baseView.setFats(String.valueOf(baseProduct.getFat()));
            baseView.setProteins(String.valueOf(baseProduct.getProtein()));
            baseView.setPrice(String.valueOf(baseProduct.getPrice()));

        }

        initializeUserInterfaceButtons();
    }

    public void initializeUserInterfaceButtons() {
        baseView.addCreateButtonActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                deliveryService.addBaseMenuItem(baseView.getTitle(),
                        baseView.getRaiting(),
                        baseView.getCalories(),
                        baseView.getProteins(),
                        baseView.getFats(),
                        baseView.getSodium(),
                        baseView.getPrice());
            }
        });

        baseView.addEditButtonActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deliveryService.editMenuItem(baseView.getTitle(),
                        baseView.getRaiting(),
                        baseView.getCalories(),
                        baseView.getProteins(),
                        baseView.getFats(),
                        baseView.getSodium(),
                        baseView.getPrice());

            }
        });


    }
}
