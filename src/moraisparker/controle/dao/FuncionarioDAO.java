package moraisparker.controle.dao;

import java.util.ArrayList;
import moraisparker.modelos.Funcionario;


public class FuncionarioDAO implements IDAO<Funcionario> {

    @Override
    public void inserir(Funcionario funcionario) {
        funcionario.setId(this.autoIncremento());
        Banco.funcionarios.add(funcionario);
    }

    @Override
    public boolean alterar(Funcionario funcionario) {
        for (int i = 0; i < Banco.funcionarios.size(); i++) {
            if(idSaoIguais(Banco.funcionarios.get(i),funcionario)){
                Banco.funcionarios.set(i, funcionario);
                return true;
            }
        }
        return false;         
    }

    @Override
    public boolean excluir(Funcionario funcionario) {
        for (Funcionario funcionarioLista : Banco.funcionarios) {
            if(idSaoIguais(funcionarioLista, funcionario)){
                Banco.funcionarios.remove(funcionarioLista);
                return true;
            }
        }
        return false;        
    }

    @Override
    public ArrayList<Funcionario> listarTodos() {
        return Banco.funcionarios;
    }

    @Override
    public boolean idSaoIguais(Funcionario funcionario, Funcionario funcionarioAComparar) {
        return funcionario.getId() ==  funcionarioAComparar.getId();
    }

    @Override
    public int autoIncremento() {
        return this.listarTodos().get(this.listarTodos().size()-1).getId()+1;
    }

    @Override
    public Funcionario buscaPorId(int id) {
        Funcionario funcionarioARetornar = new Funcionario();
        for (Funcionario funcionarioLista : this.listarTodos()){           
            if (funcionarioLista.getId()==id){
                System.out.println(funcionarioLista);
                funcionarioARetornar = funcionarioLista; break;
            } 
        }
        return funcionarioARetornar;
    }
    
    //As funções selecionePorNomeESenha e nomeESenhaSaoIguais serão usadas para Login no Sistema
    public Funcionario selecionePorNomeESenha(Funcionario funcionario){
        for (Funcionario funcionarioLista : Banco.funcionarios) {
            if(nomeESenhaSaoIguais(funcionarioLista,funcionario)){
                return funcionarioLista;
            }
        }
        return null;
    }
    
    private boolean nomeESenhaSaoIguais(Funcionario funcionario, Funcionario funcionarioAPesquisar) {
        return funcionario.getUsuario().getUsuario().equals(funcionarioAPesquisar.getUsuario().getUsuario()) && funcionario.getUsuario().getSenha().equals(funcionarioAPesquisar.getUsuario().getSenha());
    }
    
}
