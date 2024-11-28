package br.com.adailtonskywalker.marketplace.views;

import br.com.adailtonskywalker.marketplace.domain.Employee;

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

public class Employee_Consult extends JFrame {

    private final JPanel contentPane;
    private final JComboBox<String[]> mostrarNomes;
    private final JTextField mostrarTelefone;
    private final JTextField mostrarSalario;
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
    private final JLabel lblPesquisar;
    private final JTextField mostrarCargo;
    private final JLabel label;
    private final JLabel label_2;

    /**
     * Create the frame.
     *
     * @throws IOException
     */
    public Employee_Consult() throws IOException {
        setTitle("CONSULTAR FUNCION\u00C1RIOS");
        Employee Emt = new Employee();

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 810, 710);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
        panel.setBackground(new Color(245, 245, 220));
        panel.setBounds(144, 11, 492, 649);
        contentPane.add(panel);
        panel.setLayout(null);

        JButton btnPesquise = new JButton("VOLTAR");
        btnPesquise.setIcon(new ImageIcon(Employee_Consult.class.getResource("/images/back-arrow_icon-icons.com_72866.png")));
        btnPesquise.setFont(new Font("Arial", Font.BOLD, 13));
        btnPesquise.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
        btnPesquise.setBounds(177, 603, 126, 35);
        panel.add(btnPesquise);


        mostrarTelefone = new JTextField();
        mostrarTelefone.setBackground(Color.WHITE);
        mostrarTelefone.setFont(new Font("Arial", Font.PLAIN, 13));
        mostrarTelefone.setBorder(new LineBorder(new Color(0, 0, 0), 2));
        mostrarTelefone.setBounds(214, 284, 179, 20);
        panel.add(mostrarTelefone);
        mostrarTelefone.setEditable(false);
        mostrarTelefone.setColumns(10);

        mostrarSalario = new JTextField();
        mostrarSalario.setBackground(Color.WHITE);
        mostrarSalario.setFont(new Font("Arial", Font.PLAIN, 13));
        mostrarSalario.setBorder(new LineBorder(new Color(0, 0, 0), 2));
        mostrarSalario.setBounds(214, 469, 179, 20);
        panel.add(mostrarSalario);
        mostrarSalario.setEditable(false);
        mostrarSalario.setColumns(10);

        mostrarDataNascimento = new JTextField();
        mostrarDataNascimento.setBackground(Color.WHITE);
        mostrarDataNascimento.setFont(new Font("Arial", Font.PLAIN, 13));
        mostrarDataNascimento.setBorder(new LineBorder(new Color(0, 0, 0), 2));
        mostrarDataNascimento.setBounds(214, 239, 179, 20);
        panel.add(mostrarDataNascimento);
        mostrarDataNascimento.setEditable(false);
        mostrarDataNascimento.setColumns(10);

        lblTelefone = new JLabel("TELEFONE:");
        lblTelefone.setFont(new Font("Arial", Font.BOLD, 15));
        lblTelefone.setBounds(112, 284, 92, 19);
        panel.add(lblTelefone);

        JLabel lblCargo = new JLabel("CARGO:");
        lblCargo.setFont(new Font("Arial", Font.BOLD, 15));
        lblCargo.setBounds(136, 565, 68, 16);
        panel.add(lblCargo);

        lblEmail = new JLabel("SAL\u00C1RIO:");
        lblEmail.setFont(new Font("Arial", Font.BOLD, 15));
        lblEmail.setBounds(125, 468, 68, 20);
        panel.add(lblEmail);

        lblDataDeNascimento = new JLabel("DATA (NASCIMENTO):");
        lblDataDeNascimento.setFont(new Font("Arial", Font.BOLD, 13));
        lblDataDeNascimento.setBounds(57, 239, 147, 19);
        panel.add(lblDataDeNascimento);

        lblCpf = new JLabel("CPF:");
        lblCpf.setFont(new Font("Arial", Font.BOLD, 15));
        lblCpf.setBounds(156, 153, 37, 20);
        panel.add(lblCpf);

