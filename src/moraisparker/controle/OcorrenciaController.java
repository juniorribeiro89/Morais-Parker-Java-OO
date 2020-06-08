package moraisparker.controle;

import java.util.ArrayList;
import moraisparker.controle.dao.FuncionarioDAO;
import moraisparker.controle.dao.OcorrenciaDAO;
import moraisparker.controle.helpers.OcorrenciaHelper;
import moraisparker.modelos.Funcionario;
import moraisparker.modelos.Ocorrencia;
import moraisparker.visao.formularios.FormOcorrencia;

/**
 *
 * @author Desktop
 */
public class OcorrenciaController implements IController<Ocorrencia>{

    private final FormOcorrencia janela;
    private OcorrenciaHelper helper;

    
    public OcorrenciaController(FormOcorrencia janela) {
        this.janela = janela;
        this.helper = new OcorrenciaHelper(janela);
    }
   
    @Override
    public void atualizarTabela() {
        
        OcorrenciaDAO ocorrenciaDAO;
        ocorrenciaDAO = new OcorrenciaDAO();
        ArrayList<Ocorrencia> ocorrencias = ocorrenciaDAO.listarTodos();
        
        helper.preencherTabela(ocorrencias);
    }

    @Override
    public void selecionar() {
        Ocorrencia modelo;
        
        modelo = this.helper.obterModeloTabela();
        
        OcorrenciaDAO ocorrenciaDAO = new OcorrenciaDAO();
        for (Ocorrencia ocorrencia : ocorrenciaDAO.listarTodos()){
        
            if (ocorrencia.getId()==modelo.getId()){
                modelo = ocorrencia; break;
            }
        }
        
        this.helper.preencherFormulario(modelo);
    }

    @Override
    public void cadastrar() {
        Ocorrencia ocorrencia;
        ocorrencia = this.helper.obterModeloFormulario();
        OcorrenciaDAO ocorrenciaDAO = new OcorrenciaDAO();
        limparCampos();
        ocorrenciaDAO.inserir(ocorrencia);
    }

    @Override
    public void atualizar() {
        Ocorrencia modelo;
        modelo = this.helper.obterModeloFormulario();
        OcorrenciaDAO ocorrenciaDAO = new OcorrenciaDAO();
        limparCampos();
        ocorrenciaDAO.alterar(modelo);
        
    }

    @Override
    public void excluir() {
        Ocorrencia modelo;
        modelo = this.helper.obterModeloFormulario();
        OcorrenciaDAO ocorrenciaDAO = new OcorrenciaDAO();
        limparCampos();
        ocorrenciaDAO.excluir(modelo);             
    }

    @Override
    public void limparCampos() {
        this.helper.limparTela();
    }

    public void atualizarComboFuncionarios() {
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        
        for (Funcionario funcionario : funcionarioDAO.listarTodos()){
            if (!funcionario.getCategoria().equals("RH")){
                funcionarios.add(funcionario);
            }
        }
        
        this.helper.preencherComboFuncionarios(funcionarios);
    }
    
}
