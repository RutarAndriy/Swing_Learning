// SimpleTreeModel.java
// �������� ������� ������ ��� ������
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.tree.*;
import java.util.*;
import java.awt.*;

public class SimpleTreeModel extends JFrame {
  public SimpleTreeModel() {
    super("SimpleTreeModel");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    // ������ �� ������ ����� ������
    JTree tree = new JTree(new SimpleModel());
    // ��������� ��� � ����
    add(new JScrollPane(tree));
    setSize(300, 200);
    setVisible(true);
  }

  // ���� ������ ��� ������
  class SimpleModel implements TreeModel {
    // ������ ������ � �������� ����
    private String root = "���-��� ����������";
    private String
        colors = "�����",
        food = "���";
    // ��������� ������
    private ArrayList<String> rootList = new ArrayList<String>(),
        colorsList = new ArrayList<String>(),
        foodList = new ArrayList<String>();
    public SimpleModel() {
      // ��������� ������ �������
      rootList.add(colors);
      rootList.add(food);
      colorsList.add("�������");
      colorsList.add("�������");
      foodList.add("���������");
      foodList.add("���������");
    }

    // ���������� ������ ������
    public Object getRoot() {
      return root;
    }

    // �������� � ���������� �������� ����
    public int getChildCount(Object parent) {
      if ( parent == root ) return rootList.size();
      else if ( parent == colors )
        return colorsList.size();
      else if ( parent == food ) return foodList.size();
      return 0;
    }

    // ���������� ������� ���� �� ����������� ������
    public Object getChild(Object parent, int index) {
      if ( parent == root )
        return rootList.get(index);
      else if ( parent == colors )
        return colorsList.get(index);
      else if ( parent == food )
        return foodList.get(index);
      return null;
    }

    // ��������� �������� ���������� ����� �������
    public int getIndexOfChild(
        Object parent, Object child) {
      if ( parent == root )
        return rootList.indexOf(child);
      else if ( parent == colors )
        return colorsList.indexOf(child);
      else if ( parent == food )
        return foodList.indexOf(child);
      return 0;
    }

    // ����������, ����� ���� �������� ��������
    public boolean isLeaf(Object node) {
      if ( colorsList.contains(node) ||
          foodList.contains(node) ) return true;
      else return false;
    }

    // ���������� ��� ��������� �������� ���������� ����
    // ��� ����� ������ �� �����������
    public void valueForPathChanged(
        TreePath path, Object value) {
    }

    // ������ ��� ������������� � �������� ����������
    // ����� ������� ������ �� �����������
    public void addTreeModelListener(
        TreeModelListener tml) {
    }
    public void removeTreeModelListener(
        TreeModelListener tml) {
    }
  }
  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        new Runnable() {
          public void run() { new SimpleTreeModel(); } });
  }
}