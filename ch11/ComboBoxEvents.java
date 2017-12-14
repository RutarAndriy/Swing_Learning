// ComboBoxEvents.java
// ������� �������������� �������
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class ComboBoxEvents extends JFrame {
  // ������ ��� �������
  private String[] data = { "���", "������",
      "���������", "�������" };
  public ComboBoxEvents() {
    super("ComboBoxEvents");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // ������ ������
    JComboBox combo1 = new JComboBox(data);
    // ��������� ����� ���������� ��������
    combo1.addItemListener(new ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        // ��������, ��� ���������
        if ( e.getStateChange() ==
            ItemEvent.SELECTED ) {
          // ������� ��������� �������
          Object item = e.getItem();
          JOptionPane.showMessageDialog(
              ComboBoxEvents.this, item);
        }
      }
    });
    // ������, ����������� ��������������
    final JComboBox combo2 = new JComboBox(data);
    combo2.setEditable(true);
    // ��������� ��������� ��������������
    combo2.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // ������� ����� ������������
        Object item = combo2.getModel().
            getSelectedItem();
        JOptionPane.showMessageDialog(
            ComboBoxEvents.this, item);
      }
    });
    // ������� ������ � ����
    setLayout(new FlowLayout());
    add(combo1);
    add(combo2);
    // ������� ���� �� �����
    setSize(350, 250);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new ComboBoxEvents(); } });
  }
}
