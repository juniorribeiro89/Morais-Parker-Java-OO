package moraisparker.controle;

public interface IController <Tipo> {
    
    public abstract void atualizarTabela();
    
    public abstract void selecionar();
    
    public abstract void cadastrar();
    
    public abstract void atualizar();
    
    public abstract void excluir();
    
    public abstract void limparCampos();
    
}
