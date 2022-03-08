package zuoshensuanfa.graph_tu;

/**
 * 边
 * 有向边
 * */
public class Edge {

    // 权重
    public int weight;
    // 出点/起点
    public GNode from;
    // 入点/终点
    public GNode to;

    public Edge(int weight, GNode from, GNode to) {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }
}
