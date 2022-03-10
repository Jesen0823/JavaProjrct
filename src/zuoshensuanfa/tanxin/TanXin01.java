package zuoshensuanfa.tanxin;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 贪心算法
 *
 * 在某一个标准下，优先考虑最满足标准的样本，最后考虑最不满足标准的样本，最终得到
 * 一个答案的算法，叫作贪心算法。
 * 也就是说，不从整体最优上加以考虑，所做出的是在某种意义上的局部最优解。
 * 局部最优-？->整体最优
 *
 * 【案例】：
 * 一些项目要占用一个会议室宣讲，会议室不能同时容纳两个项目的宣讲。
 * 给你每一个项目开始的时间和结束的时间（给你一个数组，里面是一个个具体
 * 的项目），你来安排宣讲的日程，要求会议室进行的宣讲的场次最多。
 * 返回这个最多的宣讲场次。
 *
 *  应该优先安排结束时间早的会议
 * */
public class TanXin01 {

    public static class Program {
        public int start;
        public int end;

        public Program(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static class ProgramComparator implements Comparator<Program> {

        @Override
        public int compare(Program o1, Program o2) {
            return o1.end - o2.end;
        }

    }

    public static int bestArrange(Program[] programs, int start) {
        Arrays.sort(programs, new ProgramComparator());
        int result = 0;
        for (int i = 0; i < programs.length; i++) {
            if (start <= programs[i].start) {
                result++;
                start = programs[i].end;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Program[] allTest = {
                new Program(6,8),
                new Program(7,8),
                new Program(9,12),
                new Program(10,11),
                new Program(14,16),
                new Program(13,14),
                new Program(14,18),
                new Program(15,16),
                new Program(17,20),
                new Program(10,12),
                new Program(16,17)
        };
        int ret =bestArrange(allTest,10);
        System.out.println(ret);
    }

}
