// TextHighlights.java
// �������������� ��������� ������
import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;

public class TextHighlights extends JFrame {
  public TextHighlights() {
    super("TextHighlights");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // ������� � ����������� ����
    JTextArea area =
        new JTextArea("������ ���!");
    try {
      // ������� ���������� �������� ������� �����
      Object reference =
          area.getHighlighter().
              addHighlight(0, 6,
                  new DefaultHighlighter.
                      DefaultHighlightPainter(Color.YELLOW));
    } catch (BadLocationException e) {
      e.printStackTrace();
    }
    // ��������� ���� � ����
    add(new JScrollPane(area));
    // ������� ���� �� �����
    setSize(300, 200);
    setVisible(true);
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new TextHighlights(); } });
  }
}