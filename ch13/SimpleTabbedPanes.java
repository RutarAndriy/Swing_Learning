// SimpleTabbedPanes.java
// ������������� ������� � ���������
import javax.swing.*;
import java.awt.*;

public class SimpleTabbedPanes extends JFrame {
  public SimpleTabbedPanes() {
    super("SimpleTabbedPanes");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // ������ ������ � ���������
    JTabbedPane tabsOne = new JTabbedPane(
        JTabbedPane.BOTTOM, JTabbedPane.SCROLL_TAB_LAYOUT);
    // ��������� �������
    for (int i=1; i<8; i++) {
      JPanel tab = new JPanel();
      tab.add(new JButton("������ ������ " + i));
      tabsOne.addTab("������� �: " + i, tab);
    }
    // ������ ������ � ���������
    JTabbedPane tabsTwo = new
        JTabbedPane(JTabbedPane.TOP);
    // ��������� �������
    for (int i=1; i<8; i++) {
      JPanel tab = new JPanel();
      tab.add(new JButton("����� ������ " + i));
      tabsTwo.addTab("<html><i>������� �: " + i,
          new ImageIcon("icon.gif"),
          tab, "������� " + i + "!");
    }
    // ��������� ������� � ������ �����������
    setLayout(new GridLayout());
    add(tabsOne);
    add(tabsTwo);
    // ������� ���� �� �����
    setSize(600, 250);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new SimpleTabbedPanes(); } });
  }
}