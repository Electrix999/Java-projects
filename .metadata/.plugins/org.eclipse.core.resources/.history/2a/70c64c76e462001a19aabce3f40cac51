import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorTest {
	
	private static Polinom polinom1;
	private static Polinom polinom2;


	@BeforeClass
    // This annotation will ensure that the setup method is run once, before running all tests
    public static void setup() {
        polinom1 = new Polinom();
        polinom1.adauga(new Monom(4,3));
        polinom1.adauga(new Monom(2,2));
        polinom2=new Polinom();
		polinom2.adauga(new Monom(2,3));
    }
	
	@Test
	public void addTest() {
		Polinom rez=new Polinom();
		rez=polinom1.adunare(polinom2);
		Polinom pol=new Polinom();
		pol.adauga(new Monom(6,3));
		pol.adauga(new Monom(2,2));
		assertEquals(1,rez.equals(pol));
		
	}
	@Test
	public void subTest() {
		Polinom rez=new Polinom();
		rez=polinom1.scadere(polinom2);
		Polinom pol=new Polinom();
		pol.adauga(new Monom(2,3));
		pol.adauga(new Monom(2,2));
		assertEquals(1,rez.equals(pol));
		
	}
	
	@Test
	public void mulTest() {
		Polinom rez=new Polinom();
		rez=polinom1.inmultire(polinom2);
		Polinom pol=new Polinom();
		pol.adauga(new Monom(8,6));
		pol.adauga(new Monom(4,5));
		assertEquals(1,rez.equals(pol));
	
	}
	
	@Test
	public void divTest() {
		Polinom rez=new Polinom();
		rez=polinom1.impartire(polinom2);
		Polinom pol=new Polinom();
		pol.adauga(new Monom(2,0));
		pol.adauga(new Monom(1,-1));
		assertEquals(1,rez.equals(pol));
		
	}
	
	@Test
	public void derivareTest() {
		Polinom rez=new Polinom();
		rez=polinom1.derivare();
		Polinom pol=new Polinom();
		pol.adauga(new Monom(12,2));
		pol.adauga(new Monom(4,1));
		assertEquals(1,rez.equals(pol));
	}
		
		@Test
		public void integrareTest() {
			Polinom rez=new Polinom();
			Polinom pol2=new Polinom();
			pol2.adauga(new Monom(4,3));
			rez=pol2.integrare();
			Polinom pol=new Polinom();
			pol.adauga(new Monom(1,4));
			
			assertEquals(1,rez.equals(pol));
		
	}

}
