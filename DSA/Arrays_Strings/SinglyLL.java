class SinglyLL {

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;

    
    void insert(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
    }

    
    void rotate(int k) {

        if (head == null || head.next == null || k == 0)
            return;

        
        Node temp = head;
        int length = 1;

        while (temp.next != null) {
            temp = temp.next;
            length++;
        }

        temp.next = head;

        
        k = k % length;

        
        int stepsToNewHead = length - k;

        Node newTail = head;

        for (int i = 1; i < stepsToNewHead; i++) {
            newTail = newTail.next;
        }

       
        head = newTail.next;

        
        newTail.next = null;
    }

    
    void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {

        SinglyLL list = new SinglyLL();   

        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);

        System.out.print("Original List: ");
        list.display();

        list.rotate(2);

        System.out.print("After Rotating by 2: ");
        list.display();
    }
}
