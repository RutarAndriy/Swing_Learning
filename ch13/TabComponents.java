// TabComponents.java
// ���������� ����������� �� ��������
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class TabComponents extends JFrame {
  public TabComponents() {
    super("TabComponents");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // ������ � ���������
    final JTabbedPane tabs = new JTabbedPane();
    tabs.addTab(null, new JPanel());
    tabs.addTab(null, new JPanel());
    // ������ �� �������
    JCheckBox checkBox = new JCheckBox("������!");
    checkBox.setOpaque(false);
    tabs.setTabComponentAt(0, checkBox);
    // ������� � �������� � ������� ��������
    final JPanel panel = new JPanel();
    JLabel label = new JLabel("����� �������!");
    JButton closeButton = new JButton(new AbstractAction() {
      {
        putValue(SMALL_ICON, new ImageIcon("close.png"));
      }
      public void actionPerformed(ActionEvent e) {
        // ����� ���������� �������, � ������� ��������� ������
        tabs.removeTabAt(
            tabs.indexOfTabComponent(panel));
      }
    });
    closeButton.setBorderPainted(false);
    closeButton.setContentAreaFilled(false);
    panel.setOpaque(false);
    panel.add(label);
    panel.add(closeButton);
    tabs.setTabComponentAt(1, panel);
    // ������� ���� �� �����
    add(tabs);
    setSize(430, 300);
    setVisible(true);
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new TabComponents(); } });
  }
}