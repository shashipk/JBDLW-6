public class Main {

    public static void main(String[] args) {
        OddEven oddEven = new OddEven(1,50000);
        EvenPrinter evenPrinter = new EvenPrinter(oddEven);
        OddPrinter oddPrinter = new OddPrinter(oddEven);

        Thread t1 = new Thread(oddPrinter,"Thread-1");
        Thread t2 = new Thread(evenPrinter,"Thread-2");

        t1.start();
        t2.start();
    }
}


