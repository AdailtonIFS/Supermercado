package Employees;

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


public class Employee_Registration extends JFrame {

	private JPanel contentPane;
	private JTextField NomeFun;
	private MaskFormatter ftmTelefone;//Atributo formatador para telefone     
	private MaskFormatter ftmRG;//Atributo formatador para data
	private MaskFormatter ftmCPF;//Atributo que formato o CPF
	private MaskFormatter ftmCEP;//Atributo que formato o CPF
	private JLabel lblCpf;
	private JLabel lblTelefone;
	private JTextField ENDERECO;
	private JTextField CodFun;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField Salar;
	private JTextField textField_5;
	private JTextField Cargo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Employee_Registration frame = new Employee_Registration();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public Employee_Registration() throws ParseException {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Employee_Registration.class.getResource("/images/download.png")));
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		setTitle("CADASTRO DE FUNCION\u00C1RIOS");

		ftmTelefone = new MaskFormatter("(##)#####-####");
		ftmRG = new MaskFormatter("#.###.###-#");
		ftmCPF = new MaskFormatter("###.###.###-##");
		ftmCEP = new MaskFormatter("#####-###");


		Employee Em =  new Employee();
		ArrayList <Employee> funcionarios = new ArrayList <Employee>();

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 810, 710);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 204, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.BLACK);
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panel.setBackground(new Color(240, 255, 240));
		panel.setBounds(178, 34, 445, 166);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("NOME:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(34, 43, 65, 19);
		panel.add(lblNewLabel);
		
		NomeFun = new JTextField();
		NomeFun.setFont(new Font("Arial", Font.PLAIN, 13));
		NomeFun.setBorder(new LineBorder(Color.BLACK));
		NomeFun.setBounds(109, 43, 141, 19);
		panel.add(NomeFun);
		NomeFun.setColumns(10);
		
		lblCpf = new JLabel("CPF:");
		lblCpf.setHorizontalAlignment(SwingConstants.CENTER);
		lblCpf.setForeground(Color.BLACK);
		lblCpf.setFont(new Font("Arial", Font.BOLD, 15));
		lblCpf.setBounds(47, 104, 52, 20);
		panel.add(lblCpf);
		
		JFormattedTextField CPF = new JFormattedTextField(ftmCPF);
		CPF.setFont(new Font("Arial", Font.PLAIN, 13));
		CPF.setBorder(new LineBorder(Color.BLACK));
		CPF.setBounds(109, 104, 141, 22);
		panel.add(CPF);
		
		JLabel lblRegistroGeralrg = new JLabel("RG:");
		lblRegistroGeralrg.setForeground(Color.BLACK);
		lblRegistroGeralrg.setFont(new Font("Arial", Font.BOLD, 15));
		lblRegistroGeralrg.setBounds(59, 73, 33, 19);
		panel.add(lblRegistroGeralrg);
		
		JFormattedTextField RG = new JFormattedTextField(ftmRG);
		RG.setFont(new Font("Arial", Font.PLAIN, 13));
		RG.setBorder(new LineBorder(Color.BLACK));
		RG.setBounds(109, 73, 141, 20);
		panel.add(RG);
		
		JLabel lblNewLabel_1 = new JLabel("C\u00D3DIGO:");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(15, 135, 84, 19);
		panel.add(lblNewLabel_1);
		
		CodFun = new JTextField();
		CodFun.setFont(new Font("Arial", Font.PLAIN, 13));
		CodFun.setBorder(new LineBorder(Color.BLACK));
		CodFun.setBounds(109, 137, 141, 19);
		panel.add(CodFun);
		CodFun.setColumns(10);
		
		JLabel lblFuncionrios = new JLabel("FUNCION\u00C1RIOS");
		lblFuncionrios.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblFuncionrios.setBounds(276, 11, 159, 50);
		panel.add(lblFuncionrios);
		
		JLabel label_1 = new JLabel("");
		label_1.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		label_1.setBounds(276, 42, 148, 14);
		panel.add(label_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panel_1.setBackground(new Color(245, 245, 220));
		panel_1.setBounds(178, 200, 445, 433);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JDateChooser DataN = new JDateChooser();
		DataN.setBorder(new LineBorder(Color.BLACK));
		DataN.setBounds(185, 43, 208, 25);
		panel_1.add(DataN);
		
		JLabel lblDataDeNascimento = new JLabel("DATA (NASCIMENTO):");
		lblDataDeNascimento.setHorizontalAlignment(SwingConstants.CENTER);
		lblDataDeNascimento.setFont(new Font("Arial", Font.BOLD, 13));
		lblDataDeNascimento.setBounds(23, 43, 152, 25);
		panel_1.add(lblDataDeNascimento);
		
		JComboBox<String> Sexo = new  JComboBox<String>();
		Sexo.setFont(new Font("Arial", Font.PLAIN, 13));
		Sexo.setBorder(new LineBorder(Color.BLACK));
		Sexo.setBounds(185, 83, 208, 25);
		panel_1.add(Sexo);
		
		JLabel lblSexo = new JLabel("SEXO:");
		lblSexo.setFont(new Font("Arial", Font.BOLD, 13));
		lblSexo.setHorizontalAlignment(SwingConstants.CENTER);
		lblSexo.setBounds(123, 83, 52, 25);
		panel_1.add(lblSexo);
		
		Salar = new JTextField();
		Salar.setFont(new Font("Arial", Font.PLAIN, 13));
		Salar.setBorder(new LineBorder(Color.BLACK));
		Salar.setBounds(185, 124, 208, 25);
		panel_1.add(Salar);
		Salar.setColumns(10);
		
		JLabel lblEmail = new JLabel("SAL\u00C1RIO:");
		lblEmail.setFont(new Font("Arial", Font.BOLD, 13));
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setBounds(104, 126, 71, 21);
		panel_1.add(lblEmail);
		
		JFormattedTextField PHONE = new JFormattedTextField(ftmTelefone);
		PHONE.setFont(new Font("Arial", Font.PLAIN, 13));
		PHONE.setBorder(new LineBorder(Color.BLACK));
		PHONE.setBounds(185, 170, 208, 25);
		panel_1.add(PHONE);
		
		
		lblTelefone = new JLabel("TELEFONE:");
		lblTelefone.setHorizontalAlignment(SwingConstants.CENTER);
		lblTelefone.setFont(new Font("Arial", Font.BOLD, 13));
		lblTelefone.setBounds(91, 172, 84, 21);
		panel_1.add(lblTelefone);
		
		ENDERECO = new JTextField();
		ENDERECO.setFont(new Font("Arial", Font.PLAIN, 13));
		ENDERECO.setBorder(new LineBorder(Color.BLACK));
		ENDERECO.setBounds(185, 217, 208, 25);
		panel_1.add(ENDERECO);
		ENDERECO.setColumns(10);
		
		JLabel lblEndereo = new JLabel("ENDERE\u00C7O:");
		lblEndereo.setFont(new Font("Arial", Font.BOLD, 13));
		lblEndereo.setHorizontalAlignment(SwingConstants.CENTER);
		lblEndereo.setBounds(85, 216, 90, 26);
		panel_1.add(lblEndereo);
		
		JFormattedTextField CEP = new JFormattedTextField(ftmCEP);
		CEP.setFont(new Font("Arial", Font.PLAIN, 13));
		CEP.setBorder(new LineBorder(Color.BLACK));
		CEP.setBounds(185, 309, 208, 25);
		panel_1.add(CEP);
		
		JLabel lblCep = new JLabel("CEP:");
		lblCep.setHorizontalAlignment(SwingConstants.CENTER);
		lblCep.setFont(new Font("Arial", Font.BOLD, 13));
		lblCep.setBounds(128, 308, 47, 26);
		panel_1.add(lblCep);
		
		JLabel lblNewLabel_2 = new JLabel("CARGO:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_2.setBounds(104, 266, 71, 21);
		panel_1.add(lblNewLabel_2);
		
		Cargo = new JTextField();
		Cargo.setFont(new Font("Arial", Font.PLAIN, 13));
		Cargo.setBorder(new LineBorder(Color.BLACK));
		Cargo.setBounds(185, 264, 208, 25);
		panel_1.add(Cargo);
		Cargo.setColumns(10);
		
		JButton CANCELAR = new JButton("CANCELAR");
		CANCELAR.setIcon(new ImageIcon(Employee_Registration.class.getResource("/images/Cancel_icon-icons.com_73703.png")));
		CANCELAR.setFont(new Font("Arial", Font.BOLD, 13));
		CANCELAR.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		CANCELAR.setBounds(50, 369, 125, 35);
		panel_1.add(CANCELAR);
		CANCELAR.setBackground(UIManager.getColor("Button.background"));
		
		JButton btnNewButton = new JButton("SALVAR");
		btnNewButton.setIcon(new ImageIcon(Employee_Registration.class.getResource("/images/-cloud-confirm_86838.png")));
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 13));
		btnNewButton.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btnNewButton.setBounds(277, 369, 116, 35);
		panel_1.add(btnNewButton);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(UIManager.getColor("Button.background"));
		
				
				
					btnNewButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							int in = Sexo.getSelectedIndex();
		
							//NOME_____________________________
							if(NomeFun.getText().isEmpty()) {
								
								JOptionPane.showMessageDialog(null,"POR FAVOR INFORME SEU NOME, CAMPO OBRIGATÓRIO");
							
							}
							//_________________________________
							
							
								//CÓDIGO_______________________
							else 
								if(CodFun.getText().isEmpty()) {
								
								JOptionPane.showMessageDialog(null,"POR FAVOR INFORME O CÓDIGO, CAMPO OBRIGATÓRIO");
							
								}
								//_____________________________
								
							
								//RG___________________________
								else	
									if(RG.getText().trim().length() < 11) {
								
								JOptionPane.showMessageDialog(null,"POR FAVOR INFORME O RG, CAMPO OBRIGATÓRIO");
								
							}
								//_____________________________
							
								//CPF__________________________
								else
									if(CPF.getText().trim().length() < 14) {
								
								JOptionPane.showMessageDialog(null,"POR FAVOR INFORME O CPF, CAMPO OBRIGATÓRIO");
				
							}
								//_____________________________
							
								//DATA_DE_NASCIMENTO___________
									else
										if(DataN.getDate() == null) {
									 
									JOptionPane.showMessageDialog(null,"POR FAVOR INFORME A DATA DE NASCIMENTO, CAMPO OBRIGATÓRIO");
								}
								//_____________________________
				
							
							
								//VALIDANDO_SEXO_______________
										else if(in == 0) {
								
											JOptionPane.showMessageDialog(null,"SEXO INVÁLIDO");
										}
										else 
											if(in > 0 && in <3) {
									
									Em.setSex((String) Sexo.getSelectedItem());
								}
							
											else
												if(in == 3) {
										Em.setSex((String) Sexo.getSelectedItem());
										JOptionPane.showMessageDialog(null,"OK, COMPREENDEMOS");
										
									}
								//____________________________
							
							
							
							
			
								//FINAL
							if(NomeFun.getText().isEmpty() || CodFun.getText().isEmpty() || CPF.getText().trim().length() < 14 || in == 0) {
								
								
								
							}
							else {		
		
								Em.setName(NomeFun.getText());	
								Em.setCodFun(CodFun.getText());
								Em.setCPF(CPF.getText());
								Em.setRG(RG.getText());
								SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");
								String result = out.format(DataN.getDate());
								
								Em.setBornDate(result);
								Em.setSalar(Double.parseDouble(Salar.getText()));
								Em.setPhone(PHONE.getText());		
								Em.setAdress(ENDERECO.getText());
								
								Em.setOffice(Cargo.getText());
								Em.setCEP(CEP.getText());
								
								funcionarios.add(Em);
									try{
									
									Em.gravar();	
									
									}
									catch(IOException e1){
										e1.printStackTrace();
									}//fimgravar
								//Final
								JOptionPane.showMessageDialog(null,"CADASTRO REALIZADO COM SUCESSO", "CADASTRO",JOptionPane.PLAIN_MESSAGE);
								dispose();
							}//SALVANDO TUDO NA CLASSE E ARRAYLIST
						
						}
					});
		
		
	
		//BOTAO DE CANCELAR
		CANCELAR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object[] options = { "SIM", "NÃO" };
				int Cancel = JOptionPane.showOptionDialog(null, "TEM CERTEZA QUE DESEJA CANCELAR?", "ALERTA", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE , null, options, options[0]);
			
		if(Cancel == JOptionPane.YES_OPTION) {
			JOptionPane.showMessageDialog(null,"CADASTRO CANCELADO");
			dispose();
		}
		
		
			}
		});
		
		JLabel label = new JLabel("");
		label.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		label.setIcon(new ImageIcon(Employee_Registration.class.getResource("/images/Compartilhada do Lightroom mobile (7).jpg")));
		label.setBounds(0, 0, 794, 671);
		contentPane.add(label);
		Sexo.addItem("ESCOLHA SEU SEXO:");
		Sexo.addItem("MASCULINO");
		Sexo.addItem("FEMININO");
		Sexo.addItem("PREFIRO NÃO RESPONDER");
			//SALVAR
			
			
			
			
			
			
		
	}
}
