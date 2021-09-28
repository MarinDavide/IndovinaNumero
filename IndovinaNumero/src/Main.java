import Control.Control;
import Model.Model;
import View.View;
import log.Log;

public class Main {
	public static void start() {
		View v = new View();
		Model m = new Model();
		Log l = new Log(v);
		Control c = new Control(v, m, l);
		v.setVisible(true);
	}
	public static void main(String[] args){
		start();
	}
}
