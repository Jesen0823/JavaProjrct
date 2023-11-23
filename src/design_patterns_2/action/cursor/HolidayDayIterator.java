package design_patterns_2.action.cursor;

public class HolidayDayIterator implements Iterator {
    private Day[] array;
    private int position;

    public HolidayDayIterator(Day[] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        return !(position > array.length - 1 || array[position] == null);
    }

    @Override
    public Object next() {
        Day d = array[position];
        position++;
        return d;
    }
}
