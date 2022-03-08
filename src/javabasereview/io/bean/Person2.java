package javabasereview.io.bean;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Person2 implements Externalizable {
    private String name;
    private float weight;
    private int height;

    public Person2(String name, float weight, int height) {
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
        return "人物：\n" +
                "Person2{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", height=" + height +
                '}';
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(this.name);
        out.writeInt(this.height);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.name = (String) in.readObject();
        this.height = in.readInt();
    }
}
