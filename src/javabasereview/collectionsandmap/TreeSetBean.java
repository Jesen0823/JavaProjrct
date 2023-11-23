package javabasereview.collectionsandmap;

import com.sun.istack.internal.NotNull;

import java.util.Objects;

/**
 * 用于演示TreeSet的自定义对象类
 * */
public class TreeSetBean implements Comparable<TreeSetBean>{
    private String name;
    private int time;

    public TreeSetBean(String name, int time) {
        this.name = name;
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreeSetBean that = (TreeSetBean) o;
        return time == that.time &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, time);
    }

    @Override
    public String toString() {
        return "\n TreeSetBean{" +
                "name='" + name + '\'' +
                ", time=" + time +
                '}';
    }

    @Override
    public int compareTo(@NotNull TreeSetBean o) {
        if (this.time > o.time){
            return 1;
        }else if (this.time < o.time){
            return -1;
        }else {
            return 0;
        }
    }
}
