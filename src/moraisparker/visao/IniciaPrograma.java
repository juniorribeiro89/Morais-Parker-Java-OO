package moraisparker.visao;

import moraisparker.controle.dao.Banco;

/**
 * Classe responsável pela inicialização do programa
 */
public class IniciaPrograma {
    
    /**
     * A função main ela inicia o banco de Dados através da função iniciaBanco da classe Banco
     * e constrói uma View do tipo JFrame
     */
    public static void main(String[] args) {
        //Carregando os dados iniciais num banco de dados de ArrayList's
        Banco.iniciaBanco();
        //Construção do JFrame janelaDeLogin
        new JanelaDeLogin().setVisible(true);
    }
    
}
