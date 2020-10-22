/**A classe Entidades � uma DAO e serve para executar a��es na
tabela HEntidades, como saber se a entidade esta cadastrada,
excluir uma entidade, etc.
Nela encontramos v�rios metodos que modificam/verificam informa��es
na tabela HEntidades e relacionadas
@author Giovanna Pavani Martelli.
@author Maria Luiza Sperancin Mancebo.
@since 2019.*/
package bd.daos;

import java.sql.*;
import bd.*;
import bd.core.*;
import bd.dbos.*;

public class Entidades
{
	/**
				 Verificador de cadastramento por codigo
				 Verifica se o codigo passado no parametro j� existe na
				 tabela HPessoas, se sim, retorna true, se n�o achar nenhum, retorna false
				 @return se achar true, se n�o, false
				 @param c�digo a ser procurado
    	         @throws Exception caso n�o ache uma entidade com o c�digo do par�metro
	 */
	public static boolean cadastrado(int codigo) throws Exception
    {
        boolean retorno = false;

        if(codigo <=0)
        	return retorno;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM HENTIDADES " +
                  "WHERE CODIGO = ?";

            BDSQLServer.COMANDO.prepareStatement(sql);
            BDSQLServer.COMANDO.setInt(1, codigo);
            MeuResultSet resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery();

            retorno = resultado.first(); // pode-se usar resultado.last() ou resultado.next() ou resultado.previous() ou resultado.absotule(numeroDaLinha)
        }
        catch (SQLException erro)
        {
            throw new Exception("Erro ao procurar entidade");
        }

        return retorno;
    }

 	/**
			  Verificador de cadastramento por usuario
			  Verifica se o usuario passado no parametro j� existe na
			  tabela HEntidades, se sim, retorna true, se n�o achar nenhum, retorna false
			  @return se achar true, se n�o, false
			  @param usuario a ser procurado
    	      @throws Exception caso o usuario do par�metro for "" ou null
		 */
    public static boolean cadastrado(String usuario) throws Exception
    {
    	if(usuario.equals("") || usuario == null)
    		throw new Exception("Usu�rio n�o fornecido");

        boolean retorno = false;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM HENTIDADES " +
                  "WHERE USUARIO = ?";

            BDSQLServer.COMANDO.prepareStatement(sql);
            BDSQLServer.COMANDO.setString(1, usuario);
            MeuResultSet resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery();

            retorno = resultado.first(); // pode-se usar resultado.last() ou resultado.next() ou resultado.previous() ou resultado.absotule(numeroDaLinha)
        }
        catch (SQLException erro)
        {
            throw new Exception("Erro ao procurar entidade");
        }

        return retorno;
    }

