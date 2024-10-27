// com/porty/swing/BoxLayoutUtils.java
// Клас для зручної роботи із блочним розміщенням
package com.porty.swing;
import javax.swing.*;
import java.awt.*;

public class BoxLayoutUtils {
	// задає єдине вирівнювання по осі X для
	// групи компонентів
	public static void setGroupAlignmentX(float alignment, JComponent... cs) {
    for (JComponent c : cs) {
      c.setAlignmentX(alignment);
    }
	}
	// задає єдине вирівнювання по осі Y для
	// групи компонентів
	public static void setGroupAlignmentY(float alignment, JComponent... cs) {
    for (JComponent c : cs) {
      c.setAlignmentY(alignment);
    }
	}
	// повертає панель із встановленим горизонтальним
	// блочним розміщенням
	public static JPanel createHorizontalPanel() {
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.X_AXIS));		
		return p;
	}
	// повертає панель із встановленим вертикальним
	// блочним розміщенням
	public static JPanel createVerticalPanel() {
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));		
		return p;
	}
    // створює горизонтальний клин
    // фіксованого розміру
    public static Component createHorizontalStrut(int size) {
        return Box.createRigidArea(new Dimension(size, 0));
    }
    // створює вертикальний клин
    // фіксованого розміру
    public static Component createVerticalStrut(int size) {
        return Box.createRigidArea(new Dimension(0, size));
    }
}
