package br.com.adailtonskywalker.marketplace.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.*;
import java.util.ArrayList;

@EqualsAndHashCode(callSuper = true)
@Data
public class Employee extends Pessoa {
    public static Boolean permission = false;
    String arquivo = "SaveDataEmployee.txt";
    private Double salar;
    private String office;
    private String code;

    @Override
    public String toString() {
        return super.toString() + "Sal�rio = " + this.getSalar() + "Cargo = " + this.getOffice() +
                "C�digo do funcion�rio = " + this.getCode();
    }


    public void gravar() throws IOException {
        String linha;
        FileWriter escreverF = new FileWriter(arquivo, true);
        PrintWriter escreverL = new PrintWriter(escreverF);

        linha = String.format("%-1s;%-1s;%-1s;%-1s;%-1s;%-1s;%-1s;%-1s;%1.2f;%-1s;%-1s", getName(), getCpf(), getPhone(),
                getAddress(), getGender(), getBornDate(), getRg(),getCep(), getSalar(),getCode(), getOffice());

        escreverL.append(linha);
        escreverL.println(" ");
        escreverL.close();
    }

    public ArrayList<String> pegarNome() throws IOException {
        String linha;
        ArrayList<String> TUDO = new ArrayList<>();
        FileReader arquivoFisico = new FileReader("SaveDataEmployee.txt");
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

    public ArrayList<String> pegarCPF() throws IOException {
        String linha;
        ArrayList<String> TUDO = new ArrayList<>();
        FileReader arquivoFisico = new FileReader("SaveDataEmployee.txt");
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

    public ArrayList<String> pegarTelefone() throws IOException {
        String linha;
        ArrayList<String> TUDO = new ArrayList<>();
        FileReader arquivoFisico = new FileReader("SaveDataEmployee.txt");
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

    public ArrayList<String> pegarEndereco() throws IOException {
        String linha;
        ArrayList<String> TUDO = new ArrayList<>();
        FileReader arquivoFisico = new FileReader("SaveDataEmployee.txt");
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

    public ArrayList<String> pegarSexo() throws IOException {
        String linha;
        ArrayList<String> TUDO = new ArrayList<>();
        FileReader arquivoFisico = new FileReader("SaveDataEmployee.txt");
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

    public ArrayList<String> pegarDataNascimento() throws IOException {
        String linha;
        ArrayList<String> TUDO = new ArrayList<>();
        FileReader arquivoFisico = new FileReader("SaveDataEmployee.txt");
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

    public ArrayList<String> pegarRG() throws IOException {
        String linha;
        ArrayList<String> TUDO = new ArrayList<>();
        FileReader arquivoFisico = new FileReader("SaveDataEmployee.txt");
        BufferedReader arquivoLogico = new BufferedReader(arquivoFisico);
        linha = arquivoLogico.readLine();

        while (linha != null) {
            String[] dadosDaLinha = linha.split(";");
            TUDO.add(dadosDaLinha[6]);
            linha = arquivoLogico.readLine();
            permission = true;
        }

        arquivoLogico.close();
        return TUDO;
    }

    public ArrayList<String> pegarCEP() throws IOException {
        String linha;
        ArrayList<String> TUDO = new ArrayList<>();
        FileReader arquivoFisico = new FileReader("SaveDataEmployee.txt");
        BufferedReader arquivoLogico = new BufferedReader(arquivoFisico);
        linha = arquivoLogico.readLine();

        while (linha != null) {
            String[] dadosDaLinha = linha.split(";");
            TUDO.add(dadosDaLinha[7]);
            linha = arquivoLogico.readLine();
            permission = true;
        }

        arquivoLogico.close();
        return TUDO;
    }

    public ArrayList<String> pegarSalar() throws IOException {
        String linha;
        ArrayList<String> TUDO = new ArrayList<>();
        FileReader arquivoFisico = new FileReader("SaveDataEmployee.txt");
        BufferedReader arquivoLogico = new BufferedReader(arquivoFisico);
        linha = arquivoLogico.readLine();

        while (linha != null) {
            String[] dadosDaLinha = linha.split(";");
            TUDO.add(dadosDaLinha[8]);
            linha = arquivoLogico.readLine();
            permission = true;
        }

        arquivoLogico.close();
        return TUDO;
    }


    public ArrayList<String> pegarCod() throws IOException {
        String linha;
        ArrayList<String> TUDO = new ArrayList<>();
        FileReader arquivoFisico = new FileReader("SaveDataEmployee.txt");
        BufferedReader arquivoLogico = new BufferedReader(arquivoFisico);
        linha = arquivoLogico.readLine();

        while (linha != null) {
            String[] dadosDaLinha = linha.split(";");
            TUDO.add(dadosDaLinha[9]);
            linha = arquivoLogico.readLine();
            permission = true;
        }

        arquivoLogico.close();
        return TUDO;

    }


    public ArrayList<String> pegarCargo() throws IOException {
        String linha;
        ArrayList<String> TUDO = new ArrayList<>();
        FileReader arquivoFisico = new FileReader("SaveDataEmployee.txt");
        BufferedReader arquivoLogico = new BufferedReader(arquivoFisico);
        linha = arquivoLogico.readLine();

        while (linha != null) {
            String[] dadosDaLinha = linha.split(";");
            TUDO.add(dadosDaLinha[10]);
            linha = arquivoLogico.readLine();
            permission = true;
        }

        arquivoLogico.close();
        return TUDO;
    }
}