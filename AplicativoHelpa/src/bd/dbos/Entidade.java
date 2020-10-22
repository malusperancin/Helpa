package bd.dbos;
/**
	A classe Entidade � uma classe feita para armazenar dados de
	entidade (que � uma tabela do banco de dados).
	Nela encontramos setters e getters, al�m do construtor e m�todos obrigat�rios.
	@author Giovanna Pavani Martelli - 19173 e Maria Luiza Sperancin Mancebo - 19186
	@since 2019.
*/
public class Entidade implements Cloneable
{
	/**Armazena o codigo da pessoa*/
	 private int codigo;
	/**Armazena o nome da pessoa*/
	private String nome;
	/**Armazena o cnpj da pessoa*/
	private String cnpj;
	/**Armazena o endereco da pessoa*/
	private String endereco;
	 /**Armazena o email da pessoa*/
	 private String email;
	/**Armazena o telefone da pessoa*/
	private String telefone;
	/**Armazena o usuario da pessoa*/
	private String usuario;
	/**Armazena a senha da pessoa*/
	private String senha;
	/**Armazena as visualizacoes da pessoa*/
	private int visualizacoes;
	/**Armazena a descricao da pessoa*/
	private String descricao;
	/**Armazena a imagem da pessoa*/
	private String imagem;
	/**Armazena o site da pessoa*/
	private String site;

/**
	  Atribui valor ao codigo
	  Atribui ao atributo codigo um n�mero inteiro passado por par�metro.
	  @param o numero que ser� o codigo
	  @throws Exception caso o codigo for menor que zero
	 */
	 public void setCodigo(int codigo) throws Exception
	 {
	    if (codigo <= 0)
	       throw new Exception("Codigo invalido");

	       this.codigo = codigo;
	 }

