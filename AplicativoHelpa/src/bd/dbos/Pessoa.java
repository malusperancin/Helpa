package bd.dbos;
/**
	A classe Pessoa � uma classe feita para armazenar dados de
	pessoa (que � uma tabela do banco de dados).
	Nela encontramos setters e getters, al�m do construtor e m�todos obrigat�rios.
	@author Giovanna Pavani Martelli - 19173 e Maria Luiza Sperancin Mancebo - 19186
	@since 2019.
*/
public class Pessoa implements Cloneable
{
		/**Armazena o codigo da pessoa*/
	 private int    codigo;
	 /**Armazena o nome da pessoa*/
	 private String nome;
	 	 /**Armazena o email da pessoa*/
	 private String email;
	 	 /**Armazena o endereco da pessoa*/
	 private String endereco;
	 	 /**Armazena o senho da pessoa*/
	 private String senha;
	 	 /**Armazena o telefone da pessoa*/
	 private String telefone;
	 	 /**Armazena a cidade da pessoa*/
	 private String cidade;
	 	 /**Armazena a uf da pessoa*/
	 private String uf;


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
	  Atribui valor a cidade
	  Atribui ao atributo cidade uma String passada por par�metro.
	  @param a cidade que ser� atribuida
	  @throws Exception caso a cidade for nula ou vazia
	 */
	 public void setCidade(String cidade) throws Exception
	 {
	     if (cidade==null || cidade.equals(""))
	         throw new Exception ("Cidade n�o fornecida");

	     this.cidade = cidade;
	 }

/**
	  Atribui valor a uf
	  Atribui ao atributo uf uma String passada por par�metro.
	  @param a uf que ser� atribuida
	  @throws Exception caso a uf for nula ou vazia
	 */
	 public void setUf(String uf) throws Exception
	 {
	     if (uf==null || uf.equals(""))
	         throw new Exception ("Uf n�o fornecida");

	     this.uf = uf;
	 }

/**
	  Atribui valor ao telefone
	  Atribui ao atributo telefone uma String passada por par�metro.
	  @param o telefone que ser� atribuido
	  @throws Exception caso o telefone for nulo ou vazio
	 */
	 public void setTelefone(String telefone) throws Exception
	 {
	     if (telefone==null || telefone.equals(""))
	         throw new Exception ("Telefone n�o fornecido");

	     this.telefone = telefone;
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
	  Atribui valor ao endereco
	  Atribui ao atributo endereco uma String passada por par�metro.
	  @param o endereco que ser� atribuido
	  @throws Exception caso o endereco for nulo ou vazio
	 */
	 public void setEndereco(String endereco) throws Exception
	 {
	     if (endereco==null || endereco.equals(""))
	         throw new Exception ("Endere�o n�o fornecido");

	     this.endereco = endereco;
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
	   Retorna atributo cidade
       Retorna o atributo cidade da inst�ncia � qual este m�todo for aplicado.
	   @return a cidade
	*/
	 public String getCidade ()
	 {
	     return this.cidade;
	 }

/**
	   Retorna atributo uf
       Retorna o atributo uf da inst�ncia � qual este m�todo for aplicado.
	   @return a uf
	*/
	 public String getUf ()
	 {
	     return this.uf;
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
	   Retorna atributo email
       Retorna o atributo email da inst�ncia � qual este m�todo for aplicado.
	   @return o email
	*/
	 public String getEmail ()
	 {
	     return this.email;
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
	   Retorna atributo senha
       Retorna o atributo senha da inst�ncia � qual este m�todo for aplicado.
	   @return a senha
	*/
	 public String getSenha ()
	 {
	     return this.senha;
	 }

/**
	   Constr�i uma nova inst�ncia da classe Pessoa
	   Ele apenas instancia todos os atributos usando os setters
	   @throws Exception se algo for nulo ou vazio
	*/
	 public Pessoa (int codigo, String nome, String email, String endereco, String senha, String telefone, String cidade, String uf) throws Exception
	 {
	    this.setCodigo  (codigo);
	    this.setNome    (nome);
	    this.setEmail   (email);
	    this.setEndereco(endereco);
	    this.setSenha   (senha);
	    this.setTelefone(telefone);
	    this.setCidade  (cidade);
	    this.setUf      (uf);
	 }


  /**
	    Gera um String com toda a informa��o presente na classe Pessoa.
	    � feito um String que recebe todos os valores presentes na Pessoa
	    @return um String com todos os dados.
	 */
	 public String toString ()
	 {
	     String ret="";

	     ret+="Codigo: "+this.codigo+"\n";
	     ret+="Nome: "+this.nome  +"\n";
	     ret+="Email: "+this.email + "\n";
	     ret+="Telefone: "+this.telefone + "\n";
	     ret+="Endere�o: "+this.endereco + "\n";
	     ret+="Senha: "+this.senha + "\n";
	     ret+="Cidade: "+this.cidade + "\n";
	     ret+="UF: "+this.uf;

	     return ret;
	 }

/**
	   M�todo que retorna o hash code da inst�ncia da classe
	   Calcula o hashcode da Pessoa representada pela inst�ncia � qual o m�todo for aplicado.
	   @return int hash code que engloba o this.qtd e cada valor de equacoes
	*/
	public int hashCode()
	{
		int ret = 1;
		ret = ret * 5 + new Integer (this.codigo).hashCode();
		ret = ret * 5 + this.nome.hashCode();
		ret = ret * 5 + this.email.hashCode();
		ret = ret * 5 + this.telefone.hashCode();
		ret = ret * 5 + this.endereco.hashCode();
		ret = ret * 5 + this.senha.hashCode();
		ret = ret * 5 + this.cidade.hashCode();
		ret = ret * 5 + this.uf.hashCode();

		if(ret < 0)
			ret = -ret;

		return ret;
	}

/**
	   M�todo que retorna se o this � igual ao parametro obj do tipo objeto
	   Verifica se o Object fornecido como par�metro � a mesma Pessoa da inst�ncia, resultando true em caso afirmativo,
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

		Pessoa pes = (Pessoa)obj;

		if(pes.codigo != this.codigo || !pes.nome.equals(this.nome) || !pes.email.equals(this.email) ||
		  !pes.telefone.equals(this.telefone) || !pes.endereco.equals(this.endereco) |
		  !pes.senha.equals(this.senha) || !pes.cidade.equals(this.cidade) || !pes.uf.equals(this.uf))
			return false;

			return true;
	}

/**
	   Clona Pessoa
	   Produz e retorna uma c�pia da inst�ncia this de Doacao.
	   @return a c�pia do this
	 */
	public Object clone()
	{
		Pessoa ret = null;
		try
		{
			ret = new Pessoa (this);
		}
		catch(Exception erro)
		{}
		return ret;
	}

/**
	   Constroi uma c�pia da inst�ncia da classe Pessoa.
	   Deve ser passado no par�metro uma inst�ncia de Pessoa para ser
	   usada como modelo para criar uma nova.
	   @param modelo inst�ncia de Pessoa que ser� usada como molde.
	   @throws Exception caso o molde for nulo.
    */

	public Pessoa(Pessoa modelo) throws Exception
	{
		if(modelo == null)
			throw new Exception();
		this.codigo = modelo.codigo;
		this.nome = modelo.nome;
		this.email = modelo.email;
		this.endereco = modelo.endereco;
		this.senha = modelo.senha;
		this.telefone = modelo.telefone;
	}
}