public class No243 {
    private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public boolean isPalindrome(ListNode head) {
        ListNode pre, last, slow, fast, left, right;
        slow = fast = left = pre = head;
        /** move slow and fast pointers to the right position */
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) {
            pre = slow;
            slow = slow.next;
        }
        /** reverse last half of the list */
        right = reverse(slow);
        last = right;
        while (right != null) {
            if (left.val != right.val) {
                pre.next = reverse(last);
                return false;
            }
            left = left.next;
            right = right.next;
        }
        /** reverse back the last half of the list */
        pre.next = reverse(last);
        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre, cur, nex;
        pre = null;
        cur = nex = head;
        while (cur != null) {
            nex = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nex;
        }
        return pre;
    }
}
