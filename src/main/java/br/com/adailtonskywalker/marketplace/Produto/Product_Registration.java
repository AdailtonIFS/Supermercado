package Produto;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.text.MaskFormatter;
import java.awt.Toolkit;

public class Product_Registration extends JFrame {

	private JPanel contentPane;
	private JTextField tfNome;
	private JLabel lbCodigo;
	private JTextField tfCodigo;
	private JLabel lbDescricao;
	private JTextField tfTipo;
	private MaskFormatter ftmDinheiro;//Atributo formatador para dinheiro     
	private JTextField Preco;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Product_Registration frame = new Product_Registration();
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
	
	
	public Product_Registration() throws ParseException {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Product_Registration.class.getResource("/images/product_icon-icons.com_52346.png")));
		
		//****** INSTANCIANDO A CLASSE PRODUTO (PRODUCT) ******** 
		
		Product pd = new Product();
		
		ArrayList <Product> produtos = new ArrayList <Product>();
		
		//********************************************************
		
		
		setTitle("CADASTRO DE PRODUTOS");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 810, 710);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panel.setBackground(new Color(255, 204, 153));
		panel.setBounds(186, 24, 423, 183);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lbCodigo = new JLabel("C\u00D3DIGO:");
		lbCodigo.setBounds(23, 83, 73, 37);
		panel.add(lbCodigo);
		lbCodigo.setFont(new Font("Arial", Font.BOLD, 16));
		
		tfCodigo = new JTextField();
		tfCodigo.setFont(new Font("Arial", Font.PLAIN, 13));
		tfCodigo.setBorder(new LineBorder(Color.BLACK));
		tfCodigo.setBounds(99, 93, 114, 20);
		panel.add(tfCodigo);
		tfCodigo.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("PRE\u00C7O:");
		lblNewLabel.setBounds(33, 131, 64, 24);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 15));
		
		Preco = new JTextField();
		Preco.setFont(new Font("Arial", Font.PLAIN, 13));
		Preco.setBorder(new LineBorder(Color.BLACK));
		Preco.setBounds(99, 134, 114, 20);
		panel.add(Preco);
		Preco.setColumns(10);
		
		JLabel lblNome = new JLabel("NOME:");
		lblNome.setFont(new Font("Arial", Font.BOLD, 16));
		lblNome.setBounds(40, 56, 56, 16);
		panel.add(lblNome);
		
		tfNome = new JTextField();
		tfNome.setFont(new Font("Arial", Font.PLAIN, 13));
		tfNome.setBorder(new LineBorder(Color.BLACK));
		tfNome.setBounds(100, 56, 114, 20);
		panel.add(tfNome);
		tfNome.setColumns(10);
		
		JLabel lblutilizePara = new JLabel(" (utilize \".\" para dividir os valores)");
		lblutilizePara.setFont(new Font("Arial", Font.BOLD, 12));
		lblutilizePara.setBounds(219, 135, 204, 17);
		panel.add(lblutilizePara);
		
		JLabel lblProdutos = new JLabel("PRODUTOS");
		lblProdutos.setForeground(Color.BLACK);
		lblProdutos.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		lblProdutos.setBounds(155, 11, 134, 25);
		panel.add(lblProdutos);
		
		JLabel label = new JLabel("");
		label.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		label.setBounds(152, 29, 120, 14);
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panel_1.setBackground(SystemColor.info);
		panel_1.setBounds(186, 207, 423, 437);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label_1 = new JLabel("");
		label_1.setBorder(new LineBorder(Color.BLACK, 2, true));
		label_1.setIcon(new ImageIcon(Product_Registration.class.getResource("/images/LRM_EXPORT_90106466339704_20190830_150139821.jpeg")));
		label_1.setBounds(0, 0, 794, 671);
		contentPane.add(label_1);
		
		lbDescricao = new JLabel("DESCRI\u00C7\u00C3O:");
		lbDescricao.setBounds(156, 140, 115, 22);
		panel_1.add(lbDescricao);
		lbDescricao.setFont(new Font("Arial", Font.BOLD, 16));
		
		JSpinner spQuantidadeEst = new JSpinner();
		spQuantidadeEst.setBounds(156, 66, 73, 22);
		panel_1.add(spQuantidadeEst);
		spQuantidadeEst.setModel(new SpinnerNumberModel(0, 0, 1000, 1));
		spQuantidadeEst.setFont(new Font("Arial", Font.PLAIN, 13));
		
		JLabel lbQuantidadeEst = new JLabel("ESTOQUE:");
		lbQuantidadeEst.setBounds(59, 66, 87, 19);
		panel_1.add(lbQuantidadeEst);
		lbQuantidadeEst.setFont(new Font("Arial", Font.BOLD, 16));
		
		JLabel lbTipo = new JLabel("TIPO:");
		lbTipo.setBounds(94, 25, 52, 22);
		panel_1.add(lbTipo);
		lbTipo.setFont(new Font("Arial", Font.BOLD, 16));
		
		tfTipo = new JTextField();
		tfTipo.setFont(new Font("Arial", Font.PLAIN, 13));
		tfTipo.setBorder(new LineBorder(Color.BLACK));
		tfTipo.setBounds(156, 27, 73, 22);
		panel_1.add(tfTipo);
		tfTipo.setColumns(10);
		
		//========== SALVAR CADASTRO PRODUTO ==========
		
		JButton salvar = new JButton("SALVAR");
		salvar.setIcon(new ImageIcon(Product_Registration.class.getResource("/images/save_file_disk_open_searsh_loading_clipboard_1513.png")));
		salvar.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		salvar.setBounds(243, 372, 115, 43);
		panel_1.add(salvar);
		
		salvar.setFont(new Font("Arial", Font.BOLD, 13));
		
		TextArea taDescricao = new TextArea();
		taDescricao.setBackground(Color.WHITE);
		taDescricao.setBounds(49, 168, 309, 180);
		panel_1.add(taDescricao);
		
		JButton cancelar = new JButton("CANCELAR");
		cancelar.setIcon(new ImageIcon(Product_Registration.class.getResource("/images/cancel_77947.png")));
		cancelar.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		cancelar.setBounds(49, 372, 129, 43);
		panel_1.add(cancelar);
		cancelar.setFont(new Font("Arial", Font.BOLD, 13));
		
		JLabel label_2 = new JLabel("");
		label_2.setBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(0, 0, 0)));
		label_2.setBounds(437, 0, 57, 14);
		panel_1.add(label_2);
		
		//================ BOTÃO CANCELAR ================
		
		cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Object[] options = { "SIM", "NÃO" };
				int Cancel = JOptionPane.showOptionDialog(null, "TEM CERTEZA QUE DESEJA CANCELAR?", "ALERTA", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE , null, options, options[0]);
			
		if(Cancel == JOptionPane.YES_OPTION) {
			JOptionPane.showMessageDialog(null,"CADASTRO CANCELADO");
			dispose();
		}
				
			}
		});
		
		//-------------------------------------------------
		
		salvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(tfNome.getText().isEmpty()) {
					
					JOptionPane.showMessageDialog(null,"INFORME O NOME DO PRODUTO, CAMPO OBRIGÁTORIO");

					
				}
				
				else
					if(tfCodigo.getText().isEmpty()) {
						
						JOptionPane.showMessageDialog(null,"INFORME O CÓDIGO DO PRODUTO, CAMPO OBRIGATÓRIO");

					}	
					else
						if(Preco.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null,"INFORME O VALOR DO PRODUTO, CAMPO OBRIGÁTORIO");

					}
					
						
				if(tfNome.getText().isEmpty() || Preco.getText().isEmpty() || tfCodigo.getText().isEmpty()) {
					
					
					
				}
				else {		

					pd.setName(tfNome.getText());
					pd.setPrice(Double.parseDouble(Preco.getText()));
					pd.setCodP(tfCodigo.getText());
					pd.setQStock(Integer.parseInt(spQuantidadeEst.getValue().toString()));
					pd.setDescription(taDescricao.getText());
					pd.setTypes(tfTipo.getText());
					
					produtos.add(pd);
					try{
						
						pd.gravar();	
						
						}
						catch(IOException e1){
							e1.printStackTrace();
						}//fimgravar
					
					JOptionPane.showMessageDialog(null,"CADASTRO REALIZADO COM SUCESSO", "CADASTRO",JOptionPane.PLAIN_MESSAGE);

					dispose();				}	
			
			
			
			}
		});
		
		//-----------------------------------------------
		
	}
}
