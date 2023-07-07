package zuoshensuanfa.lianbiao;

import zuoshensuanfa.lianbiao.bean.Node;

/**
 * 有环链表的判断 形状如 ‘б’
 * <p>
 * 方案1： 准备一个数组或Set
 * 遍历链表，每遍历一次如果数在容器中不存在，则加入容器
 * 如果在容器中存在，则从容器清除
 * <p>
 * 方案2：快慢指针从头节点出发，如果快指针走到头了则没有环
 * 快慢指针相遇则有环
 * 相遇后，慢指针不动，快指针回到头部
 * 然后都各自每次走一步，再次相遇的点就是入环节点
 */
public class NodeListCycleCheck {


    /**
     * 判断一个链表是否有环，无环返回null,有环返回入环节点
     */
    public static Node getLoopNode(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }

        // 慢指针起点
        Node slow = head.next;
        // 快指针起点
        Node fast = head.next.next;

        // 循环直到相遇
        while (slow != fast) {
            if (fast.next == null || fast.next.next == null) {
                return null;
            }
            // 快指针走两步慢指针走一步
            fast = fast.next.next;
            slow = slow.next;
        }

        // 快指针回到头部 等待第二次相遇
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        // 再次相遇就是入环节点
        return fast;
    }

    /**
     * 给出两个链表
     * 判断如果两个链表都无环，如果相交返回第一个相交节点，如果不相交返回null
     * <p>
     * 【分析】
     * 先判断两个链表：
     * 1) 都没有环，先判断两个链表最后一个节点的内存地址，是否一致：
     * <p>
     * 1.1> 如果一致则相交，则形如 ‘Y’，求第一个相交点：
     * 假设长链表length = L ,短链表length = S
     * 则长链表先走(L-S)步，短链表跟着走，一定会在第一个相交点相遇
     * <p>
     * 1.2> 不一致则不相交,接下来不需要判断,形如‘||’
     * 2) 都有环，三种情况：
     * 2.1> 独立成环 ‘бб’
     * 2.2> 公用环入环节点一样 '>O'
     * 2.3> 公用环入环节点不同 '=O'
     */
    public static Node getIntersectNode(Node head1,Node head2){
        if (head1 == null|| head2==null){
            return null;
        }
        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head2);

        // 1) 都无环
        if (loop1 == null && loop2 == null){
            return findPointIn2Nodelist(head1,head2);
        }
        // 2) 都有环
        if (loop1!=null && loop2!=null){
            return bothCicleLoopTwoNodeList(head1,head2,loop1,loop2);
        }
        return null;
    }

    // 1) 无环列表相交问题
    public static Node findPointIn2Nodelist(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        Node cur1 = head1;
        Node cur2 = head2;
        int n = 0;
        // 遍历第一个链表，n是长度
        while (cur1.next != null) {
            n++;
            cur1 = cur1.next;
        }
        // 遍历第二个链表,n代表长度差值
        while (cur2.next != null) {
            n--;
            cur2 = cur2.next;
        }
        // 两个链表到尾部比较一下，不等就不相交
        if (cur1 != cur2) {
            return null;
        }

        // 长链表
        cur1 = n > 0 ? head1 : head2;
        // 短链表,即长链表选剩下的
        cur2 = cur1 == head1 ? head2 : head1;
        n = Math.abs(n);

        // 长先走n步
        while (n != 0) {
            n--;
            cur1 = cur1.next;
        }
        // 都单步走，等待相交
        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }

    // 2) 两个链表都是有环的，如果相交返回第一个相交点，如果不相交返回null
    public static Node bothCicleLoopTwoNodeList(Node head1, Node head2, Node loop1, Node loop2) {
        Node cur1 = null;
        Node cur2 = null;
        // 2.2> 公用环入环节点一样 '>-O'
        if (loop1 == loop2) {
            cur1 = head1;
            cur2 = head2;
            int n = 0;
            // 循环第一个 长度n
            while (cur1 != loop1) {
                n++;
                cur1 = cur1.next;
            }
            // 循环第二个 长度差n
            while (cur2 != loop2) {
                n--;
                cur2 = cur2.next;
            }
            // 较长的链表
            cur1 = n > 0 ? head1 : head2;
            // 较短的链表
            cur2 = cur1 == head1 ? head2 : head1;
            n = Math.abs(n);
            // 长的先走差值n
            while (n != 0) {
                n--;
                cur1 = cur1.next;
            }
            // 然后两个一起走
            while (cur1 != cur2) {
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        }else { // 2.1> 独立成环 ‘бб’
            cur1 = loop1.next;
            while (cur1 != loop1){
                if (cur1 == loop2){
                    return loop1;
                }
                cur1 = cur1.next;
            }
            return null;
        }
    }

    public static void main(String[] args) {
        //testOneNodeListIsCicle();
        testTwoNodeListIsX();
    }

    // 测试单个链表是否成环
    private static void testOneNodeListIsCicle() {
        Node head = new Node(5);
        Node node1 = new Node(7);
        Node node2 = new Node(2);
        Node node3 = new Node(0);
        Node node4 = new Node(8);
        Node node5 = new Node(9);
        Node node6 = new Node(3);
        Node node7 = new Node(10);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        // 成环
        node7.next = node5;
        // 5->7->2-0->8->9->3->10

        Node findNode = getLoopNode(head);
        System.out.println("入环节点： " + findNode.value);
    }

    // 无环相交测试
    private static void testTwoNodeListIsX() {
        Node head1 = new Node(3);
        Node node1 = new Node(6);
        Node node2 = new Node(0);
        Node node3 = new Node(9);
        Node node4 = new Node(12);
        Node head2 = new Node(4);
        Node node6 = new Node(6);
        Node node7 = new Node(8);
        Node node8 = new Node(2);
        /**
         * 3->6->0->9->
         *           /-> 12-> 2
         * 4->6->8->
         * */
        head1.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node8;

        head2.next = node6;
        node6.next = node7;
        node7.next = node4;
        node7.next.next = node8;

        Node point = getIntersectNode(head1, head2);
        System.out.print("两链表相交于：" + point.value);
    }
}
