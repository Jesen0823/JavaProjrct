package zuoshensuanfa.graph_tu;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GraphTest {


    /**
     * matrix 所有的边
     * N * 3的矩阵
     * [ weight, from节点上的值， to节点上的值 ]
     */
    public static Graph createGraph(Integer[][] matrix) {
        Graph graph = new Graph();
        for (int i = 0; i < matrix.length; i++) {
            Integer from = matrix[i][0]; //第 i 行 0 列
            Integer to = matrix[i][1];
            Integer weight = matrix[i][2];
            if (!graph.nodes.containsKey(from)) {
                graph.nodes.put(from, new GNode(from));
            }
            if (!graph.nodes.containsKey(to)) {
                graph.nodes.put(to, new GNode(to));
            }

            GNode fromGNode = graph.nodes.get(from);
            GNode toGNode = graph.nodes.get(to);
            Edge newEdge = new Edge(weight, fromGNode, toGNode);
            fromGNode.nexts.add(toGNode);
            fromGNode.out++;
            toGNode.in++;
            fromGNode.edges.add(newEdge);
            graph.edges.add(newEdge);
        }
        return graph;
    }

    /***
     * 图的宽度优先遍历：
     * 1. 利用队列实现
     * 2. 从源节点开始依次按照宽度进队列，然后弹出
     * 3. 每弹出一个点，把该节点所有没进过队列的邻接点放入队列
     * 4. 直到队列空
     *
     * */
    public static void bfs(GNode node) {
        if (node == null) {
            return;
        }
        Queue<GNode> queue = new LinkedList<>();
        HashSet<GNode> set = new HashSet<>();
        queue.add(node);
        set.add(node);
        while (!queue.isEmpty()) {
            GNode cur = queue.poll();
            System.out.println(cur.value);
            for (GNode next : cur.nexts) {
                if (!set.contains(next)) {
                    set.add(next);
                    queue.add(next);
                }
            }
        }
    }

    /***
     * 广度优先遍历：
     * 1. 利用栈实现
     * 2. 从源节点开始把节点按照深度放入栈，然后弹出
     * 3. 每弹出一个点，把该节点下一个没有进过栈的邻接点放入栈
     * 4. 直到栈变空
     *
     * */
    public static void dfs(GNode node) {
        if (node == null) {
            return;
        }
        Stack<GNode> stack = new Stack<>();
        HashSet<GNode> set = new HashSet<>();
        stack.add(node);
        set.add(node);
        System.out.println(node.value);
        while (!stack.isEmpty()) {
            GNode cur = stack.pop();
            for (GNode next : cur.nexts) {
                if (!set.contains(next)) {
                    stack.push(cur);
                    stack.push(next);
                    set.add(next);
                    System.out.println(next.value);
                    break;
                }
            }
        }
    }
}