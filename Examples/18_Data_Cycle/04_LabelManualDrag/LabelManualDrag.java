// LabelManualDrag.java
// Перетягування і вставка даних "вручну"
import javax.swing.*;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;

public class LabelManualDrag extends JFrame {
  public LabelManualDrag() {
    super("ListDrag");
    // вихід при закриванні вікна
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    final JLabel label = new JLabel("Просто текст!");
    // стандартний спосіб обміну властивістю "text"
    label.setTransferHandler(new TransferHandler("text"));
    // момент початку перетягування
    label.addMouseMotionListener(new MouseMotionAdapter() {
      public void mouseDragged(MouseEvent e) {
        TransferHandler handler = label.getTransferHandler();
        // виклик системного перетягування
        handler.exportAsDrag(label, e, TransferHandler.COPY);
      }
    });
    // додамо текстове поле і напис на екран
    add(new JScrollPane(new JTextArea()));
    add(label, "South");
    // виведемо вікно на екран
    setSize(400, 300);
    setVisible(true);
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new LabelManualDrag(); } });
  }
}
