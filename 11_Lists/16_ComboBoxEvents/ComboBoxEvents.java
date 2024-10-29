// ComboBoxEvents.java
// Події випадаючих списків
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class ComboBoxEvents extends JFrame {
  // дані для списків
  private String[] data = { "США", "Італія",
      "Швейцарія", "Тайланд" };
  public ComboBoxEvents() {
    super("ComboBoxEvents");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // перший список
    JComboBox combo1 = new JComboBox(data);
    // прослуховувач зміни вибраного елемента
    combo1.addItemListener(new ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        // з'ясовуємо, що відбулося
        if ( e.getStateChange() ==
            ItemEvent.SELECTED ) {
          // відобразимо вибраний елемент
          Object item = e.getItem();
          JOptionPane.showMessageDialog(
              ComboBoxEvents.this, item);
        }
      }
    });
    // список, дозволяючий редагування
    final JComboBox combo2 = new JComboBox(data);
    combo2.setEditable(true);
    // прослуховувач закінчення редагування
    combo2.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // покажемо вибір користувача
        Object item = combo2.getModel().
            getSelectedItem();
        JOptionPane.showMessageDialog(
            ComboBoxEvents.this, item);
      }
    });
    // додамо списки у вікно
    setLayout(new FlowLayout());
    add(combo1);
    add(combo2);
    // виведемо вікно на екран
    setSize(350, 250);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new ComboBoxEvents(); } });
  }
}
