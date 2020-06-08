package moraisparker.controle.helpers;

import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import moraisparker.modelos.Funcionario;
import moraisparker.modelos.Ocorrencia;
import moraisparker.visao.formularios.FormOcorrencia;


public class OcorrenciaHelper implements IHelper<Ocorrencia>{

    private final FormOcorrencia janela;

    public OcorrenciaHelper(FormOcorrencia janela) {
        this.janela = janela;
    }

    @Override
    public void preencherTabela(ArrayList<Ocorrencia> ocorrencias) {
        
        DefaultTableModel modeloDaTabela = (DefaultTableModel) this.janela.getTabelaDeDados().getModel();
        this.janela.getTabelaDeDados().setRowSorter(new TableRowSorter(modeloDaTabela));
        modeloDaTabela.setNumRows(0);
        
        for (Ocorrencia ocorrencia : ocorrencias){
            modeloDaTabela.addRow(new Object[]{
                ocorrencia.getId(),
                ocorrencia.getTitulo(),
                ocorrencia.getDataDaOcorrencia(),
                ocorrencia.getFuncionarioQueRegistrou()
            });
        }
        
    }

    @Override
    public Ocorrencia obterModeloFormulario() {
        
        String idString = this.janela.getTxtId().getText();
        String dataDaOcorrencia = this.janela.getTxtDataOcorrencia().getText();
        String titulo = this.janela.getTxtTitulo().getText();
        String descricao = this.janela.getTextRelato().getText();
        Funcionario funcionarioAutenticado = this.janela.getFuncionario();

        
        Ocorrencia modelo = new Ocorrencia();
        
        if (idString.equals("")){
            modelo = new Ocorrencia(dataDaOcorrencia, titulo, descricao, funcionarioAutenticado);
        } else {
            int id = Integer.parseInt(idString);
            Funcionario funcionario = (Funcionario) this.janela.getComboBoxFuncionarios().getSelectedItem();
            modelo = new Ocorrencia(id, dataDaOcorrencia, titulo, descricao, funcionario);
        }

        return modelo;
    }
    
    @Override
    public Ocorrencia obterModeloTabela() {
        
        int id = (int) this.janela.getTabelaDeDados().getValueAt(this.janela.getTabelaDeDados().getSelectedRow(), 0);

        
        Ocorrencia modelo = new Ocorrencia();
        modelo = new Ocorrencia(id);
        

        return modelo;
    }

    @Override
    public void limparTela() {
        this.janela.getTxtId().setText("");
        this.janela.getTextRelato().setText("");
        this.janela.getTxtTitulo().setText("");
        this.janela.getTxtDataOcorrencia().setText("");
        this.janela.getComboBoxFuncionarios().setSelectedItem(this.janela.getFuncionario());

    }

    @Override
    public void preencherFormulario(Ocorrencia ocorrencia) {
        String id = Integer.toString(ocorrencia.getId());
        this.janela.getTxtId().setText(id);
        this.janela.getTextRelato().setText(ocorrencia.getDescricao());
        this.janela.getTxtTitulo().setText(ocorrencia.getTitulo());
        this.janela.getTxtDataOcorrencia().setText(ocorrencia.getDataDaOcorrencia());
        this.janela.getComboBoxFuncionarios().setSelectedItem(ocorrencia.getFuncionarioQueRegistrou());
    }

    public void preencherComboFuncionarios(ArrayList<Funcionario> funcionarios) {
        DefaultComboBoxModel comboBoxFuncionarios = (DefaultComboBoxModel) this.janela.getComboBoxFuncionarios().getModel();
        
        comboBoxFuncionarios.removeAllElements();
        
        for(Funcionario funcionario : funcionarios){
            comboBoxFuncionarios.addElement(funcionario);
        }
        if (this.janela.getTxtId().getText().equals("")){
            comboBoxFuncionarios.setSelectedItem(this.janela.getFuncionario());
        }
    }
    
}
