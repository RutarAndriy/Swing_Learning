// MessageDialogs.java
// ������ JOptionPane ��� ������ ����������
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class MessageDialogs extends JFrame {
  // ���� ������ ������� � ����� �� ���������
  private ImageIcon icon = new ImageIcon("question.gif");
  public MessageDialogs() {
    super("MessageDialogs");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // ������, ����� ������� �� �������
    // ��������� ���������
    JButton message1 = new JButton("2 ���������");
    message1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(
            MessageDialogs.this,
            "<html><h2>������!<br>HTML ���� � �����!");
      }
    });
    JButton message2 = new JButton("4 ���������");
    message2.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(
            MessageDialogs.this,new String[] {
            "��������� ����� ����",
            "�������� ��������!" }, "���� ���������",
            JOptionPane.ERROR_MESSAGE);
      }
    });
    JButton message3 = new JButton("5 ����������");
    message3.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(
            MessageDialogs.this,
            "��������� ��� ��� �����", "���� ���������",
            JOptionPane.INFORMATION_MESSAGE, icon);
      }
    });
    // ������� ���� �� �����
    setLayout(new FlowLayout());
    add(message1);
    add(message2);
    add(message3);
    setSize(400, 200);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new MessageDialogs(); } });
  }
}