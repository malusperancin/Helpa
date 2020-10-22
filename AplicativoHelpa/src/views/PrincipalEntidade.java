package views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import bd.core.MeuResultSet;
import bd.daos.Doacoes;
import bd.daos.Entidades;
import bd.dbos.Doacao;
import bd.dbos.Entidade;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import java.awt.Insets;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class PrincipalEntidade extends JFrame {
	
	private JPanel contentPane;
	private int codigo;
	private int idDoacao;
	private int linha;
	private Entidade entidadeLog;
	private JTextField txtNome;
	private JTextField txtEmail;
	private JTextField txtEndereco;
	private JTextField txtTelefone;
	private JTextField txtSite;
	private JTextField txtFoto;
	private JTextField txtUsuario;
	private JTextField txtNec1;
	private JTextField txtNec2;
	private JTextField txtNec3;
	private JTextField txtNec4;
	private JTextField txtNec5;
	private JComboBox<Integer> cbxNecessidades;
	private JPanel pnlNecessidades;
	private JTextArea txtDescricao;
	private JPanel pnlInfoInt;
	private JPanel pnlInfoPub;
	JButton btnSalvarInt;
	JButton btnSalvarPub;
	private JTable tblRelatorio;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalEntidade frame = new PrincipalEntidade();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public PrincipalEntidade(int cod) {
		codigo = cod;
		initialize();
	}
	
	private void initialize()
	{
		try
		{
		  entidadeLog = new Entidade(Entidades.getEntidadeByCod(codigo));
		}
		catch(Exception ex) {} // n vai dar erro pois o codigo foi eu que passei
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 575, 407);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setToolTipText("");
		//tabbedPane.setSelectedIndex(0); // ver se d� erro
		tabbedPane.setBounds(0, 0, 559, 368);
		contentPane.add(tabbedPane);
		
		pnlInfoInt = new JPanel();
		pnlInfoInt.setLayout(null);
		tabbedPane.addTab("Informa\u00E7\u00F5es Internas", null, pnlInfoInt, null);
		
		JLabel label_1 = new JLabel("Nome:");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_1.setBounds(52, 78, 48, 32);
		pnlInfoInt.add(label_1);
		
		txtNome = new JTextField();
		txtNome.setEditable(false);
		txtNome.setText((String) null);
		txtNome.setColumns(10);
		txtNome.setBounds(109, 80, 400, 30);
		pnlInfoInt.add(txtNome);
		
		JLabel label_3 = new JLabel("E-mail:");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_3.setBounds(52, 156, 51, 32);
		pnlInfoInt.add(label_3);
		
		JLabel lblTelefone = new JLabel("Telefone: ");
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTelefone.setBounds(35, 118, 72, 32);
		pnlInfoInt.add(lblTelefone);
		
		JLabel label_7 = new JLabel("Endere\u00E7o:");
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_7.setBounds(31, 195, 72, 32);
		pnlInfoInt.add(label_7);
		
		txtEmail = new JTextField();
		txtEmail.setEditable(false);
		txtEmail.setText((String) null);
		txtEmail.setColumns(10);
		txtEmail.setBounds(109, 159, 400, 30);
		pnlInfoInt.add(txtEmail);
		
		txtEndereco = new JTextField();
		txtEndereco.setEditable(false);
		txtEndereco.setText((String) null);
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(109, 198, 400, 30);
		pnlInfoInt.add(txtEndereco);
		
		txtTelefone = new JTextField();
		txtTelefone.setEditable(false);
		txtTelefone.setText((String) null);
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(109, 121, 179, 30);
		pnlInfoInt.add(txtTelefone);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setMargin(new Insets(10, 1, 1, 1));
		menuBar.setBounds(0, 0, 546, 32);
		pnlInfoInt.add(menuBar);
		
		JButton btnAlterarInt = new JButton("Alterar");
		btnAlterarInt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setTxtInt(true);
			}
		});
		btnAlterarInt.setFont(UIManager.getFont("ToolTip.font"));
		menuBar.add(btnAlterarInt);
		
		btnSalvarInt = new JButton("Salvar");
		btnSalvarInt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if( !txtNome.getText().equals("")    ||
					!txtEmail.getText().equals("")   ||
					!txtEndereco.getText().equals("")||
					!txtTelefone.getText().equals("")||
					!txtUsuario.getText().equals("")  )
					{
						try {
							Entidade entidade = new Entidade(entidadeLog.getCodigo(), txtNome.getText(),
									entidadeLog.getCnpj(), txtEndereco.getText(),txtEmail.getText(), txtTelefone.getText(),
									txtUsuario.getText(),entidadeLog.getSenha(), entidadeLog.getVisualizacoes(), 
									entidadeLog.getDescricao(), entidadeLog.getImagem(), entidadeLog.getSite());
							try
							{
								Entidades.alterar(entidade);
								entidadeLog = new Entidade(entidade);
								JOptionPane.showMessageDialog(null,"Informa��es alteradas com sucesso!");
							}
							catch(Exception ex) 
							{
								throw new Exception();
							}
						}
						catch(Exception ex) 
						{
							JOptionPane.showMessageDialog(null,"Informa��es inseridas inv�lidas. Altera��o cancelada!");
						}
						atualizarTela();
					}
				else
					JOptionPane.showMessageDialog(null,"N�o deixe nenhum campo vazio! Altera��o cancelada.");
				btnSalvarInt.setEnabled(false);
				setTxtInt(false);
			}
		});
		btnSalvarInt.setFont(UIManager.getFont("ToolTip.font"));
		menuBar.add(btnSalvarInt);
		
		JLabel label_10 = new JLabel("   Caso queira alterar algo, clique no bot\u00E3o [Alterar] e, ap\u00F3s digitar, clique em [Salvar]!");
		label_10.setForeground(Color.GRAY);
		menuBar.add(label_10);
		
		JLabel lblEssasInformaesApenas = new JLabel("Essas informa\u00E7\u00F5es apenas n\u00F3s da Helpa! e voc\u00EA, entidade, t\u00EAm acesso! ");
		lblEssasInformaesApenas.setForeground(Color.GRAY);
		lblEssasInformaesApenas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEssasInformaesApenas.setBounds(31, 284, 556, 32);
		pnlInfoInt.add(lblEssasInformaesApenas);
		
		JLabel lblUsurio = new JLabel("Usu\u00E1rio:");
		lblUsurio.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUsurio.setBounds(41, 231, 66, 32);
		pnlInfoInt.add(lblUsurio);
		
		txtUsuario = new JTextField();
		txtUsuario.setEditable(false);
		txtUsuario.setText((String) null);
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(109, 234, 179, 30);
		pnlInfoInt.add(txtUsuario);
		
		JButton btnTrocarSenha = new JButton("Trocar Senha");
		btnTrocarSenha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TrocarSenha formTS = new TrocarSenha(entidadeLog);
				formTS.setVisible(true);
			}
		});
		btnTrocarSenha.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnTrocarSenha.setBounds(314, 231, 116, 39);
		pnlInfoInt.add(btnTrocarSenha);
		
		JLabel lblAlgumTtulo = new JLabel("\u00C1rea da Entidade");
		lblAlgumTtulo.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAlgumTtulo.setBounds(200, 43, 162, 24);
		pnlInfoInt.add(lblAlgumTtulo);
		
		pnlInfoPub = new JPanel();
		pnlInfoPub.setLayout(null);
		tabbedPane.addTab("Informa\u00E7\u00F5es P\u00FAblicas", null, pnlInfoPub, null);
		
		JMenuBar menuBar_1 = new JMenuBar();
		menuBar_1.setMargin(new Insets(10, 1, 1, 1));
		menuBar_1.setBounds(0, 0, 566, 32);
		pnlInfoPub.add(menuBar_1);
		
		JButton btnAlterarPub = new JButton("Alterar");
		btnAlterarPub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setTxtPub(true);
				cbxNecessidades.setEditable(true);
			}
		});
		menuBar_1.add(btnAlterarPub);
		
		btnSalvarPub = new JButton("Salvar");
		btnSalvarPub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if( !txtFoto.getText().equals("")     ||
					!txtSite.getText().equals("")     ||
					!txtDescricao.getText().equals("")||
					!txtNec1.getText().equals("")      )
				{
					try { 
						Entidade entidade = new Entidade(entidadeLog.getCodigo(), entidadeLog.getNome(),
						entidadeLog.getCnpj(),entidadeLog.getEndereco(), entidadeLog.getEmail(), entidadeLog.getTelefone(),
						entidadeLog.getUsuario(),entidadeLog.getSenha(), entidadeLog.getVisualizacoes(), txtDescricao.getText(),txtFoto.getText(),txtSite.getText());
						try
						{
							Entidades.alterar(entidade);
							entidadeLog = new Entidade(entidade);
							
							int qtd = Integer.parseInt(cbxNecessidades.getSelectedItem().toString());
							String produtos[] = new String[5];
							int x = 0;
							for (Component c : pnlNecessidades.getComponents()) 
							{
								if (c instanceof JTextField) 
							    {
									if(x < qtd)
									{
										produtos[x] = ((JTextField)c).getText();
										x++;
									}
							    }
							}
							
							Entidades.alterarNecessidades(entidade.getCodigo(), produtos);
						}
						catch(Exception ex) 
						{
							throw new Exception();
						}
					}
					catch(Exception ex) 
					{
						JOptionPane.showMessageDialog(null,"Informa��es inseridas inv�lidas. Altera��o cancelada!");
					}
					atualizarTela();
				}
				else
					JOptionPane.showMessageDialog(null,"N�o deixe campos em branco! Altera��o cancelada!");
				atualizarTela();
				cbxNecessidades.setEditable(false);
				btnSalvarPub.setEnabled(false);
			}
		});
		menuBar_1.add(btnSalvarPub);
		
		JLabel label_9 = new JLabel("   Caso queira alterar algo, clique no bot\u00E3o [Alterar] e, ap\u00F3s digitar, clique em [Salvar]!");
		label_9.setForeground(Color.GRAY);
		menuBar_1.add(label_9);
		
		JLabel lblSuasNecessidades = new JLabel("Necessidades");
		lblSuasNecessidades.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSuasNecessidades.setBounds(399, 43, 158, 32);
		pnlInfoPub.add(lblSuasNecessidades);
		
		txtSite = new JTextField();
		txtSite.setEditable(false);
		txtSite.setText((String) null);
		txtSite.setColumns(10);
		txtSite.setBounds(10, 57, 338, 30);
		pnlInfoPub.add(txtSite);
		
		JLabel label_4 = new JLabel("Site:");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_4.setBounds(10, 28, 69, 32);
		pnlInfoPub.add(label_4);
		
		JLabel label_6 = new JLabel("Foto:");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_6.setBounds(10, 86, 69, 32);
		pnlInfoPub.add(label_6);
		
		txtFoto = new JTextField();
		txtFoto.setEditable(false);
		txtFoto.setText((String) null);
		txtFoto.setColumns(10);
		txtFoto.setBounds(10, 112, 338, 30);
		pnlInfoPub.add(txtFoto);
		
		JLabel lblinsiraOLink = new JLabel("(Insira o link da imagem. Ex: http://recanto(...).jpg)");
		lblinsiraOLink.setForeground(Color.GRAY);
		lblinsiraOLink.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblinsiraOLink.setBounds(10, 136, 296, 32);
		pnlInfoPub.add(lblinsiraOLink);
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o:");
		lblDescrio.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDescrio.setBounds(10, 158, 101, 32);
		pnlInfoPub.add(lblDescrio);
		
		pnlNecessidades = new JPanel();
		pnlNecessidades.setBounds(359, 106, 191, 224);
		pnlInfoPub.add(pnlNecessidades);
		pnlNecessidades.setLayout(new GridLayout(5, 1, 0, 0));
		
		txtNec1 = new JTextField();
		txtNec1.setEditable(false);
		txtNec1.setColumns(10);
		pnlNecessidades.add(txtNec1);
		
		txtNec2 = new JTextField();
		txtNec2.setEditable(false);
		txtNec2.setColumns(10);
		pnlNecessidades.add(txtNec2);
		
		txtNec3 = new JTextField();
		txtNec3.setEditable(false);
		txtNec3.setColumns(10);
		pnlNecessidades.add(txtNec3);
		
		txtNec4 = new JTextField();
		txtNec4.setEditable(false);
		txtNec4.setColumns(10);
		pnlNecessidades.add(txtNec4);
		
		txtNec5 = new JTextField();
		txtNec5.setEditable(false);
		txtNec5.setColumns(10);
		pnlNecessidades.add(txtNec5);
		
		Vector<Integer> vetor = new Vector<Integer>();
		for(int i = 1; i<=5; i++)
			vetor.add(i);
		cbxNecessidades = new JComboBox<Integer>(vetor);
		cbxNecessidades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (Component c : pnlNecessidades.getComponents()) 
				{
					if (c instanceof JTextField) 
				    { 
						((JTextField)c).setVisible(false);
				    }
				}
				
				int qtd = Integer.parseInt(cbxNecessidades.getSelectedItem().toString());
				int x = 0;
				
				for (Component c : pnlNecessidades.getComponents()) {
					if(x<qtd)
					if (c instanceof JTextField) 
				    { 
						((JTextField)c).setVisible(true);
						((JTextField)c).setEditable(true);
						x++;
				    }
				}
			}
		});
		cbxNecessidades.setBounds(399, 75, 41, 32);
		pnlInfoPub.add(cbxNecessidades);
		
		JLabel label = new JLabel("Item(s)");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(445, 75, 131, 32);
		pnlInfoPub.add(label);
		
		txtDescricao = new JTextArea();
		txtDescricao.setBounds(10, 185, 338, 145);
		Dimension d = new Dimension();
		d.setSize(338, 145);
		txtDescricao.setPreferredSize(d);
		txtDescricao.setEditable(false);
		txtDescricao.setLineWrap(true);
		pnlInfoPub.add(txtDescricao);
		
		JPanel pnlRelatorio = new JPanel();
		pnlRelatorio.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent arg0) {
				DefaultTableModel model = null;
				try 
				{
					MeuResultSet dados = Entidades.getDoacoes(entidadeLog.getCodigo());
					model = new DefaultTableModel(new Object[][] {},
					new String[] {
						"Identifica��o", "Doador", "Produto", "Quantidade", "Data", "Entregue?"
					});
					
					while(dados.next())
					{
						model.addRow(new Object[] {dados.getInt(1)+"",dados.getString(2), dados.getString(3), dados.getString(4), dados.getDate(5)+"", dados.getString(6)});
					}
					tblRelatorio.setModel(model);
				}
				catch(Exception ex) 
				{
					ex.printStackTrace();
					System.out.print(ex.getMessage());
				}
			}
		});
		pnlRelatorio.setLayout(null);
		tabbedPane.addTab("Relat\u00F3rio", null, pnlRelatorio, null);
		
		JMenuBar menuBar_2 = new JMenuBar();
		menuBar_2.setBounds(0, 0, 676, 30);
		pnlRelatorio.add(menuBar_2);
		
		JLabel lblAquiEstoExibidas = new JLabel("Caso certa doa\u00E7\u00E3o j\u00E1 tenha sido entregue, clique sobre ela na tabela e no bot\u00E3o: ");
		lblAquiEstoExibidas.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAquiEstoExibidas.setForeground(Color.BLACK);
		menuBar_2.add(lblAquiEstoExibidas);
		
		JButton btnEntregue = new JButton("Entregue!");
		btnEntregue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				idDoacao = Integer.parseInt(tblRelatorio.getValueAt(tblRelatorio.getSelectedRow(), 0).toString());
				if(idDoacao<=0)
					JOptionPane.showMessageDialog(null,"Selecione uma doa��o para ser tida como entregue!");
				else
				{
					Doacao doacao = null;
					try
					{
						doacao = Doacoes.getDoacao(idDoacao);
						if(doacao.getEntregue() == 'S')
							throw new Exception("Essa doa��o j� est� dada como entregue!");
						doacao.setEntregue('S');
						Doacoes.alterar(doacao);
						tblRelatorio.setValueAt("S",linha, 5);
						JOptionPane.showMessageDialog(null,"Status de doa��o alterado com sucesso. Doa��o entregue!");
					}
					catch(Exception ex) 
					{
						JOptionPane.showMessageDialog(null, ex.getMessage());
					}
				}
			}
		});
		btnEntregue.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menuBar_2.add(btnEntregue);
		JLabel lblAquiEstoTodas = new JLabel("   Aqui est\u00E3o todas as doa\u00E7\u00F5es que as pessoas se comprometeram a fazer para a sua entidade");
		lblAquiEstoTodas.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAquiEstoTodas.setForeground(Color.GRAY);
		lblAquiEstoTodas.setBounds(0, 34, 519, 14);
		pnlRelatorio.add(lblAquiEstoTodas);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 54, 534, 275);
		pnlRelatorio.add(scrollPane_1);
		
		tblRelatorio = new JTable();
		scrollPane_1.setViewportView(tblRelatorio);
		atualizarTela();
		
	}
	
	private void setTxtInt(boolean modo)
	{
		txtNome.setEditable(modo);
		txtTelefone.setEditable(modo);
		txtEmail.setEditable(modo);
		txtEndereco.setEditable(modo);
		txtUsuario.setEditable(modo);
	}
	
	private void setTxtPub(boolean modo)
	{
		txtSite.setEditable(modo);
		txtFoto.setEditable(modo);
		txtDescricao.setEditable(modo);
		txtNec1.setEditable(modo);
		cbxNecessidades.setEnabled(modo);
	}
	
	private void atualizarTela() 
	{
		txtNome.setText(entidadeLog.getNome());
		txtEmail.setText(entidadeLog.getEmail());
		txtEndereco.setText(entidadeLog.getEndereco());
		txtTelefone.setText(entidadeLog.getTelefone());
		txtUsuario.setText(entidadeLog.getUsuario());
		txtSite.setText(entidadeLog.getSite());
		txtDescricao.setText(entidadeLog.getDescricao());
		txtFoto.setText(entidadeLog.getImagem());
		
		// exibir necessidades
		try {
			
			for (Component c : pnlNecessidades.getComponents()) 
			{
				if (c instanceof JTextField) 
			    { 
					((JTextField)c).setVisible(false);
			    }
			}
			
			MeuResultSet result = Entidades.getNecessidades(entidadeLog.getCodigo());
			result.last();
			int qtd = result.getRow();

			int x = 0;
			for (Component c : pnlNecessidades.getComponents()) {
				if(x<qtd)
				if (c instanceof JTextField) 
			    { 
					((JTextField)c).setVisible(true);
					((JTextField)c).setEditable(false);
					x++;
			    }
			}
			
			result.first();
			for (Component c : pnlNecessidades.getComponents()) {
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
		setTxtInt(false);
		setTxtPub(false);
	}
}
