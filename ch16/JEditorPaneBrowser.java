// JEditorPaneBrowser.java
// ������� ������� �� ������ ��������� JEditorPane
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class JEditorPaneBrowser extends JFrame {
  // ��� ��������
  private JEditorPane editor;
  // ��������� ���� � �������
  private JTextField address;
  public JEditorPaneBrowser() {
    super("JEditorPaneBrowser");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // ������� ���������������� ���������
    createGUI();
    // ������� ���� �� �����
    setSize(500, 400);
    setVisible(true);
  }
  // ��������� ����������������� ����������
  private void createGUI() {
    // ������ � �������� �������
    JPanel addressPanel = new JPanel();
    addressPanel.setLayout(
        new FlowLayout(FlowLayout.LEFT));
    addressPanel.setBorder(BorderFactory.
        createEmptyBorder(5, 5, 5, 5));
    // ���� ��� ������
    address = new JTextField(30);
    // ��������� ��������� �����
    address.addActionListener(new NewAddressAction());
    addressPanel.add(new JLabel("�����:"));
    addressPanel.add(address);
    // ����������� ��������
    try {
      // ���� � �������� ����� ����������
      // ���������, ������ � �����������
      editor = new JEditorPane("http://java.sun.com");
    } catch (Exception ex) {
      JOptionPane.showMessageDialog(
          this, "����� ����������");
    }
    editor.setContentType("text/html");
    editor.setEditable(false);
    // ��������� ������
    editor.addHyperlinkListener(new HyperlinkL());
    // ��������� ��� � ����
    add(addressPanel, "North");
    add(new JScrollPane(editor));
  }
  // ���������, ���������� ����������� � ����� ������ ������
  class NewAddressAction implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      // ��������� �� ������
      String newAddress = address.getText();
      try {
        editor.setPage(newAddress);
      } catch (Exception ex) {
        JOptionPane.showMessageDialog(
            JEditorPaneBrowser.this,"����� ����������");
      }
    }
  }
  // ���������, �������������� ��������� ������
  class HyperlinkL implements HyperlinkListener {
    public void hyperlinkUpdate(HyperlinkEvent he) {
      // ������ �� ��� ��� �������
      if ( he.getEventType() ==
          HyperlinkEvent.EventType.ACTIVATED ) {
        // ��������� �� ������
        try {
          editor.setPage(he.getURL());
        } catch (Exception ex) {
          JOptionPane.showMessageDialog(
              JEditorPaneBrowser.this,"����� ����������");
        }
      }
    }
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new JEditorPaneBrowser(); } });
  }
}