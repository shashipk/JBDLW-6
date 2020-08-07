public class EvenPrinter implements Runnable {
    OddEven oddEven;

    public EvenPrinter(OddEven oddEven) {
        this.oddEven = oddEven;
    }

    @Override
    public void run() {
        try {
            oddEven.printEven();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
