package br.com.adailtonskywalker.marketplace.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.*;
import java.util.ArrayList;

@EqualsAndHashCode(callSuper = true)
@Data
public class Client extends Pessoa {
    public static Boolean permission = false;
    String filename = "Arquivo.txt";
    private String email;
    private String code;


    @Override
    public String toString() {
        return super.toString() + "Email = " + getEmail() + "C�digo de cliente = " + getCode();
    }

    public void gravar() throws IOException {
        String linha;
        FileWriter escreverF = new FileWriter(filename, true);
        PrintWriter escreverL = new PrintWriter(escreverF);

        linha = String.format("%-1s; %-1s; %-1s; %-1s; %-1s; %-1s; %-1s; %-1s; %-1s; %-1s", getName(), getCpf(), getPhone(), getAddress(), getGender(), getBornDate(), getRg(), getCep(), getEmail(), getCode());

        escreverL.append(linha);
        escreverL.println(" ");
        escreverL.close();
    }
    public ArrayList<Client> getClients() throws IOException {
        String line;
        ArrayList<Client> clientData = new ArrayList<>();
        FileReader file = new FileReader(filename);
        BufferedReader logicalFile = new BufferedReader(file);
        line = logicalFile.readLine();

        while (line != null) {
            String[] dadosDaLinha = line.split(";");
            Client client = new Client();
            client.setCpf(dadosDaLinha[0]);
            client.setPhone(dadosDaLinha[1]);
            client.setPhone(dadosDaLinha[2]);
            client.setAddress(dadosDaLinha[3]);
            client.setGender(dadosDaLinha[4]);
            client.setBornDate(dadosDaLinha[5]);
            client.setRg(dadosDaLinha[6]);
            client.setCep(dadosDaLinha[7]);
            client.setEmail(dadosDaLinha[8]);
            client.setCode(dadosDaLinha[9]);
            clientData.add(client);
            line = logicalFile.readLine();
            permission = true;
        }

        logicalFile.close();
        return clientData;
    }


    public ArrayList<String> pegarNome() throws IOException {
        String linha;
        ArrayList<String> TUDO = new ArrayList<>();
        FileReader arquivoFisico = new FileReader("Arquivo.txt");
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