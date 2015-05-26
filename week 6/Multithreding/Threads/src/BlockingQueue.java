import sun.misc.Queue;

import java.util.ArrayDeque;

public class BlockingQueue<T> extends ArrayDeque<T> {
    public BlockingQueue() {
    }

    @Override
    public synchronized T poll(){
        while (this.isEmpty()){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return super.poll();
    }

    @Override
    public synchronized void push(T item){
        this.add(item);
        notifyAll();
    }
}
