// ActionSample.java
// ������������� ����������� Action
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ActionSample extends JFrame {
  public ActionSample() {
    super("ActionSample");
    setDefaultCloseOperation( EXIT_ON_CLOSE );
    // ���������� ���������������� ������������
    setLayout(new FlowLayout());
    // �������� ���� ������, �����������
    // ���� ��������
    Action action = new SimpleAction();
    JButton button1 = new JButton(action);
    JButton button2 = new JButton(action);
    add(button1);
    add(button2);
    // ������� ���� �� �����
    setSize(300, 100);
    setVisible(true);
  }
  // ���� ���������� ����� ������������� ���� �������
  class SimpleAction extends AbstractAction {
    SimpleAction() {
      // ��������� ��������� �������
      putValue(NAME, "������, Action!");
      putValue(SHORT_DESCRIPTION, "��� ���������");
      putValue(MNEMONIC_KEY, new Integer('A'));
    }
    // � ���� ������ �������������� �������, ���
    // � � ������� ������ ActionListener
    public void actionPerformed(ActionEvent e) {
      // ����� ��������� �������, �� ����, �
      // ����� ����������� ��� ������������
      setEnabled(false);
      // ������� �������
      putValue(NAME, "������, Action!");
    }
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new ActionSample(); } });
  }
}