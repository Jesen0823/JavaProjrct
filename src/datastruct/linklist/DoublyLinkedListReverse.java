package datastruct.linklist;

public class DoublyLinkedListReverse {

    static class ListNode {
        int val;
        ListNode prev;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode reverse(ListNode head) {
        ListNode current = head;
        ListNode temp = null;

        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }

        if (temp != null) {
            head = temp.prev;
        }

        return head;
    }

    private static void printDoublyLink(ListNode head){
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " <-> ");
            current = current.next;
        }
        System.out.print("null\n");
    }

    public static void main(String[] args) {
        // 创建一个双端链表：1 <-> 2 <-> 3 <-> 4 <-> 5
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        head.next = node2;
        node2.prev = head;
        node2.next = node3;
        node3.prev = node2;
        node3.next = node4;
        node4.prev = node3;
        node4.next = node5;
        node5.prev = node4;

        System.out.println("原链表：");
        printDoublyLink(head);

        // 遍历并打印翻转后的双端链表：5 <-> 4 <-> 3 <-> 2 <-> 1
        DoublyLinkedListReverse reverser = new DoublyLinkedListReverse();
        ListNode reversedHead = reverser.reverse(head);
        System.out.println("翻转后：");
        printDoublyLink(reversedHead);
    }
}

