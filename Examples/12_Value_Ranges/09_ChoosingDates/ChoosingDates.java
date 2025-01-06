// ChoosingDates.java
// Вибір дат з допомогою SpinnerDateModel
import javax.swing.*;
import java.util.*;
import java.awt.*;

public class ChoosingDates extends JFrame {
  public ChoosingDates() {
    super("ChoosingDates");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // налаштовуємо модель для вибору дня місяця
    SpinnerModel monthDay = new SpinnerDateModel(
        new Date(), null, null, Calendar.DAY_OF_MONTH);
    JSpinner spinner1 = new JSpinner(monthDay);
    // модель для вибору місяця, з обмеженнями
    // код змінено, оскільки 2011 рік вже минув!
    Calendar calendar = Calendar.getInstance();
    calendar.set(Calendar.YEAR, 2009);
    SpinnerModel month = new SpinnerDateModel(
        calendar.getTime(), new MinDate(), new MaxDate(), Calendar.MONTH);
    // SpinnerModel month = new SpinnerDateModel(
    //    new Date(), new MinDate(), new MaxDate(), Calendar.MONTH);
    JSpinner spinner2 = new JSpinner(month);
    // додаємо списки до панелі
    setLayout(new FlowLayout());
    add(spinner1);
    add(spinner2);
    // виводимо вікно на екран
    setSize(350, 300);
    setVisible(true);
  }
  // допоміжний об'єкт для провірок дат
  private Calendar calendar = Calendar.getInstance();
  // перевіряємо мінімальну дату (по році)
  class MinDate extends Date implements Comparable<Date> {
    public int compareTo(Date d) {
      calendar.setTime(d);
      int year = calendar.get(Calendar.YEAR);
      // рік не менше 2005
      return (year < 2005) ? 1 : -1;
    }
  }
  // провіряємо максимальну дату (по році)
  class MaxDate extends Date implements Comparable<Date> {
    public int compareTo(Date d) {
      calendar.setTime(d);
      calendar.get(Calendar.YEAR);
      int year = calendar.get(Calendar.YEAR);
      // рік не більше 2011
      if ( year > 2011 ) return -1;
      else return 1;
    }
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new ChoosingDates(); } });
  }
}
