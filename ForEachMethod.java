import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class ForEachMethod{
    public static void main(String[] args) {
        //sample collection
        List<Integer> myList = new ArrayList<>();

        for(int i = 0; i < 10; i++){
            myList.add(i);
        }

        //traversing using iterator
        Iterator<Integer> iterator = myList.iterator();

        while(iterator.hasNext()){
            System.out.println("Iterator value: " + iterator.next());
        }

        //traversing through forEach method of Iterable with anonymous class 
        myList.forEach(new Consumer<Integer>() {
            public void accept(Integer t){
                System.out.println("forEach anonymous class value: " + t);
            }
        });

        //traversing with consumer interface implementation
        MyConsumer action = new MyConsumer();
        myList.forEach(action);
    }
}

//Consumer implementation that can be reused 
class MyConsumer implements Consumer<Integer>{
    public void accept(Integer t){
        System.out.println("Consumer impl value: " + t);
    }
}