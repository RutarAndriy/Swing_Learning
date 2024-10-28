// ListSelectionEvents.java
// Слідкування за виділенням списку
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

public class ListSelectionEvents extends JFrame {
  // дані списку
  private String[] data =
      { "Червоний", "Жовтий", "Зелений"};
  private JTextArea jta;
  public ListSelectionEvents() {
    super("ListSelectionEvents");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // створюємо список і текстове поле
    setLayout(new FlowLayout());
    JList list = new JList(data);
    list.setSelectionMode(
        ListSelectionModel.SINGLE_SELECTION);
    jta = new JTextArea(5, 20);
    // добавимо прослуховувача подій виділення
    list.addListSelectionListener(new SelectionL());
    // добавляємо компоненти
    add(new JScrollPane(list));
    add(new JScrollPane(jta));
    // виводимо вікно на екран
    setSize(320, 200);
    setVisible(true);
  }
  // прослуховувач подій від моделі виділення
  class SelectionL implements ListSelectionListener {
    public void valueChanged(ListSelectionEvent lse) {
      int selected =
          ((JList)lse.getSource()).getSelectedIndex();
      switch ( selected ) {
        case 0: jta.setText("Переходити не можна"); break;
        case 1: jta.setText("Будьте готові"); break;
        case 2: jta.setText("Переходьте вулицю");
      }
    }
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new ListSelectionEvents(); } });
  }
}
