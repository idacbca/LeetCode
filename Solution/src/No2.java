public class No2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode centinel = new ListNode(-1);
        ListNode ptr = centinel;
        int carry = 0;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            ptr.next = new ListNode(sum % 10);
            carry = sum / 10;
            l1 = l1.next;
            l2 = l2.next;
            ptr = ptr.next;
        }
        while (l2 != null) {
            int sum = l2.val + carry;
            ptr.next = new ListNode(sum % 10);
            carry = sum / 10;
            l2 = l2.next;
            ptr = ptr.next;
        }
        while (l1 != null) {
            int sum = l1.val + carry;
            ptr.next = new ListNode(sum % 10);
            carry = sum / 10;
            l1 = l1.next;
            ptr = ptr.next;
        }
        if (carry != 0) {
            ptr.next = new ListNode(carry);
        }
        return centinel.next;
    }
}
