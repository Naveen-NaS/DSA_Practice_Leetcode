public class Problem_382_Jan15 {

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

    static class Solution {
        private ListNode head;

        public Solution(ListNode head) {
            this.head = head;
        }

        public int getRandom() {
            ListNode temp = head;
            int length = 0;
            while (temp != null) {
                temp = temp.next;
                length++;
            }

            int randomNum = (int) (Math.random() * length);

            ListNode randomNode = head;
            for (int i = 0; i < randomNum; i++) {
                randomNode = randomNode.next;
            }

            return randomNode.data;
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        for (int i = 1; i <= 5; i++) {
            list.addNode(i);
        }

        Solution obj = new Solution(list.head);

        System.out.println(obj.getRandom());
    }
}