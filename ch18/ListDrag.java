// ListDrag.java
// �������������� � ������� ������ � TransferHandler
import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;

public class ListDrag extends JFrame {
  // ��������� ������ ��� �������
  private String[] listData =
      new String[] { "���", "���", "���" };
  public ListDrag() {
    super("ListDrag");
    // ����� ��� �������� ����
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // ������� ������
    DefaultListModel model1 = new DefaultListModel(),
        model2 = new DefaultListModel();
    for (String element: listData) {
      model1.addElement(element);
      model2.addElement(element);
    }
    // ������� ������
    JList list1 = new JList(model1);
    list1.setTransferHandler(new ListTransferHandler(list1));
    list1.setDragEnabled(true);
    JList list2 = new JList(model2);
    list2.setTransferHandler(new ListTransferHandler(list2));
    list2.setDragEnabled(true);
    // ������� ������ �� �����
    setLayout(new GridLayout(1, 2));
    add(new JScrollPane(list1));
    add(new JScrollPane(list2));
    // ������� ���� �� �����
    setSize(400, 300);
    setVisible(true);
  }
  // ������-������� ��� ������� � �� ������
  static class ListTransferHandler extends TransferHandler {
    private JList list;
    public ListTransferHandler(JList list) {
      this.list = list;
    }
    @Override
    public int getSourceActions(JComponent c) {
      // ������ ����� ������������ ��� ������������
      return TransferHandler.COPY_OR_MOVE;
    }
    @Override
    public boolean canImport(TransferSupport support) {
      // �������������� ������ ������ ��������� ������
      return support.isDataFlavorSupported(
          DataFlavor.stringFlavor);
    }
    @Override
    protected Transferable createTransferable(JComponent c) {
      // ����������� ������ ������������ ������ ��� ������
      return new StringSelection(
          list.getSelectedValue().toString());
    }
    @Override
    public boolean importData(TransferSupport support) {
      if ( support.isDataFlavorSupported(DataFlavor.stringFlavor) ) {
        try {
          // ��������� � ������ ����� ������ �� ��������� �������
          ((DefaultListModel)list.getModel()).
              add(list.locationToIndex(
                  support.getDropLocation().getDropPoint()),
                  // ��������� ������ �� Transferable
                  support.getTransferable().
                      getTransferData(DataFlavor.stringFlavor));
          return true;
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
      return false;
    }
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new ListDrag(); } });
  }
}