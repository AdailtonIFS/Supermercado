package br.com.adailtonskywalker.marketplace.views;

import br.com.adailtonskywalker.marketplace.factory.ComponentFactory;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;

public class View extends JFrame {
    protected void createLabel(JPanel panel, String text, Font font, int x, int y, int width, int height) {
        JLabel label = ComponentFactory.createLabelWithFont(text, font, x, y, width, height);
        panel.add(label);
    }

    protected JTextField createTextField(JPanel panel, Font font, int x, int y, int width, int height) {
        JTextField textField = ComponentFactory.createTextField(font, true, x, y, width, height);
        panel.add(textField);
        return textField;
    }

    protected JFormattedTextField createFormattedTextField(JPanel panel, Font font, MaskFormatter formatter, int x, int y, int width, int height) {
        JFormattedTextField formattedTextField = ComponentFactory.createFormattedTextField(font, formatter, x, y, width, height);
        panel.add(formattedTextField);
        return formattedTextField;
    }

    protected JButton createButton(JPanel panel, String text, Font font, int x, int y, int width, int height) {
        JButton button = ComponentFactory.createButton(text, null, font, x, y, width, height);
        panel.add(button);
        return button;
    }
}
