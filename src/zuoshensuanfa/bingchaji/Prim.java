package zuoshensuanfa.bingchaji;

import zuoshensuanfa.graph_tu.Edge;
import zuoshensuanfa.graph_tu.GNode;
import zuoshensuanfa.graph_tu.Graph;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 并查集P算法 使用范围：满足无向图
 * 集合查找和集合合并
 */

public class Prim {
    public static class EdgeComparator implements Comparator<Edge> {

        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.weight - o2.weight;
        }

    }

    public static Set<Edge> primMST(Graph graph) {
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(
                new EdgeComparator());
        HashSet<GNode> set = new HashSet<>();
        Set<Edge> result = new HashSet<>();
        for (GNode node : graph.nodes.values()) {
            if (!set.contains(node)) {
                set.add(node);
                for (Edge edge : node.edges) {
                    priorityQueue.add(edge);
                }
                while (!priorityQueue.isEmpty()) {
                    Edge edge = priorityQueue.poll();
                    GNode toNode = edge.to;
                    if (!set.contains(toNode)) {
                        set.add(toNode);
                        result.add(edge);
                        for (Edge nextEdge : toNode.edges) {
                            priorityQueue.add(nextEdge);
                        }
                    }
                }
            }
        }
        return result;
    }
}
