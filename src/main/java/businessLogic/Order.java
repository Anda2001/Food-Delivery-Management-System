package businessLogic;


import java.io.Serializable;
import java.time.LocalDateTime;


public class Order implements Serializable {
    int orderId;
    int clientId;
    LocalDateTime orderDate;
    double price;

    public Order(){}

    public Order(int orderId, int clientId, LocalDateTime orderDate, double price) {
        this.orderId = orderId;
        this.clientId = clientId;
        this.orderDate = orderDate;
        this.price = price;
    }

    //create method hashCode
    public int hashCode(){
        return orderId;
    }

    //getters and setters
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public int getHour() {
        return orderDate.getHour();
    }

    public int getOrderDay() {
        return orderDate.getDayOfMonth();
    }

    public int getOrderMonth() {
        return orderDate.getMonthValue();
    }

    public int getOrderYear() {
        return orderDate.getYear();
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


}
