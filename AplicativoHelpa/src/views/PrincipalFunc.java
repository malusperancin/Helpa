package views;
import bd.daos.*;
import bd.dbos.*;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Font;
import javax.swing.JMenuBar;

public class PrincipalFunc extends JFrame {
	
	private JFrame frame;
	//private JPanel contentPane;
	Funcionario funcionarioLog;
	boolean alterou = false;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalFunc frame = new PrincipalFunc(12);
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
	int codigo;
	private JTextField txtNome;
	private JTextField txtEmail;
	private JTextField txtTelefone;
	private JTextField txtEndereco;
	private JTextField txtUsuario;
	private JButton btnSalvar;
	JButton btnCancelar;
	
	public PrincipalFunc(int cod) {
		codigo = cod;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		try
		{
		  funcionarioLog = new Funcionario(Funcionarios.getFuncionarioByCod(codigo));
		}
		catch(Exception ex) {} // n vai dar erro pois o codigo foi eu que passei
		
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				if(alterou)
				{
					int choice = JOptionPane.showOptionDialog(null, 
						      "Deseja sair e salvar?", 
						      "Sair", 
						      JOptionPane.YES_NO_CANCEL_OPTION, 
						      JOptionPane.QUESTION_MESSAGE, 
						      null, null, null);

						  if (choice == JOptionPane.YES_OPTION)
						  {
							  btnSalvar.doClick();
						  }
						  else if(choice == JOptionPane.NO_OPTION)
						  {
							  System.exit(0);
						  }
				}
				else
					System.exit(0);
			}
		});
		frame.getContentPane().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// ABRIR FORM DE MANUTEN��O DE ENTIDADES
				ManutEntidades formME = new ManutEntidades();
				formME.setVisible(true);
			}
		});
		frame.setBounds(100, 100, 485, 361);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("Nome:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label.setBounds(55, 53, 48, 32);
		frame.getContentPane().add(label);
		
		JLabel label_2 = new JLabel("E-mail:");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_2.setBounds(50, 127, 53, 23);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("Telefone:");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_3.setBounds(37, 93, 73, 23);
		frame.getContentPane().add(label_3);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setTxts(true);
				btnSalvar.setEnabled(true);
				alterou = true;
			}
		});
		btnAlterar.setForeground(Color.BLACK);
		btnAlterar.setBounds(100, 229, 85, 32);
		frame.getContentPane().add(btnAlterar);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.setEnabled(false);
		btnSalvar.setBounds(290, 229, 85, 32);
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtNome.getText().equals("") ||
				txtEmail.getText().equals("") ||
				txtTelefone.getText().equals("") ||
				txtEndereco.getText().equals("") ||
				txtUsuario.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null,"N�o deixe nenhum campo em branco!");
				}
				else
				{
					try
					{
						funcionarioLog.setEndereco(txtEndereco.getText());
						funcionarioLog.setUsuario(txtUsuario.getText());
						funcionarioLog.setEmail(txtEmail.getText());
						funcionarioLog.setNome(txtNome.getText());
						funcionarioLog.setTelefone(txtTelefone.getText());
						Funcionarios.alterar(funcionarioLog);
						alterou = false;
						JOptionPane.showMessageDialog(null,"Altera��o feita com sucesso!");
					}
					catch(Exception ex) 
					{
						JOptionPane.showMessageDialog(null,ex.getMessage() + "Altera��o cancelada");
					}
				}
				btnCancelar.doClick();
			}
		});
		frame.getContentPane().add(btnSalvar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtEmail.setText(funcionarioLog.getEmail());
				txtNome.setText(funcionarioLog.getNome());
				txtEndereco.setText(funcionarioLog.getEndereco());
				txtUsuario.setText(funcionarioLog.getUsuario());
				txtTelefone.setText(funcionarioLog.getTelefone());

				setTxts(false);
			}
		});
		btnCancelar.setForeground(Color.BLACK);
		btnCancelar.setBounds(195, 229, 85, 32);
		frame.getContentPane().add(btnCancelar);
		
		txtNome = new JTextField();
		txtNome.setEditable(false);
		txtNome.setBounds(119, 62, 298, 23);
		frame.getContentPane().add(txtNome);
		txtNome.setColumns(10);
		txtNome.setText(funcionarioLog.getNome());
		
		txtEmail = new JTextField();
		txtEmail.setEditable(false);
		txtEmail.setColumns(10);
		txtEmail.setBounds(119, 129, 298, 23);
		frame.getContentPane().add(txtEmail);
		txtEmail.setText(funcionarioLog.getEmail());
		
		txtTelefone = new JTextField();
		txtTelefone.setEditable(false);
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(119, 95, 298, 23);
		frame.getContentPane().add(txtTelefone);
		txtTelefone.setText(funcionarioLog.getTelefone());
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o:");
		lblEndereo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEndereo.setBounds(30, 161, 73, 23);
		frame.getContentPane().add(lblEndereo);
		
		txtEndereco = new JTextField();
		txtEndereco.setEditable(false);
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(119, 161, 298, 23);
		frame.getContentPane().add(txtEndereco);
		txtEndereco.setText(funcionarioLog.getEndereco());
		
		JLabel lblUsurio = new JLabel("Usu\u00E1rio:");
		lblUsurio.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUsurio.setBounds(43, 195, 60, 23);
		frame.getContentPane().add(lblUsurio);
		
		txtUsuario = new JTextField();
		txtUsuario.setEditable(false);
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(119, 194, 200, 23);
		frame.getContentPane().add(txtUsuario);
		txtUsuario.setText(funcionarioLog.getUsuario());
		
		JButton btnTrocarSenha = new JButton("Trocar senha");
		btnTrocarSenha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TrocarSenha formTS = new TrocarSenha(funcionarioLog);
				formTS.setVisible(true);
			}
		});
		btnTrocarSenha.setForeground(Color.BLACK);
		btnTrocarSenha.setBounds(322, 189, 95, 32);
		frame.getContentPane().add(btnTrocarSenha);
		
		JLabel lblHelpa = new JLabel(" \u00C1rea do funcion\u00E1rio");
		lblHelpa.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblHelpa.setBounds(159, 21, 190, 37);
		frame.getContentPane().add(lblHelpa);
		
		JMenu menManutencao;
		
		
		JLabel lblNewLabel = new JLabel("HELPA!");
		lblNewLabel.setBounds(216, 11, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(132, 279, 97, 21);
		frame.getContentPane().add(menuBar);
		menManutencao = new JMenu("MANUTEN\u00C7\u00D5ES");
		menuBar.add(menManutencao);
		menManutencao.setHorizontalAlignment(SwingConstants.CENTER);
		

		JMenuItem miManutEntidades = new JMenuItem("ENTIDADES");
		miManutEntidades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// manunetncao ENTIDADES
				ManutEntidades formME = new ManutEntidades();
				formME.setVisible(true);
			}
		});
		menManutencao.add(miManutEntidades);
		
		JMenuItem miManutDoadores = new JMenuItem("DOADORES");
		miManutDoadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ManutDoadores formMD = new ManutDoadores();
				formMD.setVisible(true);
			}
		});
		menManutencao.add(miManutDoadores);
		
		
		JMenuItem miManutFuncs = new JMenuItem("FUNCION\u00C1RIOS");
		miManutFuncs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(funcionarioLog.getCargo().equals("chefe de manuten��o")) // acho q nem precisa
				{
					ManutFuncionarios formMF = new ManutFuncionarios();
					formMF.setVisible(true);
				}
				else
					JOptionPane.showMessageDialog(null,"Voc� n�o tem permiss�o para acessar essa camada de manuten��o");
			}
		});
		menManutencao.add(miManutFuncs);
		
		JButton btnRelatrio = new JButton("RELAT\u00D3RIO");
		btnRelatrio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Relatorio formR = new Relatorio();
				formR.setVisible(true);
			}
		});
		btnRelatrio.setBounds(249, 277, 100, 23);
		frame.getContentPane().add(btnRelatrio);
		
		menManutencao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		
		if(!funcionarioLog.getCargo().equals("chefe de manuten��o"))
		{
			miManutFuncs.setEnabled(false);
		}
		frame.setVisible(true);
	}
	
	private void setTxts(boolean modo)
	{
		txtNome.setEditable(modo); 
		txtEmail.setEditable(modo);
		txtTelefone.setEditable(modo);
		txtEndereco.setEditable(modo);
		txtUsuario.setEditable(modo);
	}
}