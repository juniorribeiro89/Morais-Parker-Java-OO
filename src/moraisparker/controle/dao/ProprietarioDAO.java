package moraisparker.controle.dao;

import java.util.ArrayList;
import moraisparker.modelos.Proprietario;


public class ProprietarioDAO implements IDAO<Proprietario> {

    @Override
    public void inserir(Proprietario proprietario) {
        proprietario.setId(this.autoIncremento());
        Banco.proprietarios.add(proprietario);
    }

    @Override
    public boolean alterar(Proprietario proprietario) {
        for (int i = 0; i < Banco.proprietarios.size(); i++) {
            if(idSaoIguais(Banco.proprietarios.get(i),proprietario)){
                Banco.proprietarios.set(i, proprietario);
                return true;
            }
        }
        return false;         
    }

    @Override
    public boolean excluir(Proprietario proprietario) {
        for (Proprietario proprietarioLista : Banco.proprietarios) {
            if(idSaoIguais(proprietarioLista, proprietario)){
                Banco.proprietarios.remove(proprietarioLista);
                return true;
            }
        }
        return false;        
    }

    @Override
    public ArrayList<Proprietario> listarTodos() {
        return Banco.proprietarios;
    }

    @Override
    public boolean idSaoIguais(Proprietario proprietario, Proprietario proprietarioAComparar) {
        return proprietario.getId() ==  proprietarioAComparar.getId();
    }

    @Override
    public int autoIncremento() {
        return this.listarTodos().get(this.listarTodos().size()-1).getId()+1;
    }

    @Override
    public Proprietario buscaPorId(int id) {
        Proprietario proprietarioARetornar = new Proprietario();
        for (Proprietario proprietarioLista : this.listarTodos()){           
            if (proprietarioLista.getId()==id){
                System.out.println(proprietarioLista);
                proprietarioARetornar = proprietarioLista; break;
            } 
        }
        return proprietarioARetornar;
    }
    
}
