package suanfa;

/**
 * 反转链表
 */
public class ReverseLinkedList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        public boolean hasNext() {
            return (next != null);
        }
    }

    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        ListNode next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            //头指针为空或者只有头节点，无环
            return false;
        }
        ListNode slow, fast = head;
        slow = head.next;
        fast = head.next.next;
        while (true) {
            if (fast == null || fast.next == null) {
                //fast走到链表尾
                return false;
            } else if (fast.next == slow || fast == slow) {
                return true;
            } else {
                slow = slow.next;// slow每次走一步
                fast = fast.next.next;//fast每次走两步
            }
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        // 成环
        //node5.next = node3;

        ListNode h = head;
        while (h.hasNext()) {
            System.out.print(h.val + ",");
            h = h.next;
        }
        System.out.print(h.val + ",");

        System.out.println("\n-------------");


        ListNode hh = reverseList(head);
        while (hh.hasNext()) {
            System.out.print(hh.val + ",");
            hh = hh.next;
        }
        System.out.print(hh.val + ",");

        // 是否有环：
        boolean isCircle = hasCycle(head);
        System.out.println("\n is has Circle: " + isCircle);
    }


}
