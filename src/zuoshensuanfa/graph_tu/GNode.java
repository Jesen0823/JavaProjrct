package zuoshensuanfa.graph_tu;

import java.util.ArrayList;

/**
 * 点
 * */
public class GNode {
    public int value;
    // 入度，有多少个点从这个点进入，即有多少个点指向这个点
    public int in;
    // 出度，有多少个点从这个点出来，即这个点总共会指向几个点
    // 对于无向图，指向和指出相等，即 in == out
    public int out;
    // 点集：由该节点直接指向的点的集合
    public ArrayList<GNode> nexts;
    // 边集：由该节点指出的向量集合，向量描述了一种指向关系，边包含信息有起点终点和权重
    public ArrayList<Edge> edges;

    public GNode(int value){
        this.value = value;
        in = 0;
        out = 0;
        nexts = new ArrayList<>();
        edges = new ArrayList<>();
    }
}
