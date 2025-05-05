package it.uniroma3.didia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

public class ComandoGuarda implements Comando {

	 private  IO io;
	 private final static String NOME = "guarda";
	
     public ComandoGuarda() {
		
	}
	@Override
	public void esegui(Partita partita) {
		// TODO Auto-generated method stub
		io.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
	}


	@Override
	public void setParametro(String parametro) {
	}
	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return NOME;
	}
	@Override
	public String getParametro() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setIO(IO io) {
		// TODO Auto-generated method stub
		this.io=io;
	}
	
}
