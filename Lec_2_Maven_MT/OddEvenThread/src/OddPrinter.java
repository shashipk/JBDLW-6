public class OddPrinter implements Runnable {
    OddEven oddEven;

    public OddPrinter(OddEven oddEven) {
        this.oddEven = oddEven;
    }

    @Override
    public void run() {
        try {
            oddEven.printOdd();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
