// UndoAndRedo.java
// Підтримка відміни та повтору операцій
// у текстових компонентах Swing
import javax.swing.*;
import javax.swing.undo.*;
import java.awt.event.*;
import java.awt.*;

public class UndoAndRedo extends JFrame {
  // підтримка відміни/повтору операцій
  private UndoManager undoManager = new UndoManager();
  public UndoAndRedo() {
    super("UndoAndRedo");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // панель інструментів
    JToolBar toolBar = new JToolBar();
    toolBar.add(new UndoAction());
    toolBar.add(new RedoAction());
    // текстове поле
    JTextArea textArea = new JTextArea();
    // додаємо прослуховувача операцій
    textArea.getDocument().
        addUndoableEditListener(undoManager);
    // додаємо компоненти у вікно
    add(toolBar, "North");
    add(new JScrollPane(textArea));
    // виводимо вікно на екран
    setSize(400, 300);
    setVisible(true);
  }
  // команда - відміна операції
  class UndoAction extends AbstractAction {
    public UndoAction() {
      // налаштування команди
      putValue(AbstractAction.SMALL_ICON,
          new ImageIcon("Undo16.gif"));
    }
    public void actionPerformed(ActionEvent e) {
      if ( undoManager.canUndo() )
        undoManager.undo();
    }
  }
  // команда - повтор операції
  class RedoAction extends AbstractAction {
    public RedoAction() {
      // налаштування команди
      putValue(AbstractAction.SMALL_ICON,
          new ImageIcon("Redo16.gif"));
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
