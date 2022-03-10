package zuoshensuanfa.bingchaji;

import zuoshensuanfa.graph_tu.Edge;
import zuoshensuanfa.graph_tu.GNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

/**
 * 迪杰斯特拉 算法
 * 适用：边的权值不允许是负数
 *
 * */
public class Dijkstra {

    public static HashMap<GNode, Integer> dijkstra1(GNode head) {
        HashMap<GNode, Integer> distanceMap = new HashMap<>();
        distanceMap.put(head, 0);
        HashSet<GNode> selectedNodes = new HashSet<>();

        GNode minNode = getMinDistanceAndUnselectedNode(distanceMap, selectedNodes);
        while (minNode != null) {
            int distance = distanceMap.get(minNode);
            for (Edge edge : minNode.edges) {
                GNode toNode = edge.to;
                if (!distanceMap.containsKey(toNode)) {
                    distanceMap.put(toNode, distance + edge.weight);
                }
                distanceMap.put(edge.to, Math.min(distanceMap.get(toNode), distance + edge.weight));
            }
            selectedNodes.add(minNode);
            minNode = getMinDistanceAndUnselectedNode(distanceMap, selectedNodes);
        }
        return distanceMap;
    }

    public static GNode getMinDistanceAndUnselectedNode(HashMap<GNode, Integer> distanceMap,
                                                       HashSet<GNode> touchedNodes) {
        GNode minNode = null;
        int minDistance = Integer.MAX_VALUE;
        for (Entry<GNode, Integer> entry : distanceMap.entrySet()) {
            GNode node = entry.getKey();
            int distance = entry.getValue();
            if (!touchedNodes.contains(node) && distance < minDistance) {
                minNode = node;
                minDistance = distance;
            }
        }
        return minNode;
    }

    public static class NodeRecord {
        public GNode node;
        public int distance;

        public NodeRecord(GNode node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    public static class NodeHeap {
        private GNode[] nodes;
        private HashMap<GNode, Integer> heapIndexMap;
        private HashMap<GNode, Integer> distanceMap;
        private int size;

        public NodeHeap(int size) {
            nodes = new GNode[size];
            heapIndexMap = new HashMap<>();
            distanceMap = new HashMap<>();
            this.size = 0;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public void addOrUpdateOrIgnore(GNode node, int distance) {
            if (inHeap(node)) {
                distanceMap.put(node, Math.min(distanceMap.get(node), distance));
                insertHeapify(node, heapIndexMap.get(node));
            }
            if (!isEntered(node)) {
                nodes[size] = node;
                heapIndexMap.put(node, size);
                distanceMap.put(node, distance);
                insertHeapify(node, size++);
            }
        }

        public NodeRecord pop() {
            NodeRecord nodeRecord = new NodeRecord(nodes[0], distanceMap.get(nodes[0]));
            swap(0, size - 1);
            heapIndexMap.put(nodes[size - 1], -1);
            distanceMap.remove(nodes[size - 1]);
            nodes[size - 1] = null;
            heapify(0, --size);
            return nodeRecord;
        }

        private void insertHeapify(GNode node, int index) {
            while (distanceMap.get(nodes[index]) < distanceMap.get(nodes[(index - 1) / 2])) {
                swap(index, (index - 1) / 2);
                index = (index - 1) / 2;
            }
        }

        private void heapify(int index, int size) {
            int left = index * 2 + 1;
            while (left < size) {
                int smallest = left + 1 < size && distanceMap.get(nodes[left + 1]) < distanceMap.get(nodes[left])
                        ? left + 1 : left;
                smallest = distanceMap.get(nodes[smallest]) < distanceMap.get(nodes[index]) ? smallest : index;
                if (smallest == index) {
                    break;
                }
                swap(smallest, index);
                index = smallest;
                left = index * 2 + 1;
            }
        }

        private boolean isEntered(GNode node) {
            return heapIndexMap.containsKey(node);
        }

        private boolean inHeap(GNode node) {
            return isEntered(node) && heapIndexMap.get(node) != -1;
        }

        private void swap(int index1, int index2) {
            heapIndexMap.put(nodes[index1], index2);
            heapIndexMap.put(nodes[index2], index1);
            GNode tmp = nodes[index1];
            nodes[index1] = nodes[index2];
            nodes[index2] = tmp;
        }
    }

    /**
     * 方法2：自定义小根堆实现
     * 从head出发 所有能到达的节点生成，每个到达节点的最小路径
     *
     * */
    public static HashMap<GNode, Integer> dijkstra2(GNode head, int size) {
        NodeHeap nodeHeap = new NodeHeap(size);
        nodeHeap.addOrUpdateOrIgnore(head, 0);
        HashMap<GNode, Integer> result = new HashMap<>();
        while (!nodeHeap.isEmpty()) {
            NodeRecord record = nodeHeap.pop();
            GNode cur = record.node;
            int distance = record.distance;
            for (Edge edge : cur.edges) {
                nodeHeap.addOrUpdateOrIgnore(edge.to, edge.weight + distance);
            }
            result.put(cur, distance);
        }
        return result;
    }
}
