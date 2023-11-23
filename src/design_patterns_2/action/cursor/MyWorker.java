package design_patterns_2.action.cursor;

import java.util.ArrayList;
import java.util.List;

public class MyWorker implements Worker{
    private List<Day> list = new ArrayList<>();

    public MyWorker(){
        list.add(new Day(1,10,true));
        list.add(new Day(1,11,true));
        list.add(new Day(1,12,true));
        list.add(new Day(1,13,true));
        list.add(new Day(1,17,true));
        list.add(new Day(1,18,true));
    }

    public List<Day> getDays(){
        return list;
    }

    @Override
    public Iterator iterator() {
        return new WorkDayIterator(list);
    }
}
