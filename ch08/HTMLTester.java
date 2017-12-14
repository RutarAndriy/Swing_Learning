// HTMLTester.java
// ��������� ����� ����������� ���������
// ������������� HTML �� ����������� Swing
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HTMLTester extends JFrame {
  public HTMLTester() {
    super("HTMLTester");
    setDefaultCloseOperation( EXIT_ON_CLOSE );
    // �������� ��������� � �������� �������
    createGUI();
    attachListeners();
    // ������� ���� �� �����
    setSize(400, 300);
    setVisible(true);
  }
  private JTextArea html;
  private JLabel result;
  private JButton update;
  private void createGUI() {
    // � �������� ������ ���������� �������
    JPanel p = new JPanel(new GridLayout(1, 2, 5, 5));
    p.setBorder(
        BorderFactory.createEmptyBorder(12, 12, 12, 12));
    // �������� ������������
    JPanel vertical = new JPanel(new BorderLayout());
    // ��������� ���������� ����
    JScrollPane scroller = new JScrollPane(
        html = new JTextArea());
    html.setLineWrap(true);
    html.append("<html>");
    // ��������� ��������� ���� � �������
    vertical.add(new JLabel("��� HTML:"), "North");
    vertical.add(scroller);
    // ������ ���������� ������
    update = new JButton("��������");
    getContentPane().add(update, "South");
    // ������� � �����������
    JPanel resultPanel = new JPanel(new BorderLayout());
    result = new JLabel();
    resultPanel.add(new JLabel("���������:"), "North");
    resultPanel.add(new JScrollPane(result));
    // ������������� ������� �������
    p.add(vertical);
    p.add(resultPanel);
    getContentPane().add(p);
  }
  private void attachListeners() {
    update.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // ������������� � ������� ����� �����
        result.setText(html.getText());
      }
    });
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new HTMLTester(); } });
  }
}
