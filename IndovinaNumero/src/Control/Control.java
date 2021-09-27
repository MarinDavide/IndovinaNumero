package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.View;
import log.Log;
import Model.Model;

public class Control implements ActionListener{
	private View v;
	private Model m;
	private Log l;
	boolean perso = false;
	public Control(View v, Model m, Log l) {
		this.v=v;
		this.m=m; 
		this.l=l;
		v.registraController(this);
		m.NumeroDaIndovinare();
		l.giocoIniziato();
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		if(arg0.getActionCommand().equalsIgnoreCase("Invia")) {
			l.getStampDate("Hai premuto il tasto 'Invia'");
			int numeroInserito=-1;
			boolean numeroValido=true;
			try {
				numeroInserito = v.getNumeroInserito();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				v.scriviAiuto("Inserire un valore numerico");
				l.getStampDate("E' stato inserito un valore non valido");
				numeroValido = false;
			}
			if(numeroValido) {
				boolean guessed = m.IsGuessed(numeroInserito);
				if(guessed) {
					v.win();
					l.getStampDate("Hai indovinato il numero");
				}
				else {
					boolean piuAlto=m.altoBasso(numeroInserito);
					v.aiuto(piuAlto);
					l.numeroAltoBasso(piuAlto);
					perso = v.scala();
					if(perso) l.getStampDate("Hai finito i tentativi, ha perso"); 
				}
			}
		}
		if(arg0.getActionCommand().equalsIgnoreCase("View log")) {
			l.getStampDate("Pulsante log premuto");
			l.showLog();
			v.showLog();	
		}
		if(arg0.getActionCommand().equalsIgnoreCase("Back")) {
			l.getStampDate("Pulsante home premuto");
			v.hideLog(perso);
		}
		if(arg0.getActionCommand().equalsIgnoreCase("Rigioca")) {
			perso = false;
			m.NumeroDaIndovinare();
			v.restart();
			l.getStampDate("Nuova partita iniziata");
		}
	}
}
