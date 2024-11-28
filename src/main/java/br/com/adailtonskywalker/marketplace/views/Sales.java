package br.com.adailtonskywalker.marketplace.views;

import br.com.adailtonskywalker.marketplace.domain.Client;
import br.com.adailtonskywalker.marketplace.domain.Product;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

public class Sales extends JFrame {

    private final JPanel contentPane;
    private final JTextField mostrarCodigo;
    private final JTextField mostrarPreco;
    private final JTextField mostrarTipo;
    private final JTextField mostrarEstoque;
    private final JTextField mostrarCPF;
    private final JTextField mostrarRG;
    private final JTextField mostrarCodigoCl;
    private final JTextField mostrarTelefone;
    private final JTextField mostrarEndereco;
    private final JTextField mostrarCep;
    private final JButton buttonConfirmar1;
    private final JButton buttonConfirmar2;
    private final JComboBox mostrarNomeClientes;
    private final JSpinner QBuy;
    private final JButton AddProdut;
    private final JTextField TotalPrice;
    private final JLabel lblNewLabel_5;
    private final JLabel lblNewLabel_6;
    private final JLabel lblProduto;
    private final JLabel label;
    private final JLabel lblNome;
    private final JLabel lblNewLabel_7;
    private final JLabel lblNewLabel_8;
    private final JLabel lblTelefone;
    private final JLabel lblNewLabel_9;
    private final JLabel lblNewLabel_10;
    private final JLabel lblNewLabel_11;
    private final JLabel lblCliente;
    private final JLabel label_1;
    private final JPanel panel_2;
    double precoTotal = 0;
    String nomeremove = null;
    ArrayList<String> arrayDados = new ArrayList<String>();
    boolean cpf = false;
    private JTable table;
    private JList list;
    private JList<String> list_1;

