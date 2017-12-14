// InputDialogs.java
// ����������� ���������� ���� JOptionPane ��� ����� ������
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class InputDialogs extends JFrame {
  // ������ ��� ������ �� ���������
  private ImageIcon icon = new ImageIcon("question.gif");
  // ������ ��� ������
  private String[] values = {"�����","�������","�������" };
  public InputDialogs() {
    super("InputDialogs");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // ����� ������� �� ������� ��������� ���������
    JButton input1 = new JButton("2 � 3 ���������");
    input1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // ���� ������ � ��������� ����
        String res = JOptionPane.showInputDialog(
            InputDialogs.this,
            "<html><h2>������ �� ������?");
        res = JOptionPane.showInputDialog(
            InputDialogs.this,
            "��� ����� ��� �����?", res);
      }
    });
    JButton input2 = new JButton("4 ���������");
    input2.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // ��������� �������� ��� � ���������
        String res = JOptionPane.showInputDialog(
            InputDialogs.this, new String[] {
            "������ ������ �������!", "��������� ����:"},
            "������", JOptionPane.WARNING_MESSAGE);
      }
    });
    JButton input3 = new JButton("7 ����������");
    input3.addActionListener(new ActionListener() {
      // ����� �� ���������� �����������
      public void actionPerformed(ActionEvent e) {
        Object res = JOptionPane.showInputDialog(
            InputDialogs.this,"�������� ������� ����:",
            "����� �����", JOptionPane.QUESTION_MESSAGE,
            icon, values, values[0]);
        JOptionPane.showMessageDialog(
            InputDialogs.this, res);
      }
    });
    // ��������� ������ � ����
    setLayout(new FlowLayout());
    add(input1);
    add(input2);
    add(input3);
    setSize(400, 200);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new InputDialogs(); } });
  }
}
