package juc.thread;

import jdk.nashorn.internal.objects.annotations.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class CompletableFutureNetMallDemo3 {

    static List<NetMall> list = Arrays.asList(
            new NetMall("jd"),
            new NetMall("pdd"),
            new NetMall("taobao"),
            new NetMall("douyinMall"),
            new NetMall("meituan"),
            new NetMall("tmall")
    );

    // 同步
    public static List<String> getPriceByStep(List<NetMall> list, String productName) {
        return list.stream()
                .map(netMall -> String.format(productName + " in %s price is %.2f", netMall.getMallName(), netMall.calcPrice(productName)))
                .collect(Collectors.toList());
    }

    // 异步
    public static List<String> getPriceByAsync(List<NetMall> list, String productName) {
        return list.stream()
                .map(netMall -> CompletableFuture.supplyAsync(() -> String.format(productName + " in %s price is %.2f", netMall.getMallName(), netMall.calcPrice(productName))))
                .collect(Collectors.toList())
                .stream().map(CompletableFuture::join)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        List<String> list1 = getPriceByStep(list, "book");
        for (String e : list1) {
            System.out.println(e);
        }
        long end = System.currentTimeMillis();
        System.out.println("normal costTime: "+(end-start));

        System.out.println("\t \n");

        long start2 = System.currentTimeMillis();
        List<String> list2 = getPriceByAsync(list, "book");
        for (String e : list2) {
            System.out.println(e);
        }
        long end2 = System.currentTimeMillis();
        System.out.println("async costTime: "+(end2-start2));
    }
}

class NetMall {

    private String mallName;

    public String getMallName() {
        return mallName;
    }

    public NetMall(String mallName) {
        this.mallName = mallName;
    }

    public double calcPrice(String name) {
        // 检索花费1秒
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return ThreadLocalRandom.current().nextDouble() * 2 + name.charAt(0);
    }

}
