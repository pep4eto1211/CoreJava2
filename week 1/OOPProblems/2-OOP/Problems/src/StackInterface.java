public interface StackInterface<E> {
    public void push(E objectToPush);
    public boolean pushUnique(E objectToPush);
    public E pop();
    public int length();
    public boolean isEmpty();
    public E elementAt(int index);
    public void clear();
    public boolean contains(E object);
}
