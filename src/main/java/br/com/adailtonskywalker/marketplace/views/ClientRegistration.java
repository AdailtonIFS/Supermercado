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
import java.util.Objects;
import java.util.Vector;

public class ClientRegistration extends JFrame {
    private JTextField NomeCl, CodCl, email;
    private JFormattedTextField CPF, RG, PHONE, CEP;
    private JDateChooser DataN;

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
        setIconImage(Toolkit.getDefaultToolkit().getImage(ClientRegistration.class.getResource("/images/business_application_addmale_useradd_insert_add_user_client_2312.png")));
        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        setTitle("CADASTRO DE CLIENTES");

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 810, 710);
        setLocationRelativeTo(null);

        JPanel contentPane = createContentPane();
        setContentPane(contentPane);

        JPanel panelCima = createTopPanel();
        contentPane.add(panelCima);

        JPanel panelBaixo = createBottomPanel();
        contentPane.add(panelBaixo);

        addBackgroundImage(contentPane);
    }

    private JPanel createContentPane() {
        JPanel contentPane = new JPanel();
        contentPane.setBackground(new Color(102, 204, 0));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        return contentPane;
    }

    private JPanel createTopPanel() throws Exception {
        JPanel panelCima = ComponentFactory.createConfiguredPanel(new Color(240, 255, 240), new Color(0, 0, 0), 2, 188, 80, 413, 170);
        panelCima.setLayout(null);

        createLabel(panelCima, "NOME:", new Font("Arial", Font.BOLD, 15), 23, 37, 65, 19);
        NomeCl = createTextField(panelCima, new Font("Arial", Font.PLAIN, 13), 98, 38, 165, 19);

        createLabel(panelCima, "CPF:", new Font("Arial", Font.BOLD, 15), 33, 67, 58, 20);
        CPF = createFormattedTextField(panelCima, new Font("Arial", Font.PLAIN, 13), new MaskFormatter("###.###.###-##"), 98, 69, 165, 19);

        createLabel(panelCima, "RG:", new Font("Arial", Font.BOLD, 15), 51, 98, 37, 19);
        RG = createFormattedTextField(panelCima, new Font("Arial", Font.PLAIN, 13), new MaskFormatter("#.###.###-#"), 98, 99, 165, 20);

        createLabel(panelCima, "CÓDIGO:", new Font("Arial", Font.BOLD, 15), 0, 128, 101, 19);
        CodCl = createTextField(panelCima, new Font("Arial", Font.PLAIN, 13), 98, 130, 165, 20);

        JLabel lblClientes = ComponentFactory.createLabelWithFont("CLIENTES", new Font("Comic Sans MS", Font.BOLD, 18), 287, 11, 101, 36);
        panelCima.add(lblClientes);

        return panelCima;
    }

    private JPanel createBottomPanel() throws Exception {
        JPanel panelBaixo = ComponentFactory.createConfiguredPanel(SystemColor.info, new Color(0, 0, 0), 2, 188, 245, 413, 357);
        panelBaixo.setLayout(null);

        createLabel(panelBaixo, "DATA (NASCIMENTO):", new Font("Arial", Font.BOLD, 13), 10, 51, 154, 25);
        DataN = new JDateChooser();
        DataN.setBorder(new LineBorder(new Color(0, 0, 0)));
        DataN.setBounds(174, 51, 195, 25);
        panelBaixo.add(DataN);

        createLabel(panelBaixo, "SEXO:", new Font("Arial", Font.BOLD, 13), 104, 86, 60, 25);
        JComboBox<String> Sexo = createComboBox(panelBaixo, new Font("Arial", Font.PLAIN, 12), new Vector<>(Arrays.asList("ESCOLHA SEU SEXO:", "MASCULINO", "FEMININO", "PREFIRO NÃO RESPONDER")));

        createLabel(panelBaixo, "E-MAIL:", new Font("Arial", Font.BOLD, 13), 93, 122, 71, 25);
        email = createTextField(panelBaixo, new Font("Arial", Font.PLAIN, 13), 174, 123, 195, 25);

        createLabel(panelBaixo, "TELEFONE:", new Font("Arial", Font.BOLD, 13), 93, 158, 85, 25);
        PHONE = createFormattedTextField(panelBaixo, new Font("Arial", Font.PLAIN, 13), new MaskFormatter("(##)#####-####"), 174, 159, 195, 25);

        createLabel(panelBaixo, "CEP:", new Font("Arial", Font.BOLD, 13), 120, 230, 40, 25);
        CEP = createFormattedTextField(panelBaixo, new Font("Arial", Font.PLAIN, 13), new MaskFormatter("#####-###"), 174, 231, 195, 25);

        JButton btnCancel = createButton(panelBaixo, "CANCELAR", "/images/delete_delete_deleteusers_delete_male_user_maleclient_2348.png", 51, 113);
        btnCancel.addActionListener(e -> onCancel());

        JButton btnSave = createButton(panelBaixo, "SALVAR", "/images/businessapplication_accept_ok_male_man_you_negocio_2311.png", 255, 114);
        btnSave.addActionListener(e -> onSave(Sexo));

        return panelBaixo;
    }

    private void addBackgroundImage(JPanel contentPane) {
        JLabel label = new JLabel("");
        label.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
        label.setIcon(new ImageIcon(Objects.requireNonNull(ClientRegistration.class.getResource("/images/Compartilhada do Lightroom mobile.jpg"))));
        label.setBounds(0, 0, 794, 671);
        contentPane.add(label);
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
            client.setName(NomeCl.getText());
            client.setCpf(CPF.getText());
            client.setPhone(PHONE.getText());
            client.setBornDate(new SimpleDateFormat("dd/MM/yyyy").format(DataN.getDate()));
            client.setRg(RG.getText());
            client.setCep(CEP.getText());
            client.setEmail(email.getText());
            client.setCode(CodCl.getText());
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
        if (NomeCl.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "POR FAVOR INFORME SEU NOME, CAMPO OBRIGATÓRIO");
        } else if (CodCl.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "POR FAVOR INFORME O CÓDIGO, CAMPO OBRIGATÓRIO");
        } else if (RG.getText().trim().length() < 11) {
            JOptionPane.showMessageDialog(null, "POR FAVOR INFORME O RG, CAMPO OBRIGATÓRIO");
        } else if (CPF.getText().trim().length() < 14) {
            JOptionPane.showMessageDialog(null, "POR FAVOR INFORME O CPF, CAMPO OBRIGATÓRIO");
        } else if (DataN.getDate() == null) {
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
        JComboBox<String> comboBox = ComponentFactory.createComboBox(items, font, new LineBorder(Color.BLACK), 174, 87, 195, 25);
        panel.add(comboBox);
        return comboBox;
    }

    private JButton createButton(JPanel panel, String text, String iconPath, int x, int width) {
        JButton button = ComponentFactory.createButton(text, iconPath, new Font("Arial", Font.BOLD, 13), x, 291, width, 41);
        panel.add(button);
        return button;
    }
}
