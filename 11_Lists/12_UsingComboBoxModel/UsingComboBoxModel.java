// UsingComboBoxModel.java
// Використання стандартної моделі випадаючих списків
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class UsingComboBoxModel extends JFrame {
  // наша стандартна модель
  private DefaultComboBoxModel cbm;
  public UsingComboBoxModel() {
    super("UsingComboBoxModel");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // створюємо стандартну модель і заповнюємо її даними
    cbm = new DefaultComboBoxModel();
    for (int i=0; i<10; i++) {
      cbm.addElement("Елемент списку №: " + i);
    }
    // змінюємо вибраний елемент
    cbm.setSelectedItem(cbm.getElementAt(4));
    // список на основі нашої моделі
    JComboBox combo = new JComboBox(cbm);
    combo.setMaximumRowCount(5);
    // стандартна модель дозволяє
    // динамічно маніпулювати даними
    JButton add = new JButton("Додати");
    add.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // випадково вибираємо позицію
        int pos = (int) (Math.random()*cbm.getSize());
        cbm.insertElementAt("Новинка!", pos);
      }
    });
    // додаємо список і кнопку на панель
    setLayout(new FlowLayout());
    add(combo);
    add(add);
    // виводимо вікно на екран
    setSize(400, 200);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new UsingComboBoxModel(); } });
  }
}
