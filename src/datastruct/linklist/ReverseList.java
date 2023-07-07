package datastruct.linklist;

public class ReverseList {
    /**
     * 单链表反转 version1
     *
     * @param node 当前节点
     * @param pre  前一个节点
     * @return
     */
    public static SingleNode reverseV1(SingleNode node, SingleNode pre) {
        if (node == null) {
            return null;
        } else {
            // 反转后的头结点
            SingleNode headNode;
            // next为空，说明是尾节点
            if (node.next == null) {
                // 修改next引用
                node.next = pre;
                // 指定反转后的头节点
                headNode = node;
            } else {
                // 非尾节点，继续递归
                headNode = reverseV1(node.next, node);
                node.next = pre;
            }
            return headNode;
        }
    }

    /**
     * 单链表反转 version2
     *
     * @param node
     * @return
     */
    public static SingleNode reverseV2(SingleNode node) {
        if (node == null || node.next == null) {
            return node;
        } else {
            SingleNode headNode = reverseV2(node.next);
            node.next.next = node;
            node.next = null;
            return headNode;
        }
    }

    /**
     * 打印链表信息 * * @param node
     */
    public static void printLink(SingleNode node) {
        System.out.print(node.data);
        if (node.next != null) {
            System.out.print(" -> ");
            printLink(node.next);
        } else {
            System.out.println("\n -------------");
        }
    }

    public static void main(String[] args) {
        SingleNode<String> s1 = new SingleNode<>("AA");
        SingleNode<String> s2 = new SingleNode<>("BB");
        SingleNode<String> s3 = new SingleNode<>("CC");
        SingleNode<String> s4 = new SingleNode<>("DD");
        s1.next = s2;
        s2.next = s3;
        s3.next = s4;
        printLink(s1);
        //SingleNode<String> firstNode = reverseV2(s1);
        SingleNode<String> firstNode = reverseV1(s1,null);
        printLink(firstNode);
    }
}
