package br.com.adailtonskywalker.marketplace.views;

import br.com.adailtonskywalker.marketplace.domain.Client;
import br.com.adailtonskywalker.marketplace.domain.Product;
import br.com.adailtonskywalker.marketplace.factory.ComponentFactory;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Sales extends JFrame {
    private final JTextField codeField, priceField, typeField, stockField, cpfField, rgField, clientCodeField, phoneField, addressField, cepField, totalPriceField;
    private final JComboBox<String> clientNameList;
    private final JSpinner quantitySpinner;
    private final Product product = new Product();
    private final Client client = new Client();

    double total = 0;
    List<String> ticketList = new ArrayList<>();
    boolean cpf = false;

    public Sales() throws IOException {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        DefaultListModel<String> ticketListData = new DefaultListModel<>();
        setTitle("REALIZAR VENDA");
        setBounds(100, 100, 810, 710);
        setLocationRelativeTo(null);

        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        Font fontPlain13 = new Font("Arial", Font.PLAIN, 13);

        Panel clientPanel = new Panel();
        clientPanel.setBackground(new Color(250, 250, 210));
        clientPanel.setBounds(0, 308, 794, 363);
        contentPane.add(clientPanel);
        clientPanel.setLayout(null);

        JPanel productPanel = new JPanel();
        productPanel.setBackground(new Color(255, 228, 181));
        productPanel.setBounds(0, 0, 794, 309);
        contentPane.add(productPanel);
        productPanel.setLayout(null);

        JLabel nameLabel = new JLabel("NOME:");
        nameLabel.setFont(new Font("Arial", Font.BOLD, 13));
        nameLabel.setBounds(21, 13, 46, 31);
        productPanel.add(nameLabel);

        JList<String> listComponent = new JList<>();
        listComponent.setBounds(0, 0, 0, 0);
        productPanel.add(listComponent);

        JComboBox<String> productNameList = new JComboBox<>(new Vector<>(product.pegarNome()));
        productNameList.setForeground(Color.BLACK);
        productNameList.setBackground(Color.WHITE);
        productNameList.setFont(new Font("Arial", Font.PLAIN, 15));
        productNameList.setBorder(new LineBorder(new Color(0, 0, 0), 2));
        productNameList.setBounds(66, 14, 374, 36);
        productPanel.add(productNameList);

        totalPriceField = ComponentFactory.createTextField(fontPlain13, true, 450, 271, 143, 20);
        productPanel.add(totalPriceField);

        codeField = ComponentFactory.createTextField(fontPlain13, true, 179, 70, 119, 20);
        productPanel.add(codeField);

        priceField = ComponentFactory.createTextField(fontPlain13, true, 179, 105, 119, 20);
        productPanel.add(priceField);

        typeField = ComponentFactory.createTextField(fontPlain13, true, 179, 136, 119, 20);
        productPanel.add(typeField);

        stockField = ComponentFactory.createTextField(fontPlain13, true, 179, 167, 119, 20);
        productPanel.add(stockField);

        JButton searchProductButton = ComponentFactory.createButton("PESQUISAR", null, fontPlain13, 450, 14, 173, 37);
        productPanel.add(searchProductButton);

        searchProductButton.addActionListener(e -> {
            try {
                if (!Product.permission) {
                    JOptionPane.showMessageDialog(null, "N�O H� PRODUTOS CADASTRADOS");
                }

                int index = productNameList.getSelectedIndex();
                ArrayList<Product> products = product.getProducts();
                Product product = products.get(index);

                priceField.setText(String.valueOf(product.getPrice()));
                codeField.setText(product.getCode());
                stockField.setText(String.valueOf(product.getQStock()));
                typeField.setText(product.getType());
            } catch (IOException ignored) {
            }
        });

        quantitySpinner = new JSpinner();
        quantitySpinner.setBorder(new LineBorder(Color.BLACK, 2));
        quantitySpinner.setModel(new SpinnerNumberModel(1, 1, 100000000, 1));
        quantitySpinner.setBounds(179, 209, 52, 22);
        productPanel.add(quantitySpinner);

        JButton addProductButton = ComponentFactory.createButton("ADICIONAR PRODUTO", null, fontPlain13, 66, 242, 212, 47);
        productPanel.add(addProductButton);
        addProductButton.addActionListener(e -> {
            int in = productNameList.getSelectedIndex();

            try {
                ArrayList<Product> products = product.getProducts();
                Product product = products.get(in);

                int quantity = (Integer.parseInt(quantitySpinner.getValue().toString()));

                if (quantity > product.getQStock()) {
                    JOptionPane.showMessageDialog(null, "QUANTIDADE INVÁLIDA");
                } else {
                    String name = (String) productNameList.getSelectedItem();
                    double itemPrice = product.getPrice() * quantity;

                    product.gravarDadosVenda("_________________");
                    product.gravarDadosVenda("NOME DO PRODUTO");
                    product.gravarDadosVenda(name);
                    product.gravarDadosVenda("TIPO");
                    product.gravarDadosVenda(product.getType());
                    product.gravarDadosVenda("CÓDIGO");
                    product.gravarDadosVenda(product.getCode());
                    product.gravarDadosVenda("PREÇO UNITÁRIO");
                    product.gravarDadosVenda(String.valueOf(product.getPrice()));
                    total = total + itemPrice;
                    product.gravarDadosVenda("PREÇO TOTAL");
                    product.gravarDadosVenda(String.valueOf(total));

                    String ticket = String.format("|   %s   |   %s   |   %s   |  %6.2f  |   %d   |   %6.2f   |", name, product.getCode(), product.getType(), product.getPrice(), quantity, itemPrice);
                    ticketList.add(ticket);
                    ticketListData.addElement(ticket);
                    listComponent.setModel(ticketListData);
                    totalPriceField.setText(String.valueOf(total));
                }
            } catch (IOException ignored) {
            }
        });

        JLabel codeProductLabel = ComponentFactory.createLabelWithFont("CÓDIGO:", fontPlain13, 105, 71, 64, 16);
        productPanel.add(codeProductLabel);

        JLabel unitPriceLabel = ComponentFactory.createLabelWithFont("PREÇO UNITÁRIO:", fontPlain13, 45, 103, 124, 22);
        productPanel.add(unitPriceLabel);

        JLabel typeLabel = ComponentFactory.createLabelWithFont("TIPO:", fontPlain13, 123, 138, 46, 17);
        productPanel.add(typeLabel);

        JLabel stockLabel = ComponentFactory.createLabelWithFont("ESTOQUE:", fontPlain13, 98, 168, 71, 17);
        productPanel.add(stockLabel);

        JLabel quantityLabel = ComponentFactory.createLabelWithFont("QUANTIDADE:", fontPlain13, 76, 208, 93, 21);
        productPanel.add(quantityLabel);

        JLabel totalPriceLabel = ComponentFactory.createLabelWithFont("PREÇO TOTAL:", fontPlain13, 348, 271, 101, 18);
        productPanel.add(totalPriceLabel);

        JLabel productHeader = ComponentFactory.createLabelWithFont("PRODUTO", new Font("Comic Sans MS", Font.BOLD, 20), 670, 11, 109, 29);
        productPanel.add(productHeader);

        JLabel line = ComponentFactory.createLabelBorder("", new MatteBorder(0, 0, 2, 0, Color.BLACK), 670, 30, 101, 14);
        productPanel.add(line);

        Panel panel_2 = new Panel();
        panel_2.setBounds(348, 81, 308, 168);
        productPanel.add(panel_2);
        GroupLayout gl_panel_2 = new GroupLayout(panel_2);
        gl_panel_2.setHorizontalGroup(gl_panel_2.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 308, Short.MAX_VALUE));
        gl_panel_2.setVerticalGroup(gl_panel_2.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 168, Short.MAX_VALUE));
        panel_2.setLayout(gl_panel_2);

        JButton saveButton = ComponentFactory.createButton("CONFIRMAR", null, fontPlain13, 434, 272, 149, 53);
        clientPanel.add(saveButton);
        saveButton.addActionListener(e -> {
            Object[] options = {"SIM", "N�O"};
            int Cancel = JOptionPane.showOptionDialog(null, "CPF NA NOTA?", "ALERTA", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            if (Cancel == JOptionPane.YES_OPTION) {
                cpf = true;
                JOptionPane.showMessageDialog(null, "COMPRA REALIZADA COM SUCESSO");
                dispose();
            }
        });

        JButton cancelButton = ComponentFactory.createButton("CANCELAR", null, fontPlain13, 159, 272, 149, 53);
        clientPanel.add(cancelButton);
        cancelButton.addActionListener(e -> {
            Object[] options = {"SIM", "N�O"};
            int Cancel = JOptionPane.showOptionDialog(null, "TEM CERTEZA QUE DESEJA CANCELAR A COMPRA?", "ALERTA", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            if (Cancel == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(null, "OK");
                dispose();
            }
        });

        cpfField = ComponentFactory.createTextField(fontPlain13, true, 130, 95, 178, 20);
        clientPanel.add(totalPriceField);

        rgField = ComponentFactory.createTextField(fontPlain13, true, 130, 141, 178, 20);
        clientPanel.add(totalPriceField);

        clientCodeField = ComponentFactory.createTextField(fontPlain13, true, 434, 141, 178, 20);
        clientPanel.add(totalPriceField);

        phoneField = ComponentFactory.createTextField(fontPlain13, true, 130, 187, 178, 20);
        clientPanel.add(phoneField);

        addressField = ComponentFactory.createTextField(fontPlain13, true, 434, 95, 178, 20);
        clientPanel.add(addressField);

        cepField = ComponentFactory.createTextField(fontPlain13, true, 434, 187, 178, 20);
        clientPanel.add(cepField);

        clientNameList = new JComboBox<>(new Vector<>(client.pegarNome()));
        clientNameList.setBackground(Color.WHITE);
        clientNameList.setFont(new Font("Arial", Font.PLAIN, 15));
        clientNameList.setBorder(new LineBorder(Color.BLACK, 2));
        clientNameList.setBounds(102, 26, 379, 36);
        clientPanel.add(clientNameList);

        JButton searchClientButton = ComponentFactory.createButton("PESQUISAR", null, fontPlain13, 491, 26, 121, 37);
        clientPanel.add(searchClientButton);
        searchClientButton.addActionListener(e -> {
            try {
                if (Client.permission) {
                    int index = clientNameList.getSelectedIndex();
                    ArrayList<Client> clients = client.getClients();
                    Client client = clients.get(index);

                    cpfField.setText(client.getCpf());
                    phoneField.setText(client.getPhone());
                    addressField.setText(client.getAddress());
                    rgField.setText(client.getRg());
                    cepField.setText(client.getCep());
                    clientCodeField.setText(client.getCode());

                    String nomeCl = (String) clientNameList.getSelectedItem();
                    String cpfCl = client.getCpf();
                    String RGCl = client.getRg();

                    String CodCl = client.getCode();
                    String TelCl = client.getPhone();
                    String EndCl = client.getAddress();
                    String CepCl = client.getCep();

                    product.gravarDadosVenda("___________________");
                    product.gravarDadosVenda("DADOS DO CLIENTE");
                    product.gravarDadosVenda("NOME:");
                    product.gravarDadosVenda(nomeCl);
                    if (cpf) {
                        product.gravarDadosVenda("CPF:");
                        product.gravarDadosVenda(cpfCl);
                    }
                    product.gravarDadosVenda("RG:");
                    product.gravarDadosVenda(RGCl);
                    product.gravarDadosVenda("CODIGO:");
                    product.gravarDadosVenda(CodCl);
                    product.gravarDadosVenda("TELEFONE:");
                    product.gravarDadosVenda(TelCl);
                    product.gravarDadosVenda("ENDERECO");
                    product.gravarDadosVenda(EndCl);
                    product.gravarDadosVenda("CEP");
                    product.gravarDadosVenda(CepCl);

                } else {
                    JOptionPane.showMessageDialog(null, "N�O H� CLIENTES CADASTRADOS");
                }
            } catch (IOException ignored) {
            }
        });

        JLabel clientNameLabel = ComponentFactory.createLabelWithFont("PRODUTO", fontPlain13, 41, 36, 51, 22);
        clientPanel.add(clientNameLabel);

        JLabel cpfLabel = ComponentFactory.createLabelWithFont("CPF:", fontPlain13, 82, 96, 38, 17);
        clientPanel.add(cpfLabel);

        JLabel rgLabel = ComponentFactory.createLabelWithFont("RG:", fontPlain13, 90, 142, 30, 17);
        clientPanel.add(rgLabel);

        JLabel phoneLabel = ComponentFactory.createLabelWithFont("TELEFONE:", fontPlain13, 41, 186, 79, 21);
        clientPanel.add(phoneLabel);

        JLabel addressLabel = ComponentFactory.createLabelWithFont("ENDEREÇO:", fontPlain13, 345, 97, 79, 18);
        clientPanel.add(addressLabel);

        JLabel codeLabel = ComponentFactory.createLabelWithFont("CÓDIGO:", fontPlain13, 362, 142, 62, 17);
        clientPanel.add(codeLabel);

        JLabel cepLabel = ComponentFactory.createLabelWithFont("CEP:", fontPlain13, 386, 188, 38, 17);
        clientPanel.add(cepLabel);

        JLabel clientLabel = ComponentFactory.createLabelWithFont("CLIENTE", new Font("Comic Sans MS", Font.BOLD, 22), 665, 26, 129, 37);
        clientPanel.add(clientLabel);

        JLabel border = ComponentFactory.createLabelBorder("", new MatteBorder(0, 0, 2, 0, Color.BLACK), 665, 52, 100, 14);
        clientPanel.add(border);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                new Sales().setVisible(true);
            } catch (Exception ignored) {
            }
        });
    }
}
