public class No2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode centinel = new ListNode(-1);
        ListNode ptr = centinel;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = l1 != null ? l1.val : 0;
            int y = l2 != null ? l2.val : 0;
            int sum = x + y + carry;
            ptr.next = new ListNode(sum % 10);
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            ptr = ptr.next;
        }
        if (carry != 0) {
            ptr.next = new ListNode(carry);
        }
        return centinel.next;
    }
}
