package Employees;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import MarketPlace.Pessoa;

public class Employee extends Pessoa {

    //============= ATRIBUTOS =============

    public static Boolean permission = false;
    String arquivo = "SaveDataEmployee.txt";//NOME DO MEU ARQUIVO TEXTO
    private Double Salar;//ATRIBUTO SAL�RIO
    private String Office;//ATRIBUTO CARGO
    private String CodFun;//ATRIBUTO C�DIGO

	
    //--------------------------------------


    //========== GETTERS E SETTERS =========

    public Employee() {
        super();

    }

    public Employee(String name, String cPF, String phone, String adress, String sex, String bornDate, int idade, String rG, String cep, double salar, String office, String codfun) {

        super(name, cPF, phone, adress, sex, bornDate, idade, rG, cep);

        this.setSalar(salar);
        this.setOffice(office);
        this.setCodFun(codfun);

    }

    public Double getSalar() {
        return Salar;
    }

    public void setSalar(Double salar) {
        Salar = salar;
    }

    public String getOffice() {
        return Office;
    }

    public void setOffice(String office) {
        Office = office;
    }

    //============= CONSTRUTORES ================

    public String getCodFun() {
        return CodFun;
    }

    public void setCodFun(String codFun) {
        CodFun = codFun;
    }

    //---------------------------------------------

    @Override
    public void exibirDados() {
        super.exibirDados();
        System.out.println("Sal�rio = " + this.getSalar());
        System.out.println("Cargo = " + this.getOffice());
        System.out.println("C�digo do funcion�rio = " + this.getCodFun());
    }


    public void gravar() throws IOException {

        String linha;
        FileWriter escreverF = new FileWriter(arquivo, true);
        PrintWriter escreverL = new PrintWriter(escreverF);

        linha = String.format("%-1s;%-1s;%-1s;%-1s;%-1s;%-1s;%-1s;%-1s;%1.2f;%-1s;%-1s", this.getName(), this.getCPF(), this.getPhone(), this.getAdress(), this.getSex(), this.getBornDate(), this.getRG(), this.getCEP(), this.getSalar(), this.getCodFun(), this.getOffice());

        escreverL.append(linha);
        escreverL.println(" ");
        escreverL.close();
    }


    //M�TODO QUE PEGA AS INFORMA��ES DO ARQUIVO.TXT
    public ArrayList<String> pegarNome() throws IOException {

        String linha;//VARI�VEL DO TIPO STRING
        ArrayList<String> TUDO = new ArrayList<String>();//ARRAYLIS DE OBJETOS STRING
        FileReader arquivoFisico = new FileReader("SaveDataEmployee.txt");//ABRIR ARQUIVO TEXTO
        BufferedReader arquivoLogico = new BufferedReader(arquivoFisico);//PEGAR AS INFORMA��ES DO ARQUIVO TEXTO
        linha = arquivoLogico.readLine();//LER UMA LINHA DO ARQUIVO TEXT

        while (linha != null) {//ENQUANTO PARA VER SE A LINHA N�O EST� VAZIA

            String[] dadosDaLinha = linha.split("\\;");//CRIANDO UM ARRAY DE STRING PRA RECEBER CADA LINHA DO ARQUIVO TEXTO
            TUDO.add(dadosDaLinha[0]);//ADICIONANDO O  ARRAY DE STRINGS NO ARRAYLIST DE OBJETOS STRING
            linha = arquivoLogico.readLine();//LENDO OUTRA LINHA
            permission = true;

        }

        arquivoLogico.close();//FECHANDO O ARQUIVO TEXTO
        return TUDO;//RETORNANDO OS DADOS

    }//FECHAR PEGAR NOMES


