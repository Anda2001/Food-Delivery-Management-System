package Presentation;


import BusinessLogic.BaseProduct;
import BusinessLogic.DeliveryService;
import DataAccess.Serializator;

import java.util.List;

public class Controller {
    //create delivery service
    private DeliveryService deliveryService = new DeliveryService();

    //vcreate serializator
    private Serializator serializator = new Serializator();

    //create a list of base products
    private List<BaseProduct> baseProducts = serializator.readProducts();



}
