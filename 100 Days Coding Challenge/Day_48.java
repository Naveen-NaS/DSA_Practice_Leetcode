public class Day_48 {

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

    public static ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode aPrev = list1;
        int i = 0;
        while (i < a - 1) {
            aPrev = aPrev.next;
            i++;
        }
        ListNode bNext = list1;
        int j = 0;
        while (j <= b) {
            bNext = bNext.next;
            j++;
        }

        ListNode temp = list2;
        while (temp.next != null) {
            temp = temp.next;
        }

        aPrev.next = list2;
        temp.next = bNext;

        return list1;
    }

    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();

        for (int i = 1; i <= 5; i++) {
            list1.addNode(i);
            list2.addNode(2 * i);
        }

        System.out.println("First list:");
        list1.displayList();

        System.out.println("Second list:");
        list2.displayList();

        list1.head = mergeInBetween(list1.head, 1, 3, list2.head);
        System.out.println("List after Merging : ");
        list1.displayList();
    }
}
