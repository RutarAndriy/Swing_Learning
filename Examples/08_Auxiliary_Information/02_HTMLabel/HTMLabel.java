// HTMLabel.java
// Використання в написах мови HTML
import javax.swing.*;

public class HTMLabel extends JFrame {
  private String html1 =
      "<html><b>Слава</b><font size=5 color=red> HTML";
  private String html2 =
      "<html><font size=4 color=blue>" +
          "<ul>Список:<li>Один<li>Два";
  private String html3 =
      "<html><body bgcolor=white><h2>Будь-який колір фону";
  private String html4 =
      "<html><h2>Зображення:<img src=\"file:Monkey.gif\">";
  public HTMLabel() {
    super("HTMLabel");
    // при закриванні вікна - вихід
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // додаємо написи
    JPanel contents = new JPanel();
    contents.add(new JLabel(html1));
    contents.add(new JLabel(html2));
    contents.add(new JLabel(html3));
    contents.add(new JLabel(html4));
    // виводимо вікно на екран
    add(contents);
    setSize(400, 300);
    setVisible(true);
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new HTMLabel(); } });
  }
}
