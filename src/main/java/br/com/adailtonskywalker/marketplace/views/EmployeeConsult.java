package br.com.adailtonskywalker.marketplace.views;

import br.com.adailtonskywalker.marketplace.domain.Employee;
import br.com.adailtonskywalker.marketplace.factory.ComponentFactory;
import br.com.adailtonskywalker.marketplace.interfaces.Visualization;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.io.IOException;
import java.util.List;
import java.util.Vector;

public class EmployeeConsult extends View implements Visualization {

    private final JPanel contentPane;
    private final Employee employee = new Employee();
    private JTextField cpfField, phoneField, addressField, genderField, bornDateField, rgField, cepField, salarField, codeField, officeField;
    private JComboBox<String> employeeNameList;

    public EmployeeConsult() throws IOException {
        setTitle("CONSULTAR FUNCIONÁRIOS");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 810, 710);
        setLocationRelativeTo(null);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = ComponentFactory.createConfiguredPanel(new Color(245, 245, 220), new Color(0, 0, 0), 0, 144, 11, 492, 649);
        contentPane.add(panel);

        setupComponents(panel);
        setupButtons(panel);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                new EmployeeConsult().setVisible(true);
            } catch (Exception ignored) {
            }
        });
    }

    public void setupButtons(JPanel panel) {
        createButton(panel, "VOLTAR", null, new Font("Arial", Font.BOLD, 13), 177, 603, 126, 35).addActionListener(e -> dispose());
        createButton(panel, "CONSULTAR", null, new Font("Arial", Font.BOLD, 13), 310, 68, 156, 41).addActionListener(e -> {
            try {
                fillFields();
            } catch (Exception ignored) {
            }
        });
    }

    public void setupComponents(JPanel panel) throws IOException {
        Font plainFont13 = new Font("Arial", Font.PLAIN, 13);
        Font boldFont15 = new Font("Arial", Font.BOLD, 15);

        employeeNameList = ComponentFactory.createComboBox(new Vector<>(employee.pegarNome()), new Font("Arial", Font.BOLD, 13), new LineBorder(new Color(0, 0, 0), 1, true), 25, 74, 261, 29);
        panel.add(employeeNameList);

        int fieldWidth = 220, fieldHeight = 25;
        cpfField = createTextField(panel, plainFont13, 214, 154, fieldWidth, fieldHeight);
        rgField = createTextField(panel, plainFont13, 214, 196, fieldWidth, fieldHeight);
        bornDateField = createTextField(panel, plainFont13, 214, 239, fieldWidth, fieldHeight);
        phoneField = createTextField(panel, plainFont13, 214, 284, fieldWidth, fieldHeight);
        addressField = createTextField(panel, plainFont13, 214, 329, fieldWidth, fieldHeight);
        cepField = createTextField(panel, plainFont13, 214, 375, fieldWidth, fieldHeight);
        codeField = createTextField(panel, plainFont13, 214, 421, fieldWidth, fieldHeight);
        salarField = createTextField(panel, plainFont13, 214, 469, fieldWidth, fieldHeight);
        genderField = createTextField(panel, plainFont13, 214, 516, fieldWidth, fieldHeight);
        officeField = createTextField(panel, plainFont13, 214, 564, fieldWidth, fieldHeight);

        JLabel lineForm = ComponentFactory.createLabelBorder("", new LineBorder(new Color(0, 0, 0), 1, true), 25, 120, 441, 518);
        panel.add(lineForm);

        JLabel lineHeaderForm = ComponentFactory.createLabelBorder("", new MatteBorder(0, 0, 1, 0, Color.BLACK), 25, 37, 441, 14);
        panel.add(lineHeaderForm);

        createLabel(panel, "PESQUISAR", new Font("Comic Sans MS", Font.BOLD, 20), 177, 11, 147, 40);
        createLabel(panel, "TELEFONE:", boldFont15, 112, 284, 92, 19);
        createLabel(panel, "CARGO:", boldFont15, 136, 565, 68, 16);
        createLabel(panel, "SALÁRIO:", boldFont15, 125, 468, 68, 20);
        createLabel(panel, "DATA (NASCIMENTO):", boldFont15, 37, 239, 170, 19);
        createLabel(panel, "CPF:", boldFont15, 156, 153, 37, 20);
        createLabel(panel, "RG:", boldFont15, 164, 197, 29, 17);
        createLabel(panel, "CÓDIGO:", boldFont15, 125, 422, 68, 17);
        createLabel(panel, "ENDEREÇO:", boldFont15, 109, 329, 95, 18);
        createLabel(panel, "CEP:", boldFont15, 156, 376, 37, 17);
        createLabel(panel, "GÊNERO:", boldFont15, 127, 517, 80, 25);
    }

    public void fillFields() throws IOException {

        int index = employeeNameList.getSelectedIndex();

        if (Employee.permission) {
            List<Employee> employees = employee.getEmployees();
            Employee foundedEmployee = employees.get(index);

            cpfField.setText(foundedEmployee.getCpf());
            phoneField.setText(foundedEmployee.getPhone());
            addressField.setText(foundedEmployee.getAddress());
            genderField.setText(foundedEmployee.getGender());
            bornDateField.setText(foundedEmployee.getBornDate());
            rgField.setText(foundedEmployee.getRg());
            cepField.setText(foundedEmployee.getCep());
            salarField.setText(String.valueOf(foundedEmployee.getSalar()));
            codeField.setText(foundedEmployee.getCode());
            officeField.setText(foundedEmployee.getOffice());
        } else {
            JOptionPane.showMessageDialog(null, "N�O H� FUNCION�RIOS CADASTRADOS");
        }
    }
}
