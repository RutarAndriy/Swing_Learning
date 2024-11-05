// CheckBoxListTest.java
// Перевірка роботи списку із прапорцями
import javax.swing.*;
import com.porty.swing.*;
import java.awt.*;

public class CheckBoxListTest {
  // дані списку
  private static CheckBoxListElement[] data = {
      new CheckBoxListElement(false, "Корпус"),
      new CheckBoxListElement(false,
          "<html><h3><font color=red>Колонки"),
      new CheckBoxListElement(false, "Набір шлейфів"),
      new CheckBoxListElement(true, "Материнська плата")
  };
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() {
            // створюємо список і налаштовуємо його
            JList list = new CheckBoxList(data);
            // додаємо у вікно
            JFrame frame = new JFrame("CheckBoxListTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(200, 200);
            frame.add(new JScrollPane(list));
            frame.setVisible(true);
          } });
  }
}
