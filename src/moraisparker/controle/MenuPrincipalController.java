/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moraisparker.controle;

import moraisparker.visao.JanelaDeLogin;
import moraisparker.visao.JanelaPrincipal;
import moraisparker.visao.Monitor;
import moraisparker.visao.formularios.FormConfig;
import moraisparker.visao.formularios.FormEstacionamento;
import moraisparker.visao.formularios.FormEvento;
import moraisparker.visao.formularios.FormFuncionario;
import moraisparker.visao.formularios.FormOcorrencia;
import moraisparker.visao.formularios.FormProprietario;
import moraisparker.visao.formularios.FormVeiculo;

/**
 *
 * @author Desktop
 */
public class MenuPrincipalController {

    private final JanelaPrincipal janela;
    
    public MenuPrincipalController(JanelaPrincipal janela) {
        this.janela = janela;
    }

    public void navegarParaLogin() {
        JanelaDeLogin janelaLogin = new JanelaDeLogin();
        janelaLogin.setVisible(true);
    }
    
    //Estacionamento
    //- Eventos
    public void navegarParaEventos(){
        FormEvento janela = new FormEvento();
        janela.setVisible(true);
    }
    //- Monitorar
    public void navegarParaMonitorar(){
        Monitor janela = new Monitor();
        janela.setVisible(true);
    }
    //- Proprietarios
    public void navegarParaProprietarios(){
        FormProprietario janela = new FormProprietario();
        janela.setVisible(true);
        
    }
    //- Blocos de Estacionamento
    public void navegarParaEstacionamentos(){
        FormEstacionamento janela = new FormEstacionamento();
        janela.setVisible(true);
    }
    //- Ocorrências
    public void navegarParaOcorrencias(){
        FormOcorrencia janela = new FormOcorrencia(this.janela.getFuncionario());
        janela.setVisible(true);
    }
    //- Veículos
    public void navegarParaVeiculos(){
        FormVeiculo janela = new FormVeiculo();
        janela.setVisible(true);
    }
    
    //Funcionarios
    public void navegarParaFuncionarios(){
        FormFuncionario janela = new FormFuncionario();
        janela.setVisible(true);   
    }
    
    //Relatórios
    public void navegarParaRelatórios(){
        
    }
    
    //Sobre
    public void navegarParaSobre(){
        
    }

    public void navegarParaconfiguracao() {
        FormConfig janela = new FormConfig(this.janela.getFuncionario());
        System.out.println("Navegar para Config");
        janela.setVisible(true);
    }
    
}
