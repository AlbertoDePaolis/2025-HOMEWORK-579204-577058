package diadiaTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import it.uniroma3.diadia.DiaDia;
import it.uniroma3.diadia.IOsimulator;

public class SimulatorTest {

	public static IOsimulator creaSimulazionePartitaEGioca(String... comandiDaLeggere) {
		IOsimulator io = new IOsimulator(comandiDaLeggere);
		new DiaDia(io).gioca();
		return io;
	}
	
	@Test
	public void testPartitaConComandoVai() {
		String[] righeDaLeggere = {"vai nord", "fine"};
		IOsimulator io = creaSimulazionePartitaEGioca(righeDaLeggere);
		assertTrue(io.hasNextMessaggio());
		assertEquals(DiaDia.MESSAGGIO_BENVENUTO, io.nextMessaggio());
		assertTrue(io.hasNextMessaggio());
		assertEquals("Biblioteca", io.nextMessaggio());
		assertTrue(io.hasNextMessaggio());
		assertEquals("Hai vinto!", io.nextMessaggio());

	}
}