        lblRg = new JLabel("RG:");
        lblRg.setFont(new Font("Arial", Font.BOLD, 15));
        lblRg.setBounds(164, 197, 29, 17);
        panel.add(lblRg);

        mostrarCodigo = new JTextField();
        mostrarCodigo.setBackground(Color.WHITE);
        mostrarCodigo.setFont(new Font("Arial", Font.PLAIN, 13));
        mostrarCodigo.setBorder(new LineBorder(new Color(0, 0, 0), 2));
        mostrarCodigo.setBounds(214, 421, 179, 20);
        panel.add(mostrarCodigo);
        mostrarCodigo.setEditable(false);
        mostrarCodigo.setColumns(10);

        lblCodigo = new JLabel("C\u00D3DIGO:");
        lblCodigo.setFont(new Font("Arial", Font.BOLD, 15));
        lblCodigo.setBounds(125, 422, 68, 17);
        panel.add(lblCodigo);

        mostrarEndereco = new JTextField();
        mostrarEndereco.setBackground(Color.WHITE);
        mostrarEndereco.setFont(new Font("Arial", Font.PLAIN, 13));
        mostrarEndereco.setBorder(new LineBorder(new Color(0, 0, 0), 2));
        mostrarEndereco.setBounds(214, 329, 179, 20);
        panel.add(mostrarEndereco);
        mostrarEndereco.setEditable(false);
        mostrarEndereco.setColumns(10);

        lblEndereo = new JLabel("ENDERE\u00C7O:");
        lblEndereo.setFont(new Font("Arial", Font.BOLD, 15));
        lblEndereo.setBounds(109, 329, 95, 18);
        panel.add(lblEndereo);

        mostrarCEP = new JTextField();
        mostrarCEP.setBackground(Color.WHITE);
        mostrarCEP.setFont(new Font("Arial", Font.PLAIN, 13));
        mostrarCEP.setBorder(new LineBorder(new Color(0, 0, 0), 2));
        mostrarCEP.setBounds(214, 375, 179, 20);
        panel.add(mostrarCEP);
        mostrarCEP.setEditable(false);
        mostrarCEP.setColumns(10);

        lblCep = new JLabel("CEP:");
        lblCep.setFont(new Font("Arial", Font.BOLD, 15));
        lblCep.setBounds(156, 376, 37, 17);
        panel.add(lblCep);

        JButton btnConsultar = new JButton("CONSULTAR");
        btnConsultar.setIcon(new ImageIcon(Employee_Consult.class.getResource("/images/magnifier-1_icon-icons.com_56924.png")));
        btnConsultar.setFont(new Font("Arial", Font.BOLD, 13));
        btnConsultar.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
        btnConsultar.setBounds(310, 68, 156, 41);
        panel.add(btnConsultar);

        mostrarRg = new JTextField();
        mostrarRg.setBackground(Color.WHITE);
        mostrarRg.setFont(new Font("Arial", Font.PLAIN, 13));
        mostrarRg.setBorder(new LineBorder(new Color(0, 0, 0), 2));
        mostrarRg.setBounds(214, 196, 179, 20);
        panel.add(mostrarRg);
        mostrarRg.setEditable(false);
        mostrarRg.setColumns(10);

        mostrarSexo = new JTextField();
        mostrarSexo.setBackground(Color.WHITE);
        mostrarSexo.setFont(new Font("Arial", Font.PLAIN, 13));
        mostrarSexo.setBorder(new LineBorder(new Color(0, 0, 0), 2));
        mostrarSexo.setBounds(214, 516, 179, 20);
        panel.add(mostrarSexo);
        mostrarSexo.setEditable(false);
        mostrarSexo.setColumns(10);

