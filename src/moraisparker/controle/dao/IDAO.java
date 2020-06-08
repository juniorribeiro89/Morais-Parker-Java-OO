package moraisparker.controle.dao;

import java.util.ArrayList;

public interface IDAO<Tipo> {
    
    public abstract void inserir(Tipo objeto);

    public abstract boolean alterar(Tipo objeto);

    public abstract boolean excluir(Tipo objeto);

    public abstract ArrayList<Tipo> listarTodos();

    public abstract boolean idSaoIguais(Tipo objeto, Tipo objetoAComparar);
    
    public abstract int autoIncremento();
    
    public abstract Object buscaPorId (int id);
    
    
}
