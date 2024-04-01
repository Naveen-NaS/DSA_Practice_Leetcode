// Problem No : 2402 "Meeting Rooms III"

/* Aim :- You are given an integer n. There are n rooms numbered from 0 to n - 1.

    You are given a 2D integer array meetings where meetings[i] = [starti, endi] means that a meeting 
    will be held during the half-closed time interval [starti, endi). All the values of starti are unique.

    Meetings are allocated to rooms in the following manner:

    Each meeting will take place in the unused room with the lowest number.

    If there are no available rooms, the meeting will be delayed until a room becomes free. 
    The delayed meeting should have the same duration as the original meeting.
    When a room becomes unused, meetings that have an earlier original start time should be given the room.
    Return the number of the room that held the most meetings. 
    If there are multiple rooms, return the room with the lowest number.

    A half-closed interval [a, b) is the interval between a and b including a and not including b. 
*/

public class Day_17 {

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

    static ListNode reverseList(ListNode head) {
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
        System.out.println("List after swapping first and last nodes:");
        list.displayList();
    }
}
