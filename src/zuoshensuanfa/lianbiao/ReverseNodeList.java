package zuoshensuanfa.lianbiao;

import zuoshensuanfa.lianbiao.bean.Node;

/**
 * 单链表反转
 */

public class ReverseNodeList {

    public static Node reverseList(Node head) {
        if (head == null || head.next == null) return head;
        Node temp = head.next;
        Node newHead = reverseList(head.next);
        temp.next = head;
        head.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);

        head.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        Node first = head;
        System.out.print(first.value + "->");
        do {
            first = first.next;
            System.out.print(first.value + "->");
        } while (first.next != null);

       Node newHead =  reverseList(head);
        System.out.println("\n反转之后：");
        Node first2 = newHead;
        System.out.print(first2.value + "->");

        do {
            first2 = first2.next;
            if(first2.next != null) {
                System.out.print(first2.value + "->");
            }else{
                System.out.print(first2.value + "->null");
            }
        } while (first2.next != null);
    }
}
