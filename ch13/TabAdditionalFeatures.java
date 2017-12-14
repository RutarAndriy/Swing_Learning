// TabAdditionalFeatures.java
// �������������� ����������� ������� � ���������
import javax.swing.*;
import java.awt.*;

public class TabAdditionalFeatures extends JFrame {
  public TabAdditionalFeatures() {
    super("TabAdditionalFeatures");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // ������ � ���������
    JTabbedPane tabs = new JTabbedPane();
    tabs.addTab("������ �������", new JPanel());
    tabs.addTab("������ ������� (S)", new JPanel());
    tabs.addTab("���������� �������", new JPanel());
    // �������� ���������
    tabs.setMnemonicAt(0, '�');
    tabs.setMnemonicAt(1, 'S');
    tabs.setMnemonicAt(2, '�');
    // ������������ ��������� �������
    tabs.setEnabledAt(2, false);
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