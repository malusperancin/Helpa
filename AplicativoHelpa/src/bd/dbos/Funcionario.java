package bd.dbos;
/**
	A classe Funcionario � uma classe feita para armazenar dados de
	funcionario (que � uma tabela do banco de dados).
	Nela encontramos setters e getters, al�m do construtor e m�todos obrigat�rios.
	@author Giovanna Pavani Martelli - 19173 e Maria Luiza Sperancin Mancebo - 19186
	@since 2019.
*/
public class Funcionario implements Cloneable
{
		/**Armazena o codigo da pessoa*/
	private int    codigo;
	 /**Armazena o nome da pessoa*/
	private String nome;
		 /**Armazena o cpf da pessoa*/
	private String cpf;
	 /**Armazena o email da pessoa*/
	private String email;
		 /**Armazena o salario da pessoa*/
	private float  salario;
		 	 /**Armazena o telefone da pessoa*/
	private String telefone;
		 	 /**Armazena o cargo da pessoa*/
	private String cargo;
		 	 /**Armazena a conta da pessoa*/
	private String conta;
		 	 /**Armazena a agencia da pessoa*/
	private String agencia;
		 	 /**Armazena o endere�o da pessoa*/
	private String endereco;
	 	 /**Armazena o usuario da pessoa*/
	private String usuario;
	 	 /**Armazena a senha da pessoa*/
	private String senha;

/**
	  Atribui valor ao codigo
	  Atribui ao atributo codigo um n�mero inteiro passado por par�metro.
	  @param o numero que ser� o codigo
	  @throws Exception caso o codigo for menor que zero
	 */
 	public void setCodigo (int cod) throws Exception
    {
        if (cod <= 0)
            throw new Exception ("Codigo invalido");

        this.codigo = cod;
    }
/**
	  Atribui valor ao nome
	  Atribui ao atributo nome uma String passada por par�metro.
	  @param o nome que ser� atribuido
	  @throws Exception caso o nome for nulo ou vazio
	 */
 	public void setNome (String nome) throws Exception
    {
        if (nome==null || nome.equals(""))
            throw new Exception ("Nome nao fornecido");

        this.nome = nome;
    }

