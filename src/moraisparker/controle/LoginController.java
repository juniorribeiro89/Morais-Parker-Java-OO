/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moraisparker.controle;

import moraisparker.controle.dao.FuncionarioDAO;
import moraisparker.controle.helpers.FuncionarioHelper;
import moraisparker.controle.helpers.LoginHelper;
import moraisparker.modelos.Funcionario;
import moraisparker.visao.JanelaDeLogin;
import moraisparker.visao.JanelaPrincipal;

/**
 *
 * @author Desktop
 */
public class LoginController {

    private final JanelaDeLogin view;
    private LoginHelper helper;
    
    public LoginController(JanelaDeLogin view) {
        this.view = view;
        this.helper = new LoginHelper(view);
    }

    public void fazerLogin(){
        if(this.helper.verificarCampos()){
            this.entrarNoSistema();
        }
    }
    
    public void entrarNoSistema() {
        //Obter o Modelo
        Funcionario modelo = this.helper.obterModelo();
        
        //Consultar no Banco de Dados
        Funcionario funcionarioAutenticado;
        funcionarioAutenticado = new FuncionarioDAO().selecionePorNomeESenha(modelo);
        
        if (funcionarioAutenticado != null ){
            this.helper.abrindoJanelaPrincipal(funcionarioAutenticado);
        } else {
            this.helper.funcionarioNaoExiste();
        }
    }


    
}
