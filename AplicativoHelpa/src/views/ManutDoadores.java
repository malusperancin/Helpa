package views;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import bd.core.MeuResultSet;
import bd.daos.Pessoas;
import bd.dbos.Pessoa;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import java.awt.Insets;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class ManutDoadores extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtCodigo;
	private JTextField txtEmail;
	private JTextField txtEndereco;
	private JTextField txtTelefone;
	private JTextField txtCidade;
	JButton btnSalvar;
	private JTextField txtUf;
	private JTable tblRelatorio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManutDoadores frame = new ManutDoadores();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ManutDoadores() {
		contentPane = new JPanel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 497, 364);
		setContentPane(contentPane );
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setToolTipText("CADASTRO");
		tabbedPane.setBounds(0, 0, 476, 292);
		contentPane.add(tabbedPane);
		
		JPanel pnlManutencao = new JPanel();
		pnlManutencao.setLayout(null);
		tabbedPane.addTab("Manuten\u00E7\u00E3o", null, pnlManutencao, null);
		
		JLabel label = new JLabel("C\u00F3digo:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label.setBounds(21, 43, 59, 32);
		pnlManutencao.add(label);
		
		JLabel label_1 = new JLabel("Nome:");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_1.setBounds(31, 83, 48, 32);
		pnlManutencao.add(label_1);
		
		txtNome = new JTextField();
		txtNome.setText((String) null);
		txtNome.setEditable(false);
		txtNome.setColumns(10);
		txtNome.setBounds(90, 80, 355, 30);
		pnlManutencao.add(txtNome);
		
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
							JOptionPane.showMessageDialog(null,"Não foi possível achar o doador com esse código!");
					}
					else
						JOptionPane.showMessageDialog(null,"Escreva um código válido no campo de código!");
					txtCodigo.setEditable(false);
				}
			}
		});
		txtCodigo.setEditable(false);
		txtCodigo.setText((String) null);
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(90, 43, 109, 30);
		pnlManutencao.add(txtCodigo);
		
		JLabel label_3 = new JLabel("E-mail:");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_3.setBounds(21, 115, 59, 32);
		pnlManutencao.add(label_3);
		
		JLabel label_4 = new JLabel("Telefone:");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_4.setBounds(10, 149, 69, 32);
		pnlManutencao.add(label_4);
		
		JLabel label_7 = new JLabel("Endere\u00E7o:");
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_7.setBounds(8, 185, 72, 32);
		pnlManutencao.add(label_7);
		
		txtEmail = new JTextField();
		txtEmail.setText((String) null);
		txtEmail.setEditable(false);
		txtEmail.setColumns(10);
		txtEmail.setBounds(90, 115, 355, 30);
		pnlManutencao.add(txtEmail);
		
		txtEndereco = new JTextField();
		txtEndereco.setText((String) null);
		txtEndereco.setEditable(false);
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(90, 188, 355, 30);
		pnlManutencao.add(txtEndereco);
		
		txtTelefone = new JTextField();
		txtTelefone.setText((String) null);
		txtTelefone.setEditable(false);
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(90, 149, 179, 30);
		pnlManutencao.add(txtTelefone);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setMargin(new Insets(10, 1, 1, 1));
		menuBar.setBounds(0, 0, 471, 32);
		pnlManutencao.add(menuBar);
		
		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtCodigo.setEditable(true);
			}
		});
		menuBar.add(btnProcurar);
		
		JLabel label_2 = new JLabel("|");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		menuBar.add(label_2);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try 
				{
					Pessoas.excluir(Integer.parseInt(txtCodigo.getText()));
					atualizarTela();
					JOptionPane.showMessageDialog(null,"Doador excluído com sucesso");
				}
				catch(Exception er)
				{
					JOptionPane.showMessageDialog(null,"Não foi possível excluir esse doador!");
				}
			}
		});
		menuBar.add(btnExcluir);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizarTela();
				setTxt(false);
				txtCodigo.setEditable(false);
			}
		});
		menuBar.add(btnCancelar);
		
		JLabel label_6 = new JLabel("|");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		menuBar.add(label_6);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if( !txtCodigo.getText().equals("")  ||
					!txtNome.getText().equals("")    ||
					!txtEmail.getText().equals("")   ||
					!txtTelefone.getText().equals("")||
					!txtEndereco.getText().equals("")||
					!txtCidade.getText().equals("")  ||
					!txtUf.getText().equals("")       )
					{
						try
						{
							Pessoa antiga = Pessoas.getPessoa(Integer.parseInt(txtCodigo.getText()));
							Pessoa pessoa = null;
							try 
							{
								pessoa = new Pessoa(Integer.parseInt(txtCodigo.getText()), txtNome.getText(),
								txtEmail.getText(), txtEndereco.getText(), antiga.getSenha(), txtTelefone.getText(), 
								txtCidade.getText(), txtUf.getText());
							}
							catch(Exception ex) {throw new Exception();}
							Pessoas.alterar(pessoa);
						}
						catch(Exception ex) 
						{
							JOptionPane.showMessageDialog(null,"Não foi possível editar o doador com os novos dados inseridos. Alteração cancelada!");
						}
					}
					else
						JOptionPane.showMessageDialog(null,"Não deixe campos em branco! Alteração cancelada!");
					atualizarTela();
					setTxt(false);
					btnSalvar.setEnabled(false);
			}
		});
		btnSalvar.setEnabled(false);
		menuBar.add(btnSalvar);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCidade.setBounds(26, 223, 54, 32);
		pnlManutencao.add(lblCidade);
		
		txtCidade = new JTextField();
		txtCidade.setText((String) null);
		txtCidade.setEditable(false);
		txtCidade.setColumns(10);
		txtCidade.setBounds(90, 226, 221, 30);
		pnlManutencao.add(txtCidade);
		
		JLabel lblUf = new JLabel("UF:");
		lblUf.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUf.setBounds(336, 223, 54, 32);
		pnlManutencao.add(lblUf);
		
		txtUf = new JTextField();
		txtUf.setText((String) null);
		txtUf.setEditable(false);
		txtUf.setColumns(10);
		txtUf.setBounds(370, 226, 48, 30);
		pnlManutencao.add(txtUf);
		
		JPanel pnlRelatorio = new JPanel();
		pnlRelatorio.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent arg0) {
				DefaultTableModel model = null;
				try 
				{
					MeuResultSet dados = Pessoas.getPessoasDoa();
					 model = new DefaultTableModel(new Object[][] {},
					new String[] {
						"C\u00F3digo", "Nome Doador", "Vezes"
					});
					while(dados.next())
					{
						model.addRow(new Object[] {dados.getInt(1)+"", dados.getString(2), dados.getInt(3)+""});
					}
					tblRelatorio.setModel(model);
				}
				catch(Exception ex) 
				{
					System.out.print(ex.getMessage());
				}
			}
		});
		pnlRelatorio.setLayout(null);
		tabbedPane.addTab("Relat\u00F3rio", null, pnlRelatorio, null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 32, 451, 223);
		pnlRelatorio.add(scrollPane);
		
		tblRelatorio = new JTable();
		scrollPane.setViewportView(tblRelatorio);
		
		JMenuBar menuBar_1 = new JMenuBar();
		menuBar_1.setBounds(0, 0, 537, 21);
		pnlRelatorio.add(menuBar_1);
		
		JLabel lblAquiEstEm = new JLabel("   Aqui, os doadores est\u00E3o ranqueados por quantidade de vezes que realizar\u00E3o doa\u00E7\u00F5es:");
		menuBar_1.add(lblAquiEstEm);
		
		JButton btnVoltarPA = new JButton("Voltar p/ a \u00E1rea");
		btnVoltarPA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
			
		});
		btnVoltarPA.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnVoltarPA.setBounds(172, 291, 133, 34);
		contentPane.add(btnVoltarPA);
		
		atualizarTela();
	}
	
	private void atualizarTela() 
	{
		Pessoa oDoador = null;
		try 
		{
			oDoador = Pessoas.getPessoa(Integer.parseInt(txtCodigo.getText()));
		}
		catch(Exception ex) 
		{
			try 
			{
				oDoador = Pessoas.getPrimeiroRegistro();
			} 
			catch (Exception e) {
				JOptionPane.showMessageDialog(null, "message");
			} // nunca vai dar erro pois a tabela nunca estará vazia 
		}
		txtCodigo.setText(oDoador.getCodigo()+"");
		txtNome.setText(oDoador.getNome());
		txtEmail.setText(oDoador.getEmail());
		txtEndereco.setText(oDoador.getEndereco());
		txtTelefone.setText(oDoador.getTelefone());
		txtCidade.setText(oDoador.getCidade());
		txtUf.setText(oDoador.getUf());
	}
	
	private void setTxt(boolean modo)
	{
		txtCodigo.setEditable(modo);
		txtNome.setEditable(modo);
		txtEmail.setEditable(modo);
		txtEndereco.setEditable(modo);
		txtEmail.setEditable(modo);
		txtTelefone.setEditable(modo);
		txtCidade.setEditable(modo);
		txtUf.setEditable(modo);
	}
}
