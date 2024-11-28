package br.com.adailtonskywalker.marketplace.views;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;
import br.com.adailtonskywalker.marketplace.domain.*;

public class Client_Consult extends JFrame {

    private final JPanel contentPane;
    private final JComboBox<String[]> mostrarNomes;
    private final JTextField mostrarTelefone;
    private final JTextField mostrarEmail;
    private final JTextField mostrarDataNascimento;
    private final JLabel lblTelefone;
    private final JLabel lblEmail;
    private final JLabel lblDataDeNascimento;
    private final JLabel lblCpf;
    private final JLabel lblRg;
    private final JTextField mostrarCodigo;
    private final JLabel lblCodigo;
    private final JTextField mostrarEndereco;
    private final JLabel lblEndereo;
    private final JTextField mostrarCEP;
    private final JLabel lblCep;
    private final JTextField mostrarCPF;
    private final JTextField mostrarRg;
    private final JTextField mostrarSexo;
    private final JLabel label;
    private final JLabel lblNewLabel_1;
    private final JLabel lblNewLabel_2;
    private final JLabel label_1;

    /**
     * Create the frame.
     *
     * @throws IOException
     */
    public Client_Consult() throws IOException {
        setTitle("CONSULTAR CLIENTES");
        setIconImage(Toolkit.getDefaultToolkit().getImage(Client_Consult.class.getResource("/images/business_man_usersearch_thesearch_theclient_2356.png")));
        Client Ct = new Client();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 810, 710);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setForeground(Color.BLACK);
        panel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
        panel.setBackground(new Color(240, 255, 240));
        panel.setBounds(158, 26, 462, 634);
        contentPane.add(panel);
        panel.setLayout(null);

        JButton btnPesquise = new JButton("VOLTAR");
        btnPesquise.setIcon(new ImageIcon(Client_Consult.class.getResource("/images/back-arrow_icon-icons.com_72866.png")));
        btnPesquise.setBackground(UIManager.getColor("Button.background"));
        btnPesquise.setFont(new Font("Arial", Font.BOLD, 13));
        btnPesquise.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
        btnPesquise.setBounds(176, 565, 130, 40);
        panel.add(btnPesquise);


        mostrarTelefone = new JTextField();
        mostrarTelefone.setBackground(Color.WHITE);
        mostrarTelefone.setFont(new Font("Arial", Font.PLAIN, 13));
        mostrarTelefone.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
        mostrarTelefone.setBounds(186, 293, 198, 20);
        panel.add(mostrarTelefone);
        mostrarTelefone.setEditable(false);
        mostrarTelefone.setColumns(10);

        mostrarEmail = new JTextField();
        mostrarEmail.setBackground(Color.WHITE);
        mostrarEmail.setFont(new Font("Arial", Font.PLAIN, 13));
        mostrarEmail.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
        mostrarEmail.setBounds(186, 469, 198, 20);
        panel.add(mostrarEmail);
        mostrarEmail.setEditable(false);
        mostrarEmail.setColumns(10);

        mostrarDataNascimento = new JTextField();
        mostrarDataNascimento.setBackground(Color.WHITE);
        mostrarDataNascimento.setFont(new Font("Arial", Font.PLAIN, 13));
        mostrarDataNascimento.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
        mostrarDataNascimento.setBounds(186, 248, 198, 20);
        panel.add(mostrarDataNascimento);
        mostrarDataNascimento.setEditable(false);
        mostrarDataNascimento.setColumns(10);

        lblTelefone = new JLabel("TELEFONE:");
        lblTelefone.setFont(new Font("Arial", Font.BOLD, 15));
        lblTelefone.setBounds(83, 291, 93, 26);
        panel.add(lblTelefone);

        lblEmail = new JLabel("EMAIL:");
        lblEmail.setFont(new Font("Arial", Font.BOLD, 15));
        lblEmail.setBounds(122, 468, 54, 20);
        panel.add(lblEmail);

        lblDataDeNascimento = new JLabel("DATA");
        lblDataDeNascimento.setFont(new Font("Arial", Font.BOLD, 15));
        lblDataDeNascimento.setBounds(102, 231, 46, 23);
        panel.add(lblDataDeNascimento);

        lblCpf = new JLabel("CPF:");
        lblCpf.setFont(new Font("Arial", Font.BOLD, 15));
        lblCpf.setBounds(140, 153, 36, 21);
        panel.add(lblCpf);

        lblRg = new JLabel("RG:");
        lblRg.setFont(new Font("Arial", Font.BOLD, 15));
        lblRg.setBounds(145, 199, 31, 21);
        panel.add(lblRg);

        mostrarCodigo = new JTextField();
        mostrarCodigo.setBackground(Color.WHITE);
        mostrarCodigo.setFont(new Font("Arial", Font.PLAIN, 13));
        mostrarCodigo.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
        mostrarCodigo.setBounds(186, 426, 198, 20);
        panel.add(mostrarCodigo);
        mostrarCodigo.setEditable(false);
        mostrarCodigo.setColumns(10);

        lblCodigo = new JLabel("CODIGO:");
        lblCodigo.setFont(new Font("Arial", Font.BOLD, 15));
        lblCodigo.setBounds(112, 424, 74, 22);
        panel.add(lblCodigo);

        mostrarEndereco = new JTextField();
        mostrarEndereco.setBackground(Color.WHITE);
        mostrarEndereco.setFont(new Font("Arial", Font.PLAIN, 13));
        mostrarEndereco.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
        mostrarEndereco.setBounds(186, 339, 198, 20);
        panel.add(mostrarEndereco);
        mostrarEndereco.setEditable(false);
        mostrarEndereco.setColumns(10);

