public class No25 {
    private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    private ListNode reverseBetween(ListNode a, ListNode b) {
        ListNode pre = null, cur = a, nex = a;
        while (cur != b) {
            nex = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nex;
        }
        return pre;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode a, b;
        a = b = head;
        for (int i = 0; i < k; i ++) {
            /** Don't need reverse if the length of nodes < k */
            if (b == null) {
                return head;
            }
            b = b.next;
        }
        head = reverseBetween(a, b);
        b = reverseKGroup(b, k);
        a.next = b;
        return head;
    }
}
