package br.com.adailtonskywalker.marketplace.domain;

import lombok.Data;

import java.io.*;
import java.util.ArrayList;

@Data
public class Product {
    public static Boolean permission = false;
    String filename = "SaveDataProducts.txt";
    String saveDataSales = "SaveDataSales.txt";
    private String name;
    private double price;
    private String code;
    private int quantity;
    private String description;
    private int qStock;
    private String type;

    public void gravar() throws IOException {
        String linha;
        FileWriter escreverF = new FileWriter(filename, true);
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

    public ArrayList<Product> getProducts() throws IOException {
        String line;
        ArrayList<Product> productData = new ArrayList<>();
        FileReader file = new FileReader(filename);
        BufferedReader logicalFile = new BufferedReader(file);
        line = logicalFile.readLine();

        while (line != null) {
            String[] dadosDaLinha = line.split(";");
            Product product = new Product();
            product.setName(dadosDaLinha[0]);
            product.setPrice(Double.parseDouble(dadosDaLinha[1]));
            product.setCode(dadosDaLinha[2]);
            product.setDescription(dadosDaLinha[3]);
            product.setQStock(Integer.parseInt(dadosDaLinha[4]));
            product.setType(dadosDaLinha[5]);
            productData.add(product);
            line = logicalFile.readLine();
            permission = true;
        }

        logicalFile.close();
        return productData;
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
}
