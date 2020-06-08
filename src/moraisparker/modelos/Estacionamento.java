package moraisparker.modelos;

import java.util.ArrayList;

public class Estacionamento {
    
    private int id;
    private String nome;
    private ArrayList<Veiculo> veiculos;
    private boolean ativo;
    private int capacidade;
    
    public Estacionamento(int id, int capacidade, String nome) {
        this.id = id;
        this.nome = nome;
        this.capacidade = capacidade;
        this.veiculos = new ArrayList<>(this.capacidade);
    }
    
    public Estacionamento(int id, int capacidade, String nome, boolean ativo) {
        this.id = id;
        this.nome = nome;
        this.ativo = ativo;
        this.capacidade = capacidade;
        this.veiculos = new ArrayList<>(this.capacidade);
    }


    public Estacionamento(int capacidade, String nome) {
        this.nome = nome;
        this.capacidade = capacidade;
        this.veiculos = new ArrayList<>(this.capacidade);
    }
    
    public Estacionamento(int capacidade, String nome, boolean ativo) {
        this.nome = nome;
        this.ativo = ativo;
        this.capacidade = capacidade;
        this.veiculos = new ArrayList<>(this.capacidade);
    }
    
    public Estacionamento() {
       this.veiculos = new ArrayList<>(); 
    }

    public Estacionamento(int id) {
        this.id = id;
        this.veiculos = new ArrayList<>(); 
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
       
    public ArrayList<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(ArrayList<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    @Override
    public String toString() {
        return nome;
    }

    
    
}
