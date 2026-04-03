public class delLinkList {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Delete last occurrence
    public static Node deleteLastOccurrence(Node head, int target) {
        if (head == null) return null;

        Node curr = head;
        Node prev = null;
        Node lastCurr = null;
        Node lastPrev = null;

        while (curr != null) {
            if (curr.data == target) {
                lastCurr = curr;
                lastPrev = prev;
            }
            prev = curr;
            curr = curr.next;
        }

        // If target not found
        if (lastCurr == null) return head;

        // If last occurrence is head
        if (lastPrev == null) {
            head = head.next;
        } else {
            lastPrev.next = lastCurr.next;
        }

        return head;
    }

    
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {

      
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(20);
        head.next.next.next.next = new Node(40);

        System.out.println("Original List:");
        printList(head);

        head = deleteLastOccurrence(head, 20);

        System.out.println("After deleting last occurrence of 20:");
        printList(head);
    }
}
