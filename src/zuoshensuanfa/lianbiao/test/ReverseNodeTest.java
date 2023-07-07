package zuoshensuanfa.lianbiao.test;

import zuoshensuanfa.lianbiao.bean.Node;

public class ReverseNodeTest {

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        Node head = n1;
        while (head !=null){
            System.out.print(head.value+"->");
            head = head.next;
        }

        Node newHead = verseNodeList(n1);
        System.out.println("\n");
        while (newHead !=null){
            System.out.print(newHead.value+"->");
            newHead = newHead.next;
        }
    }

    public static Node verseNodeList(Node head){
        if (head == null || head.next == null) return head;
        Node tmp = head.next;
        Node newHead = verseNodeList(head.next);
        tmp.next =head;
        head.next = null;
        return newHead;
    }
}
