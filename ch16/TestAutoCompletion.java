// TestAutoCompletion.java
// �������� ������ ���������� ���� �
// �������������� �����������
import com.porty.swing.*;
import javax.swing.*;
import java.awt.*;

public class TestAutoCompletion extends JFrame {
  public TestAutoCompletion() {
    super("TestAutoCompletion");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // ������� � ����������� ����
    JTextField field =
        new JTextField();
    field.setColumns(15);
    // ����� ��� ��������������
    AutoCompleteTextDocument doc =
        new AutoCompleteTextDocument(field);
    doc.addWord("����������");
    doc.addWord("������������");
    // ��������� ���� � ����
    setLayout(new FlowLayout());
    add(field);
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