    public Sales() throws IOException {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        DefaultListModel<String> model = new DefaultListModel<String>();
        Client Cs = new Client();
        Product Ps = new Product();

        setTitle("REALIZAR VENDA");
        setIconImage(Toolkit.getDefaultToolkit().getImage(Sales.class.getResource("/images/shopping-cart.png")));
        setBounds(100, 100, 810, 710);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        Panel panel_1 = new Panel();
        panel_1.setBackground(new Color(250, 250, 210));
        panel_1.setBounds(0, 308, 794, 363);
        contentPane.add(panel_1);
        panel_1.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
        panel.setBackground(new Color(255, 228, 181));
        panel.setBounds(0, 0, 794, 309);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("NOME:");
        lblNewLabel.setFont(new Font("Arial", Font.BOLD, 13));
        lblNewLabel.setBounds(21, 13, 46, 31);
        panel.add(lblNewLabel);

        JComboBox mostrarNomeProdutos = new JComboBox(new Vector<String>(Ps.pegarNome()));
        mostrarNomeProdutos.setForeground(Color.BLACK);
        mostrarNomeProdutos.setBackground(Color.WHITE);
        mostrarNomeProdutos.setFont(new Font("Arial", Font.PLAIN, 15));
        mostrarNomeProdutos.setBorder(new LineBorder(new Color(0, 0, 0), 2));
        mostrarNomeProdutos.setBounds(66, 14, 374, 36);
        panel.add(mostrarNomeProdutos);

        mostrarCodigo = new JTextField();
        mostrarCodigo.setBackground(Color.WHITE);
        mostrarCodigo.setFont(new Font("Arial", Font.PLAIN, 13));
        mostrarCodigo.setBorder(new LineBorder(Color.BLACK, 2));
        mostrarCodigo.setEditable(false);
        mostrarCodigo.setBounds(179, 70, 119, 20);
        panel.add(mostrarCodigo);
        mostrarCodigo.setColumns(10);

        mostrarPreco = new JTextField();
        mostrarPreco.setBackground(Color.WHITE);
        mostrarPreco.setFont(new Font("Arial", Font.PLAIN, 13));
        mostrarPreco.setBorder(new LineBorder(Color.BLACK, 2));
        mostrarPreco.setEditable(false);
        mostrarPreco.setHorizontalAlignment(SwingConstants.CENTER);
        mostrarPreco.setBounds(179, 105, 119, 20);
        panel.add(mostrarPreco);
        mostrarPreco.setColumns(10);

        mostrarTipo = new JTextField();
        mostrarTipo.setBackground(Color.WHITE);
        mostrarTipo.setFont(new Font("Arial", Font.PLAIN, 13));
        mostrarTipo.setBorder(new LineBorder(Color.BLACK, 2));
        mostrarTipo.setEditable(false);
        mostrarTipo.setBounds(179, 136, 119, 20);
        panel.add(mostrarTipo);
        mostrarTipo.setColumns(10);

        mostrarEstoque = new JTextField();
        mostrarEstoque.setBackground(Color.WHITE);
        mostrarEstoque.setFont(new Font("Arial", Font.PLAIN, 13));
        mostrarEstoque.setBorder(new LineBorder(Color.BLACK, 2));
        mostrarEstoque.setEditable(false);
        mostrarEstoque.setBounds(179, 167, 119, 20);
        panel.add(mostrarEstoque);
        mostrarEstoque.setColumns(10);

        buttonConfirmar1 = new JButton("PESQUISAR");
        buttonConfirmar1.setIcon(new ImageIcon(Sales.class.getResource("/images/magnifier-1_icon-icons.com_56924.png")));
        buttonConfirmar1.setBorder(new LineBorder(Color.BLACK, 2, true));
        buttonConfirmar1.setBackground(UIManager.getColor("Button.background"));
        buttonConfirmar1.setFont(new Font("Arial", Font.BOLD, 13));
        buttonConfirmar1.setBounds(450, 14, 173, 37);
        panel.add(buttonConfirmar1);
        buttonConfirmar1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                try {

                    if (Product.permission) {

                        int in = mostrarNomeProdutos.getSelectedIndex();// PEGANDO O �NDICE DO COMBOBOX

                        // ARRAY PRA PEGAR OS DADOS
                        ArrayList<String> PRECO = Ps.pegarPreco();
                        ArrayList<String> CODIGO = Ps.pegarCodigo();
                        ArrayList<String> ESTOQUE = Ps.pegarEstoque();
                        ArrayList<String> TIPO = Ps.pegarTipo();

                        mostrarPreco.setText(PRECO.get(in));
                        mostrarCodigo.setText(CODIGO.get(in));
                        mostrarEstoque.setText(ESTOQUE.get(in));
                        mostrarTipo.setText(TIPO.get(in));

                    } else {
                        JOptionPane.showMessageDialog(null, "N�O H� PRODUTOS CADASTRADOS");
                    }

                } catch (IOException e1) {
                    e1.printStackTrace();
                }

            }

        });


        QBuy = new JSpinner();
        QBuy.setBorder(new LineBorder(Color.BLACK, 2));
        QBuy.setModel(new SpinnerNumberModel(1, 1, 100000000, 1));
        QBuy.setBounds(179, 209, 52, 22);
        panel.add(QBuy);

        AddProdut = new JButton("ADICIONAR PRODUTO");
        AddProdut.setIcon(new ImageIcon(Sales.class.getResource("/images/shopping-cart_icon-icons.com_56125.png")));
        AddProdut.setBackground(UIManager.getColor("Button.background"));
        AddProdut.setBorder(new LineBorder(Color.BLACK, 2, true));
        AddProdut.setFont(new Font("Arial", Font.BOLD, 13));
        AddProdut.setBounds(66, 242, 212, 47);
        panel.add(AddProdut);

        TotalPrice = new JTextField();
        TotalPrice.setBackground(Color.WHITE);
        TotalPrice.setBorder(new LineBorder(Color.BLACK, 2));
        TotalPrice.setEditable(false);
        TotalPrice.setBounds(450, 271, 143, 20);
        panel.add(TotalPrice);
        TotalPrice.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("C\u00D3DIGO:");
        lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 13));
        lblNewLabel_1.setBounds(105, 71, 64, 16);
        panel.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("PRE\u00C7O UNIT\u00C1RIO:");
        lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 13));
        lblNewLabel_2.setBounds(45, 103, 124, 22);
        panel.add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("TIPO:");
        lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 13));
        lblNewLabel_3.setBounds(123, 138, 46, 17);
        panel.add(lblNewLabel_3);

        JLabel lblNewLabel_4 = new JLabel("ESTOQUE:");
        lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 13));
        lblNewLabel_4.setBounds(98, 168, 71, 17);
        panel.add(lblNewLabel_4);

        lblNewLabel_5 = new JLabel("QUANTIDADE:");
        lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 13));
        lblNewLabel_5.setBounds(76, 208, 93, 21);
        panel.add(lblNewLabel_5);

        lblNewLabel_6 = new JLabel("PRE\u00C7O TOTAL:");
        lblNewLabel_6.setFont(new Font("Arial", Font.BOLD, 13));
        lblNewLabel_6.setBounds(348, 271, 101, 18);
        panel.add(lblNewLabel_6);

        lblProduto = new JLabel("PRODUTO");
        lblProduto.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        lblProduto.setBounds(670, 11, 109, 29);
        panel.add(lblProduto);

        label = new JLabel("");
        label.setBorder(new MatteBorder(0, 0, 2, 0, Color.BLACK));
        label.setBounds(670, 30, 101, 14);
        panel.add(label);

        panel_2 = new JPanel();
        panel_2.setBounds(348, 81, 308, 168);
        panel.add(panel_2);
        GroupLayout gl_panel_2 = new GroupLayout(panel_2);
        gl_panel_2.setHorizontalGroup(gl_panel_2.createParallelGroup(Alignment.LEADING).addGap(0, 308, Short.MAX_VALUE));
        gl_panel_2.setVerticalGroup(gl_panel_2.createParallelGroup(Alignment.LEADING).addGap(0, 168, Short.MAX_VALUE));
        panel_2.setLayout(gl_panel_2);

        JList<String> list_1_1 = new JList<String>();
        list_1_1.setBounds(0, 0, 0, 0);
        panel.add(list_1_1);


        JButton buttonSave = new JButton("CONFIRMAR");
        buttonSave.setIcon(new ImageIcon(Sales.class.getResource("/images/confirm_47757.png")));
        buttonSave.setBorder(new LineBorder(Color.BLACK, 2, true));
        buttonSave.setFont(new Font("Arial", Font.BOLD, 13));
        buttonSave.setBounds(434, 272, 149, 53);
        panel_1.add(buttonSave);
        JButton buttonCancel = new JButton("CANCELAR");
        buttonCancel.setIcon(new ImageIcon(Sales.class.getResource("/images/cancelbutton_85722 (1).png")));
        buttonCancel.setBorder(new LineBorder(Color.BLACK, 2, true));
        buttonCancel.setFont(new Font("Arial", Font.BOLD, 13));
        buttonCancel.setBounds(159, 272, 149, 53);
        panel_1.add(buttonCancel);
        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Object[] options = {"SIM", "N�O"};//CRIANDO UM OBJETO DE OP��ES
                int Cancel = JOptionPane.showOptionDialog(null, "TEM CERTEZA QUE DESEJA CANCELAR A COMPRA?", "ALERTA", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);//JOptionPane DE CONFIRMA��O

                //VERIFICANDO RESPOSTA DO USU�RIO
                if (Cancel == JOptionPane.YES_OPTION) {//RESPOSTA SIM
                    JOptionPane.showMessageDialog(null, "OK");//EXIBINDO CONFIRMA��O
                    dispose();

                }
            }
        });


        buttonSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                Object[] options = {"SIM", "N�O"};//CRIANDO UM OBJETO DE OP��ES
                int Cancel = JOptionPane.showOptionDialog(null, "CPF NA NOTA?", "ALERTA", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);//JOptionPane DE CONFIRMA��O

                //VERIFICANDO RESPOSTA DO USU�RIO
                if (Cancel == JOptionPane.YES_OPTION) {//RESPOSTA SIM
                    cpf = true;
                    JOptionPane.showMessageDialog(null, "COMPRA REALIZADA COM SUCESSO");//EXIBINDO CONFIRMA��O
                    dispose();

                } else {
                    cpf = false;
                    JOptionPane.showMessageDialog(null, "COMPRA REALIZADA COM SUCESSO");//EXIBINDO CONFIRMA��O
                    dispose();
                }


            }
        });

        mostrarCPF = new JTextField();
        mostrarCPF.setBackground(Color.WHITE);
        mostrarCPF.setBorder(new LineBorder(Color.BLACK, 2));
        mostrarCPF.setFont(new Font("Arial", Font.PLAIN, 13));
        mostrarCPF.setEditable(false);
        mostrarCPF.setBounds(130, 95, 178, 20);
        panel_1.add(mostrarCPF);
        mostrarCPF.setColumns(10);

        mostrarRG = new JTextField();
        mostrarRG.setBackground(Color.WHITE);
        mostrarRG.setBorder(new LineBorder(Color.BLACK, 2));
        mostrarRG.setFont(new Font("Arial", Font.PLAIN, 13));
        mostrarRG.setEditable(false);
        mostrarRG.setBounds(130, 141, 178, 20);
        panel_1.add(mostrarRG);
        mostrarRG.setColumns(10);

        mostrarCodigoCl = new JTextField();
        mostrarCodigoCl.setBackground(Color.WHITE);
        mostrarCodigoCl.setBorder(new LineBorder(Color.BLACK, 2));
        mostrarCodigoCl.setFont(new Font("Arial", Font.PLAIN, 13));
        mostrarCodigoCl.setEditable(false);
        mostrarCodigoCl.setBounds(434, 141, 178, 20);
        panel_1.add(mostrarCodigoCl);
        mostrarCodigoCl.setColumns(10);

        mostrarTelefone = new JTextField();
        mostrarTelefone.setBackground(Color.WHITE);
        mostrarTelefone.setBorder(new LineBorder(Color.BLACK, 2));
        mostrarTelefone.setFont(new Font("Arial", Font.PLAIN, 13));
        mostrarTelefone.setEditable(false);
        mostrarTelefone.setBounds(130, 187, 178, 20);
        panel_1.add(mostrarTelefone);
        mostrarTelefone.setColumns(10);

        mostrarEndereco = new JTextField();
        mostrarEndereco.setBackground(Color.WHITE);
        mostrarEndereco.setBorder(new LineBorder(Color.BLACK, 2));
        mostrarEndereco.setFont(new Font("Arial", Font.PLAIN, 13));
        mostrarEndereco.setEditable(false);
        mostrarEndereco.setBounds(434, 95, 178, 20);
        panel_1.add(mostrarEndereco);
        mostrarEndereco.setColumns(10);

        mostrarCep = new JTextField();
        mostrarCep.setBackground(Color.WHITE);
        mostrarCep.setBorder(new LineBorder(Color.BLACK, 2));
        mostrarCep.setFont(new Font("Arial", Font.PLAIN, 13));
        mostrarCep.setEditable(false);
        mostrarCep.setBounds(434, 187, 178, 20);
        panel_1.add(mostrarCep);
        mostrarCep.setColumns(10);

        mostrarNomeClientes = new JComboBox(new Vector<String>(Cs.pegarNome()));
        mostrarNomeClientes.setBackground(Color.WHITE);
        mostrarNomeClientes.setFont(new Font("Arial", Font.PLAIN, 15));
        mostrarNomeClientes.setBorder(new LineBorder(Color.BLACK, 2));
        mostrarNomeClientes.setBounds(102, 26, 379, 36);
        panel_1.add(mostrarNomeClientes);

        buttonConfirmar2 = new JButton("PESQUISAR\r\n");
        buttonConfirmar2.setIcon(new ImageIcon(Sales.class.getResource("/images/magnifier-1_icon-icons.com_56924.png")));
        buttonConfirmar2.setBackground(UIManager.getColor("Button.background"));
        buttonConfirmar2.setBorder(new LineBorder(Color.BLACK, 2, true));
        buttonConfirmar2.setFont(new Font("Arial", Font.BOLD, 13));
        buttonConfirmar2.setBounds(491, 26, 121, 37);
        panel_1.add(buttonConfirmar2);

        lblNome = new JLabel("NOME:");
        lblNome.setFont(new Font("Arial", Font.BOLD, 13));
        lblNome.setBounds(41, 36, 51, 22);
        panel_1.add(lblNome);

        lblNewLabel_7 = new JLabel("CPF:");
        lblNewLabel_7.setFont(new Font("Arial", Font.BOLD, 13));
        lblNewLabel_7.setBounds(82, 96, 38, 17);
        panel_1.add(lblNewLabel_7);

        lblNewLabel_8 = new JLabel("RG:");
        lblNewLabel_8.setFont(new Font("Arial", Font.BOLD, 13));
        lblNewLabel_8.setBounds(90, 142, 30, 17);
        panel_1.add(lblNewLabel_8);

        lblTelefone = new JLabel("TELEFONE:");
        lblTelefone.setFont(new Font("Arial", Font.BOLD, 13));
        lblTelefone.setBounds(41, 186, 79, 21);
        panel_1.add(lblTelefone);

        lblNewLabel_9 = new JLabel("ENDERE\u00C7O:");
        lblNewLabel_9.setFont(new Font("Arial", Font.BOLD, 13));
        lblNewLabel_9.setBounds(345, 97, 79, 18);
        panel_1.add(lblNewLabel_9);

        lblNewLabel_10 = new JLabel("C\u00D3DIGO:");
        lblNewLabel_10.setFont(new Font("Arial", Font.BOLD, 13));
        lblNewLabel_10.setBounds(362, 142, 62, 17);
        panel_1.add(lblNewLabel_10);

        lblNewLabel_11 = new JLabel("CEP:");
        lblNewLabel_11.setFont(new Font("Arial", Font.BOLD, 13));
        lblNewLabel_11.setBounds(386, 188, 38, 17);
        panel_1.add(lblNewLabel_11);

        lblCliente = new JLabel("CLIENTE");
        lblCliente.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
        lblCliente.setBounds(665, 26, 129, 37);
        panel_1.add(lblCliente);

        label_1 = new JLabel("");
        label_1.setBorder(new MatteBorder(0, 0, 2, 0, Color.BLACK));
        label_1.setBounds(665, 52, 100, 14);
        panel_1.add(label_1);
        buttonConfirmar2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                try {

                    if (Client.permission) {
                        int inC = mostrarNomeClientes.getSelectedIndex();// PEGANDO O �NDICE DO COMBOBOX

                        // ARRAY PRA PEGAR OS DADOS
                        ArrayList<String> CPF = Cs.pegarCPF();
                        ArrayList<String> TELEFONE = Cs.pegarTelefone();
                        ArrayList<String> ENDERECO = Cs.pegarEndereco();
                        ArrayList<String> RG = Cs.pegarRG();
                        ArrayList<String> CEP = Cs.pegarCEP();
                        ArrayList<String> CODIGO = Cs.pegarCod();


                        mostrarCPF.setText(CPF.get(inC));
                        mostrarTelefone.setText(TELEFONE.get(inC));
                        mostrarEndereco.setText(ENDERECO.get(inC));
                        mostrarRG.setText(RG.get(inC));
                        mostrarCep.setText(CEP.get(inC));
                        mostrarCodigoCl.setText(CODIGO.get(inC));

                        String nomeCl = (String) mostrarNomeClientes.getSelectedItem();
                        String cpfCl = CPF.get(inC);
                        String RGCl = RG.get(inC);
                        String CodCl = CODIGO.get(inC);
                        String TelCl = TELEFONE.get(inC);
                        String EndCl = ENDERECO.get(inC);
                        String CepCl = CEP.get(inC);

                        Ps.gravarDadosVenda("___________________");
                        Ps.gravarDadosVenda("DADOS DO CLIENTE");
                        Ps.gravarDadosVenda("NOME:");
                        Ps.gravarDadosVenda(nomeCl);
                        if (cpf) {
                            Ps.gravarDadosVenda("CPF:");
                            Ps.gravarDadosVenda(cpfCl);
                        }
                        Ps.gravarDadosVenda("RG:");
                        Ps.gravarDadosVenda(RGCl);
                        Ps.gravarDadosVenda("CODIGO:");
                        Ps.gravarDadosVenda(CodCl);
                        Ps.gravarDadosVenda("TELEFONE:");
                        Ps.gravarDadosVenda(TelCl);
                        Ps.gravarDadosVenda("ENDERECO");
                        Ps.gravarDadosVenda(EndCl);
                        Ps.gravarDadosVenda("CEP");
                        Ps.gravarDadosVenda(CepCl);

                    } else {
                        JOptionPane.showMessageDialog(null, "N�O H� CLIENTES CADASTRADOS");

                    }
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

            }
        });

        AddProdut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int in = mostrarNomeProdutos.getSelectedIndex();// PEGANDO O �NDICE DO COMBOBOX

                try {
                    ArrayList<String> PRECO = Ps.pegarPreco();
                    ArrayList<String> CODIGO = Ps.pegarCodigo();
                    ArrayList<String> ESTOQUE = Ps.pegarEstoque();
                    ArrayList<String> TIPO = Ps.pegarTipo();

                    int estoque = Integer.parseInt(ESTOQUE.get(in)); // PEGAR O VALOR NO ESTOQUE
                    int pedido = (Integer.parseInt(QBuy.getValue().toString())); // PEGAR A QUANTIDADE QUE O USUARIO
                    String Cod = CODIGO.get(in);                                                                // PEDIU

                    if (pedido > estoque) { // VALIDANDO
                        JOptionPane.showMessageDialog(null, "QUANTIDADE INV�LIDA");
                    } else {

                        String nomeproduct = (String) mostrarNomeProdutos.getSelectedItem();
                        String tipo = TIPO.get(in);
                        String replaceString = PRECO.get(in).replaceAll(",", ".");
                        double preco = Double.parseDouble(replaceString);
                        double finalpreco = preco * pedido;

                        Ps.gravarDadosVenda("_________________");
                        Ps.gravarDadosVenda("NOME DO PRODUTO");
                        Ps.gravarDadosVenda(nomeproduct);
                        Ps.gravarDadosVenda("TIPO");
                        Ps.gravarDadosVenda(tipo);
                        Ps.gravarDadosVenda("C�DIGO");
                        Ps.gravarDadosVenda(Cod);
                        Ps.gravarDadosVenda("PRE�O UNIT�RIO");
                        Ps.gravarDadosVenda(replaceString);


                        precoTotal = precoTotal + finalpreco;
                        Ps.gravarDadosVenda("PRE�O TOTAL");
                        Ps.gravarDadosVenda(String.valueOf(precoTotal));

                        String mostrarDados = String.format("|   %s   |   %s   |   %s   |  %6.2f  |   %d   |   %6.2f   |", nomeproduct, Cod, tipo, preco, pedido, finalpreco);


                        arrayDados.add(mostrarDados);
                        model.addElement(mostrarDados);
                        list_1_1.setModel(model);

                        TotalPrice.setText(String.valueOf(precoTotal));

                    }


                } catch (IOException e1) {
                    e1.printStackTrace();
                }

            }
        });


    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Sales frame = new Sales();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
