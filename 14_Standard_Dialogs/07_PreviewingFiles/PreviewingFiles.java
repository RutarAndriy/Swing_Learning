// PreviewingFiles.java
// Попередній перегляд файлів
// у компоненті JFileChooser
import javax.swing.*;
import javax.swing.filechooser.*;
import java.beans.*;
import java.awt.*;

public class PreviewingFiles extends JFrame {
  public PreviewingFiles() {
    super("PreviewingFiles");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // виводимо вікно на екран
    setSize(300, 200);
    setVisible(true);
    // налаштовуємо компонент для вибору файлу
    JFileChooser chooser = new JFileChooser();
    chooser.setDialogTitle("Виберіть зображення");
    // приєднюємо фільтр
    chooser.setFileFilter(new ImageFilesFilter());
    // забираємо універсальний фільтр
    chooser.setAcceptAllFileFilterUsed(false);
    // приєднюємо додатковий компонент
    Previewer previewer = new Previewer();
    chooser.setAccessory(previewer);
    // реєструємо в якості прослуховувача
    chooser.addPropertyChangeListener(previewer);
    // виводимо діалогове вікно на екран
    int res = chooser.showOpenDialog(this);
    if ( res == JFileChooser.APPROVE_OPTION )
      JOptionPane.showMessageDialog(
          this, chooser.getSelectedFile());
  }
  // компонент для попереднього перегляду
  class Previewer extends JPanel
      implements PropertyChangeListener {
    private JLabel label;
    public Previewer() {
      // налаштовуємо контейнер
      setLayout(new BorderLayout());
      setPreferredSize(new Dimension(200, 200));
      // створюємо напис в панелі прокрутки
      label = new JLabel();
      JScrollPane scroller = new JScrollPane(label);
      add(scroller);
    }
    public void propertyChange(PropertyChangeEvent e) {
      if ( e.getPropertyName().equals(
          JFileChooser.SELECTED_FILE_CHANGED_PROPERTY)) {
        // змінився вибраний файл, покажемо його
        if ( e.getNewValue() != null )
          label.setIcon(new ImageIcon(
              e.getNewValue().toString()));
      }
    }
  }
  // фільтр, відбираючий файли із зображеннями
  class ImageFilesFilter extends FileFilter {
    // приймаємо файл або відмовляємо йому
    public boolean accept(java.io.File file) {
      // всі каталоги приймаємо
      if ( file.isDirectory() ) return true;
      // ім'я файлу не буде враховувати регістр
      String name = file.getName().toLowerCase();
      // для файлів дивимося на розширення
      return ( name.endsWith(".jpg") ||
          name.endsWith(".gif") || name.endsWith(".png") );
    }
    // повертає опис фільтру
    public String getDescription() {
      return "Зображення (*.jpg, *.gif, *.png)";
    }
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new PreviewingFiles(); } });
  }
}
