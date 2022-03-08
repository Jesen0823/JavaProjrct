package zuoshensuanfa.bingchaji;

import zuoshensuanfa.graph_tu.Edge;
import zuoshensuanfa.graph_tu.GNode;
import zuoshensuanfa.graph_tu.Graph;

import java.util.*;

/**
 * 并查集K算法 使用范围：满足无向图
 * 集合查找和集合合并
 */
public class Kruskal {
    // Union-Find Set 并查集结构
    public static class UnionFind {
        private HashMap<GNode, GNode> fatherMap;
        private HashMap<GNode, Integer> rankMap;

        public UnionFind() {
            fatherMap = new HashMap<GNode, GNode>();
            rankMap = new HashMap<GNode, Integer>();
        }

        private GNode findFather(GNode n) {
            GNode father = fatherMap.get(n);
            if (father != n) {
                father = findFather(father);
            }
            fatherMap.put(n, father);
            return father;
        }

        public void makeSets(Collection<GNode> nodes) {
            fatherMap.clear();
            rankMap.clear();
            for (GNode node : nodes) {
                fatherMap.put(node, node);
                rankMap.put(node, 1);
            }
        }

        public boolean isSameSet(GNode a, GNode b) {
            return findFather(a) == findFather(b);
        }

        public void union(GNode a, GNode b) {
            if (a == null || b == null) {
                return;
            }
            GNode aFather = findFather(a);
            GNode bFather = findFather(b);
            if (aFather != bFather) {
                int aFrank = rankMap.get(aFather);
                int bFrank = rankMap.get(bFather);
                if (aFrank <= bFrank) {
                    fatherMap.put(aFather, bFather);
                    rankMap.put(bFather, aFrank + bFrank);
                } else {
                    fatherMap.put(bFather, aFather);
                    rankMap.put(aFather, aFrank + bFrank);
                }
            }
        }
    }

    public static class EdgeComparator implements Comparator<Edge> {

        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.weight - o2.weight;
        }

    }

    public static Set<Edge> kruskalMST(Graph graph) {
        UnionFind unionFind = new UnionFind();
        unionFind.makeSets(graph.nodes.values());
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new EdgeComparator());
        for (Edge edge : graph.edges) {
            priorityQueue.add(edge);
        }
        Set<Edge> result = new HashSet<>();
        while (!priorityQueue.isEmpty()) {
            Edge edge = priorityQueue.poll();
            if (!unionFind.isSameSet(edge.from, edge.to)) {
                result.add(edge);
                unionFind.union(edge.from, edge.to);
            }
        }
        return result;
    }
}
