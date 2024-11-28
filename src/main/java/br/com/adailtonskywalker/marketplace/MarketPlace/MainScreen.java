package MarketPlace;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Cliente.Client_Consult;
import Cliente.Client_Registration;
import Employees.Employee_Consult;
import Employees.Employee_Registration;
import Produto.Product_Consult;
import Produto.Product_Registration;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;

import javax.swing.JTextField;
import java.awt.Toolkit;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import java.awt.Window.Type;
import javax.swing.UIManager;

public class MainScreen extends JFrame {

	private JPanel contentPane;
	private JTextField Data;

	/**
	 * Launch the application.
	 * 
	 */	


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainScreen frame = new MainScreen();
					frame.setVisible(true);	
					
					} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainScreen() {
		Font dropthegame = null;
		
		try {
			dropthegame = Font.createFont(Font.TRUETYPE_FONT, new File("GROBOLD.ttf")).deriveFont(75f);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("GROBOLD.ttf")));
		} catch(IOException | FontFormatException e){
			
		}
		
		//====================================================================
		setTitle("TELA PRINCIPAL");
		setForeground(Color.GRAY);
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainScreen.class.getResource("/images/home-icon-silhouette.png")));
		
		Date data = new Date();
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
		String finalDate =formatador.format(data);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 870, 710);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 204, 255));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("VENDER");
		btnNewButton.setIcon(new ImageIcon(MainScreen.class.getResource("/images/ic_attach_money_128_28210.png")));
		btnNewButton.setBackground(UIManager.getColor("Button.background"));
		btnNewButton.setBorder(new LineBorder(new Color(153, 204, 0), 5, true));
		btnNewButton.setBounds(341, 316, 255, 75);
		btnNewButton.setFont(new Font("Comic Sans MS", Font.BOLD, 34));
		contentPane.add(btnNewButton);
		
		
	   		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				try {
					Sales frame = new Sales();
					frame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		

		
		
		
		//BARRA PRA ADICIONAR MENUS
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 11, 854, 37);
		contentPane.add(menuBar);
		menuBar.setForeground(Color.WHITE);
		menuBar.setBackground(Color.WHITE);
		
		//ABA DE CADASTRO
		JMenu mnCadastro = new JMenu("CLIENTE\r\n");
		mnCadastro.setIcon(new ImageIcon(MainScreen.class.getResource("/images/User-80_icon-icons.com_57249.png")));
		menuBar.add(mnCadastro);
		
		//ITEM "CADASTRAR" DA ABA
		JMenuItem MenuCad = new JMenuItem("CADASTRAR");
		MenuCad.setIcon(new ImageIcon(MainScreen.class.getResource("/images/Add_User-80_icon-icons.com_57380.png")));
		mnCadastro.add(MenuCad);	
		//INSTANCIANDO PARA ABRIR A NOVA TELA
		MenuCad.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				
		try {
			Client_Registration frame = new Client_Registration();
			frame.setVisible(true);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
				
			}
		});
		
		
		
		
		//consultaMenu
		JMenuItem MenuPes = new JMenuItem("PESQUISAR");
		MenuPes.setIcon(new ImageIcon(MainScreen.class.getResource("/images/Search-80_icon-icons.com_57273.png")));
		mnCadastro.add(MenuPes);
		MenuPes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
				try {
					Client_Consult frame = new Client_Consult();
					frame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		//fecharClientes
		
		
		//produtosMenu
		JMenu mnProdutos = new JMenu("PRODUTOS");
		mnProdutos.setIcon(new ImageIcon(MainScreen.class.getResource("/images/diagram-61_24456.png")));
		menuBar.add(mnProdutos);
		
		//CadastraMenuProdutos
		JMenuItem MenuPCad = new JMenuItem("CADASTRAR");
		MenuPCad.setIcon(new ImageIcon(MainScreen.class.getResource("/images/shopping-cart-add-button_icon-icons.com_56132.png")));
		mnProdutos.add(MenuPCad);
		MenuPCad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Product_Registration frame = new Product_Registration();
					frame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		JMenuItem MenuPpes = new JMenuItem("PESQUISAR");
		MenuPpes.setIcon(new ImageIcon(MainScreen.class.getResource("/images/Search-80_icon-icons.com_57273.png")));
		mnProdutos.add(MenuPpes);
		MenuPpes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					Product_Consult frame = new Product_Consult();
					frame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		
		
		
		//fecharProdutos
		
		//abrirFuncionarios
		
		//Menu De Funcionários
		JMenu mnFuncionario = new JMenu("FUNCION\u00C1RIO");
		mnFuncionario.setIcon(new ImageIcon(MainScreen.class.getResource("/images/3592855-business-man-employee-general-human-member-office-tie_107745.png")));
		menuBar.add(mnFuncionario);
		
		//Menu de Cadastrar Funcionarios
		JMenuItem mntmCadastrar = new JMenuItem("CADASTRAR");
		mntmCadastrar.setIcon(new ImageIcon(MainScreen.class.getResource("/images/3592854-add-user-business-man-employee-general-human-member-office_107767 (2).png")));
		mnFuncionario.add(mntmCadastrar);
		mntmCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Employee_Registration frame = null;
				try {
					frame = new Employee_Registration();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.setVisible(true);
				
			}
		});
		
		JMenuItem mntmPesquisar = new JMenuItem("PESQUISAR");
		mntmPesquisar.setIcon(new ImageIcon(MainScreen.class.getResource("/images/Search-80_icon-icons.com_57273.png")));
		mntmPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Employee_Consult frame = new Employee_Consult();
					frame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		mnFuncionario.add(mntmPesquisar);
		
		JLabel lblBemvindo = new JLabel("BEM-VINDO");
		lblBemvindo.setForeground(Color.WHITE);
		lblBemvindo.setFont(new Font("Comic Sans MS", Font.BOLD, 100));
		lblBemvindo.setBounds(236, 194, 494, 91);
		contentPane.add(lblBemvindo);
		lblBemvindo.setFont(dropthegame);
		
		JLabel label_2 = new JLabel("");
		label_2.setBackground(Color.WHITE);
		label_2.setBorder(new MatteBorder(0, 0, 8, 0, (Color) new Color(255, 255, 255)));
		label_2.setBounds(225, 271, 486, 14);
		contentPane.add(label_2);
		
		JLabel foto = new JLabel("");
		foto.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		foto.setBounds(0, 45, 858, 578);
		contentPane.add(foto);
		foto.setIcon(new ImageIcon(MainScreen.class.getResource("/images/Compartilhada do Lightroom mobile (16).jpg")));
		
		JLabel label = new JLabel("");
		label.setBounds(549, 402, 205, 37);
		contentPane.add(label);
		label.setBorder(new LineBorder(Color.BLACK, 2));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_1.setBounds(0, 634, 642, 37);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblSystemDevelopedBy = new JLabel("System Developed by Adailton Moura da Silva and Bruno Silva Albuquerque");
		lblSystemDevelopedBy.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lblSystemDevelopedBy.setHorizontalAlignment(SwingConstants.CENTER);
		lblSystemDevelopedBy.setBounds(10, 11, 602, 15);
		panel_1.add(lblSystemDevelopedBy);
		
		Data = new JTextField();
		Data.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		Data.setHorizontalAlignment(SwingConstants.RIGHT);
		Data.setBounds(641, 634, 213, 37);
		contentPane.add(Data);
		Data.setBackground(new Color(204, 255, 51));
		Data.setEditable(false);
		Data.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		Data.setColumns(10);
		Data.setText(finalDate);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(654, 649, 46, 14);
		contentPane.add(label_1);
		
		
		

		
		
		

		
	}
}