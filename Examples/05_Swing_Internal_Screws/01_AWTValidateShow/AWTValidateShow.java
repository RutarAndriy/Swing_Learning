// AWTValidateShow.java
// Базова валідація AWT - при зміні размірів
// або інших параметрів залишається викликати validate()
import java.awt.*;

public class AWTValidateShow extends Frame {
  private static Button button;

  public AWTValidateShow() {
    setSize(400, 300);
    Panel contents = new Panel();
    button = new Button("Текст");
    Button button2 = new Button("Текст 2");
    contents.add(button);
    contents.add(button2);
    add(contents);
  }

  public static void main(String[] args)
      throws InterruptedException {
    new AWTValidateShow().setVisible(true);
    Thread.sleep(2000);
    button.setLabel("Дуже довгий текст");
    // З цього моменту розмір змінився - викликаний invalidate()
    // можна викликати validate() в контейнері
    Thread.sleep(2000);
    // буде заново розміщений весь контейнер
    // і весь його вміст (кнопка)
    button.getParent().validate();
  }
}