    public ArrayList<String> pegarCPF() throws IOException {

        String linha;//VARI�VEL DO TIPO STRING
        ArrayList<String> TUDO = new ArrayList<String>();//ARRAYLIS DE OBJETOS STRING
        FileReader arquivoFisico = new FileReader("SaveDataEmployee.txt");//ABRIR ARQUIVO TEXTO
        BufferedReader arquivoLogico = new BufferedReader(arquivoFisico);//PEGAR AS INFORMA��ES DO ARQUIVO TEXTO
        linha = arquivoLogico.readLine();//LER UMA LINHA DO ARQUIVO TEXT

        while (linha != null) {//ENQUANTO PARA VER SE A LINHA N�O EST� VAZIA

            String[] dadosDaLinha = linha.split("\\;");//CRIANDO UM ARRAY DE STRING PRA RECEBER CADA LINHA DO ARQUIVO TEXTO
            TUDO.add(dadosDaLinha[1]);//ADICIONANDO O  ARRAY DE STRINGS NO ARRAYLIST DE OBJETOS STRING
            linha = arquivoLogico.readLine();//LENDO OUTRA LINHA
            permission = true;

        }

        arquivoLogico.close();//FECHANDO O ARQUIVO TEXTO
        return TUDO;//RETORNANDO OS DADOS


    }//FECHAR PEGAR CPF


    public ArrayList<String> pegarTelefone() throws IOException {

        String linha;//VARI�VEL DO TIPO STRING
        ArrayList<String> TUDO = new ArrayList<String>();//ARRAYLIS DE OBJETOS STRING
        FileReader arquivoFisico = new FileReader("SaveDataEmployee.txt");//ABRIR ARQUIVO TEXTO
        BufferedReader arquivoLogico = new BufferedReader(arquivoFisico);//PEGAR AS INFORMA��ES DO ARQUIVO TEXTO
        linha = arquivoLogico.readLine();//LER UMA LINHA DO ARQUIVO TEXT

        while (linha != null) {//ENQUANTO PARA VER SE A LINHA N�O EST� VAZIA

            String[] dadosDaLinha = linha.split("\\;");//CRIANDO UM ARRAY DE STRING PRA RECEBER CADA LINHA DO ARQUIVO TEXTO
            TUDO.add(dadosDaLinha[2]);//ADICIONANDO O  ARRAY DE STRINGS NO ARRAYLIST DE OBJETOS STRING
            linha = arquivoLogico.readLine();//LENDO OUTRA LINHA
            permission = true;

        }

        arquivoLogico.close();//FECHANDO O ARQUIVO TEXTO
        return TUDO;//RETORNANDO OS DADOS


    }

    public ArrayList<String> pegarEndereco() throws IOException {

        String linha;//VARI�VEL DO TIPO STRING
        ArrayList<String> TUDO = new ArrayList<String>();//ARRAYLIS DE OBJETOS STRING
        FileReader arquivoFisico = new FileReader("SaveDataEmployee.txt");//ABRIR ARQUIVO TEXTO
        BufferedReader arquivoLogico = new BufferedReader(arquivoFisico);//PEGAR AS INFORMA��ES DO ARQUIVO TEXTO
        linha = arquivoLogico.readLine();//LER UMA LINHA DO ARQUIVO TEXT

        while (linha != null) {//ENQUANTO PARA VER SE A LINHA N�O EST� VAZIA

            String[] dadosDaLinha = linha.split("\\;");//CRIANDO UM ARRAY DE STRING PRA RECEBER CADA LINHA DO ARQUIVO TEXTO
            TUDO.add(dadosDaLinha[3]);//ADICIONANDO O  ARRAY DE STRINGS NO ARRAYLIST DE OBJETOS STRING
            linha = arquivoLogico.readLine();//LENDO OUTRA LINHA
            permission = true;

        }

        arquivoLogico.close();//FECHANDO O ARQUIVO TEXTO
        return TUDO;//RETORNANDO OS DADOS


    }    //FECHAR PEGAR ENDERECO


    public ArrayList<String> pegarSexo() throws IOException {

        String linha;//VARI�VEL DO TIPO STRING
        ArrayList<String> TUDO = new ArrayList<String>();//ARRAYLIS DE OBJETOS STRING
        FileReader arquivoFisico = new FileReader("SaveDataEmployee.txt");//ABRIR ARQUIVO TEXTO
        BufferedReader arquivoLogico = new BufferedReader(arquivoFisico);//PEGAR AS INFORMA��ES DO ARQUIVO TEXTO
        linha = arquivoLogico.readLine();//LER UMA LINHA DO ARQUIVO TEXT

        while (linha != null) {//ENQUANTO PARA VER SE A LINHA N�O EST� VAZIA

            String[] dadosDaLinha = linha.split("\\;");//CRIANDO UM ARRAY DE STRING PRA RECEBER CADA LINHA DO ARQUIVO TEXTO
            TUDO.add(dadosDaLinha[4]);//ADICIONANDO O  ARRAY DE STRINGS NO ARRAYLIST DE OBJETOS STRING
            linha = arquivoLogico.readLine();//LENDO OUTRA LINHA
            permission = true;

        }

        arquivoLogico.close();//FECHANDO O ARQUIVO TEXTO
        return TUDO;//RETORNANDO OS DADOS


    }//FECHAR PEGAR SEXO	


