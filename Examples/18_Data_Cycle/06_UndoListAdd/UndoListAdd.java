// UndoListAdd.java
// Відміна операцій в списках та UndoManager
import javax.swing.*;
import javax.swing.undo.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UndoListAdd extends JFrame {
  // об'єкт для відміни операцій
  private UndoManager undoManager = new UndoManager();
  public UndoListAdd() {
    super("UndoListAdd");
    // вихід при закриванні вікна
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // створюємо модель списку
    final DefaultListModel<String> model = new DefaultListModel<>();
    // створюємо списки
    JList<String> list1 = new JList<>(model);
    JList<String> list2 = new JList<>(model);
    // додаємо списки у вікно
    JPanel listPanel = new JPanel(new GridLayout(1, 2));
    listPanel.add(new JScrollPane(list1));
    listPanel.add(new JScrollPane(list2));
    add(listPanel);
    //скнопка додавання елемента
    JButton add = new JButton("Додати");
    add.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String newElement = "Новий!";
        model.addElement(newElement);
        // реєстрація нової операції для відміни
        undoManager.addEdit(new
            ListAddUndoableEdit(model, newElement));
      }
    });
    // кнопки відміни і повтору
    final JButton undo = new JButton("Відмінити");
    final JButton redo = new JButton("Повторити");
    // оброблювач натискань кнопок
    ActionListener al = new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // відміна і повтор при можливості
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
    // додамо кнопки на південь вікна
    JPanel buttons = new JPanel();
    buttons.add(add);
    buttons.add(undo);
    buttons.add(redo);
    add(buttons, "South");
    // виводмо вікно на екран
    setSize(400, 300);
    setVisible(true);
  }
  // клас, описуючий додавання в список
  class ListAddUndoableEdit extends AbstractUndoableEdit {
    // модель і новий елемент
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
    @SuppressWarnings("unchecked")
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
