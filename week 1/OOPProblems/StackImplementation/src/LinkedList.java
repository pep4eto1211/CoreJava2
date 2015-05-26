public class LinkedList implements ILinkedList{
    ListNode[] list = new ListNode[0];

    public LinkedList(){
    }

    @Override
    public void addFirst(int item){
        ListNode[] newList = new ListNode[list.length + 1];
        System.arraycopy(list, 0, newList, 1, 0);
        if (list.length == 0){
            newList[0] = new ListNode(null, null, item);
        }
        else{
            newList[0] = new ListNode(null, list[0], item);
        }
        //System.out.println(newList[0].value);
        list = newList;
    }

    @Override
    public void addLast(int item){
        ListNode[] newList = new ListNode[list.length + 1];
        System.arraycopy(list, 0, newList, 0, 1);
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
        newList[index].previousNode = newList[index - 1];
        newList[index - 1].nextNode = newList[index];
        newList[index].nextNode = newList[index + 1];
        newList[index + 1].previousNode = newList[index];
        list = newList;
    }
}
