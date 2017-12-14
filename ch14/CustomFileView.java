// CustomFileView.java
// ������� ��� ������ � ���������� JFileChooser
import javax.swing.*;
import javax.swing.filechooser.*;
import java.awt.*;

public class CustomFileView extends JFrame {
  public CustomFileView() {
    super("CustomFileView");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // ������� ���� �� �����
    setSize(300, 200);
    setVisible(true);
    // ����������� ��������� ��� ������ ������
    JFileChooser chooser = new JFileChooser();
    chooser.setDialogTitle("�������� ����");
    chooser.setFileView(new NewFileView(
        chooser.getFileSystemView()));
    // ���������� ���������� ����
    int res = chooser.showOpenDialog(this);
  }
  // ������, ������������ ������� ��� ������
  class NewFileView extends FileView {
    // ������, ����������� ��� ������
    private Icon fileIcon = new ImageIcon("file.gif");
    private Icon folderIcon = new ImageIcon("folder.gif");
    // ������������ ���������� �������� �������� �������
    public NewFileView(FileSystemView fileSystem) {
      this.fileSystem = fileSystem;
    }
    private FileSystemView fileSystem;
    // ���������� ������ ��� �����
    public Icon getIcon(java.io.File file) {
      // �������� ����� �������� ������� ����������
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