        lblEndereo = new JLabel("ENDERE\u00C7O:");
        lblEndereo.setFont(new Font("Arial", Font.BOLD, 15));
        lblEndereo.setBounds(83, 338, 93, 20);
        panel.add(lblEndereo);

        mostrarCEP = new JTextField();
        mostrarCEP.setBackground(Color.WHITE);
        mostrarCEP.setFont(new Font("Arial", Font.PLAIN, 13));
        mostrarCEP.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
        mostrarCEP.setBounds(186, 383, 198, 20);
        panel.add(mostrarCEP);
        mostrarCEP.setEditable(false);
        mostrarCEP.setColumns(10);

        lblCep = new JLabel("CEP:");
        lblCep.setFont(new Font("Arial", Font.BOLD, 15));
        lblCep.setBounds(140, 380, 36, 25);
        panel.add(lblCep);

        JButton btnConsultar = new JButton("CONSULTAR");
        btnConsultar.setIcon(new ImageIcon(Client_Consult.class.getResource("/images/xmag_search_find_export_locate_5984.png")));
        btnConsultar.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
        btnConsultar.setFont(new Font("Arial", Font.BOLD, 13));
        btnConsultar.setBounds(286, 87, 130, 40);
        panel.add(btnConsultar);

        mostrarRg = new JTextField();
        mostrarRg.setBackground(Color.WHITE);
        mostrarRg.setFont(new Font("Arial", Font.PLAIN, 13));
        mostrarRg.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
        mostrarRg.setBounds(186, 200, 198, 20);
        panel.add(mostrarRg);
        mostrarRg.setEditable(false);
        mostrarRg.setColumns(10);

        mostrarSexo = new JTextField();
        mostrarSexo.setBackground(Color.WHITE);
        mostrarSexo.setFont(new Font("Arial", Font.PLAIN, 13));
        mostrarSexo.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
        mostrarSexo.setBounds(186, 512, 198, 20);
        panel.add(mostrarSexo);
        mostrarSexo.setEditable(false);
        mostrarSexo.setColumns(10);

        mostrarCPF = new JTextField();
        mostrarCPF.setBackground(Color.WHITE);
        mostrarCPF.setFont(new Font("Arial", Font.PLAIN, 13));
        mostrarCPF.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
        mostrarCPF.setBounds(186, 154, 198, 20);
        panel.add(mostrarCPF);
        mostrarCPF.setEditable(false);
        mostrarCPF.setColumns(10);

        JLabel lblSexo = new JLabel("SEXO:");
        lblSexo.setFont(new Font("Arial", Font.BOLD, 15));
        lblSexo.setBounds(130, 511, 46, 20);
        panel.add(lblSexo);
        mostrarNomes = new JComboBox(new Vector<String>(Ct.pegarNome()));
        mostrarNomes.setFont(new Font("Arial", Font.BOLD, 13));
        mostrarNomes.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
        mostrarNomes.setBounds(37, 94, 239, 26);
        panel.add(mostrarNomes);
        mostrarNomes.setForeground(Color.BLACK);
        mostrarNomes.setBackground(Color.WHITE);

        JLabel lblNewLabel = new JLabel("PESQUISAR");
        lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
        lblNewLabel.setBounds(182, 29, 142, 33);
        panel.add(lblNewLabel);

        lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
        lblNewLabel_1.setBounds(49, 138, 366, 485);
        panel.add(lblNewLabel_1);

        lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setBorder(new MatteBorder(0, 0, 2, 0, new Color(0, 0, 0)));
        lblNewLabel_2.setBounds(51, 29, 366, 41);
        panel.add(lblNewLabel_2);

        label_1 = new JLabel("(NASCIMENTO):");
        label_1.setFont(new Font("Arial", Font.BOLD, 13));
        label_1.setBounds(83, 251, 140, 23);
        panel.add(label_1);

        label = new JLabel("");
        label.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
        label.setIcon(new ImageIcon(Client_Consult.class.getResource("/images/Compartilhada do Lightroom mobile (2).jpg")));
        label.setBounds(0, 0, 794, 671);
        contentPane.add(label);
        btnConsultar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int in = mostrarNomes.getSelectedIndex();//PEGANDO O �NDICE DO COMBOBOX

                try {

                    if (Client.permission) {
                        //ARRAY PRA PEGAR OS DADOS
                        ArrayList<String> CPF = Ct.pegarCPF();
                        ArrayList<String> TELEFONE = Ct.pegarTelefone();
                        ArrayList<String> ENDERECO = Ct.pegarEndereco();
                        ArrayList<String> SEXO = Ct.pegarSexo();
                        ArrayList<String> DATADENASCIMENTO = Ct.pegarDataNascimento();
                        ArrayList<String> RG = Ct.pegarRG();
                        ArrayList<String> CEP = Ct.pegarCEP();
                        ArrayList<String> EMAIL = Ct.pegarEmail();
                        ArrayList<String> CODIGO = Ct.pegarCod();


                        mostrarCPF.setText(CPF.get(in));
                        mostrarTelefone.setText(TELEFONE.get(in));
                        mostrarEndereco.setText(ENDERECO.get(in));
                        mostrarSexo.setText(SEXO.get(in));
                        mostrarDataNascimento.setText(DATADENASCIMENTO.get(in));
                        mostrarRg.setText(RG.get(in));
                        mostrarCEP.setText(CEP.get(in));
                        mostrarEmail.setText(EMAIL.get(in));
                        mostrarCodigo.setText(CODIGO.get(in));

                    } else {
                        JOptionPane.showMessageDialog(null, "N�O H� CLIENTES CADASTRADOS");

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
                    Client_Consult frame = new Client_Consult();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
