package javabasereview.javacommonclass;

import javabasereview.javacommonclass.bean.Student;
import javabasereview.javacommonclass.bean.Student2;
import javabasereview.javacommonclass.bean.StudentComparator;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 补救比较器
 * */
public class ComparatorDemo4 {
    public static void main(String[] args) {
        Student2 students2[] = {
                new Student2("一张", 18, 82.5f),
                new Student2("更好", 18, 90.0f),
                new Student2("活跃", 17, 88.5f),
                new Student2("沟通", 19, 78.0f)};
        Arrays.sort(students2,new StudentComparator());
        for (int i = 0; i < students2.length; i++) {
            System.out.println(students2[i]);
        }
    }


}


