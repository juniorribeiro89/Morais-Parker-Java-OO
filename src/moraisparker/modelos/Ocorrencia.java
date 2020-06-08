package moraisparker.modelos;


public class Ocorrencia {
    
    private int id;
    private String dataDaOcorrencia;
    private String descricao;
    private Funcionario funcionarioQueRegistrou;
    private String titulo;

    //Este construtor será usado apenas na criação do Banco de Dados inicial
    public Ocorrencia(int id, String dataDaOcorrencia, String titulo, String descricao, Funcionario funcionarioQueRegistrou) {
        this.id = id;
        this.dataDaOcorrencia = dataDaOcorrencia;
        this.titulo = titulo;
        this.descricao = descricao;
        this.funcionarioQueRegistrou = funcionarioQueRegistrou;
    }
    
    public Ocorrencia(String dataDaOcorrencia, String titulo, String descricao, Funcionario funcionarioQueRegistrou) {
        this.dataDaOcorrencia = dataDaOcorrencia;
        this.titulo = titulo;
        this.descricao = descricao;
        this.funcionarioQueRegistrou = funcionarioQueRegistrou;
    }

    public Ocorrencia() {
        this.funcionarioQueRegistrou = new Funcionario();
    }

    public Ocorrencia(int id) {
        this.id = id;
        this.funcionarioQueRegistrou = new Funcionario();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDataDaOcorrencia() {
        return dataDaOcorrencia;
    }

    public void setDataDaOcorrencia(String dataDaOcorrencia) {
        this.dataDaOcorrencia = dataDaOcorrencia;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Funcionario getFuncionarioQueRegistrou() {
        return funcionarioQueRegistrou;
    }

    public void setFuncionarioQueRegistrou(Funcionario funcionarioQueRegistrou) {
        this.funcionarioQueRegistrou = funcionarioQueRegistrou;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    
}
