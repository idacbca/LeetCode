public class No82 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode centinel = new ListNode(0, head);
        ListNode cur = centinel;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int sameVal = cur.next.val;
                while (cur.next != null && cur.next.val == sameVal) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return centinel.next;
    }
}
