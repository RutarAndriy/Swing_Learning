// ComboBoxRendering.java
// ����������� ��������� ��������������� ������
import javax.swing.*;
import com.porty.swing.*;

import java.awt.*;

public class ComboBoxRendering extends JFrame {
  // ������ ��� ������� ������
  private String[] textData = { "<html><code>������",
      "<html><b>������", "<html><font color=red>�������",
      "<html><em>�������������" };
  // ������
  private ImageIcon bullet1 =
      new ImageIcon("Server16.gif");
  private ImageIcon bullet2 =
      new ImageIcon("Host16.gif");
  // ������ ��� ������� ������ �� ��������
  private ImageListElement[] iconData = {
      new ImageListElement(bullet1, "�������� ������"),
      new ImageListElement(bullet1, "��������������"),
      new ImageListElement(bullet2,
          "<html><b><em>������ ���������")
  };
  public ComboBoxRendering() {
    super("ComboBoxRendering");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // ������� ���� �������������� �������
    JComboBox combo1 = new JComboBox(textData);
    JComboBox combo2 = new JComboBox(iconData);
    // ��� ����������� ������������ ������
    combo2.setRenderer(new ImageListCellRenderer());
    // ��������� ������ � ����
    setLayout(new FlowLayout());
    add(combo1);
    add(combo2);
    // ������� ���� �� �����
    setSize(350, 200);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new ComboBoxRendering(); } });
  }
}
