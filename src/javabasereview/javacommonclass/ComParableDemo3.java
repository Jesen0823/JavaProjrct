package javabasereview.javacommonclass;

import javabasereview.javacommonclass.bean.Student;

import java.util.Arrays;

/**
 * 比较器的使用
 */
public class ComParableDemo3 {
    public static void main(String[] args) {
        Student students[] = {
                new Student("一张", 18, 82.5f),
                new Student("更好", 18, 90.0f),
                new Student("活跃", 17, 88.5f),
                new Student("沟通", 19, 78.0f)};
        Arrays.sort(students);
        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i]);
        }
    }
}
