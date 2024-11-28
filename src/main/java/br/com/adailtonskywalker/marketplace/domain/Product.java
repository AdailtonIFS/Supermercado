package br.com.adailtonskywalker.marketplace.domain;

import lombok.Data;

import java.io.*;
import java.util.ArrayList;

@Data
public class Product {
    public static Boolean permission = false;
    String arquivo = "SaveDataProducts.txt";
    String saveDataSales = "SaveDataSales";
    private String name;
    private double price;
    private String code;
    private int quantity;
    private String description;
    private int qStock;
    private String type;

    public void gravar() throws IOException {
        String linha;
        FileWriter escreverF = new FileWriter(arquivo, true);
        PrintWriter escreverL = new PrintWriter(escreverF);

        linha = String.format("%-1s;%1.2f;%-1s;%-1s;%-1d;%-1s", getName(), getPrice(), getCode(), getDescription(), getQStock(), getType());

        escreverL.append(linha);
        escreverL.println(" ");
        escreverL.close();
    }

    public void gravarDadosVenda(String dado) throws IOException {
        FileWriter escreverF = new FileWriter(saveDataSales, true);
        PrintWriter escreverL = new PrintWriter(escreverF);

        escreverL.append(dado);
        escreverL.println(" ");
        escreverL.close();
    }

    public ArrayList<String> pegarNome() throws IOException {
        String linha;
        ArrayList<String> TUDO = new ArrayList<>();
        FileReader arquivoFisico = new FileReader("SaveDataProducts.txt");
        BufferedReader arquivoLogico = new BufferedReader(arquivoFisico);
        linha = arquivoLogico.readLine();

        while (linha != null) {
            String[] dadosDaLinha = linha.split(";");
            TUDO.add(dadosDaLinha[0]);
            linha = arquivoLogico.readLine();
            permission = true;
        }

        arquivoLogico.close();
        return TUDO;
    }

    public ArrayList<String> pegarPreco() throws IOException {
        String linha;
        ArrayList<String> TUDO = new ArrayList<>();
        FileReader arquivoFisico = new FileReader("SaveDataProducts.txt");
        BufferedReader arquivoLogico = new BufferedReader(arquivoFisico);
        linha = arquivoLogico.readLine();

        while (linha != null) {
            String[] dadosDaLinha = linha.split(";");
            TUDO.add(dadosDaLinha[1]);
            linha = arquivoLogico.readLine();
            permission = true;
        }

        arquivoLogico.close();
        return TUDO;
    }

    public ArrayList<String> pegarCodigo() throws IOException {
        String linha;
        ArrayList<String> TUDO = new ArrayList<>();
        FileReader arquivoFisico = new FileReader("SaveDataProducts.txt");
        BufferedReader arquivoLogico = new BufferedReader(arquivoFisico);
        linha = arquivoLogico.readLine();

        while (linha != null) {
            String[] dadosDaLinha = linha.split(";");
            TUDO.add(dadosDaLinha[2]);
            linha = arquivoLogico.readLine();
            permission = true;
        }

        arquivoLogico.close();
        return TUDO;
    }

    public ArrayList<String> pegarDescricao() throws IOException {
        String linha;
        ArrayList<String> TUDO = new ArrayList<>();
        FileReader arquivoFisico = new FileReader("SaveDataProducts.txt");
        BufferedReader arquivoLogico = new BufferedReader(arquivoFisico);
        linha = arquivoLogico.readLine();

        while (linha != null) {
            String[] dadosDaLinha = linha.split(";");
            TUDO.add(dadosDaLinha[3]);
            linha = arquivoLogico.readLine();
            permission = true;
        }

        arquivoLogico.close();
        return TUDO;
    }

    public ArrayList<String> pegarEstoque() throws IOException {
        String linha;
        ArrayList<String> TUDO = new ArrayList<>();
        FileReader arquivoFisico = new FileReader("SaveDataProducts.txt");
        BufferedReader arquivoLogico = new BufferedReader(arquivoFisico);
        linha = arquivoLogico.readLine();

        while (linha != null) {
            String[] dadosDaLinha = linha.split(";");
            TUDO.add(dadosDaLinha[4]);
            linha = arquivoLogico.readLine();
            permission = true;
        }

        arquivoLogico.close();
        return TUDO;
    }


    public ArrayList<String> pegarTipo() throws IOException {
        String linha;
        ArrayList<String> TUDO = new ArrayList<>();
        FileReader arquivoFisico = new FileReader("SaveDataProducts.txt");
        BufferedReader arquivoLogico = new BufferedReader(arquivoFisico);
        linha = arquivoLogico.readLine();

        while (linha != null) {
            String[] dadosDaLinha = linha.split(";");
            TUDO.add(dadosDaLinha[5]);
            linha = arquivoLogico.readLine();
            permission = true;
        }

        arquivoLogico.close();
        return TUDO;
    }
}
