package bd.dbos;
import java.util.Date;
/**
	A classe Doacao � uma classe feita para armazenar dados de
	doa��o (que � uma tabela do banco de dados).
	Nela encontramos setters e getters, al�m do construtor e m�todos obrigat�rios.
	@author Giovanna Pavani Martelli - 19173 e Maria Luiza Sperancin Mancebo - 19186
	@since 2019.
*/
public class Doacao implements Cloneable
{
	/**Armazena o id da doacao*/
	private int id;
	/**Armazena o codigo da pessoa que realizou a doa��o*/
    private int codPessoa;
    /**Armazena o produto que foi doado*/
    private String produto;
   /**Armazena o codigo da entidade que recebeu a doa��o*/
    private int codEntidade;
   /**Armazena a data da doa��o*/
    private Date data;
    /**Armazena se ela foi entregue ou n�o*/
    private char entregue;
    /**Armazena a quantidade da doa��o*/
    private String quantidade;


/**
	  Atribui valor ao ID
	  Atribui ao atributo id um n�mero inteiro passado por par�metro.
	  @param o numero que ser� o id
	  @throws Exception caso o id for menor que zero
	 */
  public void setId (int id) throws Exception
  {
      if (id <= 0)
          throw new Exception ("Codigo invalido");

      this.id = id;
  }

/**
	  Atribui valor ao codigo da pessoa
	  Atribui ao atributo codPessoa um n�mero inteiro passado por par�metro.
	  @param o numero que ser� o codigo da pessoa
	  @throws Exception caso o cod for menor que zero
	 */
  public void setCodPessoa (int cod) throws Exception
  {
      if (cod <= 0)
          throw new Exception ("Codigo pessoa invalido");

      this.codPessoa = cod;
  }

/**
	  Atribui valor ao produto
	  Atribui ao atributo protudo uma String passada por par�metro.
	  @param A string q ser� atribuida
	  @throws Exception caso seja null ou vazio
	 */
  public void setProduto (String prod) throws Exception
  {
      if (prod == null || prod.equals(""))
          throw new Exception ("Data invalida");

      this.produto = prod;
  }

/**
	  Atribui valor ao codigo da entidade
	  Atribui ao atributo codEntidade um n�mero inteiro passado por par�metro.
	  @param o numero que ser� o codigo da entidade
	  @throws Exception caso o cod for menor que zero
	 */
  public void setCodEntidade (int cod) throws Exception
  {
      if (cod <= 0)
          throw new Exception ("Codigo entidade invalido");

      this.codEntidade = cod;
  }

/**
	  Atribui valor a data
	  Atribui ao atributo data uma Data passado por par�metro.
	  @param a data que ser� atribuida
	  @throws Exception caso a data for nula
	 */
  public void setData (Date dat) throws Exception
  {
      if (dat == null)
          throw new Exception ("Data invalida");

      this.data = dat;
  }

/**
	  Atribui valor ao codigo da pessoa
	  Atribui ao atributo codPessoa um n�mero inteiro passado por par�metro.
	  @param o numero que ser� o codigo da pessoa
	  @throws Exception caso o cod for menor que zero
	 */
  public void setEntregue (char entreg) throws Exception
  {
      if (entreg!='S' && entreg!='N')
          throw new Exception ("Campo 'Entregue?' inv�lido");

      this.entregue = entreg;
  }

/**
	  Atribui valor a quantidade da doa��o
	  Atribui ao atributo quantidade uma String passada por par�metro.
	  @param a quantidade a ser atribuida
	  @throws Exception caso for nula ou vazia
	 */
  public void setQuantidade (String qtd) throws Exception
  {
      if (qtd == null || qtd.equals(""))
          throw new Exception ("Quantidade invalida");

      this.quantidade = qtd;
  }

/**
	   Retorna atributo produto
       Retorna o atributo ptoduto da inst�ncia � qual este m�todo for aplicado.
	   @return o produto
	*/
  public String getProduto ()
  {
         return this.produto;
  }

/**
	   Retorna id
       Retorna o atributo id da inst�ncia � qual este m�todo for aplicado.
	   @return o id
	*/
 public int getId ()
 {
        return this.id;
 }

/**
	   Retorna c�digo da entidade
       Retorna o atributo codEntidade da inst�ncia � qual este m�todo for aplicado.
	   @return o codigo da entidade
	*/
 public int getCodEntidade ()
 {
     return this.codEntidade;
 }

/**
	   Retorna c�digo da pessoa
       Retorna o atributo codPessoa da inst�ncia � qual este m�todo for aplicado.
	   @return o codigo da pessoa
	*/
 public int getCodPessoa ()
 {
     return this.codPessoa;
 }

/**
	   Retorna atributo data
       Retorna o atributo data da inst�ncia � qual este m�todo for aplicado.
	   @return a data
	*/
 public Date getData()
 {
	 return this.data;
 }

/**
	   Retorna atributo entregue
       Retorna o atributo entregue da inst�ncia � qual este m�todo for aplicado.
	   @return o entregue
	*/
 public char getEntregue ()
 {
	 return this.entregue;
 }

/**
	   Retorna atributo quantidade
       Retorna o atributo quantidade da inst�ncia � qual este m�todo for aplicado.
	   @return a quantidade
	*/
 public String getQuantidade ()
 {
        return this.quantidade;
 }

/**
	   Constr�i uma nova inst�ncia da classe Doacao
	   Ele apenas instancia todos os atributos usando os setters
	   @throws Exception se algo for nulo ou vazio
	*/
	public Doacao (int id, int codPes, String produto, int codEnt, Date dat, char entreg, String qtd)throws Exception
	{
		this.setId          (id);
	    this.setCodEntidade (codEnt);
	    this.setProduto     (produto);
	    this.setCodPessoa   (codPes);
	    this.setData        (dat);
	    this.setEntregue    (entreg);
	    this.setQuantidade  (qtd);
	}