    public ArrayList<String> pegarDataNascimento() throws IOException {

        String linha;//VARI�VEL DO TIPO STRING
        ArrayList<String> TUDO = new ArrayList<String>();//ARRAYLIS DE OBJETOS STRING
        FileReader arquivoFisico = new FileReader("SaveDataEmployee.txt");//ABRIR ARQUIVO TEXTO
        BufferedReader arquivoLogico = new BufferedReader(arquivoFisico);//PEGAR AS INFORMA��ES DO ARQUIVO TEXTO
        linha = arquivoLogico.readLine();//LER UMA LINHA DO ARQUIVO TEXT

        while (linha != null) {//ENQUANTO PARA VER SE A LINHA N�O EST� VAZIA

            String[] dadosDaLinha = linha.split("\\;");//CRIANDO UM ARRAY DE STRING PRA RECEBER CADA LINHA DO ARQUIVO TEXTO
            TUDO.add(dadosDaLinha[5]);//ADICIONANDO O  ARRAY DE STRINGS NO ARRAYLIST DE OBJETOS STRING
            linha = arquivoLogico.readLine();//LENDO OUTRA LINHA
            permission = true;

        }

        arquivoLogico.close();//FECHANDO O ARQUIVO TEXTO
        return TUDO;//RETORNANDO OS DADOS


    }//FECHAR PEGAR DATA DE NASCIMENTO	


    public ArrayList<String> pegarRG() throws IOException {

        String linha;//VARI�VEL DO TIPO STRING
        ArrayList<String> TUDO = new ArrayList<String>();//ARRAYLIS DE OBJETOS STRING
        FileReader arquivoFisico = new FileReader("SaveDataEmployee.txt");//ABRIR ARQUIVO TEXTO
        BufferedReader arquivoLogico = new BufferedReader(arquivoFisico);//PEGAR AS INFORMA��ES DO ARQUIVO TEXTO
        linha = arquivoLogico.readLine();//LER UMA LINHA DO ARQUIVO TEXT

        while (linha != null) {//ENQUANTO PARA VER SE A LINHA N�O EST� VAZIA

            String[] dadosDaLinha = linha.split("\\;");//CRIANDO UM ARRAY DE STRING PRA RECEBER CADA LINHA DO ARQUIVO TEXTO
            TUDO.add(dadosDaLinha[6]);//ADICIONANDO O  ARRAY DE STRINGS NO ARRAYLIST DE OBJETOS STRING
            linha = arquivoLogico.readLine();//LENDO OUTRA LINHA
            permission = true;

        }

        arquivoLogico.close();//FECHANDO O ARQUIVO TEXTO
        return TUDO;//RETORNANDO OS DADOS


    }//FECHAR PEGAR RG


    public ArrayList<String> pegarCEP() throws IOException {

        String linha;//VARI�VEL DO TIPO STRING
        ArrayList<String> TUDO = new ArrayList<String>();//ARRAYLIS DE OBJETOS STRING
        FileReader arquivoFisico = new FileReader("SaveDataEmployee.txt");//ABRIR ARQUIVO TEXTO
        BufferedReader arquivoLogico = new BufferedReader(arquivoFisico);//PEGAR AS INFORMA��ES DO ARQUIVO TEXTO
        linha = arquivoLogico.readLine();//LER UMA LINHA DO ARQUIVO TEXT

        while (linha != null) {//ENQUANTO PARA VER SE A LINHA N�O EST� VAZIA

            String[] dadosDaLinha = linha.split("\\;");//CRIANDO UM ARRAY DE STRING PRA RECEBER CADA LINHA DO ARQUIVO TEXTO
            TUDO.add(dadosDaLinha[7]);//ADICIONANDO O  ARRAY DE STRINGS NO ARRAYLIST DE OBJETOS STRING
            linha = arquivoLogico.readLine();//LENDO OUTRA LINHA
            permission = true;

        }

        arquivoLogico.close();//FECHANDO O ARQUIVO TEXTO
        return TUDO;//RETORNANDO OS DADOS
    }//FECHAR PEGAR CEP

