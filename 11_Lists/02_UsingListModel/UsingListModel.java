// UsingListModel.java
// Використання стандартної моделі списку
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class UsingListModel extends JFrame {
  // наша модель
  private DefaultListModel dlm;
  public UsingListModel() {
    super("UsingListModel");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // заповнюємо модель даними
    dlm = new DefaultListModel();
    dlm.add(0, "Щось");
    dlm.add(0, "Щось ще");
    dlm.add(0, "Ще небагато");
    // створюємо кнопку і пару списків
    JButton add = new JButton("Оновити");
    add.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        dlm.add(0, "Новинка!");
      }
    });
    JList list1 = new JList(dlm);
    JList list2 = new JList(dlm);
    // додаємо компоненти
    setLayout(new FlowLayout());
    add(add);
    add(new JScrollPane(list1));
    add(new JScrollPane(list2));
    // виводимо вікно на екран
    setSize(400, 200);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new UsingListModel(); } });
  }
}
