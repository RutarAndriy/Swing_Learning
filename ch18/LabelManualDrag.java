// LabelManualDrag.java
// �������������� � ������� ������ "�������"
import javax.swing.*;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;

public class LabelManualDrag extends JFrame {
  public LabelManualDrag() {
    super("ListDrag");
    // ����� ��� �������� ����
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    final JLabel label = new JLabel("������ �����!");
    // ����������� ������ ������ ��������� "text"
    label.setTransferHandler(new TransferHandler("text"));
    // ������ ������ ��������������
    label.addMouseMotionListener(new MouseMotionAdapter() {
      public void mouseDragged(MouseEvent e) {
        TransferHandler handler = label.getTransferHandler();
        // ����� ���������� ��������������
        handler.exportAsDrag(label, e, TransferHandler.COPY);
      }
    });
    // ������� ��������� ���� � ������� �� �����
    add(new JScrollPane(new JTextArea()));
    add(label, "South");
    // ������� ���� �� �����
    setSize(400, 300);
    setVisible(true);
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new LabelManualDrag(); } });
  }
}