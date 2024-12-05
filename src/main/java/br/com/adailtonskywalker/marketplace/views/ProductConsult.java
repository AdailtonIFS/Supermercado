package br.com.adailtonskywalker.marketplace.views;

import br.com.adailtonskywalker.marketplace.domain.Product;
import br.com.adailtonskywalker.marketplace.factory.ComponentFactory;
import br.com.adailtonskywalker.marketplace.interfaces.Visualization;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

public class ProductConsult extends View implements Visualization {
    private final Product product = new Product();
    private JComboBox<String> productNameList;
    private JTextField stockField, descriptionField, codeField, typeField, priceField;

    public ProductConsult() throws IOException {
        setTitle("CONSULTAR PRODUTOS");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 810, 710);
        setLocationRelativeTo(null);

        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = ComponentFactory.createConfiguredPanel(new Color(255, 222, 173), new Color(0, 0, 0), 1, 190, 44, 443, 573);
        contentPane.add(panel);

        setupComponents(panel);
        setupButtons(panel);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                new ProductConsult().setVisible(true);
            } catch (Exception ignored) {
            }
        });
    }

    @Override
    public void setupComponents(JPanel panel) throws IOException {
        final int LABEL_WIDTH = 100;
        final int LABEL_HEIGHT = 25;
        final int FIELD_WIDTH = 200;
        final int FIELD_HEIGHT = 25;
        final int START_X = 60, START_Y = 220, GAP_Y = 55;

        int currentY = START_Y;
        Font arialBold15 = new Font("Arial", Font.BOLD, 15);
        Font arialPlain13 = new Font("Arial", Font.PLAIN, 13);

        createLabel(panel, "PREÇO:", arialBold15, START_X, START_Y, LABEL_WIDTH, LABEL_HEIGHT);
        priceField = createTextField(panel, arialPlain13, START_X + LABEL_WIDTH + 10, START_Y, FIELD_WIDTH, FIELD_HEIGHT);
        currentY += GAP_Y;

        createLabel(panel, "CODIGO:", arialBold15, START_X, currentY, LABEL_WIDTH, LABEL_HEIGHT);
        codeField = createTextField(panel, arialPlain13, START_X + LABEL_WIDTH + 10, currentY, FIELD_WIDTH, FIELD_HEIGHT);
        currentY += GAP_Y;

        createLabel(panel, "ESTOQUE:", arialBold15, START_X, currentY, LABEL_WIDTH, LABEL_HEIGHT);
        stockField = createTextField(panel, arialPlain13, START_X + LABEL_WIDTH + 10, currentY, FIELD_WIDTH, FIELD_HEIGHT);
        currentY += GAP_Y;

        createLabel(panel, "DESCRIÇÃO:", arialBold15, START_X, currentY, LABEL_WIDTH, LABEL_HEIGHT);
        descriptionField = createTextField(panel, arialPlain13, START_X + LABEL_WIDTH + 10, currentY, FIELD_WIDTH, FIELD_HEIGHT);
        currentY += GAP_Y;

        createLabel(panel, "TIPO:", arialBold15, START_X, currentY, LABEL_WIDTH, LABEL_HEIGHT);
        typeField = createTextField(panel, arialPlain13, START_X + LABEL_WIDTH + 10, currentY, FIELD_WIDTH, FIELD_HEIGHT);

        createLabel(panel, "PESQUISAR", new Font("Comic Sans MS", Font.BOLD, 20), 169, 49, 134, 33);

        JLabel line = ComponentFactory.createLabelBorder("", new MatteBorder(0, 0, 1, 0, new Color(0, 0, 0)), 29, 79, 386, 14);
        panel.add(line);

        JLabel square = ComponentFactory.createLabelBorder("", new LineBorder(new Color(0, 0, 0), 1, true), 29, 181, 386, 378);
        panel.add(square);

        productNameList = ComponentFactory.createComboBox(new Vector<>(product.pegarNome()), arialPlain13, new LineBorder(new Color(0, 0, 0), 1, true), 29, 123, 246, 33);
        panel.add(productNameList);
    }

    @Override
    public void setupButtons(JPanel panel) {
        JButton btnPesquise = new JButton("VOLTAR");
        btnPesquise.setBackground(UIManager.getColor("Button.background"));
        btnPesquise.setFont(new Font("Arial", Font.BOLD, 13));
        btnPesquise.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
        btnPesquise.setBounds(169, 496, 134, 37);
        panel.add(btnPesquise);


        JButton btnConsultar = new JButton("CONSULTAR");
        btnConsultar.setBackground(UIManager.getColor("Button.background"));
        btnConsultar.setFont(new Font("Arial", Font.BOLD, 13));
        btnConsultar.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
        btnConsultar.setBounds(289, 116, 126, 45);
        panel.add(btnConsultar);


        btnConsultar.addActionListener(e -> {
            int index = productNameList.getSelectedIndex();
            try {
                if (Product.permission) {
                    ArrayList<String> PRECO = product.pegarPreco();
                    ArrayList<String> CODIGO = product.pegarCodigo();
                    ArrayList<String> DESCRICAO = product.pegarDescricao();
                    ArrayList<String> ESTOQUE = product.pegarEstoque();
                    ArrayList<String> TIPO = product.pegarTipo();

                    priceField.setText(PRECO.get(index));
                    codeField.setText(CODIGO.get(index));
                    descriptionField.setText(DESCRICAO.get(index));
                    stockField.setText(ESTOQUE.get(index));
                    typeField.setText(TIPO.get(index));

                } else {
                    JOptionPane.showMessageDialog(null, "NÃO HÁ PRODUTOS CADASTRADOS");
                }

            } catch (Exception ignored) {
            }
        });

        btnPesquise.addActionListener(e -> dispose());
    }
}
