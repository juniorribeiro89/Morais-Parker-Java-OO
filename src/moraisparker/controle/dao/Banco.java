package moraisparker.controle.dao;

import java.util.ArrayList;
import moraisparker.modelos.Estacionamento;
import moraisparker.modelos.Evento;
import moraisparker.modelos.Funcionario;
import moraisparker.modelos.Ocorrencia;
import moraisparker.modelos.Proprietario;
import moraisparker.modelos.Usuario;
import moraisparker.modelos.Veiculo;

/**
 * Classe Banco é responsável pela criação de um banco de dados com ArrayList's
 * @param estacionamentos ArrayList do tipo Estacionamento
 * @param eventos ArrayList do tipo Evento
 * @param funcionarios ArrayList do tipo Funcionario
 * @param ocorrencias ArrayList do tipo Ocorrencia
 * @param proprietarios ArrayList do tipo Proprietario
 * @param veiculos ArrayList do tipo Veiculo
 */
public class Banco {
    
    //Listas para armazenar os modelos usados no sistema
    public static ArrayList<Estacionamento> estacionamentos;
    public static ArrayList<Evento>         eventos;
    public static ArrayList<Funcionario>    funcionarios;
    public static ArrayList<Ocorrencia>     ocorrencias;
    public static ArrayList<Proprietario>   proprietarios;
    public static ArrayList<Veiculo>        veiculos;
    
    /**
     * A função cria diversos modelos e armazena-os em seus devidos ArrayList's
     */
    public static void iniciaBanco(){
        
        //Inicialização dos ArrayList's da Classe
        estacionamentos = new ArrayList<>();
        eventos = new ArrayList<>();
        funcionarios = new ArrayList<>();
        ocorrencias = new ArrayList<>();
        proprietarios = new ArrayList<>();
        veiculos = new ArrayList<>();
        
        //Criação de 3 estacionamentos 
        Estacionamento estacionamentoA = new Estacionamento(0, 50, "Bloco A");
        Estacionamento estacionamentoB = new Estacionamento(1, 75, "Bloco B");
        Estacionamento estacionamentoC = new Estacionamento(2, 25, "Bloco C");
        
        //Criação de 2 Eventos
        Evento eventoA = new Evento(0, "Evento A", "31/12/2020", "01/01/2021");
        Evento eventoB = new Evento(1, "Evento B", "01/05/2020", "02/05/2020");

        //Criação de 4 Tipos de Funcionários seguidos da atribuição de um usuário para cada
        Funcionario admin  = new Funcionario(0, "ADMIN", "0000.000.0000","Administrador", "000.000.000-00", "00/00/0000");
        admin.getUsuario().setUsuario("admin");
        admin.getUsuario().setSenha("123456");
        Funcionario gestor = new Funcionario(1, "GESTOR",  "0000.011.0001","Gestor de Estacionamento", "000.000.000-00", "00/01/0000");
        gestor.getUsuario().setUsuario("gestor");
        gestor.getUsuario().setSenha("123456");
        Funcionario comum  = new Funcionario(2, "COMUM",  "0000.220.0001","Funcionario do Estacionamento", "000.000.000-00", "00/02/0000");
        comum.getUsuario().setUsuario("comum");
        comum.getUsuario().setSenha("123456");
        Funcionario rh     = new Funcionario(3, "RH",  "0000.303.0001","Recursos Humanos", "000.000.000-00", "00-03-0000");
        rh.getUsuario().setUsuario("rh");
        rh.getUsuario().setSenha("123456");
        
        //Criar 3 Ocorrência
        Ocorrencia ocorrencia = new Ocorrencia(0, "01/01/2021", "Titulo" ,"dedasdasdsascrição", comum);
        Ocorrencia ocorrencia1 = new Ocorrencia(1, "01/01/2021", "Batida" ,"dedasdsdfsfdsfsdfsdfsdasdsascrição", gestor);
        Ocorrencia ocorrencia2 = new Ocorrencia(2, "01/01/2021", "Arranhão" ,"dedafdsfsdsdasdsascrição", comum);
        
        //Criar 6 proprietarios
        Proprietario proprietario0 = new Proprietario(0, "João", "000.000.000-01", "01/01/1989");
        Proprietario proprietario1 = new Proprietario(1, "José", "000.000.000-02", "02/01/1989");
        Proprietario proprietario2 = new Proprietario(2, "Antônio", "000.000.003-00", "03/01/1989");
        Proprietario proprietario3 = new Proprietario(3, "Pedro", "000.000.000-40", "04/01/1989");
        Proprietario proprietario4 = new Proprietario(4, "Carlos", "000.000.000-50", "05/01/1989");
        Proprietario proprietario5 = new Proprietario(5, "Silva", "000.000.000-06", "06/01/1989");
        
        //Criar 6 veiculos
        Veiculo veiculo0 = new Veiculo(0, proprietario0, "Carro", "Chevrolet", "Onix", "Branco", "2015", "AAA-0000:Cidade-UF");
        Veiculo veiculo1 = new Veiculo(1, proprietario1, "Carro", "Ford", "Ka", "Branco", "2016", "BBB-0000:Cidade-UF");
        Veiculo veiculo2 = new Veiculo(2, proprietario2, "moto", "Honda", "Fan", "Branco", "2017", "CCC-0000:Cidade-UF");
        Veiculo veiculo3 = new Veiculo(3, proprietario3, "moto", "Honda", "CG Titan", "Branco", "2018", "DDD-0000:Cidade-UF");
        Veiculo veiculo4 = new Veiculo(4, proprietario4, "moto", "Yamaha", "YBR", "Branco", "2019", "EEE-0000:Cidade-UF");
        Veiculo veiculo5 = new Veiculo(5, proprietario5, "moto", "Honda", "Fan", "Branco", "2020", "FFF-0000:Cidade-UF");
        
        //Adicionar os elementos a suas respectivas listas
        estacionamentos.add(estacionamentoA);
        estacionamentos.add(estacionamentoB);
        estacionamentos.add(estacionamentoC);
        
        eventos.add(eventoA);
        eventos.add(eventoB);
        
        funcionarios.add(admin);
        funcionarios.add(gestor);
        funcionarios.add(comum);
        funcionarios.add(rh);
        
        ocorrencias.add(ocorrencia);
        ocorrencias.add(ocorrencia1);
        ocorrencias.add(ocorrencia2);

        proprietarios.add(proprietario0);        
        proprietarios.add(proprietario1);
        proprietarios.add(proprietario2);
        proprietarios.add(proprietario3);
        proprietarios.add(proprietario4);
        proprietarios.add(proprietario5);

        
        veiculos.add(veiculo0);
        veiculos.add(veiculo1);
        veiculos.add(veiculo2);
        veiculos.add(veiculo3);
        veiculos.add(veiculo4);
        veiculos.add(veiculo5);
    }
    
}
