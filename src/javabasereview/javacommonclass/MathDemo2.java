package javabasereview.javacommonclass;

/**
 * Math类
 */
public class MathDemo2 {
    public static void main(String[] args) {
        System.out.println("求平方根：" + Math.sqrt(9));
        System.out.println("最大值：" + Math.max(20, 9));
        System.out.println("最小值：" + Math.min(20, 9));
        System.out.println("2的3次方：" + Math.pow(2, 3));
        System.out.println("四舍五入：" + Math.round(-15.678139));
        System.out.println("修正四舍五入：" + round(-15.678139, 3));

    }

    /**
     * 修正的四舍五入
     *
     * @param scale 小数位数保留
     */
    public static double round(double num, int scale) {
        return Math.round(num * Math.pow(10.0, scale)) / Math.pow(10.0, scale);
    }
}
