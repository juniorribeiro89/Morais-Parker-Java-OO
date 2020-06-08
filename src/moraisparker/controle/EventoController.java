package moraisparker.controle;

import java.util.ArrayList;
import moraisparker.controle.dao.EstacionamentoDAO;
import moraisparker.controle.dao.EventoDAO;
import moraisparker.controle.helpers.EventoHelper;
import moraisparker.modelos.Estacionamento;
import moraisparker.modelos.Evento;
import moraisparker.visao.formularios.FormEvento;

/**
 *
 * @author Desktop
 */
public class EventoController implements IController<Evento>{

    private final FormEvento janela;
    private EventoHelper helper;

    
    public EventoController(FormEvento janela) {
        this.janela = janela;
        this.helper = new EventoHelper(janela);
    }
   
    @Override
    public void atualizarTabela() {
        
        EventoDAO eventoDAO;
        eventoDAO = new EventoDAO();
        ArrayList<Evento> eventos = eventoDAO.listarTodos();
        
        helper.preencherTabela(eventos);
    }

    @Override
    public void selecionar() {
        Evento modelo;
        
        modelo = this.helper.obterModeloTabela();
        
        EventoDAO eventoDAO = new EventoDAO();
        for (Evento evento : eventoDAO.listarTodos()){
        
            if (evento.getId()==modelo.getId()){
                modelo = evento; break;
            }
        }
        
        this.helper.preencherFormulario(modelo);
    }

    @Override
    public void cadastrar() {
        Evento evento;
        evento = this.helper.obterModeloFormulario();
        EventoDAO eventoDAO = new EventoDAO();
        limparCampos();
        eventoDAO.inserir(evento);
    }

    @Override
    public void atualizar() {
        Evento modelo;
        modelo = this.helper.obterModeloFormulario();
        EventoDAO eventoDAO = new EventoDAO();
        limparCampos();
        eventoDAO.alterar(modelo);
        
    }

    @Override
    public void excluir() {
        Evento modelo;
        modelo = this.helper.obterModeloFormulario();
        EventoDAO eventoDAO = new EventoDAO();
        limparCampos();
        eventoDAO.excluir(modelo);             
    }

    @Override
    public void limparCampos() {
        this.helper.limparTela();
    }
    
    public void atualizarListaDeEstacionamentos(){
        EstacionamentoDAO estacionamentoDAO = new EstacionamentoDAO();
        
        ArrayList<Estacionamento> estacionamentos = new ArrayList<>();
        estacionamentos = estacionamentoDAO.listarTodos();
        
        this.helper.preencherListaDeEstacionamentos(estacionamentos);
    }
}
