package Cliente;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import MarketPlace.Pessoa;

public class Client extends Pessoa {
		
			//============= ATRIBUTOS =============
	
			private String Email;//ATRIBUTO EMAIL
			private String CodCl;//ATRIBUTO CÓDIGO
			String arquivo = "Arquivo.txt";//NOME DO MEU ARQUIVO.TXT
			public static Boolean permission = false;
			//--------------------------------------
	
			
			//========== GETTERS E SETTERS =========

			
			//GETTER DO ATRIBUTO E-MAIL
			public String getEmail() {
				return Email;
			}
			//SETTER DO ATRIBUTO E-MAIL
			public void setEmail(String email) {
				Email = email;
			}
			//GETTER DO ATRIBUTO CÓDIGO
			public String getCodCl() {
				return CodCl;
			}
			//SETTER DO ATRIBUTO CÓDIGO
			public void setCodCl(String codCl) {
				CodCl = codCl;
			}

			
			//--------------------------------------

			//============= CONSTRUTORES ================

			
			//CONSTRUTOR DA CLASSE
			public Client() {
				super();
			}
			//CONSTRUTOR DA SUPER CLASSE
			public Client(String name, String cPF, String phone, String adress, String sex, String bornDate, int idade,
					String rG, String cep, String email, String codCl) {
				
				super(name, cPF, phone, adress, sex, bornDate, idade, rG,cep);
			
				this.setEmail(email);
				this.setCodCl(codCl);
				
			}
			
			@Override
			public void exibirDados() {
				super.exibirDados();
				System.out.println("Email = "+this.getEmail());
				System.out.println("Código de cliente = "+this.getCodCl());

		
			}
			
		
			//---------------------------------------------

			//======= MÉTODOS E FUNÇÕES DA CLASSE =========

			
			//METODO QUE GRAVA NO ARQUIVO.TXT
			public void gravar() throws IOException{
				
				String linha;//VARIAVEL DO TIPO STRING
				FileWriter escreverF = new FileWriter(arquivo, true);//ABRIR ARQUIVO.TXT
				PrintWriter escreverL = new PrintWriter(escreverF);//GRAVAR DADOS NO ARQUIVO.TXT
				
				linha = String.format("%-1s; %-1s; %-1s; %-1s; %-1s; %-1s; %-1s; %-1s; %-1s; %-1s",this.getName(),this.getCPF(),this.getPhone(),//STRINGFORMAT
						this.getAdress(),this.getSex(),this.getBornDate(),this.getRG(),this.getCEP(),this.getEmail(),this.getCodCl());
				
				escreverL.append(linha);//ESCREVENDO NO ARQUIVO.TXT
				escreverL.println(" ");
				escreverL.close();//FECHAR ARQUIVO.TXT
			}//
			//MÉTODO QUE PEGA AS INFORMAÇÕES DO ARQUIVO.TXT
			