/*
    public static boolean existe(int codigo)
    {
        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM HENTIDADES " +
                  "WHERE CODIGO = ?";

            BDSQLServer.COMANDO.prepareStatement(sql);
            BDSQLServer.COMANDO.setInt(1, codigo);
            BDSQLServer.COMANDO.executeQuery();
        }
        catch (SQLException erro)
        {
            return false;
        }
        return true;
    }*/

    /**
			  Inclui Entidades
			  Verifica se a entidade passada n�o � nulo, e sem seguida
			  inserta ela na tabela.
			  @param Entidade a ser procurada
    	      @throws Exception caso o par�metro for nulo
	 */

    public static void incluir(Entidade entidade) throws Exception
    {
        if (entidade==null)
            throw new Exception("Entidade n�o fornecida");

        try
        {
            String sql;

            sql = "INSERT INTO HENTIDADES " +
                  "VALUES" +
                  "(?,?,?,?,?,?,?,?,?,?,?,?)"; // guarda o lugar para dps a gnt colocar uma variavel

            BDSQLServer.COMANDO.prepareStatement(sql);

            //substituir as '?'
            BDSQLServer.COMANDO.setInt    (1, entidade.getCodigo());
            BDSQLServer.COMANDO.setString (2, entidade.getNome());
		    BDSQLServer.COMANDO.setString (3, entidade.getCnpj());
		    BDSQLServer.COMANDO.setString (4, entidade.getEndereco());
		    BDSQLServer.COMANDO.setString (5, entidade.getEmail());
		    BDSQLServer.COMANDO.setString (6, entidade.getTelefone());
		    BDSQLServer.COMANDO.setString (7, entidade.getUsuario());
		    BDSQLServer.COMANDO.setString (8, entidade.getSenha());
		    BDSQLServer.COMANDO.setInt    (9, entidade.getVisualizacoes());
		    BDSQLServer.COMANDO.setString (10, entidade.getDescricao());
		    BDSQLServer.COMANDO.setString (11, entidade.getImagem());
		    BDSQLServer.COMANDO.setString (12, entidade.getSite());

            BDSQLServer.COMANDO.executeUpdate(); // executa o comando, todos s�o executados como "update" - atualiza o banco, menos select / tipo uma fun��o void
            BDSQLServer.COMANDO.commit       (); // USAR APENAS se for insert, delete e update --> O RESTO N PRECISA // efetiva ex: funcionario e dependentes - transa��o, se n, o banco n fica consistente - tudo ou nada
        }
        catch (SQLException erro)
        {
        	//se for um monte de comandos (tudo ou nd) e um der errado, tem q excluir td
        	//BDSQLServer.COMANDO.rollback(); --> desfaz o commit / oposto do commit
        	// transa��o = conjunto de comandos q s�o tudo ou nada
            throw new Exception ("Erro ao inserir entidade");
        }
    }

	/**
		  Exclui entidades pelo codigo
		  Verifica se o codigo pertence a alguma entidade, e em seguida, caso exista,
		  exclui ela da tabela.
		  @param c�digo a ser excluido
    	  @throws Exception caso a entidade n�o for cadastrada
	 */
    public static void excluir(int codigo) throws Exception
    {
        if (!cadastrado(codigo))
            throw new Exception("Nao cadastrada");

        try
        {
            String sql;

            sql = "DELETE FROM HDOACOESNECESSARIAS WHERE CODENTIDADE = ?";
            BDSQLServer.COMANDO.prepareStatement(sql);
            BDSQLServer.COMANDO.setInt(1, codigo);
            BDSQLServer.COMANDO.executeUpdate();

            sql = "DELETE FROM HENTIDADES " +
                  "WHERE CODIGO = ?";
            BDSQLServer.COMANDO.prepareStatement(sql);
            BDSQLServer.COMANDO.setInt(1, codigo);
            BDSQLServer.COMANDO.executeUpdate();

            BDSQLServer.COMANDO.commit();
        }
        catch (SQLException erro)
        {
        	BDSQLServer.COMANDO.rollback();
            throw new Exception("Erro ao excluir entidade");
        }
    }

	/**
		  Altera entidades
		  � passado uma entidade no par�metro, que depois de verificar se ela � null ou se n�o foi
		  cadastrada ainda,e da um update na tabela HEntidades nessa entidade
		  @param Entidade a ser alterada
    	  @throws Exception caso n�o ache uma entidade com a que foi passada no par�metro, ou se ela for nula
	 */
    public static void alterar(Entidade entidade) throws Exception
    {
        if (entidade==null)
            throw new Exception ("Entidade nao fornecida");

        if (!cadastrado(entidade.getCodigo()))
            throw new Exception ("Entidade nao cadastrada");

        try
        {
            String sql;

            sql = "UPDATE HENTIDADES " +
                  "SET NOME=?, " +
                  "CNPJ=?, " +
                  "ENDERECO=?, " +
                  "EMAIL=?, " +
                  "TELEFONE=?, " +
                  "USUARIO=?, " +
                  "SENHA=?, " +
                  "VISUALIZACOES= ?, " +
                  "SITE= ?, "+
                  "DESCRICAO= ?, " +
                  "LINKIMAGEM= ? " +
                  "WHERE CODIGO = ? ";

            BDSQLServer.COMANDO.prepareStatement (sql);

            BDSQLServer.COMANDO.setString (1, entidade.getNome());
            BDSQLServer.COMANDO.setString (2, entidade.getCnpj());
            BDSQLServer.COMANDO.setString (3, entidade.getEndereco());
		    BDSQLServer.COMANDO.setString (4, entidade.getEmail());
		    BDSQLServer.COMANDO.setString (5, entidade.getTelefone());
		    BDSQLServer.COMANDO.setString (6, entidade.getUsuario());
		    BDSQLServer.COMANDO.setString (7, entidade.getSenha());
		    BDSQLServer.COMANDO.setInt    (8, entidade.getVisualizacoes());
		    BDSQLServer.COMANDO.setString (9, entidade.getSite());
		    BDSQLServer.COMANDO.setString (10, entidade.getDescricao());
		    BDSQLServer.COMANDO.setString (11, entidade.getImagem());
		    BDSQLServer.COMANDO.setInt    (12, entidade.getCodigo());

            BDSQLServer.COMANDO.executeUpdate();
            BDSQLServer.COMANDO.commit       ();
        }
        catch (SQLException erro)
        {
            throw new Exception("Erro ao atualizar dados de entidade");
        }
    }

	/**
		  Altera necessidades de uma entidade
		  � passado um codigo entidade no par�metro, al�m de um vetor de produtos, que depois de verificar se eles s�o null ou se n�o foi
		  cadastrada ainda,e da um update na tabela HDoacoesNecessarias nessa entidade.
		  @param c�digo a ser alterado e vetor com produtos
    	  @throws Exception caso n�o ache uma entidade com o c�digo do par�metro ou a lista seja nula
	 */
    public static void alterarNecessidades(int cod, String[] produtos) throws Exception
    {
        if (!cadastrado(cod))
            throw new Exception("Nao cadastrada");

        if (produtos == null)
        	throw new Exception("Lista de necessidades � nula");

        try
        {
            String sql = "DELETE FROM HDOACOESNECESSARIAS WHERE CODENTIDADE = ? ";
            BDSQLServer.COMANDO.prepareStatement (sql);
            BDSQLServer.COMANDO.setInt           (1, cod);
            BDSQLServer.COMANDO.executeUpdate    ();

            for(int i =0; i < produtos.length; i++)
            {
            	sql = "INSERT INTO HDOACOESNECESSARIAS VALUES (?, ?)";
            	BDSQLServer.COMANDO.prepareStatement (sql);
            	BDSQLServer.COMANDO.setInt           (1, cod);
                BDSQLServer.COMANDO.setString        (2, produtos[i]);
                BDSQLServer.COMANDO.executeUpdate    ();
            }

            BDSQLServer.COMANDO.commit();
        }
        catch (SQLException erro)
        {
        	BDSQLServer.COMANDO.rollback();
            throw new Exception("Erro ao atualizar necessidades de entidade");
        }
    }

