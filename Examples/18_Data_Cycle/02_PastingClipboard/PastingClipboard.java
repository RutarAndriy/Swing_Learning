// PastingClipboard.java
// Вставка даних в системний буфер обміну
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.datatransfer.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Arrays;

public class PastingClipboard extends JFrame {
  private JTextArea textArea;
  public PastingClipboard() {
    super("PastingClipboard");
    // вихід при закриванні вікна
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // додамо кнопку для вставки даних
    JButton copyButton = new JButton("Копіювати");
    // текстове поле для отримання тексту
    textArea = new JTextArea();
    copyButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // буфер обміну
        Clipboard clipboard = Toolkit.getDefaultToolkit().
            getSystemClipboard();
        // вставимо у буфер наші адаптовані дані
        clipboard.setContents(new ComplexTransferable(), null);
      }
    });
    add(new JScrollPane(textArea));
    add(copyButton, "South");
    // виведемо вікно на екран
    setSize(400, 300);
    setVisible(true);
  }
  // об'єкт-адаптер для наших даних
  class ComplexTransferable implements Transferable {
    // список підтримуваних типів даних
    private DataFlavor[] supportedTypes = new DataFlavor[]
        { DataFlavor.stringFlavor, DataFlavor.imageFlavor };
    public DataFlavor[] getTransferDataFlavors() {
      return supportedTypes;
    }
    public boolean isDataFlavorSupported(DataFlavor flavor) {
      return Arrays.asList(supportedTypes).contains(flavor);
    }
    public Object getTransferData(DataFlavor flavor)
        throws UnsupportedFlavorException, IOException {
      if ( flavor == DataFlavor.imageFlavor ) {
        // якщо запитано зображення, вернемо червоний квадрат
        BufferedImage bi = new
            BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
        Graphics g = bi.getGraphics();
        g.setColor(Color.RED);
        g.fillRect(0, 0, 100, 100);
        return bi;
      } else if ( flavor == DataFlavor.stringFlavor ) {
        // якщо запрошено строку, вернемо виділений текст
        return textArea.getSelectedText();
      }
      // виняток у випадку невідомого типу даних
      throw new UnsupportedFlavorException(flavor);
    }
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
      new Runnable() {
        public void run() { new PastingClipboard(); } });
  }
}
