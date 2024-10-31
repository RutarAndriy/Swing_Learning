// FilteringFiles.java
// Фільтри файлів в компоненті JFileChooser
import javax.swing.*;
import javax.swing.filechooser.*;
import java.awt.*;

public class FilteringFiles extends JFrame {
  public FilteringFiles() {
    super("FilteringFiles");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // виводимо вікно на екран
    setSize(300, 200);
    setVisible(true);
    // налаштовуємо компонент для вибору файлів
    JFileChooser chooser = new JFileChooser();
    chooser.setDialogTitle("Виберіть текстовий файл");
    // приєднюємо фільт
    chooser.addChoosableFileFilter(
        new TextFilesFilter());
    chooser.setFileFilter(
        new TextFilesFilter());
    // виводимо діалогове вікно на екран
    int res = chooser.showOpenDialog(this);
    if ( res == JFileChooser.APPROVE_OPTION )
      JOptionPane.showMessageDialog(
          this, chooser.getSelectedFile());
  }
  // фільтр, відбираючий текстові файли
  class TextFilesFilter extends FileFilter {
    // приймаємо файл або відказуємо йому
    public boolean accept(java.io.File file) {
      // всі каталоги приймаємо
      if ( file.isDirectory() ) return true;
      // для файлів дивимося на розширення
      return ( file.getName().endsWith(".txt") );
    }
    // повертаємо опис фільтру
    public String getDescription() {
      return "Текстові файли (*.txt)";
    }
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new FilteringFiles(); } });
  }
}
