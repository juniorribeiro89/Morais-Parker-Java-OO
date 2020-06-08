/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moraisparker.controle.helpers;

import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import moraisparker.modelos.Estacionamento;
import moraisparker.modelos.Veiculo;
import moraisparker.visao.Monitor;

/**
 *
 * @author Desktop
 */
public class MonitorHelper {
    
    private final Monitor janela;

    public MonitorHelper(Monitor janela) {
        this.janela = janela;
    }

    public void preencherTabela(ArrayList<Estacionamento> estacionamentos) {
        DefaultTableModel modeloDaTabela = (DefaultTableModel)this.janela.getTabelaDeDados().getModel();
        
        this.janela.getTabelaDeDados().setRowSorter(new TableRowSorter(modeloDaTabela));
        
        modeloDaTabela.setNumRows(0);
        
        //Percorrer a lista preenchendo o tableModel
        for(Estacionamento estacionamento : estacionamentos){
            if(estacionamento.isAtivo()){
                modeloDaTabela.addRow(new Object[]{
                    estacionamento.getNome(),
                    estacionamento.getCapacidade(),
                    estacionamento.getCapacidade()-estacionamento.getVeiculos().size(),
                    estacionamento.getVeiculos().size(),
                });
            }
        }          
    }

    public void preencherComboEstacionamentos(ArrayList<Estacionamento> estacionamentos) {
        DefaultComboBoxModel comboModel = (DefaultComboBoxModel) this.janela.getComboEstacionamentos().getModel();
        
        comboModel.removeAllElements();
        for (Estacionamento estacionamento : estacionamentos) {
            if (estacionamento.isAtivo()){
                comboModel.addElement(estacionamento);
            }
            
        }        
    }
    
    public void preencherComboEstacionamentosSaida(ArrayList<Estacionamento> estacionamentos) {
        DefaultComboBoxModel comboModel = (DefaultComboBoxModel) this.janela.getComboEstacionamentosSaida().getModel();
        
        
        comboModel.removeAllElements();
        for (Estacionamento estacionamento : estacionamentos) {
             if (estacionamento.isAtivo() & estacionamento.getVeiculos().size() > 0){
                comboModel.addElement(estacionamento);
            }
        }        
    }
    

    public void preencherComboVeiculos(ArrayList<Veiculo> veiculos) {
        DefaultComboBoxModel comboModel = (DefaultComboBoxModel) this.janela.getComboVeiculos().getModel();
        
        comboModel.removeAllElements();
        for (Veiculo veiculo : veiculos) {
            comboModel.addElement(veiculo);
        }
    }
    
    public void preencherComboVeiculosSaida(ArrayList<Veiculo> veiculos) {
        DefaultComboBoxModel comboModel = (DefaultComboBoxModel) this.janela.getComboVeiculosSaida().getModel();

        comboModel.removeAllElements();
        for (Veiculo veiculo : veiculos) {
            comboModel.addElement(veiculo);
        }
    }
    
    
    public Object[] obterModelo(){
        Estacionamento estacionamento = (Estacionamento) this.janela.getComboEstacionamentos().getSelectedItem();
        Veiculo veiculo = (Veiculo) this.janela.getComboVeiculos().getSelectedItem();

        Object[] modelo = {estacionamento, veiculo};
        return modelo;
    }
    
    public Object[] obterModeloSaida(){
        Estacionamento estacionamento = (Estacionamento) this.janela.getComboEstacionamentosSaida().getSelectedItem();
        Veiculo veiculo = (Veiculo) this.janela.getComboVeiculosSaida().getSelectedItem();

        Object[] modelo = {estacionamento, veiculo};
        
        return modelo;
    }
    
    
    
}
