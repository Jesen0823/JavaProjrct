package javabasereview.io.bean;

import java.io.Serializable;

public class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private float weight;
    private int height;

    public Person(String name, float weight, int height) {
        this.name = name;
        this.weight = weight;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public float getWeight() {
        return weight;
    }

    public int getHeight() {
        return height;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "人物信息：\n Person{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", height=" + height +
                '}';
    }
}
