public class Day_40 {

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

    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;

        while (curr != null) {
            int sum = 0;
            ListNode temp = curr.next;
            while (temp != null) {
                sum += temp.data;
                if (sum == 0) {
                    curr.next = temp.next;
                }
                temp = temp.next;
            }
            curr = curr.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.addNode(1);
        list.addNode(2);
        list.addNode(3);
        list.addNode(-3);
        list.addNode(4);

        Day_40 solution = new Day_40();
        System.out.print("Original List : ");
        list.displayList();

        list.head = solution.removeZeroSumSublists(list.head);

        System.out.print("List after removing zero-sum sublists : ");
        list.displayList();
    }
}
