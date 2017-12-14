// UsingTableHeader.java
// ��������� ��������� ������� JTableHeader
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.border.*;
import java.awt.*;

public class UsingTableHeader extends JFrame {
  // ������ ��� �������
  private String[][] data = {
      { "����", "+18 �" },
      { "����", "+22 �" },
      { "������", "+19 �" }
  };
  // �������� ��������
  private String[] columnNames = {
      "�����", "������� �����������"
  };
  public UsingTableHeader() {
    super("UsingTableHeader");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // ������� �������
    JTable table = new JTable(data, columnNames);
    table.setAutoCreateRowSorter(true);
    // ����������� ��������� �������
    JTableHeader header = table.getTableHeader();
    header.setReorderingAllowed(false);
    header.setResizingAllowed(false);
    // ������������ ������������ ������
    header.setDefaultRenderer(new HeaderRenderer());
    // ��������� ������� � ������ ���������
    add(new JScrollPane(table));
    setSize(400, 300);
    setVisible(true);
  }
  // ����������� ������������ ������ ��� ���������
  class HeaderRenderer
      extends DefaultTableCellRenderer {
    // ����� ���������� ��������� ��� ����������
    public Component getTableCellRendererComponent(
        JTable table, Object value, boolean isSelected,
        boolean hasFocus, int row, int column) {
      // �������� ����������� ������� �� �������� ������
      JLabel label = (JLabel)super.
          getTableCellRendererComponent(table,
              value, isSelected, hasFocus,
              row, column);
      // ����������� ������ ����� � ���� ����
      label.setBackground(Color.gray);
      label.setBorder(border);
      return label;
    }
    private Border border = BorderFactory.
        createMatteBorder(16, 16, 16, 16,
            new ImageIcon("bullet.png"));
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new UsingTableHeader(); } });
  }
}
