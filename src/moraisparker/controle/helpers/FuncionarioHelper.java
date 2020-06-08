package moraisparker.controle.helpers;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import moraisparker.modelos.Funcionario;
import moraisparker.visao.formularios.FormFuncionario;


public class FuncionarioHelper implements IHelper<Funcionario>{

    private final FormFuncionario janela;

    public FuncionarioHelper(FormFuncionario janela) {
        this.janela = janela;
    }

    @Override
    public void preencherTabela(ArrayList<Funcionario> funcionarios) {
        
        DefaultTableModel modeloDaTabela = (DefaultTableModel) this.janela.getTabelaDeDados().getModel();
        this.janela.getTabelaDeDados().setRowSorter(new TableRowSorter(modeloDaTabela));
        modeloDaTabela.setNumRows(0);
        
        for (Funcionario funcionario : funcionarios){
            modeloDaTabela.addRow(new Object[]{
                funcionario.getId(),
                funcionario.getNome(),
                funcionario.getCpf(),
                funcionario.getCategoria(),
                funcionario.getMatricula()
            });
        }
        
    }

    @Override
    public Funcionario obterModeloFormulario() {
        String idString = this.janela.getTxtId().getText();
        String nome = this.janela.getTxtNome().getText();
        String cpf = this.janela.getTxtCpf().getText();
        String nascimento = this.janela.getTxtNascimento().getText();
        String categoria = (String)this.janela.getComboBoxCategoria().getSelectedItem();
        String matricula = this.janela.getTxtMatricula().getText();
        
        Funcionario modelo;
        
        if (idString.equals("")){
            modelo = new Funcionario(categoria, matricula, nome, cpf, nascimento);
            modelo.getUsuario().setUsuario(cpf);
            modelo.getUsuario().setSenha(matricula);
        } else {
            int id = Integer.parseInt(idString);
            modelo = new Funcionario(id, categoria, matricula, nome, cpf, nascimento);
        }

        return modelo;
    }
    
    @Override
    public Funcionario obterModeloTabela() {
        
        int id = (int) this.janela.getTabelaDeDados().getValueAt(this.janela.getTabelaDeDados().getSelectedRow(), 0);
        
        Funcionario modelo;
        modelo = new Funcionario(id);
                       
        return modelo;
    }

    @Override
    public void limparTela() {
        this.janela.getTxtId().setText("");
        this.janela.getTxtNome().setText("");
        this.janela.getTxtCpf().setText("");
        this.janela.getTxtNascimento().setText("");
        this.janela.getTxtMatricula().setText("");
        this.janela.getComboBoxCategoria().setSelectedIndex(0);
    }

    @Override
    public void preencherFormulario(Funcionario funcionario) {
        String id = Integer.toString(funcionario.getId());
        this.janela.getTxtId().setText(id);
        this.janela.getTxtNome().setText(funcionario.getNome());
        this.janela.getTxtCpf().setText(funcionario.getCpf());
        this.janela.getTxtNascimento().setText(funcionario.getDataNascimento());
        this.janela.getTxtMatricula().setText(funcionario.getMatricula());
        this.janela.getComboBoxCategoria().setSelectedItem(funcionario.getCategoria());
    }
    
}
