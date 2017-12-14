// AnonymousClassEvents.java
// ��������� ������ ��� ��������� �������

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class AnonymousClassEvents extends JFrame {
  public AnonymousClassEvents() {
    super("AnonymousClassEvents");
    // ��������� ����� �������������� ����� �� �����
    // ����� �� ���������� ��� �������� ����
    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
    // ������� ������
    JButton button = new JButton("������� ����");
    getContentPane().add(button);
    // ��������� ��������� � ������
    button.addActionListener(getButtonL());
    // ������� ���� �� �����
    pack();
    setVisible(true);
  }

  // ���� ����� ������� ��������� ��� ������
  public ActionListener getButtonL() {
    return new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        System.out.println("ActionListener");
      }
    };
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() {
            new AnonymousClassEvents();
          }
        });
  }
}
