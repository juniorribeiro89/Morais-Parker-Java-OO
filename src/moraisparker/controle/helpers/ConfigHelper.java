/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moraisparker.controle.helpers;

import moraisparker.modelos.Funcionario;
import moraisparker.modelos.Usuario;
import moraisparker.visao.formularios.FormConfig;

/**
 *
 * @author Junior Ribeiro
 */
public class ConfigHelper {

    private FormConfig janela;
    
    public ConfigHelper(FormConfig janelaRecebida) {
        this.janela = janelaRecebida;
    }

    public Funcionario obterModelo() {
        String login = this.janela.getTxtLogin().getText();
        String senha1 = this.janela.getTxtSenha1().getText();
        String senha2 = this.janela.getTxtSenha2().getText();
        System.out.println("login: "+login+"senhas: "+senha1+" : "+senha2);
        
        Funcionario modelo = this.janela.getFuncionario();       
        Usuario usuarioCapturado = new Usuario();
        if (senha1.equals(senha2)){
            usuarioCapturado.setUsuario(login);
            usuarioCapturado.setSenha(senha1);
            modelo.setUsuario(usuarioCapturado);
            limparCampos();
        } else {
            System.out.println("Senhas não coincidem");
            limparCampos();
        }
        
        return modelo;
    }

    private void limparCampos() {
        this.janela.getTxtLogin().setText("");
        this.janela.getTxtSenha1().setText("");
        this.janela.getTxtSenha2().setText("");
    }
    
}
