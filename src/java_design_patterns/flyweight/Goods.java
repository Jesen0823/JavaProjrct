package java_design_patterns.flyweight;

public class Goods implements IGood {
    private String inName;
    private int outVersion;

    Goods(String inName){
        this.inName = inName;
    }

    @Override
    public void showPrice(String version) {
        if (version.equals("0")){
            System.out.println("价格为 100¥");
        }else if (version.equals("1")){
            System.out.println("价格为 200¥");
        }
    }
}
