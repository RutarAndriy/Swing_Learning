// ListSelectionEvents.java
// �������� �� ���������� ������
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

public class ListSelectionEvents extends JFrame {
  // ������ ������
  private String[] data =
      { "�������", "������", "�������"};
  private JTextArea jta;
  public ListSelectionEvents() {
    super("ListSelectionEvents");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // ������� ������ � ��������� ����
    setLayout(new FlowLayout());
    JList list = new JList(data);
    list.setSelectionMode(
        ListSelectionModel.SINGLE_SELECTION);
    jta = new JTextArea(5, 20);
    // ������� ��������� ������� ���������
    list.addListSelectionListener(new SelectionL());
    // ��������� ����������
    add(new JScrollPane(list));
    add(new JScrollPane(jta));
    // ������� ���� �� �����
    setSize(300, 200);
    setVisible(true);
  }
  // ��������� ������� �� ������ ���������
  class SelectionL implements ListSelectionListener {
    public void valueChanged(ListSelectionEvent lse) {
      int selected =
          ((JList)lse.getSource()).getSelectedIndex();
      switch ( selected ) {
        case 0: jta.setText("���������� ������"); break;
        case 1: jta.setText("������ ������"); break;
        case 2: jta.setText("���������� �����");
      }
    }
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new ListSelectionEvents(); } });
  }
}