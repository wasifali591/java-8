import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

class Product{
    int id;
    String name;
    float price;

    public Product(int id, String name, float price){
        super();

        this.id = id;
        this.name = name;
        this.price = price;
    }
}


public class LambdaExpressionComparator {
    public static void main(String[] args) {
        List<Product> list =new ArrayList<Product>();

        //adding product
        list.add(new Product(1, "c HP Laptop", 2500f));
        list.add(new Product(3,"b keyboard", 300f));
        list.add(new Product(2,"a dell mouse", 150f));

        //implementing lambda expression
        Collections.sort(list,(p1,p2) ->{
            return p1.name.compareTo(p2.name);
        });

        for(Product p : list){
            System.out.println(p.id + "-" + p.name + "-" + p.price);
        }

        //filter data
        Stream<Product> filterProduct = list.stream().filter(p -> p.price > 150);

        //using lambda to iterate through collection
        filterProduct.forEach(
            product -> System.out.println(product.name + "-" + product.price)
        );

    }
}
