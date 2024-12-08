package br.com.adailtonskywalker.marketplace;

import br.com.adailtonskywalker.marketplace.views.MainScreen;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.net.URL;

public class Opening extends JFrame {
    private final JPanel contentPane;

    public Opening() {
        setTitle("SUPERMARKET");

        setLookAndFeel();

        contentPane = createContentPane();
        setContentPane(contentPane);

        addButton();
        addWelcomeLabel();
        addBackgroundImage();

        setWindowProperties();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            new Opening().setVisible(true);
        });
    }

    private ImageIcon loadImage() {
        URL imageUrl = getClass().getResource("/images/opening.jpg");
        if (imageUrl != null) {
            return new ImageIcon(imageUrl);
        } else {
            return null;
        }
    }

    private void setLookAndFeel() {
        setBackground(Color.GREEN);
        setForeground(Color.GREEN);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 611, 460);
        setLocationRelativeTo(null);
    }

    private JPanel createContentPane() {
        JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        panel.setLayout(null);
        return panel;
    }

    private void addButton() {
        Button button = new Button("ENTRAR");
        button.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        button.setBackground(UIManager.getColor("Button.background"));
        button.setForeground(Color.BLACK);
        button.setBounds(221, 250, 152, 36);
        contentPane.add(button);

        button.addActionListener(e -> onEnterButtonClick(button));
    }

    private void onEnterButtonClick(Button button) {
        button.setEnabled(false);
        JProgressBar progressBar = createProgressBar();
        contentPane.add(progressBar);

        new Thread(() -> {
            for (int i = 0; i <= 100; i++) {
                try {
                    Thread.sleep(25);
                    progressBar.setValue(i);
                } catch (InterruptedException ignored) {
                }
            }

            dispose();
            openMainScreen();
        }).start();
    }

    private JProgressBar createProgressBar() {
        JProgressBar progressBar = new JProgressBar();
        progressBar.setStringPainted(true);
        progressBar.setForeground(Color.BLACK);
        progressBar.setBackground(Color.WHITE);
        progressBar.setIndeterminate(true);
        progressBar.setBounds(100, 307, 402, 36);
        return progressBar;
    }

    private void openMainScreen() {
        MainScreen frame = new MainScreen();
        frame.setVisible(true);
    }

    private void addWelcomeLabel() {
        JLabel lblBemVindo = new JLabel("BEM VINDO");
        lblBemVindo.setBackground(Color.WHITE);
        lblBemVindo.setForeground(Color.WHITE);
        lblBemVindo.setHorizontalAlignment(SwingConstants.CENTER);
        lblBemVindo.setFont(new Font("Comic Sans MS", Font.BOLD, 74));
        lblBemVindo.setBounds(0, 104, 599, 105);
        contentPane.add(lblBemVindo);
    }

    private void addBackgroundImage() {
        JLabel label = new JLabel("");
        label.setIcon(loadImage());
        label.setBounds(0, 0, 611, 460);
        contentPane.add(label);
    }

    private void setWindowProperties() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 611, 460);
        setLocationRelativeTo(null);
    }
}
