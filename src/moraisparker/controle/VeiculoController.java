/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moraisparker.controle;

import java.util.ArrayList;
import moraisparker.controle.dao.ProprietarioDAO;
import moraisparker.controle.dao.VeiculoDAO;
import moraisparker.controle.helpers.VeiculoHelper;
import moraisparker.modelos.Proprietario;
import moraisparker.modelos.Veiculo;
import moraisparker.visao.formularios.FormVeiculo;

/**
 *
 * @author Desktop
 */
public class VeiculoController implements IController<Veiculo>{

    private final FormVeiculo janela;
    private VeiculoHelper helper;
    
    
    public VeiculoController(FormVeiculo janela) {
        this.janela = janela;
        this.helper = new VeiculoHelper(janela);
    }

    @Override
    /**
     * Pega os dados no banco e passa como parâmetro para que o helper preencha a tabela
     * através do método "preencherTabela"
     */
    public void atualizarTabela() {
        VeiculoDAO veiculoDAO = new VeiculoDAO();
        ArrayList<Veiculo> veiculos = veiculoDAO.listarTodos();
        
        this.helper.preencherTabela(veiculos);
    }
    
    public void atualizarComboProprietarios(){
        ProprietarioDAO proprietarioDAO = new ProprietarioDAO();
        ArrayList<Proprietario> proprietarios = proprietarioDAO.listarTodos();
        
        this.helper.atualizarComboProprietarios(proprietarios);
    }

    @Override
    public void selecionar() {
        Veiculo modelo;
                
        modelo = this.helper.obterModeloTabela();
        
        VeiculoDAO veiculoDAO = new VeiculoDAO();
        for (Veiculo veiculo : veiculoDAO.listarTodos()){
        
            if (veiculo.getId()== modelo.getId()){
                modelo = veiculo;
                break;
            }
        }
         
        this.helper.preencherFormulario(modelo);
    }

    @Override
    public void cadastrar() {
        Veiculo modeloDoFormulario = this.helper.obterModeloFormulario();
        
        VeiculoDAO veiculoDAO = new VeiculoDAO();
        this.limparCampos();
        
        veiculoDAO.inserir(modeloDoFormulario);
    }

    @Override
    public void atualizar() {
        Veiculo modeloDoFormulario = this.helper.obterModeloFormulario();
        
        VeiculoDAO veiculoDAO = new VeiculoDAO();
        this.limparCampos();
        
        veiculoDAO.alterar(modeloDoFormulario);
    }

    @Override
    public void excluir() {
        Veiculo modelo;
        modelo = this.helper.obterModeloFormulario();
        VeiculoDAO veiculoDAO = new VeiculoDAO();
        limparCampos();
        veiculoDAO.excluir(modelo);
    }

    @Override
    public void limparCampos() {
        this.helper.limparTela();
    }
    
}
