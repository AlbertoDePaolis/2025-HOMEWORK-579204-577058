package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccata extends StanzaProtected {
	
	private String nomeAtterezzoChiave;
	private String direzioneBloccata;
	private Partita partita;
	
	
	public StanzaBloccata(String nome,String direzioneBloccata, String nomeAtterezzoChiave) {
		super(nome);
		// TODO Auto-generated constructor stub
		
        this.nomeAtterezzoChiave=nomeAtterezzoChiave ;
        this.direzioneBloccata= direzioneBloccata;
	}

	
	
	public void impostaStanzaAdiacente(String direzione, Stanza stanza) {
        boolean aggiornato = false;
    	for(int i=0; i<this.direzioni.length; i++)
        	if (direzione.equals(this.direzioni[i])) {
        		this.stanzeAdiacenti[i] = stanza;
        		aggiornato = true;
        	}
    	if (!aggiornato)
    		if (this.numeroStanzeAdiacenti < NUMERO_MASSIMO_DIREZIONI) {
    			this.direzioni[numeroStanzeAdiacenti] = direzione;
    			this.stanzeAdiacenti[numeroStanzeAdiacenti] = stanza;
    		    this.numeroStanzeAdiacenti++;
    		}
    }

    /**
     * Restituisce la stanza adiacente nella direzione specificata
     * @param direzione
     */
	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		Stanza stanza = null;
		for(int j=0; j<this.numeroStanzeAdiacenti; j++) {
        	if (this.direzioni[j].equals(direzione)) {
        		if(direzione!=direzioneBloccata || this.hasAttrezzo(nomeAtterezzoChiave) ) {
        		
        			stanza = this.stanzeAdiacenti[j];
        	        return stanza;
        		}
        		
        		
        	}
		}
		return partita.getStanzaCorrente();
        
	}

    /**
     * Restituisce la nome della stanza.
     * @return il nome della stanza
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Restituisce la descrizione della stanza.
     * @return la descrizione della stanza
     */
    public String getDescrizione() {
    	
        return this.toString();
    	
    }

    /**
     * Restituisce la collezione di attrezzi presenti nella stanza.
     * @return la collezione di attrezzi nella stanza.
     */
    public Attrezzo[] getAttrezzi() {
        return this.attrezzi;
    }

    /**
     * Mette un attrezzo nella stanza.
     * @param attrezzo l'attrezzo da mettere nella stanza.
     * @return true se riesce ad aggiungere l'attrezzo, false atrimenti.
     */
    public boolean addAttrezzo(Attrezzo attrezzo) {
        if (this.numeroAttrezzi < NUMERO_MASSIMO_ATTREZZI) {
        	this.attrezzi[numeroAttrezzi] = attrezzo;
        	this.numeroAttrezzi++;
        	return true;
        }
        else {
        	return false;
        }
    }

   /**
	* Restituisce una rappresentazione stringa di questa stanza,
	* stampadone la descrizione, le uscite e gli eventuali attrezzi contenuti
	* @return la rappresentazione stringa
	*/
    public String toString() {
    	StringBuilder risultato = new StringBuilder();
    	risultato.append(this.nome);
    	risultato.append("\nUscite: ");
    	for (String direzione : this.direzioni)
    		if (direzione!=null && direzione!=direzioneBloccata)
    			risultato.append(" " + direzione);
    		else
    	        risultato.append("bloccata ti serve una chiave " + direzioneBloccata);
    	risultato.append("\nAttrezzi nella stanza: ");
    	for (Attrezzo attrezzo : this.attrezzi) {
    		if(attrezzo!=null)
    		risultato.append(attrezzo.toString()+" ");
    	}
    	return risultato.toString();
    }

    /**
	* Controlla se un attrezzo esiste nella stanza (uguaglianza sul nome).
	* @return true se l'attrezzo esiste nella stanza, false altrimenti.
	*/
	public boolean hasAttrezzo(String nomeAttrezzo) {
		boolean trovato;
		trovato = false;
		for (Attrezzo attrezzo : this.attrezzi) {
			if (attrezzo.getNome().equals(nomeAttrezzo))
				trovato = true;
		}
		return trovato;
	}

	/**
     * Restituisce l'attrezzo nomeAttrezzo se presente nella stanza.
	 * @param nomeAttrezzo
	 * @return l'attrezzo presente nella stanza.
     * 		   null se l'attrezzo non e' presente.
	 */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo attrezzoCercato;
		attrezzoCercato = null;
		for (Attrezzo attrezzo : this.attrezzi) {
			if(attrezzo!=null)
			if (attrezzo.getNome().equals(nomeAttrezzo))
				attrezzoCercato = attrezzo;
		}
		return attrezzoCercato;	
	}

	/**
	 * Rimuove un attrezzo dalla stanza (ricerca in base al nome).
	 * @param nomeAttrezzo
	 * @return true se l'attrezzo e' stato rimosso, false altrimenti
	 */
	public boolean removeAttrezzo(Attrezzo attrezzo) {
	    // Cerchiamo l'attrezzo nell'array
	    for (int i = 0; i < numeroAttrezzi; i++) {
	        if (this.attrezzi[i].equals(attrezzo)) { // Se troviamo l'attrezzo
	            // Spostiamo tutti gli attrezzi successivi di una posizione a sinistra
	            for (int j = i; j < numeroAttrezzi - 1; j++) {
	                this.attrezzi[j] = this.attrezzi[j + 1];
	            }
	            
	            this.attrezzi[numeroAttrezzi - 1] = null;
	            // Riduciamo il numero di attrezzi
	            numeroAttrezzi--;
	            return true;
	        }
	    }
	    // Se non troviamo l'attrezzo
	    return false;
	}


	public String[] getDirezioni() {
		String[] direzioni = new String[this.numeroStanzeAdiacenti];
	    for(int i=0; i<this.numeroStanzeAdiacenti; i++)
	    	direzioni[i] = this.direzioni[i];
	    return direzioni;
    }

}
