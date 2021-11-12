public class No876 {
    public ListNode middleNode(ListNode head) {
        ListNode p = head, q = head;
        while (p != null && p.next != null) {
            p = p.next.next;
            q = q.next;
        }
        return q;
    }
}
