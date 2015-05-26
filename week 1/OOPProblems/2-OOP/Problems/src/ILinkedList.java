public interface ILinkedList {
    /*
     *Adds element at the beginning of the list
     */
    void addFirst(int item);
    /*
     *Adds element at the end of the list
     */
    void addLast(int item);
    /*
     *Returns the element at the specified index
     */
    int elementAt(int index);
    /*
     *Removes the element at the specified index
     */
    void remove(int index);
    int size();
    int get(int index);
    int getHead();
    int getTail();
    void clear();
    boolean isEmpty();
    boolean contains(int item);
}
