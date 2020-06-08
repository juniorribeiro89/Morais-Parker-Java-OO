package moraisparker.controle.dao;

import java.util.ArrayList;
import moraisparker.modelos.Estacionamento;


public class EstacionamentoDAO implements IDAO<Estacionamento> {

    @Override
    public void inserir(Estacionamento estacionamento) {
        estacionamento.setId(this.autoIncremento());
        Banco.estacionamentos.add(estacionamento);
    }

    @Override
    public boolean alterar(Estacionamento estacionamento) {
        for (int i = 0; i < Banco.estacionamentos.size(); i++) {
            if(idSaoIguais(Banco.estacionamentos.get(i),estacionamento)){
                Banco.estacionamentos.set(i, estacionamento);
                return true;
            }
        }
        return false;         
    }

    @Override
    public boolean excluir(Estacionamento estacionamento) {
        for (Estacionamento estacionamentoLista : Banco.estacionamentos) {
            if(idSaoIguais(estacionamentoLista, estacionamento)){
                Banco.estacionamentos.remove(estacionamentoLista);
                return true;
            }
        }
        return false;        
    }

    @Override
    public ArrayList<Estacionamento> listarTodos() {
        return Banco.estacionamentos;
    }

    @Override
    public boolean idSaoIguais(Estacionamento estacionamento, Estacionamento estacionamentoAComparar) {
        return estacionamento.getId() ==  estacionamentoAComparar.getId();
    }

    @Override
    public int autoIncremento() {
        return this.listarTodos().get(this.listarTodos().size()-1).getId()+1;
    }

    @Override
    public Estacionamento buscaPorId(int id) {
        Estacionamento estacionamentoARetornar = new Estacionamento();
        for (Estacionamento estacionamentoLista : this.listarTodos()){           
            if (estacionamentoLista.getId()==id){
                System.out.println(estacionamentoLista);
                estacionamentoARetornar = estacionamentoLista; break;
            } 
        }
        return estacionamentoARetornar;
    }

    public Estacionamento selecionePorNome(Estacionamento estacionamento) {
        for (Estacionamento estacionamentoLista : Banco.estacionamentos){
            if (nomeIgual(estacionamentoLista, estacionamento)){
                estacionamentoLista.getVeiculos().add(estacionamento.getVeiculos().get(0));
                return estacionamentoLista;
            }
        }
        return null;
    }
    //As funções selecionePorNomeESenha e nomeESenhaSaoIguais serão usadas para Login no Sistema
    
    private boolean nomeIgual(Estacionamento estacionamento, Estacionamento estacionamentoAPesquisar) {
        return estacionamento.getNome().equals(estacionamentoAPesquisar.getNome());
    }
    
}
