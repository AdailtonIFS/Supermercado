package MarketPlace;

import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import java.awt.Toolkit;

public class Opening extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	private static Opening frame;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Opening();
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
	public Opening() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Opening.class.getResource("/images/1490129319-rounded09_82169.png")));
		setTitle("SUPERMERCADO");
		Font dropthegame = null;
		
		try {
			dropthegame = Font.createFont(Font.TRUETYPE_FONT, new File("Sketch_Block.ttf")).deriveFont(82f);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Sketch_Block.ttf")));
		} catch(IOException | FontFormatException e){
			
		}
		
		setBackground(Color.GREEN);
		setForeground(Color.GREEN);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 611, 460);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		Button button = new Button("ENTRAR");
		button.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
		button.setBackground(UIManager.getColor("Button.background"));
		button.setForeground(Color.BLACK);
		button.setBounds(221, 250, 152, 36);
		contentPane.add(button);
		
		
		JLabel lblBemVindo = new JLabel("BEM VINDO");
		lblBemVindo.setBackground(Color.WHITE);
		lblBemVindo.setForeground(Color.WHITE);
		lblBemVindo.setHorizontalAlignment(SwingConstants.CENTER);
		lblBemVindo.setFont(new Font("Comic Sans MS", Font.BOLD, 74));
		lblBemVindo.setBounds(0, 104, 599, 105);
		contentPane.add(lblBemVindo);
		lblBemVindo.setFont(dropthegame);
		
		JLabel label_1 = new JLabel("");
		label_1.setForeground(Color.WHITE);
		label_1.setBackground(Color.WHITE);
		label_1.setBorder(new MatteBorder(0, 0, 6, 0, (Color) new Color(255, 255, 255)));
		label_1.setBounds(27, 178, 545, 14);
		contentPane.add(label_1);
		
		JLabel label = new JLabel("");
		label.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		label.setIcon(new ImageIcon(Opening.class.getResource("/images/Compartilhada do Lightroom mobile (18).jpg")));
		label.setBounds(0, 0, 599, 422);
		contentPane.add(label);
		
		//BOTAO
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
						
				button.setEnabled(false);
				JProgressBar progressBar = new JProgressBar();
				progressBar.setStringPainted(true);
				progressBar.setForeground(Color.BLACK);
				progressBar.setBackground(Color.WHITE);
				progressBar.setIndeterminate(true);
				progressBar.setBounds(100, 307, 402, 36);
				contentPane.add(progressBar);
				
				new Thread (){
					
					
					public void run() {
						
						for(int i = 0; i < 101; i++) {
							
							try {
							    sleep(25);
								progressBar.setValue(i);
								
			
							}catch(InterruptedException ex){
							}
								
						}
						
						
						dispose();
						
						MainScreen frame = new MainScreen();
						frame.setVisible(true);
						
					}
				
				}.start();
				
				
			}
		});
		
		
		
		
		
	}
}
