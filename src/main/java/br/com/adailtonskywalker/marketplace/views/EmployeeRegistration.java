package br.com.adailtonskywalker.marketplace.views;

import br.com.adailtonskywalker.marketplace.domain.Employee;
import br.com.adailtonskywalker.marketplace.factory.ComponentFactory;
import br.com.adailtonskywalker.marketplace.interfaces.Visualization;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class EmployeeRegistration extends View implements Visualization {

    private JTextField nameField, codeField;
    private JTextField addressFiel;
    private JTextField salaryField;
    private JTextField officeField;
    private JFormattedTextField rgField;
    private JFormattedTextField phoneField;
    private JFormattedTextField cepField;
    private JFormattedTextField cpfField;
    private JDateChooser bornDateField;
    private JComboBox<String> genderField;
    private final Employee employee;

    public EmployeeRegistration() throws ParseException {
        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        setTitle("CADASTRO DE FUNCIONÁRIOS");

        employee = new Employee();

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 810, 710);
        setLocationRelativeTo(null);

        JPanel contentPane = new JPanel();
        contentPane.setBackground(new Color(245, 245, 220));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = ComponentFactory.createConfiguredPanel(new Color(240, 255, 240), new Color(0, 0, 0), 0, 178, 34, 445, 600);
        contentPane.add(panel);
        setupComponents(panel);
        setupButtons(panel);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                new EmployeeRegistration().setVisible(true);
            } catch (Exception ignored) {}
        });
    }

    @Override
    public void setupComponents(JPanel panel) throws ParseException {
        createLabel(panel, "FUNCIONÁRIOS", new Font("Comic Sans MS", Font.BOLD, 18), 30, 11, 159, 50);
        JLabel line = ComponentFactory.createLabelBorder("", new MatteBorder(0, 0, 2, 0, new Color(0, 0, 0)), 30, 42, 148, 14);
        panel.add(line);

        final int LABEL_WIDTH = 140;
        final int LABEL_HEIGHT = 25;
        final int FIELD_WIDTH = 210;
        final int FIELD_HEIGHT = 25;
        final int START_X = 40, START_Y = 100, GAP_Y = 40;

        Font arialBold15 = new Font("Arial", Font.BOLD, 15);
        Font arialPlain13 = new Font("Arial", Font.PLAIN, 13);

        int currentY = START_Y;

        createLabel(panel, "NOME:", arialBold15, START_X, currentY, LABEL_WIDTH, LABEL_HEIGHT);
        nameField = createTextField(panel, arialPlain13, START_X + LABEL_WIDTH + 10, currentY, FIELD_WIDTH, FIELD_HEIGHT);
        currentY += GAP_Y;

        MaskFormatter rgMask = new MaskFormatter("#.###.###-#");
        createLabel(panel, "RG:", arialBold15, START_X, currentY, LABEL_WIDTH, LABEL_HEIGHT);
        rgField = createFormattedTextField(panel, arialPlain13, rgMask, START_X + LABEL_WIDTH + 10, currentY, FIELD_WIDTH, FIELD_HEIGHT);
        currentY += GAP_Y;

        MaskFormatter cpfMask = new MaskFormatter("###.###.###-##");
        createLabel(panel, "CPF:", arialBold15, START_X, currentY, LABEL_WIDTH, LABEL_HEIGHT);
        cpfField = createFormattedTextField(panel, arialPlain13, cpfMask, START_X + LABEL_WIDTH + 10, currentY, FIELD_WIDTH, FIELD_HEIGHT);
        currentY += GAP_Y;

        createLabel(panel, "CÓDIGO:", arialBold15, START_X, currentY, LABEL_WIDTH, LABEL_HEIGHT);
        codeField = createTextField(panel, arialPlain13, START_X + LABEL_WIDTH + 10, currentY, FIELD_WIDTH, FIELD_HEIGHT);
        currentY += GAP_Y;

        createLabel(panel, "DATA (NASCIMENTO):", arialBold15, START_X, currentY, LABEL_WIDTH, LABEL_HEIGHT);
        bornDateField = new JDateChooser();
        bornDateField.setBorder(new LineBorder(Color.BLACK));
        bornDateField.setBounds(START_X + LABEL_WIDTH + 10, currentY, FIELD_WIDTH, FIELD_HEIGHT);
        panel.add(bornDateField);
        currentY += GAP_Y;

        createLabel(panel, "SEXO:", arialBold15, START_X, currentY, LABEL_WIDTH, LABEL_HEIGHT);
        genderField = new JComboBox<>();
        genderField.setFont(arialPlain13);
        genderField.setBorder(new LineBorder(Color.BLACK));
        genderField.setBounds(START_X + LABEL_WIDTH + 10, currentY, FIELD_WIDTH, FIELD_HEIGHT);
        panel.add(genderField);
        genderField.addItem("ESCOLHA SEU SEXO:");
        genderField.addItem("MASCULINO");
        genderField.addItem("FEMININO");
        genderField.addItem("PREFIRO NÃO RESPONDER");
        currentY += GAP_Y;

        createLabel(panel, "SALÁRIO:", arialBold15, START_X, currentY, LABEL_WIDTH, LABEL_HEIGHT);
        salaryField = createTextField(panel, arialPlain13, START_X + LABEL_WIDTH + 10, currentY, FIELD_WIDTH, FIELD_HEIGHT);
        currentY += GAP_Y;

        MaskFormatter phoneMask = new MaskFormatter("(##)#####-####");
        createLabel(panel, "TELEFONE:", arialBold15, START_X, currentY, LABEL_WIDTH, LABEL_HEIGHT);
        phoneField = createFormattedTextField(panel, arialPlain13, phoneMask, START_X + LABEL_WIDTH + 10, currentY, FIELD_WIDTH, FIELD_HEIGHT);
        currentY += GAP_Y;

        createLabel(panel, "ENDEREÇO:", arialBold15, START_X, currentY, LABEL_WIDTH, LABEL_HEIGHT);
        addressFiel = createTextField(panel, arialPlain13, START_X + LABEL_WIDTH + 10, currentY, FIELD_WIDTH, FIELD_HEIGHT);
        currentY += GAP_Y;

        MaskFormatter cepMask = new MaskFormatter("#####-###");
        createLabel(panel, "CEP:", arialBold15, START_X, currentY, LABEL_WIDTH, LABEL_HEIGHT);
        cepField = createFormattedTextField(panel, arialPlain13, cepMask, START_X + LABEL_WIDTH + 10, currentY, FIELD_WIDTH, FIELD_HEIGHT);
        currentY += GAP_Y;

        createLabel(panel, "CARGO:", arialBold15, START_X, currentY, LABEL_WIDTH, LABEL_HEIGHT);
        officeField = createTextField(panel, arialPlain13, START_X + LABEL_WIDTH + 10, currentY, FIELD_WIDTH, FIELD_HEIGHT);
    }

    @Override
    public void setupButtons(JPanel panel) {
        JButton cancelButton = createButton(panel, "CANCELAR", new Font("Arial", Font.BOLD, 13), 70, 560, 125, 35);
        cancelButton.setBackground(new Color(224, 224, 224));
        cancelButton.addActionListener(e -> dispose());
        panel.add(cancelButton);

        JButton saveButton = createButton(panel, "SALVAR", new Font("Arial", Font.BOLD, 13), 240, 560, 116, 35);
        saveButton.setBackground(new Color(136, 127, 23));
        saveButton.setForeground(Color.WHITE);
        saveButton.addActionListener(e ->
        {
            int index = genderField.getSelectedIndex();

            if (nameField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "POR FAVOR INFORME SEU NOME, CAMPO OBRIGATÓRIO");
            } else if (rgField.getText().trim().length() < 11) {
                JOptionPane.showMessageDialog(null, "POR FAVOR INFORME O RG, CAMPO OBRIGATÓRIO");
            } else if (cpfField.getText().trim().length() < 14) {
                JOptionPane.showMessageDialog(null, "POR FAVOR INFORME O CPF, CAMPO OBRIGATÓRIO");
            } else if (codeField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "POR FAVOR INFORME O CÓDIGO, CAMPO OBRIGATÓRIO");
            } else if (bornDateField.getDate() == null) {
                JOptionPane.showMessageDialog(null, "POR FAVOR INFORME A DATA DE NASCIMENTO, CAMPO OBRIGATÓRIO");
            } else if (index == 0) {
                JOptionPane.showMessageDialog(null, "GÊNERO INVÁLIDO");
            } else if (index > 0 && index < 3) {
                employee.setGender((String) genderField.getSelectedItem());
            } else if (index == 3) {
                employee.setGender((String) genderField.getSelectedItem());
                JOptionPane.showMessageDialog(null, "OK, COMPREENDEMOS");
            }

            if (!(nameField.getText().isEmpty() || codeField.getText().isEmpty() || cpfField.getText().trim().length() < 14 || index == 0)) {
                employee.setName(nameField.getText());
                employee.setCode(codeField.getText());
                employee.setCpf(cpfField.getText());
                employee.setRg(rgField.getText());

                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                String formattedDate = dateFormat.format(bornDateField.getDate());

                employee.setBornDate(formattedDate);
                employee.setSalar(Double.parseDouble(salaryField.getText()));
                employee.setPhone(phoneField.getText());
                employee.setAddress(addressFiel.getText());
                employee.setOffice(officeField.getText());
                employee.setCep(cepField.getText());

                try { employee.gravar(); } catch (Exception ignored) {}
                dispose();
            }
        });
        panel.add(saveButton);
    }
}
