package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import Control.Control;

import java.awt.Font;

public class View {

	private JFrame frame;
	private JTextField textGuess;
	private JButton btnInvia;
	private JLabel lblTentativi;
	private JLabel lblTitolo;
	private JLabel lblNewLabel;
	private JLabel lblAiuto;
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
		btnInvia.setBounds(178, 154, 89, 23);
		frame.getContentPane().add(btnInvia);
		
		textGuess = new JTextField();
		textGuess.setBounds(178, 131, 89, 20);
		frame.getContentPane().add(textGuess);
		textGuess.setColumns(10);
		
		lblTentativi = new JLabel("5");
		lblTentativi.setHorizontalAlignment(SwingConstants.CENTER);
		lblTentativi.setBounds(236, 75, 18, 23);
		frame.getContentPane().add(lblTentativi);
		
		lblTitolo = new JLabel("Indovina il Numero");
		lblTitolo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTitolo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitolo.setBounds(10, 11, 414, 53);
		frame.getContentPane().add(lblTitolo);
		
		lblNewLabel = new JLabel("Tentativi: ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(125, 79, 113, 14);
		frame.getContentPane().add(lblNewLabel);
		
		lblAiuto = new JLabel("");
		lblAiuto.setHorizontalAlignment(SwingConstants.CENTER);
		lblAiuto.setBounds(104, 104, 226, 14);
		frame.getContentPane().add(lblAiuto);
	}

	public void registraController(Control control) {
		btnInvia.addActionListener(control);
		
	}
	
	public void setVisible(boolean b) {
		frame.setVisible(b);
	}
	
	public int getNumeroInserito() {
		String NumeroIns = textGuess.getText();
		int NumeroInserito = Integer.parseInt(NumeroIns);
		return NumeroInserito;
	}
	public void win() {
		textGuess.setVisible(false);
		btnInvia.setVisible(false);
		lblTentativi.setVisible(false);
		lblNewLabel.setVisible(false);
		lblAiuto.setVisible(false);
		lblTitolo.setText("HAI VINTO");
	}
	public void aiuto(boolean piuAlto) {
		if(piuAlto) lblAiuto.setText("Il numero e' piu' alto");
		else lblAiuto.setText("Il numero e' piu' basso");
	}
	public void scala() {
		String nTent = lblTentativi.getText();
		int nTentativi = Integer.parseInt(nTent);
		nTentativi--;
		if(nTentativi<=0) {
			textGuess.setVisible(false);
			btnInvia.setVisible(false);
			lblTentativi.setVisible(false);
			lblNewLabel.setVisible(false);
			lblAiuto.setVisible(false);
			lblTitolo.setText("HAI PERSO");
		}
		else {
			nTent=String.valueOf(nTentativi);
			lblTentativi.setText(nTent);
		}
	}
}
