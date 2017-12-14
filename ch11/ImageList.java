// ImageList.java
// ������, ������������ ����� �������� ������
import javax.swing.*;
import com.porty.swing.*;

import java.awt.*;

public class ImageList {
  // ������ ������
  private static Icon bullet = new ImageIcon("bullet.gif");
  private static Object[] data = {
      new ImageListElement(bullet, "������"),
      new ImageListElement(bullet, "������"),
      new ImageListElement(bullet,
          "<html><h4><font color=green>� ������!")
  };
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() {
            // ������� ������ � ����������� ���
            JList list = new JList(data);
            list.setCellRenderer(new ImageListCellRenderer());
            // ��������� � ����
            JFrame frame = new JFrame("ImageList");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(200, 200);
            frame.add(new JScrollPane(list));
            frame.setVisible(true);
          } });
  }
}
