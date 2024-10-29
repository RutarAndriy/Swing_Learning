// HTMLComboEditorTest.java
// Приклад використання спеціального об'єкта для редагування
import javax.swing.*;
import com.porty.swing.HTMLComboBoxEditor;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HTMLComboEditorTest
    extends JFrame {
  // дані для випадаючого списку
  private String[] data = {
      "<html><font color=yellow>Жовтий",
      "<html><strike>Закреслений",
      "<html><font color=green>Зелений",
      "<html><em>Курсив" };
  public HTMLComboEditorTest() {
    super("HTMLComboEditorTest");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // створюємо список
    final JComboBox combo = new JComboBox(data);
    combo.setPrototypeDisplayValue("11223344556677");
    combo.setEditable(true);
    combo.setEditor(new HTMLComboBoxEditor());
    // додаємо список у вікно
    setLayout(new FlowLayout());
    add(combo);
    // кнопка для додавання нового елемента в список
    JButton addButton = new JButton("Додати");
    addButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        combo.addItem(combo.getSelectedItem());
      }
    });
    add(addButton);
    // виводимо вікно на екран
    setSize(330, 200);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new HTMLComboEditorTest(); } });
  }
}
