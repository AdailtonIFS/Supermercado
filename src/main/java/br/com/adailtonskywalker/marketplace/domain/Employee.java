package br.com.adailtonskywalker.marketplace.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.*;
import java.util.ArrayList;

@EqualsAndHashCode(callSuper = true)
@Data
public class Employee extends Pessoa {
    public static Boolean permission = false;
    String filename = "SaveDataEmployee.txt";
    private Double salar;
    private String office;
    private String code;

    @Override
    public String toString() {
        return super.toString() + "Sal�rio = " + this.getSalar() + "Cargo = " + this.getOffice() +
                "C�digo do funcion�rio = " + this.getCode();
    }

    public void gravar() throws IOException {
        String line;
        FileWriter escreverF = new FileWriter(filename, true);
        PrintWriter escreverL = new PrintWriter(escreverF);

        line = String.format("%-1s;%-1s;%-1s;%-1s;%-1s;%-1s;%-1s;%-1s;%1.2f;%-1s;%-1s", getName(), getCpf(), getPhone(),
                getAddress(), getGender(), getBornDate(), getRg(),getCep(), getSalar(),getCode(), getOffice());

        escreverL.append(line);
        escreverL.println(" ");
        escreverL.close();
    }

    public ArrayList<Employee> getEmployees() throws IOException {
        String line;
        ArrayList<Employee> employeeData = new ArrayList<>();
        FileReader file = new FileReader(filename);
        BufferedReader logicalFile = new BufferedReader(file);
        line = logicalFile.readLine();

        while (line != null) {
            String[] dadosDaLinha = line.split(";");
            Employee employee = new Employee();
            employee.setCpf(dadosDaLinha[1]);
            employee.setPhone(dadosDaLinha[2]);
            employee.setAddress(dadosDaLinha[3]);
            employee.setGender(dadosDaLinha[4]);
            employee.setBornDate(dadosDaLinha[5]);
            employee.setRg(dadosDaLinha[6]);
            employee.setCep(dadosDaLinha[7]);
            employee.setSalar(Double.valueOf(dadosDaLinha[8]));
            employee.setCode(dadosDaLinha[9]);
            employee.setOffice(dadosDaLinha[10]);
            employeeData.add(employee);
            line = logicalFile.readLine();
            permission = true;
        }

        logicalFile.close();
        return employeeData;
    }

    public ArrayList<String> pegarNome() throws IOException {
        String line;
        ArrayList<String> nomes = new ArrayList<>();
        FileReader file = new FileReader(filename);
        BufferedReader logicalFile = new BufferedReader(file);
        line = logicalFile.readLine();

        while (line != null) {

            String[] dadosDaLinha = line.split(";");
            nomes.add(dadosDaLinha[0]);
            line = logicalFile.readLine();
            permission = true;

        }

        logicalFile.close();
        return nomes;
    }
}