// HeadersAndCorners.java
// ��������� � "������" ������ ��������� JScrollPane
import javax.swing.*;
import java.awt.*;

public class HeadersAndCorners extends JFrame {
  // ������� � ������� ������������
  private JLabel label = new JLabel(
      new ImageIcon("image.jpg"));
  public HeadersAndCorners() {
    super("HeadersAndCorners");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // ������� ������ ���������
    JScrollPane scroll = new JScrollPane(label);
    // ������������� ���������
    scroll.setColumnHeaderView(new XHeader());
    scroll.setRowHeaderView(new YHeader());
    // ������������� ����� ������� "������"
    scroll.setCorner(JScrollPane.UPPER_LEFT_CORNER,
        new JButton(new ImageIcon("Print16.gif")));
    // ������� ���� �� �����
    add(scroll);
    setSize(400, 300);
    setVisible(true);
  }
  // ��������� �� ��� X
  class XHeader extends JPanel {
    // ������ ���������
    public Dimension getPreferredSize() {
      return new Dimension(
          label.getPreferredSize().width, 20);
    }
    // ������������� �������
    public void paintComponent(Graphics g) {
      super.paintComponent(g);
      int width = getWidth();
      for (int i=0; i<width; i+=50) {
        g.drawString("" + i, i, 15);
      }
    }
  }
  // ��������� �� ��� Y
  class YHeader extends JPanel {
    // ������ ���������
    public Dimension getPreferredSize() {
      return new Dimension(
          20, label.getPreferredSize().height);
    }
    // ������������� �������
    public void paintComponent(Graphics g) {
      super.paintComponent(g);
      int height = getHeight();
      for (int i=0; i<height; i+=50) {
        g.drawString("" + i, 0, i);
      }
    }
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new HeadersAndCorners(); } });
  }
}
