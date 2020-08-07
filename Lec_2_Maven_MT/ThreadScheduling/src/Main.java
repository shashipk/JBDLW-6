public class Main {

    public static void main(String[] args) throws InterruptedException {
        Runnable counter = () -> {
            int count = 1;
            while (count < 10) {
                System.out.println(count);
                count++;
                if(count==6)
                    Thread.yield();
            }
        };

        Runnable messageWriter = () -> {
            System.out.println("Happy Coding");
        };

        Thread t1 = new Thread(messageWriter);
        t1.setPriority(Thread.MIN_PRIORITY);

        Thread t2 = new Thread(counter);
        t2.setPriority(Thread.MAX_PRIORITY);

        t2.start();
        t1.start();
    }
}
