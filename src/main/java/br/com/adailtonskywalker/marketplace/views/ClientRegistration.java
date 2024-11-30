package br.com.adailtonskywalker.marketplace.views;

import br.com.adailtonskywalker.marketplace.domain.Client;
import br.com.adailtonskywalker.marketplace.factory.ComponentFactory;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Vector;

public class ClientRegistration extends JFrame {
    private JTextField nameField, codeField, emailField;
    private JFormattedTextField cpfField, rgField, phoneField, cepField;
    private JDateChooser dateChooser;

    public ClientRegistration() throws Exception {
        initUI();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                new ClientRegistration().setVisible(true);
            } catch (Exception ignored) {}
        });
    }

    private void initUI() throws Exception {
        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        setTitle("CADASTRO DE CLIENTES");

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 810, 630);
        setLocationRelativeTo(null);

        JPanel contentPane = createContentPane();
        setContentPane(contentPane);

        JLabel lblClientes = ComponentFactory.createLabelWithFont("CADASTRO DE CLIENTES", new Font("Comic Sans MS", Font.BOLD, 18), 113, 40, 300, 36);
        contentPane.add(lblClientes);

        JPanel panelUp = createTopPanel();
        contentPane.add(panelUp);
    }

    private JPanel createContentPane() {
        JPanel contentPane = new JPanel();
        contentPane.setBackground(new Color(153, 204, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        return contentPane;
    }

    private JPanel createTopPanel() throws Exception {
        JPanel panelUp = ComponentFactory.createConfiguredPanel(new Color(153, 204, 255), new Color(0, 0, 0), 2, 115, 80, 600, 500);
        panelUp.setLayout(null);

        createLabel(panelUp, "NOME:", new Font("Arial", Font.BOLD, 15), 42, 20, 65, 19);
        nameField = createTextField(panelUp, new Font("Arial", Font.PLAIN, 13), 98, 20, 300, 25);

        createLabel(panelUp, "CPF:", new Font("Arial", Font.BOLD, 15), 56, 60, 58, 20);
        cpfField = createFormattedTextField(panelUp, new Font("Arial", Font.PLAIN, 13), new MaskFormatter("###.###.###-##"), 98, 60, 300, 25);

        createLabel(panelUp, "RG:", new Font("Arial", Font.BOLD, 15), 64, 100, 37, 19);
        rgField = createFormattedTextField(panelUp, new Font("Arial", Font.PLAIN, 13), new MaskFormatter("#.###.###-#"), 98, 100, 300, 25);

        createLabel(panelUp, "CÓDIGO:", new Font("Arial", Font.BOLD, 15), 23, 140, 101, 19);
        codeField = createTextField(panelUp, new Font("Arial", Font.PLAIN, 13), 98, 140, 300, 25);

        createLabel(panelUp, "DATA (NASCIMENTO):", new Font("Arial", Font.BOLD, 13), 23, 180, 154, 25);
        dateChooser = new JDateChooser();
        dateChooser.setBorder(new LineBorder(new Color(0, 0, 0)));
        dateChooser.setBounds(98, 180, 300, 25);
        panelUp.add(dateChooser);

        createLabel(panelUp, "SEXO:", new Font("Arial", Font.BOLD, 13), 23, 220, 60, 25);
        JComboBox<String> Sexo = createComboBox(panelUp, new Font("Arial", Font.PLAIN, 12), new Vector<>(Arrays.asList("ESCOLHA SEU SEXO:", "MASCULINO", "FEMININO", "PREFIRO NÃO RESPONDER")));

        createLabel(panelUp, "E-MAIL:", new Font("Arial", Font.BOLD, 13), 23, 260, 71, 25);
        emailField = createTextField(panelUp, new Font("Arial", Font.PLAIN, 13), 98, 260, 300, 25);

        createLabel(panelUp, "TELEFONE:", new Font("Arial", Font.BOLD, 13), 23, 300, 85, 25);
        phoneField = createFormattedTextField(panelUp, new Font("Arial", Font.PLAIN, 13), new MaskFormatter("(##)#####-####"), 98, 300, 300, 25);

        createLabel(panelUp, "CEP:", new Font("Arial", Font.BOLD, 13), 23, 340, 40, 25);
        cepField = createFormattedTextField(panelUp, new Font("Arial", Font.PLAIN, 13), new MaskFormatter("#####-###"), 98, 340, 300, 25);

        JButton btnCancel = createButton(panelUp, "CANCELAR", 51, 113);
        btnCancel.addActionListener(e -> onCancel());

        JButton btnSave = createButton(panelUp, "SALVAR", 255, 113);
        btnSave.addActionListener(e -> onSave(Sexo));

        return panelUp;
    }

    private void onCancel() {
        Object[] options = {"SIM", "NÃO"};
        int cancelOption = JOptionPane.showOptionDialog(null, "TEM CERTEZA QUE DESEJA CANCELAR?", "ALERTA", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        if (cancelOption == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "CADASTRO CANCELADO");
            dispose();
        }
    }

    private void onSave(JComboBox<String> Sexo) {
        Client client = new Client();
        int sexoIndex = Sexo.getSelectedIndex();

        if (isValidInput(sexoIndex)) {
            client.setName(nameField.getText());
            client.setCpf(cpfField.getText());
            client.setPhone(phoneField.getText());
            client.setBornDate(new SimpleDateFormat("dd/MM/yyyy").format(dateChooser.getDate()));
            client.setRg(rgField.getText());
            client.setCep(cepField.getText());
            client.setEmail(emailField.getText());
            client.setCode(codeField.getText());
            client.setGender((String) Sexo.getSelectedItem());

            try {
                client.gravar();
                JOptionPane.showMessageDialog(null, "CADASTRO REALIZADO COM SUCESSO", "CADASTRO", JOptionPane.PLAIN_MESSAGE);
                dispose();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private boolean isValidInput(int sexoIndex) {
        if (nameField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "POR FAVOR INFORME SEU NOME, CAMPO OBRIGATÓRIO");
        } else if (codeField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "POR FAVOR INFORME O CÓDIGO, CAMPO OBRIGATÓRIO");
        } else if (rgField.getText().trim().length() < 11) {
            JOptionPane.showMessageDialog(null, "POR FAVOR INFORME O RG, CAMPO OBRIGATÓRIO");
        } else if (cpfField.getText().trim().length() < 14) {
            JOptionPane.showMessageDialog(null, "POR FAVOR INFORME O CPF, CAMPO OBRIGATÓRIO");
        } else if (dateChooser.getDate() == null) {
            JOptionPane.showMessageDialog(null, "POR FAVOR INFORME A DATA DE NASCIMENTO, CAMPO OBRIGATÓRIO");
        } else if (sexoIndex == 0) {
            JOptionPane.showMessageDialog(null, "GÊNERO INVÁLIDO");
        } else {
            return true;
        }
        return false;
    }

    private void createLabel(JPanel panel, String text, Font font, int x, int y, int width, int height) {
        JLabel label = ComponentFactory.createLabelWithFont(text, font, x, y, width, height);
        panel.add(label);
    }

    private JTextField createTextField(JPanel panel, Font font, int x, int y, int width, int height) {
        JTextField textField = ComponentFactory.createTextField(font, true, x, y, width, height);
        panel.add(textField);
        return textField;
    }

    private JFormattedTextField createFormattedTextField(JPanel panel, Font font, MaskFormatter formatter, int x, int y, int width, int height) {
        JFormattedTextField formattedTextField = ComponentFactory.createFormattedTextField(font, formatter, x, y, width, height);
        panel.add(formattedTextField);
        return formattedTextField;
    }

    private JComboBox<String> createComboBox(JPanel panel, Font font, Vector<String> items) {
        JComboBox<String> comboBox = ComponentFactory.createComboBox(items, font, new LineBorder(Color.BLACK), 98, 220, 300, 25);
        panel.add(comboBox);
        return comboBox;
    }

    private JButton createButton(JPanel panel, String text, int x, int width) {
        JButton button = ComponentFactory.createButton(text, null, new Font("Arial", Font.BOLD, 13), x, 380, width, 41);
        panel.add(button);
        return button;
    }
}
