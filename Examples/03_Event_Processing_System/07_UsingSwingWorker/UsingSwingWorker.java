// UsingSwingWorker.java
// Клас SwingWorker для відкликуваності інтерфейсу

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class UsingSwingWorker extends JFrame {
  private JButton button;

  public UsingSwingWorker() {
    super("UsingSwingWorker");
    // при закритті вікна - вихід
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // добавимо кнопку із прослуховувачем
    button = new JButton("Виконати важку роботу");
    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // запустипо окрему довгу роботу
        new ComplexJob().execute();
        button.setText("Почекайте...");
      }
    });
    // налаштуємо панель вмісту та виведемо вікно на екран
    setLayout(new FlowLayout());
    add(new JTextField(20));
    add(button);
    setSize(300, 200);
    setVisible(true);
  }

  // клас, виконуючий "важку роботу"
  class ComplexJob extends SwingWorker<String, String> {
    // тут виконується робота, це окремий потік!
    public String doInBackground() throws Exception {
      Thread.sleep(2000);
      // публікуємо проміжні результати
      publish("Половина роботи закінчена...");
      Thread.sleep(2000);
      return "";
    }

    // обробка проміжних результатів
    // це потік розсилки подій!
    public void process(List<String> chunks) {
      button.setText(chunks.get(0));
    }

    // закінчення роботи - і знову це потік розсилки
    public void done() {
      button.setText("Работа завершена");
    }
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() {
            new UsingSwingWorker();
          }
        });
  }
}
