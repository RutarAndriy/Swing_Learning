// UsingComboBoxModel.java
// ������������� ����������� ������ �������������� �������
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class UsingComboBoxModel extends JFrame {
  // ���� ����������� ������
  private DefaultComboBoxModel cbm;
  public UsingComboBoxModel() {
    super("UsingComboBoxModel");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // ������� ����������� ������ � ��������� �� �������
    cbm = new DefaultComboBoxModel();
    for (int i=0; i<10; i++) {
      cbm.addElement("������� ������ �: " + i);
    }
    // ������� ��������� �������
    cbm.setSelectedItem(cbm.getElementAt(4));
    // ������ �� ������ ����� ������
    JComboBox combo = new JComboBox(cbm);
    combo.setMaximumRowCount(5);
    // ����������� ������ ���������
    // ����������� �������������� �������
    JButton add = new JButton("��������");
    add.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // �������� �������� �������
        int pos = (int) (Math.random()*cbm.getSize());
        cbm.insertElementAt("�������!", pos);
      }
    });
    // ��������� ������ � ������ � ������
    setLayout(new FlowLayout());
    add(combo);
    add(add);
    // ������� ���� �� �����
    setSize(400, 200);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new UsingComboBoxModel(); } });
  }
}