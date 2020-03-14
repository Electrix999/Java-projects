package Main;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Control.Control;
import Model.Monom;
import Model.Polinom;
import View.View;

public class MainClass {

	public static void main(String[] args) {
			
		View view=new View();
		Control control=new Control(view);
		view.setVisible(true);

	}

}
