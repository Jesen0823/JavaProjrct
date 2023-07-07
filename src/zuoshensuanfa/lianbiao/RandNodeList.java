package zuoshensuanfa.lianbiao;

import zuoshensuanfa.lianbiao.bean.RandNode;

import java.util.HashMap;

/**
 * 复制含有随机指针节点的链表
 * 【题目】一种特殊的单链表节点类描述如下
 * =============================
 * class RandNode {
 * int value;
 * RandNode next;
 * RandNode rand;
 * RandNode(int val){
 * value = val;
 * }
 * }
 * ===========================
 * rand指针是单链表节点结构中新增的指针，rand可能指向链表中的任意一个节
 * 点，也可能指向null。给定一个由RandNode节点类型组成的无环单链表的头节点
 * head，请实现一个函数完成这个链表的复制，并返回复制的新链表的头节点。
 * 【要求】时间复杂度0（N），额外空间复杂度0（1）
 * <p>
 * <p>
 * 【分析】：
 * <p>
 * ↱➝➝➝⇲     ↷
 * ②➝⑧➝⑦➝⑥➝⑨➝⑤➝②
 * ⇱↽↽↽↲
 * <p>
 * 【方案1，借助哈希表：】
 * 先用哈希表Map存储每一个节点 key=旧节点，value= 复制的对应节点
 * 然后遍历原链表，给副本链表赋值rand指针
 * 最后返回副本链表
 * <p>
 * 【方案2，不用哈希表：】
 * 复制每一个节点cur，放置在cur.next处
 * <p>
 * ↱➝➝➝➝➝➝⇲            ↷
 * ②➝➋➝⑧➝➑➝⑦➝➐➝⑥➝➏➝⑨➝➒➝⑤➝➎➝②➝➋
 * ⇱↽↽↽↽↽↽↽↲
 * <p>
 * 接下来设置副本节点(图中实心)的rand节点
 * 设置完成后拆分出原链表，剩下的是新链表
 */
class RandNodeList {

    /**
     * 方法1：借助容器HashMap实现复制链表
     */
    public static RandNode copyRandNodeList1(RandNode head) {
        HashMap<RandNode, RandNode> map = new HashMap<RandNode, RandNode>();
        RandNode cur = head;
        while (cur != null) {
            map.put(cur, new RandNode(cur.value));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).rand = map.get(cur.rand);
            cur = cur.next;
        }
        return map.get(head);
    }

    /**
     * 第二种方法
     */
    public static RandNode copyRandNodeList2(RandNode head) {
        if (head == null) return null;
        RandNode cur = head;
        RandNode next = null;
        while (cur != null) {
            next = cur.next;
            // 当前节点复制，赋给自己的下一个
            cur.next = new RandNode(cur.value);
            // 复制的新节点的下一个，与之前下一个连接起来
            cur.next.next = next;
            cur = next;
        }

        // 回到头部
        cur = head;
        RandNode curCopy = null;
        while (cur != null) {
            // 旧的下一个节点
            next = cur.next.next;
            // 复制过来的节点
            curCopy = cur.next;
            // 当前节点如果有rand则给复制节点赋给同样的rand
            curCopy.rand = cur.rand != null ? cur.rand.next : null;
            cur = next;
        }
        RandNode res = head.next;
        cur = head;
        while (cur != null) {
            // 当前节点最初的下一个
            next = cur.next.next;
            // 当前节点的副本
            curCopy = cur.next;
            // 还原到最初
            cur.next = next;
            // 完善复制节点的链条
            curCopy.next = next != null ? next.next : null;
            cur = next;
        }
        // 返回复制节点形成的链的头节点
        return res;
    }

    public static void main(String[] args) {
        RandNode head = new RandNode(2);
        RandNode node2 = new RandNode(8);
        RandNode node3 = new RandNode(7);
        RandNode node4 = new RandNode(6);
        RandNode node5 = new RandNode(9);
        RandNode node6 = new RandNode(5);
        RandNode node7 = new RandNode(2);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        head.rand = node3;
        node4.rand = node2;
        node5.rand = node5;

        //RandNode newHead = copyRandNodeList1(head);
        RandNode newHead = copyRandNodeList2(head);
        do {
            System.out.print(newHead.value + ", ");
            newHead = newHead.next;
        } while (newHead != null);
    }
}
