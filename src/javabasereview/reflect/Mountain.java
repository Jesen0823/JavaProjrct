package javabasereview.reflect;

import java.io.Serializable;

public class Mountain implements MountainInterface, Serializable {
    private String name;
    private int altitude;

    public Mountain() {
        this.name = "";
        this.altitude = 0;
    }

    public Mountain(String name, int altitude) {
        this.name = name;
        this.altitude = altitude;
    }

    public String getName() {
        return name;
    }

    public int getAltitude() {
        return altitude;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAltitude(int altitude) {
        this.altitude = altitude;
    }

    @Override
    public String toString() {
        return "Mountain{" +
                "name='" + ((name.isEmpty()) ? "未知" : name) + '\'' +
                ", altitude=" + ((altitude == 0) ? "未知" : altitude) +
                '}';
    }

    @Override
    public void climb() {
        System.out.println("攀登地：" + LOCAL + ",海拔是否超过5000：" + IS_OVER_5000);
    }

    @Override
    public boolean isOver5000(String name, int altitude) throws Exception {
        System.out.println("主峰：" + name + ",海拔：" + altitude);
        return altitude >= 5000;
    }
}
