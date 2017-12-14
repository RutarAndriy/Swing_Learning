// ControllingCaret.java
// ���������� ��������� ��������
import javax.swing.*;
import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;
import javax.swing.text.*;
import java.awt.*;

public class ControllingCaret extends JFrame {
  public ControllingCaret() {
    super("ControllingCaret");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // ������������� ��������� ����
    final JTextArea textArea = new JTextArea();
    // ������� �����
    textArea.append("������ �����-�� �����");
    // ��������� ������� � ��������� ������
    Caret caret = textArea.getCaret();
    caret.setBlinkRate(50);
    caret.setDot(5);
    caret.moveDot(10);
    // ������� ��������� ���� � ����
    add(new JScrollPane(textArea));
    // ������� ��� ����� � �������
    final JLabel label = new JLabel();
    add(label, "South");
    // ��������� ����������� �������
    textArea.addCaretListener(new CaretListener() {
      public void caretUpdate(CaretEvent e) {
        // ������� ����� � �������
        try {
          // ������ � ����� ����� �� �������
          int wordStart =
              Utilities.getWordStart(textArea, e.getDot());
          int wordEnd =
              Utilities.getWordEnd(textArea, e.getDot());
          label.setText(textArea.getText(
              wordStart, wordEnd - wordStart));
        } catch (BadLocationException ex) {
          ex.printStackTrace();
        }
      }
    });
    // ������� ���� �� �����
    setSize(400, 300);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new ControllingCaret(); } });
  }
}
