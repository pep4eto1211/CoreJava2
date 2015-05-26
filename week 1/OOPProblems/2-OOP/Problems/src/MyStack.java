public class MyStack implements IMyStack{
    private LinkedList stackList = new LinkedList();

    @Override
    public void push(int objectToPush) {
        stackList.addFirst(objectToPush);
    }

    @Override
    public boolean pushUnique(int objectToPush) {
        if (stackList.contains(objectToPush)){
            return false;
        }
        else{
            stackList.addFirst(objectToPush);
            return true;
        }
    }

    @Override
    public int pop() {
        int toReturn = stackList.get(0);
        stackList.remove(0);
        return toReturn;
    }

    @Override
    public int length() {
        return stackList.size();
    }

    @Override
    public boolean isEmpty() {
        return stackList.isEmpty();
    }

    @Override
    public int elementAt(int index) {
       return stackList.elementAt(index);
    }

    @Override
    public void clear() {
        stackList.clear();
    }

    @Override
    public boolean contains(int object) {
        return stackList.contains(object);
    }
}
