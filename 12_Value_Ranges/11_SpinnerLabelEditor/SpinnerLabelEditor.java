// SpinnerLabelEditor.java
// Редактор лічильника JSpinner на основі напису
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

public class SpinnerLabelEditor extends JFrame {
  // дані для списку
  private String[] data = {
      "Червоний", "Зелений", "Синій"
  };
  public SpinnerLabelEditor() {
    super("SpinnerLabelEditor");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // створюємо лічильник
    JSpinner spinner = new JSpinner(
        new SpinnerListModel(data));
    // приєднюємо наш редактор
    LabelEditor editor = new LabelEditor();
    spinner.setEditor(editor);
    // реєструємо прослуховувача
    spinner.addChangeListener(editor);
    // для появи на екран необхідно
    // щоб до редактора дійшла подія
    spinner.getModel().setValue(data[1]);
    // виводимо вікно на екран
    setLayout(new FlowLayout());
    add(spinner);
    setSize(300, 200);
    setVisible(true);
  }
  // спеціальний редактор для лічильника
  class LabelEditor extends JLabel
      implements ChangeListener {
    // метод прослуховувача подій
    public void stateChanged(ChangeEvent e) {
      // отримуємо лічильник
      JSpinner spinner = (JSpinner)e.getSource();
      // отримуємо поточний елемент
      Object value = spinner.getValue();
      // встановлюємо нове значення
      if ( value.equals(data[0]) ) {
        setText("<html><h2><font color=\"red\">"
            + value);
      }
      if ( value.equals(data[1]) ) {
        setText("<html><h3><font color=\"green\">"
            + value);
      }
      if ( value.equals(data[2]) ) {
        setText("<html><h4><font color=\"blue\">"
            + value);
      }
    }
    // розмір редактора
    public Dimension getPreferredSize() {
      return new Dimension(100, 30);
    }
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new SpinnerLabelEditor(); } });
  }
}
