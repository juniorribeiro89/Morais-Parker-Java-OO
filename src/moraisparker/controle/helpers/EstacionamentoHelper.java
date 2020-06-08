package moraisparker.controle.helpers;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import moraisparker.modelos.Estacionamento;
import moraisparker.visao.formularios.FormEstacionamento;


public class EstacionamentoHelper implements IHelper<Estacionamento>{

    private final FormEstacionamento janela;

    public EstacionamentoHelper(FormEstacionamento janela) {
        this.janela = janela;
    }

    @Override
    public void preencherTabela(ArrayList<Estacionamento> estacionamentos) {
        
        DefaultTableModel modeloDaTabela = (DefaultTableModel) this.janela.getTabelaDeDados().getModel();
        
        this.janela.getTabelaDeDados().setRowSorter(new TableRowSorter(modeloDaTabela));
        modeloDaTabela.setNumRows(0);
        
        for (Estacionamento estacionamento : estacionamentos){
            modeloDaTabela.addRow(new Object[]{
                estacionamento.getId(),
                estacionamento.getNome(),
                estacionamento.getCapacidade(),
                (estacionamento.isAtivo())?"Sim":"Não"
            });
        }
        
    }

    @Override
    public Estacionamento obterModeloFormulario() {
        
        String idString = this.janela.getTxtId().getText();
        String nome = this.janela.getTxtNome().getText();
        int capacidade = Integer.parseInt(this.janela.getTxtCapacidade().getText());
        boolean ativo = this.janela.getCheckBoxFuncionando().isSelected();
        System.out.println("ativo ::: "+ativo);
        
        Estacionamento modelo;
        
        if (idString.equals("")){
            modelo = new Estacionamento(capacidade, nome, ativo);
        } else {
            int id = Integer.parseInt(idString);
            modelo = new Estacionamento(id, capacidade, nome, ativo);
        }

        return modelo;
    }
    
    @Override
    public Estacionamento obterModeloTabela() {
        
        int id = (int) this.janela.getTabelaDeDados().getValueAt(this.janela.getTabelaDeDados().getSelectedRow(), 0);
        
        Estacionamento modelo;
        modelo = new Estacionamento(id);
        
        return modelo;
    }

    @Override
    public void limparTela() {
        this.janela.getTxtId().setText("");
        this.janela.getTxtNome().setText("");
        this.janela.getTxtCapacidade().setText("");
        this.janela.getCheckBoxFuncionando().setSelected(false);
    }

    @Override
    public void preencherFormulario(Estacionamento estacionamento) {
        String id = Integer.toString(estacionamento.getId());
        String capacidade = Integer.toString(estacionamento.getCapacidade());
        this.janela.getTxtId().setText(id);
        this.janela.getTxtNome().setText(estacionamento.getNome());
        this.janela.getTxtCapacidade().setText(capacidade);
        this.janela.getCheckBoxFuncionando().setSelected(estacionamento.isAtivo());
    }
    
}
