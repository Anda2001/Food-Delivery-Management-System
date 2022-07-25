package businessLogic;

import java.io.Serializable;

public abstract class MenuItem implements Serializable {
    //create method computePrice
    public abstract double computePrice();

    public abstract String getTitle();

    public abstract float getRating();
    public abstract int getCalories();
    public abstract int getProtein();
    public abstract int getFat();
    public abstract int getSodium();
    public abstract String toString();

    public abstract double getPrice();
}
