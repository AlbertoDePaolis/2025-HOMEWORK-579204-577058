package GiocatoreTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import it.uniroma3.diadia.giocatore.Giocatore;

public class GiocatoreTest {

	
	Giocatore g = new Giocatore();
	
	@Test
	public void testgetCfu() {
		assertEquals(20, g.getCfu());
	}
	
	@Test
	public void testsetCfu() {
		g.setCfu(5);
		assertEquals(5, g.getCfu());
	}
}
