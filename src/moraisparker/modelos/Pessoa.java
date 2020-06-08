package moraisparker.modelos;



public abstract class Pessoa {
    
    String nome;
    String cpf;
    String dataNascimento;

    public Pessoa(String nome, String cpf, String dataNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }
    
    public Pessoa() {
        
    }
    

    
}
