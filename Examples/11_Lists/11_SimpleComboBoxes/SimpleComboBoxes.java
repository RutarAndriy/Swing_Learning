// SimpleComboBoxes.java
// Створення простих випадаючих списків
import javax.swing.*;
import java.util.*;
import java.awt.*;

public class SimpleComboBoxes extends JFrame {
  // масив із елементами списка
  public String[] elements = new String[] {
      "Чарівний", "Розумний", "Ніжний", "Сильний"
  };
  public SimpleComboBoxes() {
    super("SimpleComboBoxes");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // створемо пару випадаючих списків
    JComboBox<String> combo1 = new JComboBox<>(elements);
    // задамо прототип елемента списку
    combo1.setPrototypeDisplayValue("Довгий елемент");
    // другий випадаючий список
    Vector<String> data = new Vector<String>();
    for (int i=0; i<10; i++)
      data.add("Елемент №: " + i);
    JComboBox<String> combo2 = new JComboBox<>(data);
    // робимо його редагуючим
    combo2.setEditable(true);
    combo2.setMaximumRowCount(6);
    // додамо списки та виведемо вікно на екран
    setLayout(new FlowLayout());
    add(combo1);
    add(combo2);
    setSize(300, 200);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new SimpleComboBoxes(); } });
  }
}
