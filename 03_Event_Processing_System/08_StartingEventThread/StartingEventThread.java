// StartingEventThread.java
// Перевірка моменту запуску потоку розсилки подій

import javax.swing.*;
import java.awt.*;

public class StartingEventThread {
  public static void main(String[] args) {
    // замінюємо системну чергу подій своєю
    Toolkit.getDefaultToolkit().
        getSystemEventQueue().push(new CustomQueue());
    // створюємо вікно
    JFrame frame = new JFrame("Тест");
    System.out.println("(1) JFrame()");
    // додаємо прапорець
    JCheckBox checkBox = new JCheckBox("Тест");
    frame.add(checkBox, "South");
    System.out.println("(2) Доданий прапорець");
    // створюємо список
    DefaultListModel model = new DefaultListModel();
    JList list = new JList(model);
    frame.add(list);
    System.out.println("(3) Доданий список");
    // оновлюємо модель
    model.addElement("Тест");
    System.out.println("(4) Оновлення моделі");
    // остаточно виводимо інтерфейс на екран
    frame.setSize(300, 200);
    frame.setVisible(true);
    System.out.println("(5) Інтерфейс побудований");
  }

  // спеціальна черга подій, повідомляюча
  // налагоджувальну інформацію про події в потоках
  static class CustomQueue extends EventQueue {
    // метод пладе подію в чергу
    public void postEvent(AWTEvent event) {
      System.out.println("post(), потік: " + Thread.currentThread().toString());
      System.out.println("post(), подія: " + event);
      super.postEvent(event);
    }

    // метод розподіляє події по компонентах
    protected void dispatchEvent(AWTEvent event) {
      System.out.println("dispatch(), потік: " + Thread.currentThread().toString());
      System.out.println("dispatch(), подія: " + event);
      super.dispatchEvent(event);
    }
  }
}
