package br.com.adailtonskywalker.marketplace.interfaces;

import javax.swing.*;
import java.io.IOException;

public interface Visualization {
    void setupComponents(JPanel panel) throws IOException;
    void setupButtons(JPanel panel);
}
