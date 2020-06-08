package moraisparker.controle.dao;

import java.util.ArrayList;
import moraisparker.modelos.Veiculo;


public class VeiculoDAO implements IDAO<Veiculo> {

    @Override
    public void inserir(Veiculo veiculo) {
        veiculo.setId(this.autoIncremento());
        Banco.veiculos.add(veiculo);
    }

    @Override
    public boolean alterar(Veiculo veiculo) {
        for (int i = 0; i < Banco.veiculos.size(); i++) {
            if(idSaoIguais(Banco.veiculos.get(i),veiculo)){
                Banco.veiculos.set(i, veiculo);
                return true;
            }
        }
        return false;         
    }

    @Override
    public boolean excluir(Veiculo veiculo) {
        for (Veiculo veiculoLista : Banco.veiculos) {
            if(idSaoIguais(veiculoLista, veiculo)){
                Banco.veiculos.remove(veiculoLista);
                return true;
            }
        }
        return false;        
    }

    @Override
    public ArrayList<Veiculo> listarTodos() {
        return Banco.veiculos;
    }

    @Override
    public boolean idSaoIguais(Veiculo veiculo, Veiculo veiculoAComparar) {
        return veiculo.getId() ==  veiculoAComparar.getId();
    }

    @Override
    public int autoIncremento() {
        return this.listarTodos().get(this.listarTodos().size()-1).getId()+1;
    }

    @Override
    public Veiculo buscaPorId(int id) {
        Veiculo veiculoARetornar = new Veiculo();
        for (Veiculo veiculoLista : this.listarTodos()){           
            if (veiculoLista.getId()==id){
                System.out.println(veiculoLista);
                veiculoARetornar = veiculoLista; break;
            } 
        }
        return veiculoARetornar;
    }
    
}
