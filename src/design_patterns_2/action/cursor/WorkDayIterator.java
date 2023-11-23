package design_patterns_2.action.cursor;

import java.util.List;

public class WorkDayIterator implements Iterator {
    private List<Day> list;
    private int position;

    public WorkDayIterator(List<Day> list){
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        return !(position>list.size()-1 || list.get(position)==null);
    }

    @Override
    public Object next() {
        Day d = list.get(position);
        position++;
        return d;
    }
}