  /**
	    Gera um String com toda a informa��o presente na classe Doacao.
	    � feito um String que recebe todos os valores presentes na doacao
	    @return um String com todos os dados.
	 */
	public String toString ()
    {
        String ret="";

        ret+="Id: "+this.id+"\n";
        ret+="CodPessoa: "+this.codPessoa  +"\n";
	    ret+="CodEntidade: "+this.codEntidade  +"\n";
	    ret+="Data: " + this.data.toString() + "\n";
	    ret+="Entregue? " + this.entregue+ "\n";
	    ret+="Quantidade: " + this.quantidade;
        return ret;
    }

/**
	   M�todo que retorna se o this � igual ao parametro obj do tipo objeto
	   Verifica se o Object fornecido como par�metro � a mesma Doacao da inst�ncia, resultando true em caso afirmativo,
       ou false, caso n�o forem iguais.
	   @param obj do tipo Object �  o objeto com o qual this ser� comparado
	   @return boolean se this � igual a obj
	*/
	public boolean Equals(Object obj)
	{
	  if(obj == null)
	    return false;

	  if(obj == this)
	    return true;

	  if(this.getClass() != obj.getClass())
	    return false;

	  Doacao  doa = (Doacao) obj;
	  if(this.id != doa.id || this.codPessoa != doa.codPessoa ||this.codEntidade != doa.codEntidade || !(this.data.equals(doa.data)) || !(this.quantidade.equals(doa.quantidade)) || this.entregue != doa.entregue)
	    return false;

	  return true;
	}

/**
	   M�todo que retorna o hash code da inst�ncia da classe
	   Calcula o hashcode da Doacao representada pela inst�ncia � qual o m�todo for aplicado.
	   @return int hash code que engloba o this.qtd e cada valor de equacoes
	*/
	public int hashCode()
	{
	  int ret = 1;
	  ret = ret * 5 + new Integer(this.id).hashCode();
	  ret = ret * 5 + new Integer(this.codPessoa).hashCode();
	  ret = ret * 5 + new Integer(this.codEntidade).hashCode();
	  ret = ret * 5 + this.data.hashCode();
	  ret = ret * 5 + this.quantidade.hashCode();
	  ret = ret * 5 + this.produto.hashCode();
	  ret = ret * 5 + new Character (this.entregue).hashCode();

	  return ret;
	}

  /**
	       Constroi uma c�pia da inst�ncia da classe Doacao.
	       Deve ser passado no par�metro uma inst�ncia de Doacao para ser
		   usada como modelo para criar uma nova.
	       @param modelo inst�ncia de Doacao que ser� usada como molde.
	       @throws Exception caso o molde for nulo.
    */

	public Doacao(Doacao modelo)throws Exception
	{
	  if(modelo == null)
	    throw new Exception();
	  this.id = modelo.id;
	  this.codPessoa = modelo.codPessoa;
	  this.codEntidade = modelo.codEntidade;
	  this.data = modelo.data;
	  this.produto = modelo.produto;
	  this.entregue = modelo.entregue;
	  this.quantidade = modelo.quantidade;
	}

	/**
	   Clona Doacao
	   Produz e retorna uma c�pia da inst�ncia this de Doacao.
	   @return a c�pia do this
	 */
	public Object clone()
	{
	  Doacao ret = null;
	  try
	  {
	    ret = new Doacao(this);
	  }
	  catch(Exception erro){}
	  return ret;
	}

}
