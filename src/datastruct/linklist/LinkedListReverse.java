package datastruct.linklist;

/**
 * 链表翻转
 */
public class LinkedListReverse {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode current = head;
        ListNode next = null;

        while (current != null) {
            // 暂存下一个节点
            next = current.next;
            // 翻转当前节点
            current.next = pre;
            // 给两个变量重新赋值
            pre = current;
            current = next;
        }

        return pre;
    }

    public static void main(String[] args) {
        // 创建一个链表：1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        LinkedListReverse reverser = new LinkedListReverse();
        ListNode reversedHead = reverser.reverse(head);

        // 遍历并打印翻转后的链表：5 -> 4 -> 3 -> 2 -> 1
        ListNode current = reversedHead;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.print("null");
    }

}
