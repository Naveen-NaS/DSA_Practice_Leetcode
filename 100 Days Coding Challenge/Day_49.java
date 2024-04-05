// Problem No : 206 "Reverse Linked List"

/* Aim :- Given the head of a singly linked list, reverse the list, and return the reversed list. */

public class Day_49 {

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

    public static ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode prev = null;

        while (current != null) {
            ListNode nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        return prev;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        for (int i = 1; i <= 6; i++) {
            list.addNode(i);
        }

        System.out.println("Original list:");
        list.displayList();

        list.head = reverseList(list.head);
        System.out.println("List after reversing : ");
        list.displayList();
    }
}
