package bd.daos;
import java.sql.*;
import bd.*;
import bd.core.*;
import bd.dbos.*;

/**A classe Doacoes � uma DAO e serve para executar a��es na
tabela HDoacoes, como saber se essa doa��o existe,
excluir uma doa��o, etc.
Nela encontramos v�rios metodos que modificam/verificam informa��es
na tabela HDoacoes
@author Giovanna Pavani Martelli.
@author Maria Luiza Sperancin Mancebo.
@since 2019.*/


public class Doacoes {


	/**
			 Verificador de cadastramento por codigo
			 Verifica se o codigo passado no parametro j� existe na
			 tabela HDoacoes, se sim, retorna true, se n�o achar nenhum, retorna false
			 @return se achar true, se n�o, false
			 @param id a ser procurado
		     @throws Exception caso n�o recupere as doa��es
	 */
	public static boolean cadastrado(int id) throws Exception
    {
        boolean retorno = false;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM HDOACOES " +
                  "WHERE ID = ?";

            BDSQLServer.COMANDO.prepareStatement(sql);

            BDSQLServer.COMANDO.setInt(1, id);

            MeuResultSet resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery();

            retorno = resultado.first(); // pode-se usar resultado.last() ou resultado.next() ou resultado.previous() ou resultado.absotule(numeroDaLinha)
        }
        catch (SQLException erro)
        {
            throw new Exception("Erro ao procurar doacao");
        }

        return retorno;
    }
