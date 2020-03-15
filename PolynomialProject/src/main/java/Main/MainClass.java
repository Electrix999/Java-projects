package Main;
import Control.Control;
import View.View;

public class MainClass {

	public static void main(String[] args) {
			
		View view=new View();
		Control control=new Control(view);
		view.setVisible(true);

	}

}