	/**
	  Atribui valor ao cpf
	  Atribui ao atributo cpf uma String passada por par�metro.
	  @param o cpf que ser� atribuido
	  @throws Exception caso o cpf for nulo ou vazio
	 */
 	public void setCpf (String cpf) throws Exception
    {
        if (cpf==null || cpf.equals(""))
            throw new Exception ("Cpf nao fornecido");

        this.cpf = cpf;
    }
/**
	  Atribui valor ao email
	  Atribui ao atributo email uma String passada por par�metro.
	  @param o email que ser� atribuido
	  @throws Exception caso o email for nulo ou vazio
	 */
	public void setEmail (String email) throws Exception
    {
        if (email==null || email.equals(""))
            throw new Exception ("Email nao fornecido");

        this.email = email;
    }
/**
	  Atribui valor ao salario
	  Atribui ao atributo salario um float passado por par�metro.
	  @param o salario que ser� atribuido
	  @throws Exception caso o salario for menor que zero
	 */
 	public void setSalario (float salario) throws Exception
    {
        if (salario <= 0)
            throw new Exception ("Salario invalido");

        this.salario = salario;
    }

/**
	  Atribui valor ao telefone
	  Atribui ao atributo telefone uma String passada por par�metro.
	  @param o telefone que ser� atribuido
	  @throws Exception caso o telefone for nulo ou vazio
	 */
 	public void setTelefone (String telefone) throws Exception
    {
        if (telefone==null || telefone.equals(""))
            throw new Exception ("Telefone nao fornecido");

        this.telefone = telefone;
    }

/**
	  Atribui valor ao cargo
	  Atribui ao atributo cargo uma String passada por par�metro.
	  @param o cargo que ser� atribuido
	  @throws Exception caso o cargo for nulo ou vazio
	 */
	public void setCargo (String cargo) throws Exception
    {
        if (cargo==null || cargo.equals(""))
            throw new Exception ("Cargo nao fornecido");

        this.cargo = cargo;
    }

/**
	  Atribui valor a conta
	  Atribui ao atributo conta uma String passada por par�metro.
	  @param a conta que ser� atribuida
	  @throws Exception caso a conta for nula ou vazia
	 */
	public void setConta (String conta) throws Exception
    {
        if (conta==null || conta.equals(""))
            throw new Exception ("Conta nao fornecida");

        this.conta = conta;
    }

/**
	  Atribui valor a agencia
	  Atribui ao atributo agencia uma String passada por par�metro.
	  @param a agencia que ser� atribuida
	  @throws Exception caso a agencia for nula ou vazia
	 */
	public void setAgencia (String agencia) throws Exception
    {
        if (agencia==null || agencia.equals(""))
            throw new Exception ("Agencia nao fornecida");

        this.agencia = agencia;
    }

/**
	  Atribui valor ao endereco
	  Atribui ao atributo endereco uma String passada por par�metro.
	  @param o endereco que ser� atribuido
	  @throws Exception caso o endere�o for nulo ou vazio
	 */
	public void setEndereco (String endereco) throws Exception
    {
        if (endereco==null || endereco.equals(""))
            throw new Exception ("Endereco nao fornecido");

        this.endereco = endereco;
    }

/**
	  Atribui valor ao usuario
	  Atribui ao atributo usuario uma String passada por par�metro.
	  @param o usuario que ser� atribuido
	  @throws Exception caso o usuario for nulo ou vazio
	 */
	public void setUsuario (String usuario) throws Exception
    {
        if (usuario==null || usuario.equals(""))
            throw new Exception ("Usuario nao fornecido");

        this.usuario = usuario;
    }

/**
	  Atribui valor a senha
	  Atribui ao atributo senha uma String passada por par�metro.
	  @param a senha que ser� atribuida
	  @throws Exception caso a senha for nula ou vazia
	 */
	public void setSenha (String senha) throws Exception
    {
        if (senha==null || senha.equals(""))
            throw new Exception ("Senha nao fornecido");

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
	   Retorna atributo cpf
       Retorna o atributo cpf da inst�ncia � qual este m�todo for aplicado.
	   @return o cpf
	*/
    public String getCpf ()
    {
        return this.cpf;
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
	   Retorna atributo salario
       Retorna o atributo salario da inst�ncia � qual este m�todo for aplicado.
	   @return o salario
	*/
    public float getSalario ()
    {
        return this.salario;
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
	   Retorna atributo cargo
       Retorna o atributo cargo da inst�ncia � qual este m�todo for aplicado.
	   @return o cargo
	*/
	public String getCargo ()
    {
        return this.cargo;
    }
/**
	   Retorna atributo conta
       Retorna o atributo conta da inst�ncia � qual este m�todo for aplicado.
	   @return o conta
	*/
	public String getConta ()
    {
        return this.conta;
    }
/**
	   Retorna atributo agencia
       Retorna o atributo agencia da inst�ncia � qual este m�todo for aplicado.
	   @return a agencia
	*/
	public String getAgencia ()
    {
        return this.agencia;
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
	   Constr�i uma nova inst�ncia da classe Funcionario
	   Ele apenas instancia todos os atributos usando os setters
	   @throws Exception se algo for nulo ou vazio
	*/
	public Funcionario (int codigo, String nome,String cpf,String email,float salario,String telefone,
			String cargo,String conta,String agencia,String endereco,String usuario,String senha) throws Exception
    {
        this.setCodigo   (codigo);
        this.setNome     (nome);
		this.setCpf      (cpf);
		this.setEmail    (email);
		this.setSalario  (salario);
		this.setTelefone (telefone);
        this.setCargo    (cargo);
		this.setConta    (conta);
		this.setAgencia  (agencia);
		this.setEndereco (endereco);
		this.setUsuario  (usuario);
		this.setSenha    (senha);
    }

 /**
	    Gera um String com toda a informa��o presente na classe Funcionario.
	    � feito um String que recebe todos os valores presentes na Funcionario
	    @return um String com todos os dados.
	 */
	public String toString ()
    {
        String ret="";

        ret+="Codigo: "  +this.codigo   +"\n";
        ret+="Nome: "    +this.nome     +"\n";
        ret+="Cpf: "     +this.cpf      +"\n";
		ret+="Email: "   +this.email    +"\n";
		ret+="Salario: " +this.salario  +"\n";
		ret+="Telefone: "+this.telefone +"\n";
		ret+="Cargo: "   +this.cargo    +"\n";
		ret+="Conta: "   +this.conta    +"\n";
		ret+="Agencia: " +this.agencia  +"\n";
		ret+="Endereco: "+this.endereco +"\n";
		ret+="Usuario: " +this.usuario  +"\n";
		ret+="Senha: "   +this.senha;
        return ret;
    }
/**
	   M�todo que retorna o hash code da inst�ncia da classe
	   Calcula o hashcode do Funcionario representada pela inst�ncia � qual o m�todo for aplicado.
	   @return int hash code que engloba o this.qtd e cada valor de equacoes
	*/
	public int hashCode()
	{
		int ret = 1;
		ret = ret * 5 + new Integer (this.codigo).hashCode();
		ret = ret * 5 + this.nome.hashCode();
		ret = ret * 5 + this.email.hashCode();
		ret = ret * 5 + this.cpf.hashCode();
		ret = ret * 5 + this.telefone.hashCode();
		ret = ret * 5 + this.conta.hashCode();
		ret = ret * 5 + this.cargo.hashCode();
		ret = ret * 5 + this.agencia.hashCode();
		ret = ret * 5 + this.endereco.hashCode();
		ret = ret * 5 + this.usuario.hashCode();
		ret = ret * 5 + this.senha.hashCode();
		ret = ret * 5 + new Float (this.salario).hashCode();

		if(ret < 0)
			ret = -ret;

		return ret;
	}

/**
	   M�todo que retorna se o this � igual ao parametro obj do tipo objeto
	   Verifica se o Object fornecido como par�metro � a mesma Funcionario da inst�ncia, resultando true em caso afirmativo,
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

		Funcionario fun = (Funcionario)obj;

		if(fun.codigo != this.codigo || !fun.nome.equals(this.nome) || !fun.cargo.equals(this.cargo) ||
		  !fun.email.equals(email) || !fun.cpf.equals(this.cpf) || !fun.telefone.equals(this.telefone) ||
		  !fun.conta.equals(this.conta) || !fun.agencia.equals(this.agencia) || !fun.endereco.equals(this.endereco) ||
		  !fun.usuario.equals(this.usuario) || !fun.senha.equals(this.senha) || fun.salario != this.salario)
			return false;

		return true;
	}
/**
	   Clona Funcionario
	   Produz e retorna uma c�pia da inst�ncia this de Funcionario.
	   @return a c�pia do this
	 */
	public Object clone()
	{
		Funcionario ret = null;
		try
		{
			ret = new Funcionario (this);
		}
		catch(Exception erro)
		{}
		return ret;
	}

/**
	   Constroi uma c�pia da inst�ncia da classe Funcionario.
	   Deve ser passado no par�metro uma inst�ncia de Funcionario para ser
	   usada como modelo para criar uma nova.
	   @param modelo inst�ncia de Funcionario que ser� usada como molde.
	   @throws Exception caso o molde for nulo.
    */
	public Funcionario(Funcionario molde) throws Exception
	{
		if(molde == null)
			throw new Exception();

		this.codigo = molde.codigo;
		this.nome = molde.nome;
		this.email = molde.email;
		this.cpf = molde.cpf;
		this.cargo = molde.cargo;
		this.telefone = molde.telefone;
		this.conta = molde.conta;
		this.agencia = molde.agencia;
		this.endereco = molde.endereco;
		this.usuario = molde.usuario;
		this.senha = molde.senha;
		this.salario = molde.salario;
	}
}