/*
    public static boolean existe(int id)
    {
        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM HDOACOES " +
                  "WHERE ID = ?";

            BDSQLServer.COMANDO.prepareStatement(sql);
            BDSQLServer.COMANDO.setInt(1, id);
            BDSQLServer.COMANDO.executeQuery();
        }
        catch (SQLException erro)
        {
            return false;
        }
        return true;
    }
*/

	/**
		  Inclui Doacoes
		  Verifica se a doa��o passada n�o � nula, e em seguida
		  inserta ela na tabela.
		  @param doacao a ser inserida
		  @throws Exception caso a doa��o n�o seja fornecida no par�metro
	 */
    public static void incluir(Doacao doacao) throws Exception
    {
        if (doacao==null)
            throw new Exception("Doacao n�o fornecida");

        try
        {
            String sql;

            sql = "INSERT INTO HDOACOES " +
                  "(ID, CODPESSOA, PRODUTO, CODENTIDADE, DATA, ENTREGUE, QUANTIDADE) " +
                  "VALUES " +
                  "(?,?,?,?,?,?,?)";

            BDSQLServer.COMANDO.prepareStatement(sql);

            BDSQLServer.COMANDO.setInt    (1, doacao.getId());
            BDSQLServer.COMANDO.setInt    (2, doacao.getCodPessoa());
            BDSQLServer.COMANDO.setString (3, doacao.getProduto());
            BDSQLServer.COMANDO.setInt    (4, doacao.getCodEntidade());
            BDSQLServer.COMANDO.setDate   (5, doacao.getData());
            BDSQLServer.COMANDO.setString (6, doacao.getEntregue()+"");
		    BDSQLServer.COMANDO.setString (7, doacao.getQuantidade());


            BDSQLServer.COMANDO.executeUpdate(); // executa o comando, todos s�o executados como "update" - atualiza o banco, menos select / tipo uma fun��o void
            BDSQLServer.COMANDO.commit       (); // USAR APENAS se for insert, delete e update --> O RESTO N PRECISA // efetiva ex: funcionario e dependentes - transa��o, se n, o banco n fica consistente - tudo ou nada
        }
        catch (SQLException erro)
        {
        	//se for um monte de comandos (tudo ou nd) e um der errado, tem q excluir td
        	//BDSQLServer.COMANDO.rollback(); --> desfaz o commit / oposto do commit
        	// transa��o = conjunto de comandos q s�o tudo ou nada
            throw new Exception ("Erro ao inserir pessoa");
        }
    }

 	/**
		  Exclui doacoes pelo id
		  Verifica se o id pertence a alguma doacao, e em seguida, caso exista,
		  exclui ela da tabela.
		  @param id a ser excluido
		  @throws Exception caso n�o encontre uma doa��o com o id informado
	 */
    public static void excluir(int id) throws Exception
    {
        if (!cadastrado(id))
            throw new Exception("Nao cadastrada");

        try
        {
            String sql;

            sql = "DELETE FROM HDOACOES " +
                  "WHERE ID=?";

            BDSQLServer.COMANDO.prepareStatement(sql);

            BDSQLServer.COMANDO.setInt(1, id);

            BDSQLServer.COMANDO.executeUpdate();
            BDSQLServer.COMANDO.commit       ();
        }
        catch (SQLException erro)
        {
            throw new Exception("Erro ao excluir doacao");
        }
    }


	/**
		  Altera doa��es
		  � passado uma doa��o no par�metro, que depois de verificar se ela � null ou se n�o foi
		  cadastrada ainda,e da um update na tabela HPDoacoes nessa doa��o
		   @param doa��o a ser alterada
		   @throws Exception caso for nula ou n�o estiver cadastrada
	 */
    public static void alterar(Doacao doacao) throws Exception
    {
        if (doacao==null)
            throw new Exception ("Doacao nao fornecida");

        if (!cadastrado(doacao.getId()))
            throw new Exception("Nao cadastrada");

        try
        {
            String sql;

            sql = "UPDATE HDOACOES " +
                  "SET CODPESSOA=?, " +
                  "PRODUTO=?, " +
				  "CODENTIDADE=?, " +
				  "DATA=?, " +
				  "ENTREGUE=?, " +
				  "QUANTIDADE=? " +
            	  "WHERE ID = ?";

            BDSQLServer.COMANDO.prepareStatement (sql);

            BDSQLServer.COMANDO.setInt    (1, doacao.getCodPessoa());
            BDSQLServer.COMANDO.setString (2, doacao.getProduto());
            BDSQLServer.COMANDO.setInt    (3, doacao.getCodEntidade());
            BDSQLServer.COMANDO.setDate   (4, doacao.getData());
            BDSQLServer.COMANDO.setString (5, doacao.getEntregue()+"");
		    BDSQLServer.COMANDO.setString (6, doacao.getQuantidade());
		    BDSQLServer.COMANDO.setInt    (7, doacao.getId());

            BDSQLServer.COMANDO.executeUpdate();
            BDSQLServer.COMANDO.commit       ();
        }
        catch (SQLException erro)
        {
            throw new Exception("Erro ao atualizar dados de doacao");
        }
    }


	/**
			  Pega todas as informa��es dobre uma doa��o
			  Seleciona na tabela tudo sobre a doa��o pelo id que foi passado no par�metro.
			  @return a entidade encontrada
			  @param id a ser procurado
		     @throws Exception caso o id n�o esteja cadastrado
	 */
    public static Doacao getDoacao(int id) throws Exception
    {
        Doacao doacao = null;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM HDOACOES " +
                  "WHERE ID = ?";

            BDSQLServer.COMANDO.prepareStatement(sql);

            BDSQLServer.COMANDO.setInt(1, id);

            MeuResultSet resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery ();

            if (!resultado.first())
                throw new Exception ("Nao cadastrado");

            doacao = new Doacao(resultado.getInt   ("ID"),
                                resultado.getInt   ("CODPESSOA"), // como q ele sb qual ie string eh?
                                resultado.getString("PRODUTO"),
                                resultado.getInt   ("CODENTIDADE"),
						        resultado.getDate  ("DATA"),
						        resultado.getString("ENTREGUE").charAt(0),
						        resultado.getString("QUANTIDADE")
            					);
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao procurar doacao");
        }

        return doacao;
    }

	/**
		  Pega a doa��o e a sua respectiva entidade
		  Seleciona todas as doa��es feitas a todas as entidades, colocando
		  em um resultSet
		  @return resultset de doacoes
		  @throws Exception caso n�o recupere as doa��es
	 */

    public static MeuResultSet getDoacoes () throws Exception
    {
        MeuResultSet resultado = null;

        try
        {
            String sql;

            sql = "SELECT ID, PRODUTO, QUANTIDADE, E.NOME, DATA, ENTREGUE " +
                  "FROM HDOACOES D, HENTIDADES E " +
                  "WHERE E.CODIGO = D.CODENTIDADE";

            BDSQLServer.COMANDO.prepareStatement (sql);

            resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery ();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao recuperar doacoes");
        }

        return resultado;
    }
}
