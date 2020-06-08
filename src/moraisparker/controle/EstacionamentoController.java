package moraisparker.controle;

import java.util.ArrayList;
import moraisparker.controle.dao.EstacionamentoDAO;
import moraisparker.modelos.Estacionamento;
import moraisparker.controle.helpers.EstacionamentoHelper;
import moraisparker.visao.formularios.FormEstacionamento;

/**
 *
 * @author Desktop
 */
public class EstacionamentoController implements IController<Estacionamento>{

    private final FormEstacionamento janela;
    private final EstacionamentoHelper helper;

    
    public EstacionamentoController(FormEstacionamento janela) {
        this.janela = janela;
        this.helper = new EstacionamentoHelper(janela);
    }
   
    @Override
    public void atualizarTabela() {
        
        EstacionamentoDAO estacionamentoDAO;
        estacionamentoDAO = new EstacionamentoDAO();
        ArrayList<Estacionamento> estacionamentos = estacionamentoDAO.listarTodos();
        
        helper.preencherTabela(estacionamentos);
    }

    @Override
    public void selecionar() {
        Estacionamento modelo;
        
        modelo = this.helper.obterModeloTabela();
        
        EstacionamentoDAO estacionamentoDAO = new EstacionamentoDAO();
        for (Estacionamento estacionamento : estacionamentoDAO.listarTodos()){
        
            if (estacionamento.getId()== modelo.getId()){
                modelo = estacionamento; break;
            }
        }
        
        this.helper.preencherFormulario(modelo);
    }

    @Override
    public void cadastrar() {
        Estacionamento estacionamento;
        estacionamento = this.helper.obterModeloFormulario();
        EstacionamentoDAO estacionamentoDAO = new EstacionamentoDAO();
        limparCampos();
        estacionamentoDAO.inserir(estacionamento);
    }

    @Override
    public void atualizar() {
        Estacionamento modelo;
        modelo = this.helper.obterModeloFormulario();
        EstacionamentoDAO estacionamentoDAO = new EstacionamentoDAO();
        limparCampos();
        estacionamentoDAO.alterar(modelo);
        
    }

    @Override
    public void excluir() {
        Estacionamento modelo;
        modelo = this.helper.obterModeloFormulario();
        EstacionamentoDAO estacionamentoDAO = new EstacionamentoDAO();
        limparCampos();
        estacionamentoDAO.excluir(modelo);             
    }

    @Override
    public void limparCampos() {
        this.helper.limparTela();
    }
    
}
