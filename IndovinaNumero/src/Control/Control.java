package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.View;
import Model.Model;

public class Control implements ActionListener{
	private View v;
	private Model m;
	
	public Control(View v, Model m) {
		this.v=v;
		this.m=m; 
		v.registraController(this);
		m.NumeroDaIndovinare();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stu
		if(arg0.getActionCommand().equalsIgnoreCase("Invia")) {
			int numeroInserito = v.getNumeroInserito();
			//System.out.println(numeroInserito);
			boolean guess = m.IsGuessed(numeroInserito);
			if(guess) v.win();
			else {
				boolean piuAlto=m.altoBasso(numeroInserito);
				v.aiuto(piuAlto);
				v.scala();
			}
		}
	}
}
