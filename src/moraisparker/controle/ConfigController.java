/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moraisparker.controle;

import moraisparker.controle.dao.FuncionarioDAO;
import moraisparker.controle.helpers.ConfigHelper;
import moraisparker.modelos.Funcionario;
import moraisparker.modelos.Usuario;
import moraisparker.visao.formularios.FormConfig;

/**
 *
 * @author Junior Ribeiro
 */
public class ConfigController {
    
    private ConfigHelper helper;
    private final FormConfig janela;

    public ConfigController(FormConfig janelaRecebida) {
        this.janela = janelaRecebida;
        this.helper = new ConfigHelper(this.janela);
    }

    public void atualizarUsuario() {
        //Obter modelo
        Funcionario modelo = this.helper.obterModelo();
        //Salvar
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        funcionarioDAO.alterar(modelo);
    }
    
}
