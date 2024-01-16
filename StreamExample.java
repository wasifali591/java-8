import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamExample {
    public static void main(String[] args) {
        List<Integer> myList = new ArrayList<>();

        for(int i = 0; i<20; i++){
            myList.add(i);
        }

        //sequential stream
        Stream<Integer> sequentialStream = myList.stream();

        //parallal stream
        Stream<Integer> parallaStream = myList.parallelStream();

        //using lambda with Stream API, filter
        Stream<Integer> highNumStream = parallaStream.filter(p -> p > 10);

        //using lambda in forEach
        highNumStream.forEach(p -> System.out.println("High Nums parallal: " + p));

        Stream<Integer> highNStreamSeq = sequentialStream.filter(p -> p > 10);
        highNStreamSeq.forEach(p -> System.out.println("High Nums Sequential: " + p));
    }
}
