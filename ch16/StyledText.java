// StyledText.java
// ������� ����������� ��������� JTextPane
import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;

public class StyledText extends JFrame {
  public StyledText() {
    super("StyledText");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // �������� ��������
    JTextPane textPane = new JTextPane();
    // �������� ��������� � ������
    createDocument(textPane);
    // ������� �������� � ����
    add(new JScrollPane(textPane));
    // ������� ���� �� �����
    setSize(400, 300);
    setVisible(true);
  }
  private void createDocument(JTextPane tp) {
    // ��������� ������
    // ����� ��������� ������
    Style normal = tp.addStyle("Normal", null);
    StyleConstants.setFontFamily(normal, "Verdana");
    StyleConstants.setFontSize(normal, 13);
    // ���������
    Style heading = tp.addStyle("Heading", normal);
    StyleConstants.setFontSize(heading, 20);
    StyleConstants.setBold(heading, true);
    // ��������� �������� ����������, ��������� �����
    insertString("�������������� ���������", tp, heading);
    insertString("����� ���� ������� ����������,", tp, normal);
    insertString("���������� ������ Normal.", tp, normal);
    insertString("��� ���� ���������", tp, heading);
    // ������ ����������� ����� ������
    SimpleAttributeSet red = new SimpleAttributeSet();
    StyleConstants.setForeground(red, Color.red);
    StyledDocument doc = tp.getStyledDocument();
    doc.setCharacterAttributes(5, 5, red, false);
    // ������� ��������� � ����� ������
    tp.setCaretPosition(doc.getLength());
    JCheckBox check = new JCheckBox("��� ��������!");
    check.setOpaque(false);
    tp.insertComponent(check);
  }
  // ��������� ������ � ����� ��������� � ���������,
  // ��������� �������� ����� ����������
  private void insertString(String s, JTextPane tp, Style style) {
    try {
      Document doc = tp.getDocument();
      doc.insertString(doc.getLength(), s + "\n", style);
    } catch (BadLocationException ex) {
      ex.printStackTrace();
    }
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new StyledText(); } });
  }
}