import Control.Control;
import Model.Model;
import View.View;

public class Main {
	public static void main(String[] args){
	View v = new View();
	Model m = new Model();
	Control c = new Control(v, m);
	
	v.setVisible(true);
	}
}
