// ListDrag.java
// Перетягування і вставка даних та TransferHandler
import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;

public class ListDrag extends JFrame {
  // початкові дані для списків
  private String[] listData =
      new String[] { "Раз", "Два", "Три" };
  public ListDrag() {
    super("ListDrag");
    // Виходимо при закриванні вікна
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // створюємо моделі
    DefaultListModel model1 = new DefaultListModel(),
        model2 = new DefaultListModel();
    for (String element: listData) {
      model1.addElement(element);
      model2.addElement(element);
    }
    // створюємо списки
    JList list1 = new JList(model1);
    list1.setTransferHandler(new ListTransferHandler(list1));
    list1.setDragEnabled(true);
    JList list2 = new JList(model2);
    list2.setTransferHandler(new ListTransferHandler(list2));
    list2.setDragEnabled(true);
    // додамо списки на екран
    setLayout(new GridLayout(1, 2));
    add(new JScrollPane(list1));
    add(new JScrollPane(list2));
    // виводимо вікно на екран
    setSize(400, 300);
    setVisible(true);
  }
  // об'єкт-адаптер для списків та їхніх даних
  static class ListTransferHandler extends TransferHandler {
    private JList list;
    public ListTransferHandler(JList list) {
      this.list = list;
    }
    @Override
    public int getSourceActions(JComponent c) {
      // Дані можуть копіюватися табо переміщуватися
      return TransferHandler.COPY_OR_MOVE;
    }
    @Override
    public boolean canImport(TransferSupport support) {
      // підтримується імпорт лише строкових даних
      return support.isDataFlavorSupported(
          DataFlavor.stringFlavor);
    }
    @Override
    protected Transferable createTransferable(JComponent c) {
      // стандартний спосіб адаптувати строку для обміну
      return new StringSelection(
          list.getSelectedValue().toString());
    }
    @Override
    public boolean importData(TransferSupport support) {
      if ( support.isDataFlavorSupported(DataFlavor.stringFlavor) ) {
        try {
          // додаємо в модель нову строку на вибрану позицію
          ((DefaultListModel)list.getModel()).
              add(list.locationToIndex(
                  support.getDropLocation().getDropPoint()),
                  // отримання строки із Transferable
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
