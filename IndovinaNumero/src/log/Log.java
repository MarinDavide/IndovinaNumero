package log;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import View.View;

public class Log {
	SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss:SS");
	SimpleDateFormat form = new SimpleDateFormat("yyyyMMddhhmmss");
	boolean nuovaPartita = false;
	private View v;
	public Log(View v) {
		this.v=v;
	}

	public void getStampDate(String messaggioLog) {
		String courrentDate = formatter.format(new Date());
		messaggioLog = "[" + courrentDate + "] " + messaggioLog+"\n";
		FileWriter fw = null;
		try {
			if(nuovaPartita) fw = new FileWriter("log.txt", false);
			else fw = new FileWriter("log.txt", true);
			fw.write(messaggioLog);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public String getCourrentDate() {
		String date = "";
		String courrentDate = form.format(new Date());
		date = courrentDate;
		return date;
	}
	public void giocoIniziato() {
		nuovaPartita = true;
		boolean fileEsistente = true;
		FileReader fr = null;
		try {
			fr = new FileReader("log.txt");
		} 
		catch (IOException e) {
		System.out.println("file non esistente");
		fileEsistente= false;
		}
		if(fileEsistente) {
			FileWriter fwr = null;
			try {
				fwr = new FileWriter (getCourrentDate()+"_log.txt");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int i = 0;
			try {
				while ((i = fr.read()) != -1 ) {
					fwr.write(i);
				}
				fr.close();
				fwr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		getStampDate("Nuova partita iniziata");
		nuovaPartita = false;
	}

	public void numeroAltoBasso(boolean piuAlto) {
		if (piuAlto) {
			getStampDate("Il numero da indovinare e' piu' alto");
		} else {
			getStampDate("Il numero da indovinare e' piu' basso");
		}
	}

	public void showLog() {
		FileReader fr = null;
		String log = "";
		try {
			fr = new FileReader("log.txt");
			int i = 0;
			while ((i = fr.read()) != -1) {
				
				log = ""+log+(char) i+"";
			}
			v.setTextLog(log);
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

/*
package ScritturaSuFile;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		//SCRITTURA
		//Creazione file
		String s = "Testo di provare da scrivere nel file";
		String string = "\nTesto di provare da scrivere nel file con string";
		FileWriter fw = null;
		try {
			fw = new FileWriter("testo.txt");
			char ch[] = s.toCharArray();
			for (int i = 0; i < ch.length; i++) {
				fw.write(ch[i]);
			}
			fw.write(string);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		//LETTURA
		FileReader fr = null;
		 try {
			fr = new FileReader ("testo.txt");
			int i = 0;
			while ((i = fr.read()) != -1 ) {
				System.out.println((char) i);
				
			}
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
*/