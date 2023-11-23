package design_patterns_2.action.cursor;

public class MyHoliday implements Worker {
    private Day[] array = new Day[4];


    public MyHoliday(){
        array[0] = new Day(1,15,false);
        array[1] = new Day(1,8,false);
        array[2] = new Day(1,9,false);
        array[3] = new Day(1,22,false);
    }

    public Day[] getDays(){
        return array;
    }

    @Override
    public Iterator iterator() {
        return new HolidayDayIterator(array);
    }
}
