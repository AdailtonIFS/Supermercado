package br.com.adailtonskywalker.marketplace.views;

import br.com.adailtonskywalker.marketplace.factory.ComponentFactory;

import javax.swing.*;
import java.awt.*;

public class View extends JFrame {
    protected void createLabel(JPanel panel, String text, Font font, int x, int y, int width, int height) {
        JLabel label = ComponentFactory.createLabelWithFont(text, font, x, y, width, height);
        panel.add(label);
    }

    protected JTextField createTextField(JPanel panel, Font font, int x, int y, int width, int height) {
        JTextField textField = ComponentFactory.createTextField(font, false, x, y, width, height);
        panel.add(textField);
        return textField;
    }

    protected JButton createButton(JPanel panel, String text, String iconPath, Font font, int x, int y, int width, int height) {
        JButton button = ComponentFactory.createButton(text, iconPath, font, x, y, width, height);
        panel.add(button);
        return button;
    }
}
