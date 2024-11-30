package br.com.adailtonskywalker.marketplace.views;

import br.com.adailtonskywalker.marketplace.domain.Client;
import br.com.adailtonskywalker.marketplace.factory.ComponentFactory;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

public class ClientConsult extends JFrame {

    private final Client client;
    private JTextField phoneField, emailField, bornDateField, codeField, addressField, cepField, rgField, genderField, cpfField;
    private JComboBox<String> clientList;

    public ClientConsult() throws IOException {
        client = new Client();

        setTitle("CONSULTAR CLIENTES");
        setIconImage(Toolkit.getDefaultToolkit().getImage(ClientConsult.class.getResource("/images/business_man_usersearch_thesearch_theclient_2356.png")));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 810, 710);
        setLocationRelativeTo(null);

        JPanel contentPane = createContentPane();
        setContentPane(contentPane);

        JPanel panel = createPanel();
        contentPane.add(panel);

        setupComponents(panel);
        setupButtons(panel);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                ClientConsult frame = new ClientConsult();
                frame.setVisible(true);
            } catch (Exception ignored) {
            }
        });
    }

    private JPanel createContentPane() {
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        return contentPane;
    }

    private JPanel createPanel() {
        return ComponentFactory.createConfiguredPanel(new Color(240, 255, 240), new Color(0, 0, 0), 2, 158, 26, 462, 634);
    }

    private void setupComponents(JPanel panel) throws IOException {
        Font boldFont15 = new Font("Arial", Font.BOLD, 15);
        Font plainFont13 = new Font("Arial", Font.PLAIN, 13);

        createLabel(panel, "TELEFONE:", boldFont15, 83, 291, 93, 26);
        createLabel(panel, "EMAIL:", boldFont15, 122, 468, 54, 20);
        createLabel(panel, "DATA", boldFont15, 102, 231, 46, 23);
        createLabel(panel, "CPF:", boldFont15, 140, 153, 36, 21);
        createLabel(panel, "RG:", boldFont15, 145, 199, 31, 21);
        createLabel(panel, "CODIGO:", boldFont15, 112, 424, 74, 22);
        createLabel(panel, "ENDEREÇO:", boldFont15, 83, 338, 93, 20);
        createLabel(panel, "CEP:", boldFont15, 140, 380, 36, 25);
        createLabel(panel, "GÊNERO:", boldFont15, 130, 511, 46, 20);

        phoneField = createTextField(panel, plainFont13, 293);
        emailField = createTextField(panel, plainFont13, 469);
        bornDateField = createTextField(panel, plainFont13, 248);
        codeField = createTextField(panel, plainFont13, 426);
        addressField = createTextField(panel, plainFont13, 339);
        cepField = createTextField(panel, plainFont13, 383);
        rgField = createTextField(panel, plainFont13, 200);
        genderField = createTextField(panel, plainFont13, 512);
        cpfField = createTextField(panel, plainFont13, 154);

        clientList = ComponentFactory.createComboBox(new Vector<>(client.pegarNome()), new Font("Arial", Font.BOLD, 13), new LineBorder(new Color(0, 0, 0), 2, true), 37, 94, 239, 26);
        panel.add(clientList);
    }

    private void setupButtons(JPanel panel) {
        JButton btnBack = createButton("VOLTAR", "/images/back-arrow_icon-icons.com_72866.png", 176, 565);
        panel.add(btnBack);

        JButton btnConsult = createButton("CONSULTAR", "/images/xmag_search_find_export_locate_5984.png", 286, 87);
        panel.add(btnConsult);

        btnConsult.addActionListener(e -> consultClient());

        btnBack.addActionListener(e -> dispose());
    }

    private void consultClient() {
        int index = clientList.getSelectedIndex();
        try {
            if (Client.permission) {
                ArrayList<String> cpfs = client.pegarCPF();
                ArrayList<String> phones = client.pegarTelefone();
                ArrayList<String> addresses = client.pegarEndereco();
                ArrayList<String> genders = client.pegarSexo();
                ArrayList<String> bornDates = client.pegarDataNascimento();
                ArrayList<String> rgs = client.pegarRG();
                ArrayList<String> ceps = client.pegarCEP();
                ArrayList<String> emails = client.pegarEmail();
                ArrayList<String> codes = client.pegarCod();

                cpfField.setText(cpfs.get(index));
                phoneField.setText(phones.get(index));
                addressField.setText(addresses.get(index));
                genderField.setText(genders.get(index));
                bornDateField.setText(bornDates.get(index));
                rgField.setText(rgs.get(index));
                cepField.setText(ceps.get(index));
                emailField.setText(emails.get(index));
                codeField.setText(codes.get(index));
            } else {
                JOptionPane.showMessageDialog(null, "NÃO HÁ CLIENTES CADASTRADOS");
            }
        } catch (IOException ignored) {
        }
    }

    private void createLabel(JPanel panel, String text, Font font, int x, int y, int width, int height) {
        JLabel label = ComponentFactory.createLabelWithFont(text, font, x, y, width, height);
        panel.add(label);
    }

    private JTextField createTextField(JPanel panel, Font font, int y) {
        JTextField textField = ComponentFactory.createTextField(font, false, 186, y, 198, 20);
        panel.add(textField);
        return textField;
    }

    private JButton createButton(String text, String iconPath, int x, int y) {
        return ComponentFactory.createButton(text, iconPath, new Font("Arial", Font.BOLD, 13), x, y, 130, 40);
    }
}

