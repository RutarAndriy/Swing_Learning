// CustomListSelection.java
// Реалізація особливого режиму виділення
import javax.swing.*;
import java.awt.*;

public class CustomListSelection extends JFrame {
  private String[] data = { "Морозиво", "Курка",
      "Холодне", "Гаряче"};
  public CustomListSelection() {
    super("CustomListSelection");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // налаштуємо список і добавимо його у вікно
    JList<String> list = new JList<>(data);
    list.setSelectionModel(new CustomSelectionModel());
    add(new JScrollPane(list));
    // виводимо вікно на екран
    setSize(300, 200);
    setVisible(true);
  }
  // спеціальна модель виділення
  class CustomSelectionModel
      extends DefaultListSelectionModel {
    // додавання інтервалу виділення
    public void addSelectionInterval(int idx0, int idx1) {
      super.addSelectionInterval(idx0, idx1);
      adjustSelection(idx0);
    }
    // встановлення інтервалу виділення
    public void setSelectionInterval(int idx0, int idx1) {
      super.setSelectionInterval(idx0, idx1);
      adjustSelection(idx0);
    }
    // загальний метод "підкрутки" виділення
    private void adjustSelection(int idx) {
      if ( idx == 0 )
        addSelectionInterval(2, 2);
      if ( idx == 1 )
        addSelectionInterval(3, 3);
    }
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new CustomListSelection(); } });
  }
}
