package java_design_patterns.builder;

/**
 * 建造者模式：
 *
 * 使用建造者模式可以使客户端不必知道产品内部组成的细节。
 * 具体的建造者类之间是相互独立的，容易扩展。
 * 由于具体的建造者是独立的，因此可以对建造过程逐步细化，而不对
 * 其他的模块产生任何影响。
 * ·缺点：产生多余的Build对象以及Worker类。
 * */
public class TestBuilder {

    public static void main(String[] args) {
        AbsBuilder builder = new RealBuilder();
        Worker worker = new Worker(builder);

        Phone p = worker.createPhone(8, "高通骁龙", 6);
        System.out.println("成品："+p.toString());
    }
}
