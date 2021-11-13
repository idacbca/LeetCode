public class No160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p = headA;
        ListNode q = headB;

        while (p != q) {
            if (p == null) {
                p = headB;
            } else {
                p = p.next;
            }

            if (q == null) {
                q = headA;
            } else {
                q = q.next;
            }
        }

        return p;
    }
}
