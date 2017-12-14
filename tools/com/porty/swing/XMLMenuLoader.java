// com/porty/swing/XMLMenuLoader.java
// ���������� ��� �������� ���� �� ����� XML
package com.porty.swing;

import javax.swing.*;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import java.io.*;
import javax.xml.parsers.*;
import java.awt.event.*;
import java.util.*;

public class XMLMenuLoader {
  // �������� ������ XML
  private InputSource source;
  // ���������� XML
  private SAXParser parser;
  // ���������� XML
  private DefaultHandler documentHandler;
  // ��������� ��� ���� ������ ������� ����
  private Map<String, JComponent> menuStorage
      = new HashMap<String, JComponent>();

  // �����������, ������� ������ ����� ������ � ����
  public XMLMenuLoader(InputStream stream) {
    // ����������� �������� ������ XML
    try {
      Reader reader = new InputStreamReader(stream, "UTF-8");
      source = new InputSource(reader);
      parser = SAXParserFactory.
          newInstance().newSAXParser();
    } catch (Exception ex) {
      throw new RuntimeException(ex);
    }
    // ������� ���������� XML
    documentHandler = new XMLParser();
  }

  // ��������� XML � ������� ������� ����
  public void parse() throws Exception {
    parser.parse(source, documentHandler);
  }

  // ��������� �������� ������ ����
  public JMenuBar getMenuBar(String name) {
    return (JMenuBar) menuStorage.get(name);
  }
  // ��������� �������� ���������� ����
  public JMenu getMenu(String name) {
    return (JMenu) menuStorage.get(name);
  }
  // ��������� �������� ������� ����
  public JMenuItem getMenuItem(String name) {
    return (JMenuItem) menuStorage.get(name);
  }
  // ������� ����� ��� �������� ����������
  // ��������� �������
  public void addActionListener(String name, ActionListener listener) {
    getMenuItem(name).addActionListener(listener);
  }

  // ������� ������ ����
  private JMenuBar currentMenuBar;
  // ������ ��� ������������ ���������� ����
  private LinkedList<JMenu> menus = new LinkedList<JMenu>();

  // ���������� XML
  class XMLParser extends DefaultHandler {
    // ����� ���� XML
    public void startElement(String uri, String localName,
                             String qName, Attributes attributes) {
      // ���������� ��� ����
      if (qName.equals("menubar"))
        parseMenuBar(attributes);
      else if (qName.equals("menu"))
        parseMenu(attributes);
      else if (qName.equals("menuitem"))
        parseMenuItem(attributes);
    }
    // ����� ����, ������������ ��� ����� ���������� ����
    public void endElement(String uri, String localName,
                           String qName) {
      if (qName.equals("menu")) menus.removeFirst();
    }
    // ������� ����� ������ ����
    protected void parseMenuBar(Attributes attrs) {
      JMenuBar menuBar = new JMenuBar();
      // ���������� ���
      String name = attrs.getValue("name");
      menuStorage.put(name, menuBar);
      currentMenuBar = menuBar;
    }
    // ������� ����� ���������� ����
    protected void parseMenu(Attributes attrs) {
      // ������� ����
      JMenu menu = new JMenu();
      String name = attrs.getValue("name");
      // ����������� ����� ��������
      adjustProperties(menu, attrs);
      menuStorage.put(name, menu);
      // ��������� ���� � ����������� �����������
      // ���� ��� � ������ ����
      if ( menus.size() != 0 ) {
        menus.getFirst().add(menu);
      } else {
        currentMenuBar.add(menu);
      }
      // ��������� � ������ ���������� ����
      menus.addFirst(menu);
    }
    // ����� ����� ����
    protected void parseMenuItem(Attributes attrs) {
      // ���������, �� ����������� �� ���
      String name = attrs.getValue("name");
      if (name.equals("separator")) {
        menus.getFirst().addSeparator();
        return;
      }
      // ������� ����� ����
      JMenuItem menuItem = new JMenuItem();
      // ����������� ��������
      adjustProperties(menuItem, attrs);
      menuStorage.put(name, menuItem);
      // ��������� � �������� ����������� ����
      menus.getFirst().add(menuItem);
    }
    // ��������� ����� ��������� ������� ����
    private void adjustProperties(
        JMenuItem menuItem, Attributes attrs) {
      // �������� �������������� ��������
      String text = attrs.getValue("text");
      String mnemonic = attrs.getValue("mnemonic");
      String accelerator = attrs.getValue("accelerator");
      String enabled = attrs.getValue("enabled");
      // ����������� �������� ����
      menuItem.setText(text);
      if (mnemonic != null) {
        menuItem.setMnemonic(mnemonic.charAt(0));
      }
      if (accelerator != null) {
        menuItem.setAccelerator(
            KeyStroke.getKeyStroke(accelerator));
      }
      if (enabled != null) {
        menuItem.setEnabled(Boolean.valueOf(enabled));
      }
    }
  }
}
