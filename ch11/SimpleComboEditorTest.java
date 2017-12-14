// SimpleComboEditorTest.java
// ������ ������������� ������������ ������� ���
// ��������������
import javax.swing.*;
import com.porty.swing.*;
import java.awt.*;

public class SimpleComboEditorTest
    extends JFrame {
  // ������ ��� ��������������� ������
  private String[] data = {
      "<html><font color=yellow>������",
      "<html><strike>�����������",
      "<html><font color=green>�������",
      "<html><em>� ��������" };
  public SimpleComboEditorTest() {
    super("SimpleComboEditorTest");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // ������� ������
    JComboBox combo = new JComboBox(data);
    combo.setEditable(true);
    combo.setEditor(new SimpleHTMLComboBoxEditor());
    // ��������� ������ � ����
    setLayout(new FlowLayout());
    add(combo);
    // ������� ���� �� �����
    setSize(330, 200);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new SimpleComboEditorTest(); } });
  }
}
