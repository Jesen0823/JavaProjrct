package javabasereview.javacommonclass.bean;

import java.util.Comparator;

public class StudentComparator implements Comparator<Student2> {
    @Override
    public int compare(Student2 o1, Student2 o2) {
        if (o1.equals(o2)){
            return 0;
        }else if (o1.getAge() < o2.getAge()){
            return 1;
        }else {
            return -1;
        }
    }
}
