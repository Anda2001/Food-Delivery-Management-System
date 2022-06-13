package BusinessLogic;

import java.util.ArrayList;

public class CompositeProduct extends MenuItem{
    //create a list of menu items
    private ArrayList<MenuItem> menuItems = new ArrayList<MenuItem>();

    @Override
    public double computePrice() {
        return 0;
    }
}
