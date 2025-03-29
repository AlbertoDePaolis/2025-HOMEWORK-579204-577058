package diadiaTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class BorsaTest {

	Borsa b = new Borsa();
	Attrezzo a1;
	Attrezzo a2;
	
	@Before
	public void setUp() {
		a1 = new Attrezzo("chiave", 1);
		a2 = new Attrezzo("martello", 3);
		b.addAttrezzo(a1);
		b.addAttrezzo(a2);
	}
	
		
	
	
	@Test
	public void testHasAttrezzo() {
		assertTrue(b.hasAttrezzo("chiave"));
		
	}
	
	@Test
	public void testremoveAttrezzo() {
		assertEquals(a1,b.removeAttrezzo("chiave"));
		
	}
	
	@Test
	public void testgetPeso() {
		assertEquals(1,a1.getPeso());
	}
}
