/**
 * Created by peter on 3/28/15.
 */
public class ListNode {
    public ListNode previousNode;
    public ListNode nextNode;
    public int value;

    public ListNode(ListNode previous, ListNode next, int value){
        previousNode = previous;
        nextNode = next;
        this.value = value;
    }
}
