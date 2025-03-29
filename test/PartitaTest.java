package diadiaTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;

public class PartitaTest {


	Partita p = new Partita();
	Stanza s = new Stanza("Stanza");
	Labirinto labirinto = new Labirinto();
	@Test
	public void testGetStanzaFinale() {
		assertEquals("Biblioteca", labirinto.getStanzaFinale().getNome());
	}

	@Test
	public void testSetStanzaCorrente() {
		p.setStanzaCorrente(s);
		assertEquals(s, p.getStanzaCorrente());
	}

	@Test
	public void testIsFinita() {
		
		assertFalse(p.vinta());
	}

	
}
