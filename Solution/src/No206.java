public class No206 {
    private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode pre = null, cur = head, nex = head;
        while (cur != null) {
            nex = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nex;
        }
        return pre;
    }
}
