// DoubleClickList.java
// Отримання елемента списку по точці екрану
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class DoubleClickList extends JFrame {
  // дані списку
  private String[] data = { "Стейк", "Лобстер",
      "Борщ", "Риба"};
  private JList<String> list;
  public DoubleClickList() {
    super("DoubleClickList");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // створюємо список
    list = new JList<>(data);
    list.setSelectionMode(
        ListSelectionModel.SINGLE_SELECTION);
    // додамо прослуховувача подій від миші
    list.addMouseListener(new MouseAdapter() {
      public void mousePressed(MouseEvent e) {
        if ( e.getClickCount() == 2 ) {
          // отримуємо елемент і показуємо його
          int pos =
              list.locationToIndex(e.getPoint());
          JOptionPane.showMessageDialog(
              list, "Вже готується: " +
                  list.getModel().getElementAt(pos));
        }
      }
    });
    // виводимо вікно на екран
    add(new JScrollPane(list));
    setSize(300, 200);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new DoubleClickList(); } });
  }
}
