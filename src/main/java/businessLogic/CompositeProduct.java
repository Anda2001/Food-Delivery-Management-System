package businessLogic;

import java.util.ArrayList;
import java.util.Objects;

public class CompositeProduct extends MenuItem{
    //create a list of menu items
    private ArrayList<MenuItem> menuItems = new ArrayList<MenuItem>();
    private String title;


    public CompositeProduct(){}

    public CompositeProduct(String title, ArrayList<MenuItem> menuItems){
        this.title=title;
        this.menuItems=menuItems;
    }

    @Override
    public double computePrice() {
        //sum of all prices of menu items
        double sum = 0;
        for(MenuItem menuItem : menuItems)
            sum += menuItem.computePrice();
        return sum;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public float getRating() {
        //compute rating as the average between the other ratings
        float sum = 0;
        for(MenuItem menuItem : menuItems)
            sum += menuItem.getRating();
        return sum/menuItems.size();
    }

    @Override
    public int getCalories() {
        int sum = 0;
        for(MenuItem menuItem : menuItems)
            sum += menuItem.getCalories();
        return sum;
    }

    @Override
    public int getProtein() {
        int sum = 0;
        for(MenuItem menuItem : menuItems)
            sum += menuItem.getProtein();
        return sum;
    }

    @Override
    public int getFat() {
        int sum = 0;
        for(MenuItem menuItem : menuItems)
            sum += menuItem.getFat();
        return sum;
    }

    @Override
    public int getSodium() {
        int sum = 0;
        for(MenuItem menuItem : menuItems)
            sum += menuItem.getSodium();
        return sum;
    }

    @Override
    public String toString() {
        String s="";
        s+= "Title: " + title + "\n";
        s+= "Rating: " + getRating() + "\n";
        s+= "Calories: " + getCalories() + "\n";
        s+= "Protein: " + getProtein() + "\n";
        s+= "Fat: " + getFat() + "\n";
        s+= "Sodium: " + getSodium() + "\n";
        s+= "Price: " + computePrice() + "\n";
        for(MenuItem mi : menuItems){
            s+= "   " + mi.getTitle() + "\n";
        }
        return s;
    }

    @Override
    public double getPrice() {
        return computePrice();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompositeProduct that = (CompositeProduct) o;
        return Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

    public ArrayList<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(ArrayList<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }
}
