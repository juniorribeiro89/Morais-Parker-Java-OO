package moraisparker.controle.dao;

import java.util.ArrayList;
import moraisparker.modelos.Evento;


public class EventoDAO implements IDAO<Evento> {

    @Override
    public void inserir(Evento evento) {
        evento.setId(this.autoIncremento());
        Banco.eventos.add(evento);
    }

    @Override
    public boolean alterar(Evento evento) {
        for (int i = 0; i < Banco.eventos.size(); i++) {
            if(idSaoIguais(Banco.eventos.get(i),evento)){
                Banco.eventos.set(i, evento);
                return true;
            }
        }
        return false;         
    }

    @Override
    public boolean excluir(Evento evento) {
        for (Evento eventoLista : Banco.eventos) {
            if(idSaoIguais(eventoLista, evento)){
                Banco.eventos.remove(eventoLista);
                return true;
            }
        }
        return false;        
    }

    @Override
    public ArrayList<Evento> listarTodos() {
        return Banco.eventos;
    }

    @Override
    public boolean idSaoIguais(Evento evento, Evento eventoAComparar) {
        return evento.getId() ==  eventoAComparar.getId();
    }

    @Override
    public int autoIncremento() {
        return this.listarTodos().get(this.listarTodos().size()-1).getId()+1;
    }

    @Override
    public Evento buscaPorId(int id) {
        Evento eventoARetornar = new Evento();
        for (Evento eventoLista : this.listarTodos()){           
            if (eventoLista.getId()==id){
                System.out.println(eventoLista);
                eventoARetornar = eventoLista; break;
            } 
        }
        return eventoARetornar;
    }
    
}
