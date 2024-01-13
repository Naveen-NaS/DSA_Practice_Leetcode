public class Problem_61_Jan13 {

    static class ListNode {
        int data;
        ListNode next;

        ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class LinkedList {
        ListNode head;

        void addNode(int data) {
            ListNode newNode = new ListNode(data);
            if (head == null) {
                head = newNode;
            } else {
                ListNode current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode;
            }
        }

        void displayList() {
            ListNode current = head;
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println();
        }
    }

    // Method asked in question
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null)
            return null;
        if (head.next == null)
            return head;
        ListNode node = head;
        int n = 0;
        while (node != null) {
            n++;
            node = node.next;
        }

        k = k % n;
        while (k != 0) {
            ListNode lastNode = head;
            ListNode secondLastNode = null;

            while (lastNode.next != null) {
                secondLastNode = lastNode;
                lastNode = lastNode.next;
            }

            secondLastNode.next = null;
            lastNode.next = head;
            head = lastNode;

            k--;
        }
        return head;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        for (int i = 1; i <= 5; i++) {
            list.addNode(i);
        }

        System.out.println("Original list:");
        list.displayList();

        list.head = rotateRight(list.head, 2);
        System.out.println("List after swapping first and last nodes:");
        list.displayList();
    }
}
