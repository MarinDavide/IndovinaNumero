package View;

import java.awt.EventQueue;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import Control.Control;

import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.DropMode;
import javax.swing.JScrollPane;

public class View {

	private JFrame frame;
	private JTextField textGuess;
	private JButton btnInvia;
	private JButton btnLog;
	private JButton btnHome;
	private JLabel lblTentativi;
	private JLabel lblTitolo;
	private JLabel lblNewLabel;
	private JLabel lblAiuto;
	private JTextArea textLog;
	private JButton btnNewGame;
	private JScrollPane sP;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View window = new View();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public View() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		btnInvia = new JButton("Invia");
		btnInvia.setBounds(178, 162, 89, 23);
		frame.getContentPane().add(btnInvia);
		
		textGuess = new JTextField();
		textGuess.setEditable(true);
		textGuess.setBounds(178, 131, 89, 20);
		frame.getContentPane().add(textGuess);
		textGuess.setColumns(10);
		
		lblTentativi = new JLabel("");
		lblTentativi.setHorizontalAlignment(SwingConstants.CENTER);
		lblTentativi.setBounds(236, 75, 18, 23);
		frame.getContentPane().add(lblTentativi);
		
		lblTitolo = new JLabel("Indovina il Numero");
		lblTitolo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTitolo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitolo.setBounds(10, -12, 414, 53);
		frame.getContentPane().add(lblTitolo);
		
		lblNewLabel = new JLabel("Tentativi: ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(125, 79, 113, 14);
		frame.getContentPane().add(lblNewLabel);
		
		lblAiuto = new JLabel("");
		lblAiuto.setHorizontalAlignment(SwingConstants.CENTER);
		lblAiuto.setBounds(104, 104, 226, 14);
		frame.getContentPane().add(lblAiuto);
		
		btnLog = new JButton("View log");
		btnLog.setBounds(178, 227, 89, 23);
		frame.getContentPane().add(btnLog);
		btnLog.setVisible(true);
		
		btnHome = new JButton("Back");
		btnHome.setBounds(178, 227, 89, 23);
		frame.getContentPane().add(btnHome);
		btnHome.setVisible(false);
		
		textLog = new JTextArea();
		textLog.setTabSize(7);
		textLog.setBounds(10, 30, 414, 185);
		textLog.setEditable(false);
		//frame.getContentPane().add(textLog);
		//textLog.setVisible(false);
		
		btnNewGame = new JButton("Rigioca");
		btnNewGame.setBounds(20, 227, 89, 23);
		frame.getContentPane().add(btnNewGame);
		btnNewGame.setVisible(false);
		
		sP = new JScrollPane(textLog);
		sP.setBounds(10, 29, 414, 182);
		frame.getContentPane().add(sP);
		sP.setVisible(false);
		
		
	}

	public void registraController(Control control) {
		btnInvia.addActionListener(control);
		btnLog.addActionListener(control);
		btnHome.addActionListener(control);
		btnNewGame.addActionListener(control);
	}
	
	public void setVisible(boolean b) {
		frame.setVisible(b);
	}
	
	public int getNumeroInserito(){
		String NumeroIns = textGuess.getText();
		int numeroInserito = Integer.parseInt(NumeroIns);
		return numeroInserito;
	}
	public void win() {
		btnInvia.setEnabled(false);
		textGuess.setEditable(false);
		lblAiuto.setText("Numero indovinato, hai vinto");
		btnLog.setVisible(true);
		btnNewGame.setVisible(true);
	}
	public void aiuto(boolean piuAlto) {
		if(piuAlto) lblAiuto.setText("Il numero e' piu' alto");
		else lblAiuto.setText("Il numero e' piu' basso");
	}
	public boolean scala() {
		boolean perso = false;
		String nTent = lblTentativi.getText();
		int nTentativi = Integer.parseInt(nTent);
		nTentativi--;
		if(nTentativi<=0) {
			btnInvia.setEnabled(false);
			textGuess.setEditable(false);
			lblAiuto.setText("Tentativi esauriti, hai perso");
			btnNewGame.setVisible(true);
			perso = true;
		}
		nTent=String.valueOf(nTentativi);
		lblTentativi.setText(nTent);
		return perso;
	}
	public void setTextLog(String testo) {
		textLog.setText("");
		textLog.setText(testo);
	}
	public void showLog() {
		textGuess.setVisible(false);
		btnInvia.setVisible(false);
		lblTentativi.setVisible(false);
		lblNewLabel.setVisible(false);
		lblAiuto.setVisible(false);
		btnLog.setVisible(false);
		lblTitolo.setText("Log");
		textLog.setVisible(true);
		btnHome.setVisible(true);
		sP.setVisible(true);
	}
	public void hideLog(boolean perso) {
		if(perso) {
			btnInvia.setEnabled(false);
			textGuess.setEditable(false);
		}
		textGuess.setVisible(true);
		btnInvia.setVisible(true);
		lblTentativi.setVisible(true);
		lblNewLabel.setVisible(true);
		lblAiuto.setVisible(true);
		btnLog.setVisible(true);
		lblTitolo.setText("Indovina il numero");
		textLog.setVisible(false);
		btnHome.setVisible(false);
		sP.setVisible(false);
	}
	public void scriviAiuto(String messaggio) {
		lblAiuto.setText(messaggio);
	}
	public void restart(String tentativi) {
		textGuess.setEditable(true);
		btnInvia.setEnabled(true);
		textGuess.setText("");
		textGuess.setVisible(true);
		btnInvia.setVisible(true);
		lblTentativi.setText(tentativi);
		lblTentativi.setVisible(true);
		lblNewLabel.setVisible(true);
		lblAiuto.setText("");
		lblAiuto.setVisible(true);
		btnLog.setVisible(true);
		lblTitolo.setText("Indovina il numero");
		textLog.setVisible(false);
		btnHome.setVisible(false);
		btnNewGame.setVisible(false);
	}
}
