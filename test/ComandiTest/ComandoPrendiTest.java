package ComandiTest;

import static org.junit.Assert.assertFalse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.didia.comandi.Comando;
import it.uniroma3.didia.comandi.ComandoPrendi;

public class ComandoPrendiTest {
	private Partita partita;
	private Attrezzo attrezzo;
	private Attrezzo attrezzoPesante;
	private Attrezzo attrezzoNull;
	private Comando comando;
	private IO io;
	
	@Before
	public void setUp() throws Exception {
		partita = new Partita();
		attrezzo = new Attrezzo("martello", 2);
		attrezzoPesante = new Attrezzo("incudine", 11);
		attrezzoNull = null;
		comando = new ComandoPrendi();
		io = new IOConsole();
		comando.setIO(io);
	}


	@After
	public void tearDown() throws Exception {
	}
	
	public boolean attrezzoPresente(String s) {
		Attrezzo[] array = partita.getStanzaCorrente().getAttrezzi();
		for(Attrezzo a : array) {
			if(a != null && s.equals(a.getNome()))
					return true;
		}
		return false;
	}
	
	@Test
	public void testAttrezzoPreso() {
		partita.getStanzaCorrente().addAttrezzo(attrezzo);
		comando.setParametro("martello");
		comando.esegui(partita);
		assertFalse(attrezzoPresente("martello"));
	}
}
