package br.com.adailtonskywalker.marketplace.domain;

public class Pessoa {

    private String Name;
    private String CPF;
    private String Phone;
    private String Adress;
    private String Sex;
    private String BornDate;
    private String RG;
    private String CEP;

    private int Idade;


    public Pessoa() {

    }

    public Pessoa(String name, String cPF, String phone, String adress, String sex, String bornDate, int idade, String rG, String cep) {

        Name = name;
        CPF = cPF;
        Phone = phone;
        Adress = adress;
        Sex = sex;
        BornDate = bornDate;
        Idade = idade;
        RG = rG;
        CEP = cep;

    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String cPF) {
        CPF = cPF;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getAdress() {
        return Adress;
    }

    public void setAdress(String adress) {
        Adress = adress;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public String getBornDate() {
        return BornDate;
    }

    public void setBornDate(String date) {
        BornDate = date;
    }

    public int getIdade() {
        return Idade;
    }

    public void setIdade(int idade) {
        this.Idade = idade;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String rG) {
        RG = rG;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String cEP) {
        CEP = cEP;
    }

    public void exibirDados() {

        System.out.println("Nome = " + this.getName());
        System.out.println("CPF = " + this.getCPF());
        System.out.println("Telefone = " + this.getPhone());
        System.out.println("Endere�o = " + this.getAdress());
        System.out.println("Sexo = " + this.getSex());
        System.out.println("Data de nascimento = " + this.getBornDate());
        System.out.println("Idade = " + this.getIdade());
        System.out.println("RG = " + this.getRG());
        System.out.println("CEP = " + this.getCEP());


    }


}
