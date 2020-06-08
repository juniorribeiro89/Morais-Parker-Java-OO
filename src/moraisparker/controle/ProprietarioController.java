package moraisparker.controle;

import java.util.ArrayList;
import moraisparker.controle.dao.ProprietarioDAO;
import moraisparker.controle.helpers.ProprietarioHelper;
import moraisparker.modelos.Proprietario;
import moraisparker.visao.formularios.FormProprietario;

/**
 *
 * @author Desktop
 */
public class ProprietarioController implements IController<Proprietario>{

    private final FormProprietario janela;
    private ProprietarioHelper helper;

    
    public ProprietarioController(FormProprietario janela) {
        this.janela = janela;
        this.helper = new ProprietarioHelper(janela);
    }
   
    @Override
    public void atualizarTabela() {
        
        ProprietarioDAO proprietarioDAO;
        proprietarioDAO = new ProprietarioDAO();
        ArrayList<Proprietario> proprietarios = proprietarioDAO.listarTodos();
        
        helper.preencherTabela(proprietarios);
    }

    @Override
    public void selecionar() {
        Proprietario modelo;
        
        modelo = this.helper.obterModeloTabela();
        
        ProprietarioDAO proprietarioDAO = new ProprietarioDAO();
        for (Proprietario proprietario : proprietarioDAO.listarTodos()){
        
            if (proprietario.getId()==modelo.getId()){
                modelo = proprietario; break;
            }
        }
        
        this.helper.preencherFormulario(modelo);
    }

    @Override
    public void cadastrar() {
        Proprietario proprietario;
        proprietario = this.helper.obterModeloFormulario();
        ProprietarioDAO proprietarioDAO = new ProprietarioDAO();
        limparCampos();
        proprietarioDAO.inserir(proprietario);
    }

    @Override
    public void atualizar() {
        Proprietario modelo;
        modelo = this.helper.obterModeloFormulario();
        ProprietarioDAO proprietarioDAO = new ProprietarioDAO();
        limparCampos();
        proprietarioDAO.alterar(modelo);
        
    }

    @Override
    public void excluir() {
        Proprietario modelo;
        modelo = this.helper.obterModeloFormulario();
        ProprietarioDAO proprietarioDAO = new ProprietarioDAO();
        limparCampos();
        proprietarioDAO.excluir(modelo);             
    }

    @Override
    public void limparCampos() {
        this.helper.limparTela();
    }
    
}
