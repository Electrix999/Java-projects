import java.util.*;

public class MainClass {

	public static void main(String[] args) {
		
		List<Monom> x=new ArrayList<Monom>();
		x.add(new Monom(4,4));
		x.add(new Monom(1,2));
		x.add(new Monom(1,0));
		
		List<Monom> y=new ArrayList<Monom>();
		y.add(new Monom(3,2));
	//	y.add(new Monom(-1,3));
	//	y.add(new Monom(1,1));
//		y.add(new Monom(3,0));
		Polinom a=new Polinom(x);
		Polinom b=new Polinom(y);
		Polinom c=b.adunare(a);
		Polinom d=a.scadere(b);
		Polinom e=a.inmultire(b);
		//Polinom f=a.impartire(b);
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		System.out.println(e);
		//System.out.println(f);
		System.out.println(a.integrare());
		System.out.println((a.integrare()).derivare());
		
		
		
		
		Model model=new Model();
		View view=new View(model);
		Control control=new Control(model,view);
		view.setVisible(true);

	}

}
