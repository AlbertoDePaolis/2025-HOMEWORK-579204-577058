package it.uniroma3.didia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Giocatore;

public class ComandoPosa implements Comando {
	
	private  IO io;
	private String nomeAttrezzo;
	private final static String NOME = "posa";
	
	
   

@Override
public void esegui(Partita partita) {
	// TODO Auto-generated method stub
	Attrezzo a = partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo);
	partita.getStanzaCorrente().removeAttrezzo(a);
	partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
	
	io.mostraMessaggio("hai posato: "+nomeAttrezzo);
}

@Override
public void setParametro(String parametro) {
	// TODO Auto-generated method stub
	this.nomeAttrezzo = parametro;
}

@Override
public String getNome() {
	// TODO Auto-generated method stub
	return NOME;
}

@Override
public String getParametro() {
	// TODO Auto-generated method stub
	return this.nomeAttrezzo;
}

@Override
public void setIO(IO io) {
	// TODO Auto-generated method stub
	this.io=io;
}
	
}
