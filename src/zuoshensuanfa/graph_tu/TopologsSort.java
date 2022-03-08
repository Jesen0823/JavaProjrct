package zuoshensuanfa.graph_tu;

import java.util.*;

/**
 * 图的拓扑排序
 *
 * */
public class TopologsSort {

    // directed graph and no loop
    public static List<GNode> sortedTopology(Graph graph) {
        // key:某一个node
        // value：剩余的入度
        HashMap<GNode, Integer> inMap = new HashMap<>();
        //入度为0的点，才能进这个队列
        Queue<GNode> zeroInQueue = new LinkedList<>();
        for (GNode node : graph.nodes.values()) {
            inMap.put(node, node.in);
            if (node.in == 0) {
                zeroInQueue.add(node);
            }
        }
        //拓扑排序的结果，依次加入result
        List<GNode> result = new ArrayList<>();
        while (!zeroInQueue.isEmpty()) {
            GNode cur = zeroInQueue.poll();
            result.add(cur);
            for (GNode next : cur.nexts) {
                inMap.put(next, inMap.get(next) - 1);
                if (inMap.get(next) == 0) {
                    zeroInQueue.add(next);
                }
            }
        }
        return result;
    }
}
