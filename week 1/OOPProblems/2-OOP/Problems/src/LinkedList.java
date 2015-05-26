public class LinkedList implements ILinkedList{
    private ListNode[] list = new ListNode[0];

    public LinkedList(){
    }

    @Override
    public void addFirst(int item){
        ListNode[] newList = new ListNode[list.length + 1];
        System.arraycopy(list, 0, newList, 1, list.length);
        if (list.length == 0){
            newList[0] = new ListNode(null, null, item);
        }
        else{
            newList[0] = new ListNode(null, list[0], item);
        }
        list = newList;
    }

    @Override
    public void addLast(int item){
        ListNode[] newList = new ListNode[list.length + 1];
        System.arraycopy(list, 0, newList, 0, list.length);
        if (list.length == 0){
            newList[0] = new ListNode(null, null, item);
        }
        else{
            newList[newList.length - 1] = new ListNode(list[newList.length - 2], null, item);
        }
        //System.out.println(newList[0].value);
        list = newList;
    }

    @Override
    public int elementAt(int index){
        return list[index].value;
    }

    @Override
    public void remove(int index){
        ListNode[] newList = new ListNode[list.length - 1];
        list[index] = null;
        int pointer = 0;
        for (int i = 0; i < list.length; i++){
            if (list[i] != null){
                newList[pointer] = list[i];
                pointer++;
            }
        }
        if (index == list.length - 1)
        {
            if (list.length > 1) {
                int newLastPosition = --index;
                if (list.length == 2){
                    newList[newLastPosition].previousNode = null;
                }
                else{
                    newList[newLastPosition].previousNode = newList[newLastPosition - 1];
                    newList[newLastPosition - 1].nextNode = newList[--index];
                }
                newList[newLastPosition].nextNode = null;
            }
        }
        else
        if (index == 0)
        {
            if (list.length > 1) {
                newList[0].previousNode = null;
                if (list.length == 2){
                    newList[0].nextNode = null;
                }
                else {
                    newList[0].nextNode = newList[1];
                    newList[1].previousNode = newList[0];
                }
            }
        }
        else {
            newList[index].previousNode = newList[index - 1];
            newList[index - 1].nextNode = newList[index];
            newList[index].nextNode = newList[index + 1];
            newList[index + 1].previousNode = newList[index];
        }
        list = newList;
    }

    @Override
    public int size(){
        return list.length;
    }

    @Override
    public int get(int index){
        return list[index].value;
    }

    @Override
    public int getTail(){
        return list[list.length-1].value;
    }

    @Override
    public int getHead(){
        return list[0].value;
    }

    @Override
    public void clear(){
        list = new ListNode[0];
    }

    @Override
    public boolean contains(int item) {
        for (int i = 0; i < list.length; i++){
            if (list[i].value == item){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        if (list.length == 0){
            return true;
        }
        else{
            return false;
        }
    }
}
