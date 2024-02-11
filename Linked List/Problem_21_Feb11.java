public class Problem_21_Feb11 {

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

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode temp1 = list1;
        ListNode temp2 = list2;
        ListNode dummy = new ListNode();
        ListNode current = dummy;

        while (temp1 != null && temp2 != null) {
            if (temp1.val >= temp2.val) {
                current.next = temp2;
                temp2 = temp2.next;
            } else {
                current.next = temp1;
                temp1 = temp1.next;
            }
            current = current.next;
        }

        if (temp1 != null) {
            current.next = temp1;
        } else {
            current.next = temp2;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        list1.addNode(4);
        list1.addNode(2);
        list1.addNode(6);
        list1.addNode(3);

        LinkedList list2 = new LinkedList();
        list2.addNode(1);
        list2.addNode(9);
        list2.addNode(5);

        ListNode ans = mergeTwoLists(list1.head, list2.head);

        LinkedList result = new LinkedList();
        result.head = ans;
        result.displayList();
    }
}
