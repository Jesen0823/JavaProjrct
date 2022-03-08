package zuoshensuanfa.lianbiao;

import zuoshensuanfa.lianbiao.bean.Node;

/**
 * 将单向链表按某值划分成左边小、中间相等、右边大的形式
 *
 * 【题目】给定一个单链表的头节点head，节点的值类型是整型，再给定一个整
 * 数pivot。实现一个调整链表的函数，将链表调整为左部分都是值小于pivot的
 * 节点，中间部分都是值等于pivot的节点，右部分都是值大于pivot的节点。
 *
 * 【进阶】在实现原问题功能的基础上增加如下的要求
 * 【要求】调整后所有小于pivot的节点之间的相对顺序和调整前一样
 * 【要求】调整后所有等于pivot的节点之间的相对顺序和调整前一样
 * 【要求】调整后所有大于pivot的节点之间的相对顺序和调整前一样
 * 【要求】时间复杂度请达到O（N），额外空间复杂度请达到O（1）。
 *
 *
 * 思路：
 * 方法1：先转化成数组，然后用快排
 *
 * 方法2：用有限几个变量:
 *  如 给定链表 ④->⑥->③->⑤->⑧->⑤->② ，给定pivot=5
 *
 *  定义6个变量：
 *  <区的头：sH = null
 *  <区的尾：sT = null
 *  =区的头：eH = null
 *  =区的尾：eT = null
 *  >区的头：bH = null
 *  >区的尾：bT = null
 *
 *   1) 先看第1个节点, ④ < 5, 则 sH=④ sT = ④
 *   2)看第2个，⑥ > 5, 则 bH = ⑥  bT = ⑥
 *   3) 看第3个，③ < 5, 则 ④->③, sH= ④ sT=③
 *   4)看第4个, eH = ⑤, eT = ⑤
 *   ...
 *   i)最后，得到：
 *       sH = ④ sT = ② 且 ④->③->②
 *       eH = ⑤ eT = ⑤ 且 ⑤->⑤
 *       bH = ⑥ bT = ⑧ 且 ⑥->⑧
 *   i+1) 三区相连：
 *       sT.next = eH
 *       eT.next = bH
 *
 *
 * */
public class NodeListToArry {

    /**
     * 第一种
     * */
    public static Node nodeListPartition1(Node head,int pivot){
        if (head == null){
            return null;
        }

        Node cur = head;
        int i = 0;
        while (cur!=null){
            i++;
            cur = cur.next;
        }

        Node[] nodeArr = new Node[i];
        i = 0;
        cur = head;
        for (i = 0; i!=nodeArr.length ; i++) {
            nodeArr[i] = cur;
            cur = cur.next;
        }

        arrPartition(nodeArr,pivot);
        for (i = 1; i != nodeArr.length; i++) {
            nodeArr[i - 1].next = nodeArr[i];
        }
        nodeArr[i - 1].next = null;
        return nodeArr[0];
    }

    private static void arrPartition(Node[] nodeArr, int pivot) {
        int small = -1;
        int big = nodeArr.length;
        int index = 0;
        while (index != big) {
            if (nodeArr[index].value < pivot) {
                swap(nodeArr, ++small, index++);
            } else if (nodeArr[index].value == pivot) {
                index++;
            } else {
                swap(nodeArr, --big, index);
            }
        }
    }

    public static void swap(Node[] nodeArr, int a, int b) {
        Node tmp = nodeArr[a];
        nodeArr[a] = nodeArr[b];
        nodeArr[b] = tmp;
    }

    /**
     * 第二种方法
     *
     * */
    public static Node listPartition2(Node head, int pivot) {
        Node sH = null; // small head
        Node sT = null; // small tail
        Node eH = null; // equal head
        Node eT = null; // equal tail
        Node bH = null; // big head
        Node bT = null; // big tail
        Node next = null; // save next node
        // every node distributed to three lists
        while (head != null) {
            next = head.next;
            head.next = null;
            if (head.value < pivot) {
                if (sH == null) {
                    sH = head;
                    sT = head;
                } else {
                    sT.next = head;
                    sT = head;
                }
            } else if (head.value == pivot) {
                if (eH == null) {
                    eH = head;
                    eT = head;
                } else {
                    eT.next = head;
                    eT = head;
                }
            } else {
                if (bH == null) {
                    bH = head;
                    bT = head;
                } else {
                    bT.next = head;
                    bT = head;
                }
            }
            head = next;
        }
        // small and equal reconnect
        if (sT != null) { // 如果有小于区存在
            sT.next = eH;
            eT = eT == null ? sT : eT;
        }
        // all reconnect
        if (eT != null) { // 如果有等于区
            eT.next = bH;
        }
        return sH != null ? sH : eH != null ? eH : bH;
    }

    public static void main(String[] args) {
        // ④->⑥->③->⑤->⑧->⑤->②
        Node head= new Node(4);
        head.next = new Node(6);
        head.next.next = new Node(3);
        head.next.next.next = new Node(5);
        head.next.next.next.next = new Node(8);
        head.next.next.next.next.next = new Node(5);
        head.next.next.next.next.next.next = new Node(2);

        //Node newHead = nodeListPartition1(head,5);
        Node newHead = listPartition2(head,5);

        do {
            System.out.print(newHead.value+"-> ");
            newHead = newHead.next;
        }while (newHead != null);
    }

}
