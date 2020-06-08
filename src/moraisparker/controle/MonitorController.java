/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moraisparker.controle;

import java.util.ArrayList;
import moraisparker.controle.dao.Banco;
import moraisparker.controle.dao.EstacionamentoDAO;
import moraisparker.controle.dao.VeiculoDAO;
import moraisparker.visao.Monitor;
import moraisparker.controle.helpers.MonitorHelper;
import moraisparker.modelos.Estacionamento;
import moraisparker.modelos.Veiculo;
/**
 *
 * @author Desktop
 */
public class MonitorController {
    private final Monitor janela;
    private final MonitorHelper helper;
    
    public MonitorController(Monitor janela) {
        this.janela = janela;
        this.helper = new MonitorHelper(janela);
    }
   
    public void atualizarTabela(){
        //Buscar Lista no Banco de Dados
        EstacionamentoDAO EstacionamentoDAO;
        EstacionamentoDAO = new EstacionamentoDAO();
        ArrayList<Estacionamento> blocos;
        blocos = EstacionamentoDAO.listarTodos();
        
        //Exibir essa lista na View
        helper.preencherTabela(blocos);
    }
    
    public void atualizaComboEstacinamentos() {
        EstacionamentoDAO estacionamentoDAO;
        estacionamentoDAO = new EstacionamentoDAO();
        ArrayList<Estacionamento> blocos;
        blocos = estacionamentoDAO.listarTodos();
        
        helper.preencherComboEstacionamentos(blocos);
    }
    
    public void atualizaComboEstacinamentosSaida() {
        EstacionamentoDAO estacionamentoDAO;
        estacionamentoDAO = new EstacionamentoDAO();
        ArrayList<Estacionamento> blocos;
        blocos = estacionamentoDAO.listarTodos();
        
        helper.preencherComboEstacionamentosSaida(blocos);
    }
    
    public void atualizaComboVeiculos() {
        VeiculoDAO veiculoDAO;
        veiculoDAO = new VeiculoDAO();

        ArrayList<Veiculo> veiculos = new ArrayList<>();
        for (Veiculo veiculo : veiculoDAO.listarTodos()){
            if (!isVeiculaCadastrado(veiculo)){
                if(veiculo.getModelo().length()>1)
                    veiculos.add(veiculo);
            }
        }     
        helper.preencherComboVeiculos(veiculos);
    }
    
    public void atualizaComboVeiculosSaida() {

        Estacionamento estacionamento;

        EstacionamentoDAO estacionamentoDAO;
        estacionamentoDAO = new EstacionamentoDAO();
        estacionamento = (Estacionamento) this.helper.obterModeloSaida()[0];
        for (Estacionamento estacionamentoLista : estacionamentoDAO.listarTodos()){
            if(estacionamentoLista.equals(estacionamento))
                helper.preencherComboVeiculosSaida(estacionamento.getVeiculos());
        }

    }    
    
    public void estacionarVeiculo(){
        Object[] modelo = this.helper.obterModelo();
        Estacionamento estacioanamento;
        
        estacioanamento = (Estacionamento) modelo[0];
        Veiculo veiculo = (Veiculo) modelo[1];

        if(!isVeiculaCadastrado(veiculo) && veiculo!=null){
            estacioanamento.getVeiculos().add(veiculo);
        }
        
    }
    
    public void removerVeiculo(){
        Object[] modelo = this.helper.obterModeloSaida();
        Estacionamento estacionamento;
        
        estacionamento = (Estacionamento) modelo[0];
        System.out.println(estacionamento);
        Veiculo veiculo = (Veiculo) modelo[1];
        estacionamento.getVeiculos().remove(veiculo);
        
    }
    
    public boolean isVeiculaCadastrado(Veiculo veiculo){
        
        for (Estacionamento estacionamentoLista : Banco.estacionamentos){
            if(estacionamentoLista.getVeiculos().contains(veiculo)){
                return true;
            }
        }   
        return false;
    }
}
