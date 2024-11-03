// TransferHandlerClipboard.java
// Копіювання в буфер із допомогою TransferHandler
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TransferHandlerClipboard extends JFrame {
  public TransferHandlerClipboard() {
    super("TransferHandlerClipboard");
    // вихід при закриванні вікна
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // створюємо модель
    DefaultListModel model = new DefaultListModel();
    model.addElement("Раз");
    model.addElement("Два");
    // список із рядками
    final JList list = new JList(model);
    list.setTransferHandler(new ListDrag.ListTransferHandler(list));
    list.setDragEnabled(true);
    list.setDropMode(DropMode.INSERT);
    add(new JScrollPane(list));
    JButton copy = new JButton("Копіювати в буфер");
    copy.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // необхідно для роботи команди
        e.setSource(list);
        // викликаємо стандартну команду копіювання
        TransferHandler.getCopyAction().actionPerformed(e);
      }
    });
    add(copy, "South");
    // виводимо вікно на екран
    setSize(400, 300);
    setVisible(true);
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new TransferHandlerClipboard(); } });
  }
}
