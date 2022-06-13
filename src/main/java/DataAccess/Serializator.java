package DataAccess;


import BusinessLogic.BaseProduct;
import BusinessLogic.MenuItem;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Serializator {

    //read the data from products.csv using streams
    public List<BaseProduct> readProducts() {
        //read the data from products.csv using streams
        //create a list of lines
        List<String[]> lines = null;

        //create a list of base products
        List<BaseProduct> baseProducts = new ArrayList<>();


        //try to read the file line by line in lines
        try {
            lines = Files.lines(Paths.get("products.csv"))
                    .filter(line -> !line.startsWith("Title"))
                    .map(line -> line.split(","))
                    .collect(Collectors.toList());
            baseProducts = lines.stream().map(a -> new BaseProduct(a[0], Integer.valueOf(a[2]), Integer.valueOf(a[3]), Integer.valueOf(a[4])
                    , Integer.valueOf(a[5]), Integer.valueOf(a[6]), Double.valueOf(a[1]))).collect(Collectors.toList());

            return null;


        } catch (IOException e) {
            e.printStackTrace();
        }

        //print lines
        lines.forEach(System.out::println);
        //print the list of base products
        System.out.println(baseProducts);
        return baseProducts;
    }

}

