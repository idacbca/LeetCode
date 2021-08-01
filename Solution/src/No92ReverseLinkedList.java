public class No92ReverseLinkedList {
    ListNode successor = null;

    private ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            successor = head.next;
            return head;
        }
        ListNode last = reverseN(head.next, n - 1);

        head.next.next = head;
        head.next = successor;
        return last;
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == 1) {
            return reverseN(head, right);
        }
        head.next = reverseBetween(head.next, left - 1, right - 1);
        return head;
    }

    public ListNode reverseBetween1(ListNode head, int left, int right) {
        if (left == 1) {
            if (right == 1) {
                successor = head.next;
                return head;
            }
            ListNode last = reverseBetween(head.next, 1, right - 1);
            head.next.next = head;
            head.next = successor;
            return last;
        }
        head.next = reverseBetween(head.next, left - 1, right - 1);
        return head;
    }
}
