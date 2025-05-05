package it.uniroma3.didia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

public class ComandoVai implements Comando{
    
	
	private Giocatore giocatore;
    private  IO io;
	private String direzione;
	private final static String NOME = "vai";
	
    


	@Override
	public void esegui(Partita partita) {
		// TODO Auto-generated method stub
		if(direzione==null)
			io.mostraMessaggio("Dove vuoi andare ?");
		Stanza prossimaStanza = null;
		prossimaStanza = partita.getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			io.mostraMessaggio("Direzione inesistente");
		else {
			partita.setStanzaCorrente(prossimaStanza);
			int cfu = partita.getGiocatore().getCfu();
			partita.getGiocatore().setCfu(cfu--);
		}
		io.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
	}


	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub
		this.direzione = parametro;
	}


	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return NOME;
	}


	@Override
	public String getParametro() {
		// TODO Auto-generated method stub
		return this.direzione;
	}


	@Override
	public void setIO(IO io) {
		// TODO Auto-generated method stub
		this.io=io;
	}
	
}
