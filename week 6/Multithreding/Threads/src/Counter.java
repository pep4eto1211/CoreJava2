public class Counter {
    public Counter() {
    }
    public int count = 0;
    public static boolean waitB = true;
    public synchronized void incrementA(){
        while (waitB == false) {
            try {
                this.wait();
            } catch (InterruptedException e) {
            }
        }
        this.count++;
        waitB = false;
        notifyAll();
    }

    public synchronized void incrementB(){
        while (waitB == true) {
            try {
                this.wait();
            } catch (InterruptedException e) {
            }
        }
        this.count++;
        waitB = true;
        notifyAll();
    }
}
