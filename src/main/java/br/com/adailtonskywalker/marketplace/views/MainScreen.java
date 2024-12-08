package br.com.adailtonskywalker.marketplace.views;

import br.com.adailtonskywalker.marketplace.interfaces.Visualization;

import javax.swing.*;
import java.awt.*;

public class MainScreen extends View implements Visualization {

    public MainScreen() {
        setTitle("TELA PRINCIPAL");
        setForeground(Color.GRAY);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 870, 671);
        setLocationRelativeTo(null);

        JPanel contentPane = new JPanel();
        contentPane.setBackground(new Color(153, 204, 255));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setupComponents(contentPane);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setBounds(0, 0, 870, 37);
        contentPane.add(menuBar);
        menuBar.setForeground(Color.WHITE);
        menuBar.setBackground(Color.WHITE);

        setupButtons(menuBar);

        JButton saleButton = createButton(contentPane, "VENDER", new Font("Comic Sans MS", Font.BOLD, 34), 300, 316, 255, 75);

        saleButton.addActionListener(e -> {
            try {
                new Sales().setVisible(true);
            } catch (Exception ignored) {
            }
        });
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                new MainScreen().setVisible(true);
            } catch (Exception ignored) {
            }
        });
    }

    @Override
    public void setupComponents(JComponent component) {
        if (!(component instanceof JPanel)) {
            throw new IllegalArgumentException("Component must be a JPanel");
        }
        JPanel panel = (JPanel) component;

        createLabel(panel, "BEM-VINDO", new Font("Comic Sans MS", Font.BOLD, 100), 150, 194, 2000, 91);
        createLabel(panel, "", new Font("Comic Sans MS", Font.BOLD, 100), 225, 271, 486, 14);
        createLabel(panel, "", new Font("Comic Sans MS", Font.BOLD, 100), 654, 649, 46, 14);
    }

    @Override
    public void setupButtons(JComponent component) {
        if (!(component instanceof JMenuBar)) {
            throw new IllegalArgumentException("Component must be a JMenuBar");
        }
        JMenuBar bar = (JMenuBar) component;

        JMenu clientMenu = new JMenu("CLIENTE\r\n");
        bar.add(clientMenu);

        JMenuItem clientStoreItemMenu = new JMenuItem("CADASTRAR");
        clientMenu.add(clientStoreItemMenu);

        clientStoreItemMenu.addActionListener(e -> {
            try {
                new ClientRegistration().setVisible(true);
            } catch (Exception ignored) {
            }
        });

        JMenuItem clientSearchItemMenu = new JMenuItem("PESQUISAR");
        clientMenu.add(clientSearchItemMenu);
        clientSearchItemMenu.addActionListener(e -> {
            try {
                new ClientConsult().setVisible(true);
            } catch (Exception ignored) {
            }
        });

        JMenu productMenu = new JMenu("PRODUTOS");
        bar.add(productMenu);

        JMenuItem productStoreItemMenu = new JMenuItem("CADASTRAR");
        productMenu.add(productStoreItemMenu);
        productStoreItemMenu.addActionListener(e -> {
            try {
                new ProductRegistration().setVisible(true);
            } catch (Exception ignored) {
            }
        });

        JMenuItem productSearchItemMenu = new JMenuItem("PESQUISAR");
        productMenu.add(productSearchItemMenu);
        productSearchItemMenu.addActionListener(e -> {
            try {
                new ProductConsult().setVisible(true);
            } catch (Exception ignored) {
            }
        });

        JMenu employeeMenu = new JMenu("FUNCIONÁRIO");
        bar.add(employeeMenu);

        JMenuItem employeeStoreItemMenu = new JMenuItem("CADASTRAR");
        employeeMenu.add(employeeStoreItemMenu);
        employeeStoreItemMenu.addActionListener(e -> {
            try {
                new EmployeeRegistration().setVisible(true);
            } catch (Exception ignored) {
            }
        });

        JMenuItem employeeSearchItemMenu = new JMenuItem("PESQUISAR");
        employeeSearchItemMenu.addActionListener(e -> {
            try {
                new EmployeeConsult().setVisible(true);
            } catch (Exception ignored) {
            }
        });
        employeeMenu.add(employeeSearchItemMenu);
    }
}