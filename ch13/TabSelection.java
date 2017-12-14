// TabSelection.java
// ������ � ��������� ��������� � ��������� �������
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.awt.*;

public class TabSelection extends JFrame {
  public TabSelection() {
    super("TabSelection");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // ������� ���� ������ � ���������
    JTabbedPane tabs = new JTabbedPane();
    tabs.addTab("�������", new JPanel());
    tabs.addTab("��� �������", new JPanel());
    // ��������� ��������� �������
    tabs.addChangeListener(new ChangeListener() {
      public void stateChanged(ChangeEvent e) {
        // ��������� �� ������� ����� ���������
        JPanel panel = (JPanel)
            ((JTabbedPane)e.getSource()).
                getSelectedComponent();
        panel.add(new JButton("������"));
      }
    });
    // ������ � ��������������� ���������
    tabs.addMouseListener(new MouseAdapter() {
      public void mousePressed(MouseEvent e) {
        // ������, �� ����� ������� ��� ������
        int idx = ((JTabbedPane)e.getSource()).
            indexAtLocation(e.getX(), e.getY());
        JOptionPane.showMessageDialog(
            null, "Index: " + idx);
      }
    });
    // ������� ���� �� �����
    add(tabs);
    setSize(400, 300);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new TabSelection(); } });
  }
}