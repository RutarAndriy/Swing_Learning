// UndoAndRedo.java
// ��������� ������ � ������� ��������
// � ��������� ����������� Swing
import javax.swing.*;
import javax.swing.undo.*;
import java.awt.event.*;
import java.awt.*;

public class UndoAndRedo extends JFrame {
  // ��������� ������/������� ��������
  private UndoManager undoManager = new UndoManager();
  public UndoAndRedo() {
    super("UndoAndRedo");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // ������ ������������
    JToolBar toolBar = new JToolBar();
    toolBar.add(new UndoAction());
    toolBar.add(new RedoAction());
    // ��������� ����
    JTextArea textArea = new JTextArea();
    // ��������� ��������� ��������
    textArea.getDocument().
        addUndoableEditListener(undoManager);
    // ��������� ���������� � ����
    add(toolBar, "North");
    add(new JScrollPane(textArea));
    // ������� ���� �� �����
    setSize(400, 300);
    setVisible(true);
  }
  // ������� - ������ ��������
  class UndoAction extends AbstractAction {
    public UndoAction() {
      // ��������� �������
      putValue(AbstractAction.SMALL_ICON,
          new ImageIcon("undo16.gif"));
    }
    public void actionPerformed(ActionEvent e) {
      if ( undoManager.canUndo() )
        undoManager.undo();
    }
  }
  // ������� - ������ ��������
  class RedoAction extends AbstractAction {
    public RedoAction() {
      // ��������� �������
      putValue(AbstractAction.SMALL_ICON,
          new ImageIcon("redo16.gif"));
    }
    public void actionPerformed(ActionEvent e) {
      if ( undoManager.canRedo() )
        undoManager.redo();
    }
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new UndoAndRedo(); } });
  }
}