package Produto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Product {
	
	//========== ATRIBUTOS DA CLASSE ==========
	
	private String Name;
	private double Price;
	private String CodP;
	private int Quantity;
	private String Description;
	private int QStock;
	private String Types;
	String arquivo = "SaveDataProducts.txt";
	String SaveDataSales = "SaveDataSales";
	public static Boolean permission = false;


	//----------------------------------------
	
	
	//========= GETTERS E SETTERS ===========
	
	public String getName() {
		return Name;
	}
	
	public void setName(String name) {
		Name = name;
	}
	
	public double getPrice() {
		return Price;
	}
	
	public void setPrice(double price) {
		this.Price = price;
	}
	
	public String getCodP() {
		return CodP;
	}
	
	public void setCodP(String codP) {
			this.CodP = codP;
	}
	
	public int getQuantity() {
		return Quantity;
	}
	
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	
	public String getDescription() {
		return Description;
	}
	
	public void setDescription(String description) {
			Description = description;
		}
	
	public int getQStock() {
		return QStock;
	}
	
	public void setQStock(int qStock) {
		QStock = qStock;
	}
	
	public String getTypes() {
		return Types;
	}

	public void setTypes(String types) {
		Types = types; 
		}

	//------------------------------------
	
	
	//========== CONSTRUTORES ==============
	
	public Product(String name, double price, String codP, int quantity, String description, int qStock,String types) {

		Name = name;
		Price = price;
		CodP = codP;
		QStock = qStock;
		Quantity = quantity;
		Description = description;
		Types = types;
		
	}
	
	public Product() {
		
		
	}
	
	
	//---------------------------------------
	public void gravar() throws IOException{
		
		String linha;
		FileWriter escreverF = new FileWriter(arquivo, true);
		PrintWriter escreverL = new PrintWriter(escreverF);
		
		linha = String.format("%-1s;%1.2f;%-1s;%-1s;%-1d;%-1s",this.getName(),this.getPrice(),this.getCodP(),
				this.getDescription(),this.getQStock(),this.getTypes());
		
		escreverL.append(linha);
		escreverL.println(" ");
		escreverL.close();
		
	}
	
	public void gravarDadosVenda(String dado) throws IOException{
		
		String linha = dado;
		FileWriter escreverF = new FileWriter(SaveDataSales, true);
		PrintWriter escreverL = new PrintWriter(escreverF);
		
		escreverL.append(linha);
		escreverL.println(" ");
		escreverL.close();
		
	}
	
	//PEGAR O NOME DO PRODUTO
	public ArrayList<String> pegarNome() throws IOException {
		
		String linha;//VARIÁVEL DO TIPO STRING
		ArrayList<String> TUDO = new ArrayList<String>();//ARRAYLIS DE OBJETOS STRING
		FileReader arquivoFisico = new FileReader("SaveDataProducts.txt");//ABRIR ARQUIVO TEXTO
		BufferedReader arquivoLogico = new BufferedReader(arquivoFisico);//PEGAR AS INFORMAÇÕES DO ARQUIVO TEXTO
		linha = arquivoLogico.readLine();//LER UMA LINHA DO ARQUIVO TEXT
		
		while (linha != null) {//ENQUANTO PARA VER SE A LINHA NÃO ESTÁ VAZIA
		
			String[] dadosDaLinha = linha.split("\\;");//CRIANDO UM ARRAY DE STRING PRA RECEBER CADA LINHA DO ARQUIVO TEXTO
			TUDO.add(dadosDaLinha[0]);//ADICIONANDO O  ARRAY DE STRINGS NO ARRAYLIST DE OBJETOS STRING
			linha = arquivoLogico.readLine();//LENDO OUTRA LINHA
			permission = true;

		}
		
		arquivoLogico.close();//FECHANDO O ARQUIVO TEXTO
		return TUDO;//RETORNANDO OS DADOS
		
		}
	
	//PEGAR O PREÇO DO PRODUTO
	public ArrayList<String> pegarPreco() throws IOException {
		
		String linha;//VARIÁVEL DO TIPO STRING
		ArrayList<String> TUDO = new ArrayList<String>();//ARRAYLIS DE OBJETOS STRING
		FileReader arquivoFisico = new FileReader("SaveDataProducts.txt");//ABRIR ARQUIVO TEXTO
		BufferedReader arquivoLogico = new BufferedReader(arquivoFisico);//PEGAR AS INFORMAÇÕES DO ARQUIVO TEXTO
		linha = arquivoLogico.readLine();//LER UMA LINHA DO ARQUIVO TEXT
		
		while (linha != null) {//ENQUANTO PARA VER SE A LINHA NÃO ESTÁ VAZIA
		
			String[] dadosDaLinha = linha.split("\\;");//CRIANDO UM ARRAY DE STRING PRA RECEBER CADA LINHA DO ARQUIVO TEXTO
			TUDO.add(dadosDaLinha[1]);//ADICIONANDO O  ARRAY DE STRINGS NO ARRAYLIST DE OBJETOS STRING
			linha = arquivoLogico.readLine();//LENDO OUTRA LINHA
			permission = true;

		}
		
		arquivoLogico.close();//FECHANDO O ARQUIVO TEXTO
		return TUDO;//RETORNANDO OS DADOS
		

		}	
	
	//PEGAR O CÓDIGO DO PRODUTO
	public ArrayList<String> pegarCodigo() throws IOException {
		
		String linha;//VARIÁVEL DO TIPO STRING
		ArrayList<String> TUDO = new ArrayList<String>();//ARRAYLIS DE OBJETOS STRING
		FileReader arquivoFisico = new FileReader("SaveDataProducts.txt");//ABRIR ARQUIVO TEXTO
		BufferedReader arquivoLogico = new BufferedReader(arquivoFisico);//PEGAR AS INFORMAÇÕES DO ARQUIVO TEXTO
		linha = arquivoLogico.readLine();//LER UMA LINHA DO ARQUIVO TEXT
		
		while (linha != null) {//ENQUANTO PARA VER SE A LINHA NÃO ESTÁ VAZIA
		
			String[] dadosDaLinha = linha.split("\\;");//CRIANDO UM ARRAY DE STRING PRA RECEBER CADA LINHA DO ARQUIVO TEXTO
			TUDO.add(dadosDaLinha[2]);//ADICIONANDO O  ARRAY DE STRINGS NO ARRAYLIST DE OBJETOS STRING
			linha = arquivoLogico.readLine();//LENDO OUTRA LINHA
			permission = true;

		}
		
		arquivoLogico.close();//FECHANDO O ARQUIVO TEXTO
		return TUDO;//RETORNANDO OS DADOS
		

		}	
	
	//PEGAR A DESCRIÇÃO DO PRODUTO
	public ArrayList<String> pegarDescricao() throws IOException {
		
		String linha;//VARIÁVEL DO TIPO STRING
		ArrayList<String> TUDO = new ArrayList<String>();//ARRAYLIS DE OBJETOS STRING
		FileReader arquivoFisico = new FileReader("SaveDataProducts.txt");//ABRIR ARQUIVO TEXTO
		BufferedReader arquivoLogico = new BufferedReader(arquivoFisico);//PEGAR AS INFORMAÇÕES DO ARQUIVO TEXTO
		linha = arquivoLogico.readLine();//LER UMA LINHA DO ARQUIVO TEXT
		
		while (linha != null) {//ENQUANTO PARA VER SE A LINHA NÃO ESTÁ VAZIA
		
			String[] dadosDaLinha = linha.split("\\;");//CRIANDO UM ARRAY DE STRING PRA RECEBER CADA LINHA DO ARQUIVO TEXTO
			TUDO.add(dadosDaLinha[3]);//ADICIONANDO O  ARRAY DE STRINGS NO ARRAYLIST DE OBJETOS STRING
			linha = arquivoLogico.readLine();//LENDO OUTRA LINHA
			permission = true;

		}
		
		arquivoLogico.close();//FECHANDO O ARQUIVO TEXTO
		return TUDO;//RETORNANDO OS DADOS
		

		}	
	
	//PEGAR A QUANTIDADE DO PRODUTO NO ESTOQUE
	public ArrayList<String> pegarEstoque() throws IOException {
		
		String linha;//VARIÁVEL DO TIPO STRING
		ArrayList<String> TUDO = new ArrayList<String>();//ARRAYLIS DE OBJETOS STRING
		FileReader arquivoFisico = new FileReader("SaveDataProducts.txt");//ABRIR ARQUIVO TEXTO
		BufferedReader arquivoLogico = new BufferedReader(arquivoFisico);//PEGAR AS INFORMAÇÕES DO ARQUIVO TEXTO
		linha = arquivoLogico.readLine();//LER UMA LINHA DO ARQUIVO TEXT
		
		while (linha != null) {//ENQUANTO PARA VER SE A LINHA NÃO ESTÁ VAZIA
		
			String[] dadosDaLinha = linha.split("\\;");//CRIANDO UM ARRAY DE STRING PRA RECEBER CADA LINHA DO ARQUIVO TEXTO
			TUDO.add(dadosDaLinha[4]);//ADICIONANDO O  ARRAY DE STRINGS NO ARRAYLIST DE OBJETOS STRING
			linha = arquivoLogico.readLine();//LENDO OUTRA LINHA
			permission = true;

		}
		
		arquivoLogico.close();//FECHANDO O ARQUIVO TEXTO
		return TUDO;//RETORNANDO OS DADOS
		

		}	
	
	//PEGAR O TIPO DO PRODUTO
	public ArrayList<String> pegarTipo() throws IOException {
		
		String linha;//VARIÁVEL DO TIPO STRING
		ArrayList<String> TUDO = new ArrayList<String>();//ARRAYLIS DE OBJETOS STRING
		FileReader arquivoFisico = new FileReader("SaveDataProducts.txt");//ABRIR ARQUIVO TEXTO
		BufferedReader arquivoLogico = new BufferedReader(arquivoFisico);//PEGAR AS INFORMAÇÕES DO ARQUIVO TEXTO
		linha = arquivoLogico.readLine();//LER UMA LINHA DO ARQUIVO TEXT
		
		while (linha != null) {//ENQUANTO PARA VER SE A LINHA NÃO ESTÁ VAZIA
		
			String[] dadosDaLinha = linha.split("\\;");//CRIANDO UM ARRAY DE STRING PRA RECEBER CADA LINHA DO ARQUIVO TEXTO
			TUDO.add(dadosDaLinha[5]);//ADICIONANDO O  ARRAY DE STRINGS NO ARRAYLIST DE OBJETOS STRING
			linha = arquivoLogico.readLine();//LENDO OUTRA LINHA
			permission = true;

		}
		
		arquivoLogico.close();//FECHANDO O ARQUIVO TEXTO
		return TUDO;//RETORNANDO OS DADOS
		

		}	
	
	
}// <----- FIM DA CLASSE
