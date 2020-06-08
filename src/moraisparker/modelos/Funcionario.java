package moraisparker.modelos;

public class Funcionario extends Pessoa{

    private int id;
    private String categoria;
    private String matricula;
    private Usuario usuario;
    
    public Funcionario(String categoria, String matricula,String nome, String cpf, String dataNascimento) {
        super(nome, cpf, dataNascimento);
        this.categoria = categoria;
        this.matricula = matricula;
        this.usuario = new Usuario();
        this.usuario.setUsuario(this.cpf);
        this.usuario.setSenha(this.matricula);
    }

    public Funcionario(int id, String categoria, String matricula, String nome, String cpf, String dataNascimento) {
        super(nome, cpf, dataNascimento);
        this.id         = id;
        this.categoria  = categoria;
        this.matricula = matricula;
        this.usuario = new Usuario();
        this.usuario.setUsuario(this.cpf);
        this.usuario.setSenha(this.matricula);
        
    }

    public Funcionario() {
        this.usuario = new Usuario();
        this.usuario.setUsuario(this.cpf);
        this.usuario.setSenha(this.matricula);
    }
    
    public Funcionario(int id) {
        this.id = id;
        this.usuario = new Usuario();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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
        return super.nome;
    }
    
    
    
    
}
