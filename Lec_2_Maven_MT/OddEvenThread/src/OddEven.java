public class OddEven {
    int var,max;

    public OddEven(int var, int max) {
        this.var = var;
        this.max = max;
    }

    public void printEven() throws InterruptedException {
        while(var<max){
            synchronized (this) {
                if (var % 2 == 0) {
                    System.out.println(Thread.currentThread().getName() + ":" + var);
                    var++;
                    this.notify();
                }else{
                    this.wait();
                }

            }
        }
    }

    public void printOdd() throws InterruptedException {
        while(var<max){
            synchronized (this) {

                if (var % 2 != 0) {
                    System.out.println(Thread.currentThread().getName() + ":" + var);
                    var++;
                    this.notify();
                }else {
                    this.wait();
                }
            }
        }
    }


}