			public ArrayList<String> pegarNome() throws IOException {
				
				String linha;//VARIÁVEL DO TIPO STRING
				ArrayList<String> TUDO = new ArrayList<String>();//ARRAYLIS DE OBJETOS STRING
				FileReader arquivoFisico = new FileReader("Arquivo.txt");//ABRIR ARQUIVO TEXTO
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
			public ArrayList<String> pegarCPF() throws IOException {
				
				String linha;//VARIÁVEL DO TIPO STRING
				ArrayList<String> TUDO = new ArrayList<String>();//ARRAYLIS DE OBJETOS STRING
				FileReader arquivoFisico = new FileReader("Arquivo.txt");//ABRIR ARQUIVO TEXTO
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
			public ArrayList<String> pegarTelefone() throws IOException {
				
				String linha;//VARIÁVEL DO TIPO STRING
				ArrayList<String> TUDO = new ArrayList<String>();//ARRAYLIS DE OBJETOS STRING
				FileReader arquivoFisico = new FileReader("Arquivo.txt");//ABRIR ARQUIVO TEXTO
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
			public ArrayList<String> pegarEndereco() throws IOException {
				
				String linha;//VARIÁVEL DO TIPO STRING
				ArrayList<String> TUDO = new ArrayList<String>();//ARRAYLIS DE OBJETOS STRING
				FileReader arquivoFisico = new FileReader("Arquivo.txt");//ABRIR ARQUIVO TEXTO
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
			public ArrayList<String> pegarSexo() throws IOException {
				
				String linha;//VARIÁVEL DO TIPO STRING
				ArrayList<String> TUDO = new ArrayList<String>();//ARRAYLIS DE OBJETOS STRING
				FileReader arquivoFisico = new FileReader("Arquivo.txt");//ABRIR ARQUIVO TEXTO
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
			public ArrayList<String> pegarDataNascimento() throws IOException {
				
				String linha;//VARIÁVEL DO TIPO STRING
				ArrayList<String> TUDO = new ArrayList<String>();//ARRAYLIS DE OBJETOS STRING
				FileReader arquivoFisico = new FileReader("Arquivo.txt");//ABRIR ARQUIVO TEXTO
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
			public ArrayList<String> pegarRG() throws IOException {
				
				String linha;//VARIÁVEL DO TIPO STRING
				ArrayList<String> TUDO = new ArrayList<String>();//ARRAYLIS DE OBJETOS STRING
				FileReader arquivoFisico = new FileReader("Arquivo.txt");//ABRIR ARQUIVO TEXTO
				BufferedReader arquivoLogico = new BufferedReader(arquivoFisico);//PEGAR AS INFORMAÇÕES DO ARQUIVO TEXTO
				linha = arquivoLogico.readLine();//LER UMA LINHA DO ARQUIVO TEXT
				
				while (linha != null) {//ENQUANTO PARA VER SE A LINHA NÃO ESTÁ VAZIA
				
					String[] dadosDaLinha = linha.split("\\;");//CRIANDO UM ARRAY DE STRING PRA RECEBER CADA LINHA DO ARQUIVO TEXTO
					TUDO.add(dadosDaLinha[6]);//ADICIONANDO O  ARRAY DE STRINGS NO ARRAYLIST DE OBJETOS STRING
					linha = arquivoLogico.readLine();//LENDO OUTRA LINHA
					permission = true;

				}
				
				arquivoLogico.close();//FECHANDO O ARQUIVO TEXTO
				return TUDO;//RETORNANDO OS DADOS
				

			}
			
			public ArrayList<String> pegarCEP() throws IOException {
				
				String linha;//VARIÁVEL DO TIPO STRING
				ArrayList<String> TUDO = new ArrayList<String>();//ARRAYLIS DE OBJETOS STRING
				FileReader arquivoFisico = new FileReader("Arquivo.txt");//ABRIR ARQUIVO TEXTO
				BufferedReader arquivoLogico = new BufferedReader(arquivoFisico);//PEGAR AS INFORMAÇÕES DO ARQUIVO TEXTO
				linha = arquivoLogico.readLine();//LER UMA LINHA DO ARQUIVO TEXT
				
				while (linha != null) {//ENQUANTO PARA VER SE A LINHA NÃO ESTÁ VAZIA
				
					String[] dadosDaLinha = linha.split("\\;");//CRIANDO UM ARRAY DE STRING PRA RECEBER CADA LINHA DO ARQUIVO TEXTO
					TUDO.add(dadosDaLinha[7]);//ADICIONANDO O  ARRAY DE STRINGS NO ARRAYLIST DE OBJETOS STRING
					linha = arquivoLogico.readLine();//LENDO OUTRA LINHA
					permission = true;

				}
				
				arquivoLogico.close();//FECHANDO O ARQUIVO TEXTO
				return TUDO;//RETORNANDO OS DADOS
				}
			public ArrayList<String> pegarEmail() throws IOException {
				
				String linha;//VARIÁVEL DO TIPO STRING
				ArrayList<String> TUDO = new ArrayList<String>();//ARRAYLIS DE OBJETOS STRING
				FileReader arquivoFisico = new FileReader("Arquivo.txt");//ABRIR ARQUIVO TEXTO
				BufferedReader arquivoLogico = new BufferedReader(arquivoFisico);//PEGAR AS INFORMAÇÕES DO ARQUIVO TEXTO
				linha = arquivoLogico.readLine();//LER UMA LINHA DO ARQUIVO TEXT
				
				while (linha != null) {//ENQUANTO PARA VER SE A LINHA NÃO ESTÁ VAZIA
				
					String[] dadosDaLinha = linha.split("\\;");//CRIANDO UM ARRAY DE STRING PRA RECEBER CADA LINHA DO ARQUIVO TEXTO
					TUDO.add(dadosDaLinha[8]);//ADICIONANDO O  ARRAY DE STRINGS NO ARRAYLIST DE OBJETOS STRING
					linha = arquivoLogico.readLine();//LENDO OUTRA LINHA
					permission = true;

				}
				
				arquivoLogico.close();//FECHANDO O ARQUIVO TEXTO
				return TUDO;//RETORNANDO OS DADOS
				

			}	
			public ArrayList<String> pegarCod() throws IOException {
				
				String linha;//VARIÁVEL DO TIPO STRING
				ArrayList<String> TUDO = new ArrayList<String>();//ARRAYLIS DE OBJETOS STRING
				FileReader arquivoFisico = new FileReader("Arquivo.txt");//ABRIR ARQUIVO TEXTO
				BufferedReader arquivoLogico = new BufferedReader(arquivoFisico);//PEGAR AS INFORMAÇÕES DO ARQUIVO TEXTO
				linha = arquivoLogico.readLine();//LER UMA LINHA DO ARQUIVO TEXT
				
				while (linha != null) {//ENQUANTO PARA VER SE A LINHA NÃO ESTÁ VAZIA
				
					String[] dadosDaLinha = linha.split("\\;");//CRIANDO UM ARRAY DE STRING PRA RECEBER CADA LINHA DO ARQUIVO TEXTO
					TUDO.add(dadosDaLinha[9]);//ADICIONANDO O  ARRAY DE STRINGS NO ARRAYLIST DE OBJETOS STRING
					linha = arquivoLogico.readLine();//LENDO OUTRA LINHA
					permission = true;
				}
				
				arquivoLogico.close();//FECHANDO O ARQUIVO TEXTO
				return TUDO;//RETORNANDO OS DADOS
				
			}

			
			
			
			
			
			
			
			
} 