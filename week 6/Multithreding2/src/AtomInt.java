public class AtomInt {
    private int value;

    public AtomInt(int value) {
        this.value = value;
    }

    public synchronized void add(int value){
        this.value += value;
    }

    public int getValue() {
        return value;
    }

    public synchronized void substract(int value){
        this.value -= value;
    }

    public synchronized void set(int value){
        this.value = value;
    }

    public synchronized void multiply(int value){
        this.value *= value;
    }

    public synchronized void devide(int value){
        this.value /= value;
    }
}
