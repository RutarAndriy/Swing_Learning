// HTMLComboEditorTest.java
// ������ ������������� ������������ ������� ���
// ��������������
import javax.swing.*;
import com.porty.swing.HTMLComboBoxEditor;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HTMLComboEditorTest
    extends JFrame {
  // ������ ��� ��������������� ������
  private String[] data = {
      "<html><font color=yellow>������",
      "<html><strike>�����������",
      "<html><font color=green>�������",
      "<html><em>� ��������" };
  public HTMLComboEditorTest() {
    super("HTMLComboEditorTest");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // ������� ������
    final JComboBox combo = new JComboBox(data);
    combo.setPrototypeDisplayValue("11223344556677");
    combo.setEditable(true);
    combo.setEditor(new HTMLComboBoxEditor());
    // ��������� ������ � ����
    setLayout(new FlowLayout());
    add(combo);
    // ������ ��� ���������� ������ �������� � ������
    JButton addButton = new JButton("��������");
    addButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        combo.addItem(combo.getSelectedItem());
      }
    });
    add(addButton);
    // ������� ���� �� �����
    setSize(330, 200);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new HTMLComboEditorTest(); } });
  }
}