    public ArrayList<String> pegarSalar() throws IOException {

        String linha;//VARI�VEL DO TIPO STRING
        ArrayList<String> TUDO = new ArrayList<String>();//ARRAYLIS DE OBJETOS STRING
        FileReader arquivoFisico = new FileReader("SaveDataEmployee.txt");//ABRIR ARQUIVO TEXTO
        BufferedReader arquivoLogico = new BufferedReader(arquivoFisico);//PEGAR AS INFORMA��ES DO ARQUIVO TEXTO
        linha = arquivoLogico.readLine();//LER UMA LINHA DO ARQUIVO TEXT

        while (linha != null) {//ENQUANTO PARA VER SE A LINHA N�O EST� VAZIA

            String[] dadosDaLinha = linha.split("\\;");//CRIANDO UM ARRAY DE STRING PRA RECEBER CADA LINHA DO ARQUIVO TEXTO
            TUDO.add(dadosDaLinha[8]);//ADICIONANDO O  ARRAY DE STRINGS NO ARRAYLIST DE OBJETOS STRING
            linha = arquivoLogico.readLine();//LENDO OUTRA LINHA
            permission = true;

        }

        arquivoLogico.close();//FECHANDO O ARQUIVO TEXTO
        return TUDO;//RETORNANDO OS DADOS


    }//FECHAR PEGAR SALAR


    public ArrayList<String> pegarCod() throws IOException {

        String linha;//VARI�VEL DO TIPO STRING
        ArrayList<String> TUDO = new ArrayList<String>();//ARRAYLIS DE OBJETOS STRING
        FileReader arquivoFisico = new FileReader("SaveDataEmployee.txt");//ABRIR ARQUIVO TEXTO
        BufferedReader arquivoLogico = new BufferedReader(arquivoFisico);//PEGAR AS INFORMA��ES DO ARQUIVO TEXTO
        linha = arquivoLogico.readLine();//LER UMA LINHA DO ARQUIVO TEXT

        while (linha != null) {//ENQUANTO PARA VER SE A LINHA N�O EST� VAZIA

            String[] dadosDaLinha = linha.split("\\;");//CRIANDO UM ARRAY DE STRING PRA RECEBER CADA LINHA DO ARQUIVO TEXTO
            TUDO.add(dadosDaLinha[9]);//ADICIONANDO O  ARRAY DE STRINGS NO ARRAYLIST DE OBJETOS STRING
            linha = arquivoLogico.readLine();//LENDO OUTRA LINHA
            permission = true;

        }

        arquivoLogico.close();//FECHANDO O ARQUIVO TEXTO
        return TUDO;//RETORNANDO OS DADOS

    }//FECHAR PEGAR COD


    public ArrayList<String> pegarCargo() throws IOException {

        String linha;//VARI�VEL DO TIPO STRING
        ArrayList<String> TUDO = new ArrayList<String>();//ARRAYLIS DE OBJETOS STRING
        FileReader arquivoFisico = new FileReader("SaveDataEmployee.txt");//ABRIR ARQUIVO TEXTO
        BufferedReader arquivoLogico = new BufferedReader(arquivoFisico);//PEGAR AS INFORMA��ES DO ARQUIVO TEXTO
        linha = arquivoLogico.readLine();//LER UMA LINHA DO ARQUIVO TEXT

        while (linha != null) {//ENQUANTO PARA VER SE A LINHA N�O EST� VAZIA

            String[] dadosDaLinha = linha.split("\\;");//CRIANDO UM ARRAY DE STRING PRA RECEBER CADA LINHA DO ARQUIVO TEXTO
            TUDO.add(dadosDaLinha[10]);//ADICIONANDO O  ARRAY DE STRINGS NO ARRAYLIST DE OBJETOS STRING
            linha = arquivoLogico.readLine();//LENDO OUTRA LINHA
            permission = true;

        }

        arquivoLogico.close();//FECHANDO O ARQUIVO TEXTO
        return TUDO;//RETORNANDO OS DADOS

    }//FECHAR PEGAR COD


    //---------------------------------------------


}// <------ FIM DO PROGRAMA