public class TestEquals {
    public static void main(String[] args) {
        MyDate date1 = new MyDate(7,11,2014);
        MyDate date2 = new MyDate(7,11,2014);
        if (date1 == date2)
            System.out.println("Даты идентичны по ==");
        else
            System.out.println("Даты неидентичны по ==");

        if (date1.equals(date2))
            System.out.println("Даты равны по equals");
        else
            System.out.println("Даты не равны по equals ");
        
        System.out.println("Присвоим date2 ссылку на date1");
        date2 = date1;
        if (date1 == date2)
            System.out.println("Даты идентичны по ==");
        else
            System.out.println("Даты неидентичны по ==");

        if (date1.equals(date2))
            System.out.println("Даты равны по equals");
        else
            System.out.println("Даты не равны по equals ");
    }
}
