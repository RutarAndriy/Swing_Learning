// ChoosingDates.java
// ����� ��� � ������� SpinnerDateModel
import javax.swing.*;
import java.util.*;
import java.awt.*;

public class ChoosingDates extends JFrame {
  public ChoosingDates() {
    super("ChoosingDates");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // ����������� ������ ��� ������ ��� ������
    SpinnerModel monthDay = new SpinnerDateModel(
        new Date(), null, null, Calendar.DAY_OF_MONTH);
    JSpinner spinner1 = new JSpinner(monthDay);
    // ������ ��� ������ ������, � �������������
    SpinnerModel month = new SpinnerDateModel(
        new Date(), new MinDate(), new MaxDate(), Calendar.MONTH);
    JSpinner spinner2 = new JSpinner(month);
    // ��������� ������ � ������
    setLayout(new FlowLayout());
    add(spinner1);
    add(spinner2);
    // ������� ���� �� �����
    setSize(350, 300);
    setVisible(true);
  }
  // ��������������� ������ ��� �������� ���
  private Calendar calendar = Calendar.getInstance();
  // ��������� ����������� ���� (�� ����)
  class MinDate extends Date implements Comparable<Date> {
    public int compareTo(Date d) {
      calendar.setTime(d);
      int year = calendar.get(Calendar.YEAR);
      // ��� �� ������ 2005
      return (year < 2005) ? 1 : -1;
    }
  }
  // ��������� ������������ ���� (�� ����)
  class MaxDate extends Date implements Comparable<Date> {
    public int compareTo(Date d) {
      calendar.setTime(d);
      calendar.get(Calendar.YEAR);
      int year = calendar.get(Calendar.YEAR);
      // ��� �� ������ 2011
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
