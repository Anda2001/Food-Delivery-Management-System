package BusinessLogic;


import java.time.LocalDateTime;


public class Order{
    int orderId;
    int clientId;
    LocalDateTime orderDate;

    public Order(){}

    public Order(int orderId, int clientId, LocalDateTime orderDate) {
        this.orderId = orderId;
        this.clientId = clientId;
        this.orderDate = orderDate;
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

}
