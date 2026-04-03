import java.util.HashSet;

class LoopLengthHashing {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static int loopLength(Node head) {
        HashSet<Node> visited = new HashSet<>();
        Node curr = head;

        while (curr != null) {
            if (visited.contains(curr)) {
                return countLoopNodes(curr);
            }
            visited.add(curr);
            curr = curr.next;
        }
        return 0;
    }

    static int countLoopNodes(Node start) {
        Node temp = start;
        int count = 1;

        temp = temp.next;
        while (temp != start) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public static void main(String[] args) {

        Node head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(5);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;

        fifth.next = third;

        int length = loopLength(head);

        if (length > 0)
            System.out.println("Loop length: " + length);
        else
            System.out.println("No loop detected");
    }
}
