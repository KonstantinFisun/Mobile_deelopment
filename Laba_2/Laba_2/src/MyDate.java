public class MyDate {
    private int day, month, year;
    public MyDate(int d,  int m, int y) {
        day = d;
        month = m;
        year = y;
    }
    @Override
    public boolean equals(Object object) {
        boolean result = false;
        // Сравнивает только объекты типа MyDate
        if (object instanceof MyDate) {
            MyDate d = (MyDate)object; // Явное приведение типов
            if ((day == d.day) && (month == d.month) && (year == d.year))
                result = true;
        }
        return result;
    }
}
