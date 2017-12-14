// FilterAndSelection.java
// ��������� ���������� ������� � ���������� ������
import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.TableRowSorter;
import java.awt.*;

public class FilterAndSelection extends JFrame {
  public FilterAndSelection() {
    super("FilterAndSelection");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // ������� ������� �� ������ ������ �� ���������
    SimpleSorting.SortModel sm = new SimpleSorting.SortModel();
    sm.setColumnCount(4);
    // ��������� ��� ����� ��������� �����
    for ( int i = 0; i < 100; i++ ) {
      sm.addRow(new Integer[] { i,
          (int)(5*Math.random()),
          (int)(5*Math.random()),
          (int)(5*Math.random())} );
    }
    final JTable table = new JTable(sm);
    // �������������� ��������� ����������
    table.setAutoCreateRowSorter(true);
    // ����������� ����������� ������
    ((TableRowSorter)table.getRowSorter()).
        setRowFilter(new RowFilter() {
          public boolean include(Entry entry) {
            // �������� ������ ������ ������
            return ((Integer)entry.getValue(0)) % 2 == 0;
          }
        });
    add(new JScrollPane(table));
    // ���� ��� ������ ������� ��������� �����
    final JTextArea out = new JTextArea(3, 10);
    add(new JScrollPane(out), "South");
    // ������ �� ���������� � �������
    table.getSelectionModel().addListSelectionListener(
        new ListSelectionListener() {
          public void valueChanged(ListSelectionEvent e) {
            if ( table.getSelectedRow() != -1) {
              out.append("������:" + table.getSelectedRow() + "\n");
              out.append("�������:" + table.getSelectedColumn() + "\n");
              out.append("������ ������:" +
                  table.convertRowIndexToModel(
                      table.getSelectedRow()) + "\n");
            }
          }
        });
    // ������� ���� �� �����
    setSize(400, 300);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new FilterAndSelection(); } });
  }
}