package it.uniroma3.diadia;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */

public class Partita {

	public String[] elencoComandi = {"vai", "aiuto", "fine","prendi","posa","guarda"};

	private Giocatore giocatore;
	private Labirinto labirinto;
	private boolean finita;
	
	private Stanza stanzaCorrente;
	

	
	public Partita(){
		this.labirinto = new Labirinto();
		this.labirinto.creaStanze();
		this.stanzaCorrente= labirinto.getStanzaIniziale();
		this.finita = false;
		this.giocatore = new Giocatore();
	}

    /**
     * Crea tutte le stanze e le porte di collegamento
     */
	public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
	}

	
	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return this.getStanzaCorrente().equals(this.labirinto.getStanzaFinale());
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return finita || vinta() || (this.giocatore.getCfu() == 0);
	}
	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaCorrente = stanzaCorrente;
	}

	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}

	public boolean giocatoreIsVivo() {
		// TODO Auto-generated method stub
		
		return this.giocatore.getCfu() > 0;
	}

	public Giocatore getGiocatore() {
		return giocatore;
	}

	public void setGiocatore(Giocatore giocatore) {
		this.giocatore = giocatore;
	}
}
