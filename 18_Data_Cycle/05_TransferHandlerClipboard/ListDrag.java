// ListDrag.java
// Перетягування і вставка даних та TransferHandler
import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;

public class ListDrag extends JFrame {
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
    @SuppressWarnings("unchecked")
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
}
