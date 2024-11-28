package br.com.adailtonskywalker.marketplace.factory;

import br.com.adailtonskywalker.marketplace.views.ClientConsult;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.util.Objects;
import java.util.Vector;

public class ComponentFactory {
    public static JLabel createLabelWithFont(String text, Font font, int x, int y, int width, int height) {
        JLabel label = new JLabel(text);
        label.setFont(font);
        label.setBounds(x, y, width, height);
        return label;
    }

    public static JLabel createLabelBorder(String text, Border border, int x, int y, int width, int height) {
        JLabel label = new JLabel(text);
        label.setBorder(border);
        label.setBounds(x, y, width, height);
        return label;
    }

    public static JLabel createImageLabel(String imagePath, Border border, int x, int y, int width, int height) {
        JLabel label = new JLabel("");
        label.setBorder(border);
        label.setIcon(new ImageIcon(Objects.requireNonNull(ComponentFactory.class.getResource(imagePath))));
        label.setBounds(x, y, width, height);
        return label;
    }

    public static JTextField createTextField(Font font, boolean editable, int x, int y, int width, int height) {
        JTextField textField = new JTextField();
        textField.setFont(font);
        textField.setEditable(editable);
        textField.setBackground(Color.WHITE);
        textField.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
        textField.setBounds(x, y, width, height);
        return textField;
    }

    public static JFormattedTextField createFormattedTextField(Font font, MaskFormatter formatter, int x, int y, int width, int height) {
        JFormattedTextField formattedTextField = new JFormattedTextField(formatter);
        formattedTextField.setFont(font);
        formattedTextField.setBorder(new LineBorder(Color.BLACK));
        formattedTextField.setBounds(x, y, width, height);
        return formattedTextField;
    }

    public static JButton createButton(String text, String iconPath, Font font, int x, int y, int width, int height) {
        JButton button = new JButton(text);
        if (iconPath != null) {
            button.setIcon(new ImageIcon(Objects.requireNonNull(ClientConsult.class.getResource(iconPath))));
        }
        button.setFont(font);
        button.setBackground(UIManager.getColor("Button.background"));
        button.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
        button.setBounds(x, y, width, height);
        return button;
    }

    public static JComboBox<String> createComboBox(Vector<String> items, Font font, Border border, int x, int y, int width, int height) {
        JComboBox<String> comboBox = new JComboBox<>(items);
        comboBox.setFont(font);
        comboBox.setBorder(border);
        comboBox.setBounds(x, y, width, height);
        comboBox.setForeground(Color.BLACK);
        comboBox.setBackground(Color.WHITE);
        return comboBox;
    }
    public static JPanel createConfiguredPanel(Color backgroundColor, Color borderColor, int borderWidth, int x, int y, int width, int height) {
        JPanel panel = new JPanel();
        panel.setForeground(Color.BLACK);
        panel.setBorder(new LineBorder(borderColor, borderWidth, true));
        panel.setBackground(backgroundColor);
        panel.setBounds(x, y, width, height);
        panel.setLayout(null);
        return panel;
    }
}
