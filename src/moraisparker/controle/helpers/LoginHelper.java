/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moraisparker.controle.helpers;

import moraisparker.modelos.Funcionario;
import moraisparker.visao.JanelaDeLogin;
import moraisparker.visao.JanelaPrincipal;

public class LoginHelper {
    
    private final JanelaDeLogin view;

    public LoginHelper(JanelaDeLogin view) {
        this.view = view;
    }
    
    public Funcionario obterModelo(){
        String login = this.view.getTxtLogin().getText();
        String senha = this.view.getTxtSenha().getText();
        
        Funcionario modelo = new Funcionario();
        modelo.getUsuario().setUsuario(login);
        modelo.getUsuario().setSenha(senha);
        
        return modelo;
    }

    public void funcionarioNaoExiste() {
        this.limparCampos();
        this.view.exibirMenssagemErro();
        
    }
    
    public void limparCampos(){
        this.view.getTxtLogin().setText("");
        this.view.getTxtSenha().setText("");
    }

    public boolean verificarCampos() {
        if(this.view.getTxtLogin().getText().equals("")){
            System.out.println("Digite o nome do Usuário");
            this.view.getTxtLogin().requestFocus();
            return false;
        } else if (this.view.getTxtSenha().getText().equals("")){
            System.out.println("Digite sua Senha");
            this.view.getTxtSenha().requestFocus();
            return false;
        } else {
            return true;
        }
    }

    public void abrindoJanelaPrincipal(Funcionario funcionarioAutenticado) {
            JanelaPrincipal janela = new JanelaPrincipal(funcionarioAutenticado);
            if(funcionarioAutenticado.getCategoria().equals("ADMIN")){
                janela.getMenuEstacionamento().setEnabled(true);
                janela.getMenuFuncionario().setEnabled(true);
                janela.getMenuRelatorios().setEnabled(true);
            } else if (funcionarioAutenticado.getCategoria().equals("GESTOR")){
                janela.getMenuEstacionamento().setEnabled(true);
                janela.getMenuFuncionario().setEnabled(false);
                janela.getMenuRelatorios().setEnabled(true);
            } else if (funcionarioAutenticado.getCategoria().equals("COMUM")){
                janela.getMenuEstacionamento().setEnabled(true);
                janela.getMenuFuncionario().setEnabled(false);
                janela.getMenuRelatorios().setEnabled(false);
                janela.getMenuEventos().setEnabled(false);
                janela.getMenuBlocosEstacionamentos().setEnabled(false);
            } else if (funcionarioAutenticado.getCategoria().equals("RH")){
                janela.getMenuEstacionamento().setEnabled(true);
                janela.getMenuBlocosEstacionamentos().setEnabled(false);
                janela.getMenuMonitorar().setEnabled(false);
                janela.getMenuOcorrecias().setEnabled(false);
                janela.getMenuProprietario().setEnabled(false);
                janela.getMenuVeiculo().setEnabled(false);
                janela.getMenuEventos().setVisible(true);
                janela.getMenuFuncionario().setEnabled(true);
                janela.getMenuRelatorios().setEnabled(false);
            }
            janela.setVisible(true);
            this.view.dispose();
    }
    
}
