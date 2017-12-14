// PreviewingFiles.java
// ��������������� �������� ������
// � ���������� JFileChooser
import javax.swing.*;
import javax.swing.filechooser.*;
import java.beans.*;
import java.awt.*;

public class PreviewingFiles extends JFrame {
  public PreviewingFiles() {
    super("PreviewingFiles");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // ������� ���� �� �����
    setSize(300, 200);
    setVisible(true);
    // ����������� ��������� ��� ������ �����
    JFileChooser chooser = new JFileChooser();
    chooser.setDialogTitle("�������� �����������");
    // ������������ ������
    chooser.setFileFilter(new ImageFilesFilter());
    // ������� ������������� ������
    chooser.setAcceptAllFileFilterUsed(false);
    // ������������ �������������� ���������
    Previewer previewer = new Previewer();
    chooser.setAccessory(previewer);
    // ������������ � �������� ���������
    chooser.addPropertyChangeListener(previewer);
    // ������� ���������� ���� �� �����
    int res = chooser.showOpenDialog(this);
    if ( res == JFileChooser.APPROVE_OPTION )
      JOptionPane.showMessageDialog(
          this, chooser.getSelectedFile());
  }
  // ��������� ��� ���������������� ���������
  class Previewer extends JPanel
      implements PropertyChangeListener {
    private JLabel label;
    public Previewer() {
      // ����������� ���������
      setLayout(new BorderLayout());
      setPreferredSize(new Dimension(200, 200));
      // ������� ������� � ������ ���������
      label = new JLabel();
      JScrollPane scroller = new JScrollPane(label);
      add(scroller);
    }
    public void propertyChange(PropertyChangeEvent e) {
      if ( e.getPropertyName().equals(
          JFileChooser.SELECTED_FILE_CHANGED_PROPERTY)) {
        // �������� ��������� ����, ������� ���
        if ( e.getNewValue() != null )
          label.setIcon(new ImageIcon(
              e.getNewValue().toString()));
      }
    }
  }
  // ������, ���������� ����� � �������������
  class ImageFilesFilter extends FileFilter {
    // ��������� ���� ��� ���������� ���
    public boolean accept(java.io.File file) {
      // ��� �������� ���������
      if ( file.isDirectory() ) return true;
      // ��� ����� �� ����� ��������� �������
      String name = file.getName().toLowerCase();
      // ��� ������ ������� �� ����������
      return ( name.endsWith(".jpg") ||
          name.endsWith(".gif") || name.endsWith(".png") );
    }
    // ���������� �������� �������
    public String getDescription() {
      return "����������� (*.jpg, *.gif, *.png)";
    }
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new PreviewingFiles(); } });
  }
}
