package design_patterns_2.action.cursor;
/**
 * 迭代器模式（Iterator Pattern）又称为游标（Cursor）模式，是行为型设计模式之一。
 * 统计我的工作日天数和休假时间
 * 工作日是电脑系统的列表存储的，假日是手写的数组存储
 * 用迭代器统一迭代
 *
 * SQLite的Cursor游标就是迭代器模式
 * */
public class MyCursorTest {

    public static void main(String[] args) {
        MyWorker worker = new MyWorker();
        check(worker.iterator());

        MyHoliday holiday = new MyHoliday();
        check(holiday.iterator());
    }

    private static void check(Iterator iterator){
        while (iterator.hasNext()){
            System.out.println(iterator.next().toString());
        }
    }
}