/**
		 Insere necessidades de uma entidade
		  � passado um codigo entidade no par�metro, al�m de um vetor de produtos, que depois de verificar se eles s�o null ou se n�o foi
		  cadastrada ainda,e da um insert tabela HDoacoesNecessarias com as informa��es.
		  @param c�digo a ser inserido e vetor com produtos
    	  @throws Exception caso n�o ache uma entidade com o c�digo do par�metro ou a lista seja nula
	 */
    public static void inserirNecessidades(int cod, String[] produtos) throws Exception
    {
        if (!cadastrado(cod))
            throw new Exception("Nao cadastrada");

        if (produtos == null)
        	throw new Exception("Lista de necessidades � nula");

        try
        {
            String sql;
            for(int i=0; i < produtos.length; i++)
            {
            	sql = "insert into HDoacoesNecessarias values(?, ?)";
            	BDSQLServer.COMANDO.prepareStatement (sql);

            	BDSQLServer.COMANDO.setInt    (1, cod);
                BDSQLServer.COMANDO.setString (2, produtos[i]);

                BDSQLServer.COMANDO.executeUpdate();
            }
            BDSQLServer.COMANDO.commit       ();
        }
        catch (SQLException erro)
        {
        	BDSQLServer.COMANDO.rollback();
            throw new Exception("Erro ao inserir necessidades de entidade");
        }
    }

  /**
		  Pega uma entidade pelo c�digo
		  Seleciona na tabela tudo sobre a entidade pelo codigo que foi passado no par�metro.
		  @return a entidade encontrada
		  @param c�digo a ser procurado
    	  @throws Exception caso n�o ache uma entidade com o c�digo do par�metro
	 */
    public static Entidade getEntidadeByCod(int codigo) throws Exception
    {

    	if(!cadastrado(codigo))
    		throw new Exception("Entidade n�o cadastrada");

        Entidade entidade = null;
        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM HENTIDADES " +
                  "WHERE CODIGO = ?";

            BDSQLServer.COMANDO.prepareStatement(sql);

            BDSQLServer.COMANDO.setInt(1, codigo);

            MeuResultSet resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery (); // n � mais para executar update, mas sim uma query (consulta) / � � void

            if (!resultado.first()) // .last()/ .next()/ .previous()/ .absolute(10) --> retornam boolean
                throw new Exception ("Nao cadastrado");

            entidade = new Entidade(resultado.getInt  ("CODIGO"),
				                    resultado.getString("NOME"),
				                    resultado.getString("CNPJ"),
				                    resultado.getString("ENDERECO"),
				                    resultado.getString("EMAIL"),
				                    resultado.getString("TELEFONE"),
							        resultado.getString("USUARIO"),
							        resultado.getString("SENHA"),
							        resultado.getInt   ("VISUALIZACOES"),
							        resultado.getString("DESCRICAO"),
							        resultado.getString("LINKIMAGEM"),
							        resultado.getString("SITE"));
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao procurar entidade");
        }

        return entidade;
    }

