// CustomFileView.java
// Зовнішній вигляд файлів у компоненті JFileChooser
import javax.swing.*;
import javax.swing.filechooser.*;
import java.awt.*;

public class CustomFileView extends JFrame {
  public CustomFileView() {
    super("CustomFileView");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // виводимо вікно на екран
    setSize(300, 200);
    setVisible(true);
    // налаштовуємо компонент для вибору файлів
    JFileChooser chooser = new JFileChooser();
    chooser.setDialogTitle("Виберіть файл");
    chooser.setFileView(new NewFileView(
        chooser.getFileSystemView()));
    // показуємо діалогове вікно
    int res = chooser.showOpenDialog(this);
  }
  // об'єкт, визначаючий зовнішній вигляд файлів
  class NewFileView extends FileView {
    // значки, що застосовуються для файлів
    private Icon fileIcon = new ImageIcon("File.gif");
    private Icon folderIcon = new ImageIcon("Folder.gif");
    // конструктору необхідний опис файлової системи
    public NewFileView(FileSystemView fileSystem) {
      this.fileSystem = fileSystem;
    }
    private FileSystemView fileSystem;
    // повертаємо значок для файлу
    public Icon getIcon(java.io.File file) {
      // основні частини файлової системи пропускаємо
      if ( fileSystem.isRoot(file) ||
          fileSystem.isDrive(file) )
        return null;
      if ( file.isDirectory() )
        return folderIcon;
      else return fileIcon;
    }
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new CustomFileView(); } });
  }
}
