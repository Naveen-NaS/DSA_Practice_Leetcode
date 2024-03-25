// Problem No : 234 "Palindrome Linked List"

/* Aim :- Given the head of a singly linked list, return true if it is a palindrome or false otherwise. */

public class Day_50 {
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

    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode temp = head;

        int len = 0;
        while (temp != null) {
            temp = temp.next;
            len++;
        }

        int[] arr = new int[len];
        temp = head;
        int i = 0;
        while (temp != null) {
            arr[i++] = temp.data;
            temp = temp.next;
        }

        i = 0;
        int j = len - 1;
        while (i <= j) {
            if (arr[i++] != arr[j--]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        for (int i = 1; i <= 5; i++) {
            list.addNode(i);
        }

        System.out.println(isPalindrome(list.head));
    }
}
