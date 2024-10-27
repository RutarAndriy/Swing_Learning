// SimpleLists.java
// Найпростіший спосіб створення списків
import javax.swing.*;
import java.util.*;
import java.awt.*;

public class SimpleLists extends JFrame {
  // дані для списків
  private String[] data1 = { "Один", "Два",
      "Три", "Чотири", "П'ять"};
  private String[] data2 = { "Просто", "Легко",
      "Елементарно", "Як два на два" };
  public SimpleLists() {
    super("SimpleLists");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // створюємо списки
    JList list1 = new JList(data1);
    // для другого списку використовуємо вектор
    Vector<String> data = new Vector<String>();
    data.addAll(Arrays.asList(data2));
    JList list2 = new JList(data);
    // динамічно наповнюємо вектор
    Vector<String> big = new Vector<String>();
    for (int i=0; i<50; i++) {
      big.add("# " + i);
    }
    JList bigList = new JList(big);
    bigList.setPrototypeCellValue("12345");
    // додамо списки в панель
    setLayout(new FlowLayout());
    add(list1);
    add(list2);
    add(new JScrollPane(bigList));
    // виводимо віно на екран
    setSize(300, 200);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new SimpleLists(); } });
  }
}
