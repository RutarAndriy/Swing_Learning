// LayeredPaneEffects.java
// Створення ефектів для інтерфейсу 
// з допомогою багатошарової панелі
import javax.swing.*;
import java.awt.*;

public class LayeredPaneEffects extends JFrame {
  public LayeredPaneEffects() {
    super("LayeredPaneEffects");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // декілька звичайних кнопок та текстове поле
    JPanel buttons = new JPanel();
    buttons.add(new JButton("Застосувати"));
    buttons.add(new JButton("Записати"));
    buttons.add(new JTextField(20));
    // додаємо у панель вмісту
    getContentPane().add(buttons);
    // додаємо компонент з анімацією у шар PALETTE
    Animation an = new Animation();
    an.setBounds(50, 10, anim.getWidth(this),
                         anim.getHeight(this));
    getLayeredPane().add(an, JLayeredPane.PALETTE_LAYER);
    // виводимо вікно на екран
    setSize(250, 100);
    setVisible(true);
  }
  // зображення
  private Image anim =
      new ImageIcon("Anim.gif").getImage();
  // компонент, малюючий анімоване зображення
  class Animation extends JComponent {
    public Animation() {
      setOpaque(false);
    }
    public void paintComponent(Graphics g) {
      Graphics2D g2 = (Graphics2D)g;
      // напівпрозорість
      g2.setComposite(AlphaComposite.getInstance(
          AlphaComposite.SRC_OVER, 0.3f));
      // малюємо зображення
      g2.drawImage(anim, 0, 0, this);
    }
    // ми ніколи не отримуємо подій від миші
    public boolean contains(int x, int y) {
      return false;
    }
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
     new Runnable() {
      public void run() { new LayeredPaneEffects(); } });
  }
}
