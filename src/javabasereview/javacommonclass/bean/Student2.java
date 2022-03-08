package javabasereview.javacommonclass.bean;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class Student2 {
    private String name;
    private int age;
    private float score;

    public Student2(String name, int age, float score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public float getScore() {
        return score;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setScore(float score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student2 student2 = (Student2) o;
        return age == student2.age &&
                Float.compare(student2.score, score) == 0 &&
                name.equals(student2.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, score);
    }
}
