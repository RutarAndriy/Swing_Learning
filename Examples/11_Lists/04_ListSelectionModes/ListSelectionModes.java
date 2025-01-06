// ListSelectionModes.java
// Різні режими виділення
import javax.swing.*;
import java.awt.*;

public class ListSelectionModes extends JFrame {
  private String[] data = { "Червоний", "Синій",
      "Зелений", "Жовтий", "Білий"};
  public ListSelectionModes() {
    super("ListSelectionModes");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // заповнимо модель даними
    DefaultListModel<String> dlm =
        new DefaultListModel<>();
    for (String next : data)
      dlm.addElement(next);
    // три списки з різним типом виділення
    JList<String> list1 = new JList<>(dlm);
    list1.setSelectionMode(
        ListSelectionModel.SINGLE_SELECTION);
    JList<String> list2 = new JList<>(dlm);
    list2.setSelectionMode(
        ListSelectionModel.SINGLE_INTERVAL_SELECTION);
    JList<String> list3 = new JList<>(dlm);
    // аналогічно попередньому виклику
    list3.getSelectionModel().setSelectionMode(
        ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
    // додаємо компоненти
    setLayout(new FlowLayout());
    add(new JScrollPane(list1));
    add(new JScrollPane(list2));
    add(new JScrollPane(list3));
    // виводимо вікно на екран
    setSize(300, 200);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new ListSelectionModes(); } });
  }
}
