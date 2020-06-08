package moraisparker.controle.helpers;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import moraisparker.modelos.Proprietario;
import moraisparker.visao.formularios.FormProprietario;


public class ProprietarioHelper implements IHelper<Proprietario>{

    private final FormProprietario janela;

    public ProprietarioHelper(FormProprietario janela) {
        this.janela = janela;
    }

    @Override
    public void preencherTabela(ArrayList<Proprietario> proprietarios) {
        
        DefaultTableModel modeloDaTabela = (DefaultTableModel) this.janela.getTabelaDeDados().getModel();
        this.janela.getTabelaDeDados().setRowSorter(new TableRowSorter(modeloDaTabela));
        modeloDaTabela.setNumRows(0);
        
        for (Proprietario proprietario : proprietarios){
            modeloDaTabela.addRow(new Object[]{
                proprietario.getId(),
                proprietario.getNome(),
                proprietario.getCpf(),
                proprietario.getDataNascimento()
            });
        }
        
    }

    @Override
    public Proprietario obterModeloFormulario() {
        
        String idString = this.janela.getTxtId().getText();
        String nome = this.janela.getTxtNome().getText();
        String cpf = this.janela.getTxtCpf().getText();
        String nascimento = this.janela.getTxtNascimento().getText();
        
        Proprietario modelo;
        
        if (idString.equals("")){
            modelo = new Proprietario(nome, cpf, nascimento);
        } else {
            int id = Integer.parseInt(idString);
            modelo = new Proprietario(id, nome, cpf, nascimento);
        }

        return modelo;
    }
    
    @Override
    public Proprietario obterModeloTabela() {
        
        int id = (int) this.janela.getTabelaDeDados().getValueAt(this.janela.getTabelaDeDados().getSelectedRow(), 0);
        
        Proprietario modelo;
        modelo = new Proprietario(id);
        

        return modelo;
    }

    @Override
    public void limparTela() {
        this.janela.getTxtId().setText("");
        this.janela.getTxtNome().setText("");
        this.janela.getTxtCpf().setText("");
        this.janela.getTxtNascimento().setText("");
    }

    @Override
    public void preencherFormulario(Proprietario proprietario) {
        String id = Integer.toString(proprietario.getId());
        this.janela.getTxtId().setText(id);
        this.janela.getTxtNome().setText(proprietario.getNome());
        this.janela.getTxtCpf().setText(proprietario.getCpf());
        this.janela.getTxtNascimento().setText(proprietario.getDataNascimento());
    }
    
}
