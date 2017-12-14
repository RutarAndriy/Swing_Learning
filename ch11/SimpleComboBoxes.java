// SimpleComboBoxes.java
// �������� ������� �������������� �������
import javax.swing.*;
import java.util.*;
import java.awt.*;

public class SimpleComboBoxes extends JFrame {
  // ������ � ���������� ������
  public String[] elements = new String[] {
      "�����������", "�����", "������", "�������"
  };
  public SimpleComboBoxes() {
    super("SimpleComboBoxes");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // �������� ���� �������������� �������
    JComboBox combo1 = new JComboBox(elements);
    // ������ �������� �������� ������
    combo1.setPrototypeDisplayValue("������� �������");
    // ������ �������������� ������
    Vector<String> data = new Vector<String>();
    for (int i=0; i<10; i++)
      data.add("������� �: " + i);
    JComboBox combo2 = new JComboBox(data);
    // ������� ��� �������������
    combo2.setEditable(true);
    combo2.setMaximumRowCount(6);
    // ������� ������ � ������� ���� �� �����
    setLayout(new FlowLayout());
    add(combo1);
    add(combo2);
    setSize(300, 200);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new SimpleComboBoxes(); } });
  }
}
