package netcracker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Person {
    private Calendar dayOfBirth;

    Person(int day, int month, int year){
        this.dayOfBirth = new GregorianCalendar(year, month, day);
    }

    public String toString(){
        return "День рождения: " + new SimpleDateFormat("d").format(dayOfBirth.getTime()) +
                "\nМесяц рождения: " + new SimpleDateFormat("LLLL").format(dayOfBirth.getTime()) +
                "\nГод рождения: " + new SimpleDateFormat("yyyy").format(dayOfBirth.getTime());
    }
    /*
      pattern - маска для вывода даты в соответствующем формате
    */
    public String getDate(String pattern){
        return new SimpleDateFormat(pattern).format(dayOfBirth.getTime());
    }
}
