public interface IMyStack {
    public void push(int objectToPush);
    public boolean pushUnique(int objectToPush);
    public int pop();
    public int length();
    public boolean isEmpty();
    public int elementAt(int index);
    public void clear();
    public boolean contains(int object);
}
