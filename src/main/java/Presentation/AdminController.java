package Presentation;

import businessLogic.DeliveryService;
import businessLogic.BaseProduct;
import businessLogic.MenuItem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AdminController {

    private AdministratorGUI adminView;
    public DeliveryService deliveryService;
    private LogView logInView;

    public void start(LogView logInView) {

        this.logInView = logInView;
        this.adminView = new AdministratorGUI(logInView);
        adminView.setVisible(true);
        deliveryService = new DeliveryService();
        adminView.setTable(new ArrayList<>(deliveryService.getMenu()));

        initializeUserInterfaceButtons();
    }

    private void initializeUserInterfaceButtons() {

        adminView.addDeleteActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String s = adminView.getSelectedRow();
                deliveryService.deleteMenuItem(s);

            }
        });

        adminView.addCreateBaseActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BaseController baseController = new BaseController();
                baseController.start(logInView, false, null, adminView);
                adminView.setVisible(false);
            }
        });

        adminView.addCreateCompActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CompositeController compositeController = new CompositeController();
                compositeController.start(logInView,adminView);
                adminView.setVisible(false);
            }
        });
        adminView.addEditActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                    String title = adminView.getSelectedRow();
                    BaseProduct baseProduct=null;
                    for(MenuItem menuItem : deliveryService.getMenu()) {
                        if ((menuItem instanceof BaseProduct) && menuItem.getTitle().equals(title))
                            baseProduct = (BaseProduct) menuItem;
                    }

                    BaseController baseController = new BaseController();
                    baseController.start(logInView, true, baseProduct,adminView);

            }
        });

        adminView.setGenerateReportButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GenerateReportController reportController = new GenerateReportController();
                reportController.start(adminView);
            }
        });

        adminView.setRefreshButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deliveryService.deserialize();
                adminView.setTable(new ArrayList<>(deliveryService.getMenu()));
            }
        });


    }


}
