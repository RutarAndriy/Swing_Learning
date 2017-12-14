// RegisteringTableRenderer.java
// ����������� � ������� ������������
// ������� ��� �����������
import javax.swing.*;
import javax.swing.table.*;
import com.porty.swing.*;
import java.awt.*;

public class RegisteringTableRenderer extends JFrame {
  public RegisteringTableRenderer() {
    super("RegisteringTableRenderer");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // ������� ������� �� ������ ����� ������
    JTable table = new JTable(new SpecialModel());
    // ������������ ������ ��� ���������� ����� ������
    table.setDefaultRenderer(ImageListElement.class,
        new ImageTableCellRenderer());
    // ������� ���� �� �����
    add(new JScrollPane(table));
    pack();
    setVisible(true);
  }
  // ������ �������
  class SpecialModel extends AbstractTableModel {
    // ������
    private Icon
        image1 = new ImageIcon("clip1.gif"),
        image2 = new ImageIcon("clip2.gif");
    // �������� ��������
    private String[] columnNames = {
        "��������", "�����"
    };
    // ������ �������
    private Object[][] data = {
        { new ImageListElement(image1, "MegaWorks"),
            "<html><font color=\"red\">�����" },
        { new ImageListElement(image2, "TerraMedia"),
            "<html><b>�.-���������" }
    };
    // ���������� ��������
    public int getColumnCount() {
      return columnNames.length;
    }
    // �������� ��������
    public String getColumnName(int column) {
      return columnNames[column];
    }
    // ���������� �����
    public int getRowCount() {
      return data.length;
    }
    // ��� ������ �������
    public Class getColumnClass(int column) {
      return data[0][column].getClass();
    }
    // �������� � ������
    public Object getValueAt(int row, int column) {
      return data[row][column];
    }
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new RegisteringTableRenderer(); } });
  }
}