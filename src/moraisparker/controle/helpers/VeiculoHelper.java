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
import moraisparker.modelos.Proprietario;
import moraisparker.modelos.Veiculo;
import moraisparker.visao.formularios.FormVeiculo;

/**
 *
 * @author Desktop
 */
public class VeiculoHelper implements IHelper<Veiculo>{

    private final FormVeiculo janela;
    
    public VeiculoHelper(FormVeiculo janela) {
        this.janela = janela;
    }

    @Override
    public Veiculo obterModeloFormulario() {
        String idString = this.janela.getTxtId().getText();
        String marca = this.janela.getTxtMarca().getText();
        String modeloCarro = this.janela.getTxtModelo().getText();
        String cor = this.janela.getTxtCor().getText();
        String placa = this.janela.getTxtPlaca().getText();
        String ano = this.janela.getTxtAno().getText();
        String tipo = (String) this.janela.getComboTipo().getSelectedItem();
        
        Veiculo modelo;
        Proprietario proprietario = (Proprietario) this.janela.getComboProprietario().getSelectedItem();
        if (idString.equals("")){
            proprietario.setNome("Sem proprietário");
            modelo = new Veiculo(proprietario, tipo, marca, modeloCarro, cor, ano, placa);
        } else {
            int id = Integer.parseInt(idString);
            modelo = new Veiculo(id, proprietario, tipo, marca, modeloCarro, cor, ano, placa);
        }
        
        return modelo;
    }

    @Override
    public Veiculo obterModeloTabela() {
        int id = (int) this.janela.getTabelaDeDados().getValueAt(this.janela.getTabelaDeDados().getSelectedRow(), 0);
        
        Veiculo modelo;
        modelo = new Veiculo(id);
        
        return modelo;
    }

    @Override
    public void preencherFormulario(Veiculo veiculo) {
        this.janela.getTxtId().setText(Integer.toString(veiculo.getId()));
        this.janela.getTxtMarca().setText(veiculo.getModelo());
        this.janela.getTxtModelo().setText(veiculo.getMarca());
        this.janela.getTxtCor().setText(veiculo.getCor());
        this.janela.getTxtPlaca().setText(veiculo.getPlaca().split(":")[0]);
        this.janela.getTxtAno().setText(veiculo.getAno());
        if (veiculo.getTipo().equals("Carro")){
            this.janela.getComboTipo().setSelectedIndex(0);
        } else {
            this.janela.getComboTipo().setSelectedIndex(1);
        } if (veiculo.getProprietario().getNome().equals("Sem proprietário")){
            this.janela.getComboProprietario().setSelectedIndex(0);
        } else {
            this.janela.getComboProprietario().setSelectedItem(veiculo.getProprietario());
        }
            
    }

    @Override
    public void preencherTabela(ArrayList<Veiculo> veiculos) {
        DefaultTableModel modeloDaTabela = (DefaultTableModel) this.janela.getTabelaDeDados().getModel();
        this.janela.getTabelaDeDados().setRowSorter(new TableRowSorter(modeloDaTabela));
        modeloDaTabela.setRowCount(0);
        
        for (Veiculo veiculo : veiculos){
            modeloDaTabela.addRow(new Object[]{
                veiculo.getId(),
                veiculo.getModelo(),
                veiculo.getMarca(),
                veiculo.getCor(),
                veiculo.getPlaca().split(":")[0]
            });
        }

    }
    
    public void atualizarComboProprietarios (ArrayList<Proprietario> proprietarios) {
        DefaultComboBoxModel modeloComboBox = (DefaultComboBoxModel) this.janela.getComboProprietario().getModel();
        
        modeloComboBox.removeAllElements();
        
        Proprietario nenhum = new Proprietario();
        nenhum.setNome("Sem proprietário");
        
        modeloComboBox.addElement(nenhum);
        
        for (Proprietario proprietario : proprietarios){
            modeloComboBox.addElement(proprietario);
        }
    }

    @Override
    public void limparTela() {
        this.janela.getTxtId().setText("");
        this.janela.getTxtMarca().setText("");
        this.janela.getTxtModelo().setText("");
        this.janela.getTxtCor().setText("");
        this.janela.getTxtPlaca().setText("");
        this.janela.getTxtAno().setText("");
        this.janela.getComboTipo().setSelectedIndex(0);
        this.janela.getComboProprietario().setSelectedIndex(0);
    }
    
}
