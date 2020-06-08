package moraisparker.controle;

import java.util.ArrayList;
import moraisparker.controle.dao.FuncionarioDAO;
import moraisparker.controle.helpers.FuncionarioHelper;
import moraisparker.modelos.Funcionario;
import moraisparker.visao.formularios.FormFuncionario;

/**
 *
 * @author Desktop
 */
public class FuncionarioController implements IController<Funcionario>{

    private final FormFuncionario janela;
    private FuncionarioHelper helper;

    
    public FuncionarioController(FormFuncionario janela) {
        this.janela = janela;
        this.helper = new FuncionarioHelper(janela);
    }
   
    @Override
    public void atualizarTabela() {
        
        FuncionarioDAO funcionarioDAO;
        funcionarioDAO = new FuncionarioDAO();
        ArrayList<Funcionario> funcionarios = funcionarioDAO.listarTodos();
        
        helper.preencherTabela(funcionarios);
    }

    @Override
    public void selecionar() {
        Funcionario modelo;
        
        modelo = this.helper.obterModeloTabela();
        
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        for (Funcionario funcionario : funcionarioDAO.listarTodos()){
        
            if (funcionario.getId() == modelo.getId()){
                modelo = funcionario; break;
            }
        }
        
        this.helper.preencherFormulario(modelo);
    }

    @Override
    public void cadastrar() {
        Funcionario funcionario;
        funcionario = this.helper.obterModeloFormulario();
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        limparCampos();
        funcionarioDAO.inserir(funcionario);
    }

    @Override
    public void atualizar() {
        Funcionario modelo;
        modelo = this.helper.obterModeloFormulario();
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        limparCampos();
        funcionarioDAO.alterar(modelo);
        
    }

    @Override
    public void excluir() {
        Funcionario modelo;
        modelo = this.helper.obterModeloFormulario();
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        limparCampos();
        funcionarioDAO.excluir(modelo);             
    }

    @Override
    public void limparCampos() {
        this.helper.limparTela();
    }
    
}