/**
		  Pega a primeira entidade
		  Seleciona na tabela tudo sobre a primeira entidade
		  @return a entidade encontrada
    	  @throws Exception caso n�o h� nada registrado na tabela
	 */
    public static Entidade getPrimeiroRegistro() throws Exception
    {
        Entidade entidade = null;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM HENTIDADES";

            BDSQLServer.COMANDO.prepareStatement(sql);

            MeuResultSet resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery (); // n � mais para executar update, mas sim uma query (consulta) / � � void
            // uma tabelinha po
            if (!resultado.first()) // .last()/ .next()/ .previous()/ .absolute(10) --> retornam boolean
                throw new Exception ("Nao h� nada registrado na tabela");

            entidade = new Entidade(resultado.getInt  ("CODIGO"),
				                    resultado.getString("NOME"),
				                    resultado.getString("CNPJ"),
				                    resultado.getString("ENDERECO"),
				                    resultado.getString("EMAIL"),
				                    resultado.getString("TELEFONE"),
							        resultado.getString("USUARIO"),
							        resultado.getString("SENHA"),
							        resultado.getInt   ("VISUALIZACOES"),
							        resultado.getString("DESCRICAO"),
							        resultado.getString("LINKIMAGEM"),
							        resultado.getString("SITE"));
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao procurar registro");
        }

        return entidade;
    }

	/**
		  Pega uma entidade pelo usuario
		  Seleciona na tabela tudo sobre a entidade pelo usuario que foi passado no par�metro.
		  @return a entidade encontrada
		  @param usuario a ser procurado
    	  @throws Exception caso n�o ache uma Entidade com o usu�rio do par�metro
	 */
    public static Entidade getEntidadeByUsuario(String usuario) throws Exception
    {
        Entidade entidade = null;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM HENTIDADES " +
                  "WHERE USUARIO = ?";

            BDSQLServer.COMANDO.prepareStatement(sql);

            BDSQLServer.COMANDO.setString(1, usuario);

            MeuResultSet resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery (); // n � mais para executar update, mas sim uma query (consulta) / � � void
            // uma tabelinha po
            if (!resultado.first()) // .last()/ .next()/ .previous()/ .absolute(10) --> retornam boolean
                throw new Exception ("Nao cadastrado");

            entidade = new Entidade(resultado.getInt  ("CODIGO"),
				                    resultado.getString("NOME"),
				                    resultado.getString("CNPJ"),
				                    resultado.getString("ENDERECO"),
				                    resultado.getString("EMAIL"),
				                    resultado.getString("TELEFONE"),
							        resultado.getString("USUARIO"),
							        resultado.getString("SENHA"),
							        resultado.getInt   ("VISUALIZACOES"),
							        resultado.getString("DESCRICAO"),
							        resultado.getString("LINKIMAGEM"),
							        resultado.getString("SITE"));
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao procurar entidade");
        }

        return entidade;
    }

 /**
		  Pega uma entidade pelo ID
		  Seleciona na tabela tudo sobre a entidade pelo ID que foi passado no par�metro.
		  @return a entidade encontrada
		  @param id a ser procurado
    	  @throws Exception caso n�o ache uma entidade com o id do par�metro
	 */
    public static Entidade getEntidadeById(int id) throws Exception
    {
        Entidade entidade = null;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM HENTIDADES " +
                  "WHERE ID = ?";

            BDSQLServer.COMANDO.prepareStatement(sql);

            BDSQLServer.COMANDO.setInt(1, id);

            MeuResultSet resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery (); // n � mais para executar update, mas sim uma query (consulta) / � � void
            // uma tabelinha po
            if (!resultado.first()) // .last()/ .next()/ .previous()/ .absolute(10) --> retornam boolean
                throw new Exception ("Nao cadastrado");

            entidade = new Entidade(resultado.getInt  ("CODIGO"),
				                    resultado.getString("NOME"),
				                    resultado.getString("CNPJ"),
				                    resultado.getString("ENDERECO"),
				                    resultado.getString("EMAIL"),
				                    resultado.getString("TELEFONE"),
							        resultado.getString("USUARIO"),
							        resultado.getString("SENHA"),
							        resultado.getInt   ("VISUALIZACOES"),
							        resultado.getString("DESCRICAO"),
							        resultado.getString("LINKIMAGEM"),
							        resultado.getString("SITE"));
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao procurar entidade");
        }

        return entidade;
    }

		/**
		  Pega as necessidades do codigo passado
		  Seleciona todas as necessidades da entidade de codigo igual ao passado
		  no par�metro.
		  @return resultset necessidades
		  @param c�digo a ser procurado
    	  @throws Exception caso n�o ache necessidades com o c�digo do par�metro
	 */

    public static MeuResultSet getNecessidades(int codigo) throws Exception
    {
    	MeuResultSet resultado = null;

        try
        {
            String sql;

            sql = "selectNecessidades_sp ?";

            BDSQLServer.COMANDO.prepareStatement(sql);

            BDSQLServer.COMANDO.setInt(1, codigo);

            resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery (); // n � mais para executar update, mas sim uma query (consulta) / � � void

            if (!resultado.first()) // .last()/ .next()/ .previous()/ .absolute(10) --> retornam boolean
                throw new Exception ("Nao cadastrado");
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao procurar necessidades da entidade");
        }

        return resultado;
    }

