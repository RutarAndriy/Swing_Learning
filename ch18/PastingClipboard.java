// PastingClipboard.java
// ������� ������ � ��������� ����� ������
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
    // ����� ��� �������� ����
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // ������� ������ ��� ������� ������
    JButton copyButton = new JButton("����������");
    // ��������� ���� ��� ��������� ������
    textArea = new JTextArea();
    copyButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // ����� ������
        Clipboard clipboard = Toolkit.getDefaultToolkit().
            getSystemClipboard();
        // ������� � ����� ���� �������������� ������
        clipboard.setContents(new ComplexTransferable(), null);
      }
    });
    add(new JScrollPane(textArea));
    add(copyButton, "South");
    // ������� ���� �� �����
    setSize(400, 300);
    setVisible(true);
  }
  // ������-������� ��� ����� ������
  class ComplexTransferable implements Transferable {
    // ������ �������������� ����� ������
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
        // ���� ��������� �����������, ������ ������� �������
        BufferedImage bi = new
            BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
        Graphics g = bi.getGraphics();
        g.setColor(Color.RED);
        g.fillRect(0, 0, 100, 100);
        return bi;
      } else if ( flavor == DataFlavor.stringFlavor ) {
        // ���� ��������� ������, ������ ���������� �����
        return textArea.getSelectedText();
      }
      // ���������� � ������ ������������ ���� ������
      throw new UnsupportedFlavorException(flavor);
    }
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new PastingClipboard(); } });
  }
}