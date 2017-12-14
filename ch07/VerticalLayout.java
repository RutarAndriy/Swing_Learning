// VerticalLayout.java
// ������� �������� ������������, �����������
// ���������� � ������������ ��� � ���������
import java.awt.*;
import javax.swing.*;

public class VerticalLayout implements LayoutManager {
  // ������ ����� ������������
  public int GAP = 5;
  // ������ ����������� ���������� � ����������
  public void layoutContainer(Container c) {
    Component comps[] = c.getComponents();
    int currentY = GAP;
    for (Component comp : comps) {
      // ���������������� ������ ����������
      Dimension pref = comp.getPreferredSize();
      // ��������� ��������� ���������� �� ������
      comp.setBounds(GAP, currentY,
          pref.width, pref.height);
      // ���������� ����� ������������
      currentY += GAP;
      currentY += pref.height;
    }
  }
  // ��� ��� ������ ��� �� �����������
  public void addLayoutComponent(
      String name, Component comp) {
  }
  public void removeLayoutComponent(
      Component comp) {
  }
  // ����������� ������ ��� ����������
  public Dimension minimumLayoutSize(Container c) {
    return calculateBestSize(c);
  }
  // ���������������� ������ ��� ����������
  public Dimension preferredLayoutSize(Container c) {
    return calculateBestSize(c);
  }

  private Dimension size = new Dimension();
  // ��������� ����������� ������ ����������
  private Dimension calculateBestSize(Container c) {
    // ������� �������� ����� ����������
    Component[] comps = c.getComponents();
    int maxWidth = 0;
    for (Component comp : comps) {
      int width = comp.getWidth();
      // ����� ���������� � ������������ ������
      if (width > maxWidth) maxWidth = width;
    }
    // ����� ���������� � ������ ������ �������
    size.width = maxWidth + GAP;
    // ��������� ������ ����������
    int height = 0;
    for (Component comp : comps) {
      height += GAP;
      height += comp.getHeight();
    }
    size.height = height;
    return size;
  }

  // �������� ������ ������ ���������
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() {
            JFrame frame = new JFrame("VerticalLayout");
            frame.setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE);
            // ������ ����� ������������ ����� ������������
            JPanel contents = new JPanel(
                new VerticalLayout());
            // ������� ���� ������ � ��������� ����
            contents.add(new JButton("����"));
            contents.add(new JButton("���"));
            contents.add(new JTextField(30));
            frame.add(contents);
            frame.setVisible(true);
            frame.pack();
          } });
  }
}