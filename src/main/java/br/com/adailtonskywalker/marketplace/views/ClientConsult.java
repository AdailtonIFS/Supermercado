package br.com.adailtonskywalker.marketplace.views;

import br.com.adailtonskywalker.marketplace.domain.Client;
import br.com.adailtonskywalker.marketplace.factory.ComponentFactory;
import br.com.adailtonskywalker.marketplace.interfaces.Visualization;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

public class ClientConsult extends View implements Visualization {

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

    @Override
    public void setupComponents(JComponent component) throws IOException {
        if (!(component instanceof JPanel)) {
            throw new IllegalArgumentException("Component must be a JPanel");
        }
        JPanel panel = (JPanel) component;

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

        phoneField = createTextField(panel, plainFont13, 186, 293, 198, 20);
        emailField = createTextField(panel, plainFont13, 186, 469, 198, 20);
        bornDateField = createTextField(panel, plainFont13, 186,  248, 198, 20);
        codeField = createTextField(panel, plainFont13, 186,  426, 198, 20);
        addressField = createTextField(panel, plainFont13, 186,  339, 198, 20);
        cepField = createTextField(panel, plainFont13, 186,  383, 198, 20);
        rgField = createTextField(panel, plainFont13, 186,  200, 198, 20);
        genderField = createTextField(panel, plainFont13, 186,  512, 198, 20);
        cpfField = createTextField(panel, plainFont13, 186,  154, 198, 20);

        clientList = ComponentFactory.createComboBox(new Vector<>(client.pegarNome()), new Font("Arial", Font.BOLD, 13), new LineBorder(new Color(0, 0, 0), 2, true), 37, 94, 239, 26);
        panel.add(clientList);
    }

    @Override
    public void setupButtons(JComponent component) {
        if (!(component instanceof JPanel)) {
            throw new IllegalArgumentException("Component must be a JPanel");
        }
        JPanel panel = (JPanel) component;
        Font plainFont13 = new Font("Arial", Font.PLAIN, 13);
        createButton(panel, "VOLTAR", plainFont13, 176, 565, 130, 40).addActionListener(e -> dispose());
        createButton(panel, "CONSULTAR", plainFont13, 286, 87, 130, 40).addActionListener(e -> consultClient());
    }

    private void consultClient() {
        int index = clientList.getSelectedIndex();
        try {
            if (Client.permission) {
                ArrayList<Client> clients = client.getClients();
                Client client = clients.get(index);
                cpfField.setText(client.getCpf());
                phoneField.setText(client.getPhone());
                addressField.setText(client.getAddress());
                genderField.setText(client.getGender());
                bornDateField.setText(client.getBornDate());
                rgField.setText(client.getRg());
                cepField.setText(client.getCep());
                emailField.setText(client.getEmail());
                codeField.setText(client.getCode());
            } else {
                JOptionPane.showMessageDialog(null, "NÃO HÁ CLIENTES CADASTRADOS");
            }
        } catch (IOException ignored) {
        }
    }
}

