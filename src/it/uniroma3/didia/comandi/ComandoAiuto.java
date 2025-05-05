package it.uniroma3.didia.comandi;

import it.uniroma3.diadia.DiaDia;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

public class ComandoAiuto implements Comando {

	 private  IO io;
	 private final static String NOME = "aiuto";
	
	@Override
	public void esegui(Partita partita) {
		// TODO Auto-generated method stub
		for(int i=0; i< partita.elencoComandi.length; i++) 
			io.mostraMessaggio(partita.elencoComandi[i]+" ");
		System.out.println();
	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub
		
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
