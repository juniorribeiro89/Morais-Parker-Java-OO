package moraisparker.controle.helpers;

import java.util.ArrayList;


public interface IHelper <Tipo> {
    
    
    
    public abstract Tipo obterModeloFormulario();
    
    public abstract Tipo obterModeloTabela();
       
    public abstract void preencherFormulario(Tipo tipo);
    
    public abstract void preencherTabela(ArrayList<Tipo> object);
    
    public abstract void limparTela();
    
}
