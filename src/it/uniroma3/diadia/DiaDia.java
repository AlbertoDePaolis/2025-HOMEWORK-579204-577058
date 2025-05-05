package it.uniroma3.diadia;


import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Giocatore;
import it.uniroma3.didia.comandi.Comando;
import it.uniroma3.didia.comandi.FabbricaDiComandi;
import it.uniroma3.didia.comandi.FabbricaDiComandiFisarmonica;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {

	public static final String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";
	
	
	private Partita partita;
    private  IO console;
    private FabbricaDiComandi fabbrica;
    
    
	public DiaDia(IO io) {
		this.partita = new Partita();
		
		
	
	
		this.console = io;
		this.fabbrica= new FabbricaDiComandiFisarmonica(io);
	}

	public void gioca() {
		String istruzione; 
		

     console.mostraMessaggio(MESSAGGIO_BENVENUTO);
			
		do		
			istruzione = console.leggiRiga();
		while (!processaIstruzione(istruzione));
		
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		
		
		Comando comandoDaEseguire = fabbrica.costruisciComando(istruzione);
		
		comandoDaEseguire.esegui(this.partita);
		
		if (this.partita.vinta())

		System.out.println("Hai vinto!");
		if (!this.partita.giocatoreIsVivo())

		System.out.println("Hai esaurito i CFU...");

		return this.partita.isFinita();
		}

	

	public static void main(String[] argc) {
		IO io = new IOConsole();
		DiaDia gioco = new DiaDia(io);
		gioco.gioca();
		
		
	}



	
}