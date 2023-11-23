package design_patterns_2.action.cursor;

public class Day {
    private int moth; // 月份
    private int daily;
    private boolean isWorkDay;

    public Day(int moth, int daily, boolean isWorkDay) {
        this.moth = moth;
        this.daily = daily;
        this.isWorkDay = isWorkDay;
    }

    @Override
    public String toString() {
        return "时间：" +
                + moth +
                "月" + daily +
                "日   " + (isWorkDay?"工作":"休假") ;
    }
}
