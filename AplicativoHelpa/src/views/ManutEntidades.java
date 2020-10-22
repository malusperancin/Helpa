package views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import bd.dbos.*;
import bd.core.MeuResultSet;
import bd.daos.*;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JScrollPane;

public class ManutEntidades extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtCodigo;
	private JTextField txtEmail;
	private JTextField txtEndereco;
	private JTextField txtUsuario;
	private JTextField txtTelefone;
	private JTextField txtCnpj;
	private JButton  btnProcurar;
	private JButton  btnNovo;
	private JButton  btnEditar;
	private JButton btnExcluir;
	private JButton btnCancelar;
	private JButton btnSalvar;
	private JPanel pnlManutencao;
	private JTextField txtSite;
	private JTable tblEntidades;
	private Situacao situacaoAtual;
	private JTextField txtNcsd1;
	private JTextField txtNcsd2;
	private JTextField txtNcsd3;
	private JTextField txtNcsd4;
	private JTextField txtNcsd5;
	private JPanel pnlNecessidades;
	private JTable tblRelatorio;
	private JButton btnVoltarPA;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManutEntidades frame = new ManutEntidades();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public ManutEntidades() 
	{
		initialize();
	}

	
	private void initialize()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 699, 453);
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		situacaoAtual = Situacao.NAVEGANDO;
		contentPane.setLayout(null);
	
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		tabbedPane.setBounds(5, 5, 681, 374);
		tabbedPane.setToolTipText("CADASTRO");
		contentPane.add(tabbedPane);
		
		pnlManutencao = new JPanel();
		/*pnlManutencao.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent arg0) {
				// AO ENTRAR NA ABA CADASTRO
			}
		});*/
		
		tabbedPane.addTab("Manuten\u00E7\u00E3o", null, pnlManutencao, null);
		pnlManutencao.setLayout(null);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo:");
		lblCdigo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCdigo.setBounds(21, 43, 59, 32);
		pnlManutencao.add(lblCdigo);
		
		JLabel label_3 = new JLabel("Nome:");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_3.setBounds(31, 83, 48, 32);
		pnlManutencao.add(label_3);
		
		txtNome = new JTextField();
		txtNome.setEditable(false);
		txtNome.setText((String) null);
		txtNome.setColumns(10);
		txtNome.setBounds(90, 80, 355, 30);
		pnlManutencao.add(txtNome);
		
		JLabel label_4 = new JLabel("CNPJ:");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_4.setBounds(32, 115, 48, 32);
		pnlManutencao.add(label_4);
		
		txtCodigo = new JTextField();
		txtCodigo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode()== KeyEvent.VK_ENTER) // apertou enter e ta procurando
				{
					if(!txtCodigo.getText().equals(""))
					{
						int codProc = Integer.parseInt(txtCodigo.getText());
						atualizarTela();
						if(codProc != Integer.parseInt(txtCodigo.getText()))
							JOptionPane.showMessageDialog(null,"N�o foi poss�vel achar a entidade com esse c�digo!");
					}
					else
						JOptionPane.showMessageDialog(null,"Escreva um c�digo v�lido no campo de c�digo!");
					txtCodigo.setEditable(false);
				}
			}
		});
		txtCodigo.setEditable(false);
		txtCodigo.setText((String) null);
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(90, 43, 109, 30);
		pnlManutencao.add(txtCodigo);
		
		JLabel label_5 = new JLabel("E-mail:");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_5.setBounds(21, 150, 59, 32);
		pnlManutencao.add(label_5);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTelefone.setBounds(10, 191, 69, 32);
		pnlManutencao.add(lblTelefone);
		
		JLabel lblUsurio = new JLabel("Usu\u00E1rio:");
		lblUsurio.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUsurio.setBounds(21, 265, 69, 32);
		pnlManutencao.add(lblUsurio);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o:");
		lblEndereo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEndereo.setBounds(10, 228, 72, 32);
		pnlManutencao.add(lblEndereo);
		
		txtEmail = new JTextField();
		txtEmail.setEditable(false);
		txtEmail.setText((String) null);
		txtEmail.setColumns(10);
		txtEmail.setBounds(90, 150, 355, 30);
		pnlManutencao.add(txtEmail);
		
		txtEndereco = new JTextField();
		txtEndereco.setEditable(false);
		txtEndereco.setText((String) null);
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(90, 228, 355, 30);
		pnlManutencao.add(txtEndereco);
		
		txtUsuario = new JTextField();
		txtUsuario.setEditable(false);
		txtUsuario.setText((String) null);
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(90, 265, 179, 30);
		pnlManutencao.add(txtUsuario);
		
		txtTelefone = new JTextField();
		txtTelefone.setEditable(false);
		txtTelefone.setText((String) null);
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(90, 191, 179, 30);
		pnlManutencao.add(txtTelefone);
		
		txtCnpj = new JTextField();
		txtCnpj.setEditable(false);
		txtCnpj.setText((String) null);
		txtCnpj.setColumns(10);
		txtCnpj.setBounds(90, 114, 179, 30);
		pnlManutencao.add(txtCnpj);
		
		JMenuBar menuBar_1 = new JMenuBar();
		menuBar_1.setMargin(new Insets(10, 1, 1, 1));
		menuBar_1.setBounds(0, 0, 676, 32);
		pnlManutencao.add(menuBar_1);
		
		btnProcurar = new JButton("Procurar");
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtCodigo.setEditable(true);
			}
		});
		menuBar_1.add(btnProcurar);
		
		JLabel label_13 = new JLabel("|");
		label_13.setFont(new Font("Tahoma", Font.PLAIN, 15));
		menuBar_1.add(label_13);
		
		btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				situacaoAtual = Situacao.INCLUINDO;
				limparTela();
				setTxt(true);
				txtCodigo.grabFocus();
				setTxtNecessidades(false);
				txtNcsd1.setEditable(true);
				btnSalvar.setEnabled(true);
			}
		});
		menuBar_1.add(btnNovo);
		
		btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {// apertar botao de editar
				situacaoAtual = Situacao.EDITANDO;
				setTxt(true);
				txtCodigo.setEditable(false);
				btnSalvar.setEnabled(true);
			}
		});
		menuBar_1.add(btnEditar);
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { // ao clicar no botao de excluir
				try 
				{
					Entidades.excluir(Integer.parseInt(txtCodigo.getText()));
					atualizarTela();
					JOptionPane.showMessageDialog(null,"Entidade exclu�da com sucesso!");
				}
				catch(Exception er)
				{
					JOptionPane.showMessageDialog(null,"N�o foi poss�vel excluir essa entidade!");
				}
			}
		});
		menuBar_1.add(btnExcluir);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				atualizarTela();
				setTxt(false);
				txtCodigo.setEditable(false);
			}
		});
		menuBar_1.add(btnCancelar);
		
		JLabel label_14 = new JLabel("|");
		label_14.setFont(new Font("Tahoma", Font.PLAIN, 15));
		menuBar_1.add(label_14);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.setEnabled(false);
		btnSalvar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {// ao apertar botao de salvar
			if( !txtCodigo.getText().equals("")  ||
				!txtNome.getText().equals("")    ||
				!txtEmail.getText().equals("")   ||
				!txtCnpj.getText().equals("")    ||
				!txtEndereco.getText().equals("")||
				!txtTelefone.getText().equals("")||
				!txtUsuario.getText().equals("") ||
				!txtNcsd1.getText().equals("")    )
				{
					switch(situacaoAtual)
					{
						case EDITANDO:
						try
						{
							Entidade antiga = Entidades.getEntidadeByCod(Integer.parseInt(txtCodigo.getText()));
							Entidade entidade = null;
							try {
								entidade = new Entidade(Integer.parseInt(txtCodigo.getText()), txtNome.getText(),
								txtCnpj.getText(), txtEndereco.getText(), txtEmail.getText(), txtTelefone.getText(), txtUsuario.getText(),antiga.getSenha(), 
								antiga.getVisualizacoes(), antiga.getDescricao(), antiga.getImagem(), txtSite.getText());
							}
							catch(Exception ex) {throw new Exception();}
							Entidades.alterar(entidade);
						}
						catch(Exception ex) 
						{
							JOptionPane.showMessageDialog(null,"N�o foi poss�vel editar a entidade com os novos dados inseridos. Altera��o cancelada!");
						}
						break;
						
						case INCLUINDO:		
						try
						{
							Entidade entidade = null;
							try {
								entidade = new Entidade(Integer.parseInt(txtCodigo.getText()), txtNome.getText(), txtCnpj.getText(),
								txtEndereco.getText(), txtEmail.getText(),txtTelefone.getText(), txtUsuario.getText(), txtNome.getText()+"123", 0,
								" ", " ", txtSite.getText());
							}
							catch(Exception ex)
							{throw new Exception(ex.getMessage());}
							Entidades.incluir(entidade);
							
							int qtd = 1;
							String produtos[] = new String[qtd];
							produtos[0] = txtNcsd1.getText();
							Entidades.inserirNecessidades(entidade.getCodigo(), produtos);
						}
						catch(Exception ex) 
						{
							JOptionPane.showMessageDialog(null,"N�o foi poss�vel incluir essa entidade."+ ex.getMessage()+" Inclus�o cancelada!");
						}
					
						case NAVEGANDO:
						setTxt(false);
						btnSalvar.setEnabled(false);
					}
				}
				else
					JOptionPane.showMessageDialog(null,"N�o deixe campos em branco! Altera��o cancelada!");
				situacaoAtual = Situacao.NAVEGANDO;
				txtNcsd1.setEditable(false);
				atualizarTela();
				btnSalvar.setEnabled(false);
			}
		});
		menuBar_1.add(btnSalvar);
		
		JLabel lblNecessidades = new JLabel("Necessidades:");
		lblNecessidades.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNecessidades.setBounds(466, 67, 131, 32);
		pnlManutencao.add(lblNecessidades);
		
		JLabel lblSite = new JLabel("Site:");
		lblSite.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSite.setBounds(48, 301, 32, 32);
		pnlManutencao.add(lblSite);
		
		txtSite = new JTextField();
		txtSite.setText((String) null);
		txtSite.setEditable(false);
		txtSite.setColumns(10);
		txtSite.setBounds(90, 304, 367, 30);
		pnlManutencao.add(txtSite);
		
		tblRelatorio = new JTable();
		JPanel pnlRelatorio = new JPanel();
		pnlRelatorio.setLayout(null);
		tabbedPane.addTab("Relat\u00F3rio", null, pnlRelatorio, null);
		pnlRelatorio.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent arg0) {
				DefaultTableModel model = null;
				try 
				{
					MeuResultSet dados = Entidades.getEntidadesVisu();
					model = new DefaultTableModel(new Object[][] {},
					new String[] {
							"C\u00F3digo", "Nome", "CNPJ","Endere\u00E7o", "Email", "Telefone", "Usu\u00E1rio", "Visualiza\u00E7\u00F5es", "Descri\u00E7ao", "Site"
					});
					
					while(dados.next())
					{
						model.addRow(new Object[] {dados.getInt(1)+"", dados.getString(2), dados.getString(3), dados.getString(4), dados.getString(5), dados.getString(6), dados.getString(7), dados.getString(8), dados.getString(9),dados.getString(10), dados.getString(11)});
					}
					tblRelatorio .setModel(model);
				}
				catch(Exception ex) 
				{
					ex.printStackTrace();
					System.out.print(ex.getMessage());
				}
			}
		});		
		
		//tblEntidades.setBounds(10, 332, 656, -302);
		
		pnlNecessidades = new JPanel();
		pnlNecessidades.setBounds(466, 110, 191, 211);
		pnlManutencao.add(pnlNecessidades);
		pnlNecessidades.setLayout(new GridLayout(5, 1, 0, 0));
		
		txtNcsd1 = new JTextField();
		txtNcsd1.setEditable(false);
		txtNcsd1.setColumns(10);
		pnlNecessidades.add(txtNcsd1);
		
		txtNcsd2 = new JTextField();
		txtNcsd2.setEditable(false);
		txtNcsd2.setColumns(10);
		pnlNecessidades.add(txtNcsd2);
		
		txtNcsd3 = new JTextField();
		txtNcsd3.setEditable(false);
		txtNcsd3.setColumns(10);
		pnlNecessidades.add(txtNcsd3);
		
		txtNcsd4 = new JTextField();
		txtNcsd4.setEditable(false);
		txtNcsd4.setColumns(10);
		pnlNecessidades.add(txtNcsd4);
		
		txtNcsd5 = new JTextField();
		txtNcsd5.setEditable(false);
		txtNcsd5.setColumns(10);
		pnlNecessidades.add(txtNcsd5);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 676, 21);
		pnlRelatorio.add(menuBar);
		
		JLabel lblAquiTemosTodas = new JLabel("Aqui, temos todas as entidades cadastradas ranqueadas pela quantidade de doa\u00E7\u00F5es que receberam:");
		lblAquiTemosTodas.setForeground(Color.GRAY);
		menuBar.add(lblAquiTemosTodas);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 32, 656, 303);
		pnlRelatorio.add(scrollPane);
		
		scrollPane.setViewportView(tblRelatorio);
		
		btnVoltarPA = new JButton("Voltar p/ a \u00E1rea");
		btnVoltarPA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnVoltarPA.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnVoltarPA.setBounds(282, 378, 132, 36);
		contentPane.add(btnVoltarPA);
		
		atualizarTela();
	}
		
	private void atualizarTela() 
	{
		Entidade aEntidade = null;
		try 
		{
			aEntidade = Entidades.getEntidadeByCod(Integer.parseInt(txtCodigo.getText()));
		}
		catch(Exception ex) 
		{
			try 
			{
				aEntidade = Entidades.getPrimeiroRegistro();
			} 
			catch (Exception e) {} // nunca vai dar erro pois a tabela nunca estar� vazia 
		}
		txtCodigo.setText(aEntidade.getCodigo()+"");
		txtNome.setText(aEntidade.getNome());
		txtEmail.setText(aEntidade.getEmail());
		txtCnpj.setText(aEntidade.getCnpj());
		txtEndereco.setText(aEntidade.getEndereco());
		txtTelefone.setText(aEntidade.getTelefone());
		txtUsuario.setText(aEntidade.getUsuario());
		txtSite.setText(aEntidade.getSite());
		
		// exibir necessidades
		try {
			
			for (Component c : pnlNecessidades.getComponents()) 
			{
				if (c instanceof JTextField) 
			    { 
					((JTextField)c).setVisible(false);
					((JTextField)c).setEditable(false);
			    }
			}
			
			MeuResultSet result = Entidades.getNecessidades(aEntidade.getCodigo());
			result.last();
			int qtd = result.getRow();

			int x = 0;
			for (Component c : pnlNecessidades.getComponents()) 
			{
				if(x<qtd)
				if (c instanceof JTextField) 
			    { 
					((JTextField)c).setVisible(true);
					x++;
			    }
			}
			
			result.first();
			for (Component c : pnlNecessidades.getComponents()) 
			{
			    if (c instanceof JTextField) 
			    { 
			    	try 
			    	{
			    		((JTextField)c).setText(result.getObject("Produto").toString());
			    		result.next();
			    	}
			    	catch(Exception ex)
			    	{
			    		((JTextField)c).setText("");
			    	}
			    }
			}
		}
		catch(Exception ex)
		{} // n vai dar erro pois o codigo foi passado por mim
		setTxt(false);
	}
	
	private void limparTela() 
	{
		txtCodigo.setText("");
		txtNome.setText("");
		txtEmail.setText("");
		txtCnpj.setText("");
		txtEndereco.setText("");
		txtTelefone.setText("");
		txtUsuario.setText("");
		txtSite.setText("");
	}
	
	private void setTxt(boolean modo)
	{
		txtNcsd1.setEditable(false);
		txtCodigo.setEditable(modo);
		txtNome.setEditable(modo);
		txtEmail.setEditable(modo);
		txtEndereco.setEditable(modo);
		txtEmail.setEditable(modo);
		txtUsuario.setEditable(modo);
		txtCnpj.setEditable(modo);
		txtTelefone.setEditable(modo);
		txtSite.setEditable(modo);
	}
	
	private void setTxtNecessidades(boolean modo)
	{
		for (Component c : pnlNecessidades.getComponents()) 
		{
			if (c instanceof JTextField) 
		    { 
				((JTextField)c).setVisible(false);
		    }
		}
		txtNcsd1.setText("");
		txtNcsd1.setVisible(true);
	}
}
