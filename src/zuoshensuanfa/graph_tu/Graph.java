package zuoshensuanfa.graph_tu;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 图
 * */
public class Graph {
    // 点集
    public HashMap<Integer, GNode> nodes;
    // 边集
    public HashSet<Edge> edges;

    public Graph(){
        nodes = new HashMap<>();
        edges = new HashSet<>();
    }
}


