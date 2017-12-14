// FilteringFiles.java
// ������� ������ � ���������� JFileChooser
import javax.swing.*;
import javax.swing.filechooser.*;
import java.awt.*;

public class FilteringFiles extends JFrame {
  public FilteringFiles() {
    super("FilteringFiles");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // ������� ���� �� �����
    setSize(300, 200);
    setVisible(true);
    // ����������� ��������� ��� ������ �����
    JFileChooser chooser = new JFileChooser();
    chooser.setDialogTitle("�������� ��������� ����");
    // ������������ ������
    chooser.addChoosableFileFilter(
        new TextFilesFilter());
    chooser.setFileFilter(
        new TextFilesFilter());
    // ������� ���������� ���� �� �����
    int res = chooser.showOpenDialog(this);
    if ( res == JFileChooser.APPROVE_OPTION )
      JOptionPane.showMessageDialog(
          this, chooser.getSelectedFile());
  }
  // ������, ���������� ��������� �����
  class TextFilesFilter extends FileFilter {
    // ��������� ���� ��� ���������� ���
    public boolean accept(java.io.File file) {
      // ��� �������� ���������
      if ( file.isDirectory() ) return true;
      // ��� ������ ������� �� ����������
      return ( file.getName().endsWith(".txt") );
    }
    // ���������� �������� �������
    public String getDescription() {
      return "��������� ����� (*.txt)";
    }
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new FilteringFiles(); } });
  }
}
