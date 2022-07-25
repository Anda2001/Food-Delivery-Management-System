import DataAccess.Serializator;
import Presentation.Controller;

public class App {
    public static void main(String[] args){

        //Serializator serializator = new Serializator();
        //serializator.readProducts();
        Controller controller = new Controller();
        //controller.printBaseProducts();

        controller.start();

    }
}
