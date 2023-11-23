package javabasereview.javacommonclass.bean;

import com.sun.istack.internal.NotNull;

public class Student implements Comparable<Student> {
    private String name;
    private int age;
    private float score;

    public Student(String name, int age, float score) {
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
    public int compareTo(@NotNull Student o) {
        // 排序规则，先按成绩，再按年龄排序
        if (this.score > o.score){
            return -1;
        }else if (this.score < o.score){
            return 1;
        }else {
            if (this.age > o.age){
                return 1;
            }else if (this.age < o.age){
                return -1;
            }else {
                return 0;
            }
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }
}
