package moraisparker.modelos;

public class Veiculo {
    
    private int id;
    private Proprietario proprietario;
    private String tipo;
    private String marca; 
    private String modelo;
    private String cor;
    private String ano;
    private String placa;

    //Usado na criação do Banco de Dados
    public Veiculo(int id, Proprietario proprietario, String tipo, String marca, String modelo, String cor, String ano, String placa) {
        this.id             = id;
        this.proprietario   = proprietario;
        this.tipo           = tipo;
        this.marca          = marca;
        this.modelo         = modelo;
        this.cor            = cor;
        this.ano            = ano;
        this.placa          = placa;
        this.proprietario = proprietario;
    }
    
    public Veiculo(Proprietario proprietario, String tipo, String marca, String modelo, String cor, String ano, String placa) {
        this.proprietario   = proprietario;
        this.tipo           = tipo;
        this.marca          = marca;
        this.modelo         = modelo;
        this.cor            = cor;
        this.ano            = ano;
        this.placa          = placa;
        this.proprietario = proprietario;
    }


    public Veiculo() {
        this.proprietario = new Proprietario();
    }
    
    public Veiculo(int id) {
        this.id = id;
        this.proprietario = new Proprietario();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Proprietario getProprietario() {
        return proprietario;
    }

    public void setProprietario(Proprietario proprietario) {
        this.proprietario = proprietario;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    @Override
    public String toString() {
        return placa.split(":")[0];
    }
    
    
    
    
}
