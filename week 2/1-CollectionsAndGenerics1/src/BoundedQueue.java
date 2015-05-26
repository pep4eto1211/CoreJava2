import jdk.nashorn.internal.runtime.Debug;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;

public class BoundedQueue<E> implements Queue<E> {
    Object[] internalArray;
    int currentCount = 0;

    public BoundedQueue(int size){
        internalArray = new Object[size];
    }

    @Override
    public int size() {
        return currentCount;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(E item){
        if (currentCount < internalArray.length  -1){
            internalArray[currentCount] = item;
            return true;
        }
        else{
            throw new IllegalArgumentException();
        }
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean offer(E item){
        if (currentCount < internalArray.length  -1){
            internalArray[currentCount] = item;
            currentCount++;
            System.out.println(internalArray[--currentCount]);
            return true;
        }
        else{
            for (int i = 0; i < currentCount - 2; i++) {
                internalArray[i] = internalArray[i + 1];
            }
            internalArray[currentCount - 1] = item;
            return false;
        }
    }

    @Override
    public E remove(){
        if (currentCount != 0) {
            Object objectToReturn = internalArray[0];
            for (int i = 0; i < currentCount - 2; i++) {
                internalArray[i] = internalArray[i + 1];
            }
            return (E) objectToReturn;
        }
        else{
            throw new NoSuchElementException();
        }
    }

    @Override
    public E poll(){
        if (currentCount != 0) {
            Object objectToReturn = internalArray[0];
            for (int i = 0; i < currentCount - 2; i++) {
                internalArray[i] = internalArray[i + 1];
            }
            return (E) objectToReturn;
        }
        else{
            return null;
        }
    }

    @Override
    public E element(){
        if (currentCount != 0) {
            return (E) internalArray[0];
        }
        else{
            throw new NoSuchElementException();
        }
    }

    @Override
    public E peek(){
        if (currentCount != 0) {
            return (E) internalArray[0];
        }
        else{
            return null;
        }
    }
}










































