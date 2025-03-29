package diadiaTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;

public class LabirintoTest {
   
	Labirinto l;
	Stanza b;
	Stanza DS1;
    Partita p;
	@Before
	public void setUp() {
		l = new Labirinto();
		l.creaStanze();
		b = new Stanza("Biblioteca");
		DS1 = new Stanza("DS1");
		p = new Partita();
	}


	@Test
	public void testGetStanzaVincente() {
		assertEquals("Biblioteca", l.getStanzaFinale().getNome());
	}


	@Test
	public void testSetStanzaCorrente() {
		p.setStanzaCorrente(b);
		assertEquals(b, p.getStanzaCorrente());
	}

	@Test
	public void testGetStanzaCorrente() {
		assertNotEquals("DS1", l.getStanzaFinale().getNome());
	}

}