        mostrarCPF = new JTextField();
        mostrarCPF.setBackground(Color.WHITE);
        mostrarCPF.setFont(new Font("Arial", Font.PLAIN, 13));
        mostrarCPF.setBorder(new LineBorder(new Color(0, 0, 0), 2));
        mostrarCPF.setBounds(214, 154, 179, 20);
        panel.add(mostrarCPF);
        mostrarCPF.setEditable(false);
        mostrarCPF.setColumns(10);

        JLabel lblSexo = new JLabel("SEXO:");
        lblSexo.setFont(new Font("Arial", Font.BOLD, 15));
        lblSexo.setBounds(147, 517, 46, 16);
        panel.add(lblSexo);
        mostrarNomes = new JComboBox(new Vector<String>(Emt.pegarNome()));
        mostrarNomes.setFont(new Font("Arial", Font.BOLD, 14));
        mostrarNomes.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
        mostrarNomes.setBounds(42, 74, 261, 29);
        panel.add(mostrarNomes);
        mostrarNomes.setForeground(Color.BLACK);
        mostrarNomes.setBackground(Color.WHITE);

        lblPesquisar = new JLabel("PESQUISAR");
        lblPesquisar.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        lblPesquisar.setBounds(177, 11, 147, 40);
        panel.add(lblPesquisar);

        mostrarCargo = new JTextField();
        mostrarCargo.setBackground(Color.WHITE);
        mostrarCargo.setBorder(new LineBorder(new Color(0, 0, 0), 2));
        mostrarCargo.setFont(new Font("Arial", Font.PLAIN, 13));
        mostrarCargo.setBounds(214, 564, 179, 20);
        panel.add(mostrarCargo);
        mostrarCargo.setColumns(10);

        JLabel label_1 = new JLabel("");
        label_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
        label_1.setBounds(25, 120, 441, 518);
        panel.add(label_1);

        label_2 = new JLabel("");
        label_2.setBorder(new MatteBorder(0, 0, 2, 0, Color.BLACK));
        label_2.setBounds(39, 37, 425, 14);
        panel.add(label_2);

        label = new JLabel("");
        label.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
        label.setIcon(new ImageIcon(Employee_Consult.class.getResource("/images/Compartilhada do Lightroom mobile (3).jpg")));
        label.setBounds(0, 0, 794, 671);
        contentPane.add(label);

        btnConsultar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int in = mostrarNomes.getSelectedIndex();//PEGANDO O �NDICE DO COMBOBOX

                try {
                    if (Employee.permission) {
                        //ARRAY PRA PEGAR OS DADOS
                        ArrayList<String> CPF = Emt.pegarCPF();
                        ArrayList<String> TELEFONE = Emt.pegarTelefone();
                        ArrayList<String> ENDERECO = Emt.pegarEndereco();
                        ArrayList<String> SEXO = Emt.pegarSexo();
                        ArrayList<String> DATADENASCIMENTO = Emt.pegarDataNascimento();
                        ArrayList<String> RG = Emt.pegarRG();
                        ArrayList<String> CEP = Emt.pegarCEP();
                        ArrayList<String> SALARIO = Emt.pegarSalar();
                        ArrayList<String> CODIGO = Emt.pegarCod();
                        ArrayList<String> CARGO = Emt.pegarCargo();


                        mostrarCPF.setText(CPF.get(in));
                        mostrarTelefone.setText(TELEFONE.get(in));
                        mostrarEndereco.setText(ENDERECO.get(in));
                        mostrarSexo.setText(SEXO.get(in));
                        mostrarDataNascimento.setText(DATADENASCIMENTO.get(in));
                        mostrarRg.setText(RG.get(in));
                        mostrarCEP.setText(CEP.get(in));
                        mostrarSalario.setText(SALARIO.get(in));
                        mostrarCodigo.setText(CODIGO.get(in));
                        mostrarCargo.setText(CARGO.get(in));
                    } else {
                        JOptionPane.showMessageDialog(null, "N�O H� FUNCION�RIOS CADASTRADOS");
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
                    Employee_Consult frame = new Employee_Consult();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
