// HTMLabel.java
// ������������� � �������� ����� HTML
import javax.swing.*;

public class HTMLabel extends JFrame {
  private String html1 =
      "<html><b>�����</b><font size=5 color=red> HTML";
  private String html2 =
      "<html><font size=4 color=blue>" +
          "<ul>������:<li>����<li>���";
  private String html3 =
      "<html><body bgcolor=white><h2>����� ���� ����";
  private String html4 =
      "<html><h2>�����������:<img src=\"file:monkey.gif\">";
  public HTMLabel() {
    super("HTMLabel");
    // ��� �������� ���� �����
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // ��������� �������
    JPanel contents = new JPanel();
    contents.add(new JLabel(html1));
    contents.add(new JLabel(html2));
    contents.add(new JLabel(html3));
    contents.add(new JLabel(html4));
    // ������� ���� �� �����
    add(contents);
    setSize(400, 300);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new HTMLabel(); } });
  }
}