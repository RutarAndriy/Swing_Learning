// ToggleButtons.java
// ������������� ������������ JToggleButton
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ToggleButtons extends JFrame {
  public ToggleButtons() {
    super("ToggleButtons");
    setDefaultCloseOperation( EXIT_ON_CLOSE );
    // ���������� ���������������� ������������
    setLayout(new FlowLayout());
    // �������� ���� ������ JToggleButton
    button1 = new JToggleButton("������", true);
    button2 = new JToggleButton("������", false);
    // ������� ��������� ������� � ����� ���������
    button2.addItemListener(new ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        button1.setSelected(
            ! button2.isSelected());
      }
    });
    add(button1);
    add(button2);
    // ������� ���� �� �����
    pack();
    setVisible(true);
  }
  // ������ �� ������������ ������
  private JToggleButton button1, button2;
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new ToggleButtons(); } });
  }
}