// UndoListAdd.java
// ������ �������� � ������� � UndoManager
import javax.swing.*;
import javax.swing.undo.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UndoListAdd extends JFrame {
  // ������ ��� ������ ��������
  private UndoManager undoManager = new UndoManager();
  public UndoListAdd() {
    super("ListDrag");
    // ����� ��� �������� ����
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // ������� ������ ������
    final DefaultListModel model = new DefaultListModel();
    // ������� ������
    JList list1 = new JList(model);
    JList list2 = new JList(model);
    // ������� ������ � ����
    JPanel listPanel = new JPanel(new GridLayout(1, 2));
    listPanel.add(new JScrollPane(list1));
    listPanel.add(new JScrollPane(list2));
    add(listPanel);
    // ������ ���������� ��������
    JButton add = new JButton("��������");
    add.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String newElement = "�����!";
        model.addElement(newElement);
        // ����������� ����� �������� ��� ������
        undoManager.addEdit(new
            ListAddUndoableEdit(model, newElement));
      }
    });
    // ������ ������ � �������
    final JButton undo = new JButton("��������");
    final JButton redo = new JButton("���������");
    // ���������� ������� ������
    ActionListener al = new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // ������ � ������ ��� �����������
        if ( e.getSource() == undo
            && undoManager.canUndo() ) {
          undoManager.undo();
        } else if ( undoManager.canRedo() ) {
          undoManager.redo();
        }
      }
    };
    undo.addActionListener(al);
    redo.addActionListener(al);
    // ������� ������ �� �� ����
    JPanel buttons = new JPanel();
    buttons.add(add);
    buttons.add(undo);
    buttons.add(redo);
    add(buttons, "South");
    // ������� ���� �� �����
    setSize(400, 300);
    setVisible(true);
  }
  // �����, ����������� ���������� � ������
  class ListAddUndoableEdit extends AbstractUndoableEdit {
    // ������ � ����� �������
    private DefaultListModel model;
    private Object element;
    public ListAddUndoableEdit(DefaultListModel model, Object element) {
      this.model = model;
      this.element = element;
    }
    @Override
    public void undo() throws CannotUndoException {
      super.undo();
      model.removeElement(element);
    }
    @Override
    public void redo() throws CannotRedoException {
      super.redo();
      model.addElement(element);
    }
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new UndoListAdd(); } });
  }
}