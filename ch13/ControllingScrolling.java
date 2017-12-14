// ControllingScrolling.java
// ���������� ��������� ��������� � �������
// ���������� Scrollable
import javax.swing.*;
import java.awt.*;

public class ControllingScrolling extends JFrame {
  public ControllingScrolling() {
    super("ControllingScrolling");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // ������� � ����� ������ ��������� �
    // ����� �����������
    add(new JScrollPane(new GridComponent()));
    // ������� ���� �� �����
    setSize(400, 300);
    setVisible(true);
  }
  // ���������-"�����" � ������ ������� ���������
  class GridComponent extends JPanel
      implements Scrollable {
    // ������ ������ �����
    private int CELL_SIZE = 45;
    // ���������� ����� �����
    private int CELL_COUNT = 50;
    // ���������������� ������ ����������
    public Dimension getPreferredSize() {
      return new Dimension(CELL_SIZE*CELL_COUNT,
          CELL_SIZE*CELL_COUNT);
    }
    // ���������� ����������
    public void paintComponent(Graphics g) {
      // ����� ������� ����� �������� ������
      super.paintComponent(g);
      for (int x=0; x<CELL_COUNT; x++) {
        for (int y=0; y<CELL_COUNT; y++) {
          // ������ ������
          g.setColor(Color.BLACK);
          g.drawRect(x*CELL_SIZE, y*CELL_SIZE,
              CELL_SIZE, CELL_SIZE);
          // ����� � ������������
          g.drawString(""+x+","+y,
              x*CELL_SIZE + 5, y*CELL_SIZE + CELL_SIZE/2);
        }
      }
    }
    // ���������������� ������ ������� ���������
    public Dimension
    getPreferredScrollableViewportSize() {
      return getPreferredSize();
    }
    // ���������� ��� ��������� �� ���� �������
    public int getScrollableUnitIncrement(
        Rectangle visible, int or, int dir) {
      return CELL_SIZE;
    }
    // ���������� ��� ��������� "������"
    public int getScrollableBlockIncrement(
        Rectangle visible, int or, int dir) {
      return CELL_SIZE*10;
    }
    // ����� �� ������� �� �������� ������� ���������
    public boolean getScrollableTracksViewportWidth() {
      return false;
    }
    public boolean getScrollableTracksViewportHeight() {
      return false;
    }
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new ControllingScrolling(); } });
  }
}
