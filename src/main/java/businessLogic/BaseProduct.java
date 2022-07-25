package businessLogic;

import java.util.Objects;

public class BaseProduct extends MenuItem {
    String title;
    float rating;
    int calories;
    int protein;
    int fat;
    int sodium;
    double price;

    public BaseProduct(String title, float rating, int calories, int protein, int fat, int sodium, double price) {
        this.title = title;
        this.rating = rating;
        this.calories = calories;
        this.protein = protein;
        this.fat = fat;
        this.sodium = sodium;
        this.price = price;
    }

    @Override
    public double computePrice() {
        return price;
    }

    //getters and setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getProtein() {
        return protein;
    }

    public void setProtein(int protein) {
        this.protein = protein;
    }

    public int getFat() {
        return fat;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public int getSodium() {
        return sodium;
    }




    @Override
    public String toString() {
        String s = "";
        s+="Title: " + title + "\n";
        s+="Rating: " + rating + "\n";
        s+="Calories: " + calories + "\n";
        s+="Protein: " + protein + "\n";
        s+="Fat: " + fat + "\n";
        s+="Sodium: " + sodium + "\n";
        s+="Price: " + price + "\n";
        return s;
    }

    public void setSodium(int sodium) {
        this.sodium = sodium;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseProduct that = (BaseProduct) o;
        return Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

}
