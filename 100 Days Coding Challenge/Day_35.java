public class Day_35 {

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

    public static ListNode middleNode(ListNode head) {
        ListNode temp = head;
        int len = 0;
        while (temp != null) {
            temp = temp.next;
            len++;
        }

        temp = head;
        int i = 0;
        int limit = len / 2;
        while (i < limit) {
            temp = temp.next;
            i++;
        }

        return temp;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        for (int i = 1; i <= 6; i++) {
            list.addNode(i);
        }

        System.out.print("Original list: ");
        list.displayList();

        ListNode middle = middleNode(list.head);
        System.out.println("Middle Node : " + middle.data);
    }
}
