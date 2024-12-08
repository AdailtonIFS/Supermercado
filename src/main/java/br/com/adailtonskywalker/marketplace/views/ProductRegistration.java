package br.com.adailtonskywalker.marketplace.views;

import br.com.adailtonskywalker.marketplace.domain.Product;
import br.com.adailtonskywalker.marketplace.factory.ComponentFactory;
import br.com.adailtonskywalker.marketplace.interfaces.Visualization;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.io.IOException;

public class ProductRegistration extends View implements Visualization {
    private JTextField nameField, codeField, priceField, typeField;
    private JTextArea descriptionArea;
    private JSpinner spQuantidadeEstoque;

    public ProductRegistration() throws IOException {
        setTitle("CADASTRO DE PRODUTOS");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 810, 710);
        setLocationRelativeTo(null);

        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panelForm = ComponentFactory.createConfiguredPanel(new Color(255, 204, 153), new Color(0, 0, 0), 2, 186, 24, 423, 600);
        contentPane.add(panelForm);

        setupComponents(panelForm);
        setupButtons(panelForm);
    }

    @Override
    public void setupComponents(JComponent component) {
        if (!(component instanceof JPanel)) {
            throw new IllegalArgumentException("Component must be a JPanel");
        }
        JPanel panel = (JPanel) component;
        final int LABEL_WIDTH = 100;
        final int LABEL_HEIGHT = 25;
        final int FIELD_WIDTH = 200;
        final int FIELD_HEIGHT = 25;
        final int START_X = 40, START_Y = 55, GAP_Y = 55;

        int currentY = START_Y;

        Font boldFont = new Font("Arial", Font.BOLD, 16);
        Font plainFont = new Font("Arial", Font.PLAIN, 13);
        createLabel(panel, "CADASTRO DE PRODUTOS", new Font("Comic Sans MS", Font.BOLD, 20), 100, 10, 400, 25);

        createLabel(panel, "NOME:", boldFont, START_X, START_Y, LABEL_WIDTH, LABEL_HEIGHT);
        nameField = createTextField(panel, plainFont, START_X + LABEL_WIDTH + 10, START_Y, FIELD_WIDTH, FIELD_HEIGHT);
        currentY += GAP_Y;

        createLabel(panel, "CÓDIGO:", boldFont, START_X, currentY, LABEL_WIDTH, LABEL_HEIGHT);
        codeField = createTextField(panel, plainFont, START_X + LABEL_WIDTH + 10, currentY, FIELD_WIDTH, FIELD_HEIGHT);
        currentY += GAP_Y;

        createLabel(panel, "PREÇO:", boldFont, START_X, currentY, LABEL_WIDTH, LABEL_HEIGHT);
        priceField = createTextField(panel, plainFont, START_X + LABEL_WIDTH + 10, currentY, FIELD_WIDTH, FIELD_HEIGHT);
        createLabel(panel, "(utilize \".\" para dividir os valores)", new Font("Arial", Font.BOLD, 12), START_X, currentY + 30, 204, 17);
        currentY += GAP_Y;

        createLabel(panel, "TIPO:", boldFont, START_X, currentY, LABEL_WIDTH, LABEL_HEIGHT);
        typeField = createTextField(panel, plainFont, START_X + LABEL_WIDTH + 10, currentY, FIELD_WIDTH, FIELD_HEIGHT);
        currentY += GAP_Y;

        createLabel(panel, "ESTOQUE:", boldFont, START_X, currentY, LABEL_WIDTH, LABEL_HEIGHT);
        spQuantidadeEstoque = new JSpinner();
        spQuantidadeEstoque.setBounds(START_X + LABEL_WIDTH + 10, currentY, FIELD_WIDTH, FIELD_HEIGHT);
        spQuantidadeEstoque.setModel(new SpinnerNumberModel(0, 0, 1000, 1));
        spQuantidadeEstoque.setFont(new Font("Arial", Font.PLAIN, 13));
        panel.add(spQuantidadeEstoque);
        currentY += GAP_Y;

        createLabel(panel, "DESCRIÇÃO:", boldFont, START_X, currentY, LABEL_WIDTH, LABEL_HEIGHT);
        descriptionArea = new JTextArea();
        descriptionArea.setFont(plainFont);
        descriptionArea.setBorder(new LineBorder(Color.BLACK));
        descriptionArea.setBounds(START_X + LABEL_WIDTH + 10, currentY, FIELD_WIDTH, FIELD_HEIGHT);
        descriptionArea.setLineWrap(true);
        panel.add(descriptionArea);

    }

    @Override
    public void setupButtons(JComponent component) {
        if (!(component instanceof JPanel)) {
            throw new IllegalArgumentException("Component must be a JPanel");
        }
        JPanel panel = (JPanel) component;

        createButton(panel, "SALVAR", new Font("Arial", Font.BOLD, 13),243, 372, 115, 43)
                .addActionListener(e -> salvarProduto());

        createButton(panel, "CANCELAR", new Font("Arial", Font.BOLD, 13), 49, 372, 129, 43)
                .addActionListener(e -> dispose());
    }

    private void salvarProduto() {
        if (nameField.getText().isEmpty() || codeField.getText().isEmpty() || priceField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "TODOS OS CAMPOS SÃO OBRIGATÓRIOS", "ERRO", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            Product produto = new Product();
            produto.setName(nameField.getText());
            produto.setCode(codeField.getText());
            produto.setPrice(Double.parseDouble(priceField.getText()));
            produto.setQStock((Integer) spQuantidadeEstoque.getValue());
            produto.setDescription(descriptionArea.getText());
            produto.setType(typeField.getText());
            produto.gravar();

            JOptionPane.showMessageDialog(null, "CADASTRO REALIZADO COM SUCESSO", "SUCESSO", JOptionPane.INFORMATION_MESSAGE);
            dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                new ProductRegistration().setVisible(true);
            } catch (IOException ignored) {}
        });
    }
}
