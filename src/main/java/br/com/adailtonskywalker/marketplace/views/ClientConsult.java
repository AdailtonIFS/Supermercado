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

    private JTextField mostrarTelefone, mostrarEmail, mostrarDataNascimento, mostrarCodigo;
    private JTextField mostrarEndereco, mostrarCEP, mostrarRg, mostrarSexo, mostrarCPF;
    private JComboBox<String> nameList;
    private final Client Ct;

    public ClientConsult() throws IOException {
        Ct = new Client();

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

        mostrarTelefone = createTextField(panel, plainFont13, 293);
        mostrarEmail = createTextField(panel, plainFont13, 469);
        mostrarDataNascimento = createTextField(panel, plainFont13, 248);
        mostrarCodigo = createTextField(panel, plainFont13, 426);
        mostrarEndereco = createTextField(panel, plainFont13, 339);
        mostrarCEP = createTextField(panel, plainFont13, 383);
        mostrarRg = createTextField(panel, plainFont13, 200);
        mostrarSexo = createTextField(panel, plainFont13, 512);
        mostrarCPF = createTextField(panel, plainFont13, 154);

        // Criar ComboBox
        nameList = ComponentFactory.createComboBox(new Vector<String>(Ct.pegarNome()), new Font("Arial", Font.BOLD, 13), new LineBorder(new Color(0, 0, 0), 2, true), 37, 94, 239, 26);
        panel.add(nameList);
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
        int index = nameList.getSelectedIndex();
        try {
            if (Client.permission) {
                ArrayList<String> cpfs = Ct.pegarCPF();
                ArrayList<String> phones = Ct.pegarTelefone();
                ArrayList<String> addresses = Ct.pegarEndereco();
                ArrayList<String> genders = Ct.pegarSexo();
                ArrayList<String> bornDates = Ct.pegarDataNascimento();
                ArrayList<String> rgs = Ct.pegarRG();
                ArrayList<String> ceps = Ct.pegarCEP();
                ArrayList<String> emails = Ct.pegarEmail();
                ArrayList<String> codes = Ct.pegarCod();

                mostrarCPF.setText(cpfs.get(index));
                mostrarTelefone.setText(phones.get(index));
                mostrarEndereco.setText(addresses.get(index));
                mostrarSexo.setText(genders.get(index));
                mostrarDataNascimento.setText(bornDates.get(index));
                mostrarRg.setText(rgs.get(index));
                mostrarCEP.setText(ceps.get(index));
                mostrarEmail.setText(emails.get(index));
                mostrarCodigo.setText(codes.get(index));
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

