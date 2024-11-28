package br.com.adailtonskywalker.marketplace.domain;

import lombok.Data;

@Data
public class Pessoa {
    private String name;
    private String cpf;
    private String phone;
    private String address;
    private String gender;
    private String bornDate;
    private String rg;
    private String cep;
    private int age;

    @Override
    public String toString() {
        return "Nome = " + this.getName() + "CPF = " + this.getCpf() + "Telefone = " + this.getPhone() + "Endere�o = "
                + this.getAddress() + "Sexo = " + this.getGender() + "Data de nascimento = " + this.getBornDate()
                + "Idade = " + this.getAge() + "RG = " + this.getRg() + "CEP = " + this.getCep();
    }
}