/**
		  Pega todas as entidades
		  Seleciona todas as entidades presentes no banco
		  @return resultset de entidades
    	  @throws Exception caso n�o recupere as entidades
	 */
    public static MeuResultSet getEntidades() throws Exception
    {
        MeuResultSet resultado = null;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM HENTIDADES";

            BDSQLServer.COMANDO.prepareStatement (sql);

            resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery ();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao recuperar entidades");
        }

        return resultado;
    }
     /**
		  Pega todas as Entidades ordenadas por visualiza��o
		  Seleciona todas as entidades oredenadas por visualiza��o
		  @return resultset entidades
    	  @throws Exception caso n�o recupere as entidades
	 */
    public static MeuResultSet getEntidadesVisu() throws Exception
    {
        MeuResultSet resultado = null;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM HENTIDADES ORDER BY VISUALIZACOES";

            BDSQLServer.COMANDO.prepareStatement (sql);

            resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery ();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao recuperar entidades");
        }

        return resultado;
    }

	/**
		  Pega todas as doacoes
		  Seleciona todas as doacoes de todas as pessoas presentes no banco
		  @return resultset de pessoas e doacoes
		  @param c�digo a ser procurado
		  @throws Exception caso n�o recupere as doa��es
	 */
    public static MeuResultSet getDoacoes(int cod) throws Exception
    {
    	if (cod <= 0)
            throw new Exception ("Codigo inv�lido");

        if (!cadastrado(cod))
            throw new Exception("Nao cadastrada");

    	MeuResultSet resultado = null;
    	try
        {
            String sql;

            sql = "select id, p.nome, produto, quantidade,  data, entregue  from HDoacoes d, HPessoas p where d.codPessoa = p.codigo and codEntidade = ?";
            BDSQLServer.COMANDO.prepareStatement (sql);
            BDSQLServer.COMANDO.setInt(1, cod);
            resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery ();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao recuperar doa��es");
        }

        return resultado;

    }
}
