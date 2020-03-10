
import java.math.BigInteger;
import java.util.*;

public class Model {
	private String m_rezultat;
	static final String INITIAL_VALUE="-";
	
	public Model()
	{
		reset();
	}
	
	public void reset()
	{
		m_rezultat=INITIAL_VALUE;
	}
	
	public void setValue(String val)
	{
		m_rezultat=val;
	}

}
