package br.com.adailtonskywalker.marketplace.views;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainScreen extends JFrame {

    public MainScreen() {
        setTitle("TELA PRINCIPAL");
        setForeground(Color.GRAY);

        Date data = new Date();
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        String finalDate = formatador.format(data);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 870, 671);
        setLocationRelativeTo(null);
        JPanel contentPane = new JPanel();
        contentPane.setBackground(new Color(153, 204, 255));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnNewButton = new JButton("VENDER");
        btnNewButton.setBackground(UIManager.getColor("Button.background"));
        btnNewButton.setBounds(300, 316, 255, 75);
        btnNewButton.setFont(new Font("Comic Sans MS", Font.BOLD, 34));
        contentPane.add(btnNewButton);

        btnNewButton.addActionListener(e -> {
            try {
                new Sales().setVisible(true);
            } catch (Exception ignored) {}
        });

        JMenuBar menuBar = new JMenuBar();
        menuBar.setBounds(0, 0, 870, 37);
        contentPane.add(menuBar);
        menuBar.setForeground(Color.WHITE);
        menuBar.setBackground(Color.WHITE);

        JMenu mnCadastro = new JMenu("CLIENTE\r\n");
        menuBar.add(mnCadastro);

        JMenuItem MenuCad = new JMenuItem("CADASTRAR");
        mnCadastro.add(MenuCad);

        MenuCad.addActionListener(e -> {
            try {
                new ClientRegistration().setVisible(true);
            } catch (Exception ignored) {}
        });

        JMenuItem MenuPes = new JMenuItem("PESQUISAR");
        mnCadastro.add(MenuPes);
        MenuPes.addActionListener(e -> {
            try {
                new ClientConsult().setVisible(true);
            } catch (Exception ignored) {}
        });

        JMenu mnProdutos = new JMenu("PRODUTOS");
        menuBar.add(mnProdutos);

        JMenuItem MenuPCad = new JMenuItem("CADASTRAR");
        mnProdutos.add(MenuPCad);
        MenuPCad.addActionListener(e -> {
            try {
                new Product_Registration().setVisible(true);
            } catch (Exception ignored) {}
        });

        JMenuItem MenuPpes = new JMenuItem("PESQUISAR");
        mnProdutos.add(MenuPpes);
        MenuPpes.addActionListener(e -> {
            try {
                new Product_Consult().setVisible(true);
            } catch (Exception ignored) {}
        });

        JMenu mnFuncionario = new JMenu("FUNCIONÁRIO");
        menuBar.add(mnFuncionario);

        JMenuItem mntmCadastrar = new JMenuItem("CADASTRAR");
        mnFuncionario.add(mntmCadastrar);
        mntmCadastrar.addActionListener(e -> {
            try {
                new Employee_Registration().setVisible(true);
            } catch (Exception ignored) {}
        });

        JMenuItem mntmPesquisar = new JMenuItem("PESQUISAR");
        mntmPesquisar.addActionListener(e -> {
            try {
                new Employee_Consult().setVisible(true);
            } catch (Exception ignored) {}
        });
        mnFuncionario.add(mntmPesquisar);

        JLabel lblBemvindo = new JLabel("BEM-VINDO");
        lblBemvindo.setForeground(Color.WHITE);
        lblBemvindo.setFont(new Font("Comic Sans MS", Font.BOLD, 100));
        lblBemvindo.setBounds(150, 194, 2000, 91);
        contentPane.add(lblBemvindo);

        JLabel label_2 = new JLabel("");
        label_2.setBackground(Color.WHITE);
        label_2.setBounds(225, 271, 486, 14);
        contentPane.add(label_2);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(Color.WHITE);
        panel_1.setBounds(0, 634, 870, 37);
        contentPane.add(panel_1);
        panel_1.setLayout(null);

        JLabel lblSystemDevelopedBy = new JLabel("System Developed by Adailton Moura da Silva and Bruno Silva Albuquerque");
        lblSystemDevelopedBy.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        lblSystemDevelopedBy.setHorizontalAlignment(SwingConstants.CENTER);
        lblSystemDevelopedBy.setBounds(10, 11, 602, 15);
        panel_1.add(lblSystemDevelopedBy);

        JLabel data1 = new JLabel(finalDate);
        data1.setHorizontalAlignment(SwingConstants.RIGHT);
        data1.setBounds(620, 1, 213, 37);
        panel_1.add(data1);
        data1.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));

        JLabel label_1 = new JLabel("");
        label_1.setBounds(654, 649, 46, 14);
        contentPane.add(label_1);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                 new MainScreen().setVisible(true);
            } catch (Exception ignored) {}
        });
    }
}