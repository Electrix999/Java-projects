package Control;
import java.awt.event.*;

import java.util.ArrayList;
import java.util.List;

import Model.Monom;
import Model.Polinom;
import View.View;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Control {
	
	private View mView;
	public Control(View view)
	{
		
		mView=view;
		
		view.addListener(new AddListener());
		view.subListener(new SubListener());
		view.mulListener(new MulListener());
		view.divListener(new DivListener());
		view.derListener(new DerListener());
		view.iListener(new IListener());
	}
	

	public static String verifCoeficient(String s)//metoda pentru a verifica daca avem x sau -x si pentru setarea corespunzatoare a coeficientului
	{
		String x="";
		if(s.equals(""))
		{
			x="1";
		}
		else if(s.equals("-"))
		{
			x="-1";
		}
		else
		{
			x=s;
		}
		return x;
	}
	
	public static Polinom regexPoly(String exp) throws BadInp
	{
		List<Monom> x=new ArrayList<Monom>();
		
		Pattern polyPatt=Pattern.compile("([+-]?\\d*)x(\\^([+-]?\\d+))?|([+-]?\\d+)");//pattern ce stabileste formatul ce trebuie introdus pentru un polinom valid:+-ax^n sau +-bx sau +-c,fiecare optiune din cele 3 fiind valide
		Matcher matcher = polyPatt.matcher(exp);
		
		String coef="";
		String power="";
		String verificare="";
			while (matcher.find()) {
			    if(matcher.group(4)!=null && matcher.group(3)==null)//group(3)-gradul,in cazul in care avem x^, group(4)-val termenului liber
			    {
			    	coef=matcher.group(4);
			    	power="0";
			    }
			    else if(matcher.group(4)==null && matcher.group(3)==null)//daca si gradul e null si termenul liber e null,inseamna ca gradul e 1
			    {
			    	coef=verifCoeficient(matcher.group(1));
			    	power="1";
			    }
			    else
			    {
			    	coef=verifCoeficient(matcher.group(1));//group(1),coeficientul pentru toti termenii,in afara de termenul liber 
			    	power=matcher.group(3);
			    }
			    verificare+=matcher.group(0);//group(0)-termenii polinomului
			    x.add(new Monom(Integer.parseInt(coef),Integer.parseInt(power)));
			}
				if(!exp.equals(verificare))//daca la final polinomul arata ca la inceput inseamna ca input-ul a fost valid
				{
					throw new BadInp("Bad Input!!!");
				}
			return new Polinom(x);
	}
	
	
	class AddListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {

			try
			{
				
				
				Polinom pol1=Control.regexPoly(mView.getPoli1());
				Polinom pol2=Control.regexPoly(mView.getPoli2());
				Polinom rezultat=new Polinom();
				
				rezultat=pol1.adunare(pol2);//adunare intre polinoame
				
				mView.setResult(rezultat.toString());
				mView.setRest("-");
				
			}
			catch(BadInp exp)
			{
				mView.showError("Bad Input!");
			}
			
			
			
		}
	}
	
		class SubListener implements ActionListener{
			
			public void actionPerformed(ActionEvent e) {

				try
				{
					
					Polinom pol1=Control.regexPoly(mView.getPoli1());
					Polinom pol2=Control.regexPoly(mView.getPoli2());
					Polinom rezultat=new Polinom();
					
					rezultat=pol1.scadere(pol2);//scadere intre polinoame 
					
					mView.setResult(rezultat.toString());
					mView.setRest("-");
					
				}
				catch(BadInp exp)
				{
					mView.showError("Bad Input!");
				}
			}
		}
		
class MulListener implements ActionListener{
			
			public void actionPerformed(ActionEvent e) {

				try
				{
					
					Polinom pol1=Control.regexPoly(mView.getPoli1());
					Polinom pol2=Control.regexPoly(mView.getPoli2());
					Polinom rezultat=new Polinom();
					
					rezultat=pol1.inmultire(pol2);//inmultire intre polinoame
					
					mView.setResult(rezultat.toString());
					mView.setRest("-");
					
				}
				catch(BadInp exp)
				{
					mView.showError("Bad Input!");
				}
				
				
			}
		}

class DivListener implements ActionListener{
	
	public void actionPerformed(ActionEvent e) {

		try
		{
			
			Polinom pol1=Control.regexPoly(mView.getPoli1());
			Polinom pol2=Control.regexPoly(mView.getPoli2());
			if(pol1.getPoli().get(0).getGrad()<pol2.getPoli().get(0).getGrad())//daca gradul primului polinom < se genereaza o exceptie
			{
				throw new GradeException("Gradul primului polinom trebuie sa fie mai mare decat gradul celui de al doilea!!");
			}
			Polinom rezultat=new Polinom();
			Polinom rest=new Polinom();
			
			rezultat=(pol1.impartire(pol2)).get(0);
			rest=(pol1.impartire(pol2)).get(1);
			
			mView.setResult(rezultat.toString());
			mView.setRest(rest.toString());
			
		}
		catch(BadInp exp)
		{
			mView.showError("Bad Input!");
		}
		catch(GradeException exp)
		{
			mView.showError(exp.getMessage());
		}
		
		
	}
}

class DerListener implements ActionListener{
	
	public void actionPerformed(ActionEvent e) {

		try
		{
			
			Polinom pol1=Control.regexPoly(mView.getPoli1());
			Polinom rezultat=new Polinom();
			
			rezultat=pol1.derivare();//se deriveaza primul polinom
			
			mView.setResult(rezultat.toString());
			mView.setRest("-");
			
		}
		catch(BadInp exp)
		{
			mView.showError("Bad Input!");
		}
		
	}
}

class IListener implements ActionListener{
	
	public void actionPerformed(ActionEvent e) {
	

		try
		{
			
			Polinom pol1=Control.regexPoly(mView.getPoli1());
			Polinom rezultat=new Polinom();
			
			rezultat=pol1.integrare();//se integreaza primul polinom
			
			mView.setResult(rezultat.toString());
			mView.setRest("-");
			
		}
		catch(BadInp exp)
		{
			mView.showError("Bad Input!");
		}
		
		
	}
}


}
	





