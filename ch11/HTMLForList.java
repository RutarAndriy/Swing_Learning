// HTMLForList.java
// ������������� ������������ �������
// DefaultListCellRenderer
import javax.swing.*;
import java.awt.*;

public class HTMLForList {
  // ������ ������
  private static Object[] data = {
      "<html><font size=4 color=red>������",
      new ImageIcon("bullet.gif"),
      "<html><h2><font color=yellow>�������"
  };
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() {
            // ������� ������
            JList list = new JList(data);
            // �������� ��� � ����
            JFrame frame = new JFrame("HTMLForList");
            frame.setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE);
            frame.setSize(200, 200);
            frame.add(new JScrollPane(list));
            frame.setVisible(true);
          } });
  }
}