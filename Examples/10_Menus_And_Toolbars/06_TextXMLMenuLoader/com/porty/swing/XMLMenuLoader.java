// com/porty/swing/XMLMenuLoader.java
// Інструмент для завантаження меню із файлу XML
package com.porty.swing;

import javax.swing.*;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import java.io.*;
import javax.xml.parsers.*;
import java.awt.event.*;
import java.util.*;

public class XMLMenuLoader {
  // джерело даних XML
  private InputSource source;
  // аналізатор XML
  private SAXParser parser;
  // оброблювач XML
  private DefaultHandler documentHandler;
  // сховище для всіх частин системи меню
  private Map<String, JComponent> menuStorage
      = new HashMap<String, JComponent>();

  // конструктор, вимагає задати потік даних з меню
  public XMLMenuLoader(InputStream stream) {
    // налаштовуємо джерело даних XML
    try {
      Reader reader = new InputStreamReader(stream, "UTF-8");
      source = new InputSource(reader);
      parser = SAXParserFactory.
          newInstance().newSAXParser();
    } catch (Exception ex) {
      throw new RuntimeException(ex);
    }
    // створюємо оброблювач XML
    documentHandler = new XMLParser();
  }

  // зчитуємо XML і створюємо систему меню
  public void parse() throws Exception {
    parser.parse(source, documentHandler);
  }

  // дозволяє отримати рядок меню
  public JMenuBar getMenuBar(String name) {
    return (JMenuBar) menuStorage.get(name);
  }
  // дозволяє отримати випадаюче меню
  public JMenu getMenu(String name) {
    return (JMenu) menuStorage.get(name);
  }
  // дозволяє отримати елемент меню
  public JMenuItem getMenuItem(String name) {
    return (JMenuItem) menuStorage.get(name);
  }
  // зручний метод для швидкого додавання
  // прослуховувача подій
  public void addActionListener(String name, ActionListener listener) {
    getMenuItem(name).addActionListener(listener);
  }

  // поточний рядок меню
  private JMenuBar currentMenuBar;
  // список для впорядкування випадаючих меню
  private LinkedList<JMenu> menus = new LinkedList<JMenu>();

  // оброблювач XML
  class XMLParser extends DefaultHandler {
    // новий вузол XML
    public void startElement(String uri, String localName,
                             String qName, Attributes attributes) {
      // визначаємо тип вузла
      if (qName.equals("menubar"))
        parseMenuBar(attributes);
      else if (qName.equals("menu"))
        parseMenu(attributes);
      else if (qName.equals("menuitem"))
        parseMenuItem(attributes);
    }
    // кінець вузла, використовується для зміни випадаючих меню
    public void endElement(String uri, String localName,
                           String qName) {
      if (qName.equals("menu")) menus.removeFirst();
    }
    // створює новий рядок меню
    protected void parseMenuBar(Attributes attrs) {
      JMenuBar menuBar = new JMenuBar();
      // визначаємо ім'я
      String name = attrs.getValue("name");
      menuStorage.put(name, menuBar);
      currentMenuBar = menuBar;
    }
    // створює нове випадаюче меню
    protected void parseMenu(Attributes attrs) {
      // створюємо меню
      JMenu menu = new JMenu();
      String name = attrs.getValue("name");
      // налаштовуємо загальні атрибути
      adjustProperties(menu, attrs);
      menuStorage.put(name, menu);
      // додаємо меню до попереднього випадаючого
      // меню або до рядка меню
      if ( menus.size() != 0 ) {
        menus.getFirst().add(menu);
      } else {
        currentMenuBar.add(menu);
      }
      // додаємо в список випадаючих меню
      menus.addFirst(menu);
    }
    // новий пункт меню
    protected void parseMenuItem(Attributes attrs) {
      // перевіряємо, чи це не розділювач
      String name = attrs.getValue("name");
      if (name.equals("separator")) {
        menus.getFirst().addSeparator();
        return;
      }
      // створюємо пункт меню
      JMenuItem menuItem = new JMenuItem();
      // налаштовуємо властивості
      adjustProperties(menuItem, attrs);
      menuStorage.put(name, menuItem);
      // додаємо до поточного випадаючого меню
      menus.getFirst().add(menuItem);
    }
    // налаштування загальних атрибутів пунктів меню
    private void adjustProperties(
        JMenuItem menuItem, Attributes attrs) {
      // отримуємо підтримувані атрибути
      String text = attrs.getValue("text");
      String mnemonic = attrs.getValue("mnemonic");
      String accelerator = attrs.getValue("accelerator");
      String enabled = attrs.getValue("enabled");
      // налаштовуємо властивості меню
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
