package javabasereview.reflect;

public interface MountainInterface {
    public static final String LOCAL = "China";
    public static final boolean IS_OVER_5000 = false;

    /**
     * 攀登
     * */
    public void climb();

    /**
     * 海拔是否超过5000
     * */
    public boolean isOver5000(String name, int altitude) throws Exception;
}
