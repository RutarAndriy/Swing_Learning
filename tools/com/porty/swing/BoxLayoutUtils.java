// com/porty/swing/BoxLayoutUtils.java
// ����� ��� ������� ������ � ������� �������������
package com.porty.swing;
import javax.swing.*;
import java.awt.*;

public class BoxLayoutUtils {
	// ������ ������ ������������ �� ��� X ���
	// ������ �����������
	public static void setGroupAlignmentX(float alignment, JComponent... cs) {
    for (JComponent c : cs) {
      c.setAlignmentX(alignment);
    }
	}
	// ������ ������ ������������ �� ��� Y ���
	// ������ �����������
	public static void setGroupAlignmentY(float alignment, JComponent... cs) {
    for (JComponent c : cs) {
      c.setAlignmentY(alignment);
    }
	}
	// ���������� ������ � ������������� ������������
	// ������� �������������
	public static JPanel createVerticalPanel() {
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));		
		return p;
	}
	// ���������� ������ � ������������� ��������������
	// ������� �������������
	public static JPanel createHorizontalPanel() {
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.X_AXIS));		
		return p;
	}
  // ������� �������������� ��������
  // �������������� �������
  public static Component createHorizontalStrut(int size) {
    return Box.createRigidArea(new Dimension(size, 0));
  }
  // ������� ������������ ��������
  // �������������� �������
  public static Component createVerticalStrut(int size) {
    return Box.createRigidArea(new Dimension(0, size));
  }
}