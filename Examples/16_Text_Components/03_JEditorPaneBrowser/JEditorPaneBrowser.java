// JEditorPaneBrowser.java
// Простий браузер на основі редактора JEditorPane
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class JEditorPaneBrowser extends JFrame {
  // наш редактор
  private JEditorPane editor;
  // текстове поле з адресою
  private JTextField address;
  public JEditorPaneBrowser() {
    super("JEditorPaneBrowser");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // створюємо користувацький інтерфейс
    createGUI();
    // виводимо вікно на екран
    setSize(500, 400);
    setVisible(true);
  }
  // налаштування користувацького інтерфейсу
  private void createGUI() {
    // панель із адресною строкою
    JPanel addressPanel = new JPanel();
    addressPanel.setLayout(
        new FlowLayout(FlowLayout.LEFT));
    addressPanel.setBorder(BorderFactory.
        createEmptyBorder(5, 5, 5, 5));
    // поле для адреси
    address = new JTextField(30);
    // прослуховувач завершення вводу
    address.addActionListener(new NewAddressAction());
    addressPanel.add(new JLabel("Адреса:"));
    addressPanel.add(address);
    // налаштовуємо редактор
    try {
      // шляхо до ресурсів можна записувати
      // повністю, разом із протоколами
      editor = new JEditorPane("http://java.sun.com");
    } catch (Exception ex) {
      JOptionPane.showMessageDialog(
          this, "Адреса недоступна");
    }
    editor.setContentType("text/html");
    editor.setEditable(false);
    // підтримка посилань
    editor.addHyperlinkListener(new HyperlinkL());
    // додаємо все у вікно
    add(addressPanel, "North");
    add(new JScrollPane(editor));
  }
  // прослуховувач, отримуючий повідомлення про ввід нової адреси
  class NewAddressAction implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      // переходимо по адресі
      String newAddress = address.getText();
      try {
        editor.setPage(newAddress);
      } catch (Exception ex) {
        JOptionPane.showMessageDialog(
            JEditorPaneBrowser.this,"Адреса недоступна");
      }
    }
  }
  // прослуховувач, забезпечуючий підтримку посилань
  class HyperlinkL implements HyperlinkListener {
    public void hyperlinkUpdate(HyperlinkEvent he) {
      // чи потрібний це тип події
      if ( he.getEventType() ==
          HyperlinkEvent.EventType.ACTIVATED ) {
        // переходимо по адресі
        try {
          editor.setPage(he.getURL());
        } catch (Exception ex) {
          JOptionPane.showMessageDialog(
              JEditorPaneBrowser.this,"Адреса недоступна");
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
