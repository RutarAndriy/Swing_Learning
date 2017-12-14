// ConfirmDialogs.java
// ����������� ���������� ���� ��� ��������� ��
// ������������ ������������� ������������ ��������
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class ConfirmDialogs extends JFrame {
  // ������ ��� ������ �� ���������
  private Icon icon = new ImageIcon("goblet.png");
  public ConfirmDialogs() {
    super("ConfirmDialogs");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // ����� ������� �� ������� ��������� ���������
    JButton confirm1 = new JButton("2 � 4 ���������");
    confirm1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // ���������� ���� c 4-�� �����������
        int res = JOptionPane.showConfirmDialog(
            ConfirmDialogs.this, "�� ����� ������?",
            "������",
            JOptionPane.YES_NO_CANCEL_OPTION);
        // ���������� ���������� ����
        if ( res == JOptionPane.YES_OPTION )
          JOptionPane.showConfirmDialog(
              ConfirmDialogs.this, "����� ������?");
        if ( res == JOptionPane.NO_OPTION )
          JOptionPane.showConfirmDialog(
              ConfirmDialogs.this,
              "������, �� ������?");
      }
    });
    JButton confirm2 = new JButton("5 ����������");
    confirm2.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        int res = JOptionPane.showConfirmDialog(
            ConfirmDialogs.this,
            "������� ���������, ����...",
            "����� ��������� ������!",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.ERROR_MESSAGE);
      }
    });
    JButton confirm3 = new JButton("6 ����������");
    confirm3.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        int res = JOptionPane.showConfirmDialog(
            ConfirmDialogs.this, "��� �������� ������?",
            "��������� ����������� ����!",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.ERROR_MESSAGE, icon);
      }
    });
    // ��������� ������ � ����
    setLayout(new FlowLayout());
    add(confirm1);
    add(confirm2);
    add(confirm3);
    // ������� ���� �� �����
    setSize(300, 200);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new ConfirmDialogs(); } });
  }
}
