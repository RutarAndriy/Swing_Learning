// Borders.java
// Рамки Swing
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class Borders extends JFrame {
  public Borders() {
    super("Borders");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // створимо панелі із всеможливими рамками
    JPanel contents = new JPanel(
        new GridLayout(3, 2, 5, 5));
    contents.add(createPanel(new TitledBorder(
        "Рамка із заголовком"), "TitledBorder"));
    contents.add(createPanel(new EtchedBorder(),
        "EtchedBorder"));
    contents.add(createPanel(new BevelBorder(
        BevelBorder.LOWERED), "BevelBorder"));
    contents.add(createPanel(new SoftBevelBorder(
        BevelBorder.RAISED), "SoftBevelBorder"));
    contents.add(createPanel(new LineBorder(
        Color.BLACK, 5), "LineBorder"));
    contents.add(createPanel(new MatteBorder(
        new ImageIcon("Matte.gif")), "MatteBorder"));
    // виводимо вікно на екран
    add(contents);
    pack();
    setVisible(true);
  }
  // метод створює панель з рамкою та написом
  private JPanel createPanel(Border b, String text) {
    JPanel panel = new JPanel(new BorderLayout());
    panel.add(new JLabel(text));
    panel.setBorder(new CompoundBorder(
        b, new EmptyBorder(30, 30, 30, 30)));
    return panel;
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new Borders(); } });
  }
}
