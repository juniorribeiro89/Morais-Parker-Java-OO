package moraisparker.controle.dao;

import java.util.ArrayList;
import moraisparker.modelos.Ocorrencia;


public class OcorrenciaDAO implements IDAO<Ocorrencia> {

    @Override
    public void inserir(Ocorrencia ocorrencia) {
        ocorrencia.setId(this.autoIncremento());
        Banco.ocorrencias.add(ocorrencia);
    }

    @Override
    public boolean alterar(Ocorrencia ocorrencia) {
        for (int i = 0; i < Banco.ocorrencias.size(); i++) {
            if(idSaoIguais(Banco.ocorrencias.get(i),ocorrencia)){
                Banco.ocorrencias.set(i, ocorrencia);
                return true;
            }
        }
        return false;         
    }

    @Override
    public boolean excluir(Ocorrencia ocorrencia) {
        for (Ocorrencia ocorrenciaLista : Banco.ocorrencias) {
            if(idSaoIguais(ocorrenciaLista, ocorrencia)){
                Banco.ocorrencias.remove(ocorrenciaLista);
                return true;
            }
        }
        return false;        
    }

    @Override
    public ArrayList<Ocorrencia> listarTodos() {
        return Banco.ocorrencias;
    }

    @Override
    public boolean idSaoIguais(Ocorrencia ocorrencia, Ocorrencia ocorrenciaAComparar) {
        return ocorrencia.getId() ==  ocorrenciaAComparar.getId();
    }

    @Override
    public int autoIncremento() {
        return this.listarTodos().get(this.listarTodos().size()-1).getId()+1;
    }

    @Override
    public Ocorrencia buscaPorId(int id) {
        Ocorrencia ocorrenciaARetornar = new Ocorrencia();
        for (Ocorrencia ocorrenciaLista : this.listarTodos()){           
            if (ocorrenciaLista.getId()==id){
                System.out.println(ocorrenciaLista);
                ocorrenciaARetornar = ocorrenciaLista; break;
            } 
        }
        return ocorrenciaARetornar;
    }
    
}
