// ContentPaneAdd.java
// ������ ������ �����������
import javax.swing.*;
import java.awt.*;

public class ContentPaneAdd extends JFrame {
  public ContentPaneAdd() {
    super("ContentPaneAdd");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // �������� ������ � ����� ��������
    JPanel contents = new JPanel();
    contents.add(new JButton("����"));
    contents.add(new JButton("���"));
    // ������� ������ �����������
    setContentPane(contents);
    // ������� ���� �� �����
    setSize(200, 100);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new ContentPaneAdd(); } });
  }
}
