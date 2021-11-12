public class No19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode sentinel = new ListNode(-1);
        sentinel.next = head;

        ListNode x = findNthFromEnd(sentinel, n + 1);
        x.next = x.next.next;
        return sentinel.next;
    }

    private ListNode findNthFromEnd(ListNode head, int n) {
        ListNode p = head, q = head;

        for (int i = 0; i < n; i++) {
            p = p.next;
        }

        while (p != null) {
            p = p.next;
            q = q.next;
        }
        return q;
    }
}
