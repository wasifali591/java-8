public class RunnableTest{
    public static void main(String[] args) {
        //anonymous Runnable
        Runnable r1 = new Runnable() {
            
            @Override
            public void run(){
                System.out.println("Hello World r1");
            }
        };

        //Lambda Runnable
        Runnable r2 = () -> System.out.println("Hello World r2");

        //run
        r1.run();
        r2.run();
    }
}