public class Day_31 {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        ListNode tail = null;
        int size = 0;

        while (temp != null) {
            tail = temp;
            temp = temp.next;
            size++;
        }

        int index = size - n;

        if (index < 0 || index >= size) {
            return head;
        }

        if (index == 0) {
            head = head.next;

            if (head == null) {
                tail = null;
            }
        } else {
            ListNode current = head;

            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }

            current.next = current.next.next;

            if (current.next == null) {
                tail = current;
            }
        }

        return head;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int data) {
            this.val = data;
            this.next = null;
        }

        ListNode() {
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
                System.out.print(current.val + " ");
                current = current.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addNode(4);
        list.addNode(2);
        list.addNode(6);
        list.addNode(3);
        list.addNode(1);
        list.addNode(9);
        list.addNode(5);

        System.out.println("Before Removal : ");
        list.displayList();

        removeNthFromEnd(list.head, 2);

        System.out.println("After Removal : ");
        list.displayList();

    }
}
