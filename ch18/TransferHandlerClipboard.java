// TransferHandlerClipboard.java
// ����������� � ����� � ������� TransferHandler
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TransferHandlerClipboard extends JFrame {
  public TransferHandlerClipboard() {
    super("TransferHandlerClipboard");
    // ����� ��� �������� ����
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // ������� ������
    DefaultListModel model = new DefaultListModel();
    model.addElement("���");
    model.addElement("���");
    // ������ �� ��������
    final JList list = new JList(model);
    list.setTransferHandler(new ListDrag.ListTransferHandler(list));
    list.setDragEnabled(true);
    list.setDropMode(DropMode.INSERT);
    add(new JScrollPane(list));
    JButton copy = new JButton("���������� � �����");
    copy.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // ���������� ��� ������ �������
        e.setSource(list);
        // �������� ����������� ������� �����������
        TransferHandler.getCopyAction().actionPerformed(e);
      }
    });
    add(copy, "South");
    // ������� ���� �� �����
    setSize(400, 300);
    setVisible(true);
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new TransferHandlerClipboard(); } });
  }
}