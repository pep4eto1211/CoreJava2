import java.util.ArrayList;
import java.util.List;

public class StackImpl<E> implements StackInterface<E> {
    private List<E> stackList = new ArrayList<>();

    public StackImpl(){
    }

    @Override
    public void push(E objectToPush){
        stackList.add(objectToPush);
    }

    @Override
    public boolean pushUnique(E objectToPush){
        if (!stackList.contains(objectToPush)){
            stackList.add(objectToPush);
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public E pop(){
        E toReturn = stackList.get(stackList.size() - 1);
        stackList.remove(stackList.size() - 1);
        return toReturn;
    }

    @Override
    public int length(){
        return stackList.size();
    }

    @Override
    public boolean isEmpty(){
        return stackList.isEmpty();
    }

    @Override
    public E elementAt(int index){
        return stackList.get(index);
    }

    @Override
    public void clear(){
        stackList.clear();
    }

    @Override
    public boolean contains(E object){
        return stackList.contains(object);
    }
}