	 /**
	 	  Atribui valor a visualizacoes
	 	  Atribui ao atributo visualizacoes um n�mero inteiro passado por par�metro.
	 	  @param o numero que ser� as visualizacoes
	 	  @throws Exception caso as visualizacoes forem menor que zero
	 */
	 public void setVisualizacoes(int visualizacoes) throws Exception
	 {
	    if (codigo < 0)
	       throw new Exception("Codigo invalido");

	       this.visualizacoes = visualizacoes;
	 }

/**
	  Atribui valor ao nome
	  Atribui ao atributo nome uma String passada por par�metro.
	  @param o nome que ser� atribuido
	  @throws Exception caso o nome for nulo ou vazio
	 */
	 public void setNome(String nome) throws Exception
	 {
	     if (nome==null || nome.equals(""))
	         throw new Exception ("Nome n�o fornecido");

	     this.nome = nome;
	 }
/**
	  Atribui valor ao email
	  Atribui ao atributo email uma String passada por par�metro.
	  @param o email que ser� atribuido
	  @throws Exception caso o email for nulo ou vazio
	 */
	 public void setEmail(String email) throws Exception
	 {
	     if (email==null || email.equals(""))
	         throw new Exception ("Email n�o fornecido");

	     this.email = email;
	 }
/**
	  Atribui valor ao cnpj
	  Atribui ao atributo cnpj uma String passada por par�metro.
	  @param o cnpj que ser� atribuido
	  @throws Exception caso o cnpj for nulo ou vazio
	 */
	 public void setCnpj(String cnpj) throws Exception
	 {
	     if (cnpj==null || cnpj.equals(""))
	         throw new Exception ("CNPJ n�o fornecido");

	     this.cnpj = cnpj;
	 }
/**
	  Atribui valor ao endereco
	  Atribui ao atributo endereco uma String passada por par�metro.
	  @param o endereco que ser� atribuido
	  @throws Exception caso o endere�o for nulo ou vazio
	 */
	 public void setEndereco(String endereco) throws Exception
	 {
	     if (endereco==null || endereco.equals(""))
	         throw new Exception ("Endere�o n�o fornecido");

	     this.endereco = endereco;
	 }
/**
	  Atribui valor ao usuario
	  Atribui ao atributo usuario uma String passada por par�metro.
	  @param o usuario que ser� atribuido
	  @throws Exception caso o usuario for nulo ou vazio
	 */
	 public void setUsuario(String usuario) throws Exception
	 {
	     if (usuario==null || usuario.equals(""))
	         throw new Exception ("Usu�rio n�o fornecido");

	     this.usuario = usuario;
	 }
/**
	  Atribui valor a senha
	  Atribui ao atributo senha uma String passada por par�metro.
	  @param a senha que ser� atribuida
	  @throws Exception caso a senha for nula ou vazia
	 */
	 public void setSenha(String senha) throws Exception
	 {
	     if (senha==null || senha.equals(""))
	         throw new Exception ("Senha n�o fornecida");

	     this.senha = senha;
	 }
/**
	  Atribui valor ao telefone
	  Atribui ao atributo telefone uma String passada por par�metro.
	  @param o telefone que ser� atribuido
	  @throws Exception caso o telefone for nulo ou vazio
	 */
	 public void setTelefone(String telefone) throws Exception
	 {
	     if (telefone==null || telefone.equals("")) // formata��o
	         throw new Exception ("Telefone n�o fornecido");

	     this.telefone = telefone;
	 }
/**
	  Atribui valor ao site
	  Atribui ao atributo site uma String passada por par�metro.
	  @param o site que ser� atribuido
	  @throws Exception caso o site for nulo ou vazio
	 */
	 public void setSite(String site) throws Exception
	 {
	     if (site==null || site.equals(""))
	         throw new Exception ("Site n�o fornecido");

	     this.site = site;
	 }

/**
	  Atribui valor a descricao
	  Atribui ao atributo descricao uma String passada por par�metro.
	  @param a descricao que ser� atribuido
	  @throws Exception caso a descricao for nula ou vazia
	 */
	 public void setDescricao(String desc) throws Exception
	 {
	     if (desc==null || desc.equals(""))
	         throw new Exception ("Descri��o n�o fornecida");

	     this.descricao = desc;
	 }

/**
	  Atribui valor a imagem
	  Atribui ao atributo imagem uma String passada por par�metro.
	  @param a imagem que ser� atribuida
	  @throws Exception caso o parametro for nulo ou vazio
	 */
	 public void setImagem(String img) throws Exception
	 {
	     if (img==null || img.equals(""))
	         throw new Exception ("Nome n�o fornecido");

	     this.imagem = img;
	 }
/**
	   Retorna atributo imagem
       Retorna o atributo imagem da inst�ncia � qual este m�todo for aplicado.
	   @return o nome
	*/
	 public String getImagem ()
	 {
	     return this.imagem;
	 }
/**
	   Retorna atributo codigo
       Retorna o atributo codigo da inst�ncia � qual este m�todo for aplicado.
	   @return o codigo
	*/
	 public int getCodigo ()
	 {
	     return this.codigo;
	 }
/**
	   Retorna atributo nome
       Retorna o atributo nome da inst�ncia � qual este m�todo for aplicado.
	   @return o nome
	*/
	 public String getNome ()
	 {
	     return this.nome;
	 }
/**
	   Retorna atributo visualizacoes
       Retorna o atributo visualizacoes da inst�ncia � qual este m�todo for aplicado.
	   @return o nome
	*/
	 public int getVisualizacoes ()
	 {
	     return this.visualizacoes;
	 }
/**
	   Retorna atributo email
       Retorna o atributo email da inst�ncia � qual este m�todo for aplicado.
	   @return o email
	*/
	 public String getEmail ()
	 {
	     return this.email;
	 }
/**
	   Retorna atributo telefone
       Retorna o atributo telefone da inst�ncia � qual este m�todo for aplicado.
	   @return o telefone
	*/
	 public String getTelefone ()
	 {
	     return this.telefone;
	 }
/**
	   Retorna atributo cnpj
       Retorna o atributo cnpj da inst�ncia � qual este m�todo for aplicado.
	   @return o cnpj
	*/
	 public String getCnpj ()
	 {
	     return this.cnpj;
	 }
/**
	   Retorna atributo endere�o
       Retorna o atributo endere�o da inst�ncia � qual este m�todo for aplicado.
	   @return o endere�o
	*/
	 public String getEndereco ()
	 {
	     return this.endereco;
	 }
  /**
		   Retorna atributo usuario
	       Retorna o atributo usuario da inst�ncia � qual este m�todo for aplicado.
		   @return o usuario
	*/
	 public String getUsuario ()
	 {
	     return this.usuario;
	 }
/**
	   Retorna atributo senha
       Retorna o atributo senha da inst�ncia � qual este m�todo for aplicado.
	   @return a senha
	*/
	 public String getSenha ()
	 {
	     return this.senha;
	 }
/**
	   Retorna atributo site
       Retorna o atributo site da inst�ncia � qual este m�todo for aplicado.
	   @return o site
	*/
	 public String getSite ()
	 {
	     return this.site;
	 }

/**
	   Retorna atributo descricao
       Retorna o atributo descricao da inst�ncia � qual este m�todo for aplicado.
	   @return a descricao
	*/
	 public String getDescricao ()
	 {
	     return this.descricao;
	 }

