// ButtonEvents.java
// ��������� ������� �� ������ JButton
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class ButtonEvents extends JFrame {
  private JTextArea info;
  public ButtonEvents() {
    super("ButtonEvents");
    setDefaultCloseOperation( EXIT_ON_CLOSE );
    // ������� ������ � �������� �� �� ����� ����
    JButton button = new JButton("������� ����!");
    add(button, "North");
    // ���� ��� ������ ��������� � ��������
    info = new JTextArea("���� ������� �� ����\n");
    add(new JScrollPane(info));
    // ����������� � ����� ������ ���������� �������
    // ��������� ������� ��� ���������� ������
    button.addActionListener(new ActionL());
    button.addChangeListener(new ChangeL());
    // ������������� ��������� ����� �� �����
    button.addItemListener(new ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        info.append("��� �� ��� ����� �� �������");
      }
    });
    // ������� ���� �� �����
    setSize(400, 300);
    setVisible(true);
  }
  class ActionL implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      info.append(
          "�������� ��������� � ������� ������! �� - "
              + e.getActionCommand() + "\n");
    }
  }
  class ChangeL implements ChangeListener {
    public void stateChanged(ChangeEvent e) {
      info.append(
          "�������� ��������� � ����� ��������� ������!\n");
      // ��� �������� �������
      Object src = e.getSource();
    }
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new ButtonEvents(); } });
  }
}