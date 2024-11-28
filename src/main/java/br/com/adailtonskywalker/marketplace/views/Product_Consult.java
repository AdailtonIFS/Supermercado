package Produto;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class Product_Consult extends JFrame {

    private JPanel contentPane;
    private JComboBox<String[]> mostrarNomes;
    private JTextField mostrarEstoque;
    private JTextField mostrarDescricao;
    private JLabel lblTelefone;
    private JLabel lblDescricao;
    private JLabel lblCpf;
    private JTextField mostrarCodigo;
    private JLabel lblCodigo;
    private JTextField mostrarTipo;
    private JLabel lblTipo;
    private JTextField mostrarPreco;
    private JLabel lblPesquisar;
    private JLabel label;
    private JLabel label_1;
    private JLabel label_2;

    /**
     * Create the frame.
     *
     * @throws IOException
     */
    public Product_Consult() throws IOException {
        setIconImage(Toolkit.getDefaultToolkit().getImage(Product_Consult.class.getResource("/images/businesssettings_thebox_theproduct_negocio_2327.png")));
        setTitle("CONSULTAR PRODUTOS");
        Product Epd = new Product();

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 810, 710);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
        panel.setBackground(new Color(255, 222, 173));
        panel.setBounds(190, 44, 443, 573);
        contentPane.add(panel);
        panel.setLayout(null);

        JButton btnPesquise = new JButton("VOLTAR");
        btnPesquise.setIcon(new ImageIcon(Product_Consult.class.getResource("/images/back-arrow_icon-icons.com_72866.png")));
        btnPesquise.setBackground(UIManager.getColor("Button.background"));
        btnPesquise.setFont(new Font("Arial", Font.BOLD, 13));
        btnPesquise.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
        btnPesquise.setBounds(169, 496, 134, 37);
        panel.add(btnPesquise);


        mostrarEstoque = new JTextField();
        mostrarEstoque.setBackground(Color.WHITE);
        mostrarEstoque.setFont(new Font("Arial", Font.PLAIN, 13));
        mostrarEstoque.setBorder(new LineBorder(new Color(0, 0, 0), 2));
        mostrarEstoque.setBounds(174, 386, 163, 20);
        panel.add(mostrarEstoque);
        mostrarEstoque.setEditable(false);
        mostrarEstoque.setColumns(10);

        mostrarDescricao = new JTextField();
        mostrarDescricao.setBackground(Color.WHITE);
        mostrarDescricao.setFont(new Font("Arial", Font.PLAIN, 13));
        mostrarDescricao.setBorder(new LineBorder(new Color(0, 0, 0), 2));
        mostrarDescricao.setBounds(174, 337, 163, 20);
        panel.add(mostrarDescricao);
        mostrarDescricao.setEditable(false);
        mostrarDescricao.setColumns(10);

        lblTelefone = new JLabel("ESTOQUE:");
        lblTelefone.setFont(new Font("Arial", Font.BOLD, 15));
        lblTelefone.setBounds(85, 385, 79, 21);
        panel.add(lblTelefone);

        lblDescricao = new JLabel("DESCRI\u00C7\u00C3O:");
        lblDescricao.setFont(new Font("Arial", Font.BOLD, 15));
        lblDescricao.setBounds(65, 336, 99, 20);
        panel.add(lblDescricao);

        lblCpf = new JLabel("PRE\u00C7O:");
        lblCpf.setFont(new Font("Arial", Font.BOLD, 15));
        lblCpf.setBounds(106, 229, 58, 20);
        panel.add(lblCpf);

        mostrarCodigo = new JTextField();
        mostrarCodigo.setBackground(Color.WHITE);
        mostrarCodigo.setFont(new Font("Arial", Font.PLAIN, 13));
        mostrarCodigo.setBorder(new LineBorder(new Color(0, 0, 0), 2));
        mostrarCodigo.setBounds(174, 284, 163, 20);
        panel.add(mostrarCodigo);
        mostrarCodigo.setEditable(false);
        mostrarCodigo.setColumns(10);

        lblCodigo = new JLabel("CODIGO:");
        lblCodigo.setFont(new Font("Arial", Font.BOLD, 15));
        lblCodigo.setBounds(98, 285, 66, 17);
        panel.add(lblCodigo);

        mostrarTipo = new JTextField();
        mostrarTipo.setBackground(Color.WHITE);
        mostrarTipo.setFont(new Font("Arial", Font.PLAIN, 13));
        mostrarTipo.setBorder(new LineBorder(new Color(0, 0, 0), 2));
        mostrarTipo.setBounds(174, 433, 163, 20);
        panel.add(mostrarTipo);
        mostrarTipo.setEditable(false);
        mostrarTipo.setColumns(10);

        lblTipo = new JLabel("TIPO:");
        lblTipo.setFont(new Font("Arial", Font.BOLD, 15));
        lblTipo.setBounds(118, 431, 46, 23);
        panel.add(lblTipo);

        JButton btnConsultar = new JButton("CONSULTAR");
        btnConsultar.setIcon(new ImageIcon(Product_Consult.class.getResource("/images/Search_find_locate_1542.png")));
        btnConsultar.setBackground(UIManager.getColor("Button.background"));
        btnConsultar.setFont(new Font("Arial", Font.BOLD, 13));
        btnConsultar.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
        btnConsultar.setBounds(289, 116, 126, 45);
        panel.add(btnConsultar);

        mostrarPreco = new JTextField();
        mostrarPreco.setBackground(Color.WHITE);
        mostrarPreco.setFont(new Font("Arial", Font.PLAIN, 13));
        mostrarPreco.setBorder(new LineBorder(new Color(0, 0, 0), 2));
        mostrarPreco.setBounds(174, 230, 163, 20);
        panel.add(mostrarPreco);
        mostrarPreco.setEditable(false);
        mostrarPreco.setColumns(10);
        mostrarNomes = new JComboBox(new Vector<String>(Epd.pegarNome()));
        mostrarNomes.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
        mostrarNomes.setBounds(33, 123, 246, 33);
        panel.add(mostrarNomes);
        mostrarNomes.setForeground(Color.BLACK);
        mostrarNomes.setBackground(Color.WHITE);

        lblPesquisar = new JLabel("PESQUISAR");
        lblPesquisar.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        lblPesquisar.setBounds(169, 49, 134, 33);
        panel.add(lblPesquisar);

        label = new JLabel("");
        label.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
        label.setBounds(51, 79, 364, 14);
        panel.add(label);

        label_1 = new JLabel("");
        label_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
        label_1.setBounds(29, 181, 386, 378);
        panel.add(label_1);

        label_2 = new JLabel("");
        label_2.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
        label_2.setIcon(new ImageIcon(Product_Consult.class.getResource("/images/Compartilhada do Lightroom mobile (8).jpg")));
        label_2.setBounds(0, 0, 794, 671);
        contentPane.add(label_2);
        btnConsultar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int in = mostrarNomes.getSelectedIndex();//PEGANDO O �NDICE DO COMBOBOX

                try {
                    if (Product.permission) {
                        //ARRAY PRA PEGAR OS DADOS
                        ArrayList<String> PRECO = Epd.pegarPreco();
                        ArrayList<String> CODIGO = Epd.pegarCodigo();
                        ArrayList<String> DESCRICAO = Epd.pegarDescricao();
                        ArrayList<String> ESTOQUE = Epd.pegarEstoque();
                        ArrayList<String> TIPO = Epd.pegarTipo();


                        mostrarPreco.setText(PRECO.get(in));
                        mostrarCodigo.setText(CODIGO.get(in));
                        mostrarDescricao.setText(DESCRICAO.get(in));
                        mostrarEstoque.setText(ESTOQUE.get(in));
                        mostrarTipo.setText(TIPO.get(in));

                    } else {
                        JOptionPane.showMessageDialog(null, "N�O H� PRODUTOS CADASTRADOS");
                    }


                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }

            }
        });
        btnPesquise.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                Object[] options = {"SIM", "N�O"};//CRIANDO UM OBJETO DE OP��ES
                int Cancel = JOptionPane.showOptionDialog(null, "TEM CERTEZA QUE VOLTAR AO MENU PRINCIPAL", "ALERTA", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);//JOptionPane DE CONFIRMA��O

                //VERIFICANDO RESPOSTA DO USU�RIO
                dispose();//FECHANDO MINHA TELA


                if (Cancel == JOptionPane.YES_OPTION) {//RESPOSTA SIM
                    JOptionPane.showMessageDialog(null, "OK");//EXIBINDO CONFIRMA��O
                    dispose();//FECHANDO MINHA TELA
                }
                //BRUNO MECHER NA MENSAGEM


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
                    Product_Consult frame = new Product_Consult();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