	/* public Entidade(int codigo) throws Exception
	 {
	    this.setCodigo  (codigo);
	 }*/

/**
	   Constr�i uma nova inst�ncia da classe Entidade
	   Ele apenas instancia todos os atributos usando os setters
	   @throws Exception se algo for nulo ou vazio
	*/
	 public Entidade(int codigo, String nome, String cnpj, String endereco, String email, String telefone, String usuario,
			 String senha, int visualizacoes, String descricao, String imagem, String site) throws Exception
	 {
	    this.setCodigo       (codigo);
	    this.setNome         (nome);
	    this.setEmail        (email);
	    this.setEndereco     (endereco);
	    this.setUsuario      (usuario);
	    this.setSenha        (senha);
	    this.setCnpj         (cnpj);
	    this.setVisualizacoes(visualizacoes);
	    this.setSite         (site);
	    this.setDescricao    (descricao);
	    this.setImagem       (imagem);
	    this.setTelefone     (telefone);
	 }

 /**
	    Gera um String com toda a informa��o presente na classe Entidade.
	    � feito um String que recebe todos os valores presentes na Entidade
	    @return um String com todos os dados.
	 */
	 public String toString ()
	 {
	     String ret="";

		 ret+="Codigo: "+this.codigo+"\n";
		 ret+="Nome: "+this.nome  +"\n";
		 ret+="Email: "+this.email + "\n";
		 ret+="CPNJ: " + this.cnpj +"\n";
		 ret+="Endere�o: "+this.endereco + "\n";
		 ret+="Usu�rio: "+this.usuario + "\n";
		 ret+="Senha: "+this.senha + "\n";
		 ret+="Telefone: "+this.telefone +"\n";
		 ret+="Visualizacoes" + this.visualizacoes + "\n";
		 ret+="Descri��o: "+this.descricao + "\n";
		 ret+="Site: "+this.site + "\n";

		 return ret;
	 }
/**
	   M�todo que retorna o hash code da inst�ncia da classe
	   Calcula o hashcode do Entidade representada pela inst�ncia � qual o m�todo for aplicado.
	   @return int hash code que engloba o this.qtd e cada valor de equacoes
	*/
	public int hashCode()
	{
		int ret = 1;
		ret = ret * 5 + new Integer (this.codigo).hashCode();
		ret = ret * 5 + this.nome.hashCode();
		ret = ret * 5 + this.email.hashCode();
		ret = ret * 5 + this.cnpj.hashCode();
		ret = ret * 5 + this.telefone.hashCode();
		ret = ret * 5 + this.endereco.hashCode();
		ret = ret * 5 + this.usuario.hashCode();
		ret = ret * 5 + this.senha.hashCode();
		ret = ret * 5 + this.site.hashCode();
		ret = ret * 5 + this.descricao.hashCode();
		ret = ret * 5 + new Integer (this.visualizacoes).hashCode();

		if(ret < 0)
			ret = -ret;

		return ret;
	}
/**
	   M�todo que retorna se o this � igual ao parametro obj do tipo objeto
	   Verifica se o Object fornecido como par�metro � a mesma Entidade da inst�ncia, resultando true em caso afirmativo,
       ou false, caso n�o forem iguais.
	   @param obj do tipo Object �  o objeto com o qual this ser� comparado
	   @return boolean se this � igual a obj
	*/
	public boolean Equals(Object obj)
	{
		if(obj == this)
			return true;

		if(obj == null)
			return false;

		if(this.getClass() != obj.getClass())
			return false;

		Entidade ent = (Entidade)obj;

		if(ent.codigo != this.codigo || !ent.nome.equals(this.nome) || !ent.email.equals(this.email) ||
		  !ent.cnpj.equals(this.cnpj) || !ent.telefone.equals(this.telefone) || !ent.endereco.equals(this.endereco) ||
		  !ent.usuario.equals(this.usuario) || !ent.senha.equals(this.senha) || ent.visualizacoes != this.visualizacoes ||
		  !ent.site.equals(this.site) || !ent.descricao.equals(this.descricao))
			return false;

		return true;
	}
/**
	   Clona Entidade
	   Produz e retorna uma c�pia da inst�ncia this de Entidade.
	   @return a c�pia do this
	 */
	public Object clone()
	{
		Entidade ret = null;
		try
		{
			ret = new Entidade (this);
		}
		catch(Exception erro)
		{}
		return ret;
	}
/**
	   Constroi uma c�pia da inst�ncia da classe Entidade.
	   Deve ser passado no par�metro uma inst�ncia de Entidade para ser
	   usada como modelo para criar uma nova.
	   @param modelo inst�ncia de Entidade que ser� usada como molde.
	   @throws Exception caso o molde for nulo.
    */
	public Entidade(Entidade molde) throws Exception
	{
		if(molde == null)
			throw new Exception();

		this.codigo = molde.codigo;
		this.nome = molde.nome;
		this.email = molde.email;
		this.cnpj = molde.cnpj;
		this.telefone = molde.telefone;
		this.endereco = molde.endereco;
		this.usuario = molde.usuario;
		this.senha = molde.senha;
		this.visualizacoes = molde.visualizacoes;
		this.site = molde.site;
		this.descricao = molde.descricao;
		this.imagem = molde.imagem;
	}
}
