package linkedLists;

/**
 * Created by pparth on 2/7/17.
 */
public class ReverseALinkedList {

    public static LinkedNode head;

    static class LinkedNode {
        int val;
        LinkedNode next;

        public LinkedNode(int val) {
            this.val = val;
            this.next = null;
        }

        public LinkedNode addNext(LinkedNode next) {
            this.next = next;
            return next;
        }
    }

    public static LinkedNode reverseList(LinkedNode head) {

        return null;
    }

    public static void main(String[] args) {
        head = new LinkedNode(1);
        LinkedNode next = head.addNext(new LinkedNode(2));
        next.addNext(new LinkedNode(3));
        LinkedNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }

        reverseList(head);

    }
}
