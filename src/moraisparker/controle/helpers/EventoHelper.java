package moraisparker.controle.helpers;

import java.util.ArrayList;
import java.util.Vector;
import javax.swing.DefaultListModel;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import moraisparker.modelos.Estacionamento;
import moraisparker.modelos.Evento;
import moraisparker.visao.formularios.FormEvento;


public class EventoHelper implements IHelper<Evento>{

    private final FormEvento janela;

    public EventoHelper(FormEvento janela) {
        this.janela = janela;
    }

    @Override
    public void preencherTabela(ArrayList<Evento> eventos) {
        
        DefaultTableModel modeloDaTabela = (DefaultTableModel) this.janela.getTabelaDeDados().getModel();
        this.janela.getTabelaDeDados().setRowSorter(new TableRowSorter(modeloDaTabela));
        modeloDaTabela.setNumRows(0);
        
        for (Evento evento : eventos){
            modeloDaTabela.addRow(new Object[]{
                evento.getId(),
                evento.getNomeDoEvento(),
                evento.getInicioDoEvento(),
                evento.getFinalDoEvento()
            });
        }
        
    }

    @Override
    public Evento obterModeloFormulario() {
        
        String idString = this.janela.getTxtId().getText();
        String nome = this.janela.getTxtNome().getText();
        String inicio = this.janela.getTxtInicioEvento().getText();
        String termino = this.janela.getTxtFinalEvento().getText();
        Object[] elementos;
        elementos =  this.janela.getListaEstacionamentos().getSelectedValues();
        ArrayList<Estacionamento> estacionamentos = new ArrayList<>();
                
        for (Object object : elementos){
            Estacionamento estacionamento = (Estacionamento) object;
            estacionamentos.add(estacionamento);
        }
        
        Evento modelo;
        
        if (idString.equals("")){
            modelo = new Evento(nome, inicio, termino, estacionamentos);
        } else {
            int id = Integer.parseInt(idString);
            modelo = new Evento(id, nome, inicio, termino, estacionamentos);
        }
        
        return modelo;
    }
    
    @Override
    public Evento obterModeloTabela() {
        
        int id = (int) this.janela.getTabelaDeDados().getValueAt(this.janela.getTabelaDeDados().getSelectedRow(), 0);
        
        Evento modelo;        
        modelo = new Evento(id);
        
        return modelo;
    }

    @Override
    public void limparTela() {
        this.janela.getTxtId().setText("");
        this.janela.getTxtNome().setText("");
        this.janela.getTxtInicioEvento().setText("");
        this.janela.getTxtFinalEvento().setText("");
        this.janela.getListaEstacionamentos().clearSelection();
    }

    @Override
    public void preencherFormulario(Evento evento) {
        String id = Integer.toString(evento.getId());
        this.janela.getTxtId().setText(id);
        this.janela.getTxtNome().setText(evento.getNomeDoEvento());
        this.janela.getTxtInicioEvento().setText(evento.getInicioDoEvento());
        this.janela.getTxtFinalEvento().setText(evento.getFinalDoEvento());
        

        
        DefaultListModel modelo = (DefaultListModel) this.janela.getListaEstacionamentos().getModel();
        int[] indices = new int[evento.getAreasUsadas().size()];
        int contador = 0;
        
        for(Estacionamento estacionamento : evento.getAreasUsadas()){
            for (int i=0; i< modelo.getSize(); i++){
                if(estacionamento.equals(modelo.getElementAt(i))){
                    indices[contador++]=i;
                }
            }
        }
        
        this.janela.getListaEstacionamentos().setSelectedIndices(indices);

    }
    

    public void preencherListaDeEstacionamentos(ArrayList<Estacionamento> estacionamentos){
        DefaultListModel modelo = new DefaultListModel();
        
        modelo.removeAllElements();
        //this.janela.getListaEstacionamentos().setModel(modelo);
        
        for (int i=0; i < estacionamentos.size(); i++){
            modelo.add(i,estacionamentos.get(i));
        }
                
        this.janela.getListaEstacionamentos().setModel(modelo);
    }
    
}
