// KeyBindingTest.java
// ������ ������������� ����������� ����������

import javax.swing.*;
import java.awt.event.*;

public class KeyBindingTest extends JFrame {
  public KeyBindingTest() {
    super("KeyBindingTest");
    // ����� ��� �������� ����
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // ����������� ����� ������ � ������� ������� ���
    // �������� ������ ����������
    InputMap im = getRootPane().getInputMap();
    ActionMap am = getRootPane().getActionMap();
    // ����������� ��� ���������� ��������� Ctrl+A
    im.put(KeyStroke.getKeyStroke(
        KeyEvent.VK_A,
        KeyEvent.CTRL_MASK, true), "Action");
    // ����������� ��� ������ ����� '�'
    im.put(KeyStroke.getKeyStroke('�'), "Action");
    am.put("Action", new AnAction());
    // ������� ���� �� �����
    setSize(200, 200);
    setVisible(true);
  }

  // ����� ����� �������
  class AnAction extends AbstractAction {
    public void actionPerformed(ActionEvent e) {
      System.out.println("OK");
    }
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new KeyBindingTest(); } });
  }
}
