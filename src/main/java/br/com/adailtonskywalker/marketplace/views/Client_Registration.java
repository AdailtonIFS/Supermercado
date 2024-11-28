package br.com.adailtonskywalker.marketplace.views;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.MaskFormatter;

import com.toedter.calendar.JDateChooser;

import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import java.awt.Toolkit;
import br.com.adailtonskywalker.marketplace.domain.*;


public class Client_Registration extends JFrame {

    int cont = 0;
    private JPanel contentPane;
    private JTextField NomeCl;
    private MaskFormatter ftmTelefone;//ATRIBUTO FORMATADOR PARA TELEFONE�����
    private MaskFormatter ftmRG;//ATRIBUTO FORMATADOR PARA DATA
    private MaskFormatter ftmCPF;//ATRIBUTO FORMATADOR PARA CPF
    private MaskFormatter ftmCEP;//ATRIBUTO FORMATADOR PARA CEP
    private JLabel labelCPF;
    private JLabel lblTelefone;
    private JTextField ENDERECO;
    private JTextField CodCl;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField email;
    private JTextField textField_5;


    /**
     * Create the frame.
     *
     * @throws ParseException
     */
    public Client_Registration() throws ParseException {
        setIconImage(Toolkit.getDefaultToolkit().getImage(Client_Registration.class.getResource("/images/business_application_addmale_useradd_insert_add_user_client_2312.png")));
        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        setTitle("CADASTRO DE CLIENTES");

        //MASCARAS
        ftmTelefone = new MaskFormatter("(##)#####-####");//MASCARA DO N�MERO DE CELULAR
        ftmRG = new MaskFormatter("#.###.###-#");//MASCARA DE RG
        ftmCPF = new MaskFormatter("###.###.###-##");//MASCARA DE CPF
        ftmCEP = new MaskFormatter("#####-###");//MASCARA DO CEP
        //FECHAR SESS�ES DE MASCARAS


        Client Cl = new Client();//INSTANCIANDO MINHA CLASSE CLIENTE
        ArrayList<Client> clientes = new ArrayList<Client>();//MEU ARRAYLIST DE CLASSE

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 810, 710);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(102, 204, 0));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panelCima = new JPanel();        //CRIANDO PANEL DA PARTE DE CIMA
        panelCima.setForeground(Color.BLACK);    //COR DE FORA
        panelCima.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));//COLOCANDO BORDA
        panelCima.setBackground(new Color(240, 255, 240));//COR DO PAINEL
        panelCima.setBounds(188, 80, 413, 170);//DEFININDO TAMANHO
        contentPane.add(panelCima);//ADICIONANDO O PAINEL A MINHA TELA
        panelCima.setLayout(null);

        JLabel labelNome = new JLabel("NOME:");//LABEL DO NOME
        labelNome.setHorizontalAlignment(SwingConstants.CENTER);//ALINHAMENTO DO LABEL
        labelNome.setFont(new Font("Arial", Font.BOLD, 15));//FONTE E TAMANHO DA LETRA DO LABEL
        labelNome.setForeground(Color.BLACK);//COR DA LETRA DO LABEL
        labelNome.setBounds(23, 37, 65, 19);//TAMANHO DO LABEL
        panelCima.add(labelNome);//ADICIONANDO LABEL AO PAINEL DE CIMA

        NomeCl = new JTextField();//CAMPO PRO USU�RIO DIGITAR O NOME
        NomeCl.setFont(new Font("Arial", Font.PLAIN, 13));
        NomeCl.setBorder(new LineBorder(new Color(0, 0, 0)));
        NomeCl.setBounds(98, 38, 165, 19);//TAMANHO DO CAMPO
        panelCima.add(NomeCl);//ADICIONANDO AO PAINEL DE CIMA
        NomeCl.setColumns(10);

        labelCPF = new JLabel("CPF:");//LABEL DO CPF
        labelCPF.setHorizontalAlignment(SwingConstants.CENTER);//ALINHAMENTO DO LABEL
        labelCPF.setForeground(Color.BLACK);//COR DA LETRA DO LABEL
        labelCPF.setFont(new Font("Arial", Font.BOLD, 15));//FONTE E TAMANHO DA LETRA DO LABEL
        labelCPF.setBounds(33, 67, 58, 20);//TAMANHO DO LABEL
        panelCima.add(labelCPF);//ADICIONANDO O LABEL AO PAINEL DE CIMA

        JFormattedTextField CPF = new JFormattedTextField(ftmCPF);//CAMPO QUE USA MASCARA DE CPF
        CPF.setFont(new Font("Arial", Font.PLAIN, 13));
        CPF.setBorder(new LineBorder(Color.BLACK));
        CPF.setBounds(98, 69, 165, 19);//TAMANHO DO CAMPO
        panelCima.add(CPF);//ADICIONANDO O LABEL AO PAINEL DE CIMA

        JLabel labelRG = new JLabel("RG:");//LABEL DO RG
        labelRG.setForeground(Color.BLACK);//COR DA LETRA DO LABEL
        labelRG.setFont(new Font("Arial", Font.BOLD, 15));//FONTE E TAMANHO DA LETRA DO LABEL
        labelRG.setBounds(51, 98, 37, 19);//TAMANHO DO LABEL
        panelCima.add(labelRG);//ADICIONANDO O LABEL AO PAINEL DE CIMA

        JFormattedTextField RG = new JFormattedTextField(ftmRG);//CAMPO QUE USA MASCARA DE RG
        RG.setFont(new Font("Arial", Font.PLAIN, 13));
        RG.setBorder(new LineBorder(Color.BLACK));
        RG.setBounds(98, 99, 165, 20);//TAMANHO DO CAMPO

        panelCima.add(RG);//ADICIONANDO O LABEL AO PAINEL DE CIMA

        JLabel labelCod = new JLabel("C\u00D3DIGO:");//LABEL DO C�DIGO
        labelCod.setForeground(Color.BLACK);//COR DE FORA
        labelCod.setFont(new Font("Arial", Font.BOLD, 15));//FONTE E TAMANHO DO LABEL
        labelCod.setHorizontalAlignment(SwingConstants.CENTER);//ALINHAMENTO
        labelCod.setBounds(0, 128, 101, 19);//TAMANHO DO LABEL
        panelCima.add(labelCod);//ADICIONANDO O LABEL AO PAINEL DE CIMA

        CodCl = new JTextField();//CAMPO DO C�DIGO
        CodCl.setFont(new Font("Arial", Font.PLAIN, 13));
        CodCl.setBorder(new LineBorder(Color.BLACK));
        CodCl.setBounds(98, 130, 165, 20);//TAMANHO DO CAMPO
        panelCima.add(CodCl);//ADICIONANDO O LABEL AO PAINEL DE CIMA
        CodCl.setColumns(10);

        JLabel lblClientes = new JLabel("CLIENTES");//LABEL DO CLIENTE
        lblClientes.setFont(new Font("Comic Sans MS", Font.BOLD, 18));//FONTE E TAMANHO DA LETRA DO LABEL
        lblClientes.setBounds(287, 11, 101, 36);//TAMANHO DO LABEL
        panelCima.add(lblClientes);//ADICIONANDO O LABEL AO PAINEL DE CIMA

        JLabel label_1 = new JLabel("");
        label_1.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
        label_1.setBounds(287, 33, 101, 14);
        panelCima.add(label_1);

        JPanel panelBaixo = new JPanel();//PAINEL DA PARTE DE BAIXO
        panelBaixo.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));//BORDA DO PAINEL
        panelBaixo.setBackground(SystemColor.info);//COR DO PAINEL
        panelBaixo.setBounds(188, 245, 413, 357);//TAMANHO DO PAINEL
        contentPane.add(panelBaixo);//ADICIONANDO O LABEL AO PAINEL DE BAIXO
        panelBaixo.setLayout(null);

        JDateChooser DataN = new JDateChooser();//JDateChooser USADO PRA PEGAR A DATA DE NASCIMENTO
        DataN.setBorder(new LineBorder(new Color(0, 0, 0)));
        DataN.setBounds(174, 51, 195, 25);//TAMANHO DO JDateChooser
        panelBaixo.add(DataN);//ADICIONANDO O JDateChoooser AO PAINEL DE BAIXO

        JLabel lblDataDeNascimento = new JLabel("DATA (NASCIMENTO):");//LABEL DATA DE NASCIMENTO
        lblDataDeNascimento.setHorizontalAlignment(SwingConstants.CENTER);//ALINHAMENTO
        lblDataDeNascimento.setFont(new Font("Arial", Font.BOLD, 13));//FONTE E TAMANHO DA LETRA DO LABEL
        lblDataDeNascimento.setBounds(10, 51, 154, 25);//TAMANHO DO LABEL
        panelBaixo.add(lblDataDeNascimento);//ADICIONANDO O LABEL AO PAINEL DE BAIXO

        JComboBox<String> Sexo = new JComboBox<String>();//COMBOBOX DE STRING PRO SEXO
        Sexo.setBackground(Color.WHITE);
        Sexo.setFont(new Font("Arial", Font.PLAIN, 12));
        Sexo.setBorder(new LineBorder(Color.BLACK));
        Sexo.setBounds(174, 87, 195, 25);//TAMANHO DO COMBOBOX
        panelBaixo.add(Sexo);//ADICIONADO O COMBOBOX AO PAINEL DE BAIXO
        Sexo.addItem("ESCOLHA SEU SEXO:");
        Sexo.addItem("MASCULINO");
        Sexo.addItem("FEMININO");
        Sexo.addItem("PREFIRO N�O RESPONDER");

        JLabel lblSexo = new JLabel("SEXO:");//LABEL DO SEXO
        lblSexo.setFont(new Font("Arial", Font.BOLD, 13));//TAMANHO E FONTE DA LETRA DO LABEL
        lblSexo.setHorizontalAlignment(SwingConstants.CENTER);//ALINHAMENTO
        lblSexo.setBounds(104, 86, 60, 25);//TAMANHO DO LABEL
        panelBaixo.add(lblSexo);//ADICIONANDO O LABEL AO PAINEL DE BAIXO

        email = new JTextField();//CAMPO DO EMAIL
        email.setFont(new Font("Arial", Font.PLAIN, 13));
        email.setBorder(new LineBorder(Color.BLACK));
        email.setBounds(174, 123, 195, 25);//TAMANHO DO CAMPO
        panelBaixo.add(email);//ADICIONANDO O CAMPO AO PAINEL DE BAIXO
        email.setColumns(10);

        JLabel lblEmail = new JLabel("E-MAIL:");//LABEL DO EMAIL
        lblEmail.setFont(new Font("Arial", Font.BOLD, 13));//FONTE E TAMANHO DA LETRA DO LABEL
        lblEmail.setHorizontalAlignment(SwingConstants.CENTER);//ALINHAMENTO DO LABEL
        lblEmail.setBounds(93, 122, 71, 25);//TAMANHO DO LABEL
        panelBaixo.add(lblEmail);//ADICIONANDO O LABEL AO PAINEL DE BAIXO

        JFormattedTextField PHONE = new JFormattedTextField(ftmTelefone);//CAMPO QUE USA A MASCARA DO TELEFONE
        PHONE.setFont(new Font("Arial", Font.PLAIN, 13));
        PHONE.setBorder(new LineBorder(Color.BLACK));
        PHONE.setBounds(174, 159, 195, 25);//TAMANHO DO CAMPO
        panelBaixo.add(PHONE);//ADICIONANDO O CAMPO AO PAINEL DE BAIXO

        lblTelefone = new JLabel("TELEFONE:");//LABEL DO TELEFONE
        lblTelefone.setHorizontalAlignment(SwingConstants.CENTER);//ALINHAMENTO DO LABEL
        lblTelefone.setFont(new Font("Arial", Font.BOLD, 13));//FONTE E TAMANHO DA LETRA DO LABEL
        lblTelefone.setBounds(80, 160, 84, 21);//TAMANHO DO LABEL
        panelBaixo.add(lblTelefone);//ADICIONANDO O LABEL AO PAINEL DE BAIXO

        ENDERECO = new JTextField();//CAMPO DO ENDERECO
        ENDERECO.setFont(new Font("Arial", Font.PLAIN, 13));
        ENDERECO.setBorder(new LineBorder(Color.BLACK));
        ENDERECO.setBounds(174, 195, 195, 25);//TAMANHO DO CAMPO
        panelBaixo.add(ENDERECO);//ADICIONANDO O CAMPO AO PAINEL DE BAIXO
        ENDERECO.setColumns(10);

        JLabel lblEndereco = new JLabel("ENDERE\u00C7O:");//LABEL DO ENDERECO
        lblEndereco.setFont(new Font("Arial", Font.BOLD, 13));//FONTE E TAMANHO DA LETRA DO LABEL
        lblEndereco.setHorizontalAlignment(SwingConstants.CENTER);//ALINHAMENTO DO LABEL
        lblEndereco.setBounds(80, 194, 89, 25);//TAMANHO DO LABEL
        panelBaixo.add(lblEndereco);//ADICIONANDO O LABEL AO PAINEL DE BAIXO

        JFormattedTextField CEP = new JFormattedTextField(ftmCEP);//CAMPO QUE USA A MASCARA DO CEP
        CEP.setFont(new Font("Arial", Font.PLAIN, 13));
        CEP.setBorder(new LineBorder(Color.BLACK));
        CEP.setBounds(174, 231, 195, 25);//TAMANHO DO CAMPO
        panelBaixo.add(CEP);//ADICIONANDO O CAMPO AO PAINEL DE BAIXO

        JLabel lblCep = new JLabel("CEP:");//LABEL DO CEP
        lblCep.setHorizontalAlignment(SwingConstants.CENTER);//ALINHAMENTO DO LABEL
        lblCep.setFont(new Font("Arial", Font.BOLD, 13));//FONTE E TAMANHO DA LETRA DO LABEL
        lblCep.setBounds(120, 230, 40, 25);//TAMANHO DO LABEL
        panelBaixo.add(lblCep);//ADICIONANDO O LABEL

        JButton CANCELAR = new JButton("CANCELAR");//CRIANDO BOT�O DE CANCELAR
        CANCELAR.setIcon(new ImageIcon(Client_Registration.class.getResource("/images/delete_delete_deleteusers_delete_male_user_maleclient_2348.png")));
        CANCELAR.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
        CANCELAR.setFont(new Font("Arial", Font.BOLD, 13));
        CANCELAR.setBounds(51, 291, 113, 41);//TAMANHO DO BOT�O
        panelBaixo.add(CANCELAR);//ADICIONANDO O BOT�O AO PAINEL DE BAIXO
        CANCELAR.setBackground(UIManager.getColor("Button.background"));//COR DO BOT�O


        //A��O DO BOTAO DE CANCELAR
        CANCELAR.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                Object[] options = {"SIM", "N�O"};//CRIANDO UM OBJETO DE OP��ES
                int Cancel = JOptionPane.showOptionDialog(null, "TEM CERTEZA QUE DESEJA CANCELAR?", "ALERTA", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);//JOptionPane DE CONFIRMA��O

                //VERIFICANDO RESPOSTA DO USU�RIO
                if (Cancel == JOptionPane.YES_OPTION) {//RESPOSTA SIM
                    JOptionPane.showMessageDialog(null, "CADASTRO CANCELADO");//EXIBINDO CONFIRMA��O
                    dispose();//FECHANDO MINHA TELA
                }


            }
        });

        JButton SALVAR = new JButton("SALVAR");//CRIANDO BOT�O SALVAR
        SALVAR.setIcon(new ImageIcon(Client_Registration.class.getResource("/images/businessapplication_accept_ok_male_man_you_negocio_2311.png")));
        SALVAR.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
        SALVAR.setFont(new Font("Arial", Font.BOLD, 13));
        SALVAR.setBounds(255, 291, 114, 41);//TAMANHO DO BOT�O
        panelBaixo.add(SALVAR);//ADICIONANDO O BOT�O AO PAINEL DE BAIXO
        SALVAR.setForeground(Color.BLACK);//FUNDO DO BOT�O
        SALVAR.setBackground(UIManager.getColor("Button.background"));//COR DO BOT�O


        //AC�O DO BOT�O DE SALVAR
        SALVAR.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                int in = Sexo.getSelectedIndex();//PEGANDO O �NDICE DO COMBOBOX

                //VERIFICANDO SE O CAMPO NOME EST� VAZIO
                if (NomeCl.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "POR FAVOR INFORME SEU NOME, CAMPO OBRIGAT�RIO");
                }
                //_________________________________


                //VERIFICANDO SE O CAMPO C�DIGO EST� VAZIO
                else if (CodCl.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "POR FAVOR INFORME O C�DIGO, CAMPO OBRIGAT�RIO");
                }

                //_____________________________


                //VERIFICANDO SE O CAMPO DO RG EST� VAZIO
                else if (RG.getText().trim().length() < 11) {
                    JOptionPane.showMessageDialog(null, "POR FAVOR INFORME O RG, CAMPO OBRIGAT�RIO");
                }
                //_____________________________

                //VERIFICANDO SE O CAMPO DO CPF EST� VAZIO
                else if (CPF.getText().trim().length() < 14) {
                    JOptionPane.showMessageDialog(null, "POR FAVOR INFORME O CPF, CAMPO OBRIGAT�RIO");
                }
                //_____________________________

                //VERIFICANDO SE O CAMPO DA DATA DE NASCIMENTO EST� VAZIO
                else if (DataN.getDate() == null) {
                    JOptionPane.showMessageDialog(null, "POR FAVOR INFORME A DATA DE NASCIMENTO, CAMPO OBRIGAT�RIO");
                }
                //_____________________________


                //VALIDANDO_SEXO_______________
                else if (in == 0) {

                    JOptionPane.showMessageDialog(null, "SEXO INV�LIDO");
                } else if (in > 0 && in < 3) {

                    Cl.setSex((String) Sexo.getSelectedItem());
                } else if (in == 3) {
                    Cl.setSex((String) Sexo.getSelectedItem());
                    JOptionPane.showMessageDialog(null, "OK, COMPREENDEMOS");

                }
                //____________________________


                //FINAL
                if (NomeCl.getText().isEmpty() || CodCl.getText().isEmpty() || CPF.getText().trim().length() < 14 || in == 0) {

                } else {

                    Cl.setName(NomeCl.getText());
                    Cl.setCPF(CPF.getText());
                    Cl.setPhone(PHONE.getText());
                    Cl.setAdress(ENDERECO.getText());

                    SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");
                    String result = out.format(DataN.getDate());

                    Cl.setBornDate(result);

                    Cl.setRG(RG.getText());
                    Cl.setCEP(CEP.getText());
                    Cl.setEmail(email.getText());
                    Cl.setCodCl(CodCl.getText());

                    clientes.add(Cl);//RECEBENDO TODOS OS ATRIBUTOS E JOGANDO NO MEU ARQUIVO TEXTO
                    try {

                        Cl.gravar();//CHAMANDO O M�TODO GRAVAR QUE GRAVA AS INFORMA��ES NO MEU ARQUIVO TEXTO

                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }//FIM GRAVAR
                    //Final
                    cont++;
                    JOptionPane.showMessageDialog(null, "CADASTRO REALIZADO COM SUCESSO", "CADASTRO", JOptionPane.PLAIN_MESSAGE);
                    dispose();//FECHAR MINHA TELA
                }//SALVANDO TUDO NA CLASSE E ARRAYLIST

            }
        });


        JLabel label = new JLabel("");
        label.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
        label.setIcon(new ImageIcon(Client_Registration.class.getResource("/images/Compartilhada do Lightroom mobile.jpg")));
        label.setBounds(0, 0, 794, 671);
        contentPane.add(label);

        //SALVAR


    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Client_Registration frame = new Client_Registration();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
