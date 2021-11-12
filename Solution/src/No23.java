import java.util.PriorityQueue;

public class No23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;

        ListNode centinel = new ListNode(-99999);
        ListNode ptr = centinel;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, (a, b) -> (a.val - b.val));
        for (ListNode list : lists) {
            if (list != null) {
                pq.add(list);
            }
        }

        while (pq.size() != 0) {
            ListNode node = pq.poll();
            ptr.next = node;
            if (node.next != null) {
                pq.add(node.next);
            }
            ptr = ptr.next;
        }

        return centinel.next;
    }
}
