// SimpleFileChooser.java
// �������� ������� ���������� ���� 
// �������� � ���������� ������
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class SimpleFileChooser extends JFrame {
  // �������� ����� ��������� JFileChooser
  private JFileChooser fc = new JFileChooser();
  public SimpleFileChooser() {
    super("SimpleFileChooser");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // ������, ��������� ���������� ���� ��� �������� �����
    JButton open = new JButton("�������...");
    open.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        fc.setDialogTitle("�������� �������");
        // �������� ��� ������ ��������
        fc.setFileSelectionMode(
            JFileChooser.DIRECTORIES_ONLY);
        int res = fc.showOpenDialog(
            SimpleFileChooser.this);
        // ���� ���� ������, ������� ���
        if ( res == JFileChooser.APPROVE_OPTION )
          JOptionPane.showMessageDialog(
              SimpleFileChooser.this,
              fc.getSelectedFile());
      }
    });
    // ������, ��������� ���������� ����
    // ��� ���������� �����
    JButton save = new JButton("���������...");
    save.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        fc.setDialogTitle("���������� �����");
        // ��������� ������
        fc.setFileSelectionMode(
            JFileChooser.FILES_ONLY);
        int res = fc.showSaveDialog(
            SimpleFileChooser.this);
        // ������� �� ������
        if ( res == JFileChooser.APPROVE_OPTION )
          JOptionPane.showMessageDialog(
              SimpleFileChooser.this,
              "���� ��������");
      }
    });
    // ������� ������ � ������� ���� �� �����
    setLayout(new FlowLayout());
    add(open);
    add(save);
    setSize(300, 200);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new SimpleFileChooser(); } });
  }
}
