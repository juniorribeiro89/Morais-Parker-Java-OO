package moraisparker.modelos;

import java.util.ArrayList;

public class Proprietario extends Pessoa {
    
    private ArrayList<Estacionamento> zonasEspeciais;
    private int id;
    

    public Proprietario(String nome, String cpf, String dataNascimento) {
        super(nome, cpf, dataNascimento);
        this.zonasEspeciais = new ArrayList<>();
    }
    
    public Proprietario(int id, String nome, String cpf, String dataNascimento) {
        super(nome, cpf, dataNascimento);
        this.id = id;
        this.zonasEspeciais = new ArrayList<>();
    }

    public Proprietario() {
        this.zonasEspeciais = new ArrayList<>();
    }

    public Proprietario(int id) {
        this.id = id;
        this.zonasEspeciais = new ArrayList<>();
    }

    public ArrayList<Estacionamento> getZonasEspeciais() {
        return zonasEspeciais;
    }

    public void setZonasEspeciais(ArrayList<Estacionamento> zonasEspeciais) {
        this.zonasEspeciais = zonasEspeciais;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String toString() {
        return this.getNome();
    }
    
    
}